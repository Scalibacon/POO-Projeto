package model;

import dao.DAOException;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;

public class Administrador extends Caixa {

	public void alterarVenda() {

	}

	public void excluirVenda(int id_venda) {

	}

	public void criarUsuario(Estoquista est) {
		FuncionarioDAO funcDAO = new FuncionarioDAOImpl();
		try {
			funcDAO.inserirFuncionario(est);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void alterarUsuario(Estoquista est, String cpf) {
		FuncionarioDAO funcDAO = new FuncionarioDAOImpl();
		try {
			funcDAO.alterarFuncionario(est, cpf);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void excluirUsuário(String cpf) {
		FuncionarioDAO funcDAO = new FuncionarioDAOImpl();
		try {
			funcDAO.excluirFuncionario(cpf);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void visualizarRelatorioVendas() {

	}

	public void visualizarRelatorioEstoque() {

	}

}
