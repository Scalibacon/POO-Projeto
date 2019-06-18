package model;

public class ProdutoMaisVendido {
	private Produto produto;
	private int vezes_comprado;
	private int qtde_comprada;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getVezes_comprado() {
		return vezes_comprado;
	}
	public void setVezes_comprado(int vezes_comprado) {
		this.vezes_comprado = vezes_comprado;
	}
	public int getQtde_comprada() {
		return qtde_comprada;
	}
	public void setQtde_comprada(int qtde_comprada) {
		this.qtde_comprada = qtde_comprada;
	}
}
