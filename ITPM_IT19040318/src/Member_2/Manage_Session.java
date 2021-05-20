package Member_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Main.Home_Frame;
import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class Manage_Session {

	private JFrame frame;
	private JTable table;
	
	private JComboBox lec1;
	private JComboBox lec2;
	private JComboBox grp;
	private JComboBox sub;
	private JComboBox tag;
	private JComboBox code;
	private JComboBox time;
	private JComboBox search;
	private JTextField id;
	private JTextField no;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Session window = new Manage_Session();
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
	public Manage_Session() {
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
				try {
					Connection con = DBConnect.connect();
					
					String query="select * from session ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1346, 772);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Session");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(580, 92, 269, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(255, 153, 51));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				
//if(lec1.getSelectedItem().equals("")||tag.getSelectedItem().equals("")|| lec2.getSelectedItem().equals("")||code.getSelectedItem().equals("")||grp.getSelectedItem().equals("")|| no.getText().equals("")||sub.getSelectedItem().equals("")||time.getSelectedItem().equals("")) {
//					
//					JOptionPane.showMessageDialog(null, "Please fill the form");
//				}else {
				try {
					Connection con = DBConnect.connect();					
					String query="Update session set number='"+no.getText()+"' where sessionID='"+id.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				}
				
				
				
			//}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(87, 411, 256, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from session where sessionID='"+id.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
					}
					catch(Exception en) {
						en.printStackTrace();
						
					}

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(393, 411, 256, 48);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(123, 104, 238));
		btnClear.setForeground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
						
				lec1.setSelectedItem(null);
				tag.setSelectedItem(null);
				lec2.setSelectedItem(null);
				code.setSelectedItem(null);
				grp.setSelectedItem(null);
				no.setText(null);
				sub.setSelectedItem(null);
				time.setSelectedItem(null);
			
				
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(694, 411, 256, 48);
		frame.getContentPane().add(btnClear);
	 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 233, 1168, 157);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
			    id.setText(table.getValueAt(selectedRow, 0).toString());
			    no.setText(table.getValueAt(selectedRow, 6).toString());
			    
			    
			    String comboLevel = table.getValueAt(selectedRow, 1).toString();
				
			    
