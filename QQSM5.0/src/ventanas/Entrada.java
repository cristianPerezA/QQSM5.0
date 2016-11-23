package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ventanas.PreguntasVentana.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class Entrada extends JFrame implements Runnable {

	/**
	 * Ventana de entrada al juego, solo cuenta con un hilo para el audio
	 * inicial y un botón para pasar a la siguiente ventana
	 */
	private static final long serialVersionUID = 1L;

	private JButton bEntrar;
	public boolean sonando = true;

	public Entrada() {

		Thread hilo = new Thread(this);
		hilo.start();
		FondoE fondo = new FondoE();
		getContentPane().add(fondo, BorderLayout.CENTER);

		fondo.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bEntrar = new JButton("ENTRAR");
		bEntrar.setForeground(new Color(0, 51, 204));
		bEntrar.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 42));
		bEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bEntrar.setBackground(new Color(255, 255, 255));
		bEntrar.setBounds(475, 607, 260, 61);
		bEntrar.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Menu menu = new Menu();
				menu.setVisible(true);
				eliminarVentana();
			}
		});
		fondo.add(bEntrar);

		JButton btnmusica = new JButton("");
		btnmusica.setForeground(new Color(0, 255, 255));
		btnmusica.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (sonando) {
					hilo.suspend();
					;
					btnmusica.setIcon(new ImageIcon(Entrada.class
							.getResource("/imagenes/turnon.png")));
					sonando = false;
				} else if (!sonando) {
					hilo.resume();
					btnmusica.setIcon(new ImageIcon(Entrada.class
							.getResource("/imagenes/turnoff.png")));
					sonando = true;
				}

			}
		});
		btnmusica.setIcon(new ImageIcon(Entrada.class
				.getResource("/imagenes/turnoff.png")));
		btnmusica.setBounds(1107, 705, 44, 35);
		fondo.add(btnmusica);
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

	protected void eliminarVentana() {
		this.dispose();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Entrada f = new Entrada();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run() Método que introduce el sonido en la
	 * ventana
	 */
	@Override
	public void run() {
		int EXTERNAL_BUFFER_SIZE = 524288;
		String filename = "./musica/intro.wav";
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

/**
 * clase para ponerle un fondo a la ventana
 */
class FondoE extends JPanel {

	public void paintComponent(Graphics g) {
		Dimension tamaño = getSize();
		ImageIcon imagenFondo = new ImageIcon(new ImageIcon(getClass()
				.getResource("/imagenes/fondo2.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height,
				null);

	}

}
