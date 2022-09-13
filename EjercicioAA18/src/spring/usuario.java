package spring;

 class usuario {
	 String nombre;
	 int ID;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	@Override
	public String toString() {
		return "Bienvenido " + nombre + ", con ID " + ID + "\n";
	}
	public usuario(String nombre, int iD) {
		super();
		this.nombre = nombre;
		ID = iD;
	}
	 

}
