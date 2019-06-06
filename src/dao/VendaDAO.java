package dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import model.Venda;

public interface VendaDAO {
	List<Venda> buscarTodasVendas() throws SQLException;

	Venda buscarVenda(int id) throws SQLException;

	void inserirVenda(Venda v) throws SQLException;

	void alterarVenda(int id) throws SQLException;

	void excluirVenda(int id) throws SQLException;
	
	List<Venda> buscarVendasPorPeriodo(Calendar inicio, Calendar fim) throws SQLException;
}
