package model;

import java.util.Date;

public class AlteracaoEstoque {
	private Date data;
	private TipoAlteracao tipoAlt;
	private int quantidade;
	private Estoquista autor;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
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
}
