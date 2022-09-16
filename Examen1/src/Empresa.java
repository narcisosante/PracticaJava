import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Empresa extends Usuario implements AntiguedadUser, SegmentoUser, EdadUser {
	

	public Empresa(String nombre, String fechaNacimiento, String fechaRegistro, String fechaLogin, String pais,
			int compras, int edad, int antiguedad, String status) {
		super(nombre, fechaNacimiento, fechaRegistro, fechaLogin, pais, compras, edad, antiguedad, status);
		// TODO Auto-generated constructor stub
	}
	
	static Empresa emp = new Empresa(null, null, null, null, null, 0, 0, 0, null);
	static Set<Usuario> listauser = new HashSet<>();
	public static void main (String [] args ) throws IOException {
		
		
		primerTxt();
		segundoTxt();
		tercerTxt();
		
		File file = new File("informeDiario_" + LocalDate.now() + ".txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter escritura = new BufferedWriter(fw);
		escritura.write(listauser.toString() + "\n");
		System.out.println(listauser.toString());
	}

	private static void primerTxt() throws IOException {
		String user1 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_3.txt")).get(1);
		String[] datos = user1.split("-");
		String part1 = datos[0];
		String part2 = datos[1];
		String part3 = datos[2];
		String part4 = datos[3];
		String part5 = datos[4];
		int Compras = Integer.parseInt(part5);
		String part6 = datos[5];
		
		Usuario us1 = new Usuario(part1, part2, part3, part4, part6, Compras, emp.Edad(part2),  emp.Antiguedad(part3), emp.Segmento(Compras));
		listauser.add(us1);
		
		
		
		String user2 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_3.txt")).get(2);
		String[] datos2 = user2.split("-");
		String part11 = datos2[0];
		String part12 = datos2[1];
		String part13 = datos2[2];
		String part14 = datos2[3];
		String part15 = datos2[4];
		int Compras1 = Integer.parseInt(part15);
		String part16 = datos2[5];
		Usuario us2 = new Usuario(part11, part12, part13, part14, part16, Compras1,emp.Edad(part12),  emp.Antiguedad(part13), emp.Segmento(Compras1));
		listauser.add(us2);
		
		
		
		String user3 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_3.txt")).get(3);
		String[] dates3 = user3.split("-");
		String Nombre3 = dates3[0];
		String Nacimiento3 = dates3[1];
		String Registro3 = dates3[2];
		String Login3 = dates3[3];
		String Compras3 = dates3[4];
		int Compras21 = Integer.parseInt(Compras3);
		String Pais3 = dates3[5];
		Usuario us3 = new Usuario(Nombre3, Nacimiento3, Registro3, Login3, Pais3, Compras21, emp.Edad(Nacimiento3),  emp.Antiguedad(Registro3), emp.Segmento(Compras21));
		listauser.add(us3);
		
	}

	private static void segundoTxt() throws IOException {
		String user1 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_1.txt")).get(1);
		String[] datos = user1.split("-");
		String part1 = datos[0];
		String part2 = datos[1];
		String part3 = datos[2];
		String part4 = datos[3];
		String part5 = datos[4];
		int Compras = Integer.parseInt(part5);
		String part6 = datos[5];
		Usuario us4 = new Usuario(part1, part2, part3, part4, part6, Compras, emp.Edad(part2),  emp.Antiguedad(part3), emp.Segmento(Compras));
		
		
		
		
		String user2 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_1.txt")).get(2);
		String[] datos2 = user2.split("-");
		String part11 = datos2[0];
		String part12 = datos2[1];
		String part13 = datos2[2];
		String part14 = datos2[3];
		String part15 = datos2[4];
		int Compras1 = Integer.parseInt(part15);
		String part16 = datos2[5];
		Usuario us5 = new Usuario(part11, part12, part13, part14, part16, Compras1, emp.Edad(part12),  emp.Antiguedad(part13), emp.Segmento(Compras1));
		listauser.add(us5);
		
		
		
		String user3 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_1.txt")).get(3);
		String[] dates3 = user3.split("-");
		String Nombre3 = dates3[0];
		String Nacimiento3 = dates3[1];
		String Registro3 = dates3[2];
		String Login3 = dates3[3];
		String Compras3 = dates3[4];
		int Compras21 = Integer.parseInt(Compras3);
		String Pais3 = dates3[5];
		Usuario us6 = new Usuario(Nombre3, Nacimiento3, Registro3, Login3, Pais3, Compras21, emp.Edad(Nacimiento3),  emp.Antiguedad(Registro3), emp.Segmento(Compras21));
		listauser.add(us6);
		
	}
	private static void tercerTxt() throws IOException {
		String user1 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_2.txt")).get(1);
		String[] datos = user1.split("-");
		String part1 = datos[0];
		String part2 = datos[1];
		String part3 = datos[2];
		String part4 = datos[3];
		String part5 = datos[4];
		int Compras = Integer.parseInt(part5);
		String part6 = datos[5];
		Usuario us7 = new Usuario(part1, part2, part3, part4, part6, Compras,  emp.Edad(part2),  emp.Antiguedad(part3), emp.Segmento(Compras));
		listauser.add(us7);
		
		
		
		String user2 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_2.txt")).get(2);
		String[] datos2 = user2.split("-");
		String part11 = datos2[0];
		String part12 = datos2[1];
		String part13 = datos2[2];
		String part14 = datos2[3];
		String part15 = datos2[4];
		int Compras1 = Integer.parseInt(part15);
		String part16 = datos2[5];
		Usuario us8 = new Usuario(part11, part12, part13, part14, part16, Compras1, emp.Edad(part12),  emp.Antiguedad(part13), emp.Segmento(Compras1));
		listauser.add(us8);
		
		
		
		String user3 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\Usuarios_2.txt")).get(3);
		String[] dates3 = user3.split("-");
		String Nombre3 = dates3[0];
		String Nacimiento3 = dates3[1];
		String Registro3 = dates3[2];
		String Login3 = dates3[3];
		String Compras3 = dates3[4];
		int Compras21 = Integer.parseInt(Compras3);
		String Pais3 = dates3[5];
		Usuario us9 = new Usuario(Nombre3, Nacimiento3, Registro3, Login3, Pais3, Compras21,emp.Edad(Nacimiento3),  emp.Antiguedad(Registro3), emp.Segmento(Compras21));
		listauser.add(us9);
		
	}

	
	@Override
	public int Edad(String part) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");				
		LocalDate nacimiento =  LocalDate.parse(part, formatter);		
		Period period = Period.between(nacimiento, LocalDate.now());	
		int tiempo = period.getYears();
		return tiempo;
	}


	@Override
	public String Segmento(int Compras) {
		String seg = null;
        if (Compras  <= 5) seg = "Estandar User";
        if (Compras  > 5 && Compras <= 10) seg = "Afiliate";
        if (Compras  > 10) seg = "Premier";
        return seg;
		
	}

	@Override
	public int Antiguedad(String part) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");		
		LocalDate incor =  LocalDate.parse(part, formatter);
		Period period = Period.between(incor, LocalDate.now());	
		int incorpo = period.getMonths();
		return incorpo;
    }

	
	}


