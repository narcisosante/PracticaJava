import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SquareEnix extends Videojuegos implements CalculoTotal {

	public static void main (String [] arg) throws Exception {
	
		SquareEnix sq = new SquareEnix();
		sq.CalculoPrecio();
		ArrayList<SquareEnix> array = new ArrayList<SquareEnix>();
		
		SquareEnix c1 = new SquareEnix ();
		c1.nombre = "NieR Replicant ver.1.22474487139";
		c1.precio = 59.99;
		c1.ventas = 60000;
		c1.montoTotal = sq.CalculoPrecio(c1.ventas, c1.precio);
		
		SquareEnix c2 = new SquareEnix ();
		c2.nombre = "NieR Replicant ver.1.22474487139";
		c2.precio = 59.99;
		c2.ventas = 60000;
		c2.montoTotal = sq.CalculoPrecio(c2.ventas, c2.precio);
		
		SquareEnix c3 = new SquareEnix ();
		c3.nombre = "FINAL FANTASY XIV Online";
		c3.precio = 14.99;
		c3.ventas = 360000;
		c3.montoTotal = sq.CalculoPrecio(c3.ventas, c3.precio);
		
		SquareEnix c4 = new SquareEnix ();
		c4.nombre = "KINGDOM HEARTS III";
		c4.precio = 69.99;
		c4.ventas = 20000;
		c4.montoTotal = sq.CalculoPrecio(c4.ventas, c4.precio);
		
		SquareEnix c5 = new SquareEnix ();
		c5.nombre = "Voice of Cards: The Isle Dragon Roars";
		c5.precio = 29.99;
		c5.ventas = 6000;
		c5.montoTotal = sq.CalculoPrecio(c5.ventas, c5.precio);
		
		SquareEnix c6 = new SquareEnix ();
		c6.nombre = "Triangle Strategy";
		c6.precio = 49.99;
		c6.ventas = 60000;
		c6.montoTotal = sq.CalculoPrecio(c6.ventas, c6.precio);
		
		array.add(c1);
		array.add(c2);
		array.add(c3);
		array.add(c4);
		array.add(c5);
		array.add(c6);
	
		File f = new File("Videojuegos_"  + LocalDate.now() + ".txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter escritura = new BufferedWriter(fw);

		
		for(int i = 0; i < array.size(); i++ ) {
			
		
		escritura.write(array.get(i).toString() + "\n");
		}
		escritura.close();
		System.out.println(array);
		
	}

	@Override
	public double CalculoPrecio(double ventas, double precio) {

		montoTotal = ventas * precio;
		return montoTotal;
	}

	@Override
	public double CalculoPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

}

interface CalculoTotal {

	public double CalculoPrecio();

	double CalculoPrecio(double ventas, double precio);
}