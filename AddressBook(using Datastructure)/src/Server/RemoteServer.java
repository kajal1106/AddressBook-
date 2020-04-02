package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import LinkedList.ImplAddressbook;
import Stack.StackImplAddressbook;
import Treeset.ImplAddressbookTree;

public class RemoteServer {
	public static void main(String args[]) throws RemoteException, MalformedURLException {
		LocateRegistry.createRegistry(1099); 
		System.out.println("java RMI registry created.");
		ImplAddressbook obj1 = new ImplAddressbook();
		StackImplAddressbook obj2 = new StackImplAddressbook();
		ImplAddressbookTree obj3 = new ImplAddressbookTree();
		Naming.rebind( "Nainsha", obj1 );   
		Naming.rebind( "Singh", obj2 ); 
		Naming.rebind( "Singhhhhh", obj3 ); 



	}

}
