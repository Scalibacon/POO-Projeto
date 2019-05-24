package controller;

import model.Estoquista;
import security.MD5;
import view.TelaMenu;

public class LoginController {

	public boolean logar(String cpf, String senha) {
		for (Estoquista e : Help.lista_usuarios) {
			if (MD5.getMd5(cpf).equals(MD5.getMd5(e.getCpf()))
					&& MD5.getMd5(senha).equals(MD5.getMd5(e.getSenha()))) {
				Help.logado = e;
				TelaMenu menu = new TelaMenu();
				menu.setVisible(true);
				return true;
			}
		}


		System.out.println("Não logou");
		return false;
	}
}
