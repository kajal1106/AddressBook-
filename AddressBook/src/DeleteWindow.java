import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class DeleteWindow extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField fname;
	private JTextField lname;
	private JTextField mobile;
	private JTextField email;
	private JComboBox searchbyfname;
	private JTextField city;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWindow frame = new DeleteWindow();
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
	public DeleteWindow() {
		setTitle("Delete Details");
		setBounds(100, 100, 805, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(SystemColor.textHighlight);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 797, 398);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Personal Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(27, 80, 741, 249);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(UIManager.getColor("PasswordField.selectionBackground"), 2, true));
		panel_2.setBackground(SystemColor.textHighlight);
		panel_1.add(panel_2, "name_516476223587900");
		
		JLabel label_1 = new JLabel("ID");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(0, 21, 96, 28);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("First Name\r\n");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(0, 60, 96, 28);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_3.setBounds(0, 98, 96, 28);
		panel_2.add(label_3);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setEditable(false);
		id.setColumns(10);
		id.setBounds(132, 22, 179, 28);
		panel_2.add(id);
		
		fname = new JTextField();
		fname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fname.setColumns(10);
		fname.setBounds(132, 61, 179, 28);
		panel_2.add(fname);
		
		lname = new JTextField();
		lname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lname.setColumns(10);
		lname.setBounds(132, 99, 179, 28);
		panel_2.add(lname);
		
		JLabel label_4 = new JLabel("Mobile #");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_4.setBounds(0, 143, 102, 28);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Email Address");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_5.setBounds(321, 185, 112, 28);
		panel_2.add(label_5);
		
		mobile = new JTextField();
		mobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobile.setColumns(10);
		mobile.setBounds(132, 146, 179, 28);
		panel_2.add(mobile);
		
		JLabel label_6 = new JLabel("Home Address");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_6.setBounds(314, 21, 119, 28);
		panel_2.add(label_6);
		
		JTextArea address = new JTextArea();
		address.setBounds(443, 25, 244, 101);
		panel_2.add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(443, 188, 244, 28);
		panel_2.add(email);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(443, 143, 244, 28);
		panel_2.add(city);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(321, 143, 112, 28);
		panel_2.add(lblCity);
		
		JLabel label = new JLabel("Gender");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(0, 185, 102, 28);
		panel_2.add(label);
		
		JRadioButton male = new JRadioButton("Male");
		male.setHorizontalAlignment(SwingConstants.CENTER);
		male.setFont(new Font("Tahoma", Font.BOLD, 15));
		male.setBackground(Color.WHITE);
		male.setBounds(131, 191, 84, 28);
		panel_2.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setHorizontalAlignment(SwingConstants.CENTER);
		female.setFont(new Font("Tahoma", Font.BOLD, 15));
		female.setBackground(Color.WHITE);
		female.setBounds(227, 191, 84, 28);
		panel_2.add(female);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Connection con = MySQLAccess.getConnection();
					PreparedStatement pstmt = con.prepareStatement("delete from addressbook where id = ?");
					int id2 = Integer.parseInt(id.getText().trim());
					pstmt.setInt(1, id2);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Contact is permanently deleted!!!");
				} catch (Exception e1) {
					System.out.print("Failed to initialise DB Connection");
					System.out.println("Error: "+e1);  
					JOptionPane.showMessageDialog(null, "Error!!!");
				}
				// reset text fields
				id.setText("");
				fname.setText("");
				lname.setText("");
				mobile.setText("");
				address.setText(""); 
				city.setText("");
				email.setText(""); 
			
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(272, 339, 207, 42);
		panel.add(btnDelete);
		
		
		JComboBox searchbyfname = new JComboBox();
		searchbyfname.setFont(new Font("Arial Black", Font.PLAIN, 15));
		searchbyfname.addItem("Search By Name");
		searchbyfname.setBounds(27, 45, 741, 25);
		panel.add(searchbyfname);
		
		JLabel lblDeleteDetails = new JLabel("Delete Details ");
		lblDeleteDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteDetails.setForeground(Color.WHITE);
		lblDeleteDetails.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblDeleteDetails.setBounds(199, 0, 346, 35);
		panel.add(lblDeleteDetails);
		
		JButton btnNewButton = new JButton("<---");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow main = new MainWindow();
				main.setVisible(true);
				DeleteWindow.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 10));
		btnNewButton.setBounds(5, 14, 57, 21);
		panel.add(btnNewButton);
		
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
