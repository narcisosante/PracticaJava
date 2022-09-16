import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;

public class Tiempo extends Producto implements Produccion {
	
	
	public static void main(String[] args) throws IOException {
		
		Tiempo tp = new Tiempo();
		barcelona(tp);
		madrid(tp);
	
}
	private static void madrid(Tiempo tp) {
		try {

			URL url1 = new URL("https://www.el-tiempo.net/api/json/v2/provincias/28"); // Declaro la URL
			HttpURLConnection conn = (HttpURLConnection) url1.openConnection(); // Declaro la conexion
			conn.connect(); // Abro la conexion

			int tiempoRespuesta1 = conn.getResponseCode(); // Para manejo de
															// Situaciones

			if (tiempoRespuesta1 != 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta1);
			} else {
				StringBuilder informacionString1 = new StringBuilder();
				File f1 = new File("Produccion_Madrid" + LocalDate.now() + ".txt");
				FileWriter fw1 = new FileWriter(f1);
				BufferedWriter escritura1 = new BufferedWriter(fw1);
				Scanner sc1 = new Scanner(url1.openStream());
				while(sc1.hasNext())
				{
					informacionString1.append(sc1.nextLine());
					informacionString1.append(System.getProperty("line.separator"));
					
					JSONObject respuesta1 = new JSONObject(informacionString1.toString()) ;
					JSONObject temperaturas1 = respuesta1.getJSONArray("ciudades").getJSONObject(0).getJSONObject("temperatures");
					int temperaturaMaxMad = temperaturas1.getInt("max");
					System.out.println("La temperatura máxima para hoy en Madrid es: " + temperaturaMaxMad);
					String produccion = tp.produccionActivaMadrid(temperaturaMaxMad);
					System.out.println(produccion);
					escritura1.write("La temperatura máxima para hoy en Barcelona es: " + temperaturaMaxMad);
					escritura1.write(produccion);
			}
				sc1.close();
				escritura1.close();
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void barcelona(Tiempo tp) {
		try {

			URL url = new URL("https://www.el-tiempo.net/api/json/v2/provincias/08"); // Declaro la URL
			HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Declaro la conexion
			conn.connect(); // Abro la conexion

			int tiempoRespuesta = conn.getResponseCode(); // Para manejo de
															// Situaciones

			if (tiempoRespuesta != 200) {
				throw new RuntimeException("HttpResponse" + tiempoRespuesta);
			} else {
				StringBuilder informacionString = new StringBuilder();
				File f = new File("Produccion_Barcelona" + LocalDate.now() + ".txt");
				FileWriter fw = new FileWriter(f);
				BufferedWriter escritura = new BufferedWriter(fw);
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					informacionString.append(sc.nextLine());
					informacionString.append(System.getProperty("line.separator"));
					
					JSONObject respuesta = new JSONObject(informacionString.toString()) ;
					JSONObject temperaturas = respuesta.getJSONArray("ciudades").getJSONObject(0).getJSONObject("temperatures");
					int temperaturaMax = temperaturas.getInt("max");
					System.out.println("La temperatura máxima para hoy en Barcelona es: " + temperaturaMax);
					String produccion = tp.produccionActivaBarcelona(temperaturaMax);
					System.out.println(produccion);
					escritura.write("La temperatura máxima para hoy en Barcelona es: " + temperaturaMax);
					escritura.write(produccion);
			}
				sc.close();
				escritura.close();
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
	}
		@Override
		public String produccionActivaBarcelona(int temperaturaMax) {
			String resultado;
			ArrayList<Producto> barcelona = Barcelona();
			
			if(temperaturaMax > 10) {
				  resultado = "\n" + "Hoy se ha producido: " + "\n" + barcelona.toString();
				
			}else{
					resultado = "Por condiciones climaticas no se ha podido trabajar el día " + LocalDate.now().getDayOfWeek();
			}
			return resultado;
			
			
		
		}
		@Override
		public String produccionActivaMadrid(int temperaturaMaxMad) {
			String resultado;
			ArrayList<Producto> madrid = Madrid();
			
			if(temperaturaMaxMad > 20) {
				  resultado = "\n" + "Hoy se ha producido: " + "\n" + madrid.toString();
				
			}else if(temperaturaMaxMad > 5 && temperaturaMaxMad < 20){
				resultado = "Se realizaron tareas administrativas";
		}
		else{
					resultado = "Por condiciones climaticas no se ha podido trabajar el día " + LocalDate.now().getDayOfWeek();
			}
			return resultado;
		}
		private ArrayList<Producto> Barcelona() {
			Producto c1 = new Producto();
			c1.nombre = "Zapatillas";
			c1.generado = 100;
			c1.costo = 1000;
			c1.esperado = 15000;
			c1.estimado = c1.esperado - c1.costo;
			
			Producto c2 = new  Producto();
			c2.nombre = "Remeras";
			c2.generado = 50;
			c2.costo = 500;
			c2.esperado = 7000;
			c2.estimado = c2.esperado - c2.costo;
			
			Producto c3 = new  Producto();
			c3.nombre = "Pantalones";
			c3.generado = 25;
			c3.costo = 750;
			c3.esperado = 18000;
			c3.estimado = c3.esperado - c3.costo;
			
			Producto c4 = new  Producto();
			c4.nombre = "Cinturones";
			c4.generado = 10;
			c4.costo = 500;
			c4.esperado = 5000;
			c4.estimado = c4.esperado - c4.costo;
			
			ArrayList<Producto> barcelona = new ArrayList<>();
			barcelona.add(c1);
			barcelona.add(c2);
			barcelona.add(c3);
			barcelona.add(c4);
			
			return barcelona;
			
		}
		private ArrayList<Producto> Madrid() {
			Producto c1 = new Producto();
			c1.nombre = "Zapatillas";
			c1.generado = 100;
			c1.costo = 1000;
			c1.esperado = 15000;
			c1.estimado = c1.esperado - c1.costo;
			
			Producto c2 = new  Producto();
			c2.nombre = "Remeras";
			c2.generado = 50;
			c2.costo = 500;
			c2.esperado = 7000;
			c2.estimado = c2.esperado - c2.costo;
			
			Producto c3 = new  Producto();
			c3.nombre = "Pantalones";
			c3.generado = 25;
			c3.costo = 750;
			c3.esperado = 18000;
			c3.estimado = c3.esperado - c3.costo;
			
			Producto c4 = new  Producto();
			c4.nombre = "Cinturones";
			c4.generado = 10;
			c4.costo = 500;
			c4.esperado = 5000;
			c4.estimado = c4.esperado - c4.costo;
			
			Producto c5 = new  Producto();
			c5.nombre = "Camisas";
			c5.generado = 100;
			c5.costo = 10000;
			c5.esperado = 15000;
			c5.estimado = c5.esperado - c5.costo;
			
			Producto c6 = new  Producto();
			c6.nombre = "Blusas";
			c6.generado = 5;
			c6.costo = 500;
			c6.esperado = 7000;
			c6.estimado = c6.esperado - c6.costo;
			
			Producto c7 = new  Producto();
			c7.nombre = "Cardigan";
			c7.generado = 2;
			c7.costo = 750;
			c7.esperado = 18000;
			c7.estimado = c7.esperado - c7.costo;
			
			Producto c8 = new  Producto();
			c8.nombre = "Chaqueta";
			c8.generado = 10;
			c8.costo = 500;
			c8.esperado = 5000;
			c8.estimado = c8.esperado - c8.costo;
			
			ArrayList<Producto> madrid = new ArrayList<>();
			madrid.add(c1);
			madrid.add(c2);
			madrid.add(c3);
			madrid.add(c4);
			madrid.add(c5);
			madrid.add(c6);
			madrid.add(c7);
			madrid.add(c8);
			
			return madrid;
		}
}
	interface Produccion{
		public String produccionActivaBarcelona(int temperaturaMax);
		public String produccionActivaMadrid(int temperaturaMax);
			}
class Producto{
	String nombre;
	int generado;
	int costo;
	int esperado;
	int estimado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGenerado() {
		return generado;
	}
	public void setGenerado(int generado) {
		this.generado = generado;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public int getEsperado() {
		return esperado;
	}
	public void setEsperado(int esperado) {
		this.esperado = esperado;
	}
	public int getEstimado() {
		return estimado;
	}
	public void setEstimado(int estimado) {
		this.estimado = estimado;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", generado=" + generado + ", costo=" + costo + ", esperado=" + esperado
				+ ", estimado=" + estimado + "]" + "\n";
	}
}
