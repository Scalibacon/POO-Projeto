package controller;

import javax.swing.JDialog;

import model.Privilegio;
import view.TelaEstoque;
import view.TelaGerenciarUsuario;
import view.TelaListarVendas;
import view.TelaRelatorio;
import view.TelaVenda;

public class MenuController {

	public void abrirModal(JDialog tela) {
		tela.setModal(true);
		tela.setVisible(true);
	}

	public boolean verificaPrivilegio(Privilegio requisito) {
		if (Help.logado.getPrivilegio().getValor() >= requisito.getValor())
			return true;
		else
			return false;
	}

	public void abrirEstoque() {
		JDialog tela = new TelaEstoque();
		abrirModal(tela);
	}

	public void abrirVenda() {
		if (verificaPrivilegio(Privilegio.CAIXA)) {
			JDialog tela = new TelaVenda();
			abrirModal(tela);
		} else {
			System.out.println("Desculpa " + Help.logado.getNome() + ", mas você não tem privilégios pra isso :(");
		}
	}

	public void abrirUsuarios() {
		if (verificaPrivilegio(Privilegio.ADMINISTRADOR)) {
			JDialog tela = new TelaGerenciarUsuario();
			abrirModal(tela);
		} else {
			System.out.println("Desculpa " + Help.logado.getNome() + ", mas você não tem privilégios pra isso :(");
		}
	}

	public void abrirRelatorios() {
		if (verificaPrivilegio(Privilegio.ADMINISTRADOR)) {
			JDialog tela = new TelaRelatorio();
			abrirModal(tela);
		} else {
			System.out.println("Desculpa " + Help.logado.getNome() + ", mas você não tem privilégios pra isso :(");
		}
	}
	
	public void abrirListaVendas() {
		if (verificaPrivilegio(Privilegio.ADMINISTRADOR)) {
			JDialog tela = new TelaListarVendas();
			abrirModal(tela);
		} else {
			System.out.println("Desculpa " + Help.logado.getNome() + ", mas você não tem privilégios pra isso :(");
		}
	}
}
