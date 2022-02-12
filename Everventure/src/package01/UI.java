package package01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class UI{
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, healthBarPanel, loginPanel, registerPanel,loginButtonPanel,
			loginButtonPanel1,loginMessagePanel, registerMessagePanel, imagePanel, savequitPanel;
	JLabel titleNameLabel, weaponLabel, username1Label, username2Label, password1Label, password2Label, password3Label, weaponNameLabel, imageLabel;
	JButton startButton, choice1, choice2, choice3, choice4, loginButton, loginButton1, registerButton, registerButton1, save, quit;
	JTextArea mainTextArea, loginMessage, registerMessage;
	JTextField username1,username2;
	JPasswordField password1, password2, password3;
	JProgressBar healthBar;
	ImageIcon image;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90 );
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26 );
	String text;
	int i;
	MouseHandler mHandler = new MouseHandler();
	public void createUI(Game.ChoiceHandler cHandler) {

		// Window

		window = new JFrame();
		window.setSize(1024, 768);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.addMouseListener(mHandler);

		// Title Screen

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(128, 128, 768, 640);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("EVERVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(384, 512, 256, 128);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);

		window.add(titleNamePanel);
		window.add(startButtonPanel);

		//Login Screen

		loginPanel = new JPanel();
		loginPanel.setBounds(160,224,768,192);
		loginPanel.setBackground(Color.black);
		loginPanel.setLayout(new GridLayout(2,2));


		username1Label = new JLabel("Username: ");
		username1Label.setFont(normalFont);
		username1Label.setBackground(Color.black);
		username1Label.setForeground(Color.white);
		loginPanel.add(username1Label);

		username1 = new JTextField(1);
		username1.setText("");
		username1.setFont(normalFont);
		username1.setBackground(Color.black);
		username1.setForeground(Color.white);
		loginPanel.add(username1);

		password1Label = new JLabel("Password: ");
		password1Label.setFont(normalFont);
		password1Label.setBackground(Color.black);
		password1Label.setForeground(Color.white);
		loginPanel.add(password1Label);

		password1 = new JPasswordField();
		password1.setText("");
		password1.setFont(normalFont);
		password1.setBackground(Color.black);
		password1.setForeground(Color.white);
		loginPanel.add(password1);

		loginButtonPanel = new JPanel();
		loginButtonPanel.setBounds(320,448,384,192);
		loginButtonPanel.setBackground(Color.black);
		loginButtonPanel.setLayout(new GridLayout(2,1));


		loginButton = new JButton("Login");
		loginButton.setBackground(Color.black);
		loginButton.setForeground(Color.white);
		loginButton.setFont(normalFont);
		loginButton.setFocusPainted(false);
		loginButton.addActionListener(cHandler);
		loginButton.setActionCommand("login");
		loginButtonPanel.add(loginButton);

		registerButton = new JButton("Register");
		registerButton.setBackground(Color.black);
		registerButton.setForeground(Color.white);
		registerButton.setFont(normalFont);
		registerButton.setFocusPainted(false);
		registerButton.addActionListener(cHandler);
		registerButton.setActionCommand("register");
		loginButtonPanel.add(registerButton);

		loginMessage = new JTextArea();
		loginMessage.setText("");
		loginMessage.setBounds(128,128,768,320);
		loginMessage.setBackground(Color.black);
		loginMessage.setForeground(Color.white);
		loginMessage.setFont(normalFont);
		loginMessage.setLineWrap(true);
		loginMessage.setWrapStyleWord(true);
		loginMessage.setEditable(false);

		loginMessagePanel = new JPanel();
		loginMessagePanel.setBounds(64,128,768,64);
		loginMessagePanel.setBackground(Color.black);
		loginMessagePanel.add(loginMessage);



		window.add(loginMessagePanel);

		window.add(loginPanel);
		window.add(loginButtonPanel);


		//Register Screen

		registerPanel = new JPanel();
		registerPanel.setBounds(160,224,768,192);
		registerPanel.setBackground(Color.black);
		registerPanel.setLayout(new GridLayout(3,2));
		window.add(registerPanel);

		username2Label = new JLabel("Username: ");
		username2Label.setFont(normalFont);
		username2Label.setBackground(Color.black);
		username2Label.setForeground(Color.white);
		registerPanel.add(username2Label);

		username2 = new JTextField(1);
		username2.setText("");
		username2.setFont(normalFont);
		username2.setBackground(Color.black);
		username2.setForeground(Color.white);
		registerPanel.add(username2);

		password2Label = new JLabel("Password: ");
		password2Label.setFont(normalFont);
		password2Label.setBackground(Color.black);
		password2Label.setForeground(Color.white);
		registerPanel.add(password2Label);

		password2 = new JPasswordField();
		password2.setText("");
		password2.setFont(normalFont);
		password2.setBackground(Color.black);
		password2.setForeground(Color.white);
		registerPanel.add(password2);

		password3Label = new JLabel("Confirm Password: ");
		password3Label.setFont(normalFont);
		password3Label.setBackground(Color.black);
		password3Label.setForeground(Color.white);
		registerPanel.add(password3Label);

		password3 = new JPasswordField();
		password3.setText("");
		password3.setFont(normalFont);
		password3.setBackground(Color.black);
		password3.setForeground(Color.white);
		registerPanel.add(password3);

		loginButtonPanel1 = new JPanel();
		loginButtonPanel1.setBounds(320,448,384,192);
		loginButtonPanel1.setBackground(Color.black);
		loginButtonPanel1.setLayout(new GridLayout(2,1));


		loginButton1 = new JButton("Login");
		loginButton1.setBackground(Color.black);
		loginButton1.setForeground(Color.white);
		loginButton1.setFont(normalFont);
		loginButton1.setFocusPainted(false);
		loginButton1.addActionListener(cHandler);
		loginButton1.setActionCommand("start");
		loginButtonPanel1.add(loginButton1);

		registerButton1 = new JButton("Register");
		registerButton1.setBackground(Color.black);
		registerButton1.setForeground(Color.white);
		registerButton1.setFont(normalFont);
		registerButton1.setFocusPainted(false);
		registerButton1.addActionListener(cHandler);
		registerButton1.setActionCommand("register1");
		loginButtonPanel1.add(registerButton1);

		registerMessage = new JTextArea();
		registerMessage.setText("");
		registerMessage.setBounds(128,128,768,320);
		registerMessage.setBackground(Color.black);
		registerMessage.setForeground(Color.white);
		registerMessage.setFont(normalFont);
		registerMessage.setLineWrap(true);
		registerMessage.setWrapStyleWord(true);
		registerMessage.setEditable(false);

		registerMessagePanel = new JPanel();
		registerMessagePanel.setBounds(64,128,768,64);
		registerMessagePanel.setBackground(Color.black);
		registerMessagePanel.add(registerMessage);

		window.add(registerMessagePanel);
		window.add(loginButtonPanel1);


		//Game screen

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(64,448,550,320);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);

		mainTextArea = new JTextArea("Here we have the main text area");
		mainTextArea.setBounds(64,448,550,320);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(640,448,320,192);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		window.add(choiceButtonPanel);

		choice1 = new JButton("choice1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton("choice2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton("choice3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		choice4 = new JButton("choice4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);



		playerPanel = new JPanel();
		playerPanel.setBounds(640,128,345,128);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(2,1));
		window.add(playerPanel);

		healthBarPanel = new JPanel();
		healthBarPanel.setBounds(640,80,256,38);
		healthBarPanel.setBackground(Color.black);
		window.add(healthBarPanel);

		healthBar = new JProgressBar(0,15);
		healthBar.setPreferredSize(new Dimension(256,384));
		healthBar.setBackground(Color.red);
		healthBar.setForeground(Color.green);
		healthBarPanel.add(healthBar);

		imagePanel = new JPanel();
		imagePanel.setBounds(64,64,512,308);
		imagePanel.setBackground(Color.black);

		imageLabel = new JLabel();
		image = new ImageIcon();
		imageLabel.setIcon(image);
		imagePanel.add(imageLabel);

		window.add(imagePanel);

		savequitPanel = new JPanel();
		savequitPanel.setBounds(640,324,320,48);
		savequitPanel.setBackground(Color.black);
		savequitPanel.setLayout(new GridLayout(1,2));
		window.add(savequitPanel);

		save = new JButton("Save");
		save.setBackground(Color.black);
		save.setForeground(Color.white);
		save.setFont(normalFont);
		save.setFocusPainted(false);
		save.addActionListener(cHandler);
		save.setActionCommand("save");
		savequitPanel.add(save);

		quit = new JButton("Quit");
		quit.setBackground(Color.black);
		quit.setForeground(Color.white);
		quit.setFont(normalFont);
		quit.setFocusPainted(false);
		quit.addActionListener(cHandler);
		quit.setActionCommand("quit");
		savequitPanel.add(quit);

		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);

		weaponNameLabel = new JLabel();
		weaponNameLabel.setFont(normalFont);
		weaponNameLabel.setForeground(Color.white);
		playerPanel.add(weaponNameLabel);



		window.setVisible(true);
	}
	Timer timer = new Timer(40, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			char character[] = text.toCharArray();
			int arrayNumber = character.length;

			String addedCharacter = "";
			String blank = "";

			addedCharacter = blank + character[i];
			mainTextArea.append(addedCharacter);

			i++;

			if( i == arrayNumber)
			{
				i = 0;
				timer.stop();
				choiceButtonPanel.setVisible(true);
			}

		}
	});
	 public void prepareText(){

		 i = 0;
		 mainTextArea.setText("");
		 timer.start();
	 }


	public class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e)
		{

		}
		@Override
		public void mousePressed(MouseEvent e)
		{
			timer.stop();
			mainTextArea.setText(text);
			i = 0;
			choiceButtonPanel.setVisible(true);
		}
		@Override
		public void mouseReleased(MouseEvent e)
		{

		}
		@Override
		public void mouseEntered(MouseEvent e)
		{

		}
		@Override
		public void mouseExited(MouseEvent e)
		{

		}


	}
}

