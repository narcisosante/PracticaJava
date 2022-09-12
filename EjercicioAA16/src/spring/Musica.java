package spring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Musica extends Persona implements Recaudacion  {
	


	static Musica msc = new Musica();
	

	public static void main(String[] args) throws IOException {
		
		Persona ps1 = new Persona();
		ps1.email = "narciso@hotmail.com";
		ps1.id = 1;
		ps1.nombre = "Narciso";
		

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			Servicio servicio = ctx.getBean(Servicio.class);
			servicio.generarTxt();
			servicio.comprobarTxt();
			servicio.confirmarTxt();

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File file = new File("salida_" + LocalDate.now() + ".txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter escritura = new BufferedWriter(fw);
		escritura.write(ps1.toString());
		File doc = new File("C:\\Users\\Usuario\\Downloads\\Canciones_2021.txt");
		String txt;
		FileReader f = new FileReader(doc);
		BufferedReader obj = new BufferedReader(f);
		escritura.write("\n" + "Canciones más escuchadas en 2021");
		while ((txt = obj.readLine()) != null) {
			String st1 = txt.replaceAll("[^A-Za-z]", " ");
			String st2 = txt.replaceAll("[^0-9]", "");

			escritura.write("\n" + "Cancion: " + st1);
			escritura.write("\n" + "Reproducciones: " + st2);
			escritura.write("\n" + "esto ha recaudado:" + msc.recaudacion(st2) + "€");
			// System.out.println(txt);
		}
		obj.close();

		File doc1 = new File("C:\\Users\\Usuario\\Downloads\\Canciones_2020.txt");
		String txt1;
		FileReader f1 = new FileReader(doc1);
		BufferedReader obj1 = new BufferedReader(f1);
		escritura.write("\n" + "Canciones más escuchadas en 2020:");
		while ((txt1 = obj1.readLine()) != null) {
			String st1 = txt1.replaceAll("[^A-Za-z]", " ");
			String st2 = txt1.replaceAll("[^0-9]", "");
			int recaudado = Integer.parseInt(st2) * 2;
			escritura.write("\n" + "Cancion: " + st1);
			escritura.write("\n" + "Reproducciones: " + st2);
			escritura.write("\n" + "esto ha recaudado:" + recaudado + "€");
			// System.out.println(txt1);
		}
		obj1.close();

		File doc2 = new File("C:\\Users\\Usuario\\Downloads\\Artistas 2021.txt");
		String txt2;
		FileReader f2 = new FileReader(doc2);
		BufferedReader obj2 = new BufferedReader(f2);
		escritura.write("\n" + "Artistas más escuchados en 2021:");
		while ((txt2 = obj2.readLine()) != null) {

			escritura.write("\n" + txt2);
		}
		obj2.close();

		File doc3 = new File("C:\\Users\\Usuario\\Downloads\\Artistas 2021.txt");
		String txt3;
		FileReader f3 = new FileReader(doc3);
		BufferedReader obj3 = new BufferedReader(f3);
		escritura.write("\n" + "Artistas más escuchados en 2020:");
		while ((txt3 = obj3.readLine()) != null) {
			
			escritura.write("\n" + txt3);
		}
		obj3.close();
		escritura.close();
	}
	

	@Override
	public int recaudacion(String st2) {
		int recaudado = Integer.parseInt(st2) * 2;
		return recaudado;
	}

}

interface Recaudacion {
	public int recaudacion(String str);
}
class Persona extends Usuario{
	String nombre;
	Usuario usuario = new Usuario();
	
	
	@Override
	public String toString() {
		return "Bienvenido " + nombre + ", con ID " + id + " y correo electronico " + email + "\n";
	}
	
	
}

class Usuario{
	int id;
	String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}