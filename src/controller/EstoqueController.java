package controller;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;

import model.Produto;
import view.TelaCadastroProduto;

public class EstoqueController extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private String[] colunas = { "Nome do produto", "Categoria", "Pre\u00E7o", "Qtd Estoque", "Cód. Barras" };
	private List<Produto> produtos;
	private final int COLUNA_NOME = 0;
	private final int COLUNA_CATEGORIA = 1;
	private final int COLUNA_PRECO = 2;
	private final int COLUNA_QTD_ESTOQUE = 3;
	private final int COLUNA_COD_BARRAS = 4;

	public EstoqueController() {
		atualizarListaProdutos();
	}

	public void atualizarListaProdutos() {
		this.produtos = Help.lista_produtos;
	}

	public void excluirProduto(int row) {
		String cod_barras = (String) getValueAt(row, 4);
		Help.logado.excluirProduto(cod_barras);
		fireTableDataChanged();
	}
	
	public void adicionarOuAlterarProduto(Produto produto) {
		if (produto != null) {
			JDialog tela_add_produto = new TelaCadastroProduto(produto);
			tela_add_produto.setModal(true);
			tela_add_produto.setVisible(true);
		} else {
			JDialog tela_add_produto = new TelaCadastroProduto(null);
			tela_add_produto.setModal(true);
			tela_add_produto.setVisible(true);
		}
		fireTableDataChanged();
	}

	public Produto buscarProduto(String cod_barras) {
		for (Produto p : this.produtos) {
			if (p.getCod_barras().equals(cod_barras)) {
				return p;
			}
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return produtos.size();
	}

	@Override
	public String getColumnName(int indice) {
		return colunas[indice];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Produto produto = this.produtos.get(rowIndex);

		switch (columnIndex) {
		case COLUNA_NOME:
			return produto.getNome();
		case COLUNA_CATEGORIA:
			return produto.getCategoria();
		case COLUNA_PRECO:
			return produto.getPreco();
		case COLUNA_QTD_ESTOQUE:
			return produto.getQuantidade_estoque();
		case COLUNA_COD_BARRAS:
			return produto.getCod_barras();
		}
		return null;
	}
}
