package tarea3;

import javax.swing.*;
import java.awt.*;

public class VistaP extends JDialog {

	public static void main(String[] args) {
		VistaP n = new VistaP(null, true);

		n.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		n.setSize(350, 200);

	}

	public JLabel Hola;

	public VistaP(Controlador controlador, boolean modal) {

		JLabel Hola = new JLabel("Ya estas dentro...");
		Hola.setLocale(null);
		add(Hola);

	}

}
