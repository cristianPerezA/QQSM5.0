package preguntas;

import java.io.Serializable;

public class Pregunta implements Serializable {

	// En esta clase se encuentra el sistema de las preguntas del juego.
	// En él creo los parametros necesarios y el constructor con el cual se
	// añadirán posteriormente las preguntas.

	private static final long serialVersionUID = 1L;
	protected String textoPregunta;
	protected String resC;
	public String[] respuestas;
	protected int posRespC;

	// El constructor de la clase Pregunta coge por parametros la pregunta y las
	// respuestas seguidos de un número
	// que indica cual es la posición de la respues correcta.
	// Seguidamente el constructor introduce todas las respuestas en un Array de
	// Strings.
	public Pregunta(String textoPregunta, String res1, String res2,
			String res3, String res4, int posRespC) {

		this.textoPregunta = textoPregunta;
		respuestas = new String[4];
		respuestas[0] = res1;
		respuestas[1] = res2;
		respuestas[2] = res3;
		respuestas[3] = res4;
		this.posRespC = posRespC;

		if (posRespC == 1) {
			this.resC = respuestas[0];
		}
		if (posRespC == 2) {
			this.resC = respuestas[1];
		}
		if (posRespC == 3) {
			this.resC = respuestas[2];
		}
		if (posRespC == 4) {
			this.resC = respuestas[3];
		}
	}

	// Getters y setters

	public String getResC() {
		return resC;
	}

	public void setResC(String resC) {
		this.resC = resC;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}

	public void setTextoPregunta(String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public String[] getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String[] respuestas) {
		this.respuestas = respuestas;
	}

	public int getPosRespC() {
		return posRespC;
	}

	public void setPosRespC(int posRespC) {
		this.posRespC = posRespC;
	}

	public String getRes1() {
		return respuestas[0];
	}

	public void setRes1(String res1) {
		respuestas[0] = res1;
	}

	public String getRes2() {
		return respuestas[1];
	}

	public void setRes2(String res2) {
		respuestas[1] = res2;
	}

	public String getRes3() {
		return respuestas[2];
	}

	public void setRes3(String res3) {
		respuestas[2] = res3;
	}

	public String getRes4() {
		return respuestas[3];
	}

	public void setRes4(String res4) {
		respuestas[3] = res4;
	}

	/*
	 * Método ToString
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return textoPregunta + "\n" + "A)" + respuestas[0] + "\tB)"
				+ respuestas[1] + "\nC)" + respuestas[2] + "\tD)"
				+ respuestas[3];
	}

	/**
	 * Main de prueba
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Pregunta a = new Pregunta("¿Cuál es la capital de Bizkaia?", "Bilbao",
				"Donosti", "Vitoria", "Barcelona", 1);

		System.out.println(a.toString());
		System.out.println("Respuesta correcta:" + a.resC);
	}

}
