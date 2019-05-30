package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;

public class TelaGerenciarVendas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public TelaGerenciarVendas() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 130, 130));
		panel.setBounds(0, 0, 800, 50);
		contentPane.add(panel);
		
		JLabel lblGerenciamentoDeVendas = new JLabel("GERENCIAMENTO DE VENDAS");
		lblGerenciamentoDeVendas.setForeground(Color.WHITE);
		lblGerenciamentoDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblGerenciamentoDeVendas);
		
		table = new JTable();
		table.setBounds(0, 105, 785, 410);
		contentPane.add(table);
	}
}
