package Member_2;

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

import dbConnect.DBConnect;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class Session {

	private JFrame frame;
	private JComboBox lec1;
	private JComboBox lec2;
	private JComboBox grp;
	private JComboBox sub;
	private JComboBox tag;
	private JComboBox code;
	private JComboBox time;
	
	private JTextField no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session window = new Session();
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
	public Session() {
		initialize();
	}

	/**
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
			}
		});
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1243, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
			String Lecturer1= lec1.getSelectedItem().toString();
			
			
			String Tag= tag.getSelectedItem().toString();
			String Lecturer2= lec2.getSelectedItem().toString();
			String Code= code.getSelectedItem().toString();
			String Group= grp.getSelectedItem().toString();
			
			String No= no.getText();    
			String Subject= sub.getSelectedItem().toString();
			String Time= time.getSelectedItem().toString();
			
			
			
			
			
			 try {
				 Connection con = DBConnect.connect();

                    String query = "INSERT INTO session values(null, '" + Lecturer1 + "','" + Lecturer2 + "','" + Tag + "', '" + Code + "','" + Group + "','" + No + "','" + Subject + "', '" + Time + "')";

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
		
		JLabel lblNewLabel = new JLabel("Add Session");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(531, 132, 185, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select 1st Lecturer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(34, 237, 156, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select 2nd Lecturer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(34, 297, 156, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblRoomType = new JLabel("Select Group");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(34, 358, 125, 39);
		frame.getContentPane().add(lblRoomType);
		
		grp = new JComboBox();
		grp.setBounds(189, 367, 410, 26);
		grp.setModel(new DefaultComboBoxModel(new String[] {"Y1S1.IT.01","Y1S1.IT.02","Y1S1.IT.03","Y1S1.SE.01","Y1S1.SE.02","Y1S1.SE.03","Y1S1.SE.04","Y1S1.DS.01","Y1S1.DS.02","Y1S1.DS.03"}));
		frame.getContentPane().add(grp);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Session itm = new Manage_Session();
				try {
					Manage_Session.main(null);
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
		
		JLabel lblAvailableDays = new JLabel("Select Subject");
		lblAvailableDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailableDays.setBounds(34, 418, 125, 39);
		frame.getContentPane().add(lblAvailableDays);
		
		 sub = new JComboBox();
		sub.setBounds(189, 427, 410, 26);
		sub.setModel(new DefaultComboBoxModel(new String[] {"SE","OOP","OOC","DS","PAF","ESD","DMS","OSSA","OOC","DS","PAF","ESD"}));
		frame.getContentPane().add(sub);
		
		no = new JTextField();
		no.setColumns(10);
		no.setBounds(786, 368, 410, 26);
		frame.getContentPane().add(no);
		
		 tag = new JComboBox();
		tag.setBounds(786, 253, 410, 26);
		tag.setModel(new DefaultComboBoxModel(new String[] {"Lecture","Tutorial","Lab"}));
		frame.getContentPane().add(tag);
		
		 time = new JComboBox();
		time.setBounds(786, 427, 410, 26);
		time.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(time);
		
		JLabel lblRoomType_2_1 = new JLabel("Duration");
		lblRoomType_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_2_1.setBounds(631, 418, 125, 39);
		frame.getContentPane().add(lblRoomType_2_1);
		
		JLabel lblBuilding = new JLabel("No. of Students");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuilding.setBounds(631, 358, 156, 39);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblNewLabel_2_1 = new JLabel("Code");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(631, 297, 125, 39);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tag");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(631, 244, 125, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		 lec2 = new JComboBox();
		lec2.setBounds(189, 309, 410, 26);
		lec2.setModel(new DefaultComboBoxModel(new String[] {"Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Kagoda","Dr. Pushpitha","Dr, Subhani ","Mrs. Piyadarshana"}));
		frame.getContentPane().add(lec2);
		
		 code = new JComboBox();
		code.setBounds(786, 309, 410, 26);
		code.setModel(new DefaultComboBoxModel(new String[] {"IT1010","SE1010","IT1020","SE2020","IT1010","SE3022","IT3010","SE2022","IT1010","SE2022","IT1010","SE2022"}));
		frame.getContentPane().add(code);
		
		 lec1 = new JComboBox();
		lec1.setBounds(189, 256, 410, 26);
		lec1.setModel(new DefaultComboBoxModel(new String[] {"Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Kagoda","Dr. Pushpitha","Dr, Subhani ","Mrs. Piyadarshana"}));
		frame.getContentPane().add(lec1);
	}
}
