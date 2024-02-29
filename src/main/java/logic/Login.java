package logic;

import java.awt.EventQueue;
import java.util.LinkedList;

import data.*;
import entities.*;
import ui.Login1;

public class Login {
	private DataAsistente da;
	
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login1 window = new Login1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
	
	public Login() {
		da=new DataAsistente();
	}
	
	public Asistente validate(Asistente a) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return da.getByUser(a);
	}

	public LinkedList<Asistente> getAll(){
		return da.getAll();
	}

	public Asistente getByDocumento(Asistente a) {
		return da.getByDocumento(a);	
	}
	
	public Asistente getByUser(Asistente asist) {
		return da.getByUser(asist);
	}
	
	public void addAsistente(Asistente asist) {
		da.add(asist);
	}
	
	public void actualizarDatos(Asistente a) {
		da.actualizarAsist(a);
	}
	
	public void deleteByDoc(Asistente a) {
		da.deleteByDoc(a);
	}
	
	public String validateUser(int dni, String password) {
		
		String message="Dni no encontrado";
		LinkedList<Asistente> listaAsistentes = da.getAll();
		
		for (Asistente asi : listaAsistentes) {
			if ((asi.getNro_doc()) == dni) {
				if (asi.getPassword().equals(password)) {
					message = " Dni y contraseña correctos. Bienvenido/a!";
				}
				else {
					message = "Contraseña incorrecta";
				}
				
				break;
			} 
		}
		
		return message;
		
	}
	
}
