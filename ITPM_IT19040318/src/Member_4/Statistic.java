package Member_4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;

public class Statistic {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private int gSum, gSum2, gSum23, gSum24;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Statistic window = new Statistic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setData() {

		try {
			Connection con = DBConnect.connect();
	
	
			String query="select count (*) as allLoc from lecturers ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			String sum = rs.getString("allLoc");
			gSum = Integer.parseInt(sum);	
			textField.setText(sum);

		
			String query2="select count (*) as allLoc from studentGroups ";
			PreparedStatement pst2=con.prepareStatement(query2);
			ResultSet rs2=pst2.executeQuery();
			String su2m = rs2.getString("allLoc");
			gSum2 = Integer.parseInt(su2m);			
			textField_1.setText(su2m);
			
	
			String query23="select count (*) as allLoc from subjects ";
			PreparedStatement pst23=con.prepareStatement(query23);
			ResultSet rs23=pst23.executeQuery();
			String su2m3 = rs23.getString("allLoc");
			gSum23 = Integer.parseInt(su2m3);			
			textField_2.setText(su2m3);
	
	
			String query24="select count(*) as allc from location ";
			PreparedStatement pst24=con.prepareStatement(query24);
			ResultSet rs24=pst24.executeQuery();
			String su2m4 = rs24.getString("allc");
			gSum24 = Integer.parseInt(su2m4);			
			textField_3.setText(su2m4);
	
			System.out.println(gSum24);
		}
		catch(Exception load) {
			load.printStackTrace();
		}	
	}

	public void setLatestData() {
		try {
			Connection con = DBConnect.connect();	
	
			
			String lastLec ="SELECT lectureName FROM lecturers WHERE lid = (SELECT MAX(lid) FROM lecturers)";
			PreparedStatement pst1 =con.prepareStatement(lastLec);
			ResultSet rs1 =pst1.executeQuery();
			String txtLastLec = rs1.getString("lectureName");
			textField_4.setText(txtLastLec);
			
			
			String lastLec2 ="SELECT subName FROM subjects WHERE subID = (SELECT MAX(subID) FROM subjects)";
			PreparedStatement pst12 =con.prepareStatement(lastLec2);
			ResultSet rs12 =pst12.executeQuery();
			String txtLastLec2 = rs12.getString("subName");
			textField_5.setText(txtLastLec2);
			
			
			String lastLec3 ="SELECT buildingName FROM studentGroups WHERE stGroupID = (SELECT MAX(stGroupID) FROM studentGroups)";
			PreparedStatement pst13 =con.prepareStatement(lastLec3);
			ResultSet rs13 =pst13.executeQuery();
			String txtLastLec3 = rs13.getString("groupID");
			textField_6.setText(txtLastLec3);
			
						
		}catch (Exception a) {
			a.printStackTrace();
		}
	}//~setLatestData
	

	
	/**
	 * Create the application.
	 */
	public Statistic() {
		initialize();
	}

	/**
	 * 
	 * 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 10));
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBackground(Color.YELLOW);
		frame.setResizable(false);
		frame.setTitle("Statistics");
		frame.setBounds(100, 40, 1350, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("Registered Lecturers");
		lblNewLabel_2.setBounds(130, 262, 200, 50);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));lblNewLabel_2.setForeground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(194, 184, 85, 68);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Registered Student Groups");
		lblNewLabel_3.setBounds(743, 262, 262, 50);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 20));lblNewLabel_3.setForeground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(808, 184, 85, 68);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Registered Subjects");
		lblNewLabel_4.setBounds(444, 262, 200, 50);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD, 20));lblNewLabel_4.setForeground(Color.BLACK);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(499, 184, 85, 68);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Registered Rooms");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 20));lblNewLabel_5.setForeground(Color.BLACK);

		lblNewLabel_5.setBounds(1113, 262, 200, 50);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(1160, 184, 78, 68);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		
			
		
		JLabel lblNewLabel_6 = new JLabel("........................................................................Latest details...............................................................");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setBounds(222, 487, 1046, 48);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Lecturer");
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBounds(380, 581, 118, 24);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(579, 577, 568, 39);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("Subject");
		lblNewLabel_7_1.setForeground(Color.BLACK);
		lblNewLabel_7_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_7_1.setBounds(380, 653, 118, 24);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Group");
		lblNewLabel_7_1_1.setForeground(Color.BLACK);
		lblNewLabel_7_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel_7_1_1.setBounds(380, 726, 118, 24);
		frame.getContentPane().add(lblNewLabel_7_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(579, 649, 568, 39);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(578, 722, 569, 39);
		frame.getContentPane().add(textField_6);
		
		JButton btnManageSessionRooms = new JButton("Session");
		btnManageSessionRooms.setBounds(579, 392, 242, 60);
		frame.getContentPane().add(btnManageSessionRooms);
		btnManageSessionRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRooms msr = new ViewRooms();
				try {
					ViewRooms.main(null);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		btnManageSessionRooms.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnManageSessionRooms.setForeground(new Color(21, 25, 28));
		btnManageSessionRooms.setBackground(Color.BLACK);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setBounds(130, 10, 1206, 93);
		frame.getContentPane().add(company_name);
		
		JLabel lblStatistics = new JLabel("Statistics");
		lblStatistics.setForeground(Color.RED);
		lblStatistics.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblStatistics.setBounds(569, 112, 185, 52);
		frame.getContentPane().add(lblStatistics);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(0, 0, 205));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(43, 116, 108, 40);
		frame.getContentPane().add(btnNewButton);
	
	 
		setData();
		setLatestData();
	
	}
}