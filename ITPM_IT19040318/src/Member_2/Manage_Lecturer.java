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

public class Manage_Lecturer {

	private JFrame frame;
	private JTable table;
	
	private JComboBox center;
	private JComboBox level;
	private JComboBox day;
	private JComboBox bu;
	private JComboBox dep;
	private JComboBox time;
	private JComboBox fac;
	private JTextField name;
	private JTextField lid;
	private JTextField rank;
	private JTextField id;
	

	/**
//	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Lecturer window = new Manage_Lecturer();
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
	public Manage_Lecturer() {
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
					
					String query="select * from lecturers ";
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
		frame.setBounds(100, 100, 1269, 722);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Lecturer");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(517, 78, 269, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(255, 153, 51));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//if(name.getText().equals("")||lid.getText().equals("")|| fac.getSelectedItem().equals("")||dep.getSelectedItem().equals("")||center.getSelectedItem().equals("")|| bu.getSelectedItem().equals("")||level.getSelectedItem().equals("")||rank.getText().equals("")||day.getSelectedItem().equals("")|| time.getSelectedItem().equals("")) {
//					
//					JOptionPane.showMessageDialog(null, "Please fill the form");
//				}else {
				try {
					Connection con = DBConnect.connect();					
					String query="Update lecturers set lectureName='"+name.getText().toString()+"',empID='"+lid.getText().toString()+"',rank='"+rank.getText().toString()+"' where lid='"+id.getText()+"'";
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
		btnNewButton.setBounds(38, 322, 173, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from lecturers where lid='"+id.getText()+"'";
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
		btnDelete.setBounds(261, 322, 161, 48);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(123, 104, 238));
		btnClear.setForeground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				
				name.setText(null);
				lid.setText(null);
				fac.setSelectedItem(null);
				dep.setSelectedItem(null);
				center.setSelectedItem(null);
				bu.setSelectedItem(null);
				level.setSelectedItem(null);
			    rank.setText(null);
				day.setSelectedItem(null);
				time.setSelectedItem(null);
				
				
				
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(476, 322, 140, 48);
		frame.getContentPane().add(btnClear);
	 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 144, 1168, 157);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
			    id.setText(table.getValueAt(selectedRow, 0).toString());
			    name.setText(table.getValueAt(selectedRow, 1).toString());
			    lid.setText(table.getValueAt(selectedRow, 2).toString());
			    rank.setText(table.getValueAt(selectedRow, 8).toString());
			    
//			    String comboLevel = table.getValueAt(selectedRow, 3).toString();
//				
//			    
//			    for(int i=0; i<fac.getItemCount();i++) {
//					if(fac.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
//						fac.setSelectedIndex(i);
//					}
//				}
//			    
//			    String comboLevel2 = table.getValueAt(selectedRow, 4).toString();
//				
//			    
//			    for(int i=0; i<dep.getItemCount();i++) {
//					if(dep.getItemAt(i).toString().equalsIgnoreCase(comboLevel2)) {
//						dep.setSelectedIndex(i);
//					}
//				}
//			    
//			    String comboLevel3 = table.getValueAt(selectedRow, 5).toString();
//				
//			    
//			    for(int i=0; i<center.getItemCount();i++) {
//					if(center.getItemAt(i).toString().equalsIgnoreCase(comboLevel3)) {
//						center.setSelectedIndex(i);
//					}
//				}
//			    
//String comboLevel4 = table.getValueAt(selectedRow, 6).toString();
//				
//			    
//			    for(int i=0; i<bu.getItemCount();i++) {
//					if(bu.getItemAt(i).toString().equalsIgnoreCase(comboLevel4)) {
//						bu.setSelectedIndex(i);
//					}
//				}
//			    
//String comboLevel5 = table.getValueAt(selectedRow, 7).toString();
//				
//			    
//			    for(int i=0; i<level.getItemCount();i++) {
//					if(level.getItemAt(i).toString().equalsIgnoreCase(comboLevel5)) {
//						level.setSelectedIndex(i);
//					}
//				}
//			    
//String comboLevel6 = table.getValueAt(selectedRow, 9).toString();
//				
//			    
//			    for(int i=0; i<day.getItemCount();i++) {
//					if(day.getItemAt(i).toString().equalsIgnoreCase(comboLevel6)) {
//						day.setSelectedIndex(i);
//					}
//				}
//String comboLevel7 = table.getValueAt(selectedRow, 10).toString();
//				
//			    
//			    for(int i=0; i<time.getItemCount();i++) {
//					if(time.getItemAt(i).toString().equalsIgnoreCase(comboLevel7)) {
//						time.setSelectedIndex(i);
//					}
//				}       
//										 
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setBounds(49, 0, 1070, 93);
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
		separator_main.setBounds(0, 81, 1255, 12);
		frame.getContentPane().add(separator_main);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(20, 380, 125, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Faculty");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(20, 440, 125, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox fac = new JComboBox();
		fac.setBounds(175, 452, 410, 26);
		fac.setModel(new DefaultComboBoxModel(new String[] {"Computing","Engineering","Business"}));
		frame.getContentPane().add(fac);
		
		JComboBox center = new JComboBox();
		center.setBounds(175, 510, 410, 26);
		center.setModel(new DefaultComboBoxModel(new String[] {"Colombo","Kandy","Galle"}));
		frame.getContentPane().add(center);
		
		JLabel lblRoomType = new JLabel("Center");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(20, 501, 125, 39);
		frame.getContentPane().add(lblRoomType);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLevel.setBounds(20, 552, 125, 39);
		frame.getContentPane().add(lblLevel);
		
		JComboBox level = new JComboBox();
		level.setBounds(175, 561, 410, 26);
		level.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4","5","6"}));
		frame.getContentPane().add(level);
		
		JLabel lblAvailableDays = new JLabel("Available Days");
		lblAvailableDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailableDays.setBounds(20, 607, 125, 39);
		frame.getContentPane().add(lblAvailableDays);
		
		JComboBox day = new JComboBox();
		day.setBounds(175, 616, 410, 26);
		day.setModel(new DefaultComboBoxModel(new String[] {"Monday","TesuseDay","WednesDay","ThursdDay","FriDay","SaturDay","Sunday"}));
		frame.getContentPane().add(day);
		
	
		
		JComboBox dep = new JComboBox();
		dep.setBounds(772, 452, 410, 26);
		dep.setModel(new DefaultComboBoxModel(new String[] {"Information Technology","Software Engineering","Civil Engineering"," Electronic & Electrical"," Mechanical","Business Management"," Marketing","Acoounting & Finance"}));
		frame.getContentPane().add(dep);
		
		JComboBox bu = new JComboBox();
		bu.setBounds(772, 510, 410, 26);
		bu.setModel(new DefaultComboBoxModel(new String[] {"A","B","C"}));
		frame.getContentPane().add(bu);
		
		
		
		JComboBox time = new JComboBox();
		time.setBounds(772, 616, 410, 26);
		time.setModel(new DefaultComboBoxModel(new String[] {"8.00 a.m. - 2.00 p.m.","2.00 p.m. - 8.00 p.m."}));
		frame.getContentPane().add(time);
		
		JLabel lblRoomType_2_1 = new JLabel("Available Time");
		lblRoomType_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_2_1.setBounds(617, 607, 125, 39);
		frame.getContentPane().add(lblRoomType_2_1);
		
		JLabel lblRoomType_1_1 = new JLabel("Rank");
		lblRoomType_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_1_1.setBounds(617, 552, 125, 39);
		frame.getContentPane().add(lblRoomType_1_1);
		
		JLabel lblBuilding = new JLabel("Building");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuilding.setBounds(617, 501, 125, 39);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblNewLabel_2_1 = new JLabel("Department");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(617, 440, 125, 39);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Employee ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(617, 380, 125, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(175, 390, 410, 26);
		frame.getContentPane().add(name);
		
		lid = new JTextField();
		lid.setColumns(10);
		lid.setBounds(772, 390, 410, 26);
		frame.getContentPane().add(lid);
		
		rank = new JTextField();
		rank.setColumns(10);
		rank.setBounds(772, 565, 410, 26);
		frame.getContentPane().add(rank);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(1100, 338, 78, 26);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(1055, 328, 35, 39);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btngenerate = new JButton("Generate Rank");
		btngenerate.setForeground(Color.BLACK);
		btngenerate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btngenerate.setBackground(Color.ORANGE);
		btngenerate.setBounds(670, 322, 264, 48);
		frame.getContentPane().add(btngenerate);
		
		JButton btnNewButton_1 = new JButton("Home");
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setBounds(946, 322, 97, 48);
		frame.getContentPane().add(btnNewButton_1);
		
		btngenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Generate group id with selected year and semester,program and group id and sub id 
				
				rank.setText(level.getSelectedItem().toString() + "." + lid.getText().toString());
			}
		});
		
			
	}
}
