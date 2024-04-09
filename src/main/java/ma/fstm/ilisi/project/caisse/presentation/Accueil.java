package ma.fstm.ilisi.project.caisse.presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi.project.caisse.controleur.Caisse;

import javax.swing.JButton;
public class Accueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPanechr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					Accueil frame = new Accueil();
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
	public Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 159, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton demarrer = new JButton("Demarrer");
		demarrer.setBounds(12, 26, 120, 40);
		contentPane.add(demarrer);
		
		demarrer.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						Caisse.getInstance().initialiser();					
					}
			
				});
		this.setLocationRelativeTo(null);
	}
}
