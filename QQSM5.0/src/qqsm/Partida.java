package qqsm;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Partida {
	// En esta clase se encuentra el main principal en el que se ejecutará todo
	// el juego

	public static void main(String[] args) {

		// Lo primero que hará será mostrar la fecha y hora por pantalla
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));

		// Después creara 3 documentos que almacenarán todas las preguntas en
		// esos documentos
		// Dependiendo de su nivel de dificultad
		// (Esto solo debería de ejecutarse una vez por lo que igual hago alguna
		// manera de que no se ejecute cada vez que se juegue)
		/*
		 * EscribirPreguntasEnFicheros.EscrirPreguntasFaciles();
		 * EscribirPreguntasEnFicheros.EscrirPreguntasMedio();
		 * EscribirPreguntasEnFicheros.EscrirPreguntasDificiles();
		 */
		System.out.println("Iniciando configuración....");
		// Inicialicemos el panel de juego con las cantidades de dinero
		Configuracion.init();

		// Ahora leeremos todas las preguntas de los 3 bloques de dificultad al
		// programa
		System.out.println("Leyendo preguntas fáciles...");
		Configuracion.LeerPreguntasFdeBD();
		System.out.println("Leyendo preguntas medias...");
		Configuracion.LeerFicheroPreguntasM();
		System.out.println("Leyendo preguntas difíciles...");
		Configuracion.LeerFicheroPreguntasD();

		// Este metodo elegirá 5 preguntas de cada nivel de difilcutad que serán
		// con las que juegue el jugador.
		// Esas preguntas se meterán en un array de 15 posiciones con las 15
		// preguntas.
		System.out.println("Eligiendo preguntas.......");
		Configuracion.elegirPreguntas();
		System.out.println("Mostrar preguntas...");
		Configuracion.mostrarPreguntas();
		Configuracion.dinamicaJuego();

	}

}