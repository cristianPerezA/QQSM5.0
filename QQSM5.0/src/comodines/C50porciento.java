package comodines;

import java.util.Random;

import preguntas.Pregunta;
import preguntas.Utilidades;
import qqsm.Configuracion;



/**
 * Comod�n del 50 porciento, hereda de comod�n y simula el uso del comod�n
 */
public class C50porciento extends Comodin {



	public C50porciento(boolean usado) {
		super(usado);
	}


	/**Main para probar el funcionamiento del comod�n del 50porciento
	 * @param args
	 */
	public static void main(String[] args) {
		C50porciento c = new C50porciento(false);
		Pregunta a = new Pregunta("�Cu�l es la capital de Bizkaia?", "Bilbao",
				"Donosti", "Vitoria", "Barcelona", 1);
		c.utilizarComodin(a);

	}

	/* M�todo que decidir� cuales ser�n las respuestas a mostrar por el comod�n del 50 porciento.
	 * 
	 */
	@Override
	public void utilizarComodin(Pregunta pregunta) {
		this.usado=true;
		Random a = new Random();
		int n = a.nextInt(4) + 1;
		while (n==pregunta.getPosRespC()){
			n=a.nextInt(4)+1;
		}
		String resE= Configuracion.respuestaX(n, pregunta);

		String resC= pregunta.getResC(); 
		System.out.println("Respuestas posibles: ");
		System.out.println("1.- "+ resE);
		System.out.println("2.- "+ resC);
		pregunta.setPosRespC(2);




	}
}
