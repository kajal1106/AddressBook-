package App;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

import LinkedList.MainWindow;
import Stack.StackMainWindow;
import Treeset.MainWindowTree;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setTitle("AddressBook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel.setBounds(0, 0, 574, 353);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 8));
		btnNewButton.setBounds(478, 10, 73, 21);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("PasswordField.selectionBackground"));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Framework Collections", TitledBorder.LEADING, TitledBorder.TOP, null, UIManager.getColor("PasswordField.selectionForeground")));
		panel_1.setBounds(86, 73, 389, 211);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnNewButton_2 = new JButton("Linked List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow linkedlist = null;
				try {
					linkedlist = new MainWindow();
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				linkedlist.setVisible(true);
				App.this.setVisible(false);

			}
		});
		btnNewButton_2.setBackground(UIManager.getColor("PasswordField.background"));
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Stack");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackMainWindow stack = null;
				try {
					stack = new StackMainWindow();
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stack.setVisible(true);
				App.this.setVisible(false);

			}
		});
		btnNewButton_3.setBackground(UIManager.getColor("PasswordField.background"));
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("Tree Set");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindowTree Tree = null;
				try {
					Tree = new MainWindowTree();
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Tree.setVisible(true);
				App.this.setVisible(false);

			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("PasswordField.background"));
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("AddressBook App");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setForeground(UIManager.getColor("PasswordField.background"));
		lblNewLabel.setBounds(120, 15, 297, 48);
		panel.add(lblNewLabel);
	}
}
