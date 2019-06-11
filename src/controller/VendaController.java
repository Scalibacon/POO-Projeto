package controller;

import java.util.Calendar;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Caixa;
import model.ItemVenda;
import model.SituacaoVenda;
import model.Venda;

public class VendaController extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private String[] colunas = { "Nome do produto", "Cód. Barras", "Preço Unit.", "Qtde", "Subtotal"};
	private Venda v = new Venda();
	private List<ItemVenda> itens_venda = v.getListaItens();
	private final int COLUNA_NOME = 0;
	private final int COLUNA_COD_BARRAS = 1;
	private final int COLUNA_PRECO_UNIT = 2;
	private final int COLUNA_QTDE = 3;
	private final int COLUNA_SUBTOTAL = 4;

	public void adicionarItemVenda(String cod_barras) {		
		if(cod_barras.length() > 0 && v.adicionarItem(cod_barras, 1)) {
			fireTableDataChanged();
		}else {
			System.out.println("Código de barras não encontrado... :(");
		}		
	}
	
	public void removerItemVenda(String cod_bar) {
		if(v.removerItem(cod_bar)) {
			fireTableDataChanged();
		}else {
			System.out.println("Não foi possível remover o produto... :(");
		}
	}
	
	public void finalizarVenda() {
		if(Help.logado instanceof Caixa) {
			v.setData(Calendar.getInstance());
			v.setSituacao(SituacaoVenda.CONCLUIDA);
			v.setFuncionario(Help.logado);
			((Caixa) Help.logado).realizarVenda(v);
		}
		System.out.println("Venda realizada com sucesso");
	}
	
	public double calcularTotal() {
		return v.calcularTotal();
	}

	public void alterarQuantidade(String cod_bar, int novaQtd) {
		if(v.alterarQuantidade(cod_bar, novaQtd)) {
			fireTableDataChanged();
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
		case COLUNA_PRECO_UNIT:
			return iv.getProduto().getPreco();
		case COLUNA_QTDE:
			return iv.getQuantidade_produto();
		case COLUNA_SUBTOTAL:
			return iv.getSubtotal();
		}
		return null;
	}
}
