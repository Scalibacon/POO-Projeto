package controller;

import javax.swing.JOptionPane;

import model.Produto;

public class CadastroProdutoController {

	public void adicionarNovoProduto(Produto p) {
		Help.logado.adicionarProduto(p);
	}

	public void alterarProduto(Produto p, String cod_barras) {
		if (JOptionPane.showConfirmDialog(null, "Deseja mesmo alterar esse produto?") == 0) {
			Help.logado.alterarProduto(p, cod_barras);
		}
	}
}
