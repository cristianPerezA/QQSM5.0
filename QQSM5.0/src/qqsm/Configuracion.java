package qqsm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import basedatos.accesobd;
import comodines.*;
import preguntas.Pregunta;
import preguntas.PreguntaTexto;
import preguntas.Utilidades;

public class Configuracion {

	// Creamos los atributos que necesitaremos para jugar por consola y por
	// ventanas
	public static int[] euros;
	private static HashMap<Integer, Pregunta> facil = new HashMap<Integer, Pregunta>();
	private static HashMap<Integer, Pregunta> medio = new HashMap<Integer, Pregunta>();
	private static HashMap<Integer, Pregunta> dificil = new HashMap<Integer, Pregunta>();
	private static LinkedList<Pregunta> facil2 = new LinkedList<>();
	public static Pregunta[] preguntasPartida;
	public static int nPregunta;
	public static Comodin[] comodines;

	// Constructor
	public Configuracion(Pregunta[] preguntasPartida) {
		super();
		Configuracion.preguntasPartida = preguntasPartida;
	}

	public Configuracion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static HashMap<Integer, Pregunta> getFacil() {
		return facil;
	}

	public static HashMap<Integer, Pregunta> getMedio() {
		return medio;
	}

	public static HashMap<Integer, Pregunta> getDificil() {
		return dificil;
	}

	/**
	 * Inicializador del array de euros y de los 3 comodines
	 * 
	 */
	public static void init() {

		euros = new int[15];
		comodines = new Comodin[3];
		euros[0] = 100;
		euros[1] = 200;
		euros[2] = 300;
		euros[3] = 500;
		euros[4] = 1000;
		euros[5] = 2000;
		euros[6] = 4000;
		euros[7] = 8000;
		euros[8] = 16000;
		euros[9] = 32000;
		euros[10] = 64000;
		euros[11] = 125000;
		euros[12] = 250000;
		euros[13] = 500000;
		euros[14] = 1000000;
		comodines[0] = new C50porciento(false);
		comodines[0].setNombreComodin("Comodín del 50%");
		comodines[1] = new CPublico(false);
		comodines[1].setNombreComodin("Comodín del público");
		comodines[2] = new CLlamada(false);
		comodines[2].setNombreComodin("Comodín de la llamada");

	}

	/**
	 * Método que le translada al programa las preguntas que se encuentran en el
	 * fichero de preguntas fáciles
	 * 
	 */
	/*
	 * public static void LeerFicheroPreguntasF() { // TODO Auto-generated
	 * method stub FileInputStream fis; try { fis = new
	 * FileInputStream("preguntasFaciles.dat"); ObjectInputStream ois = new
	 * ObjectInputStream(fis); Pregunta a = (Pregunta) ois.readObject(); int
	 * numPregunta = 1;
	 * 
	 * while (a != null) { facil.put(new Integer(numPregunta), a); a =
	 * (Pregunta) ois.readObject(); numPregunta++; } ois.close(); } catch
	 * (IOException | ClassNotFoundException e) { e.printStackTrace(); } catch
	 * (Exception e){ System.out.println("ERROR"); }
	 * 
	 * }
	 */

	public static void LeerPreguntasFdeBD() {
		accesobd a = new accesobd();
		a.conectar();
		facil2 = a.obtenerPreguntas();
	}

