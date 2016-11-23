package ventanas;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.temporal.JulianFields;








import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import basedatos.accesobd;
import clases.Jugador;


public class ventanaMostrarUsuarios extends JFrame implements ActionListener{
		
	/**
	 * Ventana que muestra los usuario de la BD en una JTable 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolvera;
	JScrollPane scrollPaneListaJugadores;
	private JTable tablaJ;
	private DefaultTableModel dtmJ;
	private LinkedList<Jugador> lJugadores;
	private accesobd bd;
	private JScrollPane scrollTabla;
	private JPanel panelSur,panel;
	
	
	public ventanaMostrarUsuarios(){
		
		Fondou fondo = new Fondou();
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(new BorderLayout());

		bd=new accesobd();
		bd.conectar();
		lJugadores=bd.obtenerJugadores();
		tablaJ = new JTable(new DefaultTableModel());
		dtmJ=(DefaultTableModel)tablaJ.getModel();
		tablaJ.setModel(dtmJ);
		tablaJ.setEnabled(false);
		
		
		//scrollTabla=new JScrollPane(tablaJ);
		
		
		String titulos[]={"NOMBRE","USUARIO","PUNTOS_MAX", "NUM_PART_JUG"};
		for (int i = 0; i < titulos.length; i++) {
			dtmJ.addColumn(titulos[i]);
		}
		
		for(int i=0;i<lJugadores.size();i++){
			Jugador j=lJugadores.get(i);
			String fila[]={j.getNombre(),j.getUsuario(), String.valueOf(j.getPunt_max()), String.valueOf(j.getN_par_j())};
			dtmJ.addRow(fila);
		}
		JLabel usua = new JLabel("USUARIOS");
		usua.setHorizontalAlignment(SwingConstants.CENTER);
		usua.setFont(new Font("Lucida Handwriting", Font.PLAIN, 75));
		usua.setForeground(Color.YELLOW);
		usua.setBounds(131, 13, 968, 139);
		fondo.add("North",usua);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setResizable(true);
		
		panelSur=new JPanel();
		btnVolvera = new JButton("VOLVER");
		btnVolvera.setFont(new Font("Yu Gothic", Font.PLAIN, 24));
		btnVolvera.setBounds(33, 652, 200, 50);
		panelSur.add(btnVolvera);
		panelSur.setOpaque(false);
		fondo.add("South",panelSur);
		
		panel = new JPanel();
		fondo.add("Center",panel);
		panel.setLayout(null);
		
		scrollTabla=new JScrollPane(tablaJ);
		scrollTabla.setBounds(278, 68, 703, 183);
		scrollTabla.setOpaque(true);
		panel.add(scrollTabla);
		panel.setOpaque(false);
		btnVolvera.addActionListener(this);


		//codigo JList//
		
		
		
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		// Se obtienen las dimensiones en pixels de la ventana.
		Dimension ventana = getSize();
		// cuenta para situar la ventana en el centro de la pantalla.
		setLocation((pantalla.width - ventana.width) / 2,
				(pantalla.height - ventana.height) / 2);
		this.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		ventanaMostrarUsuarios a= new ventanaMostrarUsuarios();
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton botonPulsado = (JButton) e.getSource();
		
		if (botonPulsado == btnVolvera){
			new Menu();
			this.dispose();
		}
	}
	
	
}


class Fondou extends JPanel {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}

}