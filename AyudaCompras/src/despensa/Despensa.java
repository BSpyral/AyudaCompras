package despensa;

import java.util.ArrayList;
import java.util.List;

public class Despensa {

	protected static byte despensaActual=1;
	protected byte idDespensa;
	protected List<Productos> productos=new ArrayList<Productos>();
	protected List<Byte> cantidadProductos=new ArrayList<Byte>();
	protected int total;
	protected String nombreDespensa;

	public Despensa() {
		idDespensa=despensaActual;
		despensaActual++;
		total=0;
		nombreDespensa="";
	}
	
	public Despensa(int idDespensa,Productos productos,int cantidad,String nombreDespensa) {
		this.idDespensa = (byte)idDespensa;
		this.productos.add(productos);
		this.cantidadProductos.add((byte) cantidad);
		this.nombreDespensa=nombreDespensa;
		despensaActual++;
		total=0;
	}
	
	public void anadirProductos(Productos productos,int cantidad) {
		this.productos.add(productos);
		this.cantidadProductos.add((byte) cantidad);
	}
	
	public void eliminarProductos(Productos productos) {
		int index=0;
				
		index=this.productos.indexOf(productos);
		this.productos.remove(index);
		this.cantidadProductos.remove(index);
	}
	
	public void alterarDespensa(Productos productos,int cantidad) {
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

	public List<Productos> getProductos() {
		return productos;
	}
	
	public void setProducto(Productos producto) {
		this.productos.add(producto);
	}

	public void setProductos(List<Productos> productos) {
		this.productos.addAll(productos);
	}

	public String getNombreDespensa() {
		return nombreDespensa;
	}

	public void setNombreDespensa(String nombreDespensa) {
		this.nombreDespensa = nombreDespensa;
	}

	public int getTotal() {
		return total;
	}

	///////mejorar
	@Override
	public String toString() {
		return "Despensa [idDespensa=" + idDespensa + ", productos=" + productos.get(0).nombre + ", cantidadProductos="
				+ cantidadProductos.get(0).toString() + ", total=" + total +"]";
	}
}
