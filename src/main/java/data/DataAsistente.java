package data;

import entities.*;
//import java.time.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class DataAsistente {
	
	public LinkedList<Asistente> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Asistente> asis= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select tipo_doc, nro_doc, nombre, apellido, email, fecha_nacimiento, celular, saldo, idrol, "
					+ "password  from asistente order by apellido");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Asistente a=new Asistente(null,0,null,null,null,null,null,0,null,0);
					a.setTipo_doc(rs.getString("tipo_doc"));
					a.setNro_doc(rs.getInt("nro_doc"));
					a.setNombre(rs.getString("nombre"));
					a.setApellido(rs.getString("apellido"));
					a.setEmail(rs.getString("email"));
					a.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
					a.setCelular(rs.getString("celular"));
					a.setSaldo(rs.getFloat("saldo"));
					a.setRol(rs.getInt("idrol"));
					a.setPassword(rs.getString("password"));
					
					asis.add(a);
				}
				System.out.println(asis.size());
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
		
		if (asis.isEmpty() == true) {
			System.out.println("Vacío");
		}
		
		return asis;
	}
	
	public Asistente getByUser(Asistente asi) {
		Asistente a=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select tipo_doc, nro_doc, nombre, apellido, email, fecha_nacimiento, celular, saldo, idrol, "
					+ "password  from asistente where email=? and password=?"
					);
			stmt.setString(1, asi.getEmail());
			stmt.setString(2, asi.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				a=new Asistente(null,0,null,null,null,null,null,0,null,0);
				a.setTipo_doc(rs.getString("tipo_doc"));
				a.setNro_doc(rs.getInt("nro_doc"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setEmail(rs.getString("email"));
				a.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
				a.setCelular(rs.getString("celular"));
				a.setSaldo(rs.getFloat("saldo"));
				a.setRol(rs.getInt("idrol"));
				a.setPassword(rs.getString("password"));
				//
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No funciona el Asistente getByUser(Asistente asi)");
			
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return a;
	}
	
	public Asistente getByEmail(Asistente asi) {
		Asistente a=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select tipo_doc, nro_doc, nombre, apellido, email, fecha_nacimiento, celular, saldo, idrol, "
					+ "password  from asistente where email=?"
					);
			stmt.setString(1, asi.getEmail());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				a=new Asistente(null,0,null,null,null,null,null,0,null,0);
				a.setTipo_doc(rs.getString("tipo_doc"));
				a.setNro_doc(rs.getInt("nro_doc"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setEmail(rs.getString("email"));
				a.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
				a.setCelular(rs.getString("celular"));
				a.setSaldo(rs.getFloat("saldo"));
				a.setRol(rs.getInt("idrol"));
				a.setPassword(rs.getString("password"));
				//
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No funciona el Asistente getByUser(Asistente asi)");
			
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return a;
	}
	
	public Asistente validateUser(Asistente asi) {
		Asistente a=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select nro_doc, email, apellido, email, fecha_nacimiento, celular, saldo, idrol, "
					+ "password  from asistente where nro_doc=? and password=?"
					);
			stmt.setInt(1, asi.getNro_doc());
			stmt.setString(2, asi.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				a=new Asistente(null,0,null,null,null,null,null,0,null,0);
				a.setTipo_doc(rs.getString("tipo_doc"));
				a.setNro_doc(rs.getInt("nro_doc"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setEmail(rs.getString("email"));
				a.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
				a.setCelular(rs.getString("celular"));
				a.setSaldo(rs.getFloat("saldo"));
				a.setRol(rs.getInt("idrol"));
				a.setPassword(rs.getString("password"));
				//
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("No funciona el Asistente getByUser(Asistente asi)");
			
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return a;
	}
	
	public Asistente getByDocumento(Asistente asi) {
		Asistente a=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		System.out.println("getByDocumento de Asistente");
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select tipo_doc, nro_doc, nombre, apellido, email, celular, fecha_nacimiento, saldo, password, idrol\r\n"
					+ "from asistente \r\n"
					+ "where tipo_doc=? and nro_doc=?"
					);
			stmt.setString(1, asi.getTipo_doc());
			stmt.setInt(2, asi.getNro_doc());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				
				a=new Asistente(null,0,null,null,null,null,null,0,null,0);
				a.setTipo_doc(rs.getString("tipo_doc"));
				a.setNro_doc(rs.getInt("nro_doc"));
				a.setNombre(rs.getString("nombre"));
				a.setApellido(rs.getString("apellido"));
				a.setEmail(rs.getString("email"));
				a.setCelular(rs.getString("celular"));
				a.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
				a.setSaldo(rs.getFloat("saldo"));
				a.setPassword(rs.getString("password"));
				a.setRol(rs.getInt("idrol"));
				
				/*
				a = new Asistente(
	                    rs.getString("tipo_doc"),
	                    rs.getInt("nro_doc"),
	                    rs.getString("nombre"),
	                    rs.getString("apellido"),
	                    rs.getString("email"),
	                    rs.getString("celular"),
	                    rs.getObject("fecha_nacimiento", LocalDate.class),
	                    rs.getFloat("saldo"),
	                    rs.getString("password"),
	                    rs.getInt("idrol")     
	            );
	            */
				System.out.println("Usuario encontrado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Usuario no encontrado");
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Usuario no encontrado");
			}
		}
		
		System.out.println(a);
		System.out.println("sale de getByDocumento, vuelve a getOne de Entrada");
		return a;
	}
	
	public void add(Asistente a) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into asistente(tipo_doc, nro_doc, nombre, apellido, email, fecha_nacimiento, celular, password, idrol, saldo)"
							+ " values(?,?,?,?,?,?,?,?,?,?)"
							);
			stmt.setString(1, a.getTipo_doc());
			stmt.setInt(2, a.getNro_doc());
			stmt.setString(3, a.getNombre());
			stmt.setString(4, a.getApellido());
			stmt.setString(5, a.getEmail());
			stmt.setObject(6, a.getFecha_nacimiento());
			stmt.setString(7, a.getCelular());
			stmt.setString(8, a.getPassword());
			stmt.setInt(9, a.getRol());
			stmt.setFloat(10, a.getSaldo());
			System.out.println("password es: "+a.getPassword());
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
	
	public void actualizarAsist(Asistente asi) {
        PreparedStatement stmt= null;
        try {stmt = DbConnector.getInstancia().getConn().prepareStatement(
            	    "UPDATE asistente SET nombre = ?, apellido = ?, email = ?, password = ?, celular = ?, saldo = ?, " +
            	    "fecha_nacimiento = ?, tipo_doc = ?, nro_doc = ?, idrol = ? WHERE tipo_doc = ? AND nro_doc = ?");
            
            stmt.setString(1, asi.getNombre());
			stmt.setString(2, asi.getApellido());
			stmt.setString(3, asi.getEmail());
			stmt.setString(4, asi.getPassword());
			stmt.setString(5, asi.getCelular());
			stmt.setFloat(6, asi.getSaldo());
			stmt.setObject(7, asi.getFecha_nacimiento());
			stmt.setString(8, asi.getTipo_doc());
			stmt.setInt(9, asi.getNro_doc());
			stmt.setInt(10, asi.getRol());
			stmt.setString(11, asi.getTipo_doc());
			stmt.setInt(12, asi.getNro_doc());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Se produjo un error, revise los datos ingresados.");

        } finally {
            try {
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public void deleteByDoc(Asistente delAsi) { 
		PreparedStatement stmt = null;

        try {
        stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from asistente where tipo_doc=? and nro_doc=?");

        stmt.setString(1, delAsi.getTipo_doc());
        stmt.setInt(2, delAsi.getNro_doc());

        stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error SQL: " + e.getMessage());
            //System.out.println("Documento inexistente " + "no funciona el deleteByDoc(Asistente delAsi)  ");

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
	
