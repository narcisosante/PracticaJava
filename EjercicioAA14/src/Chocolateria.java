import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import org.json.JSONObject;

public class Chocolateria extends Chocolate implements Produccion{
	
	private ArrayList<Chocolate> chocos() {
		Chocolate c1 = new Chocolate();
		c1.tipo = "Blanco";
		c1.cantidad = 1000;
		Chocolate c2 = new  Chocolate();
		c2.tipo = "Negro";
		c2.cantidad = 1500;
		Chocolate c3 = new  Chocolate();
		c3.tipo = "Negro";
		c3.cantidad = 1500;
		Chocolate c4 = new  Chocolate();
		c4.tipo = "Negro";
		c4.cantidad = 1500;
		Chocolate c5 = new  Chocolate();
		c5.tipo = "Negro";
		c5.cantidad = 1500;
		Chocolate c6 = new  Chocolate();
		c6.tipo = "Negro";
		c6.cantidad = 1500;
		
		ArrayList<Chocolate> choco = new ArrayList<>();
		choco.add(c1);
		choco.add(c2);
		choco.add(c3);
		choco.add(c4);
		choco.add(c5);
		choco.add(c6);
		return choco;
	}
	




	public static void main (String [] args) throws IOException {
	Chocolateria ch = new Chocolateria();
	
	
	
	
	
	

	try
	{
	
		URL url = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/41"); //Declaro la URL
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //Declaro la conexion
		conn.connect(); //Abro la conexion
		
		int tiempoRespuesta = conn.getResponseCode(); //Para manejo de 
													  //Situaciones
		
		if(tiempoRespuesta != 200)
		{
			throw new RuntimeException("HttpResponse" + tiempoRespuesta);
		}
		else
		{	
			StringBuilder informacionString = new StringBuilder();
			File f = new File("salida_" + LocalDate.now() + ".txt");
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
				System.out.println("La temperatura máxima para hoy es: " + temperaturaMax);
				String chocolate = ch.produccionActiva(temperaturaMax);
				System.out.println(chocolate);
				escritura.write("La temperatura máxima para hoy es: " + temperaturaMax);
				
				escritura.write(chocolate);
				
				
				
				 
			}
			sc.close();
			escritura.close();
							
		}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	StringBuilder Jenkins = new StringBuilder();
   
    Jenkins.append("pipeline{\r\n");
    Jenkins.append("agent any \r\n");
    Jenkins.append("stages{ \r\n");
    Jenkins.append("stage('Main'){ \r\n");
    Jenkins.append("steps{ \r\n");
    Jenkins.append("echo 'Chocolate [tipo=Blanco, cantidad producida=1000] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500] Chocolate [tipo=Negro, cantidad producida=1500]' \r\n");
    Jenkins.append("} \r\n");
    Jenkins.append("} \r\n");
    Jenkins.append("} \r\n");
    Jenkins.append("} \r\n");
    

    
    File j = new File("Jenkinsfile_chocolate.txt");
	FileWriter fw1 = new FileWriter(j);
	BufferedWriter bw2 = new BufferedWriter(fw1);
    bw2.write(Jenkins.toString());
    
	bw2.close();
	}
	


	@Override
	public String produccionActiva(int temperaturaMax) {
		String resultado;
		ArrayList<Chocolate> choco = chocos();
		if(temperaturaMax < 40) {
			  resultado = "\n" + "Hoy se ha producido: " + "\n" + choco.toString();
			
		}else{
				resultado = "No se pudo producir nada, puesto que la temperatura era demasiado alta!";
		}
		return resultado;
		
		
	
	}





	
	

}
class Chocolate extends Golosina{
	String tipo;
	Golosina golosina = new Golosina();
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Golosina getGolosina() {
		return golosina;
	}
	public void setGolosina(Golosina golosina) {
		this.golosina = golosina;
	}
	@Override
	public String toString() {
		return "Chocolate [tipo=" + tipo + ", cantidad producida=" + cantidad + "]" + "\n";
	}
	
	
}
class Golosina{
	int cantidad;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
interface Produccion{
	public String produccionActiva(int temperaturaMax);
		}
