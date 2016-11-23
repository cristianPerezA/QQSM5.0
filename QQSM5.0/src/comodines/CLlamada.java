package comodines;

import java.util.Random;

import preguntas.Pregunta;
import preguntas.Utilidades;
import qqsm.Configuracion;


//En esta clase simularemos que hacemos una llamada a la persona y al n�mero elegido por el concursante
public class CLlamada extends Comodin {

	private String nombre;
	private int telefono;


	/**Constructor de la clase del comod�n de la llamada
	 * @param usado
	 */
	public CLlamada(boolean usado) {
		super(usado);
		// TODO Auto-generated constructor stub
	}

	//Getters y setters de la clase
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	// Este es el m�todo que simular� la llamada
	public static void simuladorLlamada(CLlamada a) {
		System.out.println("Llamando a "+a.getNombre()+" al n�mero " + a.getTelefono());
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		// System.out.println(getNombre()+" cree que la respuesta correcta est� entre la"
		// + C50porciento.getnResp1()+ " y la " + C50porciento.getnResp2 );
	}

	/* M�todo que generar� los resultados del comod�n de la llamada
	 *  
	 */
	@Override
	public void utilizarComodin(Pregunta pregunta) {
		// TODO Auto-generated method stub
		this.usado=true;
		System.out.println("Nombre de la persona a la que deseas llamar: ");
		this.nombre=Utilidades.leerCadena();
		System.out.println("Introduce el n�mero de tel�fono de "+ this.nombre);
		this.telefono= Utilidades.leerEntero();
		simuladorLlamada(this);
		Random w = new Random();
		int n = w.nextInt(4) + 1;
		while (n==pregunta.getPosRespC()){
			n=w.nextInt(4)+1;
		}
		String resE= Configuracion.respuestaX(n, pregunta);
		String resC= pregunta.getResC();
		System.out.println("Hola, yo creo que la respuesta correcta es "+resC+ " aunque tambi�n podr�a ser "+resE+ ", no estoy seguro pero espero haberte ayudado. Suerte y a por el premio!");
	}


	/**Main para probar el comod�n de la llamada
	 * @param args
	 */
	public static void main(String[] args) {
		CLlamada a= new CLlamada(false);
		Pregunta b = new Pregunta("�Cu�l es la capital de Bizkaia?", "Bilbao",
				"Donosti", "Vitoria", "Barcelona", 1);
		a.utilizarComodin(b);

	}



}
