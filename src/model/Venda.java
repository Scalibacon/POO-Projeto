package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

	private double total;
	private Date data;
	private SituacaoVenda situacao;
	private List<ItemVenda> lista_produtos = new ArrayList<ItemVenda>();

	public double getTotal() {
		return total;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setSituacao(SituacaoVenda situacao) {
		this.situacao = situacao;
	}

	public SituacaoVenda getSituacao() {
		return situacao;
	}

	public List<ItemVenda> getLista_produtos() {
		return lista_produtos;
	}

	public void setLista_produtos(List<ItemVenda> lista_produtos) {
		this.lista_produtos = lista_produtos;
	}
	
	public void calcularTotal() {
		for(ItemVenda iv : this.getLista_produtos()) {
			this.total += iv.getProduto().getPreco() * iv.getQuantidade_produto();
		}
	}

	public void adicionarItem(String cod_bar, int qtd) {

	}

	public void removerItem(ItemVenda iv) {

	}

	public void alterarQuantidade(ItemVenda iv, int novaQtd) {

	}

	public void subtrairVendaDoEstoque() {

	}

	public void emitirNotaFiscal() {

	}
}
