package Stack;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

import LinkedList.AddressbookNode;

public class StackImplAddressbook extends UnicastRemoteObject implements StackInterfaceAddressbook {
Stack<AddressbookNode> l = new Stack<AddressbookNode>();

private AddressbookNode node;
//public static int counter = 0 ;



	public StackImplAddressbook() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub

		try{
			File stackFile = new File("Stack");
			if(stackFile.exists()) {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("Stack"));
		l=(Stack<AddressbookNode>)in.readObject();
		in.close();}}
		catch(Exception e){}
	}



	@Override
	public boolean insert(AddressbookNode n) throws RemoteException {
		// TODO Auto-generated method stub
		if(l.add(n))
			return true;
		else return false;

	}



	@Override
	public Stack<AddressbookNode> print() throws RemoteException {
		// TODO Auto-generated method stub
		return l;

	}



	@Override
	public AddressbookNode search(int s) throws RemoteException {
		// TODO Auto-generated method stub
		AddressbookNode node = null;
		ListIterator<AddressbookNode> iter = l.listIterator();
	
		  while(iter.hasNext())
		  {        AddressbookNode temp =iter.next();
		            if (s==(temp.getId2())) {
		            	 node = temp;}         
		  }
		return node;
	}



	@Override
	public boolean removeNode(int s) throws RemoteException {
		// TODO Auto-generated method stub
		boolean res=false;
		 for(Iterator<AddressbookNode> iter = l.iterator(); 
				 iter.hasNext();) {
			    AddressbookNode data = iter.next();
			    if (data.getId2() == s) {
			        iter.remove();
			        res = true;
			    }
			}
		return res;
	}



	@Override
	public boolean update(AddressbookNode s) throws RemoteException {
		// TODO Auto-generated method stub
		AddressbookNode node = null;
		ListIterator<AddressbookNode> iter = l.listIterator();
		boolean result = false;
		  while(iter.hasNext())
		  {        AddressbookNode temp =iter.next();
		            if (s.getId2()==(temp.getId2())) {
		             temp.setFirstname(s.getFirstname());
		             temp.setLastname(s.getLastname());
		             temp.setMobile1(s.getMobile1());
		             temp.setGender(s.getGender());
		             temp.setAddress1(s.getAddress1());
		             temp.setCity1(s.getCity1());
		             temp.setEmail1(s.getEmail1());
		            result = true;	
		            }         
		  }
		return result;
	}



	@Override
	public Stack<AddressbookNode> removeAll() throws RemoteException {
		// TODO Auto-generated method stub
		l.clear();
		return l;	}



	@Override
	public boolean searchbylname(String s) throws RemoteException {
		// TODO Auto-generated method stub
		AddressbookNode node = null;
		ListIterator<AddressbookNode> iter = l.listIterator();
		boolean result = false;
		  while(iter.hasNext())
		  {        AddressbookNode temp =iter.next();
		            if (temp.getLastname().equals(s)) {
		            	 result=true;}         
		  }
		
	
		return result;

	}



	@Override
	public int countCity(String city1) throws RemoteException {
		// TODO Auto-generated method stub
		int count = 0; 
        ListIterator<AddressbookNode> iter = l.listIterator();
        while(iter.hasNext())
		  {        AddressbookNode temp =iter.next();
		            if (temp.getCity1().equals(city1)) {
		             count = count + 1;
		            }         
		  }
        return count;
		
	}



	@Override
	public int countFemale() throws RemoteException {
		// TODO Auto-generated method stub
		int count = 0; 
        ListIterator<AddressbookNode> iter = l.listIterator();
        while(iter.hasNext())
		  {        AddressbookNode temp =iter.next();
		            if (temp.getGender().equals("Female")) {
		             count++;
		            }  
		  }
		return count;
	}



	@Override
	public int countMale() throws RemoteException {
		// TODO Auto-generated method stub
		 int count = 0; 
	        ListIterator<AddressbookNode> iter = l.listIterator();
	        while(iter.hasNext())
			  {        AddressbookNode temp =iter.next();
			            if (temp.getGender().equals("Male")) {
			             count++;
			            }  
			  }
		return count;
	}

		
	}
