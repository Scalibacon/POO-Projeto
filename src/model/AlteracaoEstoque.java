package model;

import java.util.Calendar;

public class AlteracaoEstoque {
	private Calendar data;
	private TipoAlteracao tipoAlt;
	private int quantidade;
	private Estoquista autor;
	private Produto produto;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public TipoAlteracao getTipoAlt() {
		return tipoAlt;
	}
	public void setTipoAlt(TipoAlteracao tipoAlt) {
		this.tipoAlt = tipoAlt;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Estoquista getAutor() {
		return autor;
	}
	public void setAutor(Estoquista autor) {
		this.autor = autor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
}
