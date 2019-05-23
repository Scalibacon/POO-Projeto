package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;

public class Estoque extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque();
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
	public Estoque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(-11, 0, 795, 50);
		contentPane.add(panel);
		
		JLabel lblGerenciamentoDeEstoque = new JLabel("GERENCIAMENTO DE ESTOQUE");
		lblGerenciamentoDeEstoque.setForeground(new Color(255, 255, 255));
		lblGerenciamentoDeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblGerenciamentoDeEstoque);
		
		JLabel label = new JLabel("+");
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		label.setForeground(new Color(0, 128, 128));
		label.setBounds(252, 71, 39, 40);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("Cadastrar produto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(301, 79, 182, 32);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(0, 134, 784, 427);
		contentPane.add(table);
	}
}
