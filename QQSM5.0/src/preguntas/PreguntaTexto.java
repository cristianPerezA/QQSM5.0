package preguntas;

public class PreguntaTexto extends Pregunta {

	/**Constructor para crear preguntas de solo texto
	 * @param textoPregunta
	 * @param res1
	 * @param res2
	 * @param res3
	 * @param res4
	 * @param posRespC
	 */
	public PreguntaTexto(String textoPregunta, String res1, String res2,
			String res3, String res4, int posRespC) {
		super(textoPregunta, res1, res2, res3, res4, posRespC);
	}



	public static void main(String[] args) {
		Pregunta a = new Pregunta("¿Cuál es la capital de Bizkaia?", "Bilbao",
				"Donosti", "Vitoria", "Barcelona", 1);
		String respuesta = a.respuestas[a.getPosRespC() - 1];
		System.out.println(a.toString());
		System.out.println("Respuesta correcta:" + respuesta);
	}
}
