package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produto;

public interface ProdutoDAO {
	List<Produto> buscarTodosProdutos() throws SQLException;

	Produto buscarProduto(String cod_barras) throws SQLException;

	void inserirProduto(Produto p) throws SQLException;

	void alterarProduto(String cod_barras) throws SQLException;

	void excluirProduto(String cod_barras) throws SQLException;

}
