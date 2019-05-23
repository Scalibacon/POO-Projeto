package model;

public enum SituacaoVenda {
	CONCLUIDA(1), ALTERADA(2), EXCLUIDA(3);
	
	public int situacaoVenda;
	SituacaoVenda(int situacao) {
		situacaoVenda = situacao;
	}
}
