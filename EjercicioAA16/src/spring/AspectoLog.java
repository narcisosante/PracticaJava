package spring;

import java.io.File;
import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component


public class AspectoLog 
{
	@Before("execution(* comprobarTxt())")
	public void log()
	{
		System.out.println("Estas por ejecutar un TXT");
		
	}
	@Before("execution(* generarTxt())")
	public void log1()
	{
		String doc3 = new String("C:\\Users\\Usuario\\Downloads\\Artistas 2021.txt");
		String doc2 = new String("C:\\Users\\Usuario\\Downloads\\Artistas 2020.txt");
		String doc1 = new String("C:\\Users\\Usuario\\Downloads\\Canciones_2020.txt");
		String doc = new String("C:\\Users\\Usuario\\Downloads\\Canciones_2021.txt");
		
		if(doc3.contains(".txt") && doc2.contains(".txt") && doc1.contains(".txt") && doc.contains(".txt"))
		
		System.out.println("se han comprobado si son archivos txt");
		
	}
	@After("execution(* comprobarTxt())")
	public void log2()
	{
		System.out.println("todo ok");
		
	}
}
