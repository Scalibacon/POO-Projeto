package controller;

import model.Administrador;
import model.Estoquista;

public class CadastroUsuarioController {
	
	public void adicionarNovoUsuario(Estoquista est) {
		if(Help.logado instanceof Administrador) {
			System.out.println("AddNewUser");
			((Administrador) Help.logado).criarUsuario(est);
		}
	}
	
	public void alterarUsuario(String cpf) {
		System.out.println("Alteração ainda não implementada");
	}
}