interface AntiguedadUser{
	
	public int Antiguedad(String part);
}
interface SegmentoUser{
	
	public String Segmento(int Compras);
}
interface StatusUser{
	
	public void Status();
}
interface EdadUser{
	
	public int Edad(String part);
}

class Usuario extends Persona{
	
	String Nombre;
	String FechaNacimiento;
	String FechaRegistro;
	String FechaLogin; 
	int edad;
	int antiguedad;
	
	public Usuario(String nombre, String fechaNacimiento, String fechaRegistro,
			String fechaLogin,String pais, int compras, int edad, int antiguedad, String status) {
		super(pais, compras);
		Nombre = nombre;
		FechaNacimiento = fechaNacimiento;
		FechaRegistro = fechaRegistro;
		FechaLogin = fechaLogin;
		this.edad = edad;
		this.antiguedad = antiguedad;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Empresa [Nombre=" + Nombre + ", FechaNacimiento=" + FechaNacimiento + ", FechaRegistro=" + FechaRegistro
				+ ", FechaLogin=" + FechaLogin +", Pais=" + Pais +", compras=" + Compras + ", edad=" + edad + ", antiguedad=" + antiguedad + " meses " + ", status=" + status
				+  "]" + "\n";
	}
	

	String status;
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	Persona persona = new Persona (Pais, Compras);
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public String getFechaLogin() {
		return FechaLogin;
	}
	public void setFechaLogin(String fechaLogin) {
		FechaLogin = fechaLogin;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	}
	

class Persona{
	
	static String Pais;
	static int Compras;
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	public int getCompras() {
		return Compras;
	}
	public void setCompras(int compras) {
		Compras = compras;
	}
	public Persona(String pais, int compras) {
		super();
		Pais = pais;
		Compras = compras;
	}
	
}