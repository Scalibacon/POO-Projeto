package model;

import java.util.HashMap;
import java.util.Map;

public enum SituacaoVenda {
	CONCLUIDA(0), ALTERADA(1), EXCLUIDA(2);
	
	private static final Map<Integer, SituacaoVenda> map = new HashMap<Integer, SituacaoVenda>(values().length, 1);
	
	static {
		for (SituacaoVenda sit : values())
			map.put(sit.situacaoVenda, sit);
	}
	
	public int situacaoVenda;
	SituacaoVenda(int situacao) {
		situacaoVenda = situacao;
	}
	
	public int getValor(){
        return situacaoVenda;
    }
	
	public static SituacaoVenda buscaSituacaoVenda(int valor) {
		SituacaoVenda busca = map.get(valor);
		if (busca == null) {
			throw new IllegalArgumentException("Valor de SituacaoVenda inválida: " + valor);
		}
		return busca;
	}
}
