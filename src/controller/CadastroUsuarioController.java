package controller;

import model.Administrador;
import model.Estoquista;

public class CadastroUsuarioController {
	
	public void adicionarNovoUsuario(Estoquista est) {
		if(Help.logado instanceof Administrador) {
			((Administrador) Help.logado).criarUsuario(est);
		}else {
			System.out.println("Desculpa, mas voc� n�o deveria ter acesso a essa fun��o >:(");
		}
	}
	
	public void alterarUsuario(Estoquista est, String cpf) {
		if(Help.logado instanceof Administrador) {
			((Administrador) Help.logado).alterarUsuario(est, cpf);
		}else {
			System.out.println("Desculpa, mas voc� n�o deveria ter acesso a essa fun��o >:(");
		}
	}
}
