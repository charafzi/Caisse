package ma.fstm.ilisi.project.caisse.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi.project.caisse.controleur.Caisse;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Gestion_Vente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Formulaire_Vente form_vente;
	public JLabel lblNom;
	public JLabel lblPrenom;
	public JLabel lblSolde;
	public JLabel lblSoldeVal;
	private JLabel lblInformationsDeLa;
	private JLabel lblSolde_1;
	private JLabel lblSolde_2;
	private JMenuBar menuBar;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblSolde_3;
	private JLabel lblSoldeDeLa;
	private JLabel lblSolde_4;
	private JLabel lblSolde_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Vente frame = new Gestion_Vente();
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
	public Gestion_Vente() {
		setTitle("Acceuil");
		
		this.form_vente = new Formulaire_Vente();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 379, 249);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}

			
			
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 10, 169, 170);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblInformationsDeLa = new JLabel("Informations du caissier : ");
		lblInformationsDeLa.setBounds(10, 5, 137, 13);
		panel.add(lblInformationsDeLa);
		lblInformationsDeLa.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		JLabel lblNewLabel = new JLabel("Nom ");
		lblNewLabel.setBounds(10, 36, 81, 13);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		
				
				lblNom = new JLabel("Nom ");
				lblNom.setBounds(85, 36, 45, 13);
				panel.add(lblNom);
				lblNom.setForeground(new Color(255, 0, 0));
				lblNom.setFont(new Font("Tahoma", Font.BOLD, 10));
				
				lblSolde = new JLabel("Prénom");
				lblSolde.setBounds(10, 64, 55, 13);
				panel.add(lblSolde);
				lblSolde.setFont(new Font("Tahoma", Font.BOLD, 10));
				
				lblPrenom = new JLabel("Prenom ");
				lblPrenom.setBounds(85, 64, 45, 13);
				panel.add(lblPrenom);
				lblPrenom.setForeground(new Color(255, 0, 0));
				lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 10));
				
				lblSolde_2 = new JLabel(":");
				lblSolde_2.setBounds(71, 36, 16, 13);
				panel.add(lblSolde_2);
				lblSolde_2.setFont(new Font("Tahoma", Font.BOLD, 10));
				
				lblSolde_1 = new JLabel(":");
				lblSolde_1.setBounds(49, 64, 16, 13);
				panel.add(lblSolde_1);
				lblSolde_1.setFont(new Font("Tahoma", Font.BOLD, 10));
				
				lblSoldeVal = new JLabel("xxxx");
				lblSoldeVal.setBounds(85, 128, 45, 13);
				panel.add(lblSoldeVal);
				lblSoldeVal.setForeground(new Color(0, 128, 255));
				lblSoldeVal.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				lblSolde_3 = new JLabel(":");
				lblSolde_3.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblSolde_3.setBounds(71, 64, 16, 13);
				panel.add(lblSolde_3);
				
				lblSoldeDeLa = new JLabel("Solde de la caisse :");
				lblSoldeDeLa.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblSoldeDeLa.setBounds(10, 105, 137, 13);
				panel.add(lblSoldeDeLa);
				
				lblSolde_4 = new JLabel("Solde");
				lblSolde_4.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblSolde_4.setBounds(10, 128, 81, 13);
				panel.add(lblSolde_4);
				
				lblSolde_5 = new JLabel(":");
				lblSolde_5.setFont(new Font("Tahoma", Font.BOLD, 10));
				lblSolde_5.setBounds(71, 128, 16, 13);
				panel.add(lblSolde_5);
				
				panel_1 = new JPanel();
				panel_1.setBounds(189, 10, 166, 170);
				contentPane.add(panel_1);
				
				JButton btnNewButton = new JButton("Nouvelle Achat");
				panel_1.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener()
						{

							@Override
							public void actionPerformed(ActionEvent e) {
								Caisse.getInstance().nouvelleAchat();
								
							}
					
						});
		
		this.setLocationRelativeTo(null);
		
	}
}