	/**
	 * Método que le translada al programa las preguntas que se encuentran en el
	 * fichero de preguntas medias
	 * 
	 */
	public static void LeerFicheroPreguntasM() {

		FileInputStream fis;
		try {
			fis = new FileInputStream("preguntasMedio.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			PreguntaTexto a = (PreguntaTexto) ois.readObject();
			int numPregunta = 1;

			while (a != null) {
				medio.put(new Integer(numPregunta), a);
				a = (PreguntaTexto) ois.readObject();
				numPregunta++;
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR");
		}

	}

	/**
	 * Método que le translada al programa las preguntas que se encuentran en el
	 * fichero de preguntas dificiles
	 * 
	 */
	public static void LeerFicheroPreguntasD() {

		FileInputStream fis;
		try {
			fis = new FileInputStream("preguntasDificiles.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			PreguntaTexto a = (PreguntaTexto) ois.readObject();
			int numPregunta = 1;

			while (a != null) {
				dificil.put(new Integer(numPregunta), a);
				a = (PreguntaTexto) ois.readObject();
				numPregunta++;
			}
			ois.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR");
		}

	}

	/**
	 * Método que elige las preguntas y compruea que no se repitan
	 * 
	 */
	public static void elegirPreguntas() {
		preguntasPartida = new Pregunta[15];
		/*
		 * for (int i = 0; i < 5; i++) { Random R = new Random(); int s =
		 * R.nextInt(facil.size()-1); Pregunta j = facil.get(s+1); while
		 * (preguntaExistente(j, preguntasPartida)) { s = R.nextInt(facil.size()
		 * + 1); j = facil.get(s); } preguntasPartida[i] = j; }
		 */

		for (int i = 0; i < 5; i++) {
			Random R = new Random();
			int s = R.nextInt(facil2.size() - 1);
			Pregunta j = facil2.get(s + 1);
			while (preguntaExistente(j, preguntasPartida)) {
				s = R.nextInt(facil2.size() + 1);
				j = facil2.get(s);
			}
			preguntasPartida[i] = j;
		}

		for (int i = 5; i < 10; i++) {
			Random R = new Random();
			int s = R.nextInt(medio.size() - 1);
			Pregunta j = medio.get(s + 1);
			while (preguntaExistente(j, preguntasPartida)) {
				s = R.nextInt(facil.size() + 1);
				j = medio.get(s);
			}
			preguntasPartida[i] = j;

		}
		for (int i = 10; i < 15; i++) {
			Random R = new Random();
			int s = R.nextInt(dificil.size() - 1);
			Pregunta j = dificil.get(s + 1);
			while (preguntaExistente(j, preguntasPartida)) {
				s = R.nextInt(facil.size() + 1);
				j = dificil.get(s);
			}
			preguntasPartida[i] = j;

		}

	}

	/**
	 * Método para ver si la pregunta existe ya en el array de las preguntas de
	 * la partida
	 * 
	 * @param j
	 * @param preguntasPartida
	 * @return
	 */
	private static boolean preguntaExistente(Pregunta j,
			Pregunta[] preguntasPartida) {

		boolean existe = false;
		for (int i = 0; i < preguntasPartida.length; i++) {
			if (preguntasPartida[i] == null)
				return false;
			Pregunta h = preguntasPartida[i];
			if (h.equals(j)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	/**
	 * Método para ver las preguntas por pantalla, solo para saber si las
	 * preguntas se muestran correctamente
	 * 
	 */
	public static void mostrarPreguntas() {

		System.out.println("Te muestro las preguntas del concurso: ");
		System.out.println(preguntasPartida.length);
		for (int i = 0; i < preguntasPartida.length; i++) {
			System.out.println((i + 1) + ".-" + preguntasPartida[i]);
		}
	}

	/**
	 * Método que se encarga de llevar a cabo toda la dinamica del juego
	 * 
	 */
	public static void dinamicaJuego() {

		for (int j = 0; j < euros.length; j++) {
			nPregunta = 1;
			int x = j + 1;
			System.out.println("Pregunta número " + x);
			System.out.println("...");
			System.out.println("Dinero por el que juegas en esta pregunta: "
					+ euros[j] + "€");
			System.out.println("...");
			System.out.println(preguntasPartida[j].getTextoPregunta());
			System.out.println("1.- " + preguntasPartida[j].getRes1());
			System.out.println("2.- " + preguntasPartida[j].getRes2());
			System.out.println("3.- " + preguntasPartida[j].getRes3());
			System.out.println("4.- " + preguntasPartida[j].getRes4());

			System.out.println("¿Quieres usar un comodín?(S/N):");
			char resp = Utilidades.leerCaracter();
			if (resp == 'S') {
				for (int i = 0; i < comodines.length; i++) {
					if (comodines[i].isUsado() == false)
						System.out.println((i + 1) + ".- "
								+ comodines[i].getNombreComodin());
				}
				System.out.println("Elige el comodín que quieres usar");
				int com = Utilidades.leerEntero() - 1;
				Pregunta pregunta = preguntasPartida[j];
				comodines[com].utilizarComodin(pregunta);
			}

			int respuesta = Utilidades.leerEntero();
			if (respuesta == preguntasPartida[j].getPosRespC()) {
				System.out.println("RESPUESTA CORRECTA");
				nPregunta++;
				System.out.println("numero " + nPregunta);
			} else {
				System.out.println("INCORRECTA");
				System.out.println("Respuesta correcta: " + respuesta);
				break;
			}

		}

	}

	/**
	 * @param numero
	 * @param pregunta
	 * @return respuesta elegida
	 */
	public static String respuestaX(int d, Pregunta pregunta) {

		String resE = null;
		if (d == 1) {
			resE = pregunta.getRes1();

		}
		if (d == 2) {
			resE = pregunta.getRes2();

		}
		if (d == 3) {
			resE = pregunta.getRes3();

		}
		if (d == 4) {
			resE = pregunta.getRes4();

		}
		return resE;

	}

	// Main para probar la clase
	public static void main(String[] args) {

		// LeerFicheroPreguntasF();
		LeerPreguntasFdeBD();
		System.out.println(facil2.get(0));
		String respuesta = facil2.get(0).getRespuestas()[facil2.get(0)
				.getPosRespC() - 1];
		System.out.println("Respuesta correcta es:" + respuesta);
	}

}
