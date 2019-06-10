package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.DAOException;
import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;

public class Venda {

	private int id;
	private double total;
	private Date data;
	private String funcionario;
	private SituacaoVenda situacao;
	private List<ItemVenda> listaItens = new ArrayList<ItemVenda>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
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


	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItemVenda> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<ItemVenda> listaItens) {
		this.listaItens = listaItens;
	}

	public double calcularTotal() {
		for (ItemVenda iv : this.getListaItens()) {
			this.total += iv.getProduto().getPreco() * iv.getQuantidade_produto();
		}
		return total;
	}

	public boolean adicionarItem(String cod_bar, int qtd) {
		for (ItemVenda iv : this.listaItens) {
			if (iv.getProduto().getCod_barras().equals(cod_bar)) {
				System.out.println("Produto já adicionado na lista :X");
				return false;
			}
		}
		try {
			ProdutoDAO proDAO = new ProdutoDAOImpl();
			Produto p = proDAO.buscarProduto(cod_bar);
			if (p.getCod_barras().equals(cod_bar)) {
				ItemVenda iv = new ItemVenda();
				iv.setProduto(p);
				iv.setQuantidade_produto(qtd);
				iv.calcularSubtotal();
				getListaItens().add(iv);
				return true;

			}
		} catch (DAOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean removerItem(String cod_bar) {
		for (ItemVenda iv : this.listaItens) {
			if (iv.getProduto().getCod_barras().equals(cod_bar)) {
				getListaItens().remove(iv);
				return true;
			}
		}
		return false;
	}

	public boolean alterarQuantidade(String cod_bar, int novaQtd) {
		for (ItemVenda iv : this.listaItens) {
			if (iv.getProduto().getCod_barras().equals(cod_bar)) {
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
