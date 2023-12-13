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
import java.math.BigDecimal;

import javax.swing.Icon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class MainPage extends JFrame {

	private JPanel contentPane;
	int mouseX,mouseY;
	private JLabel lblClose;
	static BigDecimal Total = new BigDecimal("0");;
	JLabel lblBoxTotal;
	JScrollPane scrollPane;
	JPanel panelBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon btn1 = new ImageIcon("img/btn1.png");
		ImageIcon btn2 = new ImageIcon("img/btn2.png");
		
		lblClose = new JLabel("X");
		lblClose.setBounds(1070, 5, 23, 20);
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
		lblMinimize.setBounds(1040, 5, 23, 20);
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
		contentPane.setLayout(null);

		ImageIcon plus1 = new ImageIcon("img/plus.png");
		ImageIcon plus2 = new ImageIcon("img/plus2.png");
		
		JLabel lblTriple = new JLabel(plus1);
		lblTriple.setToolTipText("49.99");
		lblTriple.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTriple.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTriple.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Triple Menu",lblTriple.getToolTipText());
			}
		});
		
		ImageIcon trash1 = new ImageIcon("img/trash1.png");
		ImageIcon trash2 = new ImageIcon("img/trash2.png");
		
		JLabel lblTrash = new JLabel(trash1);
		lblTrash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTrash.setIcon(trash2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTrash.setIcon(trash1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBox.removeAll();
				panelBox.repaint();
				Total = new BigDecimal("0");
				lblBoxTotal.setText("Total: $ "+Total);
			}
		});
		
		ImageIcon loc1 = new ImageIcon("img/switch1.png");
		ImageIcon loc2 = new ImageIcon("img/switch2.png");
		
		JButton btnSwitchLocation = new JButton(loc1);
		btnSwitchLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchLocation switchLoc = new SwitchLocation();
				switchLoc.setVisible(true);
				dispose();
			}
		});
		btnSwitchLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSwitchLocation.setIcon(loc2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSwitchLocation.setIcon(loc1);
			}
		});
		btnSwitchLocation.setBorder(null);
		btnSwitchLocation.setBounds(959, 103, 111, 57);
		contentPane.add(btnSwitchLocation);
		
		JLabel lblLoggedLocation = new JLabel(Popeyes.loggedUser.city + "/" + Popeyes.loggedUser.district); 
		lblLoggedLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoggedLocation.setForeground(Color.BLACK);
		lblLoggedLocation.setFont(new Font("Lucida Sans", Font.PLAIN, 18));
		lblLoggedLocation.setBounds(890, 20, 180, 30);
		contentPane.add(lblLoggedLocation);
		
		JLabel lblLocationIcon = new JLabel(new ImageIcon("img/location30.png"));
		lblLocationIcon.setBounds(855, 20, 46, 30);
		contentPane.add(lblLocationIcon);
		
		JLabel lblIconuser = new JLabel(new ImageIcon("img/userIcon.png"));
		lblIconuser.setBounds(690, 21, 46, 27);
		contentPane.add(lblIconuser);
		
		JLabel lblChickenMenuPrice = new JLabel("$ 12.49");
		lblChickenMenuPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblChickenMenuPrice.setForeground(Color.BLACK);
		lblChickenMenuPrice.setBounds(74, 351, 44, 20);
		contentPane.add(lblChickenMenuPrice);
		
		JLabel lblMaxiPrice = new JLabel("$ 19.99");
		lblMaxiPrice.setToolTipText("");
		lblMaxiPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxiPrice.setForeground(Color.BLACK);
		lblMaxiPrice.setBounds(530, 175, 44, 20);
		contentPane.add(lblMaxiPrice);
		
		JLabel lblXLPrice = new JLabel("$ 14.99");
		lblXLPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblXLPrice.setForeground(Color.BLACK);
		lblXLPrice.setBounds(221, 351, 44, 20);
		contentPane.add(lblXLPrice);
		
		JLabel lblKidsPrice = new JLabel("$ 9.99");
		lblKidsPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblKidsPrice.setForeground(Color.BLACK);
		lblKidsPrice.setBounds(530, 351, 44, 20);
		contentPane.add(lblKidsPrice);
		
		JLabel lblTriplePrice = new JLabel("$ 49.99");
		lblTriplePrice.setForeground(Color.BLACK);
		lblTriplePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTriplePrice.setBounds(74, 175, 44, 20);
		contentPane.add(lblTriplePrice);
		
		JLabel lblDoublePopPrice = new JLabel("$ 34.99");
		lblDoublePopPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoublePopPrice.setForeground(Color.BLACK);
		lblDoublePopPrice.setBounds(221, 175, 44, 20);
		contentPane.add(lblDoublePopPrice);
		
		JLabel lblOppPrice = new JLabel("$ 39.99");
		lblOppPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblOppPrice.setForeground(Color.BLACK);
		lblOppPrice.setBounds(373, 175, 44, 20);
		contentPane.add(lblOppPrice);
		
		JLabel lbl20xNuggetPrice = new JLabel("$ 15.49");
		lbl20xNuggetPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl20xNuggetPrice.setForeground(Color.BLACK);
		lbl20xNuggetPrice.setBounds(373, 351, 44, 20);
		contentPane.add(lbl20xNuggetPrice);
		
		lblBoxTotal = new JLabel("Total: $ 0");
		lblBoxTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblBoxTotal.setForeground(Color.BLACK);
		lblBoxTotal.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		lblBoxTotal.setBounds(959, 270, 111, 25);
		contentPane.add(lblBoxTotal);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(707, 133, 240, 224);
		contentPane.add(scrollPane);
		
		panelBox = new JPanel();
		scrollPane.setViewportView(panelBox);
		panelBox.setLayout(new GridLayout(0,2));
		lblTrash.setBounds(917, 106, 25, 25);
		contentPane.add(lblTrash);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_2_1.setForeground(Color.GRAY);
		separator_2_1.setBackground(Color.GRAY);
		separator_2_1.setBounds(706, 103, 2, 252);
		contentPane.add(separator_2_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.GRAY);
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(947, 102, 2, 252);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(706, 356, 243, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.GRAY);
		separator.setBounds(706, 101, 243, 2);
		contentPane.add(separator);
		
		JLabel lblBoxBG = new JLabel(new ImageIcon("img/box.png"));
		lblBoxBG.setBounds(706, 103, 241, 30);
		contentPane.add(lblBoxBG);
		
		JLabel loggedInfo = new JLabel(Popeyes.loggedUser.name+" "+Popeyes.loggedUser.surname); 
		loggedInfo.setHorizontalAlignment(SwingConstants.CENTER);
		loggedInfo.setForeground(Color.BLACK);
		loggedInfo.setFont(new Font("Lucida Sans", Font.PLAIN, 20));
		loggedInfo.setBounds(722, 20, 145, 30);
		contentPane.add(loggedInfo);
		lblTriple.setBounds(118, 170, 30, 30);
		contentPane.add(lblTriple);
		
		JLabel lblDoublePop = new JLabel(plus1);
		lblDoublePop.setToolTipText("34.99");
		lblDoublePop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDoublePop.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblDoublePop.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Double Popchicken",lblDoublePop.getToolTipText());
			}
		});
		lblDoublePop.setBounds(265, 170, 30, 30);
		contentPane.add(lblDoublePop);
		
		JLabel lblOpp = new JLabel(plus1);
		lblOpp.setToolTipText("39.99");
		lblOpp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOpp.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblOpp.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Opportunity Menu",lblOpp.getToolTipText());
			}
		});
		lblOpp.setBounds(417, 170, 30, 30);
		contentPane.add(lblOpp);
		
		JLabel lblMaxi = new JLabel(plus1);
		lblMaxi.setToolTipText("19.99");
		lblMaxi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMaxi.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMaxi.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Maxi Menu",lblMaxi.getToolTipText());
			}
		});
		lblMaxi.setBounds(574, 170, 30, 30);
		contentPane.add(lblMaxi);
		
		JLabel lbl2xTender = new JLabel(plus1);
		lbl2xTender.setToolTipText("3.99");
		lbl2xTender.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl2xTender.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl2xTender.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("2x Tender",lbl2xTender.getToolTipText());
			}
		});
		lbl2xTender.setBounds(96, 512, 30, 30);
		contentPane.add(lbl2xTender);
		
		JLabel lbl2xLeg = new JLabel(plus1);
		lbl2xLeg.setToolTipText("4.79");
		lbl2xLeg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl2xLeg.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl2xLeg.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("2x Leg",lbl2xLeg.getToolTipText());
			}
		});
		lbl2xLeg.setBounds(219, 512, 30, 30);
		contentPane.add(lbl2xLeg);
		
		JLabel lblColeslaw = new JLabel(plus1);
		lblColeslaw.setToolTipText("2.49");
		lblColeslaw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblColeslaw.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblColeslaw.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Coleslaw",lblColeslaw.getToolTipText());
			}
		});
		lblColeslaw.setBounds(565, 512, 30, 30);
		contentPane.add(lblColeslaw);
		
		JLabel lblBbq = new JLabel(plus1);
		lblBbq.setToolTipText("0.49");
		lblBbq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBbq.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBbq.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("BBQ",lblBbq.getToolTipText());
			}
		});
		lblBbq.setBounds(1012, 562, 30, 30);
		contentPane.add(lblBbq);
		
		JLabel lblBbqPrice = new JLabel("$ 0.49");
		lblBbqPrice.setToolTipText("0.49");
		lblBbqPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblBbqPrice.setForeground(Color.BLACK);
		lblBbqPrice.setBounds(968, 567, 44, 20);
		contentPane.add(lblBbqPrice);
		
		JLabel lblRanchPrice = new JLabel("$ 0.49");
		lblRanchPrice.setToolTipText("0.49");
		lblRanchPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanchPrice.setForeground(Color.BLACK);
		lblRanchPrice.setBounds(726, 567, 44, 20);
		contentPane.add(lblRanchPrice);
		
		JLabel lblRanch = new JLabel(plus1);
		lblRanch.setToolTipText("0.49");
		lblRanch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRanch.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRanch.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Ranch",lblRanch.getToolTipText());
			}
		});
		lblRanch.setBounds(770, 562, 30, 30);
		contentPane.add(lblRanch);

		
		JLabel lblTender = new JLabel("2x Tender");
		lblTender.setToolTipText("3.99");
		lblTender.setHorizontalAlignment(SwingConstants.CENTER);
		lblTender.setForeground(Color.BLACK);
		lblTender.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTender.setBounds(23, 489, 113, 16);
		contentPane.add(lblTender);
		
		JLabel lblMayonnaise = new JLabel(plus1);
		lblMayonnaise.setToolTipText("0.49");
		lblMayonnaise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMayonnaise.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMayonnaise.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Mayonnaise",lblMayonnaise.getToolTipText());
			}
		});
		lblMayonnaise.setBounds(535, 562, 30, 30);
		contentPane.add(lblMayonnaise);
		
		JLabel lblMayoPrice = new JLabel("$ 0.49");
		lblMayoPrice.setToolTipText("0.49");
		lblMayoPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayoPrice.setForeground(Color.BLACK);
		lblMayoPrice.setBounds(491, 567, 44, 20);
		contentPane.add(lblMayoPrice);
		
		JLabel lblKetchupPrice = new JLabel("$ 0.49");
		lblKetchupPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblKetchupPrice.setForeground(Color.BLACK);
		lblKetchupPrice.setBounds(175, 567, 44, 20);
		contentPane.add(lblKetchupPrice);
		
		JLabel lblKetchup = new JLabel(plus1);
		lblKetchup.setToolTipText("0.49");
		lblKetchup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKetchup.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblKetchup.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Ketchup",lblKetchup.getToolTipText());
			}
		});
		lblKetchup.setBounds(219, 562, 30, 30);
		contentPane.add(lblKetchup);
		
		JLabel lblWater = new JLabel(plus1);
		lblWater.setToolTipText("0.99");
		lblWater.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblWater.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblWater.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Water",lblWater.getToolTipText());
			}
		});
		lblWater.setBounds(1049, 512, 30, 30);
		contentPane.add(lblWater);
		
		JLabel lblWaterPrice = new JLabel("$ 0.99");
		lblWaterPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaterPrice.setForeground(Color.BLACK);
		lblWaterPrice.setBounds(1013, 517, 44, 20);
		contentPane.add(lblWaterPrice);
		
		JLabel lblSpritePrice = new JLabel("$ 1.49");
		lblSpritePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpritePrice.setForeground(Color.BLACK);
		lblSpritePrice.setBounds(935, 517, 44, 20);
		contentPane.add(lblSpritePrice);
		
		JLabel lblSprite = new JLabel(plus1);
		lblSprite.setToolTipText("1.49");
		lblSprite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblSprite.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSprite.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Sprite",lblSprite.getToolTipText());
			}
		});
		lblSprite.setBounds(972, 512, 30, 30);
		contentPane.add(lblSprite);
		
		JLabel lblCola = new JLabel(plus1);
		lblCola.setToolTipText("1.49");
		lblCola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCola.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCola.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Cola",lblCola.getToolTipText());
			}
		});
		lblCola.setBounds(893, 512, 30, 30);
		contentPane.add(lblCola);
		
		JLabel lblColaPrice = new JLabel("$ 1.49");
		lblColaPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblColaPrice.setForeground(Color.BLACK);
		lblColaPrice.setBounds(855, 517, 44, 20);
		contentPane.add(lblColaPrice);
		
		JLabel lblOnion = new JLabel(plus1);
		lblOnion.setToolTipText("2.99");
		lblOnion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOnion.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblOnion.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Onion Rings",lblOnion.getToolTipText());
			}
		});
		lblOnion.setBounds(681, 512, 30, 30);
		contentPane.add(lblOnion);
		
		JLabel lblCorn = new JLabel(plus1);
		lblCorn.setToolTipText("2.49");
		lblCorn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCorn.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCorn.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Corn",lblCorn.getToolTipText());
			}
		});
		lblCorn.setBounds(796, 512, 30, 30);
		contentPane.add(lblCorn);
		
		JLabel lblCornPrice = new JLabel("$ 2.49");
		lblCornPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCornPrice.setForeground(Color.BLACK);
		lblCornPrice.setBounds(756, 517, 44, 20);
		contentPane.add(lblCornPrice);
		
		JLabel lblOnionPrice = new JLabel("$ 2.99");
		lblOnionPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnionPrice.setForeground(Color.BLACK);
		lblOnionPrice.setBounds(637, 517, 44, 20);
		contentPane.add(lblOnionPrice);
		
		JLabel lblColeSlawPrice = new JLabel("$ 2.49");
		lblColeSlawPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblColeSlawPrice.setForeground(Color.BLACK);
		lblColeSlawPrice.setBounds(521, 517, 44, 20);
		contentPane.add(lblColeSlawPrice);
		
		JLabel lblCageFriesPrice = new JLabel("$ 2.99");
		lblCageFriesPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCageFriesPrice.setForeground(Color.BLACK);
		lblCageFriesPrice.setBounds(412, 517, 44, 20);
		contentPane.add(lblCageFriesPrice);
		
		JLabel lblCage = new JLabel(plus1);
		lblCage.setToolTipText("2.99");
		lblCage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCage.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCage.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Cage Fries",lblCage.getToolTipText());
			}
		});
		lblCage.setBounds(456, 512, 30, 30);
		contentPane.add(lblCage);
		
		JLabel lbl5xNuggetPrice = new JLabel("$ 3.49");
		lbl5xNuggetPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5xNuggetPrice.setForeground(Color.BLACK);
		lbl5xNuggetPrice.setBounds(289, 517, 44, 20);
		contentPane.add(lbl5xNuggetPrice);
		
		JLabel lbl5xNugget = new JLabel(plus1);
		lbl5xNugget.setToolTipText("3.49");
		lbl5xNugget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl5xNugget.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl5xNugget.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("5x Nugget",lbl5xNugget.getToolTipText());
			}
		});
		lbl5xNugget.setBounds(333, 512, 30, 30);
		contentPane.add(lbl5xNugget);
		
		JLabel lbl2xLegPrice = new JLabel("$ 4.79");
		lbl2xLegPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2xLegPrice.setForeground(Color.BLACK);
		lbl2xLegPrice.setBounds(175, 517, 44, 20);
		contentPane.add(lbl2xLegPrice);
		
		JLabel lbl2xTenderPrice = new JLabel("$ 3.99");
		lbl2xTenderPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2xTenderPrice.setForeground(Color.BLACK);
		lbl2xTenderPrice.setBounds(52, 517, 44, 20);
		contentPane.add(lbl2xTenderPrice);
		
		JLabel lblKids = new JLabel(plus1);
		lblKids.setToolTipText("9.99");
		lblKids.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblKids.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblKids.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Kid Menu",lblKids.getToolTipText());
			}
		});
		lblKids.setBounds(574, 346, 30, 30);
		contentPane.add(lblKids);
		
		JLabel lbl20xNugget = new JLabel(plus1);
		lbl20xNugget.setToolTipText("15.49");
		lbl20xNugget.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl20xNugget.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl20xNugget.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("20x Nugget Menu",lbl20xNugget.getToolTipText());
			}
		});
		lbl20xNugget.setBounds(417, 346, 30, 30);
		contentPane.add(lbl20xNugget);
		
		JLabel lblXL = new JLabel(plus1);
		lblXL.setToolTipText("14.99");
		lblXL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblXL.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblXL.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("XL Burger Menu",lblXL.getToolTipText());
			}
		});
		lblXL.setBounds(265, 346, 30, 30);
		contentPane.add(lblXL);
		
		JLabel lblChicken = new JLabel(plus1);
		lblChicken.setToolTipText("12.49");
		lblChicken.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblChicken.setIcon(plus2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblChicken.setIcon(plus1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				addBasket("Chicken Burger Menu",lblChicken.getToolTipText());
			}
		});
		lblChicken.setBounds(118, 346, 30, 30);
		contentPane.add(lblChicken);
		
		JLabel lblBbqq = new JLabel("BBQ");
		lblBbqq.setHorizontalAlignment(SwingConstants.CENTER);
		lblBbqq.setForeground(Color.BLACK);
		lblBbqq.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblBbqq.setBounds(890, 569, 113, 16);
		contentPane.add(lblBbqq);
		
		JLabel lblRanchhh = new JLabel("Ranch");
		lblRanchhh.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanchhh.setForeground(Color.BLACK);
		lblRanchhh.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblRanchhh.setBounds(637, 570, 113, 16);
		contentPane.add(lblRanchhh);
		
		JLabel lblMayonnaisee = new JLabel("Mayonnaise");
		lblMayonnaisee.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayonnaisee.setForeground(Color.BLACK);
		lblMayonnaisee.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMayonnaisee.setBounds(390, 569, 113, 16);
		contentPane.add(lblMayonnaisee);
		
		JLabel lblKetchuppp = new JLabel("Ketchup");
		lblKetchuppp.setToolTipText("0.49");
		lblKetchuppp.setHorizontalAlignment(SwingConstants.CENTER);
		lblKetchuppp.setForeground(Color.BLACK);
		lblKetchuppp.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblKetchuppp.setBounds(85, 569, 113, 16);
		contentPane.add(lblKetchuppp);
		
		JLabel lblCageFries = new JLabel("Cage Fries");
		lblCageFries.setToolTipText("2.99");
		lblCageFries.setHorizontalAlignment(SwingConstants.CENTER);
		lblCageFries.setForeground(Color.BLACK);
		lblCageFries.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblCageFries.setBounds(383, 491, 113, 16);
		contentPane.add(lblCageFries);
		
		JLabel lblOnionRings = new JLabel("8x Onion Rings");
		lblOnionRings.setToolTipText("2.99");
		lblOnionRings.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnionRings.setForeground(Color.BLACK);
		lblOnionRings.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblOnionRings.setBounds(614, 491, 113, 16);
		contentPane.add(lblOnionRings);
		
		JLabel lblNugget = new JLabel("5x Nugget");
		lblNugget.setToolTipText("3.49");
		lblNugget.setHorizontalAlignment(SwingConstants.CENTER);
		lblNugget.setForeground(Color.BLACK);
		lblNugget.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblNugget.setBounds(263, 491, 113, 16);
		contentPane.add(lblNugget);
		
		JLabel lblSpritee = new JLabel("Sprite");
		lblSpritee.setToolTipText("1.49");
		lblSpritee.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpritee.setForeground(Color.BLACK);
		lblSpritee.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblSpritee.setBounds(907, 491, 113, 16);
		contentPane.add(lblSpritee);
		
		JLabel lblColaa = new JLabel("Cola");
		lblColaa.setToolTipText("1.49");
		lblColaa.setHorizontalAlignment(SwingConstants.CENTER);
		lblColaa.setForeground(Color.BLACK);
		lblColaa.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblColaa.setBounds(828, 491, 113, 16);
		contentPane.add(lblColaa);
		
		JLabel lblWaterr = new JLabel("Water");
		lblWaterr.setToolTipText("1.49");
		lblWaterr.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaterr.setForeground(Color.BLACK);
		lblWaterr.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblWaterr.setBounds(985, 491, 113, 16);
		contentPane.add(lblWaterr);
		
		JLabel lblLeg = new JLabel("2x Leg");
		lblLeg.setToolTipText("4.79");
		lblLeg.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeg.setForeground(Color.BLACK);
		lblLeg.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblLeg.setBounds(140, 491, 113, 16);
		contentPane.add(lblLeg);
		
		JLabel lblCornn = new JLabel("Corn");
		lblCornn.setToolTipText("2.49");
		lblCornn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCornn.setForeground(Color.BLACK);
		lblCornn.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblCornn.setBounds(728, 491, 113, 16);
		contentPane.add(lblCornn);
		
		JLabel lblColesla = new JLabel("Coleslaw");
		lblColesla.setToolTipText("2.49");
		lblColesla.setHorizontalAlignment(SwingConstants.CENTER);
		lblColesla.setForeground(Color.BLACK);
		lblColesla.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblColesla.setBounds(491, 491, 113, 16);
		contentPane.add(lblColesla);
		
		JLabel lblChickenBurger = new JLabel("Chicken Burger Menu");
		lblChickenBurger.setToolTipText("12.49");
		lblChickenBurger.setHorizontalAlignment(SwingConstants.CENTER);
		lblChickenBurger.setForeground(Color.BLACK);
		lblChickenBurger.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblChickenBurger.setBounds(45, 321, 134, 16);
		contentPane.add(lblChickenBurger);
		
		JLabel lblForKids = new JLabel("Kids Menu");
		lblForKids.setToolTipText("9.99");
		lblForKids.setHorizontalAlignment(SwingConstants.CENTER);
		lblForKids.setForeground(Color.BLACK);
		lblForKids.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblForKids.setBounds(504, 321, 113, 14);
		contentPane.add(lblForKids);
		
		JLabel lblXlBurgerMenu = new JLabel("XL Burger Menu");
		lblXlBurgerMenu.setToolTipText("14.99");
		lblXlBurgerMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblXlBurgerMenu.setForeground(Color.BLACK);
		lblXlBurgerMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblXlBurgerMenu.setBounds(201, 319, 113, 16);
		contentPane.add(lblXlBurgerMenu);
		
		JLabel lblxNuggetMenu = new JLabel("20x Nugget Menu");
		lblxNuggetMenu.setToolTipText("15.49");
		lblxNuggetMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblxNuggetMenu.setForeground(Color.BLACK);
		lblxNuggetMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblxNuggetMenu.setBounds(352, 319, 113, 16);
		contentPane.add(lblxNuggetMenu);
		
		JLabel lblMaxiMenu = new JLabel("Maxi Menu");
		lblMaxiMenu.setToolTipText("19.99");
		lblMaxiMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxiMenu.setForeground(Color.BLACK);
		lblMaxiMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblMaxiMenu.setBounds(506, 151, 113, 14);
		contentPane.add(lblMaxiMenu);
		
		JLabel lblOpportunityMenu = new JLabel("Opportunity Menu");
		lblOpportunityMenu.setToolTipText("39.99");
		lblOpportunityMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpportunityMenu.setForeground(Color.BLACK);
		lblOpportunityMenu.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblOpportunityMenu.setBounds(352, 151, 113, 14);
		contentPane.add(lblOpportunityMenu);
		
		JLabel lblDoublePopchicken = new JLabel("Double Popchicken");
		lblDoublePopchicken.setToolTipText("34.99");
		lblDoublePopchicken.setForeground(Color.BLACK);
		lblDoublePopchicken.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoublePopchicken.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblDoublePopchicken.setBounds(201, 150, 113, 14);
		contentPane.add(lblDoublePopchicken);
		
		JLabel lblTripleMenus = new JLabel("Triple Menu");
		lblTripleMenus.setToolTipText("49.99");
		lblTripleMenus.setForeground(Color.BLACK);
		lblTripleMenus.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblTripleMenus.setHorizontalAlignment(SwingConstants.CENTER);
		lblTripleMenus.setBounds(52, 150, 113, 14);
		contentPane.add(lblTripleMenus);
		
		JLabel lblFav = new JLabel("Favorite menus");
		lblFav.setForeground(Color.BLACK);
		lblFav.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblFav.setBounds(52, 11, 302, 33);
		contentPane.add(lblFav);
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.BLACK);
		lblMinimize.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		contentPane.add(lblMinimize);
		contentPane.add(lblClose);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		
		ImageIcon visible = new ImageIcon("img/view.png");
		ImageIcon invisible = new ImageIcon("img/invisible.png");
		
		ImageIcon order1 = new ImageIcon("img/order1.png");
		ImageIcon order2 = new ImageIcon("img/order2.png");
		
		JButton btnOrder = new JButton(order1);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lblBoxTotal.getText().equals("Total: $ 0")) {
					JOptionPane.showMessageDialog(contentPane, "Box is empty!");
					return;
				}
				
				Order ord = new Order();
				ord.setVisible(true);
				dispose();
			}
		});
		btnOrder.setBorder(null);
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOrder.setIcon(order2);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOrder.setIcon(order1);
			}
		});
		btnOrder.setBounds(959, 300, 111, 57);
		contentPane.add(btnOrder);
		
		JLabel lblBG = new JLabel(new ImageIcon("img/popeyesMainBG.png"));
		lblBG.setBounds(0, 0, 1100, 600);
		contentPane.add(lblBG);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1100, 30);
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
		contentPane.add(panel);
		panel.setLayout(null);
		setUndecorated(true);
		
	}
	
	
	public void addBasket(String menu,String price) {
		
		Total = Total.add(new BigDecimal(price));
	
		lblBoxTotal.setText("Total: $ "+String.valueOf(Total));
		
		JLabel temp = new JLabel(menu+"  $ "+price);
		temp.setForeground(Color.BLACK);
		temp.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		
		JLabel temp2 = new JLabel("x");

		temp2.setForeground(Color.BLACK);
		temp2.setHorizontalAlignment(SwingConstants.CENTER);
		temp.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		temp2.setBounds(0,0,5,5);
		
		panelBox.add(temp);
		panelBox.add(temp2);
		
		temp2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelBox.remove(temp);
				panelBox.remove(temp2);
				panelBox.revalidate();
				panelBox.repaint();
				Total = Total.subtract(new BigDecimal(price));
				lblBoxTotal.setText("Total: $ "+String.valueOf(Total));
			}
		});
		
	}
}
