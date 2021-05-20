package Member_4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import Main.Home_Frame;
import dbConnect.DBConnect;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Location {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox Rtag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Location window = new Location();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Location() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 1240, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			String BuildingName= textField.getText();
			String RoomName= textField_1.getText();
			String RoomType= Rtag.getSelectedItem().toString();
			String Capacity= textField_2.getText();
			
			
			
			 try {
				 Connection con = DBConnect.connect();

                    String query = "INSERT INTO location values(null, '" + BuildingName + "','" + RoomName + "','" + RoomType + "', '" + Capacity + "')";

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Your Data is added to the database successfully");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                	
                }
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(583, 545, 150, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(793, 545, 150, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Add Location");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(479, 105, 185, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Building Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(328, 159, 125, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Room Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(328, 245, 125, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Capacity");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(328, 440, 125, 39);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(592, 167, 410, 52);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(592, 242, 410, 52);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(592, 427, 410, 52);
		frame.getContentPane().add(textField_2);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(328, 347, 125, 39);
		frame.getContentPane().add(lblRoomType);
		
		Rtag = new JComboBox();
		Rtag.setBounds(592, 343, 410, 52);
		Rtag.setModel(new DefaultComboBoxModel(new String[] {"Lecture Hall", "Laboratory"}));
		frame.getContentPane().add(Rtag);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Location itm = new Manage_Location();
				try {
					Manage_Location.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnNewButton_2.setVisible(false);
}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(351, 545, 150, 52);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home_Frame MWD = new Home_Frame();
				try {
					Home_Frame.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setBounds(10, 10, 1206, 93);
		frame.getContentPane().add(company_name);
		
		JButton company_icon = new JButton("");
		company_icon.setForeground(Color.LIGHT_GRAY);
		company_icon.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 43));
		company_icon.setBackground(Color.LIGHT_GRAY);
		company_icon.setBounds(103, 26, 77, 64);
		frame.getContentPane().add(company_icon);
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		company_icon.setIcon(new ImageIcon(img));
		
		JSeparator separator_main = new JSeparator();
		separator_main.setForeground(Color.BLACK);
		separator_main.setBackground(Color.BLACK);
		separator_main.setBounds(0, 105, 1226, 2);
		frame.getContentPane().add(separator_main);
	}
}
