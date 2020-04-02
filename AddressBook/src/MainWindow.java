import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.Choice;

import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ItemEvent;
import javax.swing.JList;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField fname;
	private JTextField lname;
	private JTextField mobile;
	private JTextField email;
	private JTextArea address;

	//public static JFrame frame;
	private JTextField city;

	private JRadioButton female;
	private JRadioButton male;
	private JTextField NumSamecities;
	private JTextField textField_1;
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


	private void groupButton( ) {

		ButtonGroup bg1 = new ButtonGroup( );

		bg1.add(male);
		bg1.add(female);

	}
	public void show_user() {
		Connection conn;
		try {
			conn = MySQLAccess.getConnection();
			ResultSet rs;
			PreparedStatement pst = conn.prepareStatement("Select * from addressbook");
			rs = pst.executeQuery();
			String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columnnames);
			table_1.setModel(model);
			while(rs.next()) {
				String id = rs.getString(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String mobile = rs.getString(4);
				String Gender = rs.getString(5);
				String address = rs.getString(6);
				String city = rs.getString(7);
				String email = rs.getString(8);

				model.addRow(new Object[] {id,fname,lname,mobile,Gender,address,city,email});

			}
		}catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	public MainWindow() {

		groupButton( ) ;

		setTitle("Address Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 981, 596);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		contentPane.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLayeredPane panel_1 = new JLayeredPane();
		panel_1.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel_1.setBounds(192, 10, 741, 249);
		contentPane.add(panel_1);

		//		try {
		//			Connection con = MySQLAccess.getConnection();
		//			Statement stmt = con.createStatement();
		//			String s = "Select * from addressbook";
		//			ResultSet rs = stmt.executeQuery(s);
		//
		//			while(rs.next()) {
		//				String type = rs.getString("fname");
		//				searchbyfname.addItem(type);
		//			}
		//
		//
		//
		//		} catch (Exception e2) {
		//
		//			e2.printStackTrace();
		//		}


		JPanel utilitiess = new JPanel();
		utilitiess.setBounds(27, 10, 143, 249);
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
		id.setEditable(false);
		id.setText("1");
		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setBounds(132, 22, 179, 28);
		panel_2.add(id);
		id.setColumns(10);

		try {
			Connection con = MySQLAccess.getConnection();
			Statement stmt = con.createStatement();
			String s = "Select id from addressbook";
			ResultSet rs = stmt.executeQuery(s);
			int id1 = 0;
			while(rs.next()) {
				id1 = Integer.parseInt(rs.getString(1));

			}
			System.out.println(id1);
			id1 = id1 + 1;
			id.setText(String.valueOf(id1));
			//


		} catch (Exception e2) {

			e2.printStackTrace();
		}

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
		//female.setActionCommand("male");
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setBackground(Color.WHITE);
		female.setFont(new Font("Tahoma", Font.BOLD, 15));
		female.setBounds(227, 191, 84, 28);
		panel_2.add(female);
		utilities.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 3, true));
		utilities.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		utilities.setLayout(new GridLayout(6, 0, 2, 2));



		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					Connection con = MySQLAccess.getConnection();
					Statement stmt = con.createStatement();
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
					String cmd="INSERT INTO addressbook (id, fname, lname, mobile, Gender,address,city,email) VALUES ('"+id2+"', '"+firstname+"', '"+lastname+"','"+mobile1+"', '"+gender+"','"+address1+"','"+city1+"','"+email1+"');";
					System.out.println(cmd);
					JOptionPane.showMessageDialog(null, "Contacts Registered Succesfully!!!");
					Statement st = con.createStatement();
					st.executeUpdate(cmd);
					//					DefaultTableModel model = (DefaultTableModel)table.getModel();
					//					model.setRowCount(0);
					show_user();
					con.close();
				} catch (Exception e1) {
					System.out.print("Failed to initialise DB Connection");
					System.out.println("Error: "+e1);  
					JOptionPane.showMessageDialog(null, "Error!!!");
				}


			}
		});

		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		//btnAdd.setBackground(Color.LIGHT_GRAY);
		utilities.add(btnAdd);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateWindow update = new UpdateWindow();
				update.setVisible(true);
				MainWindow.this.setVisible(false);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		utilities.add(btnUpdate);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteWindow delete = new DeleteWindow();
				delete.setVisible(true);
				MainWindow.this.setVisible(false);


			}
		});
		utilities.add(btnDelete);

		JButton btnView = new JButton("VIEW\r\n");
		btnView.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWindow view = new ViewWindow();
				view.setVisible(true);
				//MainWindow.this.setVisible(false);

			}
		});
		utilities.add(btnView);

		JButton btnReset = new JButton("RESEST");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// reset text fields
				//id.setText("");
				try {
					Connection con = MySQLAccess.getConnection();
					Statement stmt = con.createStatement();
					String s = "Select id from addressbook";
					ResultSet rs = stmt.executeQuery(s);
					int id1 = 0;
					while(rs.next()) {
						//String type = rs.getString("subscription_type");
						id1 = Integer.parseInt(rs.getString(1));
						//subscription.addItem(type);

					}
					System.out.println(id1);
					id1 = id1 + 1;
					id.setText(String.valueOf(id1));
					//


				} catch (Exception e2) {

					e2.printStackTrace();
				}
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

		JButton btnNewButton = new JButton("EXPORT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = MySQLAccess.getConnection();
					String cmd =  "Select * from addressbook";
					CallableStatement stmt = con.prepareCall("{call Data}");
					ResultSet rs = stmt.executeQuery();	
					writeToFile(rs,"Data.csv");
					stmt.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		utilities.add(btnNewButton);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Database Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(341, 269, 592, 283);
		contentPane.add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 572, 252);
		panel.add(scrollPane);

		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Export Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(27, 269, 308, 283);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 2, 2));

		JButton button = new JButton("No.OfCitiesFromAddress");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query ="Select * from addressbook";
					Connection con = MySQLAccess.getConnection();
					CallableStatement statement = con.prepareCall("{call CountCity(?)}");
					statement.setString(1, NumSamecities.getText());
					ResultSet rs = statement.executeQuery();
					writeToFile(rs,"CityNum.csv");
					statement.close();	
				}
				catch( Exception  e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
			}
		});
		button.setFont(new Font("Arial Black", Font.PLAIN, 8));
		panel_3.add(button);

		NumSamecities = new JTextField();
		NumSamecities.setColumns(10);
		panel_3.add(NumSamecities);

		JButton avgMale = new JButton("AvgNo.OfMale");
		avgMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = MySQLAccess.getConnection();
					String cmd =  "Select * from addressbook";
					CallableStatement stmt = con.prepareCall("{call AvgMF}");
					ResultSet rs = stmt.executeQuery();	
					writeToFile(rs,"AverageMale.csv");
					stmt.close();	
					}
				catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
			}	
		});
		avgMale.setFont(new Font("Arial Black", Font.PLAIN, 10));
		panel_3.add(avgMale);

		JButton avgFemale = new JButton("AvgNo.OfFemale");
		avgFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = MySQLAccess.getConnection();
					String cmd =  "Select * from addressbook";
					CallableStatement stmt = con.prepareCall("{call AvgMF}");
					ResultSet rs = stmt.executeQuery();	
					writeToFile(rs,"AverageFemale.csv");
					stmt.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
			}	
		});

		avgFemale.setFont(new Font("Arial Black", Font.PLAIN, 10));
		panel_3.add(avgFemale);

		JButton btnListofallemails = new JButton("No.ListOfAllEmails");
		btnListofallemails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					Connection con = MySQLAccess.getConnection();
					//Statement stmt = con.createStatement();
					String cmd =  "Select * from addressbook";
					CallableStatement stmt = con.prepareCall("{call showEmail}");
					ResultSet rs = stmt.executeQuery();	
					writeToFile(rs,"EmailList.csv");
					stmt.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
			}
		});
		btnListofallemails.setFont(new Font("Arial Black", Font.PLAIN, 8));
		panel_3.add(btnListofallemails);

		JButton btnListofallmobiles = new JButton("ListOfAllMobile#s");
		btnListofallmobiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					Connection con = MySQLAccess.getConnection();
					//Statement stmt = con.createStatement();
					String cmd =  "Select * from addressbook";
					CallableStatement stmt = con.prepareCall("{call showMobile}");
					ResultSet rs = stmt.executeQuery();	
					writeToFile(rs,"MobileList.csv");
					stmt.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
			}		
		});


		btnListofallmobiles.setFont(new Font("Arial Black", Font.PLAIN, 8));
		panel_3.add(btnListofallmobiles);

		JButton btnNoofsamesurnames = new JButton(" No.OfSameSurnames");
		btnNoofsamesurnames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String query ="Select * from addressbook";
					Connection con = MySQLAccess.getConnection();
					CallableStatement statement = con.prepareCall("{call countSurname(?)}");
					statement.setString(1, textField_1.getText());
					ResultSet rs = statement.executeQuery();	
					writeToFile(rs,"SurnameList.csv");
					statement.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
			}
		});
		btnNoofsamesurnames.setFont(new Font("Arial Black", Font.PLAIN, 8));
		panel_3.add(btnNoofsamesurnames);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		show_user();
	}

	protected void writeToFile(ResultSet rs,String filename) {
		JLabel lblNewLabel = new JLabel("Address Book");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(216, 21, 542, 55);
		contentPane.add(lblNewLabel);

		// TODO Auto-generated method stub
		try{
			JOptionPane.showMessageDialog(null, "Details are successfully generated in Data.csv");
			FileWriter fw = new FileWriter(filename);
			PrintWriter pw = new PrintWriter(fw);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for(int i=0;i<numColumns;i++){
				pw.print(rsmd.getColumnLabel(i+1)+",");
			}
			pw.print("\n");
			while(rs.next()){
				for(int i=0;i<numColumns;i++){
					pw.print(rs.getString(i+1)+",");
				}
				pw.print("\n");
				pw.flush();
			}
			pw.close();
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error!!!");	
		}
	}
}
