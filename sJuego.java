// IMPLEMENTACION DEL SERVIDOR 
// IMPLEMENTACION DE LA INTERFAZ iJuego
	
import java.util.Random;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.*;

// el servidor extiende a UnicastRemoteObject 
// el servidor implementa a iClase
public class sJuego extends UnicastRemoteObject implements iJuego 
{
	static int numAlea;
	
	//el servidor tiene un constructor nulo q lanza la excepcion RemoteExcepcion
	public sJuego() throws RemoteException {}
	
	//>> implementacion de los metodos de la interfaz lanzando RemoteException
	public void reset()
	{
		numAlea= (int)Math.floor(Math.random()*100);
		System.out.println("Iniciando juego.."+numAlea);		
	}
	
	public boolean hacerIntento(int n)
	{
		System.out.println("Comprobando acierto..");
		if(n==numAlea)
			return true;
		else 
			return false;	
	}
	
	//_el metodo main lanza una exception
	public static void main(String [] args) throws Exception {
		//el metodo main del servidor crea los objetos remotos
		sJuego juego= new sJuego();
		Naming.bind("//"+java.net.InetAddress.getLocalHost().getHostAddress()+":1066/Servidor", juego);
		System.out.println("Servidor remoto preparado..");
	}
}
