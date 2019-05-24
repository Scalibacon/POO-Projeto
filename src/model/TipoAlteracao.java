package model;

public enum TipoAlteracao {
	ADICIONAR(1), SUBTRAIR(2);

	public int tipoAlteracao;

	TipoAlteracao(int tipo) {
		tipoAlteracao = tipo;
	}
}
