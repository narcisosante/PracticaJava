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
	    Jenkins.append("echo 'Provincia [nombre=A Coruña, capital=A Coruña], Provincia [nombre=Alacant, capital=Alacant], Provincia [nombre=Albacete, capital=Albacete], Provincia [nombre=Almería, capital=Almería], Provincia [nombre=Araba, capital=Araba], Provincia [nombre=Asturias, capital=Asturias], Provincia [nombre=Badajoz, capital=Badajoz], Provincia [nombre=Barcelona, capital=Barcelona], Provincia [nombre=Bizkaia, capital=Bizkaia], Provincia [nombre=Burgos, capital=Burgos], Provincia [nombre=Cantabria, capital=Cantabria], Provincia [nombre=Castelló, capital=Castelló], Provincia [nombre=Ceuta, capital=Ceuta], Provincia [nombre=Ciudad Real, capital=Ciudad Real], Provincia [nombre=Cuenca, capital=Cuenca], Provincia [nombre=Cáceres, capital=Cáceres], Provincia [nombre=Cádiz, capital=Cádiz], Provincia [nombre=Córdoba, capital=Córdoba], Provincia [nombre=Gipuzcoa, capital=Gipuzcoa], Provincia [nombre=Girona, capital=Girona], Provincia [nombre=Granada, capital=Granada], Provincia [nombre=Guadalajara, capital=Guadalajara], Provincia [nombre=Huelva, capital=Huelva], Provincia [nombre=Huesca, capital=Huesca], Provincia [nombre=Illes Balears, capital=Illes Balears], Provincia [nombre=Jaén, capital=Jaén], Provincia [nombre=La Rioja, capital=La Rioja], Provincia [nombre=Las Palmas, capital=Las Palmas], Provincia [nombre=León, capital=León], Provincia [nombre=Lleida, capital=Lleida], Provincia [nombre=Lugo, capital=Lugo], Provincia [nombre=Madrid, capital=Madrid], Provincia [nombre=Melilla, capital=Melilla], Provincia [nombre=Murcia, capital=Murcia], Provincia [nombre=Málaga, capital=Málaga], Provincia [nombre=Navarra, capital=Navarra], Provincia [nombre=Ourense, capital=Ourense], Provincia [nombre=Palencia, capital=Palencia] Provincia [nombre=Pontevedra, capital=Pontevedra], Provincia [nombre=Salamanca, capital=Salamanca], Provincia [nombre=Santa Cruz de Tenerife, capital=Santa Cruz de Tenerife], Provincia [nombre=Segovia, capital=Segovia], Provincia [nombre=Sevilla, capital=Sevilla], Provincia [nombre=Soria, capital=Soria], Provincia [nombre=Tarragona, capital=Tarragona], Provincia [nombre=Teruel, capital=Teruel], Provincia [nombre=Toledo, capital=Toledo], Provincia [nombre=Valladolid, capital=Valladolid], Provincia [nombre=València, capital=València], Provincia [nombre=Zamora, capital=Zamora], Provincia [nombre=Zaragoza, capital=Zaragoza], Provincia [nombre=Ávila, capital=Ávila]' \r\n");
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