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

public class Manage_Subject {

	private JFrame frame;
	private JTable table;
	
	private JComboBox yr;
	private JComboBox sem;
	private JComboBox lab;
	private JComboBox lec;
	private JComboBox tute;
	private JComboBox ev;
	private JTextField id;
	private JTextField sname;
	private JTextField code;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Subject window = new Manage_Subject();
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
	public Manage_Subject() {
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
					
					String query="select * from subjects ";
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
		
		JLabel lblNewLabel = new JLabel("Manage Subject");
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
				
//if(sname.getText().equals("")||code.getText().equals("")|| yr.getSelectedItem().equals("")||sem.getSelectedItem().equals("")||lec.getSelectedItem().equals("")|| tute.getSelectedItem().equals("")||lab.getSelectedItem().equals("")||ev.getSelectedItem().equals("")) {
//					
//					JOptionPane.showMessageDialog(null, "Please fill the form");
//				}else {
				try {
					Connection con = DBConnect.connect();					
					String query="Update subjects set subName='"+sname.getText()+"',subcode='"+code.getText()+"' where subID='"+id.getText()+"'";
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
		btnNewButton.setBounds(38, 322, 256, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from subjects where subID='"+id.getText()+"'";
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
		btnDelete.setBounds(344, 322, 256, 48);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(123, 104, 238));
		btnClear.setForeground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			
				
				
				
				
				sname.setText(null);
				code.setText(null);
				yr.setSelectedItem(null);
				sem.setSelectedItem(null);
				lec.setSelectedItem(null);
				tute.setSelectedItem(null);
				
				lab.setSelectedItem(null);
				ev.setSelectedItem(null);
				
				
				
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(645, 322, 256, 48);
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
			    sname.setText(table.getValueAt(selectedRow, 3).toString());
			    code.setText(table.getValueAt(selectedRow, 4).toString());
			    
			    
			    String comboLevel = table.getValueAt(selectedRow, 3).toString();
				
			    
//			    for(int i=0; i<yr.getItemCount();i++) {
//					if(yr.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
//						yr.setSelectedIndex(i);
//					}
//				}
//			    
//             String comboLevel1 = table.getValueAt(selectedRow, 4).toString();
//				
//			    
//			    for(int i=0; i<sem.getItemCount();i++) {
//					if(sem.getItemAt(i).toString().equalsIgnoreCase(comboLevel1)) {
//						sem.setSelectedIndex(i);
//					}
//				}
//			    
//String comboLevel2 = table.getValueAt(selectedRow, 3).toString();
//				
//			    
//			    for(int i=0; i<lec.getItemCount();i++) {
//					if(lec.getItemAt(i).toString().equalsIgnoreCase(comboLevel2)) {
//						lec.setSelectedIndex(i);
//					}
//				}
//String comboLevel3 = table.getValueAt(selectedRow, 3).toString();
//				
//			    
//			    for(int i=0; i<tute.getItemCount();i++) {
//					if(tute.getItemAt(i).toString().equalsIgnoreCase(comboLevel3)) {
//						tute.setSelectedIndex(i);
//					}
//				}
//String comboLevel4 = table.getValueAt(selectedRow, 3).toString();
//				
//			    
//			    for(int i=0; i<lab.getItemCount();i++) {
//					if(lab.getItemAt(i).toString().equalsIgnoreCase(comboLevel4)) {
//						lab.setSelectedIndex(i);
//					}
//				}
//String comboLevel5 = table.getValueAt(selectedRow, 3).toString();
//				
//			    
//			    for(int i=0; i<ev.getItemCount();i++) {
//					if(ev.getItemAt(i).toString().equalsIgnoreCase(comboLevel5)) {
//						ev.setSelectedIndex(i);
//					}
//				}
//				
//			    
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
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(1100, 338, 78, 26);
		frame.getContentPane().add(id);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(1055, 328, 35, 39);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(199, 421, 410, 26);
		frame.getContentPane().add(sname);
		
		JLabel lblNewLabel_1 = new JLabel("Subject Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(44, 411, 125, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Offered Year");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(44, 471, 125, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox yr = new JComboBox();
		yr.setBounds(199, 483, 410, 26);
		yr.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4"}));
		frame.getContentPane().add(yr);
		
		JComboBox lec = new JComboBox();
		lec.setBounds(199, 541, 410, 26);
		lec.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(lec);
		
		JLabel lblRoomType = new JLabel("Lecture Hrs");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(44, 532, 125, 39);
		frame.getContentPane().add(lblRoomType);
		
		JLabel lblAvailableDays = new JLabel("Lab Hrs");
		lblAvailableDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailableDays.setBounds(44, 592, 125, 39);
		frame.getContentPane().add(lblAvailableDays);
		
		JComboBox lab = new JComboBox();
		lab.setBounds(199, 601, 410, 26);
		lab.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(lab);
		
		JComboBox ev = new JComboBox();
		ev.setBounds(796, 601, 410, 26);
		ev.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(ev);
		
		JComboBox tute = new JComboBox();
		tute.setBounds(796, 541, 410, 26);
		tute.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(tute);
		
		JComboBox sem = new JComboBox();
		sem.setBounds(796, 483, 410, 26);
		sem.setModel(new DefaultComboBoxModel(new String[] {"1","2"}));
		frame.getContentPane().add(sem);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(796, 421, 410, 26);
		frame.getContentPane().add(code);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject Code");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(641, 411, 125, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Offered Semester");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(641, 471, 125, 39);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblBuilding = new JLabel("Tute Hrs");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuilding.setBounds(641, 532, 125, 39);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblRoomType_2_1 = new JLabel("Evaluation Hrs");
		lblRoomType_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_2_1.setBounds(641, 592, 125, 39);
		frame.getContentPane().add(lblRoomType_2_1);
		
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
		btnNewButton_1.setBounds(923, 322, 97, 48);
		frame.getContentPane().add(btnNewButton_1);
			
	}
}
