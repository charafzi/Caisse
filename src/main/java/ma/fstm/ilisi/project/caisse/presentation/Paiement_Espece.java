package ma.fstm.ilisi.project.caisse.presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi.project.caisse.controleur.Caisse;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Paiement_Espece extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public JTextField textField_1;
	private JTextField textField_total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paiement_Espece frame = new Paiement_Espece(null);
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
	public Paiement_Espece(Caisse caisse) {
		setResizable(false);
		setTitle("Paiement par espèce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 257, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Montant    ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(22, 69, 88, 18);
		contentPane.add(lblNewLabel);

		JLabel lblReste = new JLabel("Reste      ");
		lblReste.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReste.setBounds(22, 112, 88, 18);
		contentPane.add(lblReste);

		textField = new JTextField();
		textField.setBounds(130, 70, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(130, 113, 96, 19);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(22, 154, 204, 26);
		btnNewButton.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						caisse.payerSomme(Double.valueOf(textField.getText()));
					}
			
				});
		contentPane.add(btnNewButton);
		
		JLabel lblTotal = new JLabel("Total  ");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(22, 29, 88, 18);
		contentPane.add(lblTotal);
		
		textField_total = new JTextField();
		textField_total.setEditable(false);
		textField_total.setColumns(10);
		textField_total.setBounds(130, 30, 96, 19);
		textField_total.setText(Double.toString(caisse.getVente().getTotal()));
		contentPane.add(textField_total);
		
		JLabel lblTotal_1 = new JLabel(":");
		lblTotal_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal_1.setBounds(107, 29, 13, 18);
		contentPane.add(lblTotal_1);
		
		JLabel lblTotal_1_1 = new JLabel(":");
		lblTotal_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal_1_1.setBounds(107, 73, 13, 18);
		contentPane.add(lblTotal_1_1);
		
		JLabel lblTotal_1_1_1 = new JLabel(":");
		lblTotal_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal_1_1_1.setBounds(107, 116, 13, 18);
		contentPane.add(lblTotal_1_1_1);
	}
}
