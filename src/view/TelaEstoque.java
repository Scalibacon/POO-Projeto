package view;

import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.EstoqueController;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaEstoque extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNovo, btnExcluir, btnEstocar, btnAlterar;
	private EstoqueController controller;

	public TelaEstoque() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 134, 784, 427);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnAlterar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		scrollPane.setViewportView(table);

		btnEstocar = new JButton("Estocar");
		btnEstocar.setBounds(250, 79, 89, 23);
		contentPane.add(btnEstocar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(445, 79, 89, 23);
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(this);
		contentPane.add(btnAlterar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(644, 79, 89, 23);
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(this);
		contentPane.add(btnExcluir);

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(56, 79, 89, 23);
		btnNovo.addActionListener(this);
		contentPane.add(btnNovo);

		controller = new EstoqueController(table);
		controller.iniciarTabelaEstoque();
		controller.carregarTabela();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNovo) {
			controller.adicionarNovoProduto();
		} else if (e.getSource() == btnAlterar) {
			controller.alterarProduto();
		} else if (e.getSource() == btnAlterar) {
			System.out.println("Desculpe, mas a função não está disponível no momento");
		} else if (e.getSource() == btnExcluir) {
			controller.excluirProduto();
		}
	}
}
