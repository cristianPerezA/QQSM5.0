package ventanas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import qqsm.Configuracion;

/**
 * Ventana para los jugadores que alcanzan el millón de euros
 *
 */
public class Premio extends JFrame{



	private static final long serialVersionUID = 1L;

	public Premio(){

		getContentPane().setLayout(null);
		FondoPremio fondoPremio = new FondoPremio();
		fondoPremio.setBounds(0, 0, 1194, 765);
		getContentPane().add(fondoPremio);
		fondoPremio.setLayout(null);

		JLabel lblEnhorabuena = new JLabel("ENHORABUENA");
		lblEnhorabuena.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnhorabuena.setForeground(Color.WHITE);
		lblEnhorabuena.setFont(new Font("Monotype Corsiva", Font.BOLD, 65));
		lblEnhorabuena.setBounds(246, 10, 762, 106);
		fondoPremio.add(lblEnhorabuena);

		JLabel lblEres = new JLabel("Eres...");
		lblEres.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblEres.setForeground(Color.WHITE);
		lblEres.setBounds(234, 270, 149, 142);
		fondoPremio.add(lblEres);

		JLabel label = new JLabel("1.000.000\u20AC");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cerrarVentana();
				Entrada a= new Entrada();
				a.setVisible(true);
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Segoe UI Black", Font.PLAIN, 99));
		label.setBounds(165, 565, 880, 187);
		fondoPremio.add(label);

		JLabel label_1 = new JLabel("!!!");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 62));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(840, 302, 72, 85);
		fondoPremio.add(label_1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(1200,800);
		this.setResizable(false);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = getSize();
		// cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);


		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Premio x= new Premio();
	}
	
	
	public void cerrarVentana(){
		this.dispose();
	}
}
	

class FondoPremio extends JPanel {

	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo2.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}
}