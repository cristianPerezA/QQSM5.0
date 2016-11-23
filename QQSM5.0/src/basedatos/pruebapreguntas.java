package basedatos;

import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

import preguntas.Pregunta;

public class pruebapreguntas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Probando la linkedlist de preguntas de la BD");
		accesobd a= new accesobd();
		a.conectar();
		
		//System.out.println(a.obtenerPreguntas().getFirst().getTextoPregunta());
		LinkedList<Pregunta> lPreguntas= a.obtenerPreguntas();
		
		for (int i = 0; i <lPreguntas.size() ; i++) {
			Pregunta mostrar = lPreguntas.get(i);
			System.out.println(mostrar);
		}
		
		
		
		//List lista2 = new ArrayList(lista);
        //Iterator it = (Iterator) lPreguntas.iterator();
        //while (it.isValid()){
        //     System.out.println(it.toString());
         //}
	}

}
