package Member_1;

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

public class View_Consective {

	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Consective window = new View_Consective();
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
	public View_Consective() {
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
					
					String query="select * from consecutiveSession ";
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
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from consecutiveSession where ID='"+textField.getText()+"'";
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
		btnDelete.setBounds(709, 470, 256, 48);
		frame.getContentPane().add(btnDelete);
		
		textField = new JTextField();
		textField.setBounds(123, 477, 256, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		

	 
		
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
