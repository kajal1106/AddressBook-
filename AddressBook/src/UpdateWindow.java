import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class UpdateWindow extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField fname;
	private JTextField lname;
	private JTextField mobile;
	private JTextField email;
	private JComboBox searchbyfname;
	private JTextField city;
	private JRadioButton female;
	private JRadioButton male;

	/**
	 * Launch the application.
	 */
	private static MainWindow myObj = new MainWindow(); 
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWindow frame = new UpdateWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}   
		});
	}

	/**
	 * Create the frame.
	 */
	
	private void groupButton( ) {

		ButtonGroup bg1 = new ButtonGroup( );

		bg1.add(male);
		bg1.add(female);

		}
	
	
	public UpdateWindow() {
		setTitle("Update AddressBook");
		
		groupButton( ) ;
		
		
		setBounds(100, 100, 775, 435);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setForeground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Personal Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 80, 741, 249);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 2, true));
		panel_1.setBackground(SystemColor.textHighlight);
		panel.add(panel_1, "name_428963297044000");
		
		JLabel label = new JLabel("ID");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(0, 21, 96, 28);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("First Name\r\n");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(0, 60, 96, 28);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(0, 98, 96, 28);
		panel_1.add(label_2);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(132, 22, 179, 28);
		panel_1.add(id);
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fname.setColumns(10);
		fname.setBounds(132, 61, 179, 28);
		panel_1.add(fname);
		
		lname = new JTextField();
		lname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lname.setColumns(10);
		lname.setBounds(132, 99, 179, 28);
		panel_1.add(lname);
		
		JLabel label_3 = new JLabel("Mobile #");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(0, 143, 102, 28);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Email Address");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(321, 185, 112, 28);
		panel_1.add(label_4);
		
		mobile = new JTextField();
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobile.setColumns(10);
		mobile.setBounds(132, 146, 179, 28);
		panel_1.add(mobile);
		
		JLabel label_5 = new JLabel("Home Address");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(314, 21, 119, 28);
		panel_1.add(label_5);
		
		JTextArea address = new JTextArea();
		address.setBounds(443, 25, 244, 101);
		panel_1.add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(443, 185, 244, 28);
		panel_1.add(email);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(443, 150, 244, 28);
		panel_1.add(city);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(321, 153, 112, 28);
		panel_1.add(lblCity);
		
		JLabel label_6 = new JLabel("Gender");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(0, 179, 102, 28);
		panel_1.add(label_6);
		
		JRadioButton male = new JRadioButton("Male");
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setFont(new Font("Tahoma", Font.BOLD, 15));
		male.setBackground(Color.WHITE);
		male.setBounds(131, 185, 84, 28);
		panel_1.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setFont(new Font("Tahoma", Font.BOLD, 15));
		female.setBackground(Color.WHITE);
		female.setBounds(227, 185, 84, 28);
		panel_1.add(female);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
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
					String address1 = address.getText();
					String city1 = city.getText();
					String email1 = email.getText();
					String cmd="UPDATE  addressbook SET fname= '"+firstname+"',lname= '"+lastname+"', mobile="+mobile1+", Gender='"+gender+"', address='"+address1+"', city='"+city1+"', email='"+email1+"' WHERE id= "+id2+" ";	
					System.out.println(cmd);
					JOptionPane.showMessageDialog(null, "Addressbook Modified Succesfully!!!");
					Statement st = con.createStatement();
					st.executeUpdate(cmd);
					myObj.show_user();
					con.close();
				} catch (Exception e1) {
					System.out.print("Failed to initialise DB Connection");
					System.out.println("Error: "+e1);  
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
				
			}
			
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(272, 339, 207, 42);
		contentPane.add(btnUpdate);
		
		JComboBox searchbyfname = new JComboBox();
		searchbyfname.setToolTipText("Update AddressBook");
		searchbyfname.setFont(new Font("Arial Black", Font.PLAIN, 15));
		searchbyfname.addItem("Search By Name");
		searchbyfname.setBounds(10, 45, 741, 25);
		contentPane.add(searchbyfname);
		
		JLabel lblNewLabel = new JLabel("Update Personal Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblNewLabel.setBounds(157, 0, 462, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("<---");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				main.setVisible(true);
				UpdateWindow.this.setVisible(false);

			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnNewButton.setBounds(5, 14, 57, 21);
		contentPane.add(btnNewButton);
		
		
		
		try {
			Connection con = MySQLAccess.getConnection();
			Statement stmt = con.createStatement();
			String s = "Select * from addressbook";
			ResultSet rs = stmt.executeQuery(s);

			while(rs.next()) {
				String type = rs.getString("fname");
				searchbyfname.addItem(type);
			}



		} catch (Exception e2) {

			e2.printStackTrace();
		}


		searchbyfname.addItemListener(new ItemListener() {
			

			public void itemStateChanged(ItemEvent e) {
				try {
					Connection con = MySQLAccess.getConnection();
					Statement stmt = con.createStatement();
					String s = "Select * from addressbook where fname = '"+searchbyfname.getSelectedItem()+"'";
					ResultSet rs = stmt.executeQuery(s);

					while(rs.next()) {
						String id2=rs.getString("id");
						String fname1 = rs.getString("fname");
						String lname1 = rs.getString("lname");
						String mobile1 = rs.getString("mobile");
						String gender1=rs.getString("gender");
						String address1 = rs.getString("address");
						String city1 = rs.getString("city");
						String email1 = rs.getString("email");
						id.setText(id2);
						fname.setText(fname1);
						lname.setText(lname1);
						mobile.setText(mobile1);
						//telephone.setText(telephone1);
						if(gender1.equals("Male"))male.setSelected(true);
						else
							female.setSelected(true);
						address.setText(address1);
						city.setText(city1);
						email.setText(email1);
						
					}



				} catch (Exception e2) {

					e2.printStackTrace();
				}
				

			}
		});
	}
}
