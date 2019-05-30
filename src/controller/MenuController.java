package controller;

import javax.swing.JDialog;

import view.TelaEstoque;
import view.TelaGerenciarUsuario;
import view.TelaRelatorio;
import view.TelaVenda;

public class MenuController {

	public void abrirModal(JDialog tela) {
		tela.setModal(true);
		tela.setVisible(true);
	}

	public boolean verificaPrivilegio(int requisito) {
		if (Help.logado.getPrivilegio() >= requisito)
			return true;
		else
			return false;
	}

	public void abrirEstoque() {
		JDialog tela = new TelaEstoque();
		abrirModal(tela);
	}

	public void abrirVenda() {
		if (verificaPrivilegio(1)) {
			JDialog tela = new TelaVenda();
			abrirModal(tela);
		} else {
			System.out.println("Desculpa " + Help.logado.getNome() + ", mas você não tem privilégios pra isso :(");
		}
	}

	public void abrirUsuarios() {
		if (verificaPrivilegio(2)) {
			JDialog tela = new TelaGerenciarUsuario();
			abrirModal(tela);
		} else {
			System.out.println("Desculpa " + Help.logado.getNome() + ", mas você não tem privilégios pra isso :(");
		}
	}

	public void abrirRelatorios() {
		if (verificaPrivilegio(2)) {
			JDialog tela = new TelaRelatorio();
			abrirModal(tela);
		} else {
			System.out.println("Desculpa " + Help.logado.getNome() + ", mas você não tem privilégios pra isso :(");
		}
	}
}
