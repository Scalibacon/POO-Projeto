package model;

public class ItemVenda {
	
	private int quantidade_produto;
	private double subtotal;
	private Produto produto;
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade_produto() {
		return quantidade_produto;
	}
	public void setQuantidade_produto(int quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	}
	public double calcularSubtotal() {
		this.subtotal = this.quantidade_produto * this.produto.getPreco();		
		return subtotal;
	}
}
