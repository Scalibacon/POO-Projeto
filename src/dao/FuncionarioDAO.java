package dao;

import java.util.List;

import model.Estoquista;

public interface FuncionarioDAO {
	List<Estoquista> buscarTodosFuncionarios() throws DAOException;
	
	Estoquista buscarFuncionario(String cpf) throws DAOException;
	
	void inserirFuncionario(Estoquista est) throws DAOException;
	
	void alterarFuncionario(Estoquista est, String cpf) throws DAOException;
	
	void excluirFuncionario(String cpf) throws DAOException;
}
