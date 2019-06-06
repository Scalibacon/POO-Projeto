package dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import model.AlteracaoEstoque;
import model.Estoquista;

public interface AlteracaoEstoqueDAO {
	List<AlteracaoEstoque> buscarTodasAlteracoes() throws SQLException;

	Estoquista buscarAlteracaoPorPeriodo(Calendar inicio, Calendar fim) throws SQLException;

	void inserirAlteracao(AlteracaoEstoque ae) throws SQLException;

	void alterarAlteracao(int id) throws SQLException;

	void excluirAlteracao(int id) throws SQLException;
}
