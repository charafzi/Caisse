package ma.fstm.ilisi.project.caisse.presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi.project.caisse.controleur.Caisse;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Formulaire_Auth extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulaire_Auth frame = new Formulaire_Auth();
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
	public Formulaire_Auth() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 182);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		login = new JTextField();
		login.setBounds(96, 31, 177, 19);
		contentPane.add(login);
		login.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 66, 177, 19);
		contentPane.add(passwordField);
		
		JLabel labelLogin = new JLabel("Login ");
		labelLogin.setBounds(10, 34, 45, 13);
		contentPane.add(labelLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe ");
		lblMotDePasse.setBounds(10, 69, 85, 13);
		contentPane.add(lblMotDePasse);
		
		JButton authentifier = new JButton("S'authentifier");
		authentifier.setBounds(96, 99, 177, 27);
		contentPane.add(authentifier);
		
		JLabel labelLogin_1 = new JLabel(":");
		labelLogin_1.setBounds(78, 34, 5, 13);
		contentPane.add(labelLogin_1);
		
		JLabel labelLogin_1_1 = new JLabel(":");
		labelLogin_1_1.setBounds(78, 69, 5, 13);
		contentPane.add(labelLogin_1_1);
		
		authentifier.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						Caisse.getInstance().check(Formulaire_Auth.this,login.getText(), passwordField.getText());
						
					}
			
				});
		
		login.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					Caisse.getInstance().check(Formulaire_Auth.this,login.getText(), passwordField.getText());
				}
				
			}
			
		});
		passwordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					Caisse.getInstance().check(Formulaire_Auth.this,login.getText(), passwordField.getText());
				}
				
			}
			
		});
		setLocationRelativeTo(null);	
	}
}
