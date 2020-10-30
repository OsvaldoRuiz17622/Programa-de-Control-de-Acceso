package tarea3;

import javax.swing.*;

import mvc.Controlador;

import java.awt.*;

public class Vista extends JFrame implements interfazVista1 {

	public JButton entrar;
	public JButton Registrar;
	public JTextField usuario;
	public JPasswordField contrasena;
	public JLabel et1;
	public JLabel et2;
	public JPanel contenedor;

	Vista() {
		super("Login Usuario");

		setLayout(new FlowLayout());

		et1 = new JLabel("Usuario: ");
		et1.setBounds(35, 59, 83, 14);
		add(et1);

		usuario = new JTextField(10);
		usuario.setBounds(128, 56, 101, 20);
		add(usuario);

		et2 = new JLabel("Contrasena");
		et2.setBounds(35, 97, 83, 14);
		add(et2);

		contrasena = new JPasswordField(10);
		contrasena.setBounds(128, 94, 101, 20);
		add(contrasena);

		Registrar = new JButton(RegistrarU);
		add(Registrar);

		entrar = new JButton(Ingresar);
		add(entrar);

	}

	@Override
	public void setControlodor(tarea3.Controlador c) {
		usuario.addActionListener(c);
		Registrar.addActionListener(c);
		entrar.addActionListener(c);

	}

}
