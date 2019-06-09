package model;

import java.util.HashMap;
import java.util.Map;

public enum Privilegio {
	ESTOQUISTA(0), CAIXA(1), ADMINISTRADOR(2);

	private static final Map<Integer, Privilegio> map = new HashMap<Integer, Privilegio>(values().length, 1);
	
	static {
		for (Privilegio priv : values())
			map.put(priv.privilegio, priv);
	}
	
	public int privilegio;

	Privilegio(int priv) {
		privilegio = priv;
	}

	public int getValor() {
		return privilegio;
	}
	
	public static Privilegio buscaPrivilegio(int valor) {
		Privilegio busca = map.get(valor);
		if (busca == null) {
			throw new IllegalArgumentException("Valor de Privilegio inválida: " + valor);
		}
		return busca;
	}
}
