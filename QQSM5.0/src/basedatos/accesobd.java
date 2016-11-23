package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import clases.Jugador;
import preguntas.Pregunta;
import preguntas.PreguntaImagen;

/**
 * Clase con la que se genera la conexion con la base de datos y la desconexion.
 */

public class accesobd {

	private Connection connection;
	private Statement stmt;

	public accesobd() {

	}

	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:BDQQSM.db");
			crearSentencia();
		} catch (Exception e) {
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}

	public void desconectar() {
		try {
			cerrarSentencia();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void crearSentencia() {
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cerrarSentencia() {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertarJugador(String n, String u, String c) {
		String s = "INSERT INTO jugador (nombre, usuario, contraseña, punt_max,n_par_j) VALUES ('"
				+ n + "','" + u + "','" + c + "',0,0 )";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void eliminarJugador(String n, String u, String c) {
		String s = "DELETE FROM Matricula WHERE nombre='" + n
				+ "' AND usuario='" + u + "' AND contraseña='" + c + "'";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			System.out.println("no se ha podido eliminar el jugador");
		}
	}

	public boolean existeJugador(String u, String cont) {
		String s = "SELECT * FROM jugador WHERE usuario='" + u
				+ "' AND contraseña='" + cont + "'";
		ResultSet rs;
		boolean existe = false;

		try {
			rs = stmt.executeQuery(s);
			if (rs.next()) 
				existe = true;
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
		}
		return existe;
	}

	public Jugador obtenerJugador(String u, String c) {
		Jugador p = null;

		String s = "SELECT * FROM jugador WHERE usuario='" + u
				+ "' AND contraseña='" + c + "'";

		try {
			ResultSet rs = stmt.executeQuery(s);
			if (rs.next()) {
				p = new Jugador(rs.getString("nombre"),
						rs.getString("usuario"), rs.getString("contraseña"),
						rs.getInt("punt_Max"), rs.getInt("n_par_j"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public int obteneridJugador(String u, String c) {
		int a = 0;

		String s = "SELECT id_user FROM jugador WHERE usuario='" + u
				+ "' AND contraseña='" + c + "'";

		try {
			ResultSet rs = stmt.executeQuery(s);
			if (rs.next()) {
				a = new Integer(rs.getInt("id_user"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public void modificarJugador(String u, String c, int punt_max) {
		String s = "UPDATE jugador SET punt_max=" + punt_max
				+ " WHERE usuario='" + u + "' AND contraseña='" + c + "'";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modificarJugadornpar(String u, String c, int n_par_j) {
		String s = "UPDATE jugador SET n_par_j=" + n_par_j + " WHERE usuario='"
				+ u + "' AND contraseña='" + c + "'";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertarPartida(String n, String u, String c) {
		String s = "INSERT INTO jugador (nombre, usuario, contraseña, punt_max,n_par_j) VALUES ('"
				+ n + "','" + u + "','" + c + "',0,0 )";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void insertarPregunta(String p, String res1, String res2,
			String res3, String res4, int posresc, String img, int nivel) {
		String s = "INSERT INTO pregunta ( pregunta, res1, res2, res3, res4, posRespC, imagen, nivel) VALUES ('"
				+ p
				+ "','"
				+ res1
				+ "','"
				+ res2
				+ "','"
				+ res3
				+ "','"
				+ res4
				+ "'," + posresc + ",'" + img + "'," + nivel + " )";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public Pregunta obtenerPregunta(String p) {
		Pregunta a = null;

		String s = "SELECT * FROM pregunta WHERE pregunta='" + p + "'";

		try {
			ResultSet rs = stmt.executeQuery(s);
			if (rs.next()) {
				if (rs.getString("imagen").equals("src/imagenespreguntas/"))
					a = new Pregunta(rs.getString("pregunta"),
							rs.getString("res1"), rs.getString("res2"),
							rs.getString("res3"), rs.getString("res4"),
							rs.getInt("posRespC"));
				else
					a = new PreguntaImagen(rs.getString("pregunta"),
							rs.getString("res1"), rs.getString("res2"),
							rs.getString("res3"), rs.getString("res4"),
							rs.getInt("posRespC"), rs.getString("imagen"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public PreguntaImagen obtenerPreguntaImagen(String p) {
		PreguntaImagen a = null;

		String s = "SELECT * FROM pregunta WHERE pregunta='" + p + "'";

		try {
			ResultSet rs = stmt.executeQuery(s);
			if (rs.next()) {
				a = new PreguntaImagen(rs.getString("pregunta"),
						rs.getString("res1"), rs.getString("res2"),
						rs.getString("res3"), rs.getString("res4"),
						rs.getInt("posRespC"), rs.getString("imagen"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public boolean existePregunta(String p, int nivel) {
		String s = "SELECT * FROM pregunta WHERE pregunta='" + p
				+ "' AND nivel=" + nivel;
		ResultSet rs;
		boolean existe = false;

		try {
			rs = stmt.executeQuery(s);
			if (rs.next()) 
				existe = true;
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return existe;
	}

	public void eliminarPregunta(String p, int nivel) {
		String s = "DELETE FROM pregunta WHERE pregunta='" + p + "' AND nivel="
				+ nivel;
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			System.out.println("no se ha podido eliminar la pregunta");
		}
	}

	public void nuevaPartida() {
		String s = "INSERT INTO partida () VALUES ('" + "','" + "',')";
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void modificarPregunta(Pregunta p, int id) {
		String s = "UPDATE pregunta SET pregunta='" + p.getTextoPregunta()
				+ "',res1='" + p.getRes1() + "',res2='" + p.getRes2()
				+ "',res3='" + p.getRes3() + "',res4='" + p.getRes4()
				+ "' WHERE id_preg=" + id;
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LinkedList<Jugador> obtenerJugadoresUnMillon() {
		String s = "SELECT * FROM jugador WHERE punt_max=1000000";
		LinkedList<Jugador> lJugadores = new LinkedList<Jugador>();
		int cont = 0;
		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next() && cont < 10) {
				Jugador j = new Jugador(rs.getString("nombre"),
						rs.getString("usuario"), rs.getString("contraseña"),
						rs.getInt("punt_max"), rs.getInt("n_par_j"));
				lJugadores.add(j);
				cont++;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lJugadores;
	}

	public LinkedList<Pregunta> obtenerPreguntas() {
		LinkedList<Pregunta> lPreguntas = new LinkedList<Pregunta>();

		String s = "SELECT * FROM pregunta";
		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {

				String pregunta = rs.getString("pregunta");
				String res1 = rs.getString("res1");
				String res2 = rs.getString("res2");
				String res3 = rs.getString("res3");
				String res4 = rs.getString("res4");
				int posRespC = rs.getInt("posRespC");
				String img = rs.getString("imagen");
				if (img.equals("src/imagenespreguntas/")) {
					lPreguntas.add(new Pregunta(pregunta, res1, res2, res3,
							res4, posRespC));
				} else {
					lPreguntas.add(new PreguntaImagen(pregunta, res1, res2,
							res3, res4, posRespC, img));
				}

			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lPreguntas;
	}

	public LinkedList<Jugador> obtenerJugadores() {
		String s = "SELECT * FROM jugador";
		LinkedList<Jugador> ljugadores = new LinkedList<Jugador>();

		try {
			ResultSet rs = stmt.executeQuery(s);
			while (rs.next()) {
				Jugador j = new Jugador(rs.getString("nombre"),
						rs.getString("usuario"), rs.getInt("punt_max"),
						rs.getInt("n_par_j"));
				ljugadores.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ljugadores;
	}

	public void acatualizarPuntuacionJugador(int puntos, int id) {
		String s = "UODATE punt_max=punt_max+" + puntos + " WHERE id_user="
				+ id;
		try {
			stmt.executeUpdate(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
