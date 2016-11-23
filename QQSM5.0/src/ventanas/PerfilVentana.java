package ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

import clases.Jugador;
import basedatos.accesobd;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Ventana para iniciar sesión que también permite crear una cuenta
 *
 */
public class PerfilVentana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField usuario;
	private JTextField contraseña;
	public static Jugador perfilJugador;
	private JButton btnRegistrarse, btnVolver, btnIniciarSesin;
	private JTextPane textPnombre;
	private JLabel lblNombre;

	public static accesobd bd;
	public static String contraseñaa;
	public static Jugador j = null;

	public PerfilVentana() {
		perfilJugador = new Jugador();
		bd = new accesobd();
		bd.conectar();

		FondoPerfil FondoPerfil = new FondoPerfil();
		FondoPerfil.setLayout(null);
		getContentPane().add(FondoPerfil, BorderLayout.CENTER);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(187, 139, 236, 100);
		FondoPerfil.add(lblUsuario);

		JLabel lblNewLabel = new JLabel("CONTRASE\u00D1A");
		lblNewLabel.setFont(new Font("Century", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(166, 251, 329, 121);
		FondoPerfil.add(lblNewLabel);

		usuario = new JTextField();
		usuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usuario.setForeground(Color.BLACK);
		usuario.setBounds(519, 182, 249, 32);

		FondoPerfil.add(usuario);

		contraseña = new JPasswordField();
		contraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contraseña.setBounds(519, 304, 249, 32);
		KeyListener keylistener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnIniciarSesin.doClick();
				}
			}
		};
		contraseña.addKeyListener(keylistener);
		FondoPerfil.add(contraseña);

		btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesin.setBackground(Color.GRAY);
		btnIniciarSesin.setForeground(Color.WHITE);
		btnIniciarSesin.addActionListener(this);
		btnIniciarSesin.setFont(new Font("Yu Gothic Light", Font.PLAIN, 23));
		btnIniciarSesin.setBounds(879, 357, 276, 67);
		btnIniciarSesin.requestFocus();
		FondoPerfil.add(btnIniciarSesin);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Century Schoolbook", Font.PLAIN, 40));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(150, 404, 319, 50);
		FondoPerfil.add(lblNombre);

		textPnombre = new JTextPane();
		textPnombre.setBounds(519, 422, 249, 32);
		KeyListener keylistener2 = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnRegistrarse.doClick();
				}
			}
		};
		textPnombre.addKeyListener(keylistener2);
		FondoPerfil.add(textPnombre);

		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(this);
		btnRegistrarse.setFont(new Font("Yu Gothic", Font.PLAIN, 23));
		btnRegistrarse.setBounds(879, 499, 276, 59);
		btnRegistrarse.requestFocus();
		FondoPerfil.add(btnRegistrarse);

		btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnVolver.setBounds(33, 652, 200, 50);
		FondoPerfil.add(btnVolver);
		btnVolver.addActionListener(this);

		this.setSize(1200, 800);
		this.setResizable(false);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = getSize();
		// cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);

		this.setVisible(true);
		ponerInvisible();
	}

	private void ponerInvisible() {
		btnRegistrarse.setVisible(false);
		textPnombre.setVisible(false);
		lblNombre.setVisible(false);
	}

	private void ponerVisible() {
		btnRegistrarse.setVisible(true);
		textPnombre.setVisible(true);
		lblNombre.setVisible(true);
	}

	public static void main(String[] args) {
		PerfilVentana x = new PerfilVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JButton botonPulsado = (JButton) e.getSource();

		if (botonPulsado == btnVolver) {
			new Menu();
			this.dispose();
		} else if (botonPulsado == btnIniciarSesin) {
			String u = usuario.getText();
			String c = contraseña.getText();
			if (u.equals("******") && c.equals("******")) {
				this.dispose();
				new VentanaAdministrador();
				usuario.setText("");
				contraseña.setText("");
			} else {
				boolean existe = bd.existeJugador(u, c);
				if (existe) {
					usuario.setText("");
					contraseña.setText("");
					this.dispose();
					j = new Jugador(u, c);
					Menu a = new Menu();
					a.lblbienvenido.setVisible(true);
					a.lblbienvenido2.setVisible(true);
					a.lblNewLabel_1.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							// PerfilUsuario pu = new PerfilUsuario();
							// pu.setVisible(true);
							a.cerrarVentana();

						}
					});
				} else
					ponerVisible();
			}
		} else if (botonPulsado == btnRegistrarse) {
			if (textPnombre.getText().equals("")
					|| usuario.getText().equals("")
					|| contraseña.getText().equals("")) {
				JOptionPane.showMessageDialog(null,
						"ERROR! falta por rellenar algun campo", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String u = usuario.getText();
				String c = contraseña.getText();
				String n = textPnombre.getText();
				bd.insertarJugador(n, u, c);
				perfilJugador.setContraseña(c);// guarda en perfiljugador la
												// contraseña
				perfilJugador.setUsuario(u);// gardar en userName perfilJugador
											// el user
				JOptionPane.showMessageDialog(null,
						"Registro completado con exito", "REGISTRADO",
						JOptionPane.INFORMATION_MESSAGE);
				textPnombre.setText("");
				usuario.setText("");
				contraseña.setText("");
				ponerInvisible();
			}
		}

	}
}

class FondoPerfil extends JPanel {

	public void paintComponent(Graphics g) {
		Dimension tamaño = getSize();
		ImageIcon imagenFondo = new ImageIcon(new ImageIcon(getClass()
				.getResource("/imagenes/fondo.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height,
				null);

	}
}