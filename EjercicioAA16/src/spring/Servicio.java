package spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
	
	public void generarTxt() {
		
		System.out.println("Se va a generar un archivo txt");
		
		
	}
public void comprobarTxt(){
		
		System.out.println("S� son archivos txt");
		
		
	}
public void confirmarTxt(){
	
	System.out.println("Se gener� el archivo txt");
	
	
}
}