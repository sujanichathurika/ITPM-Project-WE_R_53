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

public class Add_Locations {

	private JFrame frmAddNotAvailbleTime;
	private JComboBox comboBox_2;
	private JComboBox combo;
	String temp ;
	String abc;
	List<Option> options;
	private JTextField spi3;
	private JTextField spi4;
	

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
					Add_Locations window = new Add_Locations();
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
	public Add_Locations() {
		initialize();
	}
	
	
public void fillComboBox4() {
		
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from location";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				String room=rs.getString("roomName");
				comboBox_2.addItem(room);
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
		
		JLabel lblNewLabel_2 = new JLabel("End Time");
		lblNewLabel_2.setBounds(250, 386, 252, 25);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		frmAddNotAvailbleTime.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_2_1 = new JLabel("Select Rooms");
		lblNewLabel_2_1.setBounds(250, 224, 241, 25);
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		frmAddNotAvailbleTime.getContentPane().add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		
		JLabel lblSelectGroup = new JLabel("Select Day");
		lblSelectGroup.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblSelectGroup.setBounds(250, 276, 216, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblSelectGroup);
		lblSelectGroup.setForeground(new Color(0, 0, 0));
		
		comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBackground(SystemColor.control);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select Rooms..."}));
		comboBox_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		comboBox_2.setBounds(526, 218, 216, 38);
		frmAddNotAvailbleTime.getContentPane().add(comboBox_2);
		comboBox_2.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		
		JLabel lblSelectSubGroup = new JLabel("Start Time");
		lblSelectSubGroup.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblSelectSubGroup.setBounds(250, 331, 216, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblSelectSubGroup);
		lblSelectSubGroup.setForeground(new Color(0, 0, 0));
		
		JButton btnSave = new JButton("Add Session");
		btnSave.setBounds(284, 590, 154, 47);
		frmAddNotAvailbleTime.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Empty field validation 			
				if(spi3.getText().isEmpty() || spi4.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(btnSave, "The Values are Empty.. Please Fill the Field");
				}
				else {			
	
				
				String rooms= comboBox_2.getSelectedItem().toString();
				String day= combo.getSelectedItem().toString();	
				String stime= spi3.getText();
				String etime= spi4.getText();
	
				
				try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO Addlocation values(null, '" + rooms + "','" + day + "','" + stime + "','" +
	                    		etime + "')";

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
		spi3.setBounds(526, 327, 216, 38);
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
		
		JLabel lblNewLabel_1 = new JLabel("Add Session Locations");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		panel_3.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Clear");
		
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
				
				Manage_Add_Location MWD = new Manage_Add_Location();
				try {
					Manage_Add_Location.main(null);
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
		
		JButton btnNewButton = new JButton("Sessions");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(169, 147, 122, 37);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1_1 = new JButton("Consecutive");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(303, 147, 116, 37);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_4 = new JButton("Not Available Times");
		btnNewButton_4.setBackground(new Color(255, 105, 180));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(431, 147, 174, 37);
		frmAddNotAvailbleTime.getContentPane().add(btnNewButton_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 658, 1222, 52);
		frmAddNotAvailbleTime.getContentPane().add(panel_2);
		
		combo = new JComboBox();
		combo.setBackground(SystemColor.control);
		combo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		combo.setBounds(526, 272, 216, 38);
		combo.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		frmAddNotAvailbleTime.getContentPane().add(combo);
		
		spi4 = new JTextField();
		spi4.setBackground(SystemColor.control);
		spi4.setBounds(526, 381, 216, 38);
		frmAddNotAvailbleTime.getContentPane().add(spi4);
		spi4.setColumns(10);
		
	
		fillComboBox4();
	}
}