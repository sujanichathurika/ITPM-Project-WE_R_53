package Member_1;

import java.awt.Color;


import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractButton;
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
import Member_1.Manage_Reg_New_Std_Upd_Dele;
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

public class Reg_New_Std_Upd_Dele {

	JFrame frame; //remove the private because direct from home page
	private JButton company_name;
	private JButton Save;
	private JButton Clear;
	private JButton G_ID_gen;
	private JButton G_ID_remove;
	private JButton Sub_ID_gen;
	private JButton Sub_ID_remove;
	private JButton Updatebtn;
	private JButton Delebtn;
	
	private JScrollPane scrollpane;
	private JComboBox Select_Yer_Sem;
	private JComboBox Select_prog;
	private JComboBox Select__G_ID;
	private JComboBox Select__SubG_ID;
	private JTextPane DisplayGrN;
	private JTextPane DisplaySubGNum;

	

	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reg_New_Std_Upd_Dele window = new Reg_New_Std_Upd_Dele();
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
	public Reg_New_Std_Upd_Dele() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
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
				
				Home_Frame AWh = new Home_Frame();
				try {
					Home_Frame.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});	//direct to home frame from  std frame
				
		frame.getContentPane().add(company_icon);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setBounds(0, 90, 1073, 3);
		separator_main.setBackground(Color.BLACK);
		separator_main.setForeground(Color.BLACK);
		frame.getContentPane().add(separator_main);
		
		JLabel R_new_std = new JLabel("Register a New Student");
		R_new_std.setBounds(269, 106, 487, 25);
		R_new_std.setFont(new Font("Sylfaen", Font.BOLD, 20));
		R_new_std.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(R_new_std);
		
		JLabel Year_Sem = new JLabel("Academic Year & Semester");
		Year_Sem.setBounds(215, 143, 199, 24);
		Year_Sem.setForeground(Color.BLACK);
		Year_Sem.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		Year_Sem.setHorizontalAlignment(SwingConstants.CENTER);
 		frame.getContentPane().add(Year_Sem);
		
		JLabel std_program = new JLabel("Programm");
		std_program.setBounds(222, 200, 192, 24);
		std_program.setForeground(Color.BLACK);
		std_program.setHorizontalAlignment(SwingConstants.CENTER);
		std_program.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(std_program);
		
		JLabel Grp_num = new JLabel("Group Number");
		Grp_num.setBounds(235, 264, 179, 24);
		Grp_num.setForeground(Color.BLACK);
		Grp_num.setHorizontalAlignment(SwingConstants.CENTER);
		Grp_num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Grp_num);
		
		JLabel Gene_Grp_Num = new JLabel("Generate Group ID");
		Gene_Grp_Num.setBounds(246, 317, 168, 24);
		Gene_Grp_Num.setForeground(Color.BLACK);
		Gene_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Gene_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Gene_Grp_Num);
		
		JLabel Sub_Grp_Num = new JLabel("Sub-Group Number");
		Sub_Grp_Num.setBounds(246, 374, 182, 24);
		Sub_Grp_Num.setForeground(Color.BLACK);
		Sub_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Sub_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Sub_Grp_Num);
		
		JLabel Gene_Sub_Grp_Num = new JLabel("Generate Sub-Group ID");
		Gene_Sub_Grp_Num.setBounds(246, 440, 182, 24);
		Gene_Sub_Grp_Num.setForeground(Color.BLACK);
		Gene_Sub_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Gene_Sub_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		frame.getContentPane().add(Gene_Sub_Grp_Num);
				
		JComboBox Select_Yer_Sem = new JComboBox();
		Select_Yer_Sem.setBounds(505, 143, 192, 25);
		Select_Yer_Sem.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		Select_Yer_Sem.setForeground(Color.BLACK);
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
		
		JComboBox Select_prog = new JComboBox();
		Select_prog.setBounds(505, 200, 192, 25);
		//Select_prog.setSelectedIndex(8);
		Select_prog.setForeground(Color.BLACK);
		Select_prog.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Select_prog);
		//add Programmers
		Select_prog.addItem("IT");
		Select_prog.addItem("CSSE");
		Select_prog.addItem("CSE");
		Select_prog.addItem("IM");
		
		JComboBox Select__G_ID = new JComboBox();
		Select__G_ID.setBounds(505, 264, 192, 25);
		Select__G_ID.setForeground(Color.BLACK);
		Select__G_ID.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Select__G_ID);
		frame.setBounds(200, 200, 1091, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add group numbers
		Select__G_ID.addItem(01);
		Select__G_ID.addItem(02);
		Select__G_ID.addItem(03);
		Select__G_ID.addItem(04);
		
		
		JComboBox Select__SubG_ID = new JComboBox();
		Select__SubG_ID.setBounds(505, 374, 192, 25);
		Select__SubG_ID.setForeground(Color.BLACK);
		Select__SubG_ID.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Select__SubG_ID);
		//add Sub group numbers
		Select__SubG_ID.addItem(01);
		Select__SubG_ID.addItem(02);
		
		JTextPane DisplayGrN = new JTextPane();
		DisplayGrN.setBounds(505, 317, 192, 22);
		frame.getContentPane().add(DisplayGrN);
		
		JTextPane DisplaySubGNum = new JTextPane();
		DisplaySubGNum.setBounds(505, 430, 192, 22);
		frame.getContentPane().add(DisplaySubGNum);
		
		//add by me 
		
		JButton G_ID_gen = new JButton("Generate");
		G_ID_gen.setBounds(743, 317, 97, 25);
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
		
		//remove generated id 
		JButton G_ID_remove = new JButton("Remove");
		G_ID_remove.setBounds(852, 317, 97, 24);
		G_ID_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//remove generated ID
				DisplayGrN.setText(" "); //Remove generated id when the user click remove button

			}
		});
		G_ID_remove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(G_ID_remove);
		
		JButton Sub_ID_gen = new JButton("Generate");
		Sub_ID_gen.setBounds(743, 427, 97, 25);
		Sub_ID_gen.setForeground(Color.BLACK);
		Sub_ID_gen.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Sub_ID_gen);
		
		//generate sub group id with year,program,group id and sub group id  
		Sub_ID_gen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Generate group id with selected year and semester,program and group id and sub id 
				DisplaySubGNum.setText(Select_Yer_Sem.getSelectedItem().toString() + "." + Select_prog.getSelectedItem().toString() + "." + Select__G_ID.getSelectedItem().toString() + "." + Select__SubG_ID.getSelectedItem().toString()  );
				
			}
		});
		
		JButton Sub_ID_remove = new JButton("Remove");
		Sub_ID_remove.setBounds(852, 427, 97, 25);
		Sub_ID_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//remove generated std sub group id
				DisplaySubGNum.setText(" "); ////Remove generated sub id when the user click remove button
			}
		});
		Sub_ID_remove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		frame.getContentPane().add(Sub_ID_remove);

		JButton Save = new JButton("SAVE");
		Save.setBounds(477, 539, 135, 58);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
					//add row values to table
					String value_Select_Yer_Sem = Select_Yer_Sem.getSelectedItem().toString();
					String value_Select_prog = Select_prog.getSelectedItem().toString();
					String value_DisplayGrN = DisplayGrN.getText();
					String value_DisplaySubGNum =DisplaySubGNum.getText();
					
					try {
						 Connection con = DBConnect.connect();

		                    String query = "INSERT INTO studentGroups VALUES(null, '" + value_Select_Yer_Sem + "','" + value_Select_prog + "','" + value_DisplayGrN + "', '" + value_DisplaySubGNum + "')";

		                    Statement sta = con.createStatement();
		                    int x = sta.executeUpdate(query);
		                    if (x == 0) {
		                        JOptionPane.showMessageDialog(Save, "This alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(Save,"successfully Added");
		                    }
		                    con.close();
		                } catch (Exception exception) {
		                    exception.printStackTrace();
		                    System.out.println("Errorr!");
		                	
		                }
			}	
		});
		
		Save.setForeground(Color.BLACK);
		Save.setFont(new Font("Sylfaen", Font.BOLD, 16));
		Save.setBackground(Color.PINK);
		frame.getContentPane().add(Save);
		
		JButton Clear = new JButton("CLEAR");
		Clear.setBounds(689, 539, 123, 58);
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//clear field data 
				Select_Yer_Sem.setSelectedItem("");
				Select_prog.setSelectedItem("");
				DisplayGrN.setText("");
				DisplaySubGNum.setText("");
				
				
			}
		});
		Clear.setForeground(Color.BLACK);
		Clear.setFont(new Font("Sylfaen", Font.BOLD, 16));
		Clear.setBackground(new Color(30, 144, 255));
		frame.getContentPane().add(Clear);
		
		JButton View = new JButton("VIEW");
		View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Reg_New_Std_Upd_Dele Manage_Reg_New_Std_Upd_Dele= new Manage_Reg_New_Std_Upd_Dele();
				try {
					Manage_Reg_New_Std_Upd_Dele.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				View.setVisible(false);
}
				
				
			
		});
		View.setForeground(Color.BLACK);
		View.setFont(new Font("Sylfaen", Font.BOLD, 16));
		View.setBackground(Color.GREEN);
		View.setBounds(246, 539, 135, 58);
		frame.getContentPane().add(View);
		
		
		
		
	}

}



