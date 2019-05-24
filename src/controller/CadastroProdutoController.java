package controller;

import model.Produto;

public class CadastroProdutoController {
	public void adicionarNovoProduto(Produto p) {
		Help.logado.adicionarProduto(p);
	}
}
