package model;

import java.util.HashMap;
import java.util.Map;

public enum TipoAlteracao {
	ADICIONAR(0), SUBTRAIR(1);

	private static final Map<Integer, TipoAlteracao> map = new HashMap<Integer, TipoAlteracao>(values().length, 1);
	
	static {
		for (TipoAlteracao tipoAlt : values())
			map.put(tipoAlt.tipoAlteracao, tipoAlt);
	}
	
	public int tipoAlteracao;

	TipoAlteracao(int tipo) {
		tipoAlteracao = tipo;
	}
	
	public static TipoAlteracao buscaTipoAlteracao(int valor) {
		TipoAlteracao busca = map.get(valor);
		if (busca == null) {
			throw new IllegalArgumentException("Valor de TipoAlteracao inválida: " + valor);
		}
		return busca;
	}
}
