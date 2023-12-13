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
import java.awt.Image;
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

public class SwitchLocation extends JFrame {

	private JPanel contentPane;
	int mouseX,mouseY;
	static String choose;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainPage.Total = new BigDecimal("0");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwitchLocation frame = new SwitchLocation();
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
	public SwitchLocation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 1000, 516);
		contentPane = new JPanel();
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
				MainPage main = new MainPage();
				main.setVisible(true);
			}
		});
		
		JLabel lblAdana = new JLabel("Adana");
		lblAdana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAdana.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAdana.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				choose = "Adana";
				districtChoose dc = new districtChoose();
				dc.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblLoggedLocation = new JLabel(Popeyes.loggedUser.city+"/"+Popeyes.loggedUser.district);
		lblLoggedLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoggedLocation.setForeground(Color.BLACK);
		lblLoggedLocation.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		lblLoggedLocation.setBounds(624, 11, 180, 30);
		contentPane.add(lblLoggedLocation);
		
		JLabel lblLocationIcon = new JLabel(new ImageIcon("img/location30.png"));
		lblLocationIcon.setBounds(591, 11, 46, 30);
		contentPane.add(lblLocationIcon);
		lblAdana.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdana.setForeground(Color.BLACK);
		lblAdana.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdana.setBounds(464, 342, 91, 51);
		contentPane.add(lblAdana);
		
		JLabel lblIzmir = new JLabel("Izmir");
		lblIzmir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIzmir.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIzmir.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				choose = "Izmir";
				districtChoose dc = new districtChoose();
				dc.setVisible(true);
				dispose();
			}
		});
		lblIzmir.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzmir.setForeground(Color.BLACK);
		lblIzmir.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIzmir.setBounds(54, 286, 91, 51);
		contentPane.add(lblIzmir);

		
		JLabel lblIst = new JLabel("Istanbul");
		lblIst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIst.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIst.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				choose = "Istanbul";
				districtChoose dc = new districtChoose();
				dc.setVisible(true);
				dispose();
			}
		});
		lblIst.setHorizontalAlignment(SwingConstants.CENTER);
		lblIst.setForeground(Color.BLACK);
		lblIst.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIst.setBounds(137, 75, 91, 51);
		contentPane.add(lblIst);
		
		JLabel lblAnkara = new JLabel("Ankara");
		lblAnkara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAnkara.setForeground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAnkara.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				choose = "Ankara";
				districtChoose dc = new districtChoose();
				dc.setVisible(true);
				dispose();
			}
		});
		lblAnkara.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnkara.setForeground(Color.BLACK);
		lblAnkara.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAnkara.setBounds(325, 163, 91, 51);
		contentPane.add(lblAnkara);


		lblBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblBack.setForeground(Color.BLACK);
		lblBack.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblBack.setBounds(5, 5, 20, 20);
		contentPane.add(lblBack);
		
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.BLACK);
		lblMinimize.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblMinimize.setBounds(940, 5, 23, 20);
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
		lblClose.setBounds(970, 5, 23, 20);
		contentPane.add(lblClose);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		
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

		JLabel lblBG = new JLabel();
		lblBG.setBounds(0, 0, 1000, 516);
		contentPane.add(lblBG);
		
		panel.setBounds(0, 0, 1000, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon randomIcon = new ImageIcon("img/turkey.png");
		Image randomImage = randomIcon.getImage().getScaledInstance(lblBG.getWidth(),lblBG.getHeight(),Image.SCALE_SMOOTH);
		lblBG.setIcon(new ImageIcon(randomImage));
		
		
	}
}
