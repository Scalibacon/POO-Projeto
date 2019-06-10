package controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.ItemVenda;
import model.Venda;

public class VendaController extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private String[] colunas = { "Nome do produto", "Cód. Barras", "Qtde", "Subtotal"};
	private Venda v = new Venda();
	private List<ItemVenda> itens_venda = v.getListaItens();
	private final int COLUNA_NOME = 0;
	private final int COLUNA_COD_BARRAS = 1;
	private final int COLUNA_QTDE = 2;
	private final int COLUNA_SUBTOTAL = 3;

	public void adicionarItemVenda(String cod_barras) {		
		if(v.adicionarItem(cod_barras, 1)) {
			fireTableDataChanged();
		}else {
			System.out.println("Código de barras não encontrado... :(");
		}		
	}
	
	public void removerItemVenda(String cod_bar) {
		if(v.removerItem(cod_bar)) {
		}else {
			System.out.println("Não foi possível remover o produto... :(");
		}
	}
	
	public void finalizarVenda() {
		System.out.println("Venda realizada com sucesso");
	}

	public void alterarQuantidade(String cod_bar, int novaQtd) {
		if(v.alterarQuantidade(cod_bar, novaQtd)) {
			
		}
	}
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return itens_venda.size();
	}

	@Override
	public String getColumnName(int indice) {
		return colunas[indice];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ItemVenda iv = this.itens_venda.get(rowIndex);

		switch (columnIndex) {
		case COLUNA_NOME:
			return iv.getProduto().getNome();
		case COLUNA_COD_BARRAS:
			return iv.getProduto().getCod_barras();
		case COLUNA_QTDE:
			return iv.getQuantidade_produto();
		case COLUNA_SUBTOTAL:
			return iv.getSubtotal();
		}
		return null;
	}
}
