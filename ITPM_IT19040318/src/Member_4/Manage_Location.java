package Member_4;

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

public class Manage_Location {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox Rtag;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Location window = new Manage_Location();
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
	public Manage_Location() {
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
					
					String query="select * from location ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 1107, 784);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Location");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(402, 78, 269, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBackground(new Color(255, 153, 51));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
if(textField_1.getText().equals("")||textField_2.getText().equals("")|| Rtag.getSelectedItem().equals("")||textField_4.getText().equals("")) {
					
					JOptionPane.showMessageDialog(null, "Please Enter Details");
				}else {
				try {
					Connection con = DBConnect.connect();					
					String query="Update location set buildingName='"+textField_1.getText()+"',roomName='"+textField_2.getText()+"',type='"+Rtag.getSelectedItem()+"',capacity='"+textField_4.getText()+"' where locationID='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					
				}
				catch(Exception ea) {
					ea.printStackTrace();
				}
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(94, 368, 256, 48);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from location where locationID='"+textField.getText()+"'";
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
		btnDelete.setBounds(360, 368, 256, 48);
		frame.getContentPane().add(btnDelete);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(123, 104, 238));
		btnClear.setForeground(Color.BLACK);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				textField_1.setText(null);
				textField_2.setText(null);
				Rtag.setSelectedItem(null);
				textField_4.setText(null);
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnClear.setBounds(646, 368, 256, 48);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(38, 467, 256, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Building");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(493, 467, 256, 48);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Room");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(38, 575, 256, 48);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Room Type");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_3.setBounds(493, 589, 256, 48);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Capacity");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_4.setBounds(38, 678, 256, 48);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setBounds(148, 467, 256, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(646, 467, 302, 40);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(148, 586, 256, 40);
		frame.getContentPane().add(textField_2);
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(148, 689, 256, 40);
		frame.getContentPane().add(textField_4);
		
		Rtag = new JComboBox();
		Rtag.setBounds(659, 589, 289, 33);
		Rtag.setModel(new DefaultComboBoxModel(new String[] {"Lecture Hall", "Laboratory"}));
		frame.getContentPane().add(Rtag);
	 
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 144, 959, 214);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
			    textField.setText(table.getValueAt(selectedRow, 0).toString());
			    textField_1.setText(table.getValueAt(selectedRow, 1).toString());
			    textField_2.setText(table.getValueAt(selectedRow, 2).toString());
			    textField_4.setText(table.getValueAt(selectedRow, 4).toString());
			    
			    String comboLevel = table.getValueAt(selectedRow, 3).toString();
				
			    
			    for(int i=0; i<Rtag.getItemCount();i++) {
					if(Rtag.getItemAt(i).toString().equalsIgnoreCase(comboLevel)) {
						Rtag.setSelectedIndex(i);
					}
				}
			               
										 
			}
		});
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(1088, 78, -1085, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(1096, 81, -1085, 12);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setForeground(Color.BLACK);
		separator_main.setBackground(Color.BLACK);
		separator_main.setBounds(0, 81, 1103, 12);
		frame.getContentPane().add(separator_main);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		btnNewButton_1.setBounds(850, 678, 110, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel company_name_1 = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name_1.setHorizontalAlignment(SwingConstants.CENTER);
		company_name_1.setForeground(new Color(0, 0, 128));
		company_name_1.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name_1.setBackground(Color.LIGHT_GRAY);
		company_name_1.setBounds(0, 0, 1077, 93);
		frame.getContentPane().add(company_name_1);
			
	}
}
