package view;

import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.EstoqueController;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;

public class TelaEstoque extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTable tabela;
	private JButton btnNovo, btnExcluir, btnEstocar, btnAlterar;
	private EstoqueController controller = new EstoqueController();
	private JTextField txtNome, txtCategoria, txtPreco, txtCodBarras, txtQtdEstoque;
	private JTextArea txtDesc;

	public TelaEstoque() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1080, 600);
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 130, 130));
		panel.setBounds(0, 0, 1050, 50);
		painel.add(panel);

		JLabel lblGerenciamentoDeEstoque = new JLabel("GERENCIAMENTO DE ESTOQUE");
		lblGerenciamentoDeEstoque.setForeground(new Color(255, 255, 255));
		lblGerenciamentoDeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblGerenciamentoDeEstoque);

		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setBounds(10, 135, 700, 425);
		painel.add(scrollTable);

		tabela = new JTable();
		tabela.setBackground(Color.WHITE);
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(tabela.getSelectedRow());
				if (tabela.getSelectedRow() >= 0) {
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					carregarDetail(tabela.getSelectedRow());
				} else {
					btnAlterar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		scrollTable.setViewportView(tabela);
		atualizarTabela();

		btnEstocar = new JButton("Estocar");
		btnEstocar.setBounds(220, 80, 90, 25);
		painel.add(btnEstocar);

		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(385, 80, 90, 25);
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(this);
		painel.add(btnAlterar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(570, 80, 90, 25);
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(this);
		painel.add(btnExcluir);

		btnNovo = new JButton("Novo");
		btnNovo.setBounds(55, 80, 90, 25);
		btnNovo.addActionListener(this);
		painel.add(btnNovo);

		JPanel panelDetail = new JPanel();
		panelDetail.setBackground(Color.WHITE);
		panelDetail.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelDetail.setBounds(720, 80, 335, 475);
		painel.add(panelDetail);
		panelDetail.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 10, 240, 20);
		panelDetail.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setEditable(false);
		txtNome.setBounds(10, 40, 315, 25);
		panelDetail.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(10, 75, 240, 20);
		panelDetail.add(lblCategoria);

		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(10, 100, 315, 25);
		panelDetail.add(txtCategoria);

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(10, 165, 315, 25);
		panelDetail.add(txtPreco);

		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(10, 140, 240, 20);
		panelDetail.add(lblPreco);

		txtCodBarras = new JTextField();
		txtCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCodBarras.setEditable(false);
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(10, 230, 315, 25);
		panelDetail.add(txtCodBarras);

		JLabel lblCodBarras = new JLabel("C\u00F3digo de Barras");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodBarras.setBounds(10, 200, 240, 20);
		panelDetail.add(lblCodBarras);

		txtQtdEstoque = new JTextField();
		txtQtdEstoque.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtQtdEstoque.setEditable(false);
		txtQtdEstoque.setColumns(10);
		txtQtdEstoque.setBounds(10, 290, 315, 25);
		panelDetail.add(txtQtdEstoque);

		JLabel lblQtdEstoque = new JLabel("Quantidade Estoque");
		lblQtdEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQtdEstoque.setBounds(10, 265, 240, 20);
		panelDetail.add(lblQtdEstoque);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricao.setBounds(10, 325, 240, 20);
		panelDetail.add(lblDescricao);

		JScrollPane scrollDesc = new JScrollPane();
		scrollDesc.setBounds(10, 360, 315, 105);
		scrollDesc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelDetail.add(scrollDesc);

		txtDesc = new JTextArea();
		txtDesc.setEditable(false);
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollDesc.setViewportView(txtDesc);

	}

	public void carregarDetail(int rowla) {
		Produto p = controller.buscarProduto(tabela.getValueAt(rowla, 4).toString());
		txtNome.setText(p.getNome());
		txtCategoria.setText(p.getCategoria().name());
		txtPreco.setText(String.valueOf(p.getPreco()));
		txtQtdEstoque.setText(String.valueOf(p.getQuantidade_estoque()));
		txtCodBarras.setText(p.getCod_barras());
		txtDesc.setText(p.getDescricao());
	}

	public void atualizarTabela() {
		controller = new EstoqueController();
		tabela.setModel(controller);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNovo) {
			controller.adicionarOuAlterarProduto(null);
		} else if (e.getSource() == btnAlterar) {
			Produto produto = controller.buscarProduto((String) controller.getValueAt(tabela.getSelectedRow(), 4));
			controller.adicionarOuAlterarProduto(produto);
		} else if (e.getSource() == btnExcluir) {
			if (JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir esse produto?") == 0) {
				controller.excluirProduto(tabela.getSelectedRow());
			}
		}
	}

}
