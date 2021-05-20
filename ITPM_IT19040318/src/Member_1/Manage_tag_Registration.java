package Member_1;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;

public class Manage_tag_Registration {

	private JFrame frame;
	private JTextField dis_tag_name;
	private JTable table;
	private JTextField display_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_tag_Registration window = new Manage_tag_Registration();
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
	public Manage_tag_Registration() {
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
					
					String query="select * from tag ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBounds(184, 0, 836, 93);
		frame.getContentPane().add(company_name);
		
		JButton company_icon = new JButton("");
		//add company icon
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		company_icon.setIcon(new ImageIcon(img));
		company_icon.setBackground(Color.LIGHT_GRAY);
		company_icon.setForeground(Color.LIGHT_GRAY);
		company_icon.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 43));
		company_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//direct to home frame from  tag frame
				
				//create Object (interface name,object name,interface name ) and set the initial frame name and remove the public 
				Tag_Registration Tag_Registration = new Tag_Registration();
				Tag_Registration.frame.setVisible(true);
				frame.dispose();		
				
			}
		});
		company_icon.setBounds(95, 13, 77, 64);
		frame.getContentPane().add(company_icon);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setBackground(Color.BLACK);
		separator_main.setForeground(Color.BLACK);
		separator_main.setBounds(0, 90, 1073, 3);
		frame.getContentPane().add(separator_main);
		
		JLabel Tag_R = new JLabel("Manage Tag Registration");
		Tag_R.setHorizontalAlignment(SwingConstants.CENTER);
		Tag_R.setFont(new Font("Sylfaen", Font.BOLD, 20));
		Tag_R.setBounds(262, 105, 556, 43);
		frame.getContentPane().add(Tag_R);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
				display_ID.setText(table.getValueAt(selectedRow, 0).toString());
				dis_tag_name.setText(table.getValueAt(selectedRow, 1).toString());
	
			}
		});
		scrollPane.setBounds(287, 181, 436, 249);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(230, 230, 250));
		frame.setBounds(200, 200, 1091, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel Tag_Name = new JLabel("Tag Name");
		Tag_Name.setHorizontalAlignment(SwingConstants.CENTER);
		Tag_Name.setForeground(Color.BLACK);
		Tag_Name.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		Tag_Name.setBounds(287, 548, 150, 24);
		frame.getContentPane().add(Tag_Name);
		
		dis_tag_name = new JTextField();
		dis_tag_name.setColumns(10);
		dis_tag_name.setBounds(533, 544, 190, 30);
		frame.getContentPane().add(dis_tag_name);
		
		JLabel id = new JLabel("ID");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		id.setBounds(287, 485, 150, 24);
		frame.getContentPane().add(id);
		
		display_ID = new JTextField();
		display_ID.setColumns(10);
		display_ID.setBounds(533, 473, 190, 30);
		frame.getContentPane().add(display_ID);
		
		
		
		
		
		JButton Update = new JButton("UPDATE");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dis_tag_name.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please fill the form");
				}
				else{
					try {
						
					Connection con = DBConnect.connect();		
					
					String query="UPDATE tag SET tagName ='"+dis_tag_name.getText()+"' WHERE tagID='"+ display_ID .getText()+"'";
					
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated successfully");
					pst.close();
					
					}
					catch(Exception ea) {
					ea.printStackTrace();
					}
				}
			}
		});
		Update.setFont(new Font("Dialog", Font.BOLD, 16));
		Update.setBackground(Color.GREEN);
		Update.setBounds(816, 204, 163, 46);
		frame.getContentPane().add(Update);
		
		JButton Delete = new JButton("DELETE");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from location where tagID = '"+display_ID.getText()+"'";
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
		Delete.setFont(new Font("Dialog", Font.BOLD, 16));
		Delete.setBackground(Color.RED);
		Delete.setBounds(816, 278, 163, 46);
		frame.getContentPane().add(Delete);
		
		JButton Clear = new JButton("CLEAR");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dis_tag_name.setText(null); //clear text feild
				display_ID.setText(null);
				
			}
			
		});
		Clear.setFont(new Font("Dialog", Font.BOLD, 16));
		Clear.setBackground(Color.BLUE);
		Clear.setBounds(816, 359, 163, 46);
		frame.getContentPane().add(Clear);
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}