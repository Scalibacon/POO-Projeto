package model;

import java.util.HashMap;
import java.util.Map;

public enum Categoria {
	SEM_CATEGORIA(0), PADARIA(1), HORTIFRUTI(2), LIMPEZA_DO_LAR(3), HIGIENE_PESSOAL(4), ALIMENTOS_PERECIVEIS(5),
	ALIMENTOS_NAO_PERECIVEIS(6), BEBIDAS_E_SUCOS(7), PAPELARIA(8), CONDIMENTOS(9), MASSAS(10), OLEOS(11),
	BRINQUEDOS(12);

	private static final Map<Integer, Categoria> map = new HashMap<Integer, Categoria>(values().length, 1);

	static {
		for (Categoria cat : values())
			map.put(cat.categoriaProduto, cat);
	}
	
	public int categoriaProduto;

	Categoria(int cat) {
		categoriaProduto = cat;
	}

	public int getValor() {
		return categoriaProduto;
	}

	public static Categoria buscaCategoria(int valor) {
		Categoria busca = map.get(valor);
		if (busca == null) {
			throw new IllegalArgumentException("Valor de categoria inválida: " + valor);
		}
		return busca;
	}

}
