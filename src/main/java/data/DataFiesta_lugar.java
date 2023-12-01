package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import entities.Fiesta_lugar;

public class DataFiesta_lugar {

	public LinkedList<Fiesta_lugar> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Fiesta_lugar> fie_lug= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select idfiesta, idlugar, fecha_hora_fiesta from fiesta_lugar");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Fiesta_lugar fl=new Fiesta_lugar(0, 0, null);
					fl.setIdfiesta(rs.getInt("idfiesta"));
					fl.setIdlugar(rs.getInt("idlugar"));
					fl.setFecha_hora_fiesta(rs.getObject("fecha_hora_fiesta", LocalDate.class));	
					
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
	
	public Fiesta_lugar getByData(int idfiesta, int idlugar, LocalDate fecha_hora) {
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
				fl.setFecha_hora_fiesta(rs.getObject("fecha_hora_fiesta", LocalDate.class));	
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
	
	
	public Fiesta_lugar getByFiesta_lugar(Fiesta_lugar f_lug) {
		Fiesta_lugar fl=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select idfiesta, idlugar, fecha_hora_fiesta from fiesta_lugar where idfiesta = ? and idlugar = ? and fecha_hora_fiesta = ?"
					);
			stmt.setInt(1, f_lug.getIdfiesta());
			stmt.setInt(2,  f_lug.getIdlugar());
			stmt.setObject(3, f_lug.getFecha_hora_fiesta());	
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				fl=new Fiesta_lugar(0, 0, null);
				fl.setIdfiesta(rs.getInt("idfiesta"));
				fl.setIdlugar(rs.getInt("idlugar"));
				fl.setFecha_hora_fiesta(rs.getObject("fecha_hora_fiesta", LocalDate.class));	
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
							"insert into fiesta_lugar(idfiesta, idlugar, fecha_hora_fiesta) values(?,?,?)"
							,PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, fl.getIdfiesta());
			stmt.setInt(2, fl.getIdlugar());
			stmt.setObject(3, fl.getFecha_hora_fiesta());	
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
	
	public void actualizarFiesta_lugar(Fiesta_lugar fl) {
        PreparedStatement stmt= null;
        try {
            stmt=DbConnector.getInstancia().getConn().
                    prepareStatement("update fiesta set idfiesta = ?, idlugar=?, fecha_hora_fiesta= ? where idfiesta = ? and idlugar = ? and fecha_hora_fiesta = ?");
            stmt.setInt(1, fl.getIdfiesta());
			stmt.setInt(2, fl.getIdlugar());
			stmt.setObject(3, fl.getFecha_hora_fiesta());	

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Se produjo un error, revise los datos ingresados.(DataFiesta_lugar - actualizarFiesta_lugar");

        } finally {
            try {
                if(stmt!=null) {stmt.close();}
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public void deleteByIDs(Fiesta_lugar delfl) {
        PreparedStatement stmt = null;

        try {
        stmt = DbConnector.getInstancia().getConn().prepareStatement("delete from fiesta where idfiesta=? and idlugar=? and fecha_hora_fiesta=?");

        stmt.setInt(1, delfl.getIdfiesta());
		stmt.setInt(2, delfl.getIdlugar());
		stmt.setObject(3, delfl.getFecha_hora_fiesta());	
        
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
        }
	
}
