package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import preguntas.PreguntaImagen;
import preguntas.PreguntaTexto;
import preguntas.Utilidades;
import qqsm.Configuracion;
import ventanas.PreguntasVentana.Position;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import org.jfree.ui.RefineryUtilities;

import comodines.C50porciento;
import comodines.CPublico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Ventana del juego en el que sucede toda la dinámica (hilos de sonidos, cambio de preguntas,...)
 */
public class PreguntasVentana extends JFrame implements Runnable {

	int numPregunta = 0;
	private static final long serialVersionUID = 1L;
	private JLabel lblPregunta, lblRespuesta1, lblRespuesta2, lblRespuesta3,
			lblRespuesta4, lblFondoRespuesta1, lblFondoRespuesta2,
			lblFondoRespuesta3, lblFondoRespuesta4, ldinero, labelImagen;
	private boolean haySeleccionada;

	public PreguntasVentana() {

		Thread hilo = new Thread(this);
		hilo.start();
		haySeleccionada = false;
		cargarConfiguracionJuego();
		getContentPane().setLayout(null);
		FondoP fondoP = new FondoP();
		fondoP.setBounds(0, 0, 1194, 765);
		getContentPane().add(fondoP);
		fondoP.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblFondoRespuesta1 = new JLabel("");
		lblFondoRespuesta1.setBounds(12, 462, 582, 136);
		lblFondoRespuesta1.setVisible(false);

		lblFondoRespuesta2 = new JLabel("");
		lblFondoRespuesta2.setBounds(598, 462, 563, 136);
		lblFondoRespuesta2.setVisible(false);

		lblFondoRespuesta3 = new JLabel("");
		lblFondoRespuesta3.setBounds(12, 616, 593, 136);
		lblFondoRespuesta3.setVisible(false);

		lblFondoRespuesta4 = new JLabel("");
		lblFondoRespuesta4.setBounds(598, 616, 563, 136);
		lblFondoRespuesta4.setVisible(false);

		JLabel c50 = new JLabel("");
		c50.setBounds(12, 13, 70, 58);
		c50.setIcon(new ImageIcon(PreguntasVentana.class
				.getResource("/imagenes/cincuentaporciento.png")));
		c50.setVisible(true);
		c50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				c50.setVisible(false);
				Random r = new Random();
				int n = r.nextInt(4) + 1;
				while (n == Configuracion.preguntasPartida[numPregunta]
						.getPosRespC()) {
					n = r.nextInt(4) + 1;
				}
				String resE = Configuracion.respuestaX(n,
						Configuracion.preguntasPartida[numPregunta]);
				String resC = Configuracion.preguntasPartida[numPregunta]
						.getResC();
				if (lblRespuesta1.getText().equals(resE)
						|| lblRespuesta1.getText().equals(resC)) {
					lblRespuesta1.setVisible(true);
				} else {
					lblRespuesta1.setVisible(false);
				}
				if (lblRespuesta2.getText().equals(resE)
						|| lblRespuesta2.getText().equals(resC)) {
					lblRespuesta2.setVisible(true);
				} else {
					lblRespuesta2.setVisible(false);
				}
				if (lblRespuesta3.getText().equals(resE)
						|| lblRespuesta3.getText().equals(resC)) {
					lblRespuesta3.setVisible(true);
				} else {
					lblRespuesta3.setVisible(false);
				}
				if (lblRespuesta4.getText().equals(resE)
						|| lblRespuesta4.getText().equals(resC)) {
					lblRespuesta4.setVisible(true);
				} else {
					lblRespuesta4.setVisible(false);
				}
			}
		});

		JLabel cpublico = new JLabel("");
		cpublico.setBounds(94, 13, 72, 58);
		cpublico.setIcon(new ImageIcon(PreguntasVentana.class
				.getResource("/imagenes/publico.png")));
		cpublico.setVisible(true);
		cpublico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				cpublico.setVisible(false);
				CPublico p = new CPublico(false);
				p.porcentajes();

				int a = 0;
				int b = 0;
				int c = 0;
				int d = 0;
				String res1=Configuracion.preguntasPartida[numPregunta].getRes1();
				String res2=Configuracion.preguntasPartida[numPregunta].getRes2();
				String res3=Configuracion.preguntasPartida[numPregunta].getRes3();
				String res4=Configuracion.preguntasPartida[numPregunta].getRes4();

				if (Configuracion.preguntasPartida[numPregunta].getPosRespC() == 1) {
					a = p.a;
					c = p.b;
					b = p.d;
					d = p.c;
				} else if (Configuracion.preguntasPartida[numPregunta]
						.getPosRespC() == 2) {
					b = p.a;
					a = p.d;
					c = p.c;
					d = p.b;
				} else if (Configuracion.preguntasPartida[numPregunta]
						.getPosRespC() == 3) {
					c = p.a;
					a = p.b;
					b = p.d;
					d = p.c;
				} else if (Configuracion.preguntasPartida[numPregunta]
						.getPosRespC() == 4) {
					d = p.a;
					b = p.c;
					a = p.b;
					c = p.d;
				}
				// Random k = new Random();
				// int n = k.nextInt(4) + 1;
				// while
				// (n==Configuracion.preguntasPartida[numPregunta].getPosRespC()){
				// n=k.nextInt(4)+1;
				// }
				// String res1= Configuracion.respuestaX(n,
				// Configuracion.preguntasPartida[numPregunta]);
				// Random l = new Random();
				// int m = l.nextInt(4) + 1;
				// while
				// (m==Configuracion.preguntasPartida[numPregunta].getPosRespC()||
				// m==n){
				// m=l.nextInt(4)+1;
				// }
				// String res2= Configuracion.respuestaX(m,
				// Configuracion.preguntasPartida[numPregunta]);
				// Random g = new Random();
				// int o = g.nextInt(4) + 1;
				// while
				// (o==Configuracion.preguntasPartida[numPregunta].getPosRespC()||o==m||o==n){
				// o=g.nextInt(4)+1;
				// }
				// String res3= Configuracion.respuestaX(o,
				// Configuracion.preguntasPartida[numPregunta]);

				GraficoPublico demo = new GraficoPublico("COMODIN DEL PUBLICO",
						a, b, d, c,res1,res2,res3,res4);
				demo.pack();
				RefineryUtilities.centerFrameOnScreen(demo);
				demo.setVisible(true);

				// JOptionPane.showMessageDialog (null,
				// "Resultados de la votación del público: \n"+Configuracion.preguntasPartida[numPregunta].getResC()
				// +" "+ p.a+"%\n"+
				// res1+ " "+p.b+"%\n"+
				// res2+ " "+p.d+"%\n"+
				// res3+" "+p.c+"%", "Comodín del público",
				// JOptionPane.INFORMATION_MESSAGE);
				//
			}
		});

		JLabel cllamada = new JLabel("");
		cllamada.setBounds(178, 13, 72, 58);
		cllamada.setIcon(new ImageIcon(PreguntasVentana.class
				.getResource("/imagenes/telefono.png")));
		cllamada.setVisible(true);
		cllamada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				cllamada.setVisible(false);
				String nombre = javax.swing.JOptionPane
						.showInputDialog("Introduce el nombre de persona a llamar");
				String numero = javax.swing.JOptionPane
						.showInputDialog("Introduce el numero de telefono:");
				Random w = new Random();
				int n = w.nextInt(4) + 1;
				while (n == Configuracion.preguntasPartida[numPregunta]
						.getPosRespC()) {
					n = w.nextInt(4) + 1;
				}
				String resE = Configuracion.respuestaX(n,
						Configuracion.preguntasPartida[numPregunta]);
				String resC = Configuracion.preguntasPartida[numPregunta]
						.getResC();
				JOptionPane.showMessageDialog(null, "Hola " + ", "
						+ "yo creo que la respuesta correcta es " + resC
						+ " aunque no descartaría del todo " + resE
						+ ". Espero haberte podido ayudar, mucha suerte! ");
			}
		});

		lblPregunta = new JLabel("Pregunta");
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPregunta.setFont(new Font("Maiandra GD", Font.PLAIN, 32));
		lblPregunta.setForeground(Color.WHITE);
		lblPregunta.setBounds(44, 251, 1117, 167);
		fondoP.add(lblPregunta);
		lblRespuesta1 = new JLabel("Respuesta1");
		lblRespuesta1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (!haySeleccionada) {
					Hilo1 hilo = new Hilo1();
					hilo.start();
					Hilo3 hilo3 = new Hilo3();
					hilo3.start();
					haySeleccionada = true;
					lblFondoRespuesta1.setIcon(new ImageIcon(
							PreguntasVentana.class
									.getResource("/imagenes/resSeleccionada.png")));
					lblFondoRespuesta1.setVisible(true);

					if (lblRespuesta1.getText().equals(
							Configuracion.preguntasPartida[numPregunta]
									.getResC())) {

						Thread hiloEspera = new Thread(new Runnable() {

							@Override
							public void run() {

								try {
									Thread.sleep(5000);
									Hilo4 hilo4 = new Hilo4();
									hilo4.start();
									lblFondoRespuesta1.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resCorrecta.png")));
									Thread.sleep(2000);
									cambioPregunta();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();
					} else {
						Thread hiloEspera = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(5000);
									Hilo2 hilo2 = new Hilo2();
									hilo2.start();
									lblFondoRespuesta1.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resincorrecta.png")));
									Thread.sleep(2000);
									mostrarRespuestaCorrecta();
									Thread.sleep(3000);
									dispose();
									if (PerfilUsuario.jugador!=null) {
										int a=PerfilUsuario.jugador.getPunt_max();
										int b=Configuracion.euros[numPregunta];
										if (a<b) {
											PerfilUsuario.jugador.setPunt_max(b);
											PerfilVentana.bd.modificarJugador(PerfilUsuario.jugador.getUsuario(), PerfilUsuario.jugador.getContraseña(), b);
										}
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();
					}
				}
			}
		});
		lblRespuesta1.setFont(new Font("Corbel", Font.PLAIN, 25));
		lblRespuesta1.setBounds(78, 494, 447, 67);
		fondoP.add(lblRespuesta1);
		lblRespuesta3 = new JLabel("New label");
		lblRespuesta3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (!haySeleccionada) {
					Hilo1 hilo = new Hilo1();
					hilo.start();
					Hilo3 hilo3 = new Hilo3();
					hilo3.start();
					haySeleccionada = true;
					lblFondoRespuesta3.setIcon(new ImageIcon(
							PreguntasVentana.class
									.getResource("/imagenes/resSeleccionada.png")));
					lblFondoRespuesta3.setVisible(true);

					if (lblRespuesta3.getText().equals(
							Configuracion.preguntasPartida[numPregunta]
									.getResC())) {
						Thread hiloEspera = new Thread(new Runnable() {
							@Override
							public void run() {
								try {

									Thread.sleep(5000);
									Hilo4 hilo4 = new Hilo4();
									hilo4.start();
									lblFondoRespuesta3.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resCorrecta.png")));
									Thread.sleep(2000);
									cambioPregunta();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();

					} else {
						Thread hiloEspera = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(5000);
									Hilo2 hilo2 = new Hilo2();
									hilo2.start();
									lblFondoRespuesta3.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resincorrecta.png")));
									Thread.sleep(2000);
									mostrarRespuestaCorrecta();
									Thread.sleep(3000);
									dispose();
									if (PerfilUsuario.jugador!=null) {
										int a=PerfilUsuario.jugador.getPunt_max();
										int b=Configuracion.euros[numPregunta];
										if (a<b) {
											PerfilUsuario.jugador.setPunt_max(b);
											PerfilVentana.bd.modificarJugador(PerfilUsuario.jugador.getUsuario(), PerfilUsuario.jugador.getContraseña(), b);
										}
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();
					}
				}
			}
		});
		lblRespuesta3.setFont(new Font("Corbel", Font.PLAIN, 25));
		lblRespuesta3.setBounds(78, 657, 442, 58);
		fondoP.add(lblRespuesta3);

		lblRespuesta4 = new JLabel("New label");
		lblRespuesta4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (!haySeleccionada) {
					Hilo1 hilo = new Hilo1();
					hilo.start();
					Hilo3 hilo3 = new Hilo3();
					hilo3.start();
					lblFondoRespuesta4.setVisible(true);
					lblFondoRespuesta4.setIcon(new ImageIcon(
							PreguntasVentana.class
									.getResource("/imagenes/resSeleccionada.png")));

					haySeleccionada = true;

					if (lblRespuesta4.getText().equals(
							Configuracion.preguntasPartida[numPregunta]
									.getResC())) {

						Thread hiloEspera = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(5000);
									Hilo4 hilo4 = new Hilo4();
									hilo4.start();
									lblFondoRespuesta4.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resCorrecta.png")));
									Thread.sleep(2000);
									cambioPregunta();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();

					} else {
						Thread hiloEspera = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(5000);
									Hilo2 hilo2 = new Hilo2();
									hilo2.start();
									lblFondoRespuesta4.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resincorrecta.png")));
									Thread.sleep(2000);
									mostrarRespuestaCorrecta();
									Thread.sleep(3000);
									dispose();
									if (PerfilUsuario.jugador!=null) {
										int a=PerfilUsuario.jugador.getPunt_max();
										int b=Configuracion.euros[numPregunta];
										if (a<b) {
											PerfilUsuario.jugador.setPunt_max(b);
											PerfilVentana.bd.modificarJugador(PerfilUsuario.jugador.getUsuario(), PerfilUsuario.jugador.getContraseña(), b);
										}
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();
					}
				}
			}
		});
		lblRespuesta4.setFont(new Font("Corbel", Font.PLAIN, 25));
		lblRespuesta4.setBounds(662, 648, 453, 67);
		fondoP.add(lblRespuesta4);

		lblRespuesta2 = new JLabel("New label");
		lblRespuesta2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (!haySeleccionada) {
					Hilo1 hilo = new Hilo1();
					hilo.start();
					Hilo3 hilo3 = new Hilo3();
					hilo3.start();

					haySeleccionada = true;
					lblFondoRespuesta2.setIcon(new ImageIcon(
							PreguntasVentana.class
									.getResource("/imagenes/resSeleccionada.png")));
					lblFondoRespuesta2.setVisible(true);

					if (lblRespuesta2.getText().equals(
							Configuracion.preguntasPartida[numPregunta]
									.getResC())) {

						Thread hiloEspera = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(5000);
									Hilo4 hilo4 = new Hilo4();
									hilo4.start();
									lblFondoRespuesta2.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resCorrecta.png")));
									Thread.sleep(2000);
									cambioPregunta();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();

					} else {
						Thread hiloEspera = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									Thread.sleep(5000);
									Hilo2 hilo2 = new Hilo2();
									hilo2.start();
									lblFondoRespuesta2.setIcon(new ImageIcon(
											PreguntasVentana.class
													.getResource("/imagenes/resincorrecta.png")));
									Thread.sleep(2000);
									mostrarRespuestaCorrecta();
									Thread.sleep(3000);
									dispose();
									if (PerfilUsuario.jugador!=null) {
										int a=PerfilUsuario.jugador.getPunt_max();
										int b=Configuracion.euros[numPregunta];
										if (a<b) {
											PerfilUsuario.jugador.setPunt_max(b);
											PerfilVentana.bd.modificarJugador(PerfilUsuario.jugador.getUsuario(), PerfilUsuario.jugador.getContraseña(), b);
										}
									}
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
						hiloEspera.start();

					}
				}
			}
		});
		lblRespuesta2.setFont(new Font("Corbel", Font.PLAIN, 25));
		lblRespuesta2.setBounds(662, 494, 453, 67);
		fondoP.add(lblRespuesta2);

		ldinero = new JLabel("");
		ldinero.setForeground(Color.YELLOW);
		ldinero.setFont(new Font("Stencil", Font.PLAIN, 60));
		ldinero.setHorizontalAlignment(SwingConstants.CENTER);
		ldinero.setBounds(835, 55, 331, 136);

		fondoP.add(lblFondoRespuesta1);
		fondoP.add(lblFondoRespuesta2);
		fondoP.add(lblFondoRespuesta3);
		fondoP.add(lblFondoRespuesta4);
		fondoP.add(c50);
		fondoP.add(cpublico);
		fondoP.add(cllamada);
		fondoP.add(ldinero);

		// //////////////imagenDePreguntas
		labelImagen = new JLabel("");
		labelImagen.setBounds(366, 13, 502, 200);
		fondoP.add(labelImagen);

		cargarPregunta();
		this.setSize(1200, 800);
		this.setResizable(false);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = getSize();
		// cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);

		this.setVisible(true);
	}

	private void cargarPregunta() {
		Configuracion conf = new Configuracion();
		if (Configuracion.preguntasPartida[numPregunta] instanceof PreguntaTexto) {
			labelImagen.setVisible(false);
		}
		if (Configuracion.preguntasPartida[numPregunta] instanceof PreguntaImagen) {
			labelImagen.setVisible(true);
			labelImagen.setIcon(new ImageIcon(
					((PreguntaImagen) conf.preguntasPartida[numPregunta])
							.getImagen()));
		}
		lblPregunta.setText(Configuracion.preguntasPartida[numPregunta]
				.getTextoPregunta());
		lblRespuesta1.setText(Configuracion.preguntasPartida[numPregunta]
				.getRes1());
		lblRespuesta2.setText(Configuracion.preguntasPartida[numPregunta]
				.getRes2());
		lblRespuesta3.setText(Configuracion.preguntasPartida[numPregunta]
				.getRes3());
		lblRespuesta4.setText(Configuracion.preguntasPartida[numPregunta]
				.getRes4());
		int euros = Configuracion.euros[numPregunta];
		String scadena = "";
		scadena = String.valueOf(euros);
		scadena = Integer.toString(euros) + "€";
		ldinero.setText(scadena);
	}

	private void cargarConfiguracionJuego() {
		Configuracion.init();
		Configuracion.LeerPreguntasFdeBD();
		Configuracion.LeerFicheroPreguntasM();
		Configuracion.LeerFicheroPreguntasD();
		Configuracion.elegirPreguntas();
	}

	private void cambioPregunta() {

		haySeleccionada = false;
		numPregunta++;
		if (numPregunta == 5 || numPregunta == 10) {
			String[] options = new String[] { "Seguir jugando",
					"Prefiero plantarme" };
			if (JOptionPane.showConfirmDialog(this, "¿Sequir jugando?",
					"¿Qué desea hacer?", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.NO_OPTION) {
				this.dispose();
			}
		}
		if (numPregunta == 15) {
			this.dispose();
			Premio p = new Premio();
		}
		labelImagen.setVisible(false);
		lblFondoRespuesta1.setVisible(false);
		lblFondoRespuesta2.setVisible(false);
		lblFondoRespuesta3.setVisible(false);
		lblFondoRespuesta4.setVisible(false);
		lblRespuesta1.setVisible(true);
		lblRespuesta2.setVisible(true);
		lblRespuesta3.setVisible(true);
		lblRespuesta4.setVisible(true);

		cargarPregunta();
		Thread hilo = new Thread(this);
		hilo.start();
	}

	private void mostrarRespuestaCorrecta() {
		String resC = Configuracion.preguntasPartida[numPregunta].getResC();
		if (resC.equals(lblRespuesta1.getText())) {
			lblFondoRespuesta1.setIcon(new ImageIcon(PreguntasVentana.class
					.getResource("/imagenes/resCorrecta.png")));
			lblFondoRespuesta1.setVisible(true);
		}
		if (resC.equals(lblRespuesta2.getText())) {
			lblFondoRespuesta2.setIcon(new ImageIcon(PreguntasVentana.class
					.getResource("/imagenes/resCorrecta.png")));
			lblFondoRespuesta2.setVisible(true);
		}
		if (resC.equals(lblRespuesta3.getText())) {
			lblFondoRespuesta3.setIcon(new ImageIcon(PreguntasVentana.class
					.getResource("/imagenes/resCorrecta.png")));
			lblFondoRespuesta3.setVisible(true);
		}
		if (resC.equals(lblRespuesta4.getText())) {
			lblFondoRespuesta4.setIcon(new ImageIcon(PreguntasVentana.class
					.getResource("/imagenes/resCorrecta.png")));
			lblFondoRespuesta4.setVisible(true);
		}

	}

	public static void main(String[] args) {
		PreguntasVentana f = new PreguntasVentana();
	}

	enum Position {
		LEFT, RIGHT, NORMAL
	};

	@Override
	public void run() {
		int EXTERNAL_BUFFER_SIZE = 524288;
		String filename = "./musica/pregunta.wav";
		Position curPosition = Position.NORMAL;
		File soundFile = new File(filename);
		if (!soundFile.exists()) {
			System.err.println("Wave file not found: " + filename);
			return;
		}
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline
					.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT)
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT)
				pan.setValue(-1.0f);
		}
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
}

