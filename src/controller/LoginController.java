package controller;

import model.Caixa;
import security.MD5;

public class LoginController {
	public static Caixa logado;
	
	public boolean logar(String cpf, String senha) {
		if (MD5.getMd5(cpf).equals("827ccb0eea8a706c4c34a16891f84e7b") && MD5.getMd5(senha).equals("827ccb0eea8a706c4c34a16891f84e7b")) {
			LoginController.logado.setNome("Usuário");
			System.out.println("Logou");
			return true;
		}else {
			System.out.println("Não logou");
			return false;
		}
	}
}
