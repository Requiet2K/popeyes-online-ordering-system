package labProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Popeyes extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;
	private JPasswordField password;
	private JSeparator separator_1;
	private JLabel lblVisibleIcon;
	int mouseX,mouseY;
	private JLabel lblClose;
	static User loggedUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Popeyes frame = new Popeyes();
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
	public Popeyes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon btn1 = new ImageIcon("img/btn1.png");
		ImageIcon btn2 = new ImageIcon("img/btn2.png");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File("popeyesUsers.txt");
				
				FileReader fread;
				
				try {
					
					fread = new FileReader(file);
					
					BufferedReader bfread = new BufferedReader(fread);
					
					while(bfread.ready()) {
						
						String userInfos = bfread.readLine();
						
						String[] userDatas = userInfos.split(",");
						
						if(userDatas[2].equals(txtMail.getText()) && userDatas[8].equals(password.getText())) {
							
							JOptionPane.showMessageDialog(contentPane, "Succesfully logged in. Welcome "+userDatas[0]+"!");
							
							loggedUser = new User();
							loggedUser.name = userDatas[0];
							loggedUser.surname = userDatas[1];
							loggedUser.mail = userDatas[2];
							loggedUser.phone = userDatas[3];
							loggedUser.city = userDatas[4];
							loggedUser.district = userDatas[5];
							loggedUser.address = userDatas[6];
							loggedUser.password = userDatas[7];
							
							MainPage main = new MainPage();
							main.setVisible(true);
							dispose();
							return;
						}
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(contentPane, "Account not found!");
			}
		});
		btnNewButton.setIcon(btn1);
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
		
		lblClose = new JLabel("X");
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
		
		JLabel lblClickHere = new JLabel("Click here!");
		lblClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblClickHere.setForeground(Color.DARK_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblClickHere.setForeground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Register reg = new Register();
				reg.setVisible(true);
				dispose();
			}
		});
		lblClickHere.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickHere.setForeground(Color.RED);
		lblClickHere.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblClickHere.setBounds(226, 458, 74, 20);
		contentPane.add(lblClickHere);
		
		JLabel lblPasswordIcon = new JLabel(new ImageIcon("img/popPass.png"));
		lblPasswordIcon.setBounds(62, 341, 32, 30);
		contentPane.add(lblPasswordIcon);
		
		JLabel lblUsernameIcon = new JLabel(new ImageIcon("img/popUser.png"));
		lblUsernameIcon.setBounds(62, 285, 32, 30);
		contentPane.add(lblUsernameIcon);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(158,34,34));
		lblPassword.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblPassword.setBounds(100, 323, 74, 20);
		contentPane.add(lblPassword);
		
		JLabel lblMail = new JLabel("E-Mail");
		lblMail.setForeground(new Color(158,34,34));
		lblMail.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		lblMail.setBounds(100, 262, 74, 20);
		contentPane.add(lblMail);
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.BLACK);
		lblMinimize.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblMinimize.setBounds(340, 5, 23, 20);
		contentPane.add(lblMinimize);
		lblClose.setBounds(370, 5, 23, 20);
		contentPane.add(lblClose);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		
		
		
		btnNewButton.setBackground(new Color(223,120,35));
		btnNewButton.setBounds(100, 397, 185, 30);
		btnNewButton.setBorder(null);
		contentPane.add(btnNewButton);
		
		JLabel lblRegister1 = new JLabel("Don't have an account?");
		lblRegister1.setForeground(Color.BLACK);
		lblRegister1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		lblRegister1.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister1.setBounds(89, 458, 143, 20);
		contentPane.add(lblRegister1);
		
		ImageIcon visible = new ImageIcon("img/view.png");
		ImageIcon invisible = new ImageIcon("img/invisible.png");
		
		lblVisibleIcon = new JLabel("");
		lblVisibleIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblVisibleIcon.getIcon().equals(visible)) {
					lblVisibleIcon.setIcon(invisible);
					password.setEchoChar('*');
				}
				else {
					lblVisibleIcon.setIcon(visible);
					password.setEchoChar((char) 0);
				}
			}
		});
		lblVisibleIcon.setBounds(295, 350, 16, 19);
		contentPane.add(lblVisibleIcon);
		lblVisibleIcon.setIcon(invisible);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(158,34,34));
		separator.setForeground(new Color(158,34,34));
		separator.setBounds(100, 315, 185, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(158,34,34));
		separator_1.setForeground(new Color(158,34,34));
		separator_1.setBounds(100, 372, 185, 2);
		contentPane.add(separator_1);
		
		password = new JPasswordField();
		password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(158,34,34));
				lblPasswordIcon.setBorder(border);
				lblPassword.setForeground(new Color(255,0,0));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblPasswordIcon.setBorder(null);
				lblPassword.setForeground(new Color(158,34,34));
			}
		});
		password.setEchoChar('*');
		password.setBorder(null);
		password.setFont(new Font("Tahoma", Font.PLAIN, 16));
		password.setBackground(new Color(223,120,35));
		password.setForeground(Color.BLACK);
		password.setBounds(100, 348, 185, 20);
		contentPane.add(password);
		
		txtMail = new JTextField();
		txtMail.requestFocusInWindow();
		txtMail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(158,34,34));
				lblUsernameIcon.setBorder(border);
				lblMail.setForeground(new Color(255,0,0));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblUsernameIcon.setBorder(null);
				lblMail.setForeground(new Color(158,34,34));
			}
		});
		txtMail.setBorder(null);
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMail.setBackground(new Color(223,120,35));
		txtMail.setForeground(Color.BLACK);
		txtMail.setBounds(100, 291, 185, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblBg = new JLabel(new ImageIcon("img/popeyesBG.png"));
		lblBg.setBounds(0, 0, 400, 500);
		contentPane.add(lblBg);
		
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
		panel.setBounds(0, 0, 400, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		setUndecorated(true);
		
		
		
	}
}
