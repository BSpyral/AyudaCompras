package despensa;

import java.awt.BorderLayout;

//Autor: Baruc Salomon 

/*
Programa encargado de las interfaces de usuario del programa <Ayuda Despensa>
-Interfaz Llena Despensa
-Interfaz Pagar
*/

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

public class InterfazDespensa {

	private static Despensa despensa;
	public static void main(String nombreDespensa) {
		despensa=new Despensa();
		despensa.setNombreDespensa(nombreDespensa);
		interfaz_despensa();
	}
	
	private static void interfaz_despensa() {
		int altura=500,ancho=1000;
		String titulo_ventana="Despensa";
		
		JFrame interfaz=new JFrame(titulo_ventana);
		JButton botonPagar=new JButton();
		JButton botonAnadir_producto = new JButton();
		JLabel encabezado=new JLabel();
		List <JLabel> labelsProductos=new ArrayList<JLabel>();
		JPanel listaProductos=new JPanel();
		listaProductos.setLayout(new BoxLayout(listaProductos, BoxLayout.Y_AXIS));
		
		anadirLabelProductos_interfazDespensa(labelsProductos, listaProductos);
		inicializar_interfazDespensa(interfaz, listaProductos, botonPagar, botonAnadir_producto, encabezado, ancho, altura);
		graficar_interfazDespensa(interfaz, listaProductos,botonPagar, botonAnadir_producto, encabezado, altura, ancho);

		ActionListener accionAñadirProducto = accionAñadirProducto(interfaz);
		botonAnadir_producto.addActionListener(accionAñadirProducto);

		ActionListener accionPagar=new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (despensa.getProductos().isEmpty())
				{	
					String textoLabel="Llene su despensa\n";
					
					JFrame error=new JFrame();
					InterfazInicial.graficar_interfazError(error, textoLabel, altura/2, ancho/2);
					error.setVisible(true);
				}
				else
				{
					JFrame interfaz_pagar=new JFrame();
					JLabel cantidadPagar = new JLabel();
					interfaz_pagar.add(cantidadPagar);
					cantidadPagar.setText("El total por sus productos es:"+despensa.calcularTotal());
					interfaz_pagar.setVisible(true);
					interfaz_pagar.pack();
				}
			}
		};
		botonPagar.addActionListener(accionPagar);

		interfaz.setVisible(true);

	}

	private static void anadirLabelProductos_interfazDespensa(List<JLabel> labelsProductos,
			JPanel listaProductos) {
		int contador=0;
		while (contador<despensa.getProductos().size())			
		{
			labelsProductos.add(new JLabel(
					"Producto: "  +
					despensa.getProductos().get(contador).getNombre()  +
					"\tPrecio: "  +
					despensa.getProductos().get(contador).getPrecio() +
					"\tCantidad: "  +
					despensa.getCantidadProductos().get(contador) 
					));
			listaProductos.add(labelsProductos.get(contador));
			contador++;
		}
		System.out.println(contador);
	}
	private static void inicializar_interfazDespensa(JFrame interfaz, JPanel productos,JButton botonPagar, JButton botonAnadir_producto,
			JLabel encabezado, int ancho, int altura) {
		String texto_botonPagar="Total/Pagar",
				texto_Anadir_producto="+ Añadir Productos";
		
		interfaz.setSize(ancho,altura);
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		productos.setSize(ancho/2, altura/2);
		botonPagar.setText(texto_botonPagar);
		botonAnadir_producto.setText(texto_Anadir_producto);
		encabezado.setText(despensa.getNombreDespensa());
		encabezado.setFont(new Font("Verdana", 1, 24));
		encabezado.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	private static void graficar_interfazDespensa(JFrame interfaz, JPanel productos,JButton botonPagar, JButton botonAnadir_producto,
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
				      	 .addComponent(productos,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/4)
				      	 .addComponent(botonAnadir_producto,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/5))
				     .addGap(ancho/4)
			      	 .addComponent(botonPagar,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,ancho/7)	      
				);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				         .addComponent(encabezado,0,GroupLayout.DEFAULT_SIZE,altura/8)
				         .addComponent(botonPagar,0,GroupLayout.DEFAULT_SIZE,altura/9))	
				    .addComponent(productos,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,altura/2)
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
						JFrame interfazAgregarTexto=new JFrame();
						JTextField text_nombreProducto=new JTextField();
						JTextField text_precio=new JTextField();
						JTextField text_cantidadProductos=new JTextField();
						JLabel label_nombreProducto=new JLabel();
						JLabel label_precio=new JLabel();
						JLabel label_cantidadProductos=new JLabel();
						JButton boton_aceptarProducto=new JButton();
						int altura=400,ancho=800;
						
						inicializar_interfazPorTexto(interfazAgregarTexto, label_nombreProducto, label_precio,
								label_cantidadProductos, boton_aceptarProducto, altura, ancho);
						
						graficar_interfazPorTexto(interfazAgregarTexto, text_nombreProducto, text_precio,
								text_cantidadProductos, label_nombreProducto, label_precio, label_cantidadProductos,
								boton_aceptarProducto, altura, ancho);
						
						
						ActionListener accionAceptarProducto = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (text_precio.getText().isEmpty() || text_nombreProducto.getText().isEmpty()
										|| text_cantidadProductos.getText().isEmpty()) {
									JFrame error=new JFrame();
									JLabel label_error=new JLabel();
									
									label_error.setText("Llene todos los campos del producto");
									error.getContentPane().setLayout(new FlowLayout());
									error.getContentPane().add(label_error);
									error.pack();
									error.setLocation(ancho/2,altura/2);
									
									error.setVisible(true);
								}
								else {
									String nombreProducto=text_nombreProducto.getText();
									int precio=0,cantidad_productos=0;
										try {
											precio = Integer.parseInt(text_precio.getText());
											cantidad_productos=Integer.parseInt(text_cantidadProductos.getText());
											
											Producto productoElegido=new Producto(precio,nombreProducto);
											
											despensa.anadirProductos(productoElegido, cantidad_productos);
											
											interfazAgregarTexto.dispose();										
											interfaz.dispose();
											interfaz_despensa();
										} catch (NumberFormatException e1) {
											String textoLabel="Escriba el precio del producto y la cantidad adecuada";
											JFrame error=new JFrame();
											InterfazInicial.graficar_interfazError(error, textoLabel, altura/2, ancho/2);
											error.setVisible(true);
											
											e1.printStackTrace();
										}
								}
							}							
						};
						boton_aceptarProducto.addActionListener(accionAceptarProducto);
						
						interfazAgregarTexto.setVisible(true);
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
	
	private static void inicializar_interfazPorTexto(JFrame interfazTexto, JLabel label_nombreProducto,
			JLabel label_precio, JLabel label_cantidadProductos, JButton boton_aceptarProducto,
			int altura, int ancho) {
		interfazTexto.setSize(ancho,altura);
		label_nombreProducto.setText("Producto");
		label_precio.setText("Precio");
		label_cantidadProductos.setText("Cantidad");
		boton_aceptarProducto.setText("Aceptar");
	}
	
	private static void graficar_interfazPorTexto(JFrame interfazTexto, JTextField text_nombreProducto,
			JTextField text_precio, JTextField text_cantidadProductos, JLabel label_nombreProducto,
			JLabel label_precio, JLabel label_cantidadProductos, JButton boton_aceptarProducto,
			int altura, int ancho) {
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
						.addComponent(boton_aceptarProducto,Alignment.CENTER)
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
					.addGap(altura/3)
					.addComponent(boton_aceptarProducto)
				);
	}

}

