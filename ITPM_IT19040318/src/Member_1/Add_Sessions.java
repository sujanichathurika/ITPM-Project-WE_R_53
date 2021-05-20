package Member_1;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Main.Home_Frame;
import dbConnect.DBConnect;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Checkbox;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.sql.Statement;

public class Add_Sessions {

	JFrame frame;
	private JTable table;
	protected Connection con;
	private JTextField a;
	private JTextField b;
	private JTextField c;
	private JTextField d;
	private JTextField e;
	private JTextField f;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Sessions window = new Add_Sessions();
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
	public Add_Sessions() {
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
					
					String query="select  s.stGroupID, s.academicYearSemester , s.programme , s.groupID , l.lectureName, l.avatime from studentGroups s ,lecturers l "; //display data from DB
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
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
		
		JLabel managesessions = new JLabel("Manage Sessions");
		managesessions.setHorizontalAlignment(SwingConstants.CENTER);
		managesessions.setFont(new Font("Sylfaen", Font.BOLD, 20));
		managesessions.setBounds(207, 105, 639, 40);
		frame.getContentPane().add(managesessions);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				

			}
		});
		
		scrollPane.setBounds(95, 230, 873, 195);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				  int selectedRow=table.getSelectedRow();
	                DefaultTableModel model=(DefaultTableModel)table.getModel();
					
	            	a.setText(table.getValueAt(selectedRow, 0).toString());
	            	b.setText(table.getValueAt(selectedRow, 1).toString());
	            	c.setText(table.getValueAt(selectedRow, 2).toString());
	            	d.setText(table.getValueAt(selectedRow, 3).toString());
	            	e.setText(table.getValueAt(selectedRow, 4).toString());
	            	f.setText(table.getValueAt(selectedRow, 5).toString());
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
		scrollPane.setViewportView(table);
		
		
		JButton Add_btn_Consective = new JButton("Add Consective");
		Add_btn_Consective.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Add_btn_Consective.setBackground(Color.GREEN);
		Add_btn_Consective.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ID = a.getText();
				String acdemicyearsemester = b.getText();
				String prgramm = c.getText();
				String ConSessionSignature= d.getText();
				String lecturename = e.getText();
				String duration = f.getText();
	
				
				try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO consecutiveSession values(null, '" + ID + "','" + acdemicyearsemester+ "','" + prgramm + "','" + ConSessionSignature + "','" + lecturename + "','" + duration + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(Add_btn_Consective, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(Add_btn_Consective,
	                            "Data Added consective session sucessfully");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                	
	                }
			}
		});
				
		Add_btn_Consective.setBounds(138, 531, 190, 74);
		frame.getContentPane().add(Add_btn_Consective);
		
		JButton Add_btn_parallel = new JButton("Add parallel");
		Add_btn_parallel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Add_btn_parallel.setBackground(new Color(100, 149, 237));
		Add_btn_parallel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ID = a.getText();
				String acdemicyearsemester = b.getText();
				String prgramm = c.getText();
				String ConSessionSignature= d.getText();
				String lecturename = e.getText();
				String duration = f.getText();
	
				
				try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO parallel values(null, '" + ID + "','" + acdemicyearsemester+ "','" + prgramm + "','" + ConSessionSignature + "','" + lecturename + "','" + duration + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(Add_btn_Consective, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(Add_btn_Consective,
	                            "Data Added parallel sucessfully");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                	
	                }
			}
		});
			
		Add_btn_parallel.setBounds(435, 531, 185, 74);
		frame.getContentPane().add(Add_btn_parallel);
		
		JButton Add_btn_nonoverlapping = new JButton("Add Non-overlapping");
		Add_btn_nonoverlapping.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Add_btn_nonoverlapping.setBackground(new Color(255, 182, 193));
		Add_btn_nonoverlapping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ID = a.getText();
				String acdemicyearsemester = b.getText();
				String prgramm = c.getText();
				String ConSessionSignature= d.getText();
				String lecturename = e.getText();
				String duration = f.getText();
	
				
				try {
					 Connection con = DBConnect.connect();

	                    String query = "INSERT INTO nonOverlapping values(null, '" + ID + "','" + acdemicyearsemester+ "','" + prgramm + "','" + ConSessionSignature + "','" + lecturename + "','" + duration + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(Add_btn_Consective, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(Add_btn_Consective,
	                            "Data Added non Over lapping sucessfully");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                	
	                }
			}
		});
		Add_btn_nonoverlapping.setBounds(727, 531, 199, 74);
		frame.getContentPane().add(Add_btn_nonoverlapping);
		
		JButton view_consective = new JButton("Consective");
		view_consective.setFont(new Font("Tahoma", Font.PLAIN, 15));
		view_consective.setBackground(new Color(0, 255, 0));
		view_consective.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Consective MWD = new View_Consective();
				try {
					View_Consective.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		view_consective.setBounds(246, 173, 185, 45);
		frame.getContentPane().add(view_consective);
		
		JButton view_parallel = new JButton("Parallel");
		view_parallel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		view_parallel.setBackground(new Color(100, 149, 237));
		view_parallel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					View_Parallel MWD = new View_Parallel();
					try {
						View_Parallel.main(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.setVisible(false);
				}
			});
		view_parallel.setBounds(435, 172, 199, 45);
		frame.getContentPane().add(view_parallel);
		
		JButton view_non_overlapping = new JButton("Non-Overlapping");
		view_non_overlapping.setFont(new Font("Tahoma", Font.PLAIN, 15));
		view_non_overlapping.setBackground(new Color(255, 182, 193));
		view_non_overlapping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				View_Nonoverlapping MWD = new View_Nonoverlapping();
				try {
					View_Nonoverlapping.main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
			}
		});
		view_non_overlapping.setBounds(641, 173, 190, 45);
		frame.getContentPane().add(view_non_overlapping);
		
		a = new JTextField();
		a.setBounds(70, 456, 114, 20);
		frame.getContentPane().add(a);
		a.setColumns(10);
		
		b = new JTextField();
		b.setBounds(218, 456, 114, 20);
		frame.getContentPane().add(b);
		b.setColumns(10);
		
		c = new JTextField();
		c.setBounds(378, 456, 114, 20);
		frame.getContentPane().add(c);
		c.setColumns(10);
		
		d = new JTextField();
		d.setBounds(555, 456, 114, 20);
		frame.getContentPane().add(d);
		d.setColumns(10);
		
		e = new JTextField();
		e.setBounds(732, 456, 114, 20);
		frame.getContentPane().add(e);
		e.setColumns(10);
		
		f = new JTextField();
		f.setBounds(884, 456, 114, 20);
		frame.getContentPane().add(f);
		f.setColumns(10);
		
		
	}
}

