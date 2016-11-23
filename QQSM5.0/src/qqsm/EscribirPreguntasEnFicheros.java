package qqsm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import preguntas.PreguntaImagen;
import preguntas.PreguntaTexto;

//En esta clase se encuentran todas las preguntas.
//Esta clase se ejecutarla primera vez que inicializemos el programa y creara 3 archivos con todas las preguntas del programa.
//Cada archivo será para una dificultad concreta

public class EscribirPreguntasEnFicheros  {

	public static void main(String[] args) {

		EscribirPreguntasFaciles();

		EscribirPreguntasMedio();

		EscribirPreguntasDificiles();

	}

	/**Método que escribe las preguntas clasificadas como fáciles en el archivo preguntasFaciles.dat
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
					"La Orquesta Mondragón", "La Granja", "Radio Futura", "Nacha Pop", 1, "src/imagenespreguntas/Javier.png"));
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
					"Pigmentación", "Vitamina A", "Oxigeno", 2));
			oss.writeObject(new PreguntaTexto(
					"Cual de estos instrumentos mide la densidad de los aceites?",
					"Dinamometro", "Micrometro", "Oleometro", "Holometro", 3));
			oss.writeObject(new PreguntaTexto(
					"Última letra del alfabeto griego", "Omega", "Alpha",
					"Zeta", "Gamma", 1));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál es el deporte que más se practica en el Mundo?",
					"El croquet", "El rugby", "El baloncesto", "El fútbol", 4));
			oss.writeObject(new PreguntaTexto(
					"En ajedrez, la única ficha que pasa por encima de otras es...",
					"El caballo", "La reina", "El peón", "El rey", 1));
			oss.writeObject(new PreguntaTexto(
					"¿En qué ciudad se encuentra la Catedral de Notre-Dame?",
					"Estambul", "Londres", "Barcelona", "Paris", 4));
			oss.writeObject(new PreguntaTexto(
					"¿Sobre la creación de qué red social se estrenó una película en el año 2010?",
					"Twitter", "Tuenti", "Facebook", "MySpace", 3));
			oss.writeObject(new PreguntaTexto("Una esclusa es como:",
					"Una perilla", "Una disculpa", "Una puerta", "Una manga", 3));
			oss.writeObject(new PreguntaTexto(
					"¿En qué continente se encuentra Bolivia?", "Europa",
					"Asia", "África", "América", 4));
			oss.writeObject(new PreguntaTexto(
					"Los juegos Olímpicos se celebran cada...", "2 años",
					"7 años", "8 años", "4 años", 4));
			oss.writeObject(new PreguntaTexto(
					"Marbella pertenece a la provincia de...", "Jaén",
					"Almería", "Granada", "Málaga", 4));
			oss.writeObject(new PreguntaTexto(
					"Segun el refran, quien es ciego?", "La esperanza",
					"El amor", "El odio", "La envidia", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Qué personaje medieval robaba a los ricos para darles el dinero a los pobres?",
					"Robin Bonnet", "Robin Hood", "Robin Hat", "Robin Cap", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál de las siguientes corresponde con el significado de 'sempiterno'?",
					"Inmortal", "Indefenso", "Igual", "Diferente", 1));
			oss.writeObject(new PreguntaTexto(
					"¿Quién canta la canción 'Let it be'?",
					"Chuck Berry",
					"Elvis Presley",
					"Jimi Hendrix",
					"The Beatles", 4));
			oss.writeObject(new PreguntaTexto(
					"De las siguientes palabras cuál está escrita correctamente",
					"Vatayón",
					"Batallon",
					"Batallón",
					"Batayon", 3));
			oss.writeObject(new PreguntaTexto(
					"¿En qué año nació Alejandro Magno?",
					"1752",
					"356 a.C",
					"5000 a.C",
					"1500 a.C", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Quién escribió 'El cantar del Mío Cid'?",
					"Tomás de Aquino",
					"Quevedo",
					"Anónimo",
					"Góngora", 3));

			oss.writeObject(null);
			oss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**Método que escribe las preguntas clasificadas como 'Medio' en el archivo preguntasMedio.dat
	 * 
	 */
	protected static void EscribirPreguntasMedio() {
		try {
			FileOutputStream fos = new FileOutputStream("preguntasMedio.dat");
			ObjectOutputStream oss = new ObjectOutputStream(fos);

			oss.writeObject(new PreguntaTexto(
					"¿Qué detective aparece en la obra de Agatha Christie 'Muerte en el Nilo'?", "Lord Peter Wimsey",
					"Hercule Poirot", "Inspector Morse", "Kurt Wallander", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Cuántas veces ha participado Venezuela en un mundial de fútbol?",
					"2", "1", "0", "3", 3));
			oss.writeObject(new PreguntaTexto(
					"¿Cómo se representa el número 3045 en números romanos?",
					"MMMLX", "MMMXLV", "MMCCLXV", "MMDLXV", 2));
			oss.writeObject(new PreguntaTexto(
					"El gentilicio de la provincia de Huesca es:",
					"Huescano", "Huescense", "Huescaño", "Oscense", 4));
			oss.writeObject(new PreguntaTexto("Capital de Perú.",
					"Tegucigalpa", "Lima", "Bogotá", "Caracas", 2));
			oss.writeObject(new PreguntaTexto(
					"¿En qué campo destaca el ruso del siglo XIX Pyotr Tchaikovsky?",
					"Música ", "Arquitectura", "Escultura", "Literatura", 1));
			oss.writeObject(new PreguntaTexto(
					"Capital del Principado de Liechtenstein", "Berna",
					"San Marino", "Vaduz", "Vilna", 3));
			oss.writeObject(new PreguntaTexto(
					"Antónimo de la palabra 'desabrido'", "Insulso", "Afable",
					"Inhibido", "Displicente", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Qué puede ser cuarto creciente o cuarto menguante?",
					"La Vía Láctea", "El Sol", "La Tierra", "La Luna", 4));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál de los siguientes no es un instrumento de viento?",
					"La tuba", "La gaita", "El timbal", "El clarinete", 3));
			oss.writeObject(new PreguntaTexto(
					"¿En qué país se han celebrado un mayor número de Juegos Olímpicos?",
					"EE.UU.", "Francia", "Grecia", "Canadá", 1));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál es el símbolo químico del Platino?", "Pn", "Pl",
					"Pt", "P", 3));
			oss.writeObject(new PreguntaTexto(
					"¿Con qué compañía de ballet se vincula a Margot Fonteyn?",
					"El Ballet de Moscú", "El Ballet de Nueva York",
					"El Ballet Bolshoi", "El Royal Ballet", 4));
			oss.writeObject(new PreguntaTexto(
					"¿A quién reemplazó Roland Burris en enero de 2009?",
					"Hillary Clinton", "Barack Obama", "Dick Cheney",
					"Donald Rumsfeld", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Qué país vió nacer a Baudelaire?",
					"Holanda",
					"Francia",
					"Bélgica",
					"Alemania", 2));
			oss.writeObject(new PreguntaTexto(
					"¿En qué ciudad podemos encontrar el Cristo de la Concordia?",
					"Montevideo",
					"Santiago de los Caballeros",
					"Caracas",
					"Cochabamba", 4));
			oss.writeObject(new PreguntaTexto(
					"¿En qué país se encuentra la ciudad de Stuttgart?",
					"Reino Unido",
					"España",
					"Italia",
					"Alemania", 4));
			oss.writeObject(new PreguntaTexto(
					"¿Qué pintor español del siglo XX lucía un larguísimo y curvado bigote?",
					"Salvador Dalí",
					"Juan Gris",
					"Pablo Picasso",
					"Rafael Barradas", 1));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál de los siguientes juegos se parece más al Scrabble?",
					"Mafia Wars",
					"Drop7",
					"Words with Friends",
					"FarmVille", 3));
			oss.writeObject(new PreguntaTexto(
					"¿De qué color son los pantalones de los 'castellers'?",
					"Negros",
					"Plateados",
					"Blancos",
					"Azules", 3));
			oss.writeObject(new PreguntaTexto(
					"¿De qué saga de videojuegos es protagonista Leon S Kennedy?",
					"Resident Evil",
					"Resident Devil",
					"President Evil",
					"President Devil", 1));
			oss.writeObject(new PreguntaTexto(
					"¿Qué río puede cruzarse mediante el Puente de Brooklyn?",
					"Colorado",
					"Potomac",
					"East River",
					"Orinoco", 3));
			oss.writeObject(new PreguntaTexto(
					"¿Quién era el presidente de España cuando ésta entró a formar parte de la UE?",
					"Felipe González",
					"Jose María Aznar",
					"Leopoldo Calvo-Sotelo",
					"Adolfo Suárez", 1));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál es el principal producto de exportación de Venezuela?",
					"Petróleo",
					"Carbón",
					"Niquel",
					"Hierro", 1));
			oss.writeObject(new PreguntaTexto(
					"¿Qué actriz interpreta a Paca, la protagonista de '¿Quién da la vez?'?",
					"Carmen Machi",
					"Beatriz Carvajal",
					"Melanie Olivares",
					"Carmen Sevilla", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Quién ha recibido en tres ocasiones el Premio Nobel de la Paz?",
					"La Madre Teresa de Calcuta",
					"Mahatma Ganghi",
					"El Comité Internacional de la Cruz Roja",
					"Ninguna persona ni institución", 3));

			oss.writeObject(null);
			oss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**Método que escribe las preguntas clasificadas como difíciles en el archivo preguntasDificiles.dat
	 * 
	 */
	protected static void EscribirPreguntasDificiles() {
		try {
			FileOutputStream fos = new FileOutputStream(
					"preguntasDificiles.dat");
			ObjectOutputStream oss = new ObjectOutputStream(fos);

			oss.writeObject(new PreguntaTexto(
					"Quien dirigió la película 'El Padrino' en 1972?",
					"Roman Polanski", "Franco Zeffirelli",
					"Francis Ford Copolla", "Federico Fellini", 3));
			oss.writeObject(new PreguntaTexto(
					"El famoso cuadro 'Las tres gracias' es obra de...",
					"Velázquez", "Goya", "Rubens", "Leonardo Da Vinci", 3));
			oss.writeObject(new PreguntaTexto(
					"¿Cuántos pares de patas tienen los cangrejos?",
					"Cinco pares", "Diez pares", "Dos pares", "Tres pares", 1));
			oss.writeObject(new PreguntaTexto(
					"Omar Torrijos Herrera fue un presidente...", "Panameño",
					"Ecuatoriano", "Mexicano", "Salvadoreño", 1));
			oss.writeObject(new PreguntaTexto(
					"Equipo de Formula 1 en el que corrió Michael Schumacher entre 1996 y 2006",
					"Toyota", "Renault", "McLaren",
					"Ferrari", 4));
			oss.writeObject(new PreguntaTexto(
					"¿Qué otro nombre recibe la ley de Dalton?",
					"Ley de la conservación de la masa",
					"Ley de las proporciones múltiples",
					"Ley de las proporciones definidas",
					"Ley de los equivalentes", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Donde nació Juan Ramón Jimenez?", "Chipiona", "Moguer",
					"Sevilla", "Málaga", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Quién dirigió Casablanca, ganadora de tres premios Óscar en 1943?",
					"Billy Wilder", "Sam Wood", "John Huston",
					"Michael Curtiz", 4));
			oss.writeObject(new PreguntaTexto(
					"¿Cómo se denomina la fuente arqueológica de fotografía a larga distancia?",
					"Infradetección",
					"Teledetección",
					"Detención del yacimiento",
					"Ninguna es correcta", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Qué navegante español descubrió el Oceano Pacífico",
					"Vasco Núñez de Balboa",
					"Fernando Magallanes",
					"Juan Sebastián Elcano",
					"Cristobal Colón", 1));
			oss.writeObject(new PreguntaTexto(
					"El único director de cine que ha obtenido 4 Oscars ha sido:",
					"Elia Kazan",
					"Frank Capra",
					"John Ford",
					"William Wyler", 3));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál de estos corresponde a una verdura utilizada en la cocina china?",
					"Dim sum",
					"Chow mein",
					"Pak choi",
					"Foo yung", 3));
			oss.writeObject(new PreguntaTexto(
					"¿Qué glándula productora de hormonas se encuentra en el cerebro?",
					"Suprarrenal",
					"Pineal",
					"Tiroides",
					"Páncreas", 2));
			oss.writeObject(new PreguntaTexto(
					"¿Cuál de los siguientes no consiguió vender un solo cuadro en vida?",
					"Leonardo Da Vinci",
					"Miguel Ángel",
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
