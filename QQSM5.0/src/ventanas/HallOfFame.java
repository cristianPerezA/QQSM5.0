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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ventanas.PreguntasVentana.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import clases.Jugador;
import basedatos.accesobd;

public class HallOfFame extends JFrame implements ActionListener {

	/**
	 * Hall of Fame del juego en el que se muestran los jugadores que han
	 * obtenido una puntuación máxima igual al millón de euros
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JTable tablaJ;
	private DefaultTableModel dtmJ;
	private LinkedList<Jugador> lJugadores;
	private accesobd bd;
	private JScrollPane scrollTabla;
	private JPanel panelSur;
	private JPanel panel;

	public HallOfFame() {

		FondoH fondo = new FondoH();
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(new BorderLayout());

		bd = new accesobd();
		bd.conectar();
		lJugadores = bd.obtenerJugadoresUnMillon();
		tablaJ = new JTable(new DefaultTableModel());
		dtmJ = (DefaultTableModel) tablaJ.getModel();
		tablaJ.setModel(dtmJ);
		tablaJ.setEnabled(false);
		tablaJ.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		String titulos[] = { "USUARIO", "PUNTOS" };
		for (int i = 0; i < titulos.length; i++) {
			dtmJ.addColumn(titulos[i]);
		}
		for (int i = 0; i < lJugadores.size(); i++) {
			Jugador j = lJugadores.get(i);
			String fila[] = { j.getUsuario(), String.valueOf(j.getPunt_max()) };
			dtmJ.addRow(fila);
		}
		TableColumnModel columnModel = tablaJ.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setPreferredWidth(350);
		}

		JLabel lblHallOfFame = new JLabel("HALL OF FAME");
		lblHallOfFame.setHorizontalAlignment(SwingConstants.CENTER);
		lblHallOfFame.setFont(new Font("Lucida Handwriting", Font.PLAIN, 75));
		lblHallOfFame.setForeground(Color.YELLOW);
		lblHallOfFame.setBounds(131, 13, 968, 139);
		fondo.add("North", lblHallOfFame);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 800);
		this.setResizable(false);

		panelSur = new JPanel();
		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnVolver.setBounds(33, 652, 200, 50);
		panelSur.add(btnVolver);
		panelSur.setOpaque(false);
		fondo.add("South", panelSur);

		panel = new JPanel();
		fondo.add("Center", panel);
		panel.setLayout(null);

		scrollTabla = new JScrollPane(tablaJ);
		scrollTabla.setBounds(278, 68, 703, 183);
		panel.add(scrollTabla);
		panel.setOpaque(false);
		btnVolver.addActionListener(this);

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
		HallOfFame f = new HallOfFame();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnVolver) {
			new Menu();
			this.dispose();
		}
	}

}

/**
 * @author Asier clase para ponerle un fondo a la ventana
 */
class FondoH extends JPanel {

	public void paintComponent(Graphics g) {
		Dimension tamaño = getSize();
		ImageIcon imagenFondo = new ImageIcon(new ImageIcon(getClass()
				.getResource("/imagenes/fondo2.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height,
				null);

	}

}
