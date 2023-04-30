//Autor: Baruc Salomon 

/*
Programa encargado de las interfaces de usuario del programa <Ayuda Despensa>
-Interfaz CreaDespensa
-Interfaz Llena Despensa
-Interfaz Pagar
*/

package despensa;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Interfaz {
	
	static Despensa despensa;

	public static void main(String[] args) {
		despensa=new Despensa();
		
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

	private static void interfaz_despensa() {
		int altura=500,ancho=1000;
		String titulo_ventana="Despensa";
		
		JFrame interfaz=new JFrame(titulo_ventana);
		JButton botonPagar=new JButton();
		JButton botonAnadir_producto = new JButton();
		JLabel encabezado=new JLabel();
		List <JLabel> labelsProductos=new ArrayList<JLabel>();

		inicializar_interfazDespensa(interfaz, botonPagar, botonAnadir_producto, encabezado, ancho, altura);
		
		Container contenedor=interfaz.getContentPane();
		GroupLayout layout = new GroupLayout(contenedor);
		contenedor.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					 .addGap(ancho/3)
			      	 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				      	 .addComponent(encabezado,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/4)
				      	 .addComponent(botonAnadir_producto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/5))
				     .addGap(ancho/4)
			      	 .addComponent(botonPagar,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/7)	      
				);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				         .addComponent(encabezado,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/8)
				         .addComponent(botonPagar,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/9))	
				    .addGap(altura/15)
				    .addComponent(botonAnadir_producto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/8)
				);
		//si presiona boton añadir: interfaz añadir y agregar a Lista nuevo producto
		ActionListener accionAñadirProducto=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileIconoImagen="C:/Users/Bar/Documents/Proyectos/-AyudaCompras/prueba.png";
				String fileIconoVoz="C:/Users/Bar/Documents/Proyectos/-AyudaCompras/prueba.png";
				String fileIconoTexto="C:/Users/Bar/Documents/Proyectos/-AyudaCompras/prueba.png";
				
				int altura=400,ancho=800;
				JFrame jAgregarProducto=new JFrame();
				JLabel tituloAgregar=new JLabel("Añadir Producto");
				JLabel labelImagen=new JLabel("Por Imagen");
				JButton imgImagen = new JButton(new ImageIcon(fileIconoImagen,"Icono de Imagen"));
				JLabel labelVoz=new JLabel("Por Voz");
				JButton imgVoz = new JButton(new ImageIcon(fileIconoVoz,"Icono de Voz"));
				JLabel labelTexto=new JLabel("Por Texto");
				JButton imgTexto = new JButton(new ImageIcon(fileIconoTexto,"Icono de Texto"));

				jAgregarProducto.setSize(ancho, altura);
				tituloAgregar.setHorizontalAlignment(SwingConstants.CENTER);
				labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
				labelVoz.setHorizontalAlignment(SwingConstants.CENTER);
				labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
				
				Container contenedor=jAgregarProducto.getContentPane();
				GroupLayout layout = new GroupLayout(contenedor);
				contenedor.setLayout(layout);
				layout.setAutoCreateContainerGaps(true);
				layout.setHorizontalGroup(
						layout.createSequentialGroup()
							 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							     .addComponent(imgImagen,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/3)
							     .addComponent(labelImagen,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/3))
					      	 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					      		 .addComponent(tituloAgregar,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/3)
						      	 .addComponent(imgVoz,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/3)      
					      	 	 .addComponent(labelVoz,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/3))   
					      	 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							      .addComponent(labelTexto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/3)      
						      	  .addComponent(imgTexto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/3)) 
						);
				layout.setVerticalGroup(
						layout.createSequentialGroup()
							.addComponent(tituloAgregar,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6)
						    .addGap(altura/10)
						    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							      .addComponent(imgImagen,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6)
							      .addComponent(imgVoz,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6)      
						      	  .addComponent(imgTexto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6))  
						    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								  .addComponent(labelImagen,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6)
								  .addComponent(labelVoz,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6)      
							      .addComponent(labelTexto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6))  
						);
				
				jAgregarProducto.setVisible(true);
				interfaz.setEnabled(false);
				
				labelsProductos.add(new JLabel("{El producto}"));
			}
		};
		botonAnadir_producto.addActionListener(accionAñadirProducto);
		
		ActionListener accionPagar=new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (despensa.getProductos().isEmpty()==true)
				{
					
				}
				else
				{
					
				}
			}
		};
		botonPagar.addActionListener(accionPagar);
		
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
				interfaz.setEnabled(false);
				
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
					despensa.setNombreDespensa(textoNombreDespensa);
					interfaz.dispose();
					pedirNombre.dispose();
					interfaz_despensa();
				}

			}
		};
		return accionAceptar;
	}
	
	private static void graficar_interfazError(JFrame error, String textoLabel, int ubicacionX, int ubicacionY) {
		JLabel textoError=new JLabel();
		textoError.setText(textoLabel);
		textoError.setFont(new Font("Times New Roman",0, 18));
		error.getContentPane().setLayout(new FlowLayout());
		error.getContentPane().add(textoError);
		error.pack();
		error.setLocation(ubicacionX,ubicacionY);
	}

	private static void inicializar_interfazDespensa(JFrame interfaz, JButton botonPagar, JButton botonAnadir_producto,
			JLabel encabezado, int ancho, int altura) {
		String texto_botonPagar="Total/Pagar",
				texto_Anadir_producto="+ Añadir Productos";
		
		interfaz.setSize(ancho,altura);
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		botonPagar.setText(texto_botonPagar);
		botonAnadir_producto.setText(texto_Anadir_producto);
		encabezado.setText(despensa.getNombreDespensa());
		encabezado.setFont(new Font("Verdana", 1, 24));
		encabezado.setHorizontalAlignment(SwingConstants.CENTER);
	}
	///////////////////////////////////////////////////////////////////////////
	
	private static void creaDespensaAutomatica () {
		Productos panque=new Productos(45,"Panque Nuez");
		Despensa despensa=new Despensa();
		despensa.anadirProductos(panque, 2);
		despensa.alterarDespensa(panque, 4);
		System.out.println(despensa.toString());
	}

}
