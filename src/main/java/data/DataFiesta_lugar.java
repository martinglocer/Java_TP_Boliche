package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import entities.Fiesta_lugar;
import entities.Lugar;
import entities.Fiesta;

public class DataFiesta_lugar {

	public LinkedList<Fiesta_lugar> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Fiesta_lugar> fie_lug= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select fl.fecha_evento, fl.hora_evento, f.nombre_fiesta, l.nombre_lugar, l.direccion, l.ciudad \r\n"
					+ "from fiesta_lugar fl \r\n"
					+ "inner join fiesta f \r\n"
					+ "on f.idfiesta = fl.idfiesta \r\n"
					+ "inner join lugar l \r\n"
					+ "on l.idlugar = fl.idlugar  \r\n"
					+ "order by fl.fecha_evento asc, fl.hora_evento asc;");
					
			if(rs!=null) {
				while(rs.next()) {
					Lugar l = new Lugar();
					l.setNombre_lugar(rs.getString("l.nombre_lugar"));
					l.setDireccion(rs.getString("l.direccion"));
					l.setCiudad(rs.getString("l.ciudad"));
					Fiesta f = new Fiesta();
					f.setNombre_fiesta(rs.getString("f.nombre_fiesta"));
					Fiesta_lugar fl=new Fiesta_lugar();
					fl.setFecha_fiesta(rs.getObject("fl.fecha_evento", LocalDate.class));
					fl.setHora_fiesta(rs.getObject("fl.hora_evento", LocalTime.class));
					fl.setFiesta(f);
					fl.setLugar(l);
					
					fie_lug.add(fl);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return fie_lug;
	}
	
	/*public Fiesta_lugar getByData(int idfiesta, int idlugar, LocalDateTime fecha_hora) {
		Fiesta_lugar fl=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idfiesta, idlugar, fecha_hora_fiesta from fiesta_lugar where idfiesta = ? and idlugar = ? and fecha_hora_fiesta = ?"
					);
			stmt.setInt(1, idfiesta);
			stmt.setInt(2,  idlugar);
			stmt.setObject(3, fecha_hora);	
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				fl=new Fiesta_lugar(0, 0, null);
				fl.setIdfiesta(rs.getInt("idfiesta"));
				fl.setIdlugar(rs.getInt("idlugar"));
				fl.setFecha_hora_fiesta(rs.getTimestamp("fecha_hora_fiesta").toLocalDateTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fl;
	}*/
	
	
	public Fiesta_lugar getOne(Fiesta_lugar f_lug) {
		Fiesta_lugar fl=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idfiesta, idlugar, fecha_evento, hora_evento from fiesta_lugar where idfiesta = ? and idlugar = ? and fecha_evento = ? and hora_evento = ?"
					);
			
			Fiesta f = f_lug.getFiesta();
			Lugar l = f_lug.getLugar();
			
			stmt.setInt(1, f.getIdfiesta());
			stmt.setInt(2,  l.getIdlugar());
			stmt.setObject(3, f_lug.getFecha_fiesta());	
			stmt.setObject(4, f_lug.getHora_fiesta());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				fl= new Fiesta_lugar();
				Fiesta f2 = new Fiesta();
				Lugar l2 = new Lugar(); 
				
				f2.setIdfiesta(rs.getInt("idfiesta"));
				fl.setFiesta(f2);
				l2.setIdlugar(rs.getInt("idlugar"));
				fl.setLugar(l2);
				fl.setFecha_fiesta(rs.getObject("fecha_evento", LocalDate.class));
				fl.setHora_fiesta(rs.getObject("hora_evento", LocalTime.class));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return fl;
	}
	
	
	public void add(Fiesta_lugar fl) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
							"insert into fiesta_lugar(idfiesta, idlugar, fecha_evento, hora_evento) values(?,?,?,?)"
							,PreparedStatement.RETURN_GENERATED_KEYS);
			
			Fiesta f = fl.getFiesta();
			Lugar l = fl.getLugar();
			
			stmt.setInt(1, f.getIdfiesta());
			stmt.setInt(2, l.getIdlugar());
			stmt.setObject(3, fl.getFecha_fiesta());
			stmt.setObject(4, fl.getHora_fiesta());
			stmt.executeUpdate();
		
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
    }
	
	public void actualizarFiesta_lugar(Fiesta_lugar fl, LocalDate fe_nueva, LocalTime ho_nueva) {
	    PreparedStatement stmt = null;
	    try {
	        stmt = DbConnector.getInstancia().getConn().
	                prepareStatement("update fiesta_lugar set fecha_evento = ?, hora_evento = ? where idfiesta = ? and idlugar = ? and fecha_evento = ? and hora_evento = ?");
	        
	        Fiesta f = fl.getFiesta();
			Lugar l = fl.getLugar(); 
	        
			stmt.setObject(1, fe_nueva);
			stmt.setObject(2, ho_nueva);
	        stmt.setInt(3, f.getIdfiesta());
	        stmt.setInt(4, l.getIdlugar());
	        stmt.setObject(5, fl.getFecha_fiesta());
			stmt.setObject(6, fl.getHora_fiesta());
			
	        System.out.println(f.getIdfiesta());
	        System.out.println(l.getIdlugar());
	        System.out.println(fl.getFecha_fiesta());
	        System.out.println(fl.getHora_fiesta());
	        System.out.println(fe_nueva);
	        System.out.println(ho_nueva);

	        stmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Se produjo un error, revise los datos ingresados");

	    } finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            DbConnector.getInstancia().releaseConn();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	/*public void deleteByIDs(Fiesta_lugar delfl) {
        PreparedStatement stmt = null;

        try {
        stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from fiesta_lugar where idfiesta=? and idlugar=? and fecha_hora_fiesta=?");

        stmt.setInt(1, delfl.getIdfiesta());
		stmt.setInt(2, delfl.getIdlugar());
		
		LocalDateTime fecha_hora_fiesta = delfl.getFecha_hora_fiesta();
        Timestamp timestamp = Timestamp.valueOf(fecha_hora_fiesta);

        stmt.setTimestamp(3, timestamp);
        
        stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fiesta_lugar inexistente");

        } finally {
            try {
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/
	
}
