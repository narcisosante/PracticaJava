import java.util.Scanner;

public class Adivina extends Usuario {

	public static void main(String[] args) {
		Usuario us = new Usuario();
		
		Juego juego = (Jugador) -> {
		Scanner sc = new Scanner(System.in);
		int n1, n2, n3;
		n1 = (int) ((Math.random() * 1000000) + 1);
		System.out.println("D�game su nombre");
		us.nombre = sc.nextLine();
		System.out.println("Bienvenido " + us.nombre + "\n"
				+ "Vamos a jugar a un juego de adivinar un n�mero entre 1 y 1000000. Tienes cinco intentos");
		System.out.println("Escribe el n�mero:");
		n2 = sc.nextInt();
		for (n3 = 0; n3 <= 4; n3++) {
			//comparar(n1, n2, n3, compara_lambda);

			if (n1 == n2) {
				//int resultado = formato.ejecutar(n1, n2, n3);
				System.out.println("has acertado!!!!");
				break;
			} else if (n3 == 4) {
				System.out.println("lo sentimos, perdiste! el n�mero era: " + n1);
				break;
			} if (n3 <= 1) {
				System.out.println("Siguiente intento!");
				n2 = sc.nextInt();
				
			} else if (n3 == 2) {
				System.out.println("Que no decaiga el �nimo, prueba otra vez!");
				n2 = sc.nextInt();
			} else if (n3 >= 3) {
				System.out.println("ULTIMO INTENTO!!!");
				n2 = sc.nextInt();
				
			}
		
		}
		sc.close();
		return 0;
	};
	juego.Jugar(us);
	}

	

public interface Juego {
		int Jugar(Usuario jugador);
	}

}

class Usuario {
	String nombre;
}