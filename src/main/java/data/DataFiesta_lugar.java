package data;

import java.sql.Connection;
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
            rs= stmt.executeQuery("select fl.fecha_evento, fl.hora_evento, fl.precio, f.idfiesta, f.nombre_fiesta, f.descripcion, l.idlugar, l.nombre_lugar, l.direccion, l.capacidad, l.ciudad \r\n"
                    + "from fiesta_lugar fl \r\n"
                    + "inner join fiesta f \r\n"
                    + "on f.idfiesta = fl.idfiesta \r\n"
                    + "inner join lugar l \r\n"
                    + "on l.idlugar = fl.idlugar  \r\n"
                    + "order by fl.fecha_evento asc, fl.hora_evento asc;");
                    
            if(rs!=null) {
                while(rs.next()) {
                    Lugar l = new Lugar();
                    l.setIdlugar(rs.getInt("l.idlugar"));
                    l.setNombre_lugar(rs.getString("l.nombre_lugar"));
                    l.setDireccion(rs.getString("l.direccion"));
                    l.setCapacidad(rs.getInt("l.capacidad"));
                    l.setCiudad(rs.getString("l.ciudad"));
                    Fiesta f = new Fiesta();
                    f.setIdfiesta(rs.getInt("f.idfiesta"));
                    f.setNombre_fiesta(rs.getString("f.nombre_fiesta"));
                    f.setDescripcion(rs.getString("f.descripcion"));
                    Fiesta_lugar fl=new Fiesta_lugar();
                    fl.setFecha_fiesta(rs.getObject("fl.fecha_evento", LocalDate.class));
                    fl.setHora_fiesta(rs.getObject("fl.hora_evento", LocalTime.class));
                    fl.setPrecio(rs.getDouble("fl.precio"));
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
    
    public LinkedList<Fiesta_lugar> getDisponibles() {
        Statement stmt = null;
        ResultSet rs = null;
        LinkedList<Fiesta_lugar> fie_lug = new LinkedList<>();
        
        try {
            System.out.println("Trying to get connection...");
            Connection conn = DbConnector.getInstancia().getConn();
            if (conn != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to get connection.");
            }

            stmt = conn.createStatement();
            String sql = "select f.idfiesta, l.idlugar, fl.fecha_evento, fl.hora_evento, fl.precio, f.nombre_fiesta, " +
                         "l.nombre_lugar, l.direccion, l.ciudad, l.capacidad, count(e.identrada) entradas_vendidas " +
                         "from fiesta_lugar fl " +
                         "inner join fiesta f on f.idfiesta = fl.idfiesta " +
                         "inner join lugar l on l.idlugar = fl.idlugar " +
                         "left join entrada e on e.fecha_evento = fl.fecha_evento " +
                         "and e.hora_evento = fl.hora_evento " +
                         "and e.idlugar = fl.idlugar " +
                         "and e.idfiesta = fl.idfiesta " +
                         "where fl.fecha_evento >= current_timestamp() " +
                         "group by f.idfiesta, l.idlugar, fl.fecha_evento, fl.hora_evento, f.nombre_fiesta, l.nombre_lugar, l.direccion, l.ciudad, fl.precio " +
                         "having l.capacidad > entradas_vendidas " +
                         "order by fl.fecha_evento asc, fl.hora_evento asc;";
            System.out.println("Executing query: " + sql);
            rs = stmt.executeQuery(sql);
                    
            if (rs != null) {
                while (rs.next()) {
                    Lugar l = new Lugar();
                    l.setIdlugar(rs.getInt("l.idlugar"));
                    l.setNombre_lugar(rs.getString("l.nombre_lugar"));
                    l.setDireccion(rs.getString("l.direccion"));
                    l.setCiudad(rs.getString("l.ciudad"));
                    Fiesta f = new Fiesta();
                    f.setIdfiesta(rs.getInt("f.idfiesta"));
                    f.setNombre_fiesta(rs.getString("f.nombre_fiesta"));
                    Fiesta_lugar fl = new Fiesta_lugar();
                    fl.setFecha_fiesta(rs.getObject("fl.fecha_evento", LocalDate.class));
                    fl.setHora_fiesta(rs.getObject("fl.hora_evento", LocalTime.class));
                    fl.setPrecio(rs.getDouble("fl.precio"));
                    fl.setFiesta(f);
                    fl.setLugar(l);
                    
                    fie_lug.add(fl);
                }
                System.out.println("Fetched " + fie_lug.size() + " records.");
            } else {
                System.out.println("ResultSet is null.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (rs != null) { rs.close(); }
                if (stmt != null) { stmt.close(); }
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return fie_lug;
    }
    
    public Fiesta_lugar getByData(int idfiesta, int idlugar, LocalDate fecha_fiesta, LocalTime hora_fiesta) {
        Fiesta_lugar fl = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = DbConnector.getInstancia().getConn().prepareStatement(
                    "select fl.fecha_evento, fl.hora_evento, fl.precio, f.idfiesta, f.nombre_fiesta, f.descripcion, l.idlugar, l.nombre_lugar, l.direccion, l.capacidad, l.ciudad " +
                    "from fiesta_lugar fl " +
                    "inner join fiesta f on f.idfiesta = fl.idfiesta " +
                    "inner join lugar l on l.idlugar = fl.idlugar " +
                    "where fl.idfiesta = ? and fl.idlugar = ? and fl.fecha_evento = ? and fl.hora_evento = ?"
            );
            stmt.setInt(1, idfiesta);
            stmt.setInt(2, idlugar);
            stmt.setObject(3, fecha_fiesta);
            stmt.setObject(4, hora_fiesta);
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                fl = new Fiesta_lugar();

                Lugar l = new Lugar();
                l.setIdlugar(rs.getInt("l.idlugar"));
                l.setNombre_lugar(rs.getString("l.nombre_lugar"));
                l.setDireccion(rs.getString("l.direccion"));
                l.setCapacidad(rs.getInt("l.capacidad"));
                l.setCiudad(rs.getString("l.ciudad"));
                fl.setLugar(l);

                Fiesta f = new Fiesta();
                f.setIdfiesta(rs.getInt("f.idfiesta"));
                f.setNombre_fiesta(rs.getString("f.nombre_fiesta"));
                f.setDescripcion(rs.getString("f.descripcion"));
                fl.setFiesta(f);

                fl.setFecha_fiesta(rs.getObject("fl.fecha_evento", LocalDate.class));
                fl.setHora_fiesta(rs.getObject("fl.hora_evento", LocalTime.class));
                fl.setPrecio(rs.getDouble("fl.precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {rs.close();}
                if (stmt != null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fl;
    }
    
    public Fiesta_lugar getOne(Fiesta_lugar f_lug) {
		Fiesta_lugar fl = new Fiesta_lugar();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idfiesta, idlugar, fecha_evento, hora_evento, precio from fiesta_lugar where idfiesta = ? and idlugar = ? and fecha_evento = ? and hora_evento = ?"
					);
			
			Fiesta f = f_lug.getFiesta();
			Lugar l = f_lug.getLugar();
			
			System.out.println(f);
			System.out.println(l);
			
			stmt.setInt(1, f.getIdfiesta());
			stmt.setInt(2,  l.getIdlugar());
			stmt.setObject(3, f_lug.getFecha_fiesta());	
			stmt.setObject(4, f_lug.getHora_fiesta());	
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				/*fl= new Fiesta_lugar();*/
				Fiesta f2 = new Fiesta();
				Lugar l2 = new Lugar(); 
				
				f2.setIdfiesta(rs.getInt("idfiesta"));
				fl.setFiesta(f2);
				l2.setIdlugar(rs.getInt("idlugar"));
				fl.setLugar(l2);
				fl.setFecha_fiesta(rs.getObject("fecha_evento", LocalDate.class));
				fl.setHora_fiesta(rs.getObject("hora_evento", LocalTime.class));
				fl.setPrecio(rs.getDouble("precio"));
				
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
                            "insert into fiesta_lugar(idfiesta, idlugar, fecha_evento, hora_evento, precio) values(?,?,?,?,?)"
                            ,PreparedStatement.RETURN_GENERATED_KEYS);
            
            Fiesta f = fl.getFiesta();
            Lugar l = fl.getLugar();
            
            stmt.setInt(1, f.getIdfiesta());
            stmt.setInt(2, l.getIdlugar());
            stmt.setObject(3, fl.getFecha_fiesta());
            stmt.setObject(4, fl.getHora_fiesta());
            stmt.setDouble(5, fl.getPrecio());
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
    
    public void actualizarFiesta_lugar(Fiesta_lugar fl, LocalDate fe_nueva, LocalTime ho_nueva, double pre_nuevo) {
        PreparedStatement stmt = null;
        try {
            stmt = DbConnector.getInstancia().getConn().
                    prepareStatement("update fiesta_lugar set fecha_evento = ?, hora_evento = ?, precio = ? where idfiesta = ? and idlugar = ? and fecha_evento = ? and hora_evento = ?");
            
            Fiesta f = fl.getFiesta();
            Lugar l = fl.getLugar(); 
            
            stmt.setObject(1, fe_nueva);
            stmt.setObject(2, ho_nueva);
            stmt.setDouble(3, pre_nuevo);
            stmt.setInt(4, f.getIdfiesta());
            stmt.setInt(5, l.getIdlugar());
            stmt.setObject(6, fl.getFecha_fiesta());
            stmt.setObject(7, fl.getHora_fiesta());
            
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

    public String deleteByIDs(Fiesta_lugar delfl) {
        PreparedStatement stmt = null;
        String message = null;
        
        try {
            stmt = DbConnector.getInstancia().getConn().prepareStatement(
                "delete from fiesta_lugar where idfiesta=? and idlugar=? and fecha_evento=? and hora_evento=?"
            );
            
            Fiesta delf = delfl.getFiesta();
            Lugar dell = delfl.getLugar();
            
            stmt.setInt(1, delf.getIdfiesta());
            stmt.setInt(2, dell.getIdlugar());
            stmt.setObject(3, delfl.getFecha_fiesta());
            stmt.setObject(4, delfl.getHora_fiesta());
            
            stmt.executeUpdate();
            message = "Evento eliminado exitosamente.";
        } catch (SQLException e) {
        	
        	message = "No se puede eliminar un evento que tiene entradas vendidas.";
            e.printStackTrace();
            
            System.out.println(message);
            //throw e;
        } finally {
            try {
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return message;
    }
}