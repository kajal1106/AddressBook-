package Stack;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Stack;

import LinkedList.AddressbookNode;

public interface StackInterfaceAddressbook extends Remote {
	public boolean insert(AddressbookNode n) throws RemoteException;
	public Stack<AddressbookNode> print() throws RemoteException;
	public AddressbookNode search(int id2) throws RemoteException;
	public boolean removeNode(int id2) throws RemoteException;
	public boolean update(AddressbookNode s) throws RemoteException;
	public Stack<AddressbookNode> removeAll() throws RemoteException;
	public boolean searchbylname(String lastname) throws RemoteException;
	public int countCity(String city1)  throws RemoteException;
	public int countFemale() throws RemoteException;
	public int countMale() throws RemoteException;


}
