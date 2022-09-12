import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Spain extends Provincia implements Jenkins{
	
	
	static Usuario us = new Usuario(1, "Narciso", LocalDate.now());

	public Spain(String nombre, String capital) {
		super(nombre, capital);
		// TODO Auto-generated constructor stub
	}

	

	public static void main (String [] args) throws IOException {
		Spain sp = new Spain(null, null);
		
		

	try
	{
	
		URL url = new URL ("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&lang=sp&rows=0&sort=-provincia&facet=ccaa&facet=provincia"); //Declaro la URL
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
            String json = "";
            while(sc.hasNextLine()) {
                json = json + sc.nextLine();
            }
            sc.close();
            JSONObject objetoJSON = new JSONObject(json);
            JSONArray arrayJSON = (JSONArray) objetoJSON.get("facet_groups");
            objetoJSON = (JSONObject) arrayJSON.get(1);
            arrayJSON = (JSONArray) objetoJSON.get("facets");
            
            List<Provincia> listaProvincia = new ArrayList<>();
            for(Object iter:arrayJSON) {
                listaProvincia.add(new Provincia(((JSONObject) iter).getString("name"), ((JSONObject) iter).getString("path")));
            }
            
			System.out.println("Bienvenido " + us.toString() + listaProvincia);
			escritura.write("Bienvenido " + us.toString() + listaProvincia.toString());
			//escritura.write(listaProvincia.toString());
			escritura.close();	
			
	
		}
		
		sp.Jenkins();
	}

			catch (Exception e)
			{
				e.printStackTrace();
			}
	}

	@Override
	public void Jenkins() throws IOException {
		StringBuilder Jenkins = new StringBuilder();
		   
	    Jenkins.append("pipeline{\r\n");
	    Jenkins.append("agent any \r\n");
	    Jenkins.append("stages{ \r\n");
	    Jenkins.append("stage('Main'){ \r\n");
	    Jenkins.append("steps{ \r\n");
	    Jenkins.append("echo 'Provincia [nombre=A Coruña, capital=A Coruña]\r\n"
	    		+ ", Provincia [nombre=Alacant, capital=Alacant]\r\n"
	    		+ ", Provincia [nombre=Albacete, capital=Albacete]\r\n"
	    		+ ", Provincia [nombre=Almería, capital=Almería]\r\n"
	    		+ ", Provincia [nombre=Araba, capital=Araba]\r\n"
	    		+ ", Provincia [nombre=Asturias, capital=Asturias]\r\n"
	    		+ ", Provincia [nombre=Badajoz, capital=Badajoz]\r\n"
	    		+ ", Provincia [nombre=Barcelona, capital=Barcelona]\r\n"
	    		+ ", Provincia [nombre=Bizkaia, capital=Bizkaia]\r\n"
	    		+ ", Provincia [nombre=Burgos, capital=Burgos]\r\n"
	    		+ ", Provincia [nombre=Cantabria, capital=Cantabria]\r\n"
	    		+ ", Provincia [nombre=Castelló, capital=Castelló]\r\n"
	    		+ ", Provincia [nombre=Ceuta, capital=Ceuta]\r\n"
	    		+ ", Provincia [nombre=Ciudad Real, capital=Ciudad Real]\r\n"
	    		+ ", Provincia [nombre=Cuenca, capital=Cuenca]\r\n"
	    		+ ", Provincia [nombre=Cáceres, capital=Cáceres]\r\n"
	    		+ ", Provincia [nombre=Cádiz, capital=Cádiz]\r\n"
	    		+ ", Provincia [nombre=Córdoba, capital=Córdoba]\r\n"
	    		+ ", Provincia [nombre=Gipuzcoa, capital=Gipuzcoa]\r\n"
	    		+ ", Provincia [nombre=Girona, capital=Girona]\r\n"
	    		+ ", Provincia [nombre=Granada, capital=Granada]\r\n"
	    		+ ", Provincia [nombre=Guadalajara, capital=Guadalajara]\r\n"
	    		+ ", Provincia [nombre=Huelva, capital=Huelva]\r\n"
	    		+ ", Provincia [nombre=Huesca, capital=Huesca]\r\n"
	    		+ ", Provincia [nombre=Illes Balears, capital=Illes Balears]\r\n"
	    		+ ", Provincia [nombre=Jaén, capital=Jaén]\r\n"
	    		+ ", Provincia [nombre=La Rioja, capital=La Rioja]\r\n"
	    		+ ", Provincia [nombre=Las Palmas, capital=Las Palmas]\r\n"
	    		+ ", Provincia [nombre=León, capital=León]\r\n"
	    		+ ", Provincia [nombre=Lleida, capital=Lleida]\r\n"
	    		+ ", Provincia [nombre=Lugo, capital=Lugo]\r\n"
	    		+ ", Provincia [nombre=Madrid, capital=Madrid]\r\n"
	    		+ ", Provincia [nombre=Melilla, capital=Melilla]\r\n"
	    		+ ", Provincia [nombre=Murcia, capital=Murcia]\r\n"
	    		+ ", Provincia [nombre=Málaga, capital=Málaga]\r\n"
	    		+ ", Provincia [nombre=Navarra, capital=Navarra]\r\n"
	    		+ ", Provincia [nombre=Ourense, capital=Ourense]\r\n"
	    		+ ", Provincia [nombre=Palencia, capital=Palencia]\r\n"
	    		+ ", Provincia [nombre=Pontevedra, capital=Pontevedra]\r\n"
	    		+ ", Provincia [nombre=Salamanca, capital=Salamanca]\r\n"
	    		+ ", Provincia [nombre=Santa Cruz de Tenerife, capital=Santa Cruz de Tenerife]\r\n"
	    		+ ", Provincia [nombre=Segovia, capital=Segovia]\r\n"
	    		+ ", Provincia [nombre=Sevilla, capital=Sevilla]\r\n"
	    		+ ", Provincia [nombre=Soria, capital=Soria]\r\n"
	    		+ ", Provincia [nombre=Tarragona, capital=Tarragona]\r\n"
	    		+ ", Provincia [nombre=Teruel, capital=Teruel]\r\n"
	    		+ ", Provincia [nombre=Toledo, capital=Toledo]\r\n"
	    		+ ", Provincia [nombre=Valladolid, capital=Valladolid]\r\n"
	    		+ ", Provincia [nombre=València, capital=València]\r\n"
	    		+ ", Provincia [nombre=Zamora, capital=Zamora]\r\n"
	    		+ ", Provincia [nombre=Zaragoza, capital=Zaragoza]\r\n"
	    		+ ", Provincia [nombre=Ávila, capital=Ávila]' \r\n");
	    Jenkins.append("} \r\n");
	    Jenkins.append("} \r\n");
	    Jenkins.append("} \r\n");
	    Jenkins.append("} \r\n");
	    

	    
	    File j = new File("Jenkinsfile_spain.txt");
		FileWriter fw1 = new FileWriter(j);
		BufferedWriter bw2 = new BufferedWriter(fw1);
	    bw2.write(Jenkins.toString());
	    
		bw2.close();
		}
		
	}

class Provincia extends Capital{
	
	String nombre;
	String capital;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", capital=" + capital + "]" + "\n";
	}
	public Provincia(String nombre, String capital) {
		super();
		this.nombre = nombre;
		this.capital = capital;
	}
	
	
}
class Capital{
	String Capital;
}
class Usuario{
	
	int ID_Usuario;
	String nombre_usuario;
	LocalDate fecha;
	public int getID_Usuario() {
		return ID_Usuario;
	}
	public void setID_Usuario(int iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		//return "Usuario [ID_Usuario=" + ID_Usuario + ", nombre_usuario=" + nombre_usuario + ", fecha=" + fecha + "]";
		return " " + nombre_usuario + ", con ID=" + ID_Usuario + ". Hoy es " + fecha + "\n" ;
	}
	public Usuario(int iD_Usuario, String nombre_usuario, LocalDate fecha) {
		super();
		ID_Usuario = iD_Usuario;
		this.nombre_usuario = nombre_usuario;
		this.fecha = fecha;
	}	
}
interface Jenkins{
	public void Jenkins() throws IOException;
}