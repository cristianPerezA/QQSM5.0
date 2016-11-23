package ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.JScrollPane;
import javax.swing.JTable;

import ventanas.PreguntasVentana.Position;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import preguntas.Pregunta;
import preguntas.PreguntaImagen;
import basedatos.accesobd;
import qqsm.Configuracion;

/**
 * Ventana que muestra las preguntas en una JTable y que permite la actualización de la BD de las mismas
 * con un simple 'enter'
 *
 */
public class VentanaMostrarPreguntas extends JFrame {

	private JTable tablaP;
	private JScrollPane scrollTabla;
	private DefaultTableModel dtm;
	private accesobd  bd;
	private static final long serialVersionUID = 1L;


	public VentanaMostrarPreguntas(){
		Configuracion.init();
		
		// ahora leeremos todas las preguntas de los 3 bloques de dificultad al
		//programa
		
		bd = new accesobd();
		bd.conectar();

		FondoMPreguntas fondo = new FondoMPreguntas();
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(new BorderLayout());
		
		tablaP = new JTable(new DefaultTableModel());
		DefaultTableModel dtm = (DefaultTableModel) tablaP.getModel();
		String titulos [] = {"PREGUNTA","RESPUESTA 1","RESPUESTA 2", "RESPUESTA 3", "RESPUESTA 4", "RESPUESTA C","RUTA"};
		for (int i = 0; i < titulos.length; i++) {
			dtm.addColumn(titulos[i]);
		}
		LinkedList<Pregunta>lpreguntas = bd.obtenerPreguntas();
		for (int i = 0; i <lpreguntas.size(); i++) {
			Pregunta pregunta = lpreguntas.get(i);
			
			if(pregunta instanceof PreguntaImagen){
				String fila [] = {pregunta.getTextoPregunta(), pregunta.getRes1(), pregunta.getRes2(),pregunta.getRes3(),pregunta.getRes4(),pregunta.getResC(),((PreguntaImagen)pregunta).getImagen()};
				dtm.addRow(fila);
			}
			else{ 
				String fila [] = {pregunta.getTextoPregunta(), pregunta.getRes1(), pregunta.getRes2(),pregunta.getRes3(),pregunta.getRes4(),pregunta.getResC(),""};
				dtm.addRow(fila);
			}
			
		}
		tablaP.setModel(dtm);
		
		scrollTabla = new JScrollPane(tablaP);
		scrollTabla.setViewportView(tablaP);
		fondo.add("Center", scrollTabla);
		fondo.updateUI();
		
		
		JLabel lblIntroducirPreguntas = new JLabel("PREGUNTAS EN LA BD");
		lblIntroducirPreguntas.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroducirPreguntas.setForeground(Color.WHITE);
		lblIntroducirPreguntas.setFont(new Font("Segoe Script", Font.BOLD, 45));
		//lblIntroducirPreguntas.setBounds(316, 40, 603, 57);
		fondo.add("North",lblIntroducirPreguntas);
		
		/*Creamos un escuchador que comprueba si ha habido algun cambio en la tabla*/
	    TableModelListener escuchador = new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int fila = tablaP.getSelectedRow();
				System.out.println("Se ha seleccionado una fila"+fila);
				if (fila>=0){
					DefaultTableModel dtm = (DefaultTableModel)tablaP.getModel();
					Pregunta p = new Pregunta(dtm.getValueAt(fila, 0).toString(),dtm.getValueAt(fila, 1).toString(),dtm.getValueAt(fila, 2).toString(),dtm.getValueAt(fila, 3).toString(),dtm.getValueAt(fila, 4).toString(),1);
					System.out.println(p);
					bd.modificarPregunta(p, fila+1);
				}
				
			}
		};
		
		tablaP.getModel().addTableModelListener(escuchador);
		
	
		JButton btnIntroducirPreguntaNueva = new JButton("INTRODUCIR PREGUNTA NUEVA");
		btnIntroducirPreguntaNueva.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIntroducirPreguntaNueva.setBounds(707, 672, 463, 64);
		JPanel pnlintro = new JPanel();
		pnlintro.add(btnIntroducirPreguntaNueva);
		pnlintro.setOpaque(false);
		btnIntroducirPreguntaNueva.addMouseListener(new MouseListener() {

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
				MeterPreguntas mp = new MeterPreguntas();
				mp.setVisible(true);
				eliminarVentana();
			}
		});
		fondo.add("South",pnlintro);
		
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



	protected void eliminarVentana() {
		bd.desconectar();
		this.dispose();
	}



	public static void main(String[] args) {    
		// TODO Auto-generated method stub
	VentanaMostrarPreguntas f= new VentanaMostrarPreguntas();
	}
}

/**
 * @author Asier
 *clase para ponerle un fondo a la ventana
 */
class FondoMPreguntas extends JPanel {



	public void paintComponent (Graphics g){
		Dimension tamaño= getSize();
		ImageIcon imagenFondo= new ImageIcon (new ImageIcon(getClass().getResource("/imagenes/fondo.png")).getImage());
		g.drawImage(imagenFondo.getImage(), 0, 0, tamaño.width, tamaño.height, null);

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
}



