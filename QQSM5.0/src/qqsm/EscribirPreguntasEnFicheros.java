package qqsm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import preguntas.PreguntaImagen;
import preguntas.PreguntaTexto;

//En esta clase se encuentran todas las preguntas.
//Esta clase se ejecutarla primera vez que inicializemos el programa y creara 3 archivos con todas las preguntas del programa.
//Cada archivo ser� para una dificultad concreta

public class EscribirPreguntasEnFicheros  {

	public static void main(String[] args) {

		EscribirPreguntasFaciles();

		EscribirPreguntasMedio();

		EscribirPreguntasDificiles();

	}

	/**M�todo que escribe las preguntas clasificadas como f�ciles en el archivo preguntasFaciles.dat
	 * 
	 */
	protected static void EscribirPreguntasFaciles() {
		try {
			FileOutputStream fos = new FileOutputStream("preguntasFaciles.dat");
			ObjectOutputStream oss = new ObjectOutputStream(fos);

			oss.writeObject(new PreguntaImagen(
					"El sistema electoral para determinar las personas que ocuparan cargos publicos:",
					"Sufragio", "Adagio", "Naufrago", "Prestigio", 1,"src/imagenespreguntas/sufragio.png"));
			oss.writeObject(new PreguntaImagen(
					"Nombre de la banda liderada por Javier Gurruchaga:",
					"La Orquesta Mondrag�n", "La Granja", "Radio Futura", "Nacha Pop", 1, "src/imagenespreguntas/Javier.png"));
			oss.writeObject(new PreguntaTexto("Una persona famelica esta:",
					"Irritable", "Hambrienta", "Furiosa", "Asustada", 2));
			oss.writeObject(new PreguntaImagen(
					"Jose Tomas Boves murio en la Batalla de:", "Carabobo",
					"Urica", "Mucuritas", "Calabozo", 2, "src/imagenespreguntas/Jose.png"));
			oss.writeObject(new PreguntaTexto(
					"Son las membranas movibles cubiertas de piel que resguardan los ojos:",
					"Cejas", "Pupilas", "Parpados", "Anteojos", 3));
			oss.writeObject(new PreguntaTexto(
					"El albinismo se presenta por la carencia de:", "Calcio",
					"Pigmentaci�n", "Vitamina A", "Oxigeno", 2));
			oss.writeObject(new PreguntaTexto(
					"Cual de estos instrumentos mide la densidad de los aceites?",
					"Dinamometro", "Micrometro", "Oleometro", "Holometro", 3));
			oss.writeObject(new PreguntaTexto(
					"�ltima letra del alfabeto griego", "Omega", "Alpha",
					"Zeta", "Gamma", 1));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l es el deporte que m�s se practica en el Mundo?",
					"El croquet", "El rugby", "El baloncesto", "El f�tbol", 4));
			oss.writeObject(new PreguntaTexto(
					"En ajedrez, la �nica ficha que pasa por encima de otras es...",
					"El caballo", "La reina", "El pe�n", "El rey", 1));
			oss.writeObject(new PreguntaTexto(
					"�En qu� ciudad se encuentra la Catedral de Notre-Dame?",
					"Estambul", "Londres", "Barcelona", "Paris", 4));
			oss.writeObject(new PreguntaTexto(
					"�Sobre la creaci�n de qu� red social se estren� una pel�cula en el a�o 2010?",
					"Twitter", "Tuenti", "Facebook", "MySpace", 3));
			oss.writeObject(new PreguntaTexto("Una esclusa es como:",
					"Una perilla", "Una disculpa", "Una puerta", "Una manga", 3));
			oss.writeObject(new PreguntaTexto(
					"�En qu� continente se encuentra Bolivia?", "Europa",
					"Asia", "�frica", "Am�rica", 4));
			oss.writeObject(new PreguntaTexto(
					"Los juegos Ol�mpicos se celebran cada...", "2 a�os",
					"7 a�os", "8 a�os", "4 a�os", 4));
			oss.writeObject(new PreguntaTexto(
					"Marbella pertenece a la provincia de...", "Ja�n",
					"Almer�a", "Granada", "M�laga", 4));
			oss.writeObject(new PreguntaTexto(
					"Segun el refran, quien es ciego?", "La esperanza",
					"El amor", "El odio", "La envidia", 2));
			oss.writeObject(new PreguntaTexto(
					"�Qu� personaje medieval robaba a los ricos para darles el dinero a los pobres?",
					"Robin Bonnet", "Robin Hood", "Robin Hat", "Robin Cap", 2));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l de las siguientes corresponde con el significado de 'sempiterno'?",
					"Inmortal", "Indefenso", "Igual", "Diferente", 1));
			oss.writeObject(new PreguntaTexto(
					"�Qui�n canta la canci�n 'Let it be'?",
					"Chuck Berry",
					"Elvis Presley",
					"Jimi Hendrix",
					"The Beatles", 4));
			oss.writeObject(new PreguntaTexto(
					"De las siguientes palabras cu�l est� escrita correctamente",
					"Vatay�n",
					"Batallon",
					"Batall�n",
					"Batayon", 3));
			oss.writeObject(new PreguntaTexto(
					"�En qu� a�o naci� Alejandro Magno?",
					"1752",
					"356 a.C",
					"5000 a.C",
					"1500 a.C", 2));
			oss.writeObject(new PreguntaTexto(
					"�Qui�n escribi� 'El cantar del M�o Cid'?",
					"Tom�s de Aquino",
					"Quevedo",
					"An�nimo",
					"G�ngora", 3));

			oss.writeObject(null);
			oss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**M�todo que escribe las preguntas clasificadas como 'Medio' en el archivo preguntasMedio.dat
	 * 
	 */
	protected static void EscribirPreguntasMedio() {
		try {
			FileOutputStream fos = new FileOutputStream("preguntasMedio.dat");
			ObjectOutputStream oss = new ObjectOutputStream(fos);

			oss.writeObject(new PreguntaTexto(
					"�Qu� detective aparece en la obra de Agatha Christie 'Muerte en el Nilo'?", "Lord Peter Wimsey",
					"Hercule Poirot", "Inspector Morse", "Kurt Wallander", 2));
			oss.writeObject(new PreguntaTexto(
					"�Cu�ntas veces ha participado Venezuela en un mundial de f�tbol?",
					"2", "1", "0", "3", 3));
			oss.writeObject(new PreguntaTexto(
					"�C�mo se representa el n�mero 3045 en n�meros romanos?",
					"MMMLX", "MMMXLV", "MMCCLXV", "MMDLXV", 2));
			oss.writeObject(new PreguntaTexto(
					"El gentilicio de la provincia de Huesca es:",
					"Huescano", "Huescense", "Huesca�o", "Oscense", 4));
			oss.writeObject(new PreguntaTexto("Capital de Per�.",
					"Tegucigalpa", "Lima", "Bogot�", "Caracas", 2));
			oss.writeObject(new PreguntaTexto(
					"�En qu� campo destaca el ruso del siglo XIX Pyotr Tchaikovsky?",
					"M�sica ", "Arquitectura", "Escultura", "Literatura", 1));
			oss.writeObject(new PreguntaTexto(
					"Capital del Principado de Liechtenstein", "Berna",
					"San Marino", "Vaduz", "Vilna", 3));
			oss.writeObject(new PreguntaTexto(
					"Ant�nimo de la palabra 'desabrido'", "Insulso", "Afable",
					"Inhibido", "Displicente", 2));
			oss.writeObject(new PreguntaTexto(
					"�Qu� puede ser cuarto creciente o cuarto menguante?",
					"La V�a L�ctea", "El Sol", "La Tierra", "La Luna", 4));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l de los siguientes no es un instrumento de viento?",
					"La tuba", "La gaita", "El timbal", "El clarinete", 3));
			oss.writeObject(new PreguntaTexto(
					"�En qu� pa�s se han celebrado un mayor n�mero de Juegos Ol�mpicos?",
					"EE.UU.", "Francia", "Grecia", "Canad�", 1));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l es el s�mbolo qu�mico del Platino?", "Pn", "Pl",
					"Pt", "P", 3));
			oss.writeObject(new PreguntaTexto(
					"�Con qu� compa��a de ballet se vincula a Margot Fonteyn?",
					"El Ballet de Mosc�", "El Ballet de Nueva York",
					"El Ballet Bolshoi", "El Royal Ballet", 4));
			oss.writeObject(new PreguntaTexto(
					"�A qui�n reemplaz� Roland Burris en enero de 2009?",
					"Hillary Clinton", "Barack Obama", "Dick Cheney",
					"Donald Rumsfeld", 2));
			oss.writeObject(new PreguntaTexto(
					"�Qu� pa�s vi� nacer a Baudelaire?",
					"Holanda",
					"Francia",
					"B�lgica",
					"Alemania", 2));
			oss.writeObject(new PreguntaTexto(
					"�En qu� ciudad podemos encontrar el Cristo de la Concordia?",
					"Montevideo",
					"Santiago de los Caballeros",
					"Caracas",
					"Cochabamba", 4));
			oss.writeObject(new PreguntaTexto(
					"�En qu� pa�s se encuentra la ciudad de Stuttgart?",
					"Reino Unido",
					"Espa�a",
					"Italia",
					"Alemania", 4));
			oss.writeObject(new PreguntaTexto(
					"�Qu� pintor espa�ol del siglo XX luc�a un largu�simo y curvado bigote?",
					"Salvador Dal�",
					"Juan Gris",
					"Pablo Picasso",
					"Rafael Barradas", 1));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l de los siguientes juegos se parece m�s al Scrabble?",
					"Mafia Wars",
					"Drop7",
					"Words with Friends",
					"FarmVille", 3));
			oss.writeObject(new PreguntaTexto(
					"�De qu� color son los pantalones de los 'castellers'?",
					"Negros",
					"Plateados",
					"Blancos",
					"Azules", 3));
			oss.writeObject(new PreguntaTexto(
					"�De qu� saga de videojuegos es protagonista Leon S Kennedy?",
					"Resident Evil",
					"Resident Devil",
					"President Evil",
					"President Devil", 1));
			oss.writeObject(new PreguntaTexto(
					"�Qu� r�o puede cruzarse mediante el Puente de Brooklyn?",
					"Colorado",
					"Potomac",
					"East River",
					"Orinoco", 3));
			oss.writeObject(new PreguntaTexto(
					"�Qui�n era el presidente de Espa�a cuando �sta entr� a formar parte de la UE?",
					"Felipe Gonz�lez",
					"Jose Mar�a Aznar",
					"Leopoldo Calvo-Sotelo",
					"Adolfo Su�rez", 1));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l es el principal producto de exportaci�n de Venezuela?",
					"Petr�leo",
					"Carb�n",
					"Niquel",
					"Hierro", 1));
			oss.writeObject(new PreguntaTexto(
					"�Qu� actriz interpreta a Paca, la protagonista de '�Qui�n da la vez?'?",
					"Carmen Machi",
					"Beatriz Carvajal",
					"Melanie Olivares",
					"Carmen Sevilla", 2));
			oss.writeObject(new PreguntaTexto(
					"�Qui�n ha recibido en tres ocasiones el Premio Nobel de la Paz?",
					"La Madre Teresa de Calcuta",
					"Mahatma Ganghi",
					"El Comit� Internacional de la Cruz Roja",
					"Ninguna persona ni instituci�n", 3));

			oss.writeObject(null);
			oss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**M�todo que escribe las preguntas clasificadas como dif�ciles en el archivo preguntasDificiles.dat
	 * 
	 */
	protected static void EscribirPreguntasDificiles() {
		try {
			FileOutputStream fos = new FileOutputStream(
					"preguntasDificiles.dat");
			ObjectOutputStream oss = new ObjectOutputStream(fos);

			oss.writeObject(new PreguntaTexto(
					"Quien dirigi� la pel�cula 'El Padrino' en 1972?",
					"Roman Polanski", "Franco Zeffirelli",
					"Francis Ford Copolla", "Federico Fellini", 3));
			oss.writeObject(new PreguntaTexto(
					"El famoso cuadro 'Las tres gracias' es obra de...",
					"Vel�zquez", "Goya", "Rubens", "Leonardo Da Vinci", 3));
			oss.writeObject(new PreguntaTexto(
					"�Cu�ntos pares de patas tienen los cangrejos?",
					"Cinco pares", "Diez pares", "Dos pares", "Tres pares", 1));
			oss.writeObject(new PreguntaTexto(
					"Omar Torrijos Herrera fue un presidente...", "Paname�o",
					"Ecuatoriano", "Mexicano", "Salvadore�o", 1));
			oss.writeObject(new PreguntaTexto(
					"Equipo de Formula 1 en el que corri� Michael Schumacher entre 1996 y 2006",
					"Toyota", "Renault", "McLaren",
					"Ferrari", 4));
			oss.writeObject(new PreguntaTexto(
					"�Qu� otro nombre recibe la ley de Dalton?",
					"Ley de la conservaci�n de la masa",
					"Ley de las proporciones m�ltiples",
					"Ley de las proporciones definidas",
					"Ley de los equivalentes", 2));
			oss.writeObject(new PreguntaTexto(
					"�Donde naci� Juan Ram�n Jimenez?", "Chipiona", "Moguer",
					"Sevilla", "M�laga", 2));
			oss.writeObject(new PreguntaTexto(
					"�Qui�n dirigi� Casablanca, ganadora de tres premios �scar en 1943?",
					"Billy Wilder", "Sam Wood", "John Huston",
					"Michael Curtiz", 4));
			oss.writeObject(new PreguntaTexto(
					"�C�mo se denomina la fuente arqueol�gica de fotograf�a a larga distancia?",
					"Infradetecci�n",
					"Teledetecci�n",
					"Detenci�n del yacimiento",
					"Ninguna es correcta", 2));
			oss.writeObject(new PreguntaTexto(
					"�Qu� navegante espa�ol descubri� el Oceano Pac�fico",
					"Vasco N��ez de Balboa",
					"Fernando Magallanes",
					"Juan Sebasti�n Elcano",
					"Cristobal Col�n", 1));
			oss.writeObject(new PreguntaTexto(
					"El �nico director de cine que ha obtenido 4 Oscars ha sido:",
					"Elia Kazan",
					"Frank Capra",
					"John Ford",
					"William Wyler", 3));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l de estos corresponde a una verdura utilizada en la cocina china?",
					"Dim sum",
					"Chow mein",
					"Pak choi",
					"Foo yung", 3));
			oss.writeObject(new PreguntaTexto(
					"�Qu� gl�ndula productora de hormonas se encuentra en el cerebro?",
					"Suprarrenal",
					"Pineal",
					"Tiroides",
					"P�ncreas", 2));
			oss.writeObject(new PreguntaTexto(
					"�Cu�l de los siguientes no consigui� vender un solo cuadro en vida?",
					"Leonardo Da Vinci",
					"Miguel �ngel",
					"Donatello",
					"Vincent van Gogh", 4));
			oss.writeObject(new PreguntaTexto(
					"Alex Ferguson fue entrenador del...",
					"Celtic",
					"ManchesterUnited",
					"Real Madrid",
					"Chelsea", 2));

			oss.writeObject(null);
			oss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
