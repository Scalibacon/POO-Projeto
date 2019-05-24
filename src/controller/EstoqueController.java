package controller;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import view.TelaCadastroProduto;

public class EstoqueController {
	private JTable tabela;

	public EstoqueController(JTable tabela) {
		this.tabela = tabela;
	}

	public void iniciarTabelaEstoque() {
		tabela.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome do produto", "Categoria", "Pre\u00E7o", "Qtd Estoque", "C�d. Barras" }));

		tabela.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(95);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(75);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(200);
	}

	public void carregarTabela() {
		limparTabela();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		for (Produto p : Help.lista_produtos) {
			model.addRow(new Object[] { p.getNome(), p.getCategoria().name(), "R$" + p.getPreco(),
					p.getQuantidade_estoque(), p.getCod_barras() });
		}
	}

	public void limparTabela() {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);
	}

	public void adicionarNovoProduto() {
		JDialog tela_add_produto = new TelaCadastroProduto(this);
		tela_add_produto.setModal(true);
		tela_add_produto.setVisible(true);
	}
	
	public void excluirProduto() {
		String cod_barras = String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 4));
		Help.logado.excluirProduto(cod_barras);
		carregarTabela();
	}
}
