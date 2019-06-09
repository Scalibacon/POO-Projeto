package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DAOException;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import model.Administrador;
import model.Caixa;
import model.Estoquista;
import security.MD5;
import view.TelaMenu;

public class LoginController {
	private FuncionarioDAO funcDAO;
	private List<Estoquista> listaUsers = new ArrayList<Estoquista>();

	public boolean logar(String cpf, String senha) {
		funcDAO = new FuncionarioDAOImpl();
		try {
			listaUsers = funcDAO.buscarTodosFuncionarios();
		} catch (DAOException e1) {
			e1.printStackTrace();
		}
		for (Estoquista e : listaUsers) {
			System.out.println("CPF -> " + e.getCpf() + " - " + cpf
					+ "/nSenha -> " + e.getSenha() + " - " + MD5.getMd5(senha));
			if (cpf.equals(e.getCpf()) && MD5.getMd5(senha).equals(e.getSenha())) {
				Estoquista est;

				switch (e.getPrivilegio()) {
				case ESTOQUISTA:
					est = new Estoquista();
					break;
				case CAIXA:
					est = new Caixa();
					break;
				case ADMINISTRADOR:
					est = new Administrador();
					break;
				default:
					est = new Estoquista();
				}

				est = e;
				Help.logado = est;
				TelaMenu menu = new TelaMenu();
				menu.setVisible(true);
				return true;
			}
		}

		System.out.println("Não logou");
		return false;
	}
}
