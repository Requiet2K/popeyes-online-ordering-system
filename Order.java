package labProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;

public class Order extends JFrame {

	private JPanel contentPane;
	int mouseX,mouseY;
	String district;
	private JTextField txtCn;
	private JTextField txtCv;
	private JTextField txtExpiry;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 800, 600);
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
				lblMinimize.setForeground(Color.WHITE);
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
				lblBack.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainPage main = new MainPage();
				main.setVisible(true);
				MainPage.Total = new BigDecimal("0");
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Total is $ "+MainPage.Total);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD, 24));
		lblNewLabel_1.setBounds(236, 41, 311, 64);
		contentPane.add(lblNewLabel_1);
		
		txtCv = new JTextField();
		txtCv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					boolean dot = false;                              
				    char vChar = e.getKeyChar();
				    
				    
				        
				    
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
				    
				    if (txtCv.getText().length() >= 3 ) {
		                e.consume();
				    }
				}
			
		});
		txtCv.setEnabled(false);
		txtCv.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		txtCv.setForeground(Color.WHITE);
		txtCv.setColumns(10);
		txtCv.setBorder(null);
		txtCv.setBackground(new Color(36, 40, 82));
		txtCv.setBounds(476, 393, 143, 30);
		contentPane.add(txtCv);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(30, 33, 72));
		separator_1_1.setBackground(new Color(30, 33, 72));
		separator_1_1.setBounds(476, 426, 143, 2);
		contentPane.add(separator_1_1);
		
		txtExpiry = new JTextField();
		txtExpiry.setEnabled(false);
		txtExpiry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtExpiry.getText().equals("MM/YY")) {
					txtExpiry.setText(""); 
					txtExpiry.setForeground(Color.WHITE);
				}
			}
			public void focusLost(FocusEvent e) {
				if(txtExpiry.getText().equals("") || txtExpiry.getText().equals("MM/YY")) {
					txtExpiry.setText("MM/YY");
					txtExpiry.setForeground(new Color(36, 40, 82));
				}
			}
		});
		txtExpiry.setText("MM/YY");
		txtExpiry.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					boolean dot = false;                              
				    char vChar = e.getKeyChar();
				    
				    if (txtExpiry.getText().equals("")) dot = false;
				        
				    
				    if (dot == false){
				    	
				        if (vChar == '/') dot = true;
				        else if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE)  || (vChar == KeyEvent.VK_DELETE))) {
				                e.consume();
				        }
				        
				    } 
				    else {
				        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE))) {
				                e.consume();
				        }
				    }
				    
				    if (txtExpiry.getText().length() >= 5 ) {
		                e.consume();
				    }
				}
			
			
		});
		txtExpiry.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		txtExpiry.setForeground(new Color(135,139,186));
		txtExpiry.setColumns(10);
		txtExpiry.setBorder(null);
		txtExpiry.setBackground(new Color(36, 40, 82));
		txtExpiry.setBounds(249, 393, 100, 30);
		contentPane.add(txtExpiry);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(30, 33, 72));
		separator_1.setBackground(new Color(30, 33, 72));
		separator_1.setBounds(249, 426, 100, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(30,33,72));
		separator.setBackground(new Color(30,33,72));
		separator.setBounds(308, 355, 311, 2);
		contentPane.add(separator);
		
		txtCn = new JTextField();
		txtCn.setEnabled(false);
		txtCn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					boolean dot = false;                              
				    char vChar = e.getKeyChar();
				    
				    
				        
				    
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
				    
				    if (txtCn.getText().length() >= 16 ) {
		                e.consume();
				    }
				}
			
		});
		txtCn.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		txtCn.setForeground(Color.WHITE);
		txtCn.setBorder(null);
		txtCn.setBounds(308, 323, 308, 30);
		txtCn.setBackground(new Color(36,40,82));
		contentPane.add(txtCn);
		txtCn.setColumns(10);
		
		
		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblBack.setBounds(5, 5, 20, 20);
		contentPane.add(lblBack);
		
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.WHITE);
		lblMinimize.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblMinimize.setBounds(735, 5, 23, 20);
		contentPane.add(lblMinimize);
		
		JLabel lblClose = new JLabel("X");
		lblClose.setForeground(Color.WHITE);
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
				lblClose.setForeground(Color.WHITE);
			}
		});
		lblClose.setBounds(770, 5, 23, 20);
		contentPane.add(lblClose);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		
		ImageIcon r1 = new ImageIcon("img/rd1.png");
		ImageIcon r2 = new ImageIcon("img/rd2.png");
		
		JRadioButton rdbtnCash = new JRadioButton("  Cash on delivery");
		rdbtnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCash.isSelected()) {
					txtCn.setEnabled(false);
					txtCn.setText("");
					txtExpiry.setEnabled(false);
					txtExpiry.setText("MM/YY");
					txtExpiry.setForeground(new Color(36, 40, 82));
					txtCv.setEnabled(false);
					txtCv.setText("");
				}
			}
		});
		rdbtnCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnCash.getIcon().equals(r1)) {
					rdbtnCash.setSelectedIcon(r2);
				}
				else {
					rdbtnCash.setSelectedIcon(r1);
				}
			}
		});
		rdbtnCash.setForeground(Color.WHITE);
		rdbtnCash.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnCash.setBorder(null);
		rdbtnCash.setIcon(r1);
		rdbtnCash.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		rdbtnCash.setBackground(new Color(30,33,72));
		rdbtnCash.setBounds(169, 168, 233, 45);
		rdbtnCash.setActionCommand("Online");
		rdbtnCash.setFocusPainted(false);
		contentPane.add(rdbtnCash);
		
		JRadioButton rdbtnOnline = new JRadioButton("  Credic card");
		rdbtnOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOnline.isSelected()) {
					txtCn.setEnabled(true);
					txtExpiry.setEnabled(true);
					txtCv.setEnabled(true);
				}
				
			}
		});
		rdbtnOnline.setForeground(Color.WHITE);
		rdbtnOnline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnCash.getIcon().equals(r1)) {
					rdbtnOnline.setSelectedIcon(r2);
				}
				else {
					rdbtnOnline.setSelectedIcon(r1);
				}
			}
		});
		rdbtnOnline.setBorder(null);
		rdbtnOnline.setIcon(r1);
		rdbtnOnline.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		rdbtnOnline.setBackground(new Color(30,33,72));
		rdbtnOnline.setBounds(169, 241, 233, 45);
		rdbtnOnline.setActionCommand("Cash on delivery");
		rdbtnOnline.setFocusPainted(false);
		contentPane.add(rdbtnOnline);

		
		ButtonGroup paymentGroup = new ButtonGroup();
		paymentGroup.add(rdbtnOnline);
		paymentGroup.add(rdbtnCash);
		
		ImageIcon btn1 = new ImageIcon("img/orderbtn1.png");
		ImageIcon btn2 = new ImageIcon("img/orderbtn2.png");
		
		JButton btnNewButton = new JButton(btn1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOnline.isSelected()) {
					if(txtCn.getText().length()!=16 || txtExpiry.getText().length()!=5 || txtCv.getText().length()!=3) {
						JOptionPane.showMessageDialog(contentPane, "Credic card infos are invalid!");
						return;
					}
				}
				else if(!rdbtnCash.isSelected()) {
					JOptionPane.showMessageDialog(contentPane, "Select payment method!");
					return;
				}
				
				JOptionPane.showMessageDialog(contentPane, "Succesfully Ordered!");
				
				int process = JOptionPane.showConfirmDialog(contentPane, "Would you like to exit ?");
				if(process==0) {
					System.exit(0);
				}
				else {
					MainPage.Total = new BigDecimal("0");
					MainPage mp = new MainPage();
					mp.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBorder(null);
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
		btnNewButton.setBounds(143, 475, 519, 63);
		contentPane.add(btnNewButton);
		
		JLabel lblBG = new JLabel(new ImageIcon("img/payment.png"));
		lblBG.setBounds(0, 0, 800, 600);
		contentPane.add(lblBG);
		
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
		panel.setBounds(0, 0, 800, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		

		
	}
}
