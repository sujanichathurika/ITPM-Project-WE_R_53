package Member_3;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import Main.Home_Frame;
import dbConnect.DBConnect;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddWorkDaysHours {

	private JFrame frame;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JCheckBox chckbxNewCheckBox_6;
	private JTextField spi1;
	private JTextField spi2;
	private JTextField spi3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWorkDaysHours window = new AddWorkDaysHours();
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
	public AddWorkDaysHours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 255));
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.setBounds(100, 100, 1224, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("No. of Working Days");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(242, 195, 249, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Working Days");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBackground(new Color(0, 0, 139));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_3.setBounds(242, 293, 183, 41);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Working Time Per Day");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(242, 437, 265, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		chckbxNewCheckBox = new JCheckBox("Monday");
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		chckbxNewCheckBox.setBounds(562, 303, 113, 25);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Tuesday");
		chckbxNewCheckBox_1.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox_1.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		chckbxNewCheckBox_1.setBounds(715, 303, 113, 25);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("Wednesday");
		chckbxNewCheckBox_2.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox_2.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		chckbxNewCheckBox_2.setBounds(871, 303, 130, 25);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("Thursday");
		chckbxNewCheckBox_3.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox_3.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		chckbxNewCheckBox_3.setBounds(1037, 303, 113, 25);
		frame.getContentPane().add(chckbxNewCheckBox_3);
		
		chckbxNewCheckBox_4 = new JCheckBox("Friday");
		chckbxNewCheckBox_4.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox_4.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		chckbxNewCheckBox_4.setBounds(562, 349, 113, 25);
		frame.getContentPane().add(chckbxNewCheckBox_4);
		
		chckbxNewCheckBox_5 = new JCheckBox("Saturday");
		chckbxNewCheckBox_5.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox_5.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		chckbxNewCheckBox_5.setBounds(715, 349, 113, 25);
		frame.getContentPane().add(chckbxNewCheckBox_5);
		
		chckbxNewCheckBox_6 = new JCheckBox("Sunday");
		chckbxNewCheckBox_6.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox_6.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		chckbxNewCheckBox_6.setBounds(871, 349, 113, 25);
		frame.getContentPane().add(chckbxNewCheckBox_6);
		
		JLabel lblNewLabel_5 = new JLabel("Hours");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_5.setBounds(711, 437, 113, 43);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mintues");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_6.setBounds(991, 442, 113, 38);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 643, 1210, 65);
		frame.getContentPane().add(panel_2);
		
		JButton btnSave = new JButton("Submit");
		btnSave.setForeground(Color.WHITE);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Empty field validation 			
				if(spi1.getText().isEmpty() || spi2.getText().isEmpty() || spi3.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(btnSave, "The Values are Empty.. Please Fill the Field");
				}
				else {
					
					String NoOfWorkingDays= spi1.getText();
					String hours= spi2.getText();
					String minutes= spi3.getText();
					
					String monday="-";
					String tuesday="-";
					String wednesday="-";
					String thursday="-";
					String friday="-";
					String saturday="-";
					String sunday="-";
					
					if(chckbxNewCheckBox.isSelected()) {
						monday="Monday";
					}
					if(chckbxNewCheckBox_1.isSelected()) {
						tuesday="Tuesday";
					}
					if(chckbxNewCheckBox_2.isSelected()) {
						wednesday="Wednesday";
					}
					if(chckbxNewCheckBox_3.isSelected()) {
						thursday="Thursday";
					}
					if(chckbxNewCheckBox_4.isSelected()) {
						friday="Friday";
					}
					if(chckbxNewCheckBox_5.isSelected()) {
						saturday="Saturday";
					}
					if(chckbxNewCheckBox_6.isSelected()) {
						sunday="Sunday";
					}
					
					
					try {
						 Connection con = DBConnect.connect();

		                    String query = "INSERT INTO main values(NULL, '" + NoOfWorkingDays + "','" + monday + "','" + tuesday + "','" +
		                    		wednesday + "','" + thursday + "','" + friday + "','"+ saturday +"','"+ sunday +"','"+ hours +"','"+ minutes +"')";

		                    Statement sta = con.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(btnSave,"Data Added sucessfully");
		                    }
		                    con.close();
		                } catch (Exception exception) {
		                	  exception.printStackTrace();
		                }
					
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSave.setBackground(new Color(50, 205, 50));
		btnSave.setBounds(642, 553, 113, 37);
		frame.getContentPane().add(btnSave);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ManageWorkingDays MWD = new ManageWorkingDays();
				try {
					ManageWorkingDays.main(null);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBackground(new Color(255, 204, 102));
		btnNewButton_2.setBounds(871, 553, 113, 37);
		frame.getContentPane().add(btnNewButton_2);
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1210, 90);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		lblNewLabel.setBackground(Color.BLUE);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		
		JLabel lblNewLabel_1 = new JLabel("Add Working Days And Hours");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(419, 111, 431, 31);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				chckbxNewCheckBox.setSelected(false);
				chckbxNewCheckBox_1.setSelected(false);
				chckbxNewCheckBox_2.setSelected(false);
				chckbxNewCheckBox_3.setSelected(false);
				chckbxNewCheckBox_4.setSelected(false);
				chckbxNewCheckBox_5.setSelected(false);
				chckbxNewCheckBox_6.setSelected(false);
				spi1.setText(null);				
				spi2.setText(null);
				spi3.setText(null);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(444, 553, 113, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		spi1 = new JTextField();
		spi1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				
				char c = evt.getKeyChar();
				if(Character.isLetter(c)) {
					spi1.setEditable(false);								
					JOptionPane.showMessageDialog(btnSave, "Enter a Valid No of Working Days ");
				}
					else {
						spi1.setEditable(true);
					}	
				
			}
		});
		spi1.setBounds(562, 194, 130, 35);
		frame.getContentPane().add(spi1);
		spi1.setColumns(10);
		
		spi2 = new JTextField();
		spi2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ev) {
				
				char c = ev.getKeyChar();
				if(Character.isLetter(c)) {
					spi2.setEditable(false);								
					JOptionPane.showMessageDialog(btnSave, "Enter Valid Working Time Per Day");
				}
					else {
						spi2.setEditable(true);
					}	
			}
		});
		spi2.setBounds(562, 438, 135, 35);
		frame.getContentPane().add(spi2);
		spi2.setColumns(10);
		
		spi3 = new JTextField();
		spi3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					spi3.setEditable(false);								
					JOptionPane.showMessageDialog(btnSave, "Enter Valid Working Time Per Day");
				}
					else {
						spi3.setEditable(true);
					}	
			}
		});
		spi3.setBounds(834, 438, 135, 35);
		frame.getContentPane().add(spi3);
		spi3.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 88, 146, 555);
		frame.getContentPane().add(panel_1);

		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(218, 112, 214));
		btnNewButton_3.setBounds(8, 500, 130, 42);
		panel_1.add(btnNewButton_3);
		Image imgs = new ImageIcon(this.getClass().getResource("/my.jpg")).getImage();
		
	}
}
