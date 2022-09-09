
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TopPeliculas extends Pelicula {
public TopPeliculas(Integer posicion, String nombre, String recaudado) {
		super(posicion, nombre, recaudado);
	
}
public static void main (String [] arg) throws IOException {
	Set<String> ts1 = new TreeSet<>();
	Pelicula p1 = new Pelicula(1,"Avatar", "2.847.397.339");
	Pelicula p2 = new Pelicula(2,"Avengers: Endgame", "2.797.501.328");
	Pelicula p3 = new Pelicula(3,"Titanic", "2.201.647.264");
	Pelicula p4 = new Pelicula(4,"Star Wars: Episode VII - The Force Awakens", "2.069.521.700");
	Pelicula p5 = new Pelicula(5,"Avengers: Infinity War", "2.048.359.754");
	Pelicula p6 = new Pelicula(6,"Spider-Man: No Way Home", "1.910.675.428");
	Pelicula p7 = new Pelicula(7,"Jurassic World", "1.671.537.444");
	Pelicula p8 = new Pelicula(8,"The Lion King", "1.663.250.487");
	Pelicula p9 = new Pelicula(9,"Avatar", "2.847.397.339");
	Pelicula p10 = new Pelicula(10,"The Avengers", "1.515.341.399");
	
	File doc = new File("C:\\Users\\Usuario\\Downloads\\Peliculas_11_20.txt");
	FileReader fr = new FileReader (doc);
	BufferedReader br = new BufferedReader(fr);
	 String linea;
     while((linea=br.readLine())!=null)
    	 ts1.add(linea.toString());
     
	
	
	ts1.add(p1.toString());
	ts1.add(p2.toString());
	ts1.add(p3.toString());
	ts1.add(p4.toString());
	ts1.add(p5.toString());
	ts1.add(p6.toString());
	ts1.add(p7.toString());
	ts1.add(p8.toString());
	ts1.add(p9.toString());
	ts1.add(p10.toString());
	
	String cadena = ts1.toString();
	String cadenaSinComas = cadena.replace(",", "\n");
	
	File f = new File("top20_peliculas.txt");
	FileWriter fw = new FileWriter(f);
	BufferedWriter bw = new BufferedWriter(fw);

	
		bw.write(cadenaSinComas);
		System.out.println(cadenaSinComas);
		bw.close();

	
	
	
	
	StringBuilder Jenkins = new StringBuilder();
    Jenkins.append("import java.time.LocalDate\r\n");
    Jenkins.append("pipeline{\r\n");
    Jenkins.append("agent any \r\n");
    Jenkins.append("stages{ \r\n");
    Jenkins.append("stage('Main'){ \r\n");
    Jenkins.append("steps{ \r\n");
    Jenkins.append("script{ \r\n");
    Jenkins.append("def fecha = LocalDate.now() \r\n");
    Jenkins.append("def texto = 'Hola Mundo! EL día de hoy es ' + fecha.getDayOfWeek() + '.' \r\n");
    Jenkins.append("def texto2 = ' Este curso me hizo pensar mas de lo que me hubiese gustado ' \r\n");
    Jenkins.append("println texto \r\n");
    Jenkins.append("println texto2 \r\n");
    Jenkins.append("} \r\n");
    Jenkins.append("} \r\n");
    Jenkins.append("} \r\n");
    Jenkins.append("} \r\n");
    Jenkins.append("} \r\n");

    
    File j = new File("Jenkinsfile_peliculas.txt");
	FileWriter fw1 = new FileWriter(j);
	BufferedWriter bw2 = new BufferedWriter(fw1);
    bw2.write(Jenkins.toString());
    
	bw2.close();
	
}

}
class Pelicula{
	int posicion;
	String nombre;
	String recaudado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRecaudado() {
		return recaudado;
	}
	public void setRecaudado(String recaudado) {
		this.recaudado = recaudado;
	}
	
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public Pelicula(int posicion, String nombre, String recaudado) {
		super();
		this.posicion = posicion;
		this.nombre = nombre;
		this.recaudado = recaudado;
	}
	@Override
	public String toString() {
		return    recaudado + "$ " +  nombre  + "";
	}
	
	
	
}