class Hilo1 extends Thread {

	public void run() {
		int EXTERNAL_BUFFER_SIZE = 524288;
		String filename = "./musica/seleccionada.wav";
		Position curPosition = Position.NORMAL;
		File soundFile = new File(filename);
		if (!soundFile.exists()) {
			System.err.println("Wave file not found: " + filename);
			return;
		}
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline
					.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT)
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT)
				pan.setValue(-1.0f);
		}
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
}

class Hilo2 extends Thread {

	public void run() {
		int EXTERNAL_BUFFER_SIZE = 524288;
		String filename = "./musica/fallo.wav";
		Position curPosition = Position.NORMAL;
		File soundFile = new File(filename);
		if (!soundFile.exists()) {
			System.err.println("Wave file not found: " + filename);
			return;
		}
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline
					.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT)
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT)
				pan.setValue(-1.0f);
		}
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
}

class Hilo3 extends Thread {

	public void run() {
		int EXTERNAL_BUFFER_SIZE = 524288;
		String filename = "./musica/tension.wav";
		Position curPosition = Position.NORMAL;
		File soundFile = new File(filename);
		if (!soundFile.exists()) {
			System.err.println("Wave file not found: " + filename);
			return;
		}
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline
					.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT)
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT)
				pan.setValue(-1.0f);
		}
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
}

class Hilo4 extends Thread {

	public void run() {
		int EXTERNAL_BUFFER_SIZE = 524288;
		String filename = "./musica/acierto.wav";
		Position curPosition = Position.NORMAL;
		File soundFile = new File(filename);
		if (!soundFile.exists()) {
			System.err.println("Wave file not found: " + filename);
			return;
		}
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		if (auline.isControlSupported(FloatControl.Type.PAN)) {
			FloatControl pan = (FloatControl) auline
					.getControl(FloatControl.Type.PAN);
			if (curPosition == Position.RIGHT)
				pan.setValue(1.0f);
			else if (curPosition == Position.LEFT)
				pan.setValue(-1.0f);
		}
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
	}
}

class FondoP extends JPanel {

	public void paintComponent(Graphics g) {
		Dimension tamaño = getSize();
		ImageIcon imagenFondo = new ImageIcon(new ImageIcon(getClass()
				.getResource("/imagenes/panel.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height,
				null);
	}
}
