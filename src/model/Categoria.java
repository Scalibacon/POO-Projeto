package model;

public enum Categoria {
	SEM_CATEGORIA(0), PADARIA(1), HORTIFRUTI(2), LIMPEZA_DO_LAR(3), HIGIENE_PESSOAL(4), ALIMENTOS_PERECIVEIS(5),
		ALIMENTOS_NAO_PERECIVEIS(6), BEBIDAS_E_SUCOS(7), PAPELARIA(8), CONDIMENTOS(9), MASSAS(10), OLEOS(11),
			BRINQUEDOS(12);
	
	public int categoriaProduto;
	Categoria(int cat){
		categoriaProduto = cat;
	}
}
