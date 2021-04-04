package IT19040318_HOME;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class Home_Frame  {

	 JFrame frame; //change the private 

	private JButton SubR;
	private JButton TagR;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Frame window = new Home_Frame();
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
	public Home_Frame() {
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
		company_icon.setBackground(Color.WHITE);
		company_icon.setForeground(Color.WHITE);
		company_icon.setFont(new Font("Yu Gothic UI Light", Font.BOLD | Font.ITALIC, 43));
		company_icon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		company_icon.setBounds(95, 13, 77, 64);
		frame.getContentPane().add(company_icon);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setBackground(Color.BLACK);
		separator_main.setForeground(Color.BLACK);
		separator_main.setBounds(0, 90, 1073, 3);
		frame.getContentPane().add(separator_main);
		
		JButton LecR = new JButton("Lecture Registration");
		LecR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		LecR.setBackground(new Color(240, 230, 140));
		LecR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LecR.setBounds(95, 180, 240, 64);
		frame.getContentPane().add(LecR);
		
		JButton SubR = new JButton("Subject Registration");
		SubR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SubR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		SubR.setBackground(new Color(255, 222, 173));
		SubR.setBounds(409, 180, 240, 64);
		frame.getContentPane().add(SubR);
		
		JButton StdR = new JButton("Student Registration");
		StdR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//direct to student registration Frame
				
				//create Object (interface name,object name,interface name ) and set the initial frame name and remove the public 
				Reg_New_Std_Upd_Dele Reg_New_Std_Upd_Dele_Move  = new Reg_New_Std_Upd_Dele() ;
				Reg_New_Std_Upd_Dele_Move.frame.setVisible(true); //object name, and initial class frame name
				frame.dispose();
			}
		});
		StdR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		StdR.setBackground(new Color(255, 127, 80));
		StdR.setBounds(721, 180, 240, 64);
		frame.getContentPane().add(StdR);
		
		JButton TagR = new JButton("Tag Registration");
		TagR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//direct to tag registration Frame
				
				//create Object (interface name,object name,interface name ) and set the initial frame name and remove the public 
				Tag_Registration Tag_Registration_Move = new Tag_Registration();
				Tag_Registration_Move.frame.setVisible(true);
				frame.dispose();		
				
			}
		});
		TagR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		TagR.setBackground(new Color(255, 182, 193));
		TagR.setBounds(95, 305, 240, 64);
		frame.getContentPane().add(TagR);
		
		JButton LocR = new JButton("Location Registration");
		LocR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LocR.setFont(new Font("Sylfaen", Font.BOLD, 20));
		LocR.setBackground(new Color(233, 150, 122));
		LocR.setBounds(409, 305, 240, 64);
		frame.getContentPane().add(LocR);
		
		JButton worDays = new JButton("Working days & \r\nHours");
		worDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		worDays.setFont(new Font("Sylfaen", Font.BOLD, 18));
		worDays.setBackground(new Color(154, 205, 50));
		worDays.setBounds(721, 305, 240, 64);
		frame.getContentPane().add(worDays);
		
		JButton staticMan = new JButton("Static Management ");
		staticMan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		staticMan.setFont(new Font("Sylfaen", Font.BOLD, 22));
		staticMan.setBackground(new Color(30, 144, 255));
		staticMan.setBounds(95, 426, 240, 64);
		frame.getContentPane().add(staticMan);
		
		JButton manageSess = new JButton("Manage Sessions");
		manageSess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		manageSess.setFont(new Font("Sylfaen", Font.BOLD, 22));
		manageSess.setBackground(new Color(175, 238, 238));
		manageSess.setBounds(409, 426, 240, 64);
		frame.getContentPane().add(manageSess);
		
		JButton TimeTable = new JButton("Generate Time Table");
		TimeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		TimeTable.setFont(new Font("Sylfaen", Font.BOLD, 20));
		TimeTable.setBackground(new Color(216, 191, 216));
		TimeTable.setBounds(721, 426, 240, 64);
		frame.getContentPane().add(TimeTable);
		frame.setBounds(200, 200, 1091, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
