package labProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class districtChoose extends JFrame {

	private JPanel contentPane;
	int mouseX,mouseY;
	String district;
	private JTextField txtAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainPage.Total = new BigDecimal("0");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					districtChoose frame = new districtChoose();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public districtChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 350, 383, 273);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,125,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblMinimize = new JLabel("-");
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimize.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimize.setForeground(Color.BLACK);
			}
		});
		
		JLabel lblBack = new JLabel("<");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBack.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				SwitchLocation sw = new SwitchLocation();
				MainPage.Total = new BigDecimal("0");
				sw.setVisible(true);
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(156, 175, 210, 2);
		contentPane.add(separator);
		
		txtAddress = new JTextField();
		txtAddress.setForeground(Color.BLACK);
		txtAddress.setFont(new Font("Lucida Sans", Font.PLAIN, 12));
		txtAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				if(a == ',') {
					e.consume();
					JOptionPane.showMessageDialog(contentPane, "Forbidden key typed --> ',' ");
				}
			}
		});
		txtAddress.setBorder(null);
		txtAddress.setBackground(new Color(255,125,0));
		txtAddress.setBounds(156, 153, 210, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblnewAddress = new JLabel("New Address");
		lblnewAddress.setForeground(Color.BLACK);
		lblnewAddress.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblnewAddress.setBounds(156, 123, 92, 30);
		contentPane.add(lblnewAddress);
		
		
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblBack.setBounds(5, 5, 20, 20);
		contentPane.add(lblBack);
		
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.BLACK);
		lblMinimize.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblMinimize.setBounds(320, 5, 23, 20);
		contentPane.add(lblMinimize);
		
		JLabel lblClose = new JLabel("X");
		lblClose.setForeground(Color.BLACK);
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClose.setForeground(Color.BLACK);
			}
		});
		lblClose.setBounds(350, 5, 23, 20);
		contentPane.add(lblClose);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		
		String dis1[] = {"Atasehir","Avcilar","Bahcelievler","Buyukcekmece","Besiktas","Esenler","Esenyurt","Fatih","Kadikoy","Kagithane","Kucukcekmece","Silivri"};
		String dis2[] = {"Ceyhan","Cukurova","Feke","Imamoglu","Karaisali","Karatas","Kozan","Pozanti","Saimbeyli","Seyhan","Yumurtalik","Yuregir"};
		String dis3[] = {"Akyurt","Altindag","Beypazari","Cankaya","Etimesgut","Kalecik","Mamak","Polatli","Sincan","Yenimahalle"};
		String dis4[] = {"Aliaga","Bayrakli","Bergama","Bornova","Cesme","Dikili","Gaziemir","Karaburun","Kiraz","Menderes","Menemen","Narlidere","Seferihisar"};
		
		DefaultListModel model = new DefaultListModel();
		
		if(SwitchLocation.choose.equals("Istanbul")) {
			for(int i = 0 ; i < dis1.length ; i++) {
				model.addElement(dis1[i]);
			}
		}
		if(SwitchLocation.choose.equals("Adana")) {
			for(int i = 0 ; i < dis2.length ; i++) {
				model.addElement(dis2[i]);
			}
		}
		if(SwitchLocation.choose.equals("Ankara")) {
			for(int i = 0 ; i < dis3.length ; i++) {
				model.addElement(dis3[i]);
			}
		}
		if(SwitchLocation.choose.equals("Izmir")) {
			for(int i = 0 ; i < dis4.length ; i++) {
				model.addElement(dis4[i]);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 41, 131, 221);
		contentPane.add(scrollPane);
		
		JList list = new JList();

		scrollPane.setViewportView(list);
		
		list.setModel(model);
		
		JLabel lblNewLabel = new JLabel("City: "+SwitchLocation.choose);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblNewLabel.setBounds(156, 41, 171, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblDistrict = new JLabel("District: Select a district!");
		lblDistrict.setForeground(Color.BLACK);
		lblDistrict.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblDistrict.setBounds(156, 82, 181, 30);
		contentPane.add(lblDistrict);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,125,0));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX , getY() + e.getY() - mouseY);
			}
		});
		panel.setBounds(0, 0, 382, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon change1 = new ImageIcon("img/change1.png");
		ImageIcon change2 = new ImageIcon("img/change2.png");
		
		JButton btnChangeLocation = new JButton(change1);
		btnChangeLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblDistrict.getText().equals("District: Select a district!")) {
					JOptionPane.showMessageDialog(contentPane, "Select a district!");
					return;
				}
				if(txtAddress.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type an delivery address!");
					return;
				}
				
				File file = new File("popeyesUsers.txt");
				
				try {

					BufferedReader bfread = new BufferedReader(new FileReader(file));
					
					String line = bfread.readLine();
					String newContent = "";

					while (line != null)
					{
						        
					        String datas[] = line.split(",");
					        
					        if(datas[2].equals(Popeyes.loggedUser.mail)) {
					        	datas[4] = 	SwitchLocation.choose;
					        	datas[5] = 	district;
					        	datas[6] = 	txtAddress.getText();
					        	Popeyes.loggedUser.city = SwitchLocation.choose;
					        	Popeyes.loggedUser.district = district;
					        	Popeyes.loggedUser.address = txtAddress.getText();
					        	line="";
					        	for(int i = 0 ; i < datas.length ; i++) {
					        		line+= datas[i]+",";
					        	}
					        }
					        
					        newContent+= line+"\n";
					        line = bfread.readLine();
					}
					
					BufferedWriter bfwrite = new BufferedWriter(new FileWriter(file));
					
					bfwrite.write(newContent);
					bfwrite.close();
					bfread.close();
					
					JOptionPane.showMessageDialog(contentPane, "Succesfully location changed!");
					dispose();
					MainPage.Total = new BigDecimal("0");
					MainPage mP = new MainPage();
					mP.setVisible(true);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnChangeLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChangeLocation.setIcon(change2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnChangeLocation.setIcon(change1);
			}
		});
		btnChangeLocation.setBorder(null);
		btnChangeLocation.setBounds(156, 202, 210, 60);
		contentPane.add(btnChangeLocation);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblDistrict.setText("District: "+list.getSelectedValue().toString());
				district = list.getSelectedValue().toString();
			}
		});
		
	}
}
