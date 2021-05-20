package Member_3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

import dbConnect.DBConnect;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManageWorkingDays {

	private JFrame frmManageWork;
	private JTable table;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JCheckBox chckbxNewCheckBox_6;
//	private JSpinner spi1;
//	private JSpinner spi2;
//	private JSpinner spi3;
	
	private JTextField textField;
	private JTextField spi1;
	private JTextField spi2;
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
					
					ManageWorkingDays window = new ManageWorkingDays();
					window.frmManageWork.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageWorkingDays() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageWork = new JFrame();
		
		frmManageWork.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					
					String query="select * from main ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
				
		frmManageWork.getContentPane().setBackground(new Color(102, 204, 255));
		frmManageWork.setBackground(Color.YELLOW);
		frmManageWork.setResizable(false);
		frmManageWork.setTitle("Manage Working Days And Hours");
		frmManageWork.setBounds(350, 90, 1237, 751);
		frmManageWork.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageWork.getContentPane().setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 82, 146, 608);
		panel_1.setBackground(new Color(0, 0, 128));
		frmManageWork.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		Image imgs = new ImageIcon(this.getClass().getResource("/my.jpg")).getImage();


		
		JLabel lblNewLabel_1 = new JLabel("Manage Working Days And Hours");
		lblNewLabel_1.setBackground(new Color(128, 0, 128));
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setBounds(169, 93, 1057, 48);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		frmManageWork.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No. of Working Days");
		lblNewLabel_2.setBounds(704, 353, 252, 25);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmManageWork.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		
		JLabel lblNewLabel_2_1 = new JLabel("Working Days");
		lblNewLabel_2_1.setBounds(182, 434, 252, 25);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmManageWork.getContentPane().add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 128));
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Working Time Per Day");
		lblNewLabel_2_1_2.setBounds(182, 572, 281, 25);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmManageWork.getContentPane().add(lblNewLabel_2_1_2);
		lblNewLabel_2_1_2.setForeground(new Color(0, 0, 128));
		
		chckbxNewCheckBox = new JCheckBox("Monday");
		chckbxNewCheckBox.setBackground(new Color(248, 248, 255));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox.setBounds(446, 435, 125, 25);
		frmManageWork.getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		
		chckbxNewCheckBox_1 = new JCheckBox("Tuesday");
		chckbxNewCheckBox_1.setBackground(new Color(248, 248, 255));
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox_1.setBounds(659, 435, 125, 25);
		frmManageWork.getContentPane().add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setForeground(new Color(0, 0, 0));
		
		chckbxNewCheckBox_2 = new JCheckBox("Wednesday");
		chckbxNewCheckBox_2.setBackground(new Color(248, 248, 255));
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox_2.setBounds(840, 435, 135, 25);
		frmManageWork.getContentPane().add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.setForeground(new Color(0, 0, 0));
		
		chckbxNewCheckBox_3 = new JCheckBox("Thursday");
		chckbxNewCheckBox_3.setBackground(new Color(248, 248, 255));
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox_3.setBounds(1017, 435, 125, 25);
		frmManageWork.getContentPane().add(chckbxNewCheckBox_3);
		chckbxNewCheckBox_3.setForeground(new Color(0, 0, 0));
		
		chckbxNewCheckBox_4 = new JCheckBox("Friday");
		chckbxNewCheckBox_4.setBackground(new Color(248, 248, 255));
		chckbxNewCheckBox_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox_4.setBounds(446, 490, 125, 25);
		frmManageWork.getContentPane().add(chckbxNewCheckBox_4);
		chckbxNewCheckBox_4.setForeground(new Color(0, 0, 0));
		
		chckbxNewCheckBox_5 = new JCheckBox("Saturday");
		chckbxNewCheckBox_5.setBackground(new Color(248, 248, 255));
		chckbxNewCheckBox_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox_5.setBounds(659, 490, 125, 25);
		frmManageWork.getContentPane().add(chckbxNewCheckBox_5);
		chckbxNewCheckBox_5.setForeground(new Color(0, 0, 0));
		
		chckbxNewCheckBox_6 = new JCheckBox("Sunday");
		chckbxNewCheckBox_6.setBackground(new Color(248, 248, 255));
		chckbxNewCheckBox_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		chckbxNewCheckBox_6.setBounds(840, 490, 125, 25);
		frmManageWork.getContentPane().add(chckbxNewCheckBox_6);
		chckbxNewCheckBox_6.setForeground(new Color(0, 0, 0));
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblHours.setBounds(574, 579, 96, 25);
		frmManageWork.getContentPane().add(lblHours);
		lblHours.setForeground(new Color(0, 0, 0));
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblMinutes.setBounds(840, 579, 96, 25);
		frmManageWork.getContentPane().add(lblMinutes);
		lblMinutes.setForeground(new Color(0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 169, 1057, 133);
		frmManageWork.getContentPane().add(scrollPane);
		
//		spi1 = new JSpinner();
//		spi1.setBounds(539, 419, 170, 31);
//		frmManageWork.getContentPane().add(spi1);
//		
//		spi2 = new JSpinner();
//		spi2.setBounds(539, 649, 159, 31);
//		frmManageWork.getContentPane().add(spi2);
//		
//		spi3 = new JSpinner();
//		spi3.setBounds(852, 653, 148, 25);
//		frmManageWork.getContentPane().add(spi3);
		
		textField = new JTextField();
		textField.setBounds(446, 350, 135, 37);
		frmManageWork.getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int selectedRow=table.getSelectedRow();
				
				textField.setText(table.getValueAt(selectedRow, 0).toString());
				
				
				spi1.setText(table.getValueAt(selectedRow, 1).toString());
				spi2.setText(table.getValueAt(selectedRow, 9).toString());
				spi3.setText(table.getValueAt(selectedRow, 10).toString());
				
				
				String checkdaymon=table.getValueAt(selectedRow, 2).toString();
				String checkdaytues=table.getValueAt(selectedRow, 3).toString();
				String checkdayWed=table.getValueAt(selectedRow, 4).toString();
				String checkdayThur=table.getValueAt(selectedRow, 5).toString();
				String checkdayFri=table.getValueAt(selectedRow, 6).toString();
				String checkdaySat=table.getValueAt(selectedRow, 7).toString();	
				String checkdaySun=table.getValueAt(selectedRow, 8).toString();
				
				if(checkdaymon.equals("Monday")) {
					chckbxNewCheckBox.setSelected(true);
				}
				else{
					chckbxNewCheckBox.setSelected(false);
				}
				
				
				if(checkdaytues.equals("Tuesday")) {
					chckbxNewCheckBox_1.setSelected(true);
				}
				else{
					chckbxNewCheckBox_1.setSelected(false);
				}
				
				if(checkdayWed.equals("Wednesday")) {
					chckbxNewCheckBox_2.setSelected(true);
				}
				else{
					chckbxNewCheckBox_2.setSelected(false);
				}
				
				if(checkdayThur.equals("Thursday")) {
					chckbxNewCheckBox_3.setSelected(true);
				}
				else{
					chckbxNewCheckBox_3.setSelected(false);
				}
				
				
				if(checkdayFri.equals("Friday")) {
					chckbxNewCheckBox_4.setSelected(true);
				}
				else{
					chckbxNewCheckBox_4.setSelected(false);
				}
				
				if(checkdaySat.equals("Saturday")) {
					chckbxNewCheckBox_5.setSelected(true);
				}
				else{
					chckbxNewCheckBox_5.setSelected(false);
				}
				
				if(checkdaySun.equals("Sunday")) {
					chckbxNewCheckBox_6.setSelected(true);
				}
				else{
					chckbxNewCheckBox_6.setSelected(false);
				}
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblId.setBounds(182, 353, 252, 25);
		frmManageWork.getContentPane().add(lblId);
		lblId.setForeground(new Color(0, 0, 128));
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(419, 641, 140, 42);
		frmManageWork.getContentPane().add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DBConnect.connect();
					
					String query="select * from main ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setBackground(new Color(51, 102, 0));
		
		JButton btnClear = new JButton("Update");
		btnClear.setBounds(632, 641, 140, 42);
		frmManageWork.getContentPane().add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String monday="-";
				String tuesday="-";
				String wednesday="-";
				String thursday="-";
				String friday="-";
				String saturday="-";
				String sunday="-";
				
				if(chckbxNewCheckBox.isSelected()) {
					monday="Monday";
				}
				if(chckbxNewCheckBox_1.isSelected()) {
					tuesday="Tuesday";
				}
				if(chckbxNewCheckBox_2.isSelected()) {
					wednesday="Wednesday";
				}
				if(chckbxNewCheckBox_3.isSelected()) {
					thursday="Thursday";
				}
				if(chckbxNewCheckBox_4.isSelected()) {
					friday="Friday";
				}
				if(chckbxNewCheckBox_5.isSelected()) {
					saturday="Saturday";
				}
				if(chckbxNewCheckBox_6.isSelected()) {
					sunday="Sunday";
				}
				
				try {
					Connection con = DBConnect.connect();
					
					String query="Update main set noOfWorkingDays='"+spi1.getText().toString()+"',monday='"+monday+"',tuesday='"+tuesday+"',wednesday='"+wednesday+"',thursday='"+thursday+"',friday='"+friday+"',saturday='"+saturday+"',sunday='"+sunday+"',hours='"+spi2.getText().toString()+"',minutes='"+spi3.getText().toString()+"' where mid='"+textField.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated sucessfully");
					pst.close();
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setForeground(Color.WHITE);
		btnClear.setBackground(new Color(218, 165, 32));
		
		JButton btnSave = new JButton("Delete");
		btnSave.setBounds(863, 641, 140, 42);
		frmManageWork.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection con = DBConnect.connect();
					String query="Delete from main where mid='"+textField.getText()+"'";
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
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(new Color(255, 0, 0));
		
		spi1 = new JTextField();
		spi1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(Character.isLetter(c)) {
					spi1.setEditable(false);								
					JOptionPane.showMessageDialog(btnSave, "Enter a Valid No of Working Days ");
				}
					else {
						spi1.setEditable(true);
					}	
			}
		});
		spi1.setBounds(1007, 350, 135, 37);
		frmManageWork.getContentPane().add(spi1);
		spi1.setColumns(10);
		
		spi2 = new JTextField();
		spi2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ev) {
				char c = ev.getKeyChar();
				if(Character.isLetter(c)) {
					spi2.setEditable(false);								
					JOptionPane.showMessageDialog(btnSave, "Enter Valid Working Time Per Day");
				}
					else {
						spi2.setEditable(true);
					}	
			}
		});
		spi2.setBounds(446, 570, 116, 34);
		frmManageWork.getContentPane().add(spi2);
		spi2.setColumns(10);
		
		spi3 = new JTextField();
		spi3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				if(Character.isLetter(c)) {
					spi2.setEditable(false);								
					JOptionPane.showMessageDialog(btnSave, "Enter Valid Working Time Per Day");
				}
					else {
						spi2.setEditable(true);
					}	
			}
		});
		spi3.setBounds(704, 570, 116, 35);
		frmManageWork.getContentPane().add(spi3);
		spi3.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1226, 90);
		frmManageWork.getContentPane().add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		panel.add(lblNewLabel_3);
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		
		
		JLabel lblNewLabel = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBackground(Color.BLUE);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 691, 1231, 25);
		frmManageWork.getContentPane().add(panel_2);
		Image imgss = new ImageIcon(this.getClass().getResource("/my.jpg")).getImage();
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddWorkDaysHours MWD = new AddWorkDaysHours();
				try {
					AddWorkDaysHours.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmManageWork.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 553, 130, 42);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(204, 102, 255));
		
		
		
	 
	    
	}
}