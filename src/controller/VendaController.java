package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ItemVenda;
import model.Venda;

public class VendaController {
	private JTable tabela;
	private Venda v = new Venda();

	public VendaController(JTable tabela) {
		this.tabela = tabela;
	}

	public void iniciarTabelaItens() {
		tabela.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Produto", "Cod. Barras", "Preço", "Qtd", "Subtotal" }));

		tabela.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(75);
		tabela.getColumnModel().getColumn(4).setPreferredWidth(100);

	}

	public void carregarTabela() {
		limparTabela();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		for (ItemVenda iv : v.getLista_produtos()) {
			model.addRow(new Object[] { iv.getProduto().getNome(), iv.getProduto().getCod_barras(),
					"R$" + iv.getProduto().getPreco(), iv.getQuantidade_produto(),
					iv.calcularSubtotal()});
		}
	}

	public void limparTabela() {
		tabela.clearSelection();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);
	}

	public void adicionarItemVenda(String cod_barras) {		
		if(v.adicionarItem(cod_barras, 1)) {
			carregarTabela();
		}else {
			System.out.println("Código de barras não encontrado... :(");
		}		
	}
	
	public void removerItemVenda(String cod_bar) {
		if(v.removerItem(cod_bar)) {
			carregarTabela();
		}else {
			System.out.println("Não foi possível remover o produto... :(");
		}
	}
	
	public void finalizarVenda() {
		Help.lista_vendas.add(v);
		System.out.println("Venda realizada com sucesso");
		limparTabela();
	}

	public void alterarQuantidade(String cod_bar, int novaQtd) {
		if(v.alterarQuantidade(cod_bar, novaQtd)) {
			carregarTabela();
		}
	}
}
