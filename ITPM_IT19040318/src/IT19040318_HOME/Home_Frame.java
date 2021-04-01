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

public class Home_Frame {

	private JFrame frame;

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
		frame.setBounds(200, 200, 1091, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
