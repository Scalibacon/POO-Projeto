package dao;

import java.util.List;

import model.Produto;

public interface ProdutoDAO {
	List<Produto> buscarTodosProdutos() throws DAOException;

	Produto buscarProduto(String cod_barras) throws DAOException;

	void inserirProduto(Produto p) throws DAOException;

	void alterarProduto(Produto p, String cod_barras) throws DAOException;

	void excluirProduto(String cod_barras) throws DAOException;
	
	void removerDoEstoque(String cod_barras, int qtde) throws DAOException;
	
	public void adicionarAoEstoque(String cod_barras, int qtde) throws DAOException;
	
	public List<Produto> buscarFaltando() throws DAOException;

}
