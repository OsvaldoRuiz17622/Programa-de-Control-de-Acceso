package tarea3;

public class pruebaLogin {

	public static void main(String[] args) {
		Vista v = new Vista();
		Modelo m = new Modelo();
		new Controlador(m, v);
	}

}
