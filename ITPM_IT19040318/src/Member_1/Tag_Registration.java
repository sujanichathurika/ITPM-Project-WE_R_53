package Member_1;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Main.Home_Frame;
import dbConnect.DBConnect;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JCheckBox;

public class Tag_Registration {

    JFrame frame; //remove the private because to direct to the frame from home 
	private JTextField type_TagN;
	private JButton Save;
	private JButton Updatebtn;
	private JButton Delebtn;
	DefaultTableModel model1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tag_Registration window = new Tag_Registration();
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
	public Tag_Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
				
				Home_Frame AWh = new Home_Frame();
				try {
					Home_Frame.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);			
			}
		});

		company_icon.setBounds(95, 13, 77, 64);
		frame.getContentPane().add(company_icon);
		
		JSeparator separator_main = new JSeparator();
		separator_main.setBackground(Color.BLACK);
		separator_main.setForeground(Color.BLACK);
		separator_main.setBounds(0, 90, 1073, 3);
		frame.getContentPane().add(separator_main);
		
		JLabel Tag_R = new JLabel("Tag Registration");
		Tag_R.setHorizontalAlignment(SwingConstants.CENTER);
		Tag_R.setFont(new Font("Sylfaen", Font.BOLD, 20));
		Tag_R.setBounds(430, 120, 237, 24);
		frame.getContentPane().add(Tag_R);
		
		JLabel Tag_Name = new JLabel("Tag Name");
		Tag_Name.setHorizontalAlignment(SwingConstants.CENTER);
		Tag_Name.setForeground(Color.BLACK);
		Tag_Name.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		Tag_Name.setBounds(282, 294, 150, 24);
		frame.getContentPane().add(Tag_Name);
		
		type_TagN = new JTextField();
		type_TagN.setBounds(506, 290, 190, 30);
		frame.getContentPane().add(type_TagN);
		type_TagN.setColumns(10);
		model1 = new DefaultTableModel();
		Object[] columNames = {"TagName"};//add table field names
		final Object[] row = new Object[1];
		model1.setColumnIdentifiers(columNames);
		
		//add
		
		JButton Save = new JButton("SAVE");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(type_TagN.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame,"please fill the feild!"); //if the field is empty, pop up a dialog message
				}
				else 
				{
					
					
					String value_tagname =type_TagN.getText();
					
					try {
						 Connection con = DBConnect.connect();

		                    String query = "INSERT INTO tag VALUES(null, '" + value_tagname + "')";

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
				
			}
		});
		Save.setForeground(Color.BLACK);
		Save.setFont(new Font("Sylfaen", Font.BOLD, 16));
		Save.setBackground(Color.RED);
		Save.setBounds(626, 419, 150, 56);
		frame.getContentPane().add(Save);
		
		JButton View = new JButton("VIEW");
		View.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_tag_Registration Manage_tag_Registration= new Manage_tag_Registration();
				try {
					Manage_tag_Registration.main(null);
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
		View.setBounds(388, 419, 135, 58);
		frame.getContentPane().add(View);
		frame.setBounds(200, 200, 1091, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/*private static void addPopup(Component component, final JPopupMenu popup) {
	}*/
}
