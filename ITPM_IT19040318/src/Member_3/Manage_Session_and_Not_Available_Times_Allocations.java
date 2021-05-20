package Member_3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class Manage_Session_and_Not_Available_Times_Allocations {

	private JFrame frmAddNotAvailbleTime;
	private JTable table;
	private JTextField textField_10;
	private JButton btnClear;
	private JComboBox comboBox_4;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JComboBox comboBox_11;
	private JTextField spi4;
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
					Manage_Session_and_Not_Available_Times_Allocations window = new Manage_Session_and_Not_Available_Times_Allocations();
					window.frmAddNotAvailbleTime.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillComboBox2() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from studentGroups";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String group=rs.getString("groupID");
				String subgroup=rs.getString("subGroupID");
				
				comboBox_4.addItem(group);
				comboBox_2.addItem(subgroup);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillComboBox3() {
		try {
			Connection con = DBConnect.connect();
			
			String query="select * from lecturers";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			//comboBox.setModel(DbUtils.resultSetToNestedList(rs));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer..."}))
			while(rs.next()) {
				String name=rs.getString("lectureName");
				comboBox_3.addItem(name);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the application.
	 */
	public Manage_Session_and_Not_Available_Times_Allocations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddNotAvailbleTime = new JFrame();
		frmAddNotAvailbleTime.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frmAddNotAvailbleTime.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					
					String query="select * from timeAlloLecture ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frmAddNotAvailbleTime.getContentPane().setBackground(new Color(72, 209, 204));
		frmAddNotAvailbleTime.setBackground(Color.YELLOW);
		frmAddNotAvailbleTime.setResizable(false);
		frmAddNotAvailbleTime.setTitle("Manage Available Time");
		frmAddNotAvailbleTime.setBounds(350, 90, 1245, 761);
		frmAddNotAvailbleTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddNotAvailbleTime.getContentPane().setLayout(null);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/tt.png/"));
		
		 JComboBox comboBox_1 = new JComboBox();
		 comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 comboBox_1.setBounds(816, 393, 144, 34);
		 comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		 frmAddNotAvailbleTime.getContentPane().add(comboBox_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 138, 1091, 172);
		frmAddNotAvailbleTime.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
                int selectedRow=table.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel)table.getModel();
				
                textField_10.setText(table.getValueAt(selectedRow, 0).toString());		
    
				spi4.setText(table.getValueAt(selectedRow, 6).toString());
				spi3.setText(table.getValueAt(selectedRow, 4).toString());
				
			
				
				  String comboLevel1 = table.getValueAt(selectedRow, 2).toString();
				  
				  
				    String comboLevel0 = table.getValueAt(selectedRow, 5).toString();		
				    for(int i=0; i<comboBox_1.getItemCount();i++) {
						if(comboBox_1.getItemAt(i).toString().equalsIgnoreCase(comboLevel0)) {
							comboBox_1.setSelectedIndex(i);
						}
					}
				    
                String comboLevel = table.getValueAt(selectedRow, 2).toString();
				for(int i=0; i<comboBox_4.getItemCount();i++) {
					if(comboBox_4.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
						
						
						comboBox_4.setSelectedIndex(i);
					}
				}
				
				
				String comboLevel4 = table.getValueAt(selectedRow, 3).toString();
				for(int i=0; i<comboBox_2.getItemCount();i++) {
					if(comboBox_2.getItemAt(i).toString().equalsIgnoreCase(comboLevel4)) {
						
						
						comboBox_2.setSelectedIndex(i);
					}
				}
				
				String comboLevel5 = table.getValueAt(selectedRow, 1).toString();
				for(int i=0; i<comboBox_3.getItemCount();i++) {
					if(comboBox_3.getItemAt(i).toString().equalsIgnoreCase(comboLevel5)) {
						
						
						comboBox_3.setSelectedIndex(i);
					}
				}
                
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		JLabel lblLectimealloid = new JLabel("ID");
		lblLectimealloid.setForeground(new Color(0, 0, 0));
		lblLectimealloid.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLectimealloid.setBounds(173, 323, 104, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblLectimealloid);
		
		JLabel lblLectureName = new JLabel("Lecture Name");
		lblLectureName.setForeground(new Color(0, 0, 0));
		lblLectureName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLectureName.setBounds(173, 395, 252, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblLectureName);
		
		JLabel lblGroup = new JLabel("Group");
		lblGroup.setForeground(new Color(0, 0, 0));
		lblGroup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGroup.setBounds(173, 463, 252, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblGroup);
		
		JLabel lblSubgroup = new JLabel("SubGroup");
		lblSubgroup.setForeground(new Color(0, 0, 0));
		lblSubgroup.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSubgroup.setBounds(173, 521, 252, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblSubgroup);
		
		JLabel lblSessionSignature = new JLabel("Session ID");
		lblSessionSignature.setForeground(new Color(0, 0, 0));
		lblSessionSignature.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSessionSignature.setBounds(650, 326, 138, 25);
		frmAddNotAvailbleTime.getContentPane().add(lblSessionSignature);
		
		JLabel spi = new JLabel("Time");
		spi.setForeground(new Color(0, 0, 0));
		spi.setFont(new Font("Tahoma", Font.BOLD, 20));
		spi.setBounds(650, 395, 122, 25);
		frmAddNotAvailbleTime.getContentPane().add(spi);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setForeground(Color.BLACK);
		textField_10.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_10.setColumns(10);
		textField_10.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		textField_10.setBackground(SystemColor.control);
		textField_10.setBounds(330, 323, 274, 34);
		frmAddNotAvailbleTime.getContentPane().add(textField_10);
		
		 comboBox_4 = new JComboBox();
		 comboBox_4.setBackground(SystemColor.control);
		 comboBox_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 comboBox_4.setForeground(new Color(0, 0, 0));
	     comboBox_4.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		 comboBox_4.setBounds(330, 462, 276, 34);
		 frmAddNotAvailbleTime.getContentPane().add(comboBox_4);
		

		
		 comboBox_2 = new JComboBox();
		comboBox_2.setForeground(new Color(0, 0, 0));
		comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_2.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		comboBox_2.setBackground(SystemColor.control);
		comboBox_2.setBounds(330, 518, 276, 34);
		frmAddNotAvailbleTime.getContentPane().add(comboBox_2);
		
		 comboBox_3 = new JComboBox();
		comboBox_3.setForeground(new Color(0, 0, 0));
		comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_3.setBorder(new LineBorder(new Color(169, 224, 49), 3));
		comboBox_3.setBackground(SystemColor.control);
		comboBox_3.setBounds(332, 392, 272, 34);
		comboBox_3.setSelectedItem(" ");
		frmAddNotAvailbleTime.getContentPane().add(comboBox_3);
		
		spi4 = new JTextField();
		spi4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spi4.setBackground(SystemColor.control);
		spi4.setBounds(816, 464, 144, 34);
		frmAddNotAvailbleTime.getContentPane().add(spi4);
		spi4.setColumns(10);
		
		 btnClear = new JButton("Save Changes");
		 btnClear.setBounds(305, 603, 138, 47);
		 frmAddNotAvailbleTime.getContentPane().add(btnClear);
		 btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				// Empty field validation 			
				if(spi4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnClear, "The Values are Empty.. Please Fill the Field");
				}
				else {
					
				try {
					Connection con = DBConnect.connect();
					
					String query="Update timeAlloLecture set LecName='"+comboBox_3.getSelectedItem().toString()+"',subGroup='"+comboBox_2.getSelectedItem().toString()+"',sessionID='"+spi3.getText().toString()+"',Day='"+comboBox_1.getSelectedItem().toString()+"',Duration='"+spi4.getText().toString()+"' where ID='"+textField_10.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated sucessfully");
					pst.close();
					
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}}
		});
		 btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnClear.setForeground(new Color(21, 25, 28));
		 btnClear.setBackground(Color.ORANGE);
		 
		 JButton btnSave = new JButton("Delete");
		 btnSave.setBounds(494, 603, 138, 47);
		 frmAddNotAvailbleTime.getContentPane().add(btnSave);
		 btnSave.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		try {
		 			Connection con = DBConnect.connect();
		 			String query="Delete from timeAlloLecture where ID ='"+textField_10.getText()+"'";
		 			PreparedStatement pst=con.prepareStatement(query);
		 			pst.execute();
		 			
		 			JOptionPane.showMessageDialog(null, "Data Deleted sucessfully");
		 			pst.close();
		 			
		 			}
		 			catch(Exception e) {
		 				e.printStackTrace();
		 				
		 			}

		 	
		 	}
		 });
		 btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnSave.setForeground(new Color(21, 25, 28));
		 btnSave.setBackground(Color.RED);
		 
		 JButton btnClear_1 = new JButton("Refresh");
		 btnClear_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					spi4.setText(null);
				}
			});
		 btnClear_1.setBounds(687, 601, 156, 47);
		 frmAddNotAvailbleTime.getContentPane().add(btnClear_1);
		 btnClear_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		 btnClear_1.setForeground(new Color(21, 25, 28));
		 btnClear_1.setBackground(new Color(0, 128, 0));
		 
		 spi3 = new JTextField();
		 spi3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 spi3.setBackground(SystemColor.control);
		 spi3.setBounds(810, 326, 274, 34);
		 frmAddNotAvailbleTime.getContentPane().add(spi3);
		 spi3.setColumns(10);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(Color.LIGHT_GRAY);
		 panel.setBounds(0, 0, 1239, 90);
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
		 
		 JPanel panel_3 = new JPanel();
		 panel_3.setBounds(148, 90, 1091, 47);
		 frmAddNotAvailbleTime.getContentPane().add(panel_3);
		 
		 JLabel lblNewLabel_1 = new JLabel("Manage Session and Not Available Times Allocations");
		 lblNewLabel_1.setForeground(Color.BLUE);
		 lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		 panel_3.add(lblNewLabel_1);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setBackground(new Color(0, 0, 128));
		 panel_1.setBounds(0, 86, 146, 588);
		 frmAddNotAvailbleTime.getContentPane().add(panel_1);
		 
		 JButton btnNewButton_3 = new JButton("Back");
		 btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Session_and_Not_Available_Times_Allocations MWD = new Session_and_Not_Available_Times_Allocations();
					try {
						Session_and_Not_Available_Times_Allocations.main(null);
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
		 btnNewButton_3.setBounds(0, 513, 144, 47);
		 panel_1.add(btnNewButton_3);
		 
		 JPanel panel_2 = new JPanel();
		 panel_2.setBackground(Color.LIGHT_GRAY);
		 panel_2.setBounds(0, 674, 1239, 52);
		 frmAddNotAvailbleTime.getContentPane().add(panel_2);
		 
		 JLabel lblDay = new JLabel("Day");
		 lblDay.setForeground(Color.BLACK);
		 lblDay.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		 lblDay.setBounds(978, 397, 79, 25);
		 frmAddNotAvailbleTime.getContentPane().add(lblDay);
		 
		 JLabel lblDuration = new JLabel("Time Duration");
		 lblDuration.setForeground(Color.BLACK);
		 lblDuration.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		 lblDuration.setBounds(976, 465, 151, 25);
		 frmAddNotAvailbleTime.getContentPane().add(lblDuration);
		 

		
		
		fillComboBox2();
		fillComboBox3();
	    
	}
}