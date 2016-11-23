package comodines;

import java.util.Random;

import preguntas.Pregunta;
import qqsm.Configuracion;

//En esta clase crearemos el código correspondiente al comodín del público
public class CPublico extends Comodin {


	public CPublico(boolean usado) {
		super(usado);
		// TODO Auto-generated constructor stub
	}

	//Atributos de la clase del comodín del público a los que asignaremos porcentajes Random
	public static int a;
	public static int b;
	public static int c;
	public static int d;


	/**Método que calcula porcentajes random para cada atributo
	 * 
	 */
	public void porcentajes() {
		Random R = new Random();
		this.a = R.nextInt(20) + 40;
		this.b = R.nextInt(10) + 5;
		this.c = 90 - (a + b);
		this.d = 100 - (a+b+c);
	}


	/* En este método asignaremos al porcentaje más alto la respuesta correcta y simularemos que el público ha realizado una votación
	 * @see comodines.Comodin#utilizarComodin(preguntas.Pregunta)
	 */
	public void utilizarComodin(Pregunta pregunta) {
		// TODO Auto-generated method stub
		this.usado=true;
		CPublico a= new CPublico(false);
		a.porcentajes();
		System.out.println("El público está votando");
		System.out.println("...");
		System.out.println("...");
		System.out.println("...");
		System.out.println("Resultados:");
		System.out.println(pregunta.getResC() +" "+ a.a+"%");
		Random k = new Random();
		int n = k.nextInt(4) + 1;
		while (n==pregunta.getPosRespC()){
			n=k.nextInt(4)+1;
		}
		String res1= Configuracion.respuestaX(n, pregunta);
		System.out.println(res1+ " "+a.b+"%");
		Random l = new Random();
		int m = l.nextInt(4) + 1;
		while (m==pregunta.getPosRespC()|| m==n){
			m=l.nextInt(4)+1;
		}
		String res2= Configuracion.respuestaX(m, pregunta);
		System.out.println(res2+ " "+a.d+"%");
		Random p = new Random();
		int o = p.nextInt(4) + 1;
		while (o==pregunta.getPosRespC()||o==m||o==n){
			o=p.nextInt(4)+1;
		}
		String res3= Configuracion.respuestaX(o, pregunta);
		System.out.println(res3+" "+a.c+"%");

	}



	/**Main para probar el comodin
	 * @param args
	 */
	public static void main(String[] args) {
		CPublico n= new CPublico(false);
		Pregunta pregunta = new Pregunta("¿Cuál es la capital de Bizkaia?", "Bilbao",
				"Donosti", "Vitoria", "Barcelona", 1);
		n.porcentajes();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		n.utilizarComodin(pregunta);
	}


}
