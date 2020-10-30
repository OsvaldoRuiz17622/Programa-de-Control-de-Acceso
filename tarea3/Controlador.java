package tarea3;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
import tarea3.cifradosha.*;

class Controlador implements ActionListener {

	Modelo modelo;
	Vista vista;

	public Controlador(Modelo m, Vista v) {
		modelo = m;
		vista = v;

		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setSize(250, 250);
		vista.setResizable(false);
		vista.setLocationRelativeTo(null);
		vista.setVisible(true);

		vista.setControlodor(this); 
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		sha256 c = new sha256 ();
		
	
		// agregado
		// @Override
		switch (e.getActionCommand()) {

		case interfazVista1.Ingresar:
			
			// inicia lectura de archivo
			File file = new File("archivoLogin.txt");
			// "C:/Users/osval/OneDrive/Escritorio/Trabajos JAVA/Topicos Avanzados de
			// Programacion/src/tarea3/niu.txt"
			
			String UsuarioN, contrasenaN;

			int cond = 0;
			try {

				Scanner scanner = new Scanner(file);

				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				
				while (delimitar.hasNext() == true) {

					UsuarioN = delimitar.next();

					contrasenaN = delimitar.next();

					if (vista.usuario.getText().equals(UsuarioN)
							&& c.convertirSHA256(vista.contrasena.getText()).equals(contrasenaN)) {

						cond = 1;

					}

				}

				
				
				if (cond == 1) {

					vista.usuario.setText("");
					vista.contrasena.setText("");
					vista.usuario.requestFocus();
					JOptionPane.showMessageDialog(null, "Bienvenido", "Ingresando...", JOptionPane.INFORMATION_MESSAGE);
					VistaP p = new VistaP(this, true);
					p.setVisible(true);
					p.setSize(300, 200);
					p.setLocationRelativeTo(null);

				} else {
					vista.usuario.setText("");
					vista.contrasena.setText("");
					JOptionPane.showMessageDialog(null, "ERROR:\nUsuario o Contrasena no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
					vista.setVisible(false);	
					
					
				}

			} catch (FileNotFoundException e1) {
				
				System.out.print("ERROR: " + e1.getMessage());
			}

			
			break;

		case interfazVista1.RegistrarU:

			try {
				FileWriter esc = new FileWriter("archivoLogin.txt", true);
				// "C:/Users/osval/OneDrive/Escritorio/Trabajos JAVA/Topicos Avanzados de
				// Programacion/src/tarea3/niu.txt"
				BufferedWriter bw = new BufferedWriter(esc);
				bw.write(vista.usuario.getText() + " , " + c.convertirSHA256(vista.contrasena.getText()) + " , "); 


				bw.close();
				esc.close();

			} catch (IOException ecsdi) {
				
				JOptionPane.showMessageDialog(null, "ERROR INESPERADO");
			}

			vista.usuario.setText("");
			vista.contrasena.setText("");
			JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
			vista.usuario.requestFocus();
			
			break;

		}
		// finagregado

	}

}
