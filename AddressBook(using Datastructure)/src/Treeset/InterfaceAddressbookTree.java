package Treeset;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

import LinkedList.AddressbookNode;

public interface InterfaceAddressbookTree extends Remote {
	public boolean insert(AddressbookNode n) throws RemoteException;
	public TreeSet<AddressbookNode> print() throws RemoteException;
	public AddressbookNode search(int id2) throws RemoteException;
	public boolean removeNode(int id2) throws RemoteException;
	public boolean update(AddressbookNode s) throws RemoteException;
	public TreeSet<AddressbookNode> removeAll() throws RemoteException;
	public boolean searchbylname(String lastname) throws RemoteException;
	public int countCity(String city1)  throws RemoteException;
	public int countFemale() throws RemoteException;
	public int countMale() throws RemoteException;
}
