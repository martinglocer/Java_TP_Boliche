package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login1 extends JFrame {

	private JFrame frame;
	private JTextField txtUser;
	private JTextArea txtMessage;
	private JPasswordField txtPassword;


	/**
	 * Create the application.
	 */
	public Login1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 595);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(195, 20, 100, 44);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(85, 123, 66, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(55, 180, 98, 22);
		panel.add(lblNewLabel_1_1);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUser.setBounds(161, 119, 213, 31);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(55, 252, 372, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(55, 325, 372, 2);
		panel.add(separator_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLogin.setBounds(85, 264, 126, 51);
		panel.add(btnLogin);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Botón Limpiar clickeado");
				txtUser.setText("");
				txtPassword.setText("");
				txtMessage.setText("");
				
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnLimpiar.setBounds(269, 264, 126, 51);
		panel.add(btnLimpiar);
		
		JTextArea txtMessage = new JTextArea();
		txtMessage.setEditable(false);
		txtMessage.setBounds(55, 344, 372, 167);
		panel.add(txtMessage);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPassword.setBounds(161, 176, 213, 31);
		panel.add(txtPassword);
	}
	
	public void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
		
		txtUser.setText("");
		txtPassword.setText("");
		txtMessage.setText("");
		
	}
	
}
