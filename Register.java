package labProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	int mouseX,mouseY;
	private JTextField txtSurname;
	private JTextField txtMail;
	private JTextField txtAddress;
	private JPasswordField passwordField;
	private JPasswordField passwordField2;
	private JTextField txtPhone;

 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 800, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				Popeyes pop = new Popeyes();
				pop.setVisible(true);
			}
		});
		
		ImageIcon visible = new ImageIcon("img/view.png");
		ImageIcon invisible = new ImageIcon("img/invisible.png");
		
		JLabel lblVisibility = new JLabel(invisible);
		lblVisibility.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblVisibility.getIcon().equals(invisible)) {
					lblVisibility.setIcon(visible);
					passwordField.setEchoChar((char) 0);
					passwordField2.setEchoChar((char) 0);
				}
				else{
					lblVisibility.setIcon(invisible);
					passwordField.setEchoChar('*');
					passwordField2.setEchoChar('*');
				}
			}
		});
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(new Color(253, 150, 55));
		separator_2_1.setBackground(new Color(253, 150, 55));
		separator_2_1.setBounds(629, 175, 111, 2);
		contentPane.add(separator_2_1);
		
		txtPhone = new JTextField();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					boolean dot = false;                              
				    char vChar = e.getKeyChar();
				    
				    if (txtPhone.getText().equals("")) dot = false;
				        
				    
				    if (dot == false){
				    	
				        if (vChar == '.') dot = true;
				        else if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE)  || (vChar == KeyEvent.VK_DELETE))) {
				                e.consume();
				        }
				        
				    } 
				    else {
				        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE))) {
				                e.consume();
				        }
				    }
				    
				    if (txtPhone.getText().length() >= 10 ) {
		                e.consume();
				    }
				}
			
		});
		txtPhone.setForeground(new Color(253, 150, 55));
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBackground(Color.WHITE);
		txtPhone.setBounds(629, 149, 111, 20);
		contentPane.add(txtPhone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(new Color(253, 150, 55));
		lblPhone.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblPhone.setBounds(629, 122, 111, 20);
		contentPane.add(lblPhone);
		lblVisibility.setBounds(724, 325, 16, 19);
		contentPane.add(lblVisibility);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(new Color(253, 150, 55));
		separator_1_1_1.setBackground(new Color(253, 150, 55));
		separator_1_1_1.setBounds(494, 412, 249, 2);
		contentPane.add(separator_1_1_1);
		
		JLabel lblPassword_2 = new JLabel("Password");
		lblPassword_2.setForeground(new Color(253, 150, 55));
		lblPassword_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblPassword_2.setBounds(493, 361, 74, 20);
		contentPane.add(lblPassword_2);
		
		passwordField2 = new JPasswordField();
		passwordField2.setForeground(new Color(253, 150, 55));
		passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField2.setEchoChar('*');
		passwordField2.setBorder(null);
		passwordField2.setBackground(Color.WHITE);
		passwordField2.setBounds(494, 388, 251, 20);
		contentPane.add(passwordField2);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(253, 150, 55));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setEchoChar('*');
		passwordField.setBorder(null);
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(493, 324, 226, 20);
		contentPane.add(passwordField);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(253, 150, 55));
		separator_1_1.setBackground(new Color(253, 150, 55));
		separator_1_1.setBounds(493, 348, 249, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(253, 150, 55));
		lblPassword.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblPassword.setBounds(492, 297, 74, 20);
		contentPane.add(lblPassword);
		
		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setForeground(new Color(253, 150, 55));
		lblDistrict.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblDistrict.setBounds(614, 196, 57, 20);
		contentPane.add(lblDistrict);
		
		JComboBox cbDistrict = new JComboBox();
		cbDistrict.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 10));
		cbDistrict.setBounds(669, 196, 74, 22);
		contentPane.add(cbDistrict);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(new Color(253, 150, 55));
		lblCity.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblCity.setBounds(494, 196, 43, 20);
		contentPane.add(lblCity);
		
		
		
		DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"Istanbul","Adana","Ankara","Izmir"});
		
		DefaultComboBoxModel dis1 = new DefaultComboBoxModel(new String[] {"Atasehir","Avcilar","Bahcelievler","Buyukcekmece","Besiktas","Esenler","Esenyurt","Fatih","Kadıkoy","Kagithane","Kucukcekmece","Silivri"});
		DefaultComboBoxModel dis2 = new DefaultComboBoxModel(new String[] {"Ceyhan","Cukurova","Feke","Imamoglu","Karaisali","Karatas","Kozan","Pozanti","Saimbeyli","Seyhan","Yumurtalık","Yuregir"});
		DefaultComboBoxModel dis3 = new DefaultComboBoxModel(new String[] {"Akyurt","Altindag","Beypazari","Cankaya","Etimesgut","Kalecik","Mamak","Polatlı","Sincan","Yenimahalle"});
		DefaultComboBoxModel dis4 = new DefaultComboBoxModel(new String[] {"Aliaga","Bayrakli","Bergama","Bornova","Çesme","Dikili","Gaziemir","Karaburun","Kiraz","Menderes","Menemen","Narlidere","Seferihisar"});
		
		cbDistrict.setModel(dis1);
		
		JComboBox cbCity = new JComboBox(model);
		cbCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbCity.getSelectedItem().toString().equals("Istanbul")) {
					cbDistrict.setModel(dis1);
				}
				else if(cbCity.getSelectedItem().toString().equals("Adana")) {
					cbDistrict.setModel(dis2);
				}
				else if(cbCity.getSelectedItem().toString().equals("Ankara")) {
					cbDistrict.setModel(dis3);
				}
				else {
					cbDistrict.setModel(dis4);
				}
				
			}
		});
		cbCity.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		cbCity.setBounds(530, 196, 74, 22);
		contentPane.add(cbCity);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(253, 150, 55));
		separator_3.setBackground(new Color(253, 150, 55));
		separator_3.setBounds(492, 284, 250, 2);
		contentPane.add(separator_3);
		
		JLabel lblAdress = new JLabel("Address");
		lblAdress.setForeground(new Color(253, 150, 55));
		lblAdress.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblAdress.setBounds(492, 231, 74, 20);
		contentPane.add(lblAdress);
		
		txtAddress = new JTextField();
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
		txtAddress.setForeground(new Color(253, 150, 55));
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress.setColumns(10);
		txtAddress.setBorder(null);
		txtAddress.setBackground(Color.WHITE);
		txtAddress.setBounds(492, 258, 250, 20);
		contentPane.add(txtAddress);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setForeground(new Color(253, 150, 55));
		lblEmail.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblEmail.setBounds(493, 122, 111, 20);
		contentPane.add(lblEmail);
		
		txtMail = new JTextField();
		txtMail.setForeground(new Color(253, 150, 55));
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMail.setColumns(10);
		txtMail.setBorder(null);
		txtMail.setBackground(Color.WHITE);
		txtMail.setBounds(493, 149, 111, 20);
		contentPane.add(txtMail);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(253, 150, 55));
		separator_2.setBackground(new Color(253, 150, 55));
		separator_2.setBounds(493, 175, 111, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(253, 150, 55));
		separator_1.setBackground(new Color(253, 150, 55));
		separator_1.setBounds(623, 109, 110, 2);
		contentPane.add(separator_1);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setForeground(new Color(253, 150, 55));
		lblSurname.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblSurname.setBounds(623, 56, 74, 20);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setForeground(new Color(253, 150, 55));
		txtSurname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSurname.setColumns(10);
		txtSurname.setBorder(null);
		txtSurname.setBackground(Color.WHITE);
		txtSurname.setBounds(623, 83, 110, 20);
		contentPane.add(txtSurname);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(253, 150, 55));
		separator.setBackground(new Color(253, 150, 55));
		separator.setBounds(492, 109, 110, 2);
		contentPane.add(separator);
		
		JTextField txtName = new JTextField();
		txtName.setForeground(new Color(253, 150, 55));
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(492, 83, 110, 20);
		contentPane.add(txtName);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(253, 150, 55));
		lblName.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblName.setBounds(492, 56, 74, 20);
		contentPane.add(lblName);
		
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblBack.setBounds(5, 5, 20, 20);
		contentPane.add(lblBack);
		
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.BLACK);
		lblMinimize.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblMinimize.setBounds(740, 5, 23, 20);
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
		lblClose.setBounds(770, 5, 23, 20);
		contentPane.add(lblClose);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));

		ImageIcon btn1 = new ImageIcon("img/btn1RegisterPop.png");
		ImageIcon btn2 = new ImageIcon("img/btn2RegisterPop.png");
		
		JButton btnNewButton = new JButton(btn1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
				
				Pattern pat = Pattern.compile(emailRegex);
				
				if(txtName.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type a name!");
					return;
				}
				if(txtSurname.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type a surname!");
					return;
				}
				if(txtMail.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type a mail!");
					return;
				}
				if(!pat.matcher(txtMail.getText()).matches()) {
					JOptionPane.showMessageDialog(contentPane, "Incorrect Mail!");
					return;
				}
				if(txtPhone.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type a phone!");
					return;
				}
				if(txtPhone.getText().length()!=10) {
					JOptionPane.showMessageDialog(contentPane, "Wrong phone number!");
					return;
				}
				if(txtAddress.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type an address!");
					return;
				}
				if(passwordField.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type a password!");
					return;
				}
				if(passwordField2.getText().length()==0) {
					JOptionPane.showMessageDialog(contentPane, "Type a password!");
					return;
				}
				if(!passwordField.getText().equals(passwordField2.getText())) {
					JOptionPane.showMessageDialog(contentPane, "Password are not equal!");
					return;
				}

				File file = new File("popeyesUsers.txt");

				try {
					
					FileReader fread = new FileReader(file);

					BufferedReader bfread = new BufferedReader(fread);

					while(bfread.ready()) {

						String userInfos = bfread.readLine();
						
						String[] userDatas = userInfos.split(",");
						
						if(userDatas[2].equals(txtMail.getText())) {
							JOptionPane.showMessageDialog(contentPane, "This mail is using.");
							return;
						}
						if(userDatas[3].equals(txtPhone.getText())) {
							JOptionPane.showMessageDialog(contentPane, "This phone number is using.");
							return;
						}
					}
					
					bfread.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try(BufferedWriter bfwrite = new BufferedWriter(new FileWriter(file,true))){
					
					bfwrite.write(txtName.getText()+",");
					bfwrite.write(txtSurname.getText()+",");
					bfwrite.write(txtMail.getText()+",");
					bfwrite.write(txtPhone.getText()+",");
					bfwrite.write(cbCity.getSelectedItem().toString()+",");
					bfwrite.write(cbDistrict.getSelectedItem().toString()+",");
					bfwrite.write(txtAddress.getText()+",");
					bfwrite.write(passwordField.getText().toString()+",");
					bfwrite.write(passwordField2.getText().toString());
					bfwrite.newLine();
					bfwrite.close();
			 	} catch (IOException e1) {
					JOptionPane.showMessageDialog(contentPane, "IOException Error!");
					return;
			 	}
				
				JOptionPane.showMessageDialog(contentPane, "Succesfully Registered!");
				dispose();
				Popeyes p = new Popeyes();
				p.setVisible(true);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setIcon(btn2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setIcon(btn1);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(530, 439, 185, 30);
		contentPane.add(btnNewButton);


		JLabel lblBackground = new JLabel(new ImageIcon("img/registerBackPopeyes.png"));
		lblBackground.setBounds(0, 0, 800, 512);
		contentPane.add(lblBackground);
		
		JPanel panel = new JPanel();
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
		panel.setBounds(0, 0, 800, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		setUndecorated(true);
		
		
		
	}
	
}
