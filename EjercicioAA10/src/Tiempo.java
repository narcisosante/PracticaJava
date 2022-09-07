import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Tiempo {
	public static void main (String [] args) 
	{
		
		//SIEMPRE QUE USEMOS API REST, TRY-CATCH
	
		try
		{
		
			URL url = new URL ("https://www.el-tiempo.net/api/json/v2/provincias/28"); //Declaro la URL
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
				StringBuilder informacionTiempo = new StringBuilder();
				Scanner scanner = new Scanner(url.openStream());
				System.out.println("Digame su nombre");
				String nombre = "";
				Scanner sc = new Scanner(System.in);
				nombre = sc.nextLine();
				System.out.println("bienvenido "+ nombre + ". Le dejo aquí la información del clima actual:");
				sc.close();
				while(scanner.hasNext())
				{
					informacionTiempo.append(scanner.nextLine());
				System.out.println(informacionTiempo);
				}
			}
				
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}
}
