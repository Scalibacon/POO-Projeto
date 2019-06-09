package dao;

import java.util.Calendar;
import java.util.List;

import model.AlteracaoEstoque;
import model.Estoquista;

public interface AlteracaoEstoqueDAO {
	List<AlteracaoEstoque> buscarTodasAlteracoes() throws DAOException;

	Estoquista buscarAlteracaoPorPeriodo(Calendar inicio, Calendar fim) throws DAOException;

	void inserirAlteracao(AlteracaoEstoque ae) throws DAOException;

	void alterarAlteracao(int id) throws DAOException;

	void excluirAlteracao(int id) throws DAOException;
}
