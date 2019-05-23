package model;

public class ItemVenda {
	
	public int getQuantidade_produto() {
		return quantidade_produto;
	}
	public void setQuantidade_produto(int quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	private int quantidade_produto;
	private double subtotal;

}
