package model;

import java.util.Date;

public class Venda {
	
	private double preco_produto;
	public double getPreco_produto() {
		return preco_produto;
	}
	public void setPreco_produto(double preco_produto) {
		this.preco_produto = preco_produto;
	}
	public int getQtd_produto() {
		return qtd_produto;
	}
	public void setQtd_produto(int qtd_produto) {
		this.qtd_produto = qtd_produto;
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
	private int qtd_produto;
	private double total;
	private Date data;

}
