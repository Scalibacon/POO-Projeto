package dao;

import java.sql.SQLException;
import java.util.List;

import model.Estoquista;

public interface FuncionarioDAO {
	List<Estoquista> buscarTodosFuncionarios() throws SQLException;
	
	Estoquista buscarFuncionario(String cpf) throws SQLException;
	
	void inserirFuncionario(Estoquista est) throws SQLException;
	
	void alterarFuncionario(String cpf) throws SQLException;
	
	void excluirFuncionario(String cpf) throws SQLException;
}
