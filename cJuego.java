// IMPLEMENTACION DEL CLIENTE
import java.util.Random;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class cJuego 
{
	//el cliente como llama a metodos remotos maneja excepciones
	public static void main(String [] args) throws Exception
	{
		//los obtejos remotos son pasados por referencia
		iJuego conexion = (iJuego)Naming.lookup("//"+java.net.InetAddress.getLocalHost().getHostAddress()+":1066/Servidor");

		//el cliente de objetos remotos se comunican con internfaces remotas disenadas previamente
		conexion.reset();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Numero?");		
		if(conexion.hacerIntento(sc.nextInt()))
			System.out.println("Has acertado!");
		else
			System.out.println("Has fallado!");
	}
}
