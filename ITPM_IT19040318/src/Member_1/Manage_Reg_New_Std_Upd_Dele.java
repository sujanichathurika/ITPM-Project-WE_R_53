package Member_1;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Manage_Reg_New_Std_Upd_Dele {

	private JFrame frame;
	private JTable table;
	private JTextField std_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Reg_New_Std_Upd_Dele window = new Manage_Reg_New_Std_Upd_Dele();
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
	public Manage_Reg_New_Std_Upd_Dele() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String query="select * from studentGroups "; //display data from DB
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		frame.setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1087, 734);
		frame.getContentPane().setLayout(null);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setBounds(184, 0, 836, 93);
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setForeground(new Color(0, 0, 139));
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		frame.getContentPane().add(company_name);
		
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
				
				//direct to home frame from  std frame
				
				//create Object (interface name,object name,interface name ) and set the initial frame name and remove the public 
				Reg_New_Std_Upd_Dele Reg_New_Std_Upd_Dele = new Reg_New_Std_Upd_Dele();
				Reg_New_Std_Upd_Dele.frame.setVisible(true);
				frame.dispose();				
				
			}
		});
		
		
		
		
		
		frame.getContentPane().add(company_icon);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setBounds(0, 89, 1121, 4);
		separator_main.setBackground(Color.BLACK);
		separator_main.setForeground(Color.BLACK);
		frame.getContentPane().add(separator_main);
		
		JLabel Year_Sem = new JLabel("Academic Year & Semester");
		Year_Sem.setBounds(12, 523, 199, 24);
		//Year_Se. 105tHorizontalAlignment(SwingConstants.CENTER);
		Year_Sem.setForeground(Color.BLACK);
		Year_Sem.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Year_Sem);
		
		JComboBox Select_Yer_Sem = new JComboBox();
		Select_Yer_Sem.setBounds(235, 523, 192, 25);
		Select_Yer_Sem.setForeground(Color.BLACK);
		Select_Yer_Sem.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Select_Yer_Sem);
		//add years and semesters
				Select_Yer_Sem.addItem("Y1S1");
				Select_Yer_Sem.addItem("Y1S2");
				Select_Yer_Sem.addItem("Y2S1");
				Select_Yer_Sem.addItem("Y2S2");
				Select_Yer_Sem.addItem("Y3S1");
				Select_Yer_Sem.addItem("Y3S2");
				Select_Yer_Sem.addItem("Y4S1");
				Select_Yer_Sem.addItem("Y4S2");
		
		JLabel std_program = new JLabel("Programm");
		std_program.setBounds(32, 601, 192, 24);
		std_program.setHorizontalAlignment(SwingConstants.CENTER);
		std_program.setForeground(Color.BLACK);
		std_program.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(std_program);
		
		JComboBox Select_prog = new JComboBox();
		Select_prog.setBounds(235, 601, 192, 25);
		Select_prog.setForeground(Color.BLACK);
		Select_prog.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Select_prog);
		//add Programmers
				Select_prog.addItem("IT");
				Select_prog.addItem("CSSE");
				Select_prog.addItem("CSE");
				Select_prog.addItem("IM");
		
		JLabel Grp_num = new JLabel("Group Number");
		Grp_num.setBounds(577, 452, 179, 24);
		Grp_num.setHorizontalAlignment(SwingConstants.CENTER);
		Grp_num.setForeground(Color.BLACK);
		Grp_num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Grp_num);
		
		JComboBox Select__G_ID = new JComboBox();
		Select__G_ID.setBounds(796, 452, 192, 25);
		Select__G_ID.setForeground(Color.BLACK);
		Select__G_ID.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Select__G_ID);
		//add group numbers
				Select__G_ID.addItem(01);
				Select__G_ID.addItem(02);
				Select__G_ID.addItem(03);
				Select__G_ID.addItem(04);
		
		JLabel Gene_Grp_Num = new JLabel("Generate Group ID");
		Gene_Grp_Num.setBounds(577, 487, 168, 24);
		Gene_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Gene_Grp_Num.setForeground(Color.BLACK);
		Gene_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Gene_Grp_Num);
		
		JTextPane DisplayGrN = new JTextPane();
		DisplayGrN.setBounds(796, 489, 192, 22);
		frame.getContentPane().add(DisplayGrN);
		
		JButton G_ID_gen = new JButton("Generate");
		G_ID_gen.setBounds(796, 523, 97, 25);
		G_ID_gen.setForeground(Color.BLACK);
		G_ID_gen.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(G_ID_gen);
		//Generate group id with selected year and semester,program and group id 
		
				G_ID_gen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//Generate group id with selected year and semester,program and group id and sub id 
						DisplayGrN.setText(Select_Yer_Sem.getSelectedItem().toString() + "." + Select_prog.getSelectedItem().toString() + "." + Select__G_ID.getSelectedItem().toString() );
						
					}
				});
		
		JButton G_ID_remove = new JButton("Remove");
		G_ID_remove.setBounds(891, 524, 97, 24);
		G_ID_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//remove generated ID
				DisplayGrN.setText(" "); //Remove generated id when the user click remove button

			}
		});
		G_ID_remove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(G_ID_remove);
		
		
		
		JLabel Sub_Grp_Num = new JLabel("Sub-Group Number");
		Sub_Grp_Num.setBounds(577, 566, 182, 24);
		Sub_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Sub_Grp_Num.setForeground(Color.BLACK);
		Sub_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Sub_Grp_Num);
		
		JComboBox Select__SubG_ID = new JComboBox();
		Select__SubG_ID.setBounds(796, 566, 192, 25);
		Select__SubG_ID.setForeground(Color.BLACK);
		Select__SubG_ID.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Select__SubG_ID);
		//add Sub group numbers
				Select__SubG_ID.addItem(01);
				Select__SubG_ID.addItem(02);
				
		
		JLabel Gene_Sub_Grp_Num = new JLabel("Generate Sub-Group ID");
		Gene_Sub_Grp_Num.setBounds(577, 601, 182, 24);
		Gene_Sub_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Gene_Sub_Grp_Num.setForeground(Color.BLACK);
		Gene_Sub_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Gene_Sub_Grp_Num);
		
		
		JTextPane DisplaySubGNum = new JTextPane();
		DisplaySubGNum.setBounds(796, 603, 192, 22);
		frame.getContentPane().add(DisplaySubGNum);
		
		JButton Sub_ID_gen = new JButton("Generate");
		Sub_ID_gen.setBounds(796, 641, 97, 25);
		Sub_ID_gen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//generate sub group id with year,program,group id and sub group id  
				Sub_ID_gen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//Generate group id with selected year and semester,program and group id and sub id 
						DisplaySubGNum.setText(Select_Yer_Sem.getSelectedItem().toString() + "." + Select_prog.getSelectedItem().toString() + "." + Select__G_ID.getSelectedItem().toString() + "." + Select__SubG_ID.getSelectedItem().toString()  );
						
					}
				});
			}
		});
		Sub_ID_gen.setForeground(Color.BLACK);
		Sub_ID_gen.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Sub_ID_gen);
		
		JButton Sub_ID_remove = new JButton("Remove");
		Sub_ID_remove.setBounds(891, 641, 97, 25);
		Sub_ID_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//remove generated std sub group id
				DisplaySubGNum.setText(" "); ////Remove generated sub id when the user click remove button
			}
		});
		Sub_ID_remove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Sub_ID_remove);
		
		JLabel R_new_std = new JLabel("Manage Student");
		R_new_std.setBounds(55, 99, 639, 40);
		R_new_std.setHorizontalAlignment(SwingConstants.CENTER);
		R_new_std.setFont(new Font("Sylfaen", Font.BOLD, 20));
		frame.getContentPane().add(R_new_std);
		
		JLabel std_id = new JLabel("ID");
		std_id.setBounds(12, 452, 192, 24);
		std_id.setHorizontalAlignment(SwingConstants.CENTER);
		std_id.setForeground(Color.BLACK);
		std_id.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(std_id);
		
		
		//update the data table from DB
		JButton Update = new JButton("UPDATE");
		Update.setBounds(857, 145, 163, 46);
		Update.setFont(new Font("Dialog", Font.BOLD, 16));
		Update.setBackground(Color.GREEN);
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				if(Select_Yer_Sem.getSelectedItem().equals("")||Select_prog.getSelectedItem().equals("")|| DisplayGrN.getText().equals("")|| DisplaySubGNum.getText().equals("")) {
//					
//					JOptionPane.showMessageDialog(null, "Please fill the form");
//				}
//				else{
					try {
						
					Connection con = DBConnect.connect();		
					
					String query="UPDATE studentGroups SET academicYearSemester='"+Select_Yer_Sem.getSelectedItem()+"',programme='"+Select_prog.getSelectedItem()+"',groupID='"+DisplayGrN.getText()+"',subGroupID='"+DisplaySubGNum.getText()+"' WHERE StGroupID ='"+ std_ID.getText()+"'";
					
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated successfully");
					pst.close();
					
					}
					catch(Exception ea) {
					ea.printStackTrace();
					}
				}
				
				
				
		//	}
		});
		frame.getContentPane().add(Update);
		
		JButton Delete = new JButton("DELETE");
		Delete.setBounds(857, 225, 163, 46);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from studentGroups where stGroupID ='"+std_ID.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted successfully");
					pst.close();
					
					}
					catch(Exception en) {
						en.printStackTrace();
						
					}
				
			}
		});
		Delete.setFont(new Font("Dialog", Font.BOLD, 16));
		Delete.setBackground(Color.RED);
		frame.getContentPane().add(Delete);
		
		
		JButton Clear = new JButton("CLEAR");
		Clear.setBounds(857, 300, 163, 46);
		Clear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					Select_Yer_Sem.setSelectedItem(null);
					Select_prog.setSelectedItem(null);
					DisplayGrN.setText(null);
					DisplaySubGNum.setText(null);
					
				}
			});
		Clear.setFont(new Font("Dialog", Font.BOLD, 16));
		Clear.setBackground(Color.BLUE);
		frame.getContentPane().add(Clear);
		


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 140, 788, 280);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(211, 211, 211));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
				std_ID.setText(table.getValueAt(selectedRow, 0).toString());
				DisplayGrN.setText(table.getValueAt(selectedRow, 3).toString());
				DisplaySubGNum.setText(table.getValueAt(selectedRow, 4).toString());
			    
			    String seletyearsem = table.getValueAt(selectedRow, 1).toString();
			    String selectprog = table.getValueAt(selectedRow, 2).toString();

		
			    	
				}
			               
										 
			
		});
		scrollPane.setViewportView(table);
		
		std_ID = new JTextField();
		std_ID.setBounds(235, 453, 192, 23);
		frame.getContentPane().add(std_ID);
		std_ID.setColumns(10);
		

	}
}
