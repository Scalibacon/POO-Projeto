package model;

import javax.swing.JDialog;

import view.TelaVenda;

public class Caixa extends Estoquista{
	
	public void realizarVenda(){
		JDialog tela_venda = new TelaVenda();
		tela_venda.setModal(true);
		tela_venda.setVisible(true);
	}

}
