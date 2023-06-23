package despensa;

//Autor: Baruc Salomon 

/*
Programa encargado de las interfaces de usuario del programa <Ayuda Despensa>
-Interfaz CreaDespensa
*/


/*NOTA:    Aparte de añadir productos para despensa y asi ahorrar, tambien añadir una 
 * 			opcion de guardar los productos y poder dar observaciones y asi usarlas 
 * 			a futuro (por ejemplo,que algo no te gusto mucho y asi evitar comprarlo)
 * 
 * 
 * */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class InterfazInicial {


	public static void main(String[] args) {
		interfaz_iniciail();
	}

	private static void interfaz_iniciail() {
		int ancho=1000,altura=500;
		String titulo_ventana="Ayuda Compras";
		
		JFrame interfaz=new JFrame();     
		JButton botonCrea_despensa=new JButton();
		JLabel titulo=new JLabel();
		
		inicializar_interfazInicial(interfaz, botonCrea_despensa, titulo,ancho, altura, titulo_ventana);
		graficar_interfazInicial(interfaz, botonCrea_despensa, titulo,ancho, altura);
		
		ActionListener accionNuevaDespensa = accionNuevaDespensa(interfaz);
		botonCrea_despensa.addActionListener(accionNuevaDespensa);
		
		interfaz.setVisible(true);
	}
	
	private static void inicializar_interfazInicial(JFrame interfaz,JButton botonCrea_despensa, JLabel titulo,
			int ancho, int altura, String titulo_ventana) {
		interfaz.setTitle(titulo_ventana);
		interfaz.setSize(ancho,altura);
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		botonCrea_despensa.setText("+ Crear nueva despensa");
		titulo.setText(titulo_ventana);
		titulo.setFont(new Font("Times New Roman",1, 24));
	}
	
	private static void graficar_interfazInicial(JFrame interfaz, JButton botonCrea_despensa,
			JLabel titulo,int ancho, int altura) {
		Container contenedor=interfaz.getContentPane();
		GroupLayout layout = new GroupLayout(contenedor);
		contenedor.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGap(ancho/3)
				.addGroup(layout.createParallelGroup()
					.addComponent(titulo,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE,ancho/4)
					.addComponent(botonCrea_despensa,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE,ancho/6))
				);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(titulo,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE,altura/3)
				.addGap(altura/3)
				.addComponent(botonCrea_despensa,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE,altura/8)
				);
	}

	private static ActionListener accionNuevaDespensa(JFrame interfaz) {
		ActionListener accionNuevaDespensa=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame pedirNombre=new JFrame();
				JLabel tituloPedir=new JLabel();
				JTextField textoDespensa=new JTextField();
				JButton botonAceptar=new JButton();
				int ancho=200;
				int altura=150;
				
				inicializar_interfazNombreDespensa(pedirNombre, botonAceptar,tituloPedir,ancho, altura);
				graficar_interfazNombreDespensa(pedirNombre, tituloPedir, textoDespensa, botonAceptar, ancho, altura);
				
				pedirNombre.setVisible(true);
				
				ActionListener accionAceptar = accionAceptarNombreDespensa(interfaz, pedirNombre, textoDespensa, ancho,
						altura);
				botonAceptar.addActionListener(accionAceptar);
			}
		};
		return accionNuevaDespensa;
	}

	
	private static void inicializar_interfazNombreDespensa(JFrame pedirNombre, JButton botonAceptar, 
			JLabel tituloPedir,	int ancho,	int altura) {
		String textoBoton="Aceptar",textoLabel="Nombre de Despensa";
		
		pedirNombre.setSize(ancho,altura);
		botonAceptar.setText(textoBoton);
		tituloPedir.setText(textoLabel);
		pedirNombre.setLocation(ancho,altura);		//PODRIA ESTAR MAS CENTRADO
		
		pedirNombre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private static void graficar_interfazNombreDespensa(JFrame pedirNombre, JLabel tituloPedir,
			JTextField textoDespensa, JButton botonAceptar, int ancho, int altura) {
		Container contenedor=pedirNombre.getContentPane();
		GroupLayout layout=new GroupLayout(contenedor); 
		contenedor.setLayout(layout);	
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addComponent(tituloPedir)
				.addComponent(textoDespensa,0,GroupLayout.DEFAULT_SIZE,ancho)
				.addComponent(botonAceptar)
				);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(tituloPedir)
				.addComponent(textoDespensa,0,GroupLayout.DEFAULT_SIZE,altura/4)
				.addComponent(botonAceptar)
				);
	}
	
	private static ActionListener accionAceptarNombreDespensa(JFrame interfaz, JFrame pedirNombre,
			JTextField textoDespensa, int ubicacionX, int ubicacionY) {
		ActionListener accionAceptar=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoNombreDespensa=textoDespensa.getText();
				if (textoNombreDespensa.length()==0){
					String textoLabel="Escriba un nombre\n";
					
					JFrame error=new JFrame();
					graficar_interfazError(error, textoLabel, ubicacionX, ubicacionY);
					error.setVisible(true);
				}
				else {
					interfaz.dispose();
					pedirNombre.dispose();
					InterfazDespensa.main(textoNombreDespensa);
				}

			}
		};
		return accionAceptar;
	}
	
	public static void graficar_interfazError(JFrame error, String textoLabel, int ubicacionX, int ubicacionY) {
		JLabel textoError=new JLabel();
		textoError.setText(textoLabel);
		textoError.setFont(new Font("Times New Roman",0, 18));
		error.getContentPane().setLayout(new FlowLayout());
		error.getContentPane().add(textoError);
		error.pack();
		error.setLocation(ubicacionX,ubicacionY);
	}
	
}
