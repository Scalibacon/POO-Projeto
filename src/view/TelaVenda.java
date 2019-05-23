package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TelaVenda extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
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
	public TelaVenda() {
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
		
		JLabel lblVenda = new JLabel("VENDA");
		lblVenda.setForeground(Color.WHITE);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblVenda);
		
		JLabel label = new JLabel("+");
		label.setForeground(new Color(0, 128, 128));
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		label.setBounds(321, 61, 39, 40);
		contentPane.add(label);
		
		JLabel lblNovoItem = new JLabel("Novo Item");
		lblNovoItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNovoItem.setBounds(370, 69, 182, 32);
		contentPane.add(lblNovoItem);
		
		table = new JTable();
		table.setBounds(0, 133, 795, 378);
		contentPane.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(-11, 511, 795, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotalR = new JLabel("TOTAL R$: ");
		lblTotalR.setBounds(477, 0, 195, 50);
		panel_1.add(lblTotalR);
		lblTotalR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalR.setForeground(Color.WHITE);
		lblTotalR.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.setBounds(364, 11, 89, 23);
		panel_1.add(btnNewButton);
	}

}
