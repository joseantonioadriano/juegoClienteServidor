// INTERFAZ REMOTA
 
 import java.rmi.*;

// la interfaz es PUBLICA y extiende a Remote
public interface iJuego extends Remote 
{
	// los metodos lanzan la excepcion RemoteException	
	public void reset() throws RemoteException;
	public boolean hacerIntento(int n) throws RemoteException;
}

