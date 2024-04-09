package ma.fstm.ilisi.project.caisse.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi.project.caisse.controleur.Caisse;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Paiement_Carte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paiement_Carte frame = new Paiement_Carte(null);
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
	public Paiement_Carte(Caisse caisse) {
		setTitle("Paiment par carte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 282);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("N° de la carte :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(27, 47, 106, 15);
		contentPane.add(lblNewLabel);

		JLabel lblDateDexpiration = new JLabel("Date d'expiration :");
		lblDateDexpiration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDateDexpiration.setBounds(27, 95, 125, 15);
		contentPane.add(lblDateDexpiration);

		JLabel lblN = new JLabel("N° de sécurité :");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblN.setBounds(27, 170, 125, 15);
		contentPane.add(lblN);

		textField = new JTextField();
		textField.setBounds(163, 46, 123, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(3);
		textField_2.setBounds(163, 169, 47, 19);
		contentPane.add(textField_2);

		String[] mois = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre",
				"Octobre", "Novembre", "Décembre" };
		JComboBox comboBoxMois = new JComboBox(mois);
		comboBoxMois.setBounds(218, 95, 68, 17);
		contentPane.add(comboBoxMois);

		int anneeDebut = 2024;
		int anneeFin = 2100;
		String[] annees = new String[anneeFin - anneeDebut + 1];
		for (int i = 0; i < annees.length; i++) {
			annees[i] = String.valueOf(anneeDebut + i);
		}
		JComboBox comboBoxAnnée = new JComboBox(annees);
		comboBoxAnnée.setBounds(218, 130, 68, 17);
		contentPane.add(comboBoxAnnée);

		JLabel lblMois = new JLabel("Mois :");
		lblMois.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMois.setBounds(161, 97, 49, 13);
		contentPane.add(lblMois);

		JLabel lblAnne = new JLabel("Année");
		lblAnne.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAnne.setBounds(159, 132, 49, 13);
		contentPane.add(lblAnne);
	}
}
