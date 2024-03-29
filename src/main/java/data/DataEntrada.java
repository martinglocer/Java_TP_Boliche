
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;

import entities.Entrada;
import entities.Fiesta;
import entities.Fiesta_lugar;
import entities.Lugar;
import entities.Asistente;

public class DataEntrada {

	public LinkedList<Entrada> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Entrada> ents = new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select ent.identrada\r\n"
					+ "  , asis.tipo_doc, asis.nro_doc, asis.nombre, asis.apellido\r\n"
					+ "  , f.nombre_fiesta\r\n"
					+ "  , l.nombre_lugar, l.direccion, l.ciudad\r\n"
					+ "  , fl.fecha_evento, fl.hora_evento\r\n"
					+ "  , ent.fecha_compra, ent.hora_compra\r\n"
					+ "from entrada ent \r\n"
					+ "left join fiesta_lugar fl \r\n"
					+ "  on ent.idfiesta = fl.idfiesta \r\n"
					+ "  and ent.idlugar = fl.idlugar \r\n"
					+ "  and ent.fecha_evento = fl.fecha_evento \r\n"
					+ "  and ent.hora_evento = fl.hora_evento\r\n"
					+ "left join fiesta f\r\n"
					+ "  on ent.idfiesta=f.idfiesta\r\n"
					+ "left join lugar l\r\n"
					+ "  on fl.idlugar=l.idlugar\r\n"
					+ "left join asistente asis \r\n"
					//+ "  #on ent.tipo_doc = asis.tipo_doc \r\n"
					+ "  on ent.nro_doc = asis.nro_doc \r\n"
					+ "order by ent.identrada, fl.fecha_evento asc, fl.hora_evento asc;");
					
			if(rs!=null) {
				while(rs.next()) {
					Entrada ent = new Entrada();
					ent.setIdentrada(rs.getInt("ent.identrada"));
					ent.setFecha_compra(rs.getObject("ent.fecha_compra", LocalDate.class));
					ent.setHora_compra(rs.getObject("ent.hora_compra", LocalTime.class));
					Asistente asis = new Asistente();
					asis.setTipo_doc(rs.getString("asis.tipo_doc"));
					asis.setNro_doc(rs.getInt("asis.nro_doc"));
					asis.setNombre(rs.getString("asis.nombre"));
					asis.setApellido(rs.getString("asis.apellido"));
					ent.setAsistente(asis);
					Fiesta f = new Fiesta();
					f.setNombre_fiesta(rs.getString("f.nombre_fiesta"));
					Lugar l = new Lugar();
					l.setNombre_lugar(rs.getString("l.nombre_lugar"));
					l.setDireccion(rs.getString("l.direccion"));
					l.setCiudad(rs.getString("l.ciudad"));
					Fiesta_lugar fl = new Fiesta_lugar();
					fl.setFecha_fiesta(rs.getObject("fl.fecha_evento", LocalDate.class));
					fl.setHora_fiesta(rs.getObject("fl.hora_evento", LocalTime.class));
					fl.setFiesta(f);
					fl.setLugar(l);
					ent.setFiesta_lugar(fl);
		
					System.out.println("IdEntrada: " + ent.getIdentrada() + ", Tipo_doc: " + asis.getTipo_doc() + ", Nro_doc: " + asis.getNro_doc());
					ents.add(ent);
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
		
		
		return ents;
	}
	
	public void add(Entrada en) {
		
		
		Fiesta_lugar fl = en.getFiesta_lugar();
		Fiesta f = fl.getFiesta();
		Lugar l = fl.getLugar();
		Asistente a = en.getAsistente();
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
							"insert into Entrada(tipo_doc, nro_doc, idfiesta, idlugar, fecha_evento, hora_evento, fecha_compra, hora_compra)\r\n" 
						+ "values(?,?,?,?,?,?,?,?)"
						,PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, a.getTipo_doc());
			stmt.setInt(2, a.getNro_doc());
			stmt.setInt(3, f.getIdfiesta());
			stmt.setInt(4, l.getIdlugar());
			stmt.setObject(5, fl.getFecha_fiesta());
			stmt.setObject(6, fl.getHora_fiesta());
			stmt.setObject(7, en.getFecha_compra());
			stmt.setObject(8, en.getHora_compra());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			
			if (keyResultSet!= null && keyResultSet.next()) {
				l.setIdlugar(keyResultSet.getInt(1));
			} 

			
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
	
	
	public Entrada getById(int identrada) {
		Entrada ent=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select identrada, tipo_doc, nro_doc, idfiesta, idlugar, fecha_evento, hora_evento, fecha_compra, hora_compra\r\n"
					+ "from entrada where identrada = ?"
					);
			stmt.setInt(1, identrada);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				ent=new Entrada();
				ent.setIdentrada(rs.getInt("identrada"));
				
				Asistente asis = new Asistente();
				asis.setTipo_doc(rs.getString("tipo_doc"));
				asis.setNro_doc(rs.getInt("nro_doc"));
				
				Fiesta f = new Fiesta();
				f.setIdfiesta(rs.getInt("idfiesta"));
				
				Lugar l = new Lugar();
				l.setIdlugar(rs.getInt("idlugar"));
				
				Fiesta_lugar fiesta_lug = new Fiesta_lugar();
				fiesta_lug.setFiesta(f);
				fiesta_lug.setLugar(l);
				fiesta_lug.setFecha_fiesta(rs.getObject("fecha_evento", LocalDate.class));
				fiesta_lug.setHora_fiesta(rs.getObject("hora_evento", LocalTime.class));
				
				ent.setFecha_compra(rs.getObject("fecha_compra", LocalDate.class));
				ent.setHora_compra(rs.getObject("hora_compra", LocalTime.class));
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
		
		System.out.println(ent);
		
		return ent;
	}
	
	
	
	public Entrada getOne(Entrada ent) {
		Entrada en = new Entrada();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select identrada, tipo_doc, nro_doc, idfiesta, idlugar, fecha_evento, hora_evento, fecha_compra, hora_compra \r\n "
					+ "from entrada where identrada = ?"
					);
					
			stmt.setInt(1, ent.getIdentrada());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				Asistente asis = new Asistente();
				asis.setTipo_doc(rs.getString("tipo_doc"));
				asis.setNro_doc(rs.getInt("nro_doc"));
				
				Fiesta f = new Fiesta();
				f.setIdfiesta(rs.getInt("idfiesta"));
				
				Lugar l = new Lugar();
				l.setIdlugar(rs.getInt("idlugar"));
				
				Fiesta_lugar fiesta_lug = new Fiesta_lugar();
				fiesta_lug.setFiesta(f);
				fiesta_lug.setLugar(l);
				fiesta_lug.setFecha_fiesta(rs.getObject("fecha_evento", LocalDate.class));
				fiesta_lug.setHora_fiesta(rs.getObject("hora_evento", LocalTime.class));
				
				System.out.println(fiesta_lug);
				
				en.setIdentrada(rs.getInt("identrada"));
				en.setFecha_compra(rs.getObject("fecha_compra", LocalDate.class));
				en.setHora_compra(rs.getObject("hora_compra", LocalTime.class));
				
				
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
		
		return en;
	}
	
	public void actualizarEntrada(Fiesta_lugar fl, LocalDate fe_nueva, LocalTime ho_nueva) {
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


	public void deleteByID(Entrada en) {
        PreparedStatement stmt = null;

        try {
        stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from entrada where identrada=? ");

        
		stmt.setInt(1, en.getIdentrada());      
        stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Entrada inexistente");

        } finally {
            try {
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	
}

