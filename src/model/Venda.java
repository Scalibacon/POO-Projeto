package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.Help;

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
	
	public double calcularTotal() {
		for(ItemVenda iv : this.getLista_produtos()) {
			this.total += iv.getProduto().getPreco() * iv.getQuantidade_produto();
		}
		return total;
	}

	public boolean adicionarItem(String cod_bar, int qtd) {
		for(ItemVenda iv : this.lista_produtos) {
			if(iv.getProduto().getCod_barras().equals(cod_bar)) {
				System.out.println("Produto já adicionado na lista :X");
				return false;
			}
		}
		for (Produto p : Help.lista_produtos) {
			if (p.getCod_barras().equals(cod_bar)) {
				ItemVenda iv = new ItemVenda();
				iv.setProduto(p);
				iv.setQuantidade_produto(qtd);
				getLista_produtos().add(iv);
				return true;
			}
		}
		return false;
	}

	public boolean removerItem(String cod_bar) {
		for(ItemVenda iv : this.lista_produtos) {
			if(iv.getProduto().getCod_barras().equals(cod_bar)) {
				getLista_produtos().remove(iv);
				return true;
			}
		}
		return false;
	}

	public boolean alterarQuantidade(String cod_bar, int novaQtd) {
		for(ItemVenda iv : this.lista_produtos) {
			if(iv.getProduto().getCod_barras().equals(cod_bar)) {
				iv.setQuantidade_produto(novaQtd);
				return true;
			}
		}
		System.out.println("Não foi possível alterar a quantidade do produto... :(");
		return false;
	}

	public void subtrairVendaDoEstoque() {

	}

	public void emitirNotaFiscal() {

	}
}
