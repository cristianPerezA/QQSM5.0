package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

import qqsm.Configuracion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Menu del juego en el que puedes acceder a la ventana de iniciar sesión o a
 * iniciar la partida
 *
 */
public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	public JLabel lblbienvenido, lblbienvenido2, lblNewLabel_1;

	public Menu() {

		FondoM fondoM = new FondoM();
		getContentPane().add(fondoM, BorderLayout.CENTER);
		fondoM.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel = new JLabel("INICIAR PARTIDA");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PreguntasVentana pv = new PreguntasVentana();
				pv.setVisible(true);
				if (PerfilUsuario.jugador != null) {
					int a = PerfilUsuario.jugador.getN_par_j();
					a++;
					PerfilUsuario.jugador.setN_par_j(a);
					PerfilVentana.bd.modificarJugadornpar(
							PerfilUsuario.jugador.getUsuario(),
							PerfilUsuario.jugador.getContraseña(), a);

				}
			}
		});
		lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setBounds(444, 215, 338, 105);
		fondoM.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("PERFIL");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (PerfilVentana.j == null) {
					PerfilVentana pv = new PerfilVentana();
					pv.setVisible(true);
					cerrarVentana();
				} else {
					PerfilUsuario pu = new PerfilUsuario();
					pu.setVisible(true);
					cerrarVentana();
				}

			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 36));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(444, 388, 327, 87);
		fondoM.add(lblNewLabel_1);

		JLabel lblSalir = new JLabel("SALIR");
		lblSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalir.setFont(new Font("Stencil", Font.PLAIN, 36));
		lblSalir.setForeground(new Color(255, 255, 255));
		lblSalir.setBounds(426, 540, 378, 87);
		fondoM.add(lblSalir);

		JButton btnHallOfFame = new JButton("HALL OF FAME");
		btnHallOfFame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HallOfFame h = new HallOfFame();
				h.setVisible(true);
				cerrarVentana();
			}
		});
		btnHallOfFame.setToolTipText("");
		btnHallOfFame.setBackground(Color.DARK_GRAY);
		btnHallOfFame.setForeground(new Color(255, 255, 0));
		btnHallOfFame.setFont(new Font("Jokerman", Font.BOLD, 34));
		btnHallOfFame.setBounds(816, 688, 378, 77);
		fondoM.add(btnHallOfFame);

		lblbienvenido = new JLabel("Bienvenido");
		lblbienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblbienvenido.setForeground(Color.WHITE);
		lblbienvenido.setFont(new Font("Maiandra GD", Font.BOLD, 55));
		lblbienvenido.setBounds(264, 39, 338, 143);
		lblbienvenido.setVisible(false);
		fondoM.add(lblbienvenido);

		lblbienvenido2 = new JLabel("");
		if (PerfilVentana.j == null) {
			lblbienvenido2.setVisible(false);
		} else {
			lblbienvenido2.setText(PerfilVentana.j.getUsuario());
		}
		lblbienvenido2.setHorizontalAlignment(SwingConstants.LEFT);
		lblbienvenido2.setForeground(Color.WHITE);
		lblbienvenido2.setFont(new Font("Maiandra GD", Font.BOLD, 60));
		lblbienvenido2.setBounds(616, 39, 338, 143);
		fondoM.add(lblbienvenido2);
		
		//TODO meter la ventana de partidas
		JButton btnPartidasJugadas = new JButton("N\u00BA partidas");
		btnPartidasJugadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaMostrarUsuarios u = new ventanaMostrarUsuarios();
				u.setVisible(true);
				cerrarVentana();
			}
		});
		btnPartidasJugadas.setBounds(30, 688, 190, 52);
		fondoM.add(btnPartidasJugadas);

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

	public void cerrarVentana() {
		this.dispose();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu f = new Menu();

	}
}

// Fondo menu
class FondoM extends JPanel {

	public void paintComponent(Graphics g) {
		Dimension tamaño = getSize();
		ImageIcon imagenFondo = new ImageIcon(new ImageIcon(getClass()
				.getResource("/imagenes/menu.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height,
				null);

	}

}
