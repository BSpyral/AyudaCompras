package despensa;

//import jakarta.persistence.Entity;

//@Entity
public class Producto {

	private int idProducto;
	private short precio;
	private String nombre;
	
	private static int productoActual=1;

	public Producto(int idProducto, int precio, String nombre) {
		super();
		this.idProducto = idProducto;
		this.precio = (short)precio;
		this.nombre = nombre;
	}
	
	public Producto(int precio, String nombre) {
		super();
		this.idProducto = productoActual;
		productoActual++;
		this.precio = (short)precio;
		this.nombre = nombre;
	}
	
	public int getIdProductos() {
		return idProducto;
	}

	public void setIdProductos(int idProducto) {
		this.idProducto = idProducto;
	}

	public short getPrecio() {
		return precio;
	}

	public void setPrecio(short precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}