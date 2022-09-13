package spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component


public class AspectoLog 
{
	@Before("execution(* generarTxt())")
	public void log()
	{
		System.out.println("Estas por ejecutar un TXT");
		
	}
	
	@After("execution(* generarTxt())")
	public void log1() {
		
		System.out.println("comprobando usuario");
		
	}
	
	
	
}
