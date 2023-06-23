package despensa;

import java.util.ArrayList;
import java.util.List;

public class Despensa {

	private static byte despensaActual=1;
	private byte idDespensa;
	private List<Producto> productos=new ArrayList<Producto>();
	private List<Byte> cantidadProductos=new ArrayList<Byte>();
	private int total;
	private String nombreDespensa;

	public Despensa() {
		idDespensa=despensaActual;
		despensaActual++;
		total=0;
		nombreDespensa="";
	}
	
	public Despensa(int idDespensa,Producto productos,int cantidad,String nombreDespensa) {
		this.idDespensa = (byte)idDespensa;
		this.productos.add(productos);
		this.cantidadProductos.add((byte) cantidad);
		this.nombreDespensa=nombreDespensa;
		despensaActual++;
		total=0;
	}
	
	public void anadirProductos(Producto productos,int cantidad) {
		this.productos.add(productos);
		this.cantidadProductos.add((byte) cantidad);
	}
	
	public void eliminarProductos(Producto productos) {
		int index=0;
				
		index=this.productos.indexOf(productos);
		this.productos.remove(index);
		this.cantidadProductos.remove(index);
	}
	
	public void alterarDespensa(Producto productos,int cantidad) {
		int index=0;
		
		index=this.productos.indexOf(productos);
		this.productos.set(index, productos);
		this.cantidadProductos.set(index, (byte) cantidad);
	}
	
	public int calcularTotal() {
		for (int i=0;i<productos.size();i++) {
			total+=(productos.get(i).getPrecio()*cantidadProductos.get(i));
		}
		
		return total;
	}

	/////////////////////////////////////////////////////////////////////////
	public static void setDespensaActual(int despensaActual) {
		Despensa.despensaActual = (byte)despensaActual;
	}

	public byte getIdDespensa() {
		return idDespensa;
	}

	public void setIdDespensa(int idDespensa) {
		this.idDespensa =(byte) idDespensa;
	}

	public List<Producto> getProductos() {
		return productos;
	}
	
	public List<Byte> getCantidadProductos() {
		return cantidadProductos;
	}
	
	public String getNombreDespensa() {
		return nombreDespensa;
	}

	public void setNombreDespensa(String nombreDespensa) {
		this.nombreDespensa = nombreDespensa;
	}

	///////mejorar
	@Override
	public String toString() {
		return "Despensa [idDespensa=" + idDespensa + ", productos=" + productos.get(0).getNombre() + ", cantidadProductos="
				+ cantidadProductos.get(0).toString() + ", total=" + total +"]";
	}
}
