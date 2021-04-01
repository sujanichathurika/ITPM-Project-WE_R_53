package IT19040318_HOME;

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
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Reg_New_Std_Upd_Dele {

	private JFrame frame;

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
		company_name.setBackground(Color.LIGHT_GRAY);
		company_name.setForeground(Color.BLUE);
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
		
		JLabel R_new_std = new JLabel("Register a New Student");
		R_new_std.setFont(new Font("Sylfaen", Font.BOLD, 20));
		R_new_std.setHorizontalAlignment(SwingConstants.CENTER);
		R_new_std.setBounds(12, 106, 237, 24);
		frame.getContentPane().add(R_new_std);
		
		JLabel Year_Sem = new JLabel("Academic Year & Semester");
		Year_Sem.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		Year_Sem.setHorizontalAlignment(SwingConstants.CENTER);
		Year_Sem.setBounds(22, 143, 199, 24);
 		frame.getContentPane().add(Year_Sem);
		
		JLabel std_program = new JLabel("Programm");
		std_program.setHorizontalAlignment(SwingConstants.CENTER);
		std_program.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		std_program.setBounds(29, 205, 192, 24);
		frame.getContentPane().add(std_program);
		
		JLabel Grp_num = new JLabel("Group Number");
		Grp_num.setHorizontalAlignment(SwingConstants.CENTER);
		Grp_num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		Grp_num.setBounds(42, 271, 179, 24);
		frame.getContentPane().add(Grp_num);
		
		JLabel Gene_Grp_Num = new JLabel("Generate Group ID");
		Gene_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Gene_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		Gene_Grp_Num.setBounds(42, 338, 168, 24);
		frame.getContentPane().add(Gene_Grp_Num);
		
		JButton G_ID_gen = new JButton("Generate");
		G_ID_gen.setForeground(Color.BLACK);
		G_ID_gen.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		G_ID_gen.setBounds(29, 400, 93, 25);
		frame.getContentPane().add(G_ID_gen);
		
		JButton G_ID_remove = new JButton("Remove");
		G_ID_remove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		G_ID_remove.setBounds(134, 400, 97, 25);
		frame.getContentPane().add(G_ID_remove);
		
		JLabel Sub_Grp_Num = new JLabel("Sub-Group Number");
		Sub_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Sub_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		Sub_Grp_Num.setBounds(39, 445, 182, 24);
		frame.getContentPane().add(Sub_Grp_Num);
		
		JButton Sub_ID_gen = new JButton("Generate");
		Sub_ID_gen.setForeground(Color.BLACK);
		Sub_ID_gen.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		Sub_ID_gen.setBounds(29, 567, 97, 25);
		frame.getContentPane().add(Sub_ID_gen);
		
		JButton Sub_ID_remove = new JButton("Remove");
		Sub_ID_remove.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		Sub_ID_remove.setBounds(138, 567, 97, 25);
		frame.getContentPane().add(Sub_ID_remove);
		
		JLabel Gene_Sub_Grp_Num = new JLabel("Generate Sub-Group ID");
		Gene_Sub_Grp_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Gene_Sub_Grp_Num.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		Gene_Sub_Grp_Num.setBounds(42, 508, 182, 24);
		frame.getContentPane().add(Gene_Sub_Grp_Num);
		
		JButton Save = new JButton("SAVE");
		Save.setBackground(Color.WHITE);
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Student Registered Successfully!"); //add successful  message when data save to the table and DB
			}
		});
		Save.setForeground(new Color(0, 0, 255));
		Save.setFont(new Font("Sylfaen", Font.BOLD, 16));
		Save.setBounds(35, 621, 87, 31);
		frame.getContentPane().add(Save);
		
		JButton Clear = new JButton("CLEAR");
		Clear.setBackground(Color.WHITE);
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Clear.setForeground(new Color(0, 0, 255));
		Clear.setFont(new Font("Sylfaen", Font.BOLD, 16));
		Clear.setBounds(144, 621, 87, 31);
		frame.getContentPane().add(Clear);
		
		JComboBox Select_Yer_Sem = new JComboBox();
		Select_Yer_Sem.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		Select_Yer_Sem.setForeground(Color.BLACK);
		Select_Yer_Sem.setSelectedIndex(0);
		Select_Yer_Sem.setBounds(32, 170, 192, 25);
		frame.getContentPane().add(Select_Yer_Sem);
		
		JComboBox Select_prog = new JComboBox();
		Select_prog.setSelectedIndex(8);
		Select_prog.setForeground(Color.BLACK);
		Select_prog.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		Select_prog.setBounds(32, 233, 192, 25);
		frame.getContentPane().add(Select_prog);
		
		JSeparator separator_hori = new JSeparator();
		separator_hori.setBackground(Color.BLACK);
		separator_hori.setForeground(Color.BLACK);
		separator_hori.setBounds(0, 137, 276, 555);
		frame.getContentPane().add(separator_hori);
		
		JSeparator separator_verti = new JSeparator();
		separator_verti.setForeground(Color.BLACK);
		separator_verti.setBackground(Color.BLACK);
		separator_verti.setOrientation(SwingConstants.VERTICAL);
		separator_verti.setBounds(275, 90, 2, 600);
		frame.getContentPane().add(separator_verti);
		frame.setBounds(200, 200, 1091, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