//			    for(int i=0; i<lec1.getItemCount();i++) {
//					if(lec1.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
//						lec1.setSelectedIndex(i);
//					}
//				}
//			    
//             String comboLevel1 = table.getValueAt(selectedRow, 2).toString();
//				
//			    
//			    for(int i=0; i<tag.getItemCount();i++) {
//					if(tag.getItemAt(i).toString().equalsIgnoreCase(comboLevel1)) {
//						tag.setSelectedIndex(i);
//					}
//				}
//			    
//String comboLevel2 = table.getValueAt(selectedRow, 3).toString();
//				
//			    
//			    for(int i=0; i<lec2.getItemCount();i++) {
//					if(lec2.getItemAt(i).toString().equalsIgnoreCase(comboLevel2)) {
//						lec2.setSelectedIndex(i);
//					}
//				}
//String comboLevel3 = table.getValueAt(selectedRow, 4).toString();
//				
//			    
//			    for(int i=0; i<code.getItemCount();i++) {
//					if(code.getItemAt(i).toString().equalsIgnoreCase(comboLevel3)) {
//						code.setSelectedIndex(i);
//					}
//				}
//String comboLevel4 = table.getValueAt(selectedRow, 5).toString();
//				
//			    
//			    for(int i=0; i<grp.getItemCount();i++) {
//					if(grp.getItemAt(i).toString().equalsIgnoreCase(comboLevel4)) {
//						grp.setSelectedIndex(i);
//					}
//				}
//String comboLevel5 = table.getValueAt(selectedRow, 7).toString();
//				
//			    
//			    for(int i=0; i<sub.getItemCount();i++) {
//					if(sub.getItemAt(i).toString().equalsIgnoreCase(comboLevel5)) {
//						sub.setSelectedIndex(i);
//					}
//				}
//				
//			    
//String comboLevel6 = table.getValueAt(selectedRow, 8).toString();
//				
//			    
//			    for(int i=0; i<time.getItemCount();i++) {
//					if(time.getItemAt(i).toString().equalsIgnoreCase(comboLevel6)) {
//						time.setSelectedIndex(i);
//					}
//				}	    
			    
			    
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setBounds(162, -11, 1070, 93);
		frame.getContentPane().add(company_name);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1088, 78, -1085, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(1096, 81, -1085, 12);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setForeground(Color.BLACK);
		separator_main.setBackground(Color.BLACK);
		separator_main.setBounds(0, 81, 1332, 12);
		frame.getContentPane().add(separator_main);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(1149, 427, 78, 26);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(1104, 417, 35, 39);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox lec2 = new JComboBox();
		lec2.setBounds(248, 566, 410, 26);
		lec2.setModel(new DefaultComboBoxModel(new String[] {"Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Kagoda","Dr. Pushpitha","Dr, Subhani ","Mrs. Piyadarshana"}));
		frame.getContentPane().add(lec2);
		
		JComboBox lec1 = new JComboBox();
		lec1.setBounds(248, 513, 410, 26);
		lec1.setModel(new DefaultComboBoxModel(new String[] {"Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Nuwan Kagoda","Dr. Pushpitha","Dr, Subhani AK","Mrs. Piyadarshana","Dr. Kagoda","Dr. Pushpitha","Dr, Subhani ","Mrs. Piyadarshana"}));
		frame.getContentPane().add(lec1);
		
		JLabel lblNewLabel_1 = new JLabel("Select 1st Lecturer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(93, 494, 156, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select 2nd Lecturer");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(93, 554, 156, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblRoomType = new JLabel("Select Group");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(93, 615, 125, 39);
		frame.getContentPane().add(lblRoomType);
		
		JComboBox grp = new JComboBox();
		grp.setBounds(248, 624, 410, 26);
		grp.setModel(new DefaultComboBoxModel(new String[] {"Y1S1.IT.01","Y1S1.IT.02","Y1S1.IT.03","Y1S1.SE.01","Y1S1.SE.02","Y1S1.SE.03","Y1S1.SE.04","Y1S1.DS.01","Y1S1.DS.02","Y1S1.DS.03"}));
		frame.getContentPane().add(grp);
		
		JLabel lblAvailableDays = new JLabel("Select Subject");
		lblAvailableDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailableDays.setBounds(93, 675, 125, 39);
		frame.getContentPane().add(lblAvailableDays);
		
		JComboBox sub = new JComboBox();
		sub.setBounds(248, 684, 410, 26);
		sub.setModel(new DefaultComboBoxModel(new String[] {"SE","OOP","OOC","DS","PAF","ESD","DMS","OSSA","OOC","DS","PAF","ESD"}));
		frame.getContentPane().add(sub);
		
		JComboBox tag = new JComboBox();
		tag.setBounds(845, 510, 410, 26);
		tag.setModel(new DefaultComboBoxModel(new String[] {"Lecture","Tutorial","Lab"}));
		frame.getContentPane().add(tag);
		
		JComboBox code = new JComboBox();
		code.setBounds(845, 566, 410, 26);
		code.setModel(new DefaultComboBoxModel(new String[] {"IT1010","SE1010","IT1020","SE2020","IT1010","SE3022","IT3010","SE2022","IT1010","SE2022","IT1010","SE2022"}));
		frame.getContentPane().add(code);
		
		no = new JTextField();
		no.setColumns(10);
		no.setBounds(845, 625, 410, 26);
		frame.getContentPane().add(no);
		
		JComboBox time = new JComboBox();
		time.setBounds(845, 684, 410, 26);
		time.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(time);
		
		JLabel lblRoomType_2_1 = new JLabel("Duration");
		lblRoomType_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_2_1.setBounds(690, 675, 125, 39);
		frame.getContentPane().add(lblRoomType_2_1);
		
		JLabel lblBuilding = new JLabel("No. of Students");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuilding.setBounds(690, 615, 156, 39);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblNewLabel_2_1 = new JLabel("Code");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(690, 554, 125, 39);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tag");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(690, 501, 125, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnAddSession = new JButton("ADD Session");
		btnAddSession.setForeground(Color.BLACK);
		btnAddSession.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddSession.setBackground(new Color(123, 104, 238));
		btnAddSession.setBounds(999, 157, 256, 48);
		frame.getContentPane().add(btnAddSession);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBackground(new Color(123, 104, 238));
		btnSearch.setBounds(671, 157, 256, 48);
		frame.getContentPane().add(btnSearch);
		
		JComboBox search = new JComboBox();
		search.setBounds(248, 175, 410, 26);
		frame.getContentPane().add(search);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		
		btnNewButton_1.setBounds(955, 411, 97, 48);
		frame.getContentPane().add(btnNewButton_1);
			
	}
}
