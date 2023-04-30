package despensa;

public class Productos {

	protected int idProducto;
	protected short precio;
	protected String nombre;
	
	private static int productoActual=1;

	public Productos(int idProducto, int precio, String nombre) {
		super();
		this.idProducto = idProducto;
		this.precio = (short)precio;
		this.nombre = nombre;
	}
	
	public Productos(int precio, String nombre) {
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
