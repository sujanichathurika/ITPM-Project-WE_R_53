package Member_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

import dbConnect.DBConnect;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Subject {

	private JFrame frame;
	private JTextField sname;
	private JComboBox yr;
	private JComboBox sem;
	private JComboBox lab;
	private JComboBox lec;
	private JComboBox tute;
	private JComboBox ev;
	private JTextField code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subject window = new Subject();
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
	public Subject() {
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
				
			}
		});
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1243, 694);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			String subjectName= sname.getText();
			String subjectCode= code.getText();
			
			String year= yr.getSelectedItem().toString();
			String semester= sem.getSelectedItem().toString();
			
			String lecHrs= lec.getSelectedItem().toString();
			String tuteHrs= tute.getSelectedItem().toString();
			
			String labHrs= lab.getSelectedItem().toString();
			String evHrs= ev.getSelectedItem().toString();
			
			
			
			
			
			 try {
				 Connection con = DBConnect.connect();

                    String query = "INSERT INTO subjects values(null, '" + year + "','" + semester + "','" + subjectName + "', '" + subjectCode + "','" + lecHrs + "','" + tuteHrs + "','" + labHrs + "', '" + evHrs + "')";

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Your Data is added to the database successfully");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                	
                }
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(583, 545, 150, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(793, 545, 150, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Add Subject");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(531, 132, 185, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Subject Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(34, 237, 125, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Offered Year");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(34, 297, 125, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		sname = new JTextField();
		sname.setBounds(189, 247, 410, 26);
		frame.getContentPane().add(sname);
		sname.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Lecture Hrs");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType.setBounds(34, 358, 125, 39);
		frame.getContentPane().add(lblRoomType);
		
		lec = new JComboBox();
		lec.setBounds(189, 367, 410, 26);
		lec.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(lec);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Manage_Subject itm = new Manage_Subject();
				try {
					Manage_Subject.main(null);
			} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnNewButton_2.setVisible(false);
}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(351, 545, 150, 52);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel company_name = new JLabel("ABC INSTITUTE TIME TABLE MANAGEMNT SYSTEM");
		company_name.setHorizontalAlignment(SwingConstants.CENTER);
		company_name.setForeground(new Color(0, 0, 128));
		company_name.setFont(new Font("Sylfaen", Font.BOLD, 28));
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setBounds(10, 10, 1206, 93);
		frame.getContentPane().add(company_name);
		
		JButton company_icon = new JButton("");
		company_icon.setForeground(Color.LIGHT_GRAY);
		company_icon.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 43));
		company_icon.setBackground(Color.LIGHT_GRAY);
		company_icon.setBounds(103, 26, 77, 64);
		frame.getContentPane().add(company_icon);
		Image img = new ImageIcon(this.getClass().getResource("/ABC_com_icon.png")).getImage();
		company_icon.setIcon(new ImageIcon(img));
		
		JSeparator separator_main = new JSeparator();
		separator_main.setForeground(Color.BLACK);
		separator_main.setBackground(Color.BLACK);
		separator_main.setBounds(0, 105, 1226, 2);
		frame.getContentPane().add(separator_main);
		
		JLabel lblAvailableDays = new JLabel("Lab Hrs");
		lblAvailableDays.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvailableDays.setBounds(34, 418, 125, 39);
		frame.getContentPane().add(lblAvailableDays);
		
		 lab = new JComboBox();
		lab.setBounds(189, 427, 410, 26);
		lab.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(lab);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(786, 247, 410, 26);
		frame.getContentPane().add(code);
		
		 tute = new JComboBox();
		tute.setBounds(786, 367, 410, 26);
		tute.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(tute);
		
		 ev = new JComboBox();
		ev.setBounds(786, 427, 410, 26);
		ev.setModel(new DefaultComboBoxModel(new String[] {"30 min","1 hrs","2 hrs"}));
		frame.getContentPane().add(ev);
		
		JLabel lblRoomType_2_1 = new JLabel("Evaluation Hrs");
		lblRoomType_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomType_2_1.setBounds(631, 418, 125, 39);
		frame.getContentPane().add(lblRoomType_2_1);
		
		JLabel lblBuilding = new JLabel("Tute Hrs");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBuilding.setBounds(631, 358, 125, 39);
		frame.getContentPane().add(lblBuilding);
		
		JLabel lblNewLabel_2_1 = new JLabel("Offered Semester");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(631, 297, 125, 39);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Subject Code");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(631, 237, 125, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		 yr = new JComboBox();
		yr.setBounds(189, 309, 410, 26);
		yr.setModel(new DefaultComboBoxModel(new String[] {"1","2","3","4"}));
		frame.getContentPane().add(yr);
		
		 sem = new JComboBox();
		sem.setBounds(786, 309, 410, 26);
		sem.setModel(new DefaultComboBoxModel(new String[] {"1","2"}));
		frame.getContentPane().add(sem);
	}
}
