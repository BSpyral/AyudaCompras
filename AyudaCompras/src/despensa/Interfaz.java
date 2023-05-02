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
		graficar_interfazDespensa(interfaz, botonPagar, botonAnadir_producto, encabezado, altura, ancho);

		ActionListener accionAñadirProducto = accionAñadirProducto(interfaz);
		botonAnadir_producto.addActionListener(accionAñadirProducto);
		
		//labelsProductos.add(new JLabel("{El producto}"));
		
		ActionListener accionPagar=new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (despensa.getProductos().isEmpty())
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
	
	private static void graficar_interfazDespensa(JFrame interfaz, JButton botonPagar, JButton botonAnadir_producto,
			JLabel encabezado, int altura, int ancho) {
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
				         .addComponent(encabezado,0,GroupLayout.DEFAULT_SIZE,altura/8)
				         .addComponent(botonPagar,0,GroupLayout.DEFAULT_SIZE,altura/9))	
				    .addGap(altura/15)
				    .addComponent(botonAnadir_producto,0,GroupLayout.DEFAULT_SIZE,altura/8)
				);
	}
	
	private static ActionListener accionAñadirProducto(JFrame interfaz) {
		ActionListener accionAñadirProducto=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileIconoImagen="C:/Users/Bar/Documents/Proyectos/-AyudaCompras/prueba.png";
				String fileIconoVoz="C:/Users/Bar/Documents/Proyectos/-AyudaCompras/prueba.png";
				String fileIconoTexto="C:/Users/Bar/Documents/Proyectos/-AyudaCompras/prueba.png";
				
				int altura=400,ancho=800;
				JFrame interfaz_agregarProducto=new JFrame();
				JLabel tituloAgregar=new JLabel();
				JLabel labelImagen=new JLabel();
				JLabel labelVoz=new JLabel();
				JLabel labelTexto=new JLabel();
				JButton botonImagen = new JButton();
				JButton botonVoz = new JButton();
				JButton botonTexto = new JButton();

				inicializar_interfazAñadirProducto(fileIconoImagen, fileIconoVoz, fileIconoTexto, altura, ancho,
						interfaz_agregarProducto, tituloAgregar, labelImagen, labelVoz, labelTexto, botonImagen, botonVoz,
						botonTexto);
				graficar_interfazAñadirProducto(interfaz_agregarProducto, tituloAgregar, labelImagen, labelVoz, labelTexto,
						botonImagen, botonVoz, botonTexto, altura, ancho);
				
				interfaz_agregarProducto.setVisible(true);
				interfaz.setVisible(false);
				
				ActionListener accionAñadirporImagen=new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//Implementacion posterior
					}
				};
				botonImagen.addActionListener(accionAñadirporImagen);
				
				
				ActionListener accionAñadirporVoz=new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//Implementacion posterior
					}
				};
				botonVoz.addActionListener(accionAñadirporVoz);
				
				
				ActionListener accionAñadirporTexto=new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame interfazTexto=new JFrame();
						JTextField text_nombreProducto=new JTextField();
						JTextField text_precio=new JTextField();
						JTextField text_cantidadProductos=new JTextField();
						JLabel label_nombreProducto=new JLabel();
						JLabel label_precio=new JLabel();
						JLabel label_cantidadProductos=new JLabel();
						int altura=400,ancho=800;
						
						interfazTexto.setSize(ancho,altura);
						label_nombreProducto.setText("Producto");
						label_precio.setText("Precio");
						label_cantidadProductos.setText("Cantidad");
						
						Container contenedor=interfazTexto.getContentPane();
						GroupLayout layout = new GroupLayout(contenedor);
						contenedor.setLayout(layout);
						layout.setAutoCreateContainerGaps(true);
						layout.setAutoCreateGaps(true);

						layout.setHorizontalGroup(
								layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup()
										.addComponent(label_nombreProducto)
										.addComponent(label_precio)
										)
									.addGroup(layout.createParallelGroup()
										.addComponent(text_nombreProducto,0,ancho/3,ancho)	
										.addComponent(text_precio,0,GroupLayout.DEFAULT_SIZE,ancho/3)		
										)
									.addComponent(label_cantidadProductos)
									.addComponent(text_cantidadProductos)						
								);
						layout.setVerticalGroup(
								layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup()
											.addComponent(label_nombreProducto,0,GroupLayout.DEFAULT_SIZE,altura/8)
											.addComponent(text_nombreProducto,0,GroupLayout.DEFAULT_SIZE,altura/8)
											)
									.addGroup(layout.createParallelGroup()
											.addComponent(label_precio,0,GroupLayout.DEFAULT_SIZE,altura/8)
											.addComponent(text_precio,0,GroupLayout.DEFAULT_SIZE,altura/8)
											.addComponent(label_cantidadProductos,0,GroupLayout.DEFAULT_SIZE,altura/8)
											.addComponent(text_cantidadProductos,0,GroupLayout.DEFAULT_SIZE,altura/8)
											)
								);
						
						interfazTexto.setVisible(true);
						interfaz_agregarProducto.setVisible(false);
					}
				};
				botonTexto.addActionListener(accionAñadirporTexto);
				
			}
		};
		return accionAñadirProducto;
	}
	

	private static void inicializar_interfazAñadirProducto(String fileIconoImagen, String fileIconoVoz,
			String fileIconoTexto, int altura, int ancho, JFrame interfaz_agregarProducto, JLabel tituloAgregar,
			JLabel labelImagen, JLabel labelVoz, JLabel labelTexto, JButton imgImagen, JButton imgVoz,
			JButton imgTexto) {
		interfaz_agregarProducto.setSize(ancho, altura);
		tituloAgregar.setText("Añadir Producto");
		tituloAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		labelImagen.setText("Por Imagen");
		labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
		labelVoz.setText("Por Voz");
		labelVoz.setHorizontalAlignment(SwingConstants.CENTER);
		labelTexto.setText("Por Texto");
		labelTexto.setHorizontalAlignment(SwingConstants.CENTER);
		imgImagen.setIcon(new ImageIcon(fileIconoImagen,"Icono de Imagen"));
		imgVoz.setIcon(new ImageIcon(fileIconoVoz,"Icono de Voz"));
		imgTexto.setIcon(new ImageIcon(fileIconoTexto,"Icono de Texto"));
	}

	private static void graficar_interfazAñadirProducto(JFrame interfaz_agregarProducto, JLabel tituloAgregar,
			JLabel labelImagen, JLabel labelVoz, JLabel labelTexto, JButton imgImagen, JButton imgVoz, JButton imgTexto,
			int altura, int ancho) {
		Container contenedor=interfaz_agregarProducto.getContentPane();
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
					.addComponent(tituloAgregar,0,GroupLayout.DEFAULT_SIZE,altura/6)
				    .addGap(altura/10)
				    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					      .addComponent(imgImagen,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6)
					      .addComponent(imgVoz,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6)      
				      	  .addComponent(imgTexto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/6))  
				    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						  .addComponent(labelImagen,0,GroupLayout.DEFAULT_SIZE,altura/6)
						  .addComponent(labelVoz,0,GroupLayout.DEFAULT_SIZE,altura/6)      
					      .addComponent(labelTexto,0,GroupLayout.DEFAULT_SIZE,altura/6))  
				);
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
