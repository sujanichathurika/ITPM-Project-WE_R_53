package Main;

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

import Member_1.Add_Sessions;
import Member_1.Reg_New_Std_Upd_Dele;
import Member_1.Tag_Registration;
import Member_2.Lecturer;
import Member_2.Session;
import Member_2.Subject;
import Member_3.AddWorkDaysHours;
import Member_3.Add_Locations;
import Member_3.Session_and_Not_Available_Times_Allocations;
import Member_4.AddSessionRooms;
import Member_4.Location;
import Member_4.Statistic;

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
		company_icon.setBackground(Color.LIGHT_GRAY);
		company_icon.setForeground(Color.LIGHT_GRAY);
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
		LecR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Lecturer AWh = new Lecturer();
				try {
					Lecturer.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});
		
		
		LecR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		LecR.setBackground(new Color(240, 230, 140));
		LecR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		LecR.setBounds(95, 157, 240, 64);
		frame.getContentPane().add(LecR);
		
		JButton SubR = new JButton("Subject Registration");
		SubR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

			Subject AWh = new Subject();
				try {
				Subject.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});
		SubR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		SubR.setBackground(new Color(255, 222, 173));
		SubR.setBounds(409, 157, 240, 64);
		frame.getContentPane().add(SubR);
		
		JButton StdR = new JButton("Student Registration");
		StdR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Reg_New_Std_Upd_Dele AWh = new Reg_New_Std_Upd_Dele();
				try {
					Reg_New_Std_Upd_Dele.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});

		StdR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		StdR.setBackground(new Color(255, 127, 80));
		StdR.setBounds(721, 157, 240, 64);
		frame.getContentPane().add(StdR);
		
		JButton TagR = new JButton("Tag Registration");
		TagR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Tag_Registration AWh = new Tag_Registration();
					try {
						Tag_Registration.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.setVisible(false);			
				}
			});
	

		TagR.setFont(new Font("Sylfaen", Font.BOLD, 22));
		TagR.setBackground(new Color(255, 182, 193));
		TagR.setBounds(95, 265, 240, 64);
		frame.getContentPane().add(TagR);
		
		JButton LocR = new JButton("Location Registration");
		LocR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Location AWh = new Location();
				try {
					Location.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});
		LocR.setFont(new Font("Sylfaen", Font.BOLD, 20));
		LocR.setBackground(new Color(233, 150, 122));
		LocR.setBounds(409, 265, 240, 64);
		frame.getContentPane().add(LocR);
		
		JButton worDays = new JButton("Working days & \r\nHours");
		worDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWorkDaysHours MWD = new AddWorkDaysHours();
				try {
					AddWorkDaysHours.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		worDays.setFont(new Font("Sylfaen", Font.BOLD, 18));
		worDays.setBackground(new Color(154, 205, 50));
		worDays.setBounds(721, 266, 240, 64);
		frame.getContentPane().add(worDays);
		
		JButton staticMan = new JButton("Static Management ");
		staticMan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistic AWh = new Statistic();
				try {
					Statistic.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});
			
		staticMan.setFont(new Font("Sylfaen", Font.BOLD, 22));
		staticMan.setBackground(new Color(30, 144, 255));
		staticMan.setBounds(95, 366, 240, 64);
		frame.getContentPane().add(staticMan);
		
		JButton manageSess = new JButton("Manage Sessions");
		manageSess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Sessions AWh = new Add_Sessions();
				try {
					Add_Sessions.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});
		manageSess.setFont(new Font("Sylfaen", Font.BOLD, 22));
		manageSess.setBackground(new Color(175, 238, 238));
		manageSess.setBounds(409, 366, 240, 64);
		frame.getContentPane().add(manageSess);
		
		JButton TimeTable = new JButton("Generate Time Table");
		TimeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		TimeTable.setFont(new Font("Sylfaen", Font.BOLD, 20));
		TimeTable.setBackground(new Color(216, 191, 216));
		TimeTable.setBounds(95, 556, 240, 64);
		frame.getContentPane().add(TimeTable);
		
		JButton managerooms = new JButton("Manage Rooms");
		managerooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddSessionRooms AWh = new AddSessionRooms();
				try {
					AddSessionRooms.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});

		managerooms.setFont(new Font("Sylfaen", Font.BOLD, 22));
		managerooms.setBackground(new Color(224, 255, 255));
		managerooms.setBounds(95, 464, 240, 64);
		frame.getContentPane().add(managerooms);
		
		JButton addsession = new JButton("Add Session");
		addsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Session MWD = new Session();
				try {
				Session.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		addsession.setFont(new Font("Sylfaen", Font.BOLD, 22));
		addsession.setBackground(new Color(255, 165, 0));
		addsession.setBounds(409, 464, 240, 64);
		frame.getContentPane().add(addsession);
		
		JButton btnSessionNotavailabe = new JButton("Session & \r\nTime Allocation");
		btnSessionNotavailabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Session_and_Not_Available_Times_Allocations MWD = new Session_and_Not_Available_Times_Allocations();
				try {
					Session_and_Not_Available_Times_Allocations.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		
		btnSessionNotavailabe.setFont(new Font("Sylfaen", Font.BOLD, 16));
		btnSessionNotavailabe.setBackground(new Color(222, 184, 135));
		btnSessionNotavailabe.setBounds(721, 464, 240, 64);
		frame.getContentPane().add(btnSessionNotavailabe);
		
		JButton btnNewButton = new JButton("Add Location");
		btnNewButton.setBackground(new Color(60, 179, 113));
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_Locations AWh = new Add_Locations();
				try {
					Add_Locations.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});
		btnNewButton.setBounds(721, 372, 240, 53);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(200, 200, 1091, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
