package ma.fstm.ilisi.project.caisse.presentation;
import ma.fstm.ilisi.project.caisse.controleur.Caisse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class Formulaire_Vente extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textFieldCodePrdt;
	public JTextField textFieldQte;
	public JTextField textField_Total;
	public Paiement_Espece panel_paie_esp;
	public Paiement_Carte panel_paie_carte;
	public int quantite = 1;
	public JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulaire_Vente frame = new Formulaire_Vente();
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
	public Formulaire_Vente() {
		setTitle("Achat");
		
		//this.panel_paie_esp = new Paiement_Espece();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,2));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(new Color(0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_Total = new JTextField();
		textField_Total.setBackground(new Color(255, 255, 255));
		textField_Total.setEditable(false);
		textField_Total.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_Total.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Total.setForeground(new Color(255, 0, 0));
		textField_Total.setColumns(10);
		textField_Total.setBounds(428, 136, 96, 19);
		panel.add(textField_Total);
		
		JLabel lblNewLabel_prixU_1_1 = new JLabel("Total en DH :");
		lblNewLabel_prixU_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_prixU_1_1.setBounds(322, 132, 96, 26);
		panel.add(lblNewLabel_prixU_1_1);
		
		String[] columnNames = {"Code Produit","Designation", "Prix","Quantité", "Sous Total"};
		model = new DefaultTableModel(null,  columnNames); 
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 514, 118);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblQte = new JLabel("Quantité :");
		lblQte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQte.setBounds(10, 47, 129, 26);
		panel_1.add(lblQte);
		
		textFieldCodePrdt = new JTextField();
		textFieldCodePrdt.setBounds(149, 16, 121, 19);
		panel_1.add(textFieldCodePrdt);
		textFieldCodePrdt.setColumns(10);
		
		JButton btnentrer = new JButton("Entrer");
		btnentrer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnentrer.setBounds(347, 11, 121, 26);
		btnentrer.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						quantite=1;
						Caisse.getInstance().enregisterArticle(textFieldCodePrdt.getText());
						
					}
			
				});
		panel_1.add(btnentrer);
		
		JLabel lblNewLabel_codePdt = new JLabel("Code du produit :");
		lblNewLabel_codePdt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_codePdt.setBounds(10, 11, 129, 26);
		panel_1.add(lblNewLabel_codePdt);
		
		textFieldQte = new JTextField();
		textFieldQte.setText("1");
		textFieldQte.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQte.setColumns(10);
		textFieldQte.setBounds(149, 52, 121, 19);
		textFieldQte.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                	Caisse.getInstance().denombrer(Integer.parseInt(textFieldQte.getText()));
                }
            }
        });
		panel_1.add(textFieldQte);
		
		JButton btnplus = new JButton("+");
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quantite++;
				Caisse.getInstance().denombrer(quantite);
			}
		});
		btnplus.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnplus.setBounds(347, 47, 57, 26);
		panel_1.add(btnplus);
		
		JButton btnmoins = new JButton("-");
		btnmoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(quantite>1)
				{
					quantite--;
					Caisse.getInstance().denombrer(quantite);	
				}
			}
		});
		btnmoins.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnmoins.setBounds(411, 47, 57, 26);
		panel_1.add(btnmoins);
		
		JButton btnFin = new JButton("Fin de vente");
		btnFin.setBackground(new Color(0, 128, 255));
		btnFin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFin.setBounds(347, 83, 121, 78);
		btnFin.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Caisse.getInstance().FinirVente();
					}
			
				});
		panel_1.add(btnFin);
	}
}
