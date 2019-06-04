package controller;

import model.Produto;

public class CadastroProdutoController {
	public void adicionarNovoProduto(Produto p) {
		Help.logado.adicionarProduto(p);
	}
	
	public void alterarProduto(String cod_barras) {
		System.out.println("Alteração ainda não implementada");
	}
}
