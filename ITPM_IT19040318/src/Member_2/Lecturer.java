package Member_2;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Main.Home_Frame;
//import Member_2.Manage_Lecturer;
import dbConnect.DBConnect;


import java.sql.Connection;
import java.sql.Statement;


import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import java.awt.Canvas;
import java.awt.Label;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Button;

public class Lecturer {

	private JFrame frame;
	private JTextField name;
	private JComboBox center;
	private JComboBox level;
	private JComboBox day;
	private JComboBox bu;
	private JComboBox dep;
	private JComboBox time;
	private JComboBox fac;
	private JTextField id;
	private JTextField rank;
	
	private JButton save;
	private JButton clr;
	private JButton view;
	private JButton genarate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lecturer window = new Lecturer();
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
	public Lecturer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
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
		
		JButton save = new JButton("SAVE");
		save.setForeground(Color.BLACK);
		save.setBackground(Color.GREEN);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			String lecturerName= name.getText();
			String lecturerID= id.getText();
			
			String department= dep.getSelectedItem().toString();
			String faculty= fac.getSelectedItem().toString();
			
			String centers= center.getSelectedItem().toString();
			String building= bu.getSelectedItem().toString();
			String levels= level.getSelectedItem().toString();
			String ranks= rank.getText();
			String days= day.getSelectedItem().toString();
			String times= time.getSelectedItem().toString();
			
			
			
			
			
			 try {
				 Connection con = DBConnect.connect();

                    String query = "INSERT INTO Lecturers values(null, '" + lecturerName + "','" + lecturerID + "','" + centers + "','" + department + "','" + faculty + "','" + building + "','" + levels + "', '" + ranks + "','" + days + "', '" + times + "')";

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(save, "This alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(save,
                            "Your Data is added to the database successfully");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    System.out.println("Errorr!");
                }
			}
			
		});
		save.setFont(new Font("Tahoma", Font.BOLD, 20));
		save.setBounds(384, 545, 150, 52);
		frame.getContentPane().add(save);
		
		JButton clr = new JButton("CLEAR");
		clr.setBackground(Color.PINK);
		clr.setForeground(Color.BLACK);
		clr.setFont(new Font("Tahoma", Font.BOLD, 20));
		clr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		clr.setBounds(586, 545, 150, 52);
		frame.getContentPane().add(clr);
		
		JLabel lblNewLabel = new JLabel("Add Lecturer");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(479, 105, 185, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(34, 180, 125, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Faculty");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(34, 240, 125, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(189, 190, 410, 26);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Center");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(34, 301, 125, 39);
		frame.getContentPane().add(lblRoomType);
		
		center = new JComboBox();
		center.setBounds(189, 310, 410, 26);
		center.setModel(new DefaultComboBoxModel(new String[] {"Colombo","Kandy","Galle"}));
		frame.getContentPane().add(center);
		
		JButton view = new JButton("View");
		view.setForeground(Color.BLACK);
		view.setBackground(Color.ORANGE);
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Lecturer MWD = new Manage_Lecturer();
				try {
					Manage_Lecturer.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		view.setFont(new Font("Tahoma", Font.BOLD, 20));
		view.setBounds(185, 545, 150, 52);
		frame.getContentPane().add(view);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setBounds(10, 10, 1206, 93);
		frame.getContentPane().add(company_name);
	
		
//		hide
		/* JButton company_icon = new JButton("");
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
		frame.getContentPane().add(separator_main); */
		
//		add new
		
		JButton company_icon = new JButton("");
		company_icon.setBounds(95, 13, 77, 64);
		//add company icon
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		company_icon.setIcon(new ImageIcon(img));
		company_icon.setBackground(Color.LIGHT_GRAY);
		company_icon.setForeground(Color.LIGHT_GRAY);
		company_icon.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 43));
		company_icon.addActionListener(new ActionListener() {
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
		frame.getContentPane().add(company_icon);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setBounds(0, 90, 1073, 3);
		separator_main.setBackground(Color.BLACK);
		separator_main.setForeground(Color.BLACK);
		frame.getContentPane().add(separator_main);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLevel.setBounds(34, 352, 125, 39);
		frame.getContentPane().add(lblLevel);
		
		level = new JComboBox();
		level.setBounds(189, 361, 410, 26);
		level.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6"}));
		frame.getContentPane().add(level);
		
		JLabel lblAvailableDays = new JLabel("Available Days");
		lblAvailableDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailableDays.setBounds(34, 407, 125, 39);
		frame.getContentPane().add(lblAvailableDays);
		
		day = new JComboBox();
		day.setBounds(189, 416, 410, 26);
		day.setModel(new DefaultComboBoxModel(new String[] {"Monday","TesuseDay","WednesDay","ThursdDay","FriDay","SaturDay","Sunday"}));
		frame.getContentPane().add(day);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(786, 190, 410, 26);
		frame.getContentPane().add(id);
		
		bu = new JComboBox();
		bu.setBounds(786, 310, 410, 26);
		bu.setModel(new DefaultComboBoxModel(new String[] {"A","B","C"}));
		frame.getContentPane().add(bu);
		
		time = new JComboBox();
		time.setBounds(786, 416, 410, 26);
		time.setModel(new DefaultComboBoxModel(new String[] {"8.00 a.m. - 2.00 p.m.","2.00 p.m. - 8.00 p.m."}));
		frame.getContentPane().add(time);
		
		JLabel lblRoomType_2_1 = new JLabel("Available Time");
		lblRoomType_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_2_1.setBounds(631, 407, 125, 39);
		frame.getContentPane().add(lblRoomType_2_1);
		
		JLabel lblRoomType_1_1 = new JLabel("Rank");
		lblRoomType_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_1_1.setBounds(631, 352, 125, 39);
		frame.getContentPane().add(lblRoomType_1_1);
		
		JLabel lblBuilding = new JLabel("Building");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuilding.setBounds(631, 301, 125, 39);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblNewLabel_2_1 = new JLabel("Department");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(631, 240, 125, 39);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Employee ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(631, 180, 125, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		fac = new JComboBox();
		fac.setBounds(189, 252, 410, 26);
		fac.setModel(new DefaultComboBoxModel(new String[] {"Computing","Engineering","Business"}));
		frame.getContentPane().add(fac);
		
		dep = new JComboBox();
		dep.setBounds(786, 252, 410, 26);
		dep.setModel(new DefaultComboBoxModel(new String[] {"Information Technology","Software Engineering","Civil Engineering"," Electronic & Electrical"," Mechanical","Business Management"," Marketing","Acoounting & Finance"}));
		frame.getContentPane().add(dep);
		
		rank = new JTextField();
		rank.setColumns(10);
		rank.setBounds(786, 365, 410, 26);
		frame.getContentPane().add(rank);
		
		JButton generate = new JButton("Generate Rank");
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		generate.setForeground(Color.BLACK);
		generate.setFont(new Font("Tahoma", Font.BOLD, 20));
		generate.setBackground(Color.ORANGE);
		generate.setBounds(798, 545, 264, 52);
		frame.getContentPane().add(generate);
		
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Generate group id with selected year and semester,program and group id and sub id 
				
				rank.setText(level.getSelectedItem().toString() + "." + id.getText().toString());
			}
		});
		
		
	}
}
