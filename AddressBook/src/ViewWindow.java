import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ViewWindow extends JFrame {

	private JPanel contentPane;
	private JComboBox searchbyfname;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWindow frame = new ViewWindow();
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
	public ViewWindow() {
		setTitle("View AddressBook");
		setBounds(100, 100, 806, 431);
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
		
		JButton btnView = new JButton("View Contacts");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conn;
				try {
					conn = MySQLAccess.getConnection();
					ResultSet rs;
			    	PreparedStatement pst = conn.prepareStatement("Select * from addressbook");
			    	rs = pst.executeQuery();
			    	String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
			    	DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table.setModel(model);
					while(rs.next()) {
						String id = rs.getString(1);
						String fname = rs.getString(2);
						String lname = rs.getString(3);
						String mobile = rs.getString(4);
						String Gender = rs.getString(5);
						String address = rs.getString(6);
						String city = rs.getString(7);
						String email = rs.getString(8);
						
						model.setColumnIdentifiers(columnnames);
						model.addRow(new Object[] {id,fname,lname,mobile,Gender,address,city,email});
			    	//System.out.println("lol");
				}
				}catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnView.setBounds(467, 44, 119, 25);
		panel.add(btnView);
		
		JComboBox searchbyfname = new JComboBox();
		searchbyfname.addItem("Search By Name");
		searchbyfname.setBounds(21, 45, 436, 25);
		panel.add(searchbyfname);
		
		JLabel lblViewPersonalDetails = new JLabel("View Personal Details");
		lblViewPersonalDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewPersonalDetails.setForeground(Color.WHITE);
		lblViewPersonalDetails.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblViewPersonalDetails.setBounds(199, 0, 406, 35);
		panel.add(lblViewPersonalDetails);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Database Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 82, 777, 306);
		panel.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 757, 276);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnViewDeletedItems = new JButton("View Deleted Contacts");
		btnViewDeletedItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conn;
				try {
					conn = MySQLAccess.getConnection();
					ResultSet rs;
			    	PreparedStatement pst = conn.prepareStatement("Select * from addressbook_backup");
			    	rs = pst.executeQuery();
			    	String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
			    	DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table.setModel(model);
					while(rs.next()) {
						String id = rs.getString(1);
						String fname = rs.getString(2);
						String lname = rs.getString(3);
						String mobile = rs.getString(4);
						String Gender = rs.getString(5);
						String address = rs.getString(6);
						String city = rs.getString(7);
						String email = rs.getString(8);
						
						model.setColumnIdentifiers(columnnames);
						model.addRow(new Object[] {id,fname,lname,mobile,Gender,address,city,email});
			    	//System.out.println("lol");
				}
				}catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
		});
		btnViewDeletedItems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewDeletedItems.setBounds(596, 44, 179, 25);
		panel.add(btnViewDeletedItems);
		
		
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
				
				Connection conn;
				try {
					conn = MySQLAccess.getConnection();
					ResultSet rs;
			    	PreparedStatement pst = conn.prepareStatement("Select * from addressbook where fname = '"+searchbyfname.getSelectedItem()+"'");
			    	rs = pst.executeQuery();
			    	String[] columnnames = {"id","fname","lname","mobile","Gender","address","city","email"};
			    	DefaultTableModel model = new DefaultTableModel();
					model.setColumnIdentifiers(columnnames);
					table.setModel(model);
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
			    	//System.out.println("lol");
				}
				}catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			});

	}
}
