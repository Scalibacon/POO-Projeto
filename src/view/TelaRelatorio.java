package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JButton;

public class TelaRelatorio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 795, 50);
		contentPane.add(panel);
		
		JLabel lblRelatrios = new JLabel("RELAT\u00D3RIOS");
		lblRelatrios.setForeground(Color.WHITE);
		lblRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblRelatrios);
		
		JButton btnNewButton = new JButton("Produtos mais vendidos");
		btnNewButton.setBounds(298, 122, 203, 23);
		contentPane.add(btnNewButton);
		
		JButton btnPorPerodo = new JButton("Por per\u00EDodo");
		btnPorPerodo.setBounds(298, 226, 203, 23);
		contentPane.add(btnPorPerodo);
	}
}
