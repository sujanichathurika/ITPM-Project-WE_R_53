package Member_3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.text.html.Option;
import javax.swing.text.html.Option;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import Main.Home_Frame;
//import Main.Home_Page;
import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Session_and_Not_Available_Times_Allocations {

	private JFrame frmAddNotAvailbleTime;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox combo;
	private JComboBox<String> comboBox_4;
	String temp ;
	String abc;
	List<Option> options;
	private JTextField spi3;
	

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session_and_Not_Available_Times_Allocations window = new Session_and_Not_Available_Times_Allocations();
					window.frmAddNotAvailbleTime.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Session_and_Not_Available_Times_Allocations() {
		initialize();
	}
	
	
//	
	public void fillComboBox4() {
		
		
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from session";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String sessionID=rs.getString("sessionID");
				comboBox_4.addItem(sessionID);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox3() {
			
		String selection=(String)comboBox.getSelectedItem();
		System.out.println(selection);
		
			try {
				
				Connection con = DBConnect.connect();
			
			String query="select s.sessionSignature from session s, lecturers l where s.lecID=l.lid and l.lectureName='"+selection+"'";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String signature=rs.getString("sessionSignature");
				comboBox_4.addItem(signature);
			}
			con.close();			
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void fillComboBox() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from lecturers";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				String name=rs.getString("lectureName");
				comboBox.addItem(name);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox2() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from studentGroups";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String group=rs.getString("groupID");
				String subgroup=rs.getString("subGroupID");
				
				comboBox_2.addItem(group);
				comboBox_3.addItem(subgroup);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		frmAddNotAvailbleTime = new JFrame();
		frmAddNotAvailbleTime.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
			}
		});
		frmAddNotAvailbleTime.getContentPane().setBackground(new Color(30, 144, 255));
		frmAddNotAvailbleTime.setBackground(Color.YELLOW);
		frmAddNotAvailbleTime.setResizable(false);
		frmAddNotAvailbleTime.setTitle("Session and Not Available Time");
		frmAddNotAvailbleTime.setBounds(350, 90, 1228, 748);
		frmAddNotAvailbleTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNotAvailbleTime.getContentPane().setLayout(null);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/tt.png/"));
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer");
		lblNewLabel_2.setBounds(250, 378, 252, 25);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		frmAddNotAvailbleTime.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("Select Session ID");
		lblNewLabel_2_1.setBounds(250, 224, 241, 25);
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		frmAddNotAvailbleTime.getContentPane().add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));

		
		comboBox = new JComboBox();	
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(SystemColor.control);
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox.setBounds(526, 372, 262, 38);
		frmAddNotAvailbleTime.getContentPane().add(comboBox);
		comboBox.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		
		JLabel lblSelectGroup = new JLabel("Select Group");
		lblSelectGroup.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblSelectGroup.setBounds(250, 276, 216, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblSelectGroup);
		lblSelectGroup.setForeground(new Color(0, 0, 0));
		
		comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBackground(SystemColor.control);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select Group..."}));
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_2.setBounds(526, 270, 262, 38);
		frmAddNotAvailbleTime.getContentPane().add(comboBox_2);
		comboBox_2.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		
		JLabel lblSelectSubGroup = new JLabel("Select Sub Group");
		lblSelectSubGroup.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblSelectSubGroup.setBounds(250, 327, 216, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblSelectSubGroup);
		lblSelectSubGroup.setForeground(new Color(0, 0, 0));
		
		 comboBox_3 = new JComboBox();
		comboBox_3.setForeground(Color.BLACK);
		comboBox_3.setBackground(SystemColor.control);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Select Sub Group..."}));
		comboBox_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_3.setBounds(526, 321, 262, 38);
		frmAddNotAvailbleTime.getContentPane().add(comboBox_3);
		comboBox_3.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		
		 comboBox_4 = new JComboBox();
		 comboBox_4.setSelectedItem(" ");
		 
		 comboBox_4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 	}
		 });
		comboBox_4.setForeground(new Color(0, 0, 0));
		//AutoCompleteDecorator.decorate(comboBox_4);
		comboBox_4.setBackground(SystemColor.control);
		comboBox_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_4.setBounds(526, 217, 262, 38);
		frmAddNotAvailbleTime.getContentPane().add(comboBox_4);
		comboBox_4.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		
		JLabel lblStartTime = new JLabel("Time");
		lblStartTime.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblStartTime.setBounds(250, 462, 234, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblStartTime);
		lblStartTime.setForeground(new Color(0, 0, 0));
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblDay.setBounds(692, 462, 79, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblDay);
		lblDay.setForeground(new Color(0, 0, 0));
		
		JLabel lblDuration = new JLabel("Time Duration");
		lblDuration.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblDuration.setBounds(927, 462, 151, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblDuration);
		lblDuration.setForeground(new Color(0, 0, 0));
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(316, 590, 122, 47);
		frmAddNotAvailbleTime.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Empty field validation 			
				if(spi3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnSave, "The Values are Empty.. Please Fill the Field");
				}
				else {
				
				String lecname= comboBox.getSelectedItem().toString();
				String group= comboBox_2.getSelectedItem().toString();
				String subgroup= comboBox_3.getSelectedItem().toString();
				String signature= comboBox_4.getSelectedItem().toString();
				String day= combo.getSelectedItem().toString();
				
				String minutes= spi3.getText();
				
				System.out.println(signature);
				
				try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO timeAlloLecture values(null, '" + lecname + "','" + group + "','" + subgroup + "','" +
	                    		signature + "','" + day +"','" + minutes +"')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnSave, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnSave,
	                            "Data Added sucessfully");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	                }}  
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(50, 205, 50));
		
		spi3 = new JTextField();
		spi3.setBackground(SystemColor.control);
		spi3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		spi3.setBounds(783, 457, 132, 38);
		frmAddNotAvailbleTime.getContentPane().add(spi3);
		spi3.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1222, 90);
		frmAddNotAvailbleTime.getContentPane().add(panel);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_7);
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBackground(Color.BLUE);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 90, 146, 565);
		frmAddNotAvailbleTime.getContentPane().add(panel_1);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Home_Frame MWD = new Home_Frame();
				try {
					Home_Frame.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmAddNotAvailbleTime.setVisible(false);
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_3.setBackground(new Color(218, 112, 214));
		btnNewButton_3.setBounds(8, 500, 130, 47);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(147, 90, 1075, 47);
		frmAddNotAvailbleTime.getContentPane().add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Session and Not Available Times Allocations");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		panel_3.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Reset");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				spi3.setText(null);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.setBounds(709, 590, 113, 47);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("View");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Session_and_Not_Available_Times_Allocations MWD = new Manage_Session_and_Not_Available_Times_Allocations();
				try {
					Manage_Session_and_Not_Available_Times_Allocations.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmAddNotAvailbleTime.setVisible(false);
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2_1.setBackground(new Color(255, 204, 102));
		btnNewButton_2_1.setBounds(517, 590, 113, 47);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton = new JButton("Concecutive");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(169, 147, 122, 37);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Parallel");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(316, 147, 86, 37);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Non Overlapping");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(427, 147, 151, 37);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Not Available Times");
		btnNewButton_4.setBackground(new Color(255, 105, 180));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(592, 147, 174, 37);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 658, 1222, 52);
		frmAddNotAvailbleTime.getContentPane().add(panel_2);
		
		combo = new JComboBox();
		combo.setBackground(SystemColor.control);
		combo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		combo.setBounds(526, 457, 154, 38);
		combo.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		frmAddNotAvailbleTime.getContentPane().add(combo);
		
		fillComboBox();
		fillComboBox2();
		fillComboBox4();
	}
}