package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ventanas.PreguntasVentana.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import clases.Jugador;

public class PerfilUsuario extends JFrame implements ActionListener {

	/**
	 * Perfil de cada usuario que pueden personalizar con una foto y ver su nombre, usuario y puntuación máxima
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver, btnCerrarSesion;
	private JLabel lblFoto;
	private JButton btnfoto;
	private JFileChooser fcExaminar;
	public static Jugador jugador = null;

	public PerfilUsuario() {

		Fondoper fondo = new Fondoper();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);

		JLabel lblNombre = new JLabel();
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Caladea", Font.PLAIN, 55));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(402, 86, 541, 117);
		fondo.add(lblNombre);

		JLabel lblUsuario = new JLabel();
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Caladea", Font.PLAIN, 55));
		lblUsuario.setBounds(402, 226, 541, 117);
		fondo.add(lblUsuario);

		JPanel pnlfoto = new JPanel();
		pnlfoto.setBounds(83, 63, 317, 308);
		fondo.add(pnlfoto);
		pnlfoto.setOpaque(false);

		this.lblFoto = new JLabel();
		this.lblFoto.setIcon(new ImageIcon(PerfilUsuario.class
				.getResource("/imagenes/perfil.png")));
		this.lblFoto.setBounds(187, 65, 128, 146);
		pnlfoto.add(lblFoto);

		this.btnfoto = new JButton("");
		btnfoto.addActionListener(this);
		this.btnfoto.setIcon(new ImageIcon(PerfilUsuario.class
				.getResource("/imagenes/editar.png")));
		this.btnfoto.setOpaque(false);
		this.btnfoto.setContentAreaFilled(false);
		this.btnfoto.setBorderPainted(false);
		this.btnfoto.setBounds(186, 224, 23, 23);
		pnlfoto.add(btnfoto);
		this.btnfoto.addActionListener(this);

		JLabel lblRecord = new JLabel();
		lblRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecord.setForeground(Color.WHITE);
		lblRecord.setFont(new Font("Caladea", Font.PLAIN, 55));
		lblRecord.setBounds(402, 392, 541, 117);
		fondo.add(lblRecord);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnVolver.setBounds(33, 652, 200, 50);
		fondo.add(btnVolver);

		btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setFont(new Font("Kristen ITC", Font.PLAIN, 35));
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBounds(804, 652, 378, 74);
		fondo.add(btnCerrarSesion);

		btnVolver.addActionListener(this);
		btnCerrarSesion.addActionListener(this);

		if (PerfilVentana.j == null) {
			lblNombre.setText("NOMBRE");
			lblUsuario.setText("USUARIO");
			lblRecord.setText("RECORD");

		} else {
			jugador = PerfilVentana.bd.obtenerJugador(
					PerfilVentana.j.getUsuario(),
					PerfilVentana.j.getContraseña());
			lblNombre.setText(jugador.getNombre());
			lblUsuario.setText(jugador.getUsuario());
			String record = Integer.toString(jugador.getPunt_max());
			lblRecord.setText(record);

		}

		this.setSize(1200, 800);
		this.setResizable(false);

		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = getSize();
		// cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);

		this.setVisible(true);
		this.fcExaminar = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(
				"Imágenes jpg, ico y png", "jpg", "png", "ico");
		this.fcExaminar.setFileFilter(filtro);
	}

	protected void eliminarVentana() {
		this.dispose();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfilUsuario f = new PerfilUsuario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnVolver) {
			new Menu();
			this.dispose();
		} else if (botonPulsado == btnCerrarSesion) {
			PerfilVentana.j = null;
			new Menu();
			this.dispose();
		} else if (botonPulsado == btnfoto) {
			int opcion = fcExaminar.showOpenDialog(null);
			if (opcion == 0) {
				String path = fcExaminar.getSelectedFile().getAbsolutePath();
				ImageIcon image = new ImageIcon(new ImageIcon(path).getImage()
						.getScaledInstance(280, 200, Image.SCALE_DEFAULT));
				this.lblFoto.setIcon(image);
			}
		}
	}

	/**
	 * @author Asier clase para ponerle un fondo a la ventana
	 */
	class Fondoper extends JPanel {

		public void paintComponent(Graphics g) {
			Dimension tamaño = getSize();
			ImageIcon imagenFondo = new ImageIcon(new ImageIcon(getClass()
					.getResource("/imagenes/fondo.png")).getImage());
			g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width,
					tamaño.height, null);

		}

	}
}
