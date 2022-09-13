package spring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;


import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Pais implements PIB {
	static usuario us = new usuario("Narciso", 1);
	static Main m = new Main();

	public static void main(String[] args) throws IOException {
		
		
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarSpring.class)) {
			Servicio servicio = ctx.getBean(Servicio.class);
			servicio.generarTxt();
			servicio.confirmarUser();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		texto text = (usuario)-> { System.out.println(us);
		;};
		text.bienvenida(us);

		File doc = new File("C:\\Users\\Usuario\\Downloads\\INFO_PAISES.txt");

		FileReader f = new FileReader(doc);
		BufferedReader obj = new BufferedReader(f);

		primerPais(obj);
		segundoPais(obj);
		tercerPais(obj);
		cuartoPais(obj);
	}

	private static void tercerPais(BufferedReader obj) throws IOException {
		Pais pais3 = new Pais();
		String line1 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(12);
		String[] pais = line1.split(":");
		String part1 = pais[1];
		pais3.nombre = part1;

		String line2 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(13);
		String[] continente = line2.split(":");
		String part2 = continente[1];
		pais3.conti = part2;
		String line3 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(14);
		String[] capital = line3.split(":");
		String part3 = capital[1];
		pais3.capital = part3;
		String line4 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(15);
		String[] habitantes = line4.split(":");
		String part4 = habitantes[1];
		pais3.habitantes = part4;
		String line5 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(16);
		String[] clima = line5.split(":");
		String part5 = clima[1];
		pais3.clima = part5;
		String line6 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(17);
		String[] salario = line6.split(": ");
		String part6 = salario[1];
		pais3.salario = part6;
		double hab = Integer.parseInt(part4);
		double sal = Integer.parseInt(part6);
		pais3.pib = m.calcularPIB(hab, sal);

		obj.close();
		File file = new File("tercer_pais_" + LocalDate.now() + ".txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter escritura = new BufferedWriter(fw);
		escritura.write(line1 + "\n");
		escritura.write(line2 + "\n");
		escritura.write(line3 + "\n");
		escritura.write(line4 + "\n");
		escritura.write(line5 + "\n");
		escritura.write(line6 + "\n");
		escritura.write("PIB: " + pais3.pib);
		
		

		escritura.close();
	}

	private static void segundoPais(BufferedReader obj) throws IOException {
		Pais pais2 = new Pais();
		String line1 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(6);
		String[] pais = line1.split(":");
		String part1 = pais[1];
		pais2.nombre = part1;

		String line2 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(7);
		String[] continente = line2.split(":");
		String part2 = continente[1];
		pais2.conti = part2;
		String line3 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(8);
		String[] capital = line3.split(":");
		String part3 = capital[1];
		pais2.capital = part3;
		String line4 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(9);
		String[] habitantes = line4.split(": ");
		String part4 = habitantes[1];
		pais2.habitantes = part4;
		String line5 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(10);
		String[] clima = line5.split(":");
		String part5 = clima[1];
		pais2.clima = part5;
		String line6 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(11);
		String[] salario = line6.split(": ");
		String part6 = salario[1];
		pais2.salario = part6;
		double hab = Integer.parseInt(part4);
		double sal = Integer.parseInt(part6);
		pais2.pib = m.calcularPIB(hab, sal);
		

		obj.close();
		File file = new File("segundo_pais_" + LocalDate.now() + ".txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter escritura = new BufferedWriter(fw);
		escritura.write(line1 + "\n");
		escritura.write(line2 + "\n");
		escritura.write(line3 + "\n");
		escritura.write(line4 + "\n");
		escritura.write(line5 + "\n");
		escritura.write(line6 + "\n");
		escritura.write("PIB: " + pais2.pib);
		

		escritura.close();
	}

	private static void primerPais(BufferedReader obj) throws IOException {
		Pais pais1 = new Pais();
		String line1 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(18);
		String[] pais = line1.split(":");
		String part1 = pais[1];
		pais1.nombre = part1;

		String line2 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(19);
		String[] continente = line2.split(":");
		String part2 = continente[1];
		pais1.conti = part2;
		String line3 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(20);
		String[] capital = line3.split(":");
		String part3 = capital[1];
		pais1.capital = part3;
		String line4 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(21);
		String[] habitantes = line4.split(":");
		String part4 = habitantes[1];
		pais1.habitantes = part4;
		String line5 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(22);
		String[] clima = line5.split(":");
		String part5 = clima[1];
		pais1.clima = part5;
		String line6 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(23);
		String[] salario = line6.split(": ");
		String part6 = salario[1];
		pais1.salario = part6;
		double hab = Integer.parseInt(part4);
		double sal = Integer.parseInt(part6);
		pais1.pib = m.calcularPIB(hab, sal);
		

		obj.close();
		File file = new File("primer_pais_" + LocalDate.now() + ".txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter escritura = new BufferedWriter(fw);
		escritura.write(line1 + "\n");
		escritura.write(line2 + "\n");
		escritura.write(line3 + "\n");
		escritura.write(line4 + "\n");
		escritura.write(line5 + "\n");
		escritura.write(line6 + "\n");
		escritura.write("PIB: " + pais1.pib);
		

		escritura.close();
	}

	private static void cuartoPais(BufferedReader obj) throws IOException {
		Pais pais4 = new Pais();
		String line1 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(0);
		String[] pais = line1.split(":");
		String part1 = pais[1];
		pais4.nombre = part1;

		String line2 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(1);
		String[] continente = line2.split(":");
		String part2 = continente[1];
		pais4.conti = part2;
		String line3 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(2);
		String[] capital = line3.split(":");
		String part3 = capital[1];
		pais4.capital = part3;
		String line4 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(3);
		String[] habitantes = line4.split(": ");
		String part4 = habitantes[1];
		pais4.habitantes = part4;
		String line5 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(4);
		String[] clima = line5.split(":");
		String part5 = clima[1];
		pais4.clima = part5;
		String line6 = Files.readAllLines(Paths.get("C:\\\\Users\\\\Usuario\\\\Downloads\\\\INFO_PAISES.txt")).get(5);
		String[] salario = line6.split(": ");
		String part6 = salario[1];
		pais4.salario = part6;
		double hab = Integer.parseInt(part4);
		double sal = Integer.parseInt(part6);
		pais4.pib = m.calcularPIB(hab, sal);
		

		obj.close();
		File file = new File("cuarto_pais_" + LocalDate.now() + ".txt");
		FileWriter fw = new FileWriter(file);
		BufferedWriter escritura = new BufferedWriter(fw);
		escritura.write(line1 + "\n");
		escritura.write(line2 + "\n");
		escritura.write(line3 + "\n");
		escritura.write(line4 + "\n");
		escritura.write(line5 + "\n");
		escritura.write(line6 + "\n");
		escritura.write("PIB: " + pais4.pib);

		escritura.close();
	}

	public interface texto {
		public void bienvenida(usuario jugador);
	}

	@Override
	public double calcularPIB(double sal, double hab) {
		
		double p = hab + sal;
		return p;
	}
}

class Pais extends Continente {
	String capital;
	String nombre;
	String habitantes;
	String salario;
	String clima;
	double pib;
	Continente continente = new Continente();
}

class Continente {

	String conti;

}
interface PIB{
	double calcularPIB(double hab, double sal);
}