
class Videojuegos{
	
	String nombre;
	double ventas;
	double precio;
	double montoTotal;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getVentas() {
		return ventas;
	}
	public void setVentas(Double ventas) {
		this.ventas = ventas;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	
	@Override
	public String toString() {
		return "Videojuegos [nombre=" + nombre + ", ventas=" + ventas + ", precio=" + precio + ", montoTotal="
				+ montoTotal + "]";
	}


	
}