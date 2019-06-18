package dao;

import java.util.Calendar;
import java.util.List;

import model.ProdutoMaisVendido;
import model.Venda;

public interface VendaDAO {
	List<Venda> buscarTodasVendas() throws DAOException;

	Venda buscarVenda(int id) throws DAOException;

	void inserirVenda(Venda v) throws DAOException;

	void alterarVenda(int id) throws DAOException;

	void excluirVenda(int id) throws DAOException;
	
	List<Venda> buscarVendasPorPeriodo(Calendar inicio, Calendar fim) throws DAOException;	
	
	public List<ProdutoMaisVendido> buscarProdutosMaisVendidos(Calendar inicio, Calendar fim) throws DAOException;
	
}
