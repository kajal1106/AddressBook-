package LinkedList;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InterfaceAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import App.App;


public class MainWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField id;
	private JTextField fname;
	private JTextField lname;
	private JTextField mobile;
	private JTextField email;
	private JTextArea address;
	public InterfaceAddress a1;
	private JTextField city;

	private JRadioButton female;
	private JRadioButton male;
	private JTextField NumSamecities;
	private JTextField femaleNum;
	private JTable table_1;
	/**
	 * Launch the application.
	 * @return 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	LinkedList<AddressbookNode> l = new LinkedList<AddressbookNode>();
	private JTextField maleNum;
	private JTextField searchLname;

	public MainWindow() throws MalformedURLException, RemoteException, NotBoundException {


		String url =  "rmi:///"; 
		InterfaceAddressbook a = (InterfaceAddressbook) Naming.lookup( url + "Nainsha" );
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			try {
				LinkedList<AddressbookNode> l = a.print();

				ObjectOutputStream out=new ObjectOutputStream(
						  new FileOutputStream("LinkedList"));
				out.writeObject(l);
					System.out.println("LinkedList Data Generated");
			    	out.close();
				
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
		setTitle("Address Book(Linked List)");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 972, 630);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		contentPane.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane panel_1 = new JLayeredPane();
		panel_1.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel_1.setBounds(196, 41, 741, 249);
		contentPane.add(panel_1);

		JPanel utilitiess = new JPanel();
		utilitiess.setBounds(27, 41, 143, 249);
		contentPane.add(utilitiess);
		utilitiess.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "My Utilities", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		utilitiess.setLayout(new CardLayout(0, 0));

		JPanel utilities = new JPanel();
		utilitiess.add(utilities, "name_678317210038700");
		panel_1.setLayer(utilities, 1);
		panel_1.setLayout(new CardLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Personal Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.add(panel_4, "name_678298822457000");
		panel_4.setLayout(new CardLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2, "name_678229091861400");
		panel_2.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 2, true));
		panel_2.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 21, 96, 28);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("First Name\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(0, 60, 96, 28);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(0, 98, 96, 28);
		panel_2.add(lblNewLabel_3);

		id = new JTextField();
		id.setEditable(true);

		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setBounds(132, 22, 179, 28);
		panel_2.add(id);
		id.setColumns(10);



		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fname.setBounds(132, 61, 179, 28);
		panel_2.add(fname);
		fname.setColumns(10);

		lname = new JTextField();
		lname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lname.setBounds(132, 99, 179, 28);
		panel_2.add(lname);
		lname.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Mobile #");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(0, 143, 102, 28);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("Email Address");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(321, 185, 112, 28);
		panel_2.add(lblNewLabel_6);

		mobile = new JTextField();
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobile.setBounds(132, 146, 179, 28);
		panel_2.add(mobile);
		mobile.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Home Address");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(314, 21, 119, 28);
		panel_2.add(lblNewLabel_7);

		JTextArea address = new JTextArea();
		address.setBounds(443, 25, 244, 101);
		panel_2.add(address);

		email = new JTextField();

		email.setColumns(10);
		email.setBounds(443, 185, 244, 28);
		panel_2.add(email);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(0, 185, 102, 28);
		panel_2.add(lblGender);

		city = new JTextField();
		city.setColumns(10);
		city.setBounds(443, 143, 244, 28);
		panel_2.add(city);

		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(321, 143, 112, 28);
		panel_2.add(lblCity);

		JRadioButton male = new JRadioButton("Male");
		//male.setActionCommand("male");
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setBackground(Color.WHITE);
		male.setFont(new Font("Tahoma", Font.BOLD, 15));
		male.setBounds(131, 191, 84, 28);
		panel_2.add(male);

		JRadioButton female = new JRadioButton("Female");
		//		female.setSelected(true);
		//female.setActionCommand("male");
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setBackground(Color.WHITE);
		female.setFont(new Font("Tahoma", Font.BOLD, 15));
		female.setBounds(227, 191, 84, 28);
		panel_2.add(female);
		utilities.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 3, true));
		utilities.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		utilities.setLayout(new GridLayout(6, 0, 2, 2));
		ButtonGroup bg1 = new ButtonGroup( );

		bg1.add(male);
		bg1.add(female);


		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result1=false;
				boolean result2=false;
				try {
					result1 = AddressbookNode.validateId(id.getText());
				} catch (AddressbookException e1) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, e1, "Error",JOptionPane.ERROR_MESSAGE);
				}
				try {
					result2 = AddressbookNode.validateName(fname.getText());
				} catch (AddressbookException e1) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, e1, "Error",JOptionPane.ERROR_MESSAGE);
				}
				if(result1==true&&result2==true)
				{
					try {
						int id2 = Integer.parseInt(id.getText().trim());
						String firstname = fname.getText();
						String lastname = lname.getText();
						int mobile1 = Integer.parseInt(mobile.getText().trim());
						String gender ="";
						if(male.isSelected()) 
							gender=male.getText();
						else if(female.isSelected()) 
							gender=female.getText();
						String city1 = city.getText();
						String address1 = address.getText();
						String email1 = email.getText();

						AddressbookNode n = new AddressbookNode(id2, firstname, lastname, mobile1, gender, address1, city1, email1);

						a.insert(n);
						LinkedList<AddressbookNode> l = a.print();
						ListIterator<AddressbookNode> iterator = l.listIterator();
						while(iterator.hasNext()) {
							AddressbookNode temp = iterator.next();

							System.out.println(temp.getFirstname());
							System.out.println(temp.getLastname());
							System.out.println(temp.getMobile1());
							System.out.println(temp.getGender());
							System.out.println(temp.getAddress1());
							System.out.println(temp.getCity1());
							System.out.println(temp.getEmail1());
						}
						JOptionPane.showMessageDialog(null, "Contacts Registered Succesfully!!!");

						/////////////////TABLE
						String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
						DefaultTableModel model = new DefaultTableModel();
						model.setColumnIdentifiers(columnnames);
						table_1.setModel(model);
						ListIterator<AddressbookNode> iterator2 = l.listIterator();
						while(iterator2.hasNext()) {
							AddressbookNode temp = iterator2.next();
							model.addRow(new Object[] {temp.getId2(),temp.getFirstname(),temp.getLastname(),temp.getMobile1(),temp.getGender(),temp.getAddress1(),temp.getCity1(),temp.getEmail1()});
						}
					} catch (RemoteException e1) {	 
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("Error: "+e1);  
						JOptionPane.showMessageDialog(null, "Error!!!");
					}


				}

			}
		});

		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		//btnAdd.setBackground(Color.LIGHT_GRAY);
		utilities.add(btnAdd);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int id2 = Integer.parseInt(id.getText().trim());
					String firstname = fname.getText();
					String lastname = lname.getText();
					int mobile1 = Integer.parseInt(mobile.getText().trim());
					String gender ="";
					if(male.isSelected()) 
						gender=male.getText();
					else if(female.isSelected()) 
						gender=female.getText();
					String city1 = city.getText();
					String address1 = address.getText();
					String email1 = email.getText();

					AddressbookNode n = new AddressbookNode(id2, firstname, lastname, mobile1, gender, address1, city1, email1);

					boolean res =a.update(n);
					if(res==true)
						System.out.println("True");
					LinkedList<AddressbookNode> l = a.print();
					ListIterator<AddressbookNode> iterator = l.listIterator();
					while(iterator.hasNext()) {
						AddressbookNode temp = iterator.next();


					}
					JOptionPane.showMessageDialog(null, "Contacts Modified Succesfully!!!");

					///////////////TABLE

					l = a.print();
					String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table_1.setModel(model);
					ListIterator<AddressbookNode> iterator2 = l.listIterator();
					while(iterator2.hasNext()) {
						AddressbookNode temp = iterator2.next();
						model.addRow(new Object[] {temp.getId2(),temp.getFirstname(),temp.getLastname(),temp.getMobile1(),temp.getGender(),temp.getAddress1(),temp.getCity1(),temp.getEmail1()});
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		utilities.add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				int id2 = Integer.parseInt(id.getText().trim());
				try {
					boolean res = a.removeNode(id2);
					if(res==true)
						JOptionPane.showMessageDialog(null, "Contacts Removed Succesfully!!!");
					id.setText("");
					fname.setText("");
					lname.setText("");
					mobile.setText("");
					address.setText(""); 
					city.setText("");
					email.setText(""); 

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				LinkedList<AddressbookNode> l;
				try {
					l = a.print();
					String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table_1.setModel(model);
					ListIterator<AddressbookNode> iterator2 = l.listIterator();
					while(iterator2.hasNext()) {
						AddressbookNode temp = iterator2.next();
						model.addRow(new Object[] {temp.getId2(),temp.getFirstname(),temp.getLastname(),temp.getMobile1(),temp.getGender(),temp.getAddress1(),temp.getCity1(),temp.getEmail1()});
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				///////////////TABLE


			}
		});
		utilities.add(btnDelete);

		JButton btnView = new JButton("SEARCH\r\n");
		btnView.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int id2 = Integer.parseInt(id.getText().trim());

				try {
					AddressbookNode search1 = a.search(id2);
					if(search1==null)
						System.out.println("Not Found");
					else
					{
						id.setText(""+search1.getId2());	
						fname.setText(search1.getFirstname());
						lname.setText(search1.getLastname());
						mobile.setText(""+search1.getMobile1());
						String gender ="";
						if(gender.equals("Male")) {
							male.setSelected(true);
							female.setSelected(false);
						}
						else {
							female.setSelected(true);
							male.setSelected(false);
						}
						city.setText(search1.getCity1());
						address.setText(search1.getAddress1());
						email.setText(search1.getEmail1());
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				LinkedList<AddressbookNode> l;
				try {
					l = a.print();
					String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table_1.setModel(model);
					ListIterator<AddressbookNode> iterator2 = l.listIterator();
					while(iterator2.hasNext()) {
						AddressbookNode temp = iterator2.next();
						model.addRow(new Object[] {temp.getId2(),temp.getFirstname(),temp.getLastname(),temp.getMobile1(),temp.getGender(),temp.getAddress1(),temp.getCity1(),temp.getEmail1()});
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				///////////////TABLE


			}
		});
		utilities.add(btnView);

		JButton btnReset = new JButton("RESEST");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reset text fields
				id.setText("");
				fname.setText("");
				lname.setText("");
				mobile.setText("");
				//gender.setText("");
				address.setText(""); 
				city.setText("");
				email.setText(""); 
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		utilities.add(btnReset);

		JButton btnNewButton = new JButton("DELETE ALL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LinkedList<AddressbookNode> l;
				try {
					l=a.removeAll();
					l = a.print();
					String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table_1.setModel(model);
					ListIterator<AddressbookNode> iterator2 = l.listIterator();
					while(iterator2.hasNext()) {
						AddressbookNode temp = iterator2.next();
						model.addRow(new Object[] {temp.getId2(),temp.getFirstname(),temp.getLastname(),temp.getMobile1(),temp.getGender(),temp.getAddress1(),temp.getCity1(),temp.getEmail1()});
					}
					JOptionPane.showMessageDialog(null, "All Contacts Removed Succesfully!!!");
				} catch (RemoteException e1) {	 
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Error: "+e1);  
					JOptionPane.showMessageDialog(null, "Error!!!");
				}



			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		utilities.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Database Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(345, 300, 592, 283);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 572, 252);
		panel.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Export Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(27, 300, 308, 283);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 2, 2));

		JButton btnNoOfCities = new JButton("No. of Cities");
		btnNoOfCities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int value = 0;
					String city1 = NumSamecities.getText();
					value=a.countCity(city1);
					JOptionPane.showMessageDialog(null, "Total Number of \t" + NumSamecities.getText() +"\tis: \t" + a.countCity(city1));
					System.out.println(city1 + a.countCity(city1));
					NumSamecities.setText(""+value);
					
				} catch (RemoteException e1) {	 
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Error: "+e1);  
					JOptionPane.showMessageDialog(null, "Error!!!");
				}


			}
		});
		btnNoOfCities.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel_3.add(btnNoOfCities);

		NumSamecities = new JTextField();
		NumSamecities.setColumns(10);
		panel_3.add(NumSamecities);

		JButton femalenum = new JButton("No. of Female");
		femalenum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int value = 0;
					String gender1 = femaleNum.getText();
					value=a.countFemale();
					System.out.println("" + a.countFemale());
					femaleNum.setText(""+value);
					JOptionPane.showMessageDialog(null, "Total Number of Female: " + a.countFemale());
					
				} catch (RemoteException e1) {	 
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Error: "+e1);  
					JOptionPane.showMessageDialog(null, "Error!!!");
				}

			}	
		});
		femalenum.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel_3.add(femalenum);

		femaleNum = new JTextField();
		femaleNum.setColumns(10);
		panel_3.add(femaleNum);

		JButton malenum = new JButton("No. of Male");
		malenum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					String gender ="";
					if(male.isSelected()) 
						gender=male.getText();
					else if(female.isSelected()) 
						gender=female.getText();
					int value = 0;
					String gender1 = maleNum.getText();
					value=a.countMale();
					System.out.println("" + a.countMale());
					maleNum.setText(""+value);
					JOptionPane.showMessageDialog(null, "Total Number of Male: " + a.countMale());
					
				} catch (RemoteException e1) {	 
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("Error: "+e1);  
					JOptionPane.showMessageDialog(null, "Error!!!");
				}

			}
		});
		malenum.setFont(new Font("Arial Black", Font.PLAIN, 12));
		panel_3.add(malenum);

		maleNum = new JTextField();
		maleNum.setColumns(10);
		panel_3.add(maleNum);

		JButton searchbylname = new JButton("Search By Surname");
		searchbylname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastname = searchLname.getText();
				
				try {
					boolean search1 = a.searchbylname(lastname);
					System.out.println(search1);
					if(search1==false) {
						System.out.println("Not FOUND");
					searchLname.setText(""+search1);

					}
					else
					{
						searchLname.setText(""+search1);
					}
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				LinkedList<AddressbookNode> l;
				try {
					l = a.print();
					String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
					DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table_1.setModel(model);
					ListIterator<AddressbookNode> iterator2 = l.listIterator();
					while(iterator2.hasNext()) {
						AddressbookNode temp = iterator2.next();
						model.addRow(new Object[] {temp.getId2(),temp.getFirstname(),temp.getLastname(),temp.getMobile1(),temp.getGender(),temp.getAddress1(),temp.getCity1(),temp.getEmail1()});
					}

				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				///////////////TABLE


			}
		});
		searchbylname.setFont(new Font("Arial Black", Font.PLAIN, 10));
		panel_3.add(searchbylname);

		searchLname = new JTextField();
		searchLname.setColumns(10);
		panel_3.add(searchLname);
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App main = new App();
				main.setVisible(true);
				MainWindow.this.setVisible(false);
				
				
				try {
					LinkedList<AddressbookNode> l = a.print();

					ObjectOutputStream out=new ObjectOutputStream(
							  new FileOutputStream("LinkedList"));
					out.writeObject(l);
						System.out.println("LinkedList Data Generated");
				    	out.close();
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1.setBounds(876, 10, 61, 21);
		contentPane.add(btnNewButton_1);
	}



	public MainWindow(String string) {
		// TODO Auto-generated constructor stub
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
