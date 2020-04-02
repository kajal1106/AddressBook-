package LinkedList;

import java.io.Serializable;

public class AddressbookNode implements Serializable, Comparable<AddressbookNode>{
	private int id2;
	private String firstname;
	private String lastname;
	private int mobile1;
	private String gender;
	private String address1;
	private String city1;
	private String email1;
	public AddressbookNode next;
	
	public AddressbookNode(int id2, String firstname, String lastname, int mobile1, String gender, String address1,
			String city1, String email1)  {
		super();
		
		this.id2 = id2;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobile1 = mobile1;
		this.gender = gender;
		this.address1 = address1;
		this.city1 = city1;
		this.email1 = email1;
	}
	
	@Override
	public String toString() {
		return "AddressbookNode [id2=" + id2 + ", firstname=" + firstname + ", lastname=" + lastname + ", mobile1="
				+ mobile1 + ", gender=" + gender + ", address1=" + address1 + ", city1=" + city1 + ", email1=" + email1
				+ ", next=" + next + "]";
	}

	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getMobile1() {
		return mobile1;
	}
	public void setMobile1(int mobile1) {
		this.mobile1 = mobile1;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
		
	public static boolean validateId(String id2) throws AddressbookException {
		// TODO Auto-generated method stub
		boolean res = false;

		if (isNullOrEmpty(id2)) {
			throw new AddressbookException("ID Field can't be empty!");
		}
//
		else {

			try{
				int idInt = Integer.parseInt(id2);

				if(idInt<1) {
					throw new AddressbookException(" Id should be Less Than 1");
				}
				else if(idInt>=1 && idInt<=100) {
					res = true;
				}
				else {
					throw new AddressbookException(" Id should always be Greater Than 100");
				}
			}catch (NumberFormatException ex) {

				throw new AddressbookException("Entry for id must be numeric value");
			}
		}

		return res;	}	
	
	public static boolean validateName(String firstname) throws AddressbookException{
		// TODO Auto-generated method stub
		boolean res = false;

		if (isNullOrEmpty(firstname)) {
			throw new AddressbookException("Name field can't be empty");
		}

		else if(firstname.length() >= 1 && firstname.length() <=3) {
			throw new AddressbookException("Name Length can't be less than 4");
		}
		else if(firstname.length() >= 4 && firstname.length() <=15) {
			res = true;
		}
		else {
			throw new AddressbookException("name Length Greater than 15 Characters");
		}


		return res;	}

	
	private static boolean isNullOrEmpty(String str) {
		// TODO Auto-generated method stub
		if(str != null && !str.isEmpty())
			return false;
		return true;
	}

	

	@Override
	public int compareTo(AddressbookNode o) {
		// TODO Auto-generated method stub
		if(id2 > o.id2)
			return 1;
			else if(id2 < o.id2)
			return -1;
			else 
			return 0;
	}
}
