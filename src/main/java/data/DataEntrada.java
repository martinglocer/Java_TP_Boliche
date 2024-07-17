
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

import data.DataFiesta_lugar;
import data.DataFiesta;
import data.DataLugar;
import data.DataAsistente;

public class DataEntrada {

	public LinkedList<Entrada> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Entrada> ents = new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select ent.identrada, asis.idasistente \r\n"
					+ "  , asis.tipo_doc, asis.nro_doc, asis.nombre, asis.apellido\r\n"
					+ "  , f.idfiesta, f.nombre_fiesta\r\n"
					+ "  , l.idlugar, l.nombre_lugar, l.direccion, l.ciudad\r\n"
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
					+ "  on ent.idasistente = asis.idasistente \r\n"
					+ "order by ent.identrada, fl.fecha_evento asc, fl.hora_evento asc;");
					
			if(rs!=null) {
				while(rs.next()) {
					Entrada ent = new Entrada();
					ent.setIdentrada(rs.getInt("ent.identrada"));
					ent.setFecha_compra(rs.getObject("ent.fecha_compra", LocalDate.class));
					ent.setHora_compra(rs.getObject("ent.hora_compra", LocalTime.class));
					Asistente asis = new Asistente();
					asis.setIdasistente(rs.getInt("asis.idasistente"));
					asis.setTipo_doc(rs.getString("asis.tipo_doc"));
					asis.setNro_doc(rs.getInt("asis.nro_doc"));
					asis.setNombre(rs.getString("asis.nombre"));
					asis.setApellido(rs.getString("asis.apellido"));
					ent.setAsistente(asis);
					Fiesta f = new Fiesta();
					f.setIdfiesta(rs.getInt("f.idfiesta"));
					f.setNombre_fiesta(rs.getString("f.nombre_fiesta"));
					Lugar l = new Lugar();
					l.setIdlugar(rs.getInt("l.idlugar"));
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
		
		Asistente asis = en.getAsistente();
		Fiesta_lugar fl = en.getFiesta_lugar();
		Fiesta f = fl.getFiesta();
		Lugar l = fl.getLugar();
		
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
							"insert into Entrada(idasistente, idfiesta, idlugar, fecha_evento, hora_evento, fecha_compra, hora_compra)\r\n" 
						+ "values(?,?,?,?,?,?,?)"
						,PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, asis.getIdasistente());
			stmt.setInt(2, f.getIdfiesta());
			stmt.setInt(3, l.getIdlugar());
			stmt.setObject(4, fl.getFecha_fiesta());
			stmt.setObject(5, fl.getHora_fiesta());
			stmt.setObject(6, en.getFecha_compra());
			stmt.setObject(7, en.getHora_compra());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			
			if (keyResultSet!= null && keyResultSet.next()) {
				en.setIdentrada(keyResultSet.getInt(1));
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
	
	
	public Entrada getById(Entrada en) {
		
		Entrada ent=null;
		DataFiesta df = new DataFiesta();
		DataLugar dl = new DataLugar();
		DataAsistente da = new DataAsistente();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select e.identrada, a.tipo_doc, a.nro_doc, e.idfiesta, e.idlugar, e.fecha_evento, e.hora_evento, e.fecha_compra, e.hora_compra\r\n"
					+ "from entrada e \r\n"
					+ "inner join asistente a \r\n"
					+ "		on a.idasistente = e.idasistente \r\n"
					+ "where identrada = ?");
			
			stmt.setInt(1, en.getIdentrada());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				ent=new Entrada();
				ent.setIdentrada(rs.getInt("e.identrada"));
				
				Asistente asis = new Asistente();
				asis.setTipo_doc(rs.getString("a.tipo_doc"));
				asis.setNro_doc(rs.getInt("a.nro_doc"));
				Asistente a = da.getByDocumento(asis);
				
				Fiesta f = df.getById(rs.getInt("e.idfiesta"));
				
				Lugar l = dl.getById(rs.getInt("e.idlugar"));
				
				Fiesta_lugar fiesta_lug = new Fiesta_lugar();
				fiesta_lug.setFiesta(f);
				fiesta_lug.setLugar(l);
				fiesta_lug.setFecha_fiesta(rs.getObject("fecha_evento", LocalDate.class));
				fiesta_lug.setHora_fiesta(rs.getObject("hora_evento", LocalTime.class));
				
				ent.setAsistente(a);
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
	
	
	
/*	public Entrada getOne(Entrada ent) {
		Entrada en = new Entrada();
		DataFiesta df = new DataFiesta();
		DataLugar dl = new DataLugar();
		DataAsistente da = new DataAsistente();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select identrada, tipo_doc, nro_doc, idfiesta, idlugar, fecha_evento, hora_evento, fecha_compra, hora_compra \r\n "
					+ "from entrada where identrada = ?"
					);
					
			stmt.setInt(1, ent.getIdentrada());
			rs=stmt.executeQuery();
			System.out.println("getOne de Entrada");
			if(rs!=null && rs.next()) {
				Asistente asis = new Asistente();
				asis.setTipo_doc(rs.getString("tipo_doc"));
				asis.setNro_doc(rs.getInt("nro_doc"));
				System.out.println(asis);
				//Asistente a = da.getByDocumento(asis);
				
				
				Fiesta f = df.getById(rs.getInt("idfiesta"));
				System.out.println(f);
				
				Lugar l = dl.getById(rs.getInt("idlugar"));
				System.out.println(l);
				
				Fiesta_lugar fiesta_lug = new Fiesta_lugar();
				fiesta_lug.setFiesta(f);
				fiesta_lug.setLugar(l);
				fiesta_lug.setFecha_fiesta(rs.getObject("fecha_evento", LocalDate.class));
				fiesta_lug.setHora_fiesta(rs.getObject("hora_evento", LocalTime.class));
				System.out.println(fiesta_lug);
				
				//en.setAsistente(a);
				en.setAsistente(asis);
				en.setIdentrada(rs.getInt("identrada"));
				en.setFecha_compra(rs.getObject("fecha_compra", LocalDate.class));
				en.setHora_compra(rs.getObject("hora_compra", LocalTime.class));
				en.setFiesta_lugar(fiesta_lug);
				System.out.println(en);
				
				
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
	}*/
	
	public void actualizarEntrada(Entrada ent, LocalDate fc_nueva, LocalTime hc_nueva) {
	    PreparedStatement stmt = null;
	    try {
	        stmt = DbConnector.getInstancia().getConn().
	                prepareStatement("update entrada set fecha_compra = ?, hora_compra = ? where identrada = ?");
	        
	    
			stmt.setObject(1, fc_nueva);
			stmt.setObject(2, hc_nueva);
	        stmt.setInt(3, ent.getIdentrada());
			
	        System.out.println(ent.getIdentrada());
	        System.out.println(fc_nueva);
	        System.out.println(hc_nueva);

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

