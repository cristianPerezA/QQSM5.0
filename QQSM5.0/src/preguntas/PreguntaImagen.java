package preguntas;

import java.io.File;

public class PreguntaImagen extends Pregunta {

	private static final long serialVersionUID = 1L;
	private String imagen;

	/**
	 * Constructor que pasa los datos de la pregunta como parametros y ademas
	 * pasa la imagen de la pregunta
	 * 
	 * @param textoPregunta
	 * @param res1
	 * @param res2
	 * @param res3
	 * @param res4
	 * @param posRespC
	 * @param imagen
	 */
	public PreguntaImagen(String textoPregunta, String res1, String res2,
			String res3, String res4, int posRespC, String imagen) {
		super(textoPregunta, res1, res2, res3, res4, posRespC);
		this.imagen = imagen;
	}

	// Getters y setters
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String toString() {
		return super.toString() + imagen;
	}

	/**
	 * Main de prueba
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Pregunta a = new Pregunta("¿Cuál es la capital de Bizkaia?", "Bilbao",
				"Donosti", "Vitoria", "Barcelona", 1);
		String respuesta = a.respuestas[a.getPosRespC() - 1];
		System.out.println(a.toString());
		System.out.println("Respuesta correcta:" + respuesta);

		PreguntaImagen pi = new PreguntaImagen(
				"¿Cuál es la capital de Bizkaia?", "Bilbao", "Donosti",
				"Vitoria", "Barcelona", 1, "imagenes\\Jose Tomas Boves.jpg");
		System.out.println(pi.getImagen());

	}
}
