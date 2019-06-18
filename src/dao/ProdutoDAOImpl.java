package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import model.Categoria;

public class ProdutoDAOImpl implements ProdutoDAO {

	@Override
	public List<Produto> buscarTodosProdutos() throws DAOException {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "SELECT * FROM produto ORDER BY nome";
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setNome(rs.getString("nome"));
				produto.setCod_barras(rs.getString("codigo_barras"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade_estoque(rs.getInt("qtde_estoque"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCategoria(Categoria.buscaCategoria(rs.getInt("categoria")));
				produtos.add(produto);
			}
			conexao.close();
			return produtos;
		} catch (SQLException e) {			
			e.printStackTrace();			
			return null;
		}
	}

	@Override
	public Produto buscarProduto(String cod_barras) throws DAOException {
		try {
			Produto produto = new Produto();
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "SELECT codigo_barras, nome, categoria, preco, qtde_estoque, descricao FROM produto "
					+ "WHERE codigo_barras = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, cod_barras);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				produto.setNome(rs.getString("nome"));
				produto.setCod_barras(rs.getString("codigo_barras"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade_estoque(rs.getInt("qtde_estoque"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setCategoria(Categoria.buscaCategoria(rs.getInt("categoria")));
			}
			conexao.close();
			return produto;
		} catch (SQLException e) {			
			e.printStackTrace();			
			return null;
		}
	}

	@Override
	public void inserirProduto(Produto p) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "insert into produto(codigo_barras, nome, categoria, preco, qtde_estoque, descricao)"
					+ "VALUES(?,?,?,?,?,?)";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, p.getCod_barras());
			stm.setString(2, p.getNome());
			stm.setInt(3, p.getCategoria().getValor());
			stm.setDouble(4, p.getPreco());
			stm.setInt(5, p.getQuantidade_estoque());
			stm.setString(6, p.getDescricao());

			stm.executeUpdate();
			System.out.println("Produto inserido com sucesso");
			conexao.close();
		} catch (SQLException e) {
			DAOException.mensagemConflitoPrimaryKey("Código de Barras");
			e.printStackTrace();
		}
	}

	@Override
	public void alterarProduto(Produto p, String cod_barras) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "UPDATE produto SET codigo_barras = ?, nome = ?, categoria = ?, preco = ?, "
					+ "qtde_estoque = ?, descricao = ? "
					+ "WHERE codigo_barras = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, p.getCod_barras());
			stm.setString(2, p.getNome());
			stm.setInt(3, p.getCategoria().getValor());
			stm.setDouble(4, p.getPreco());
			stm.setInt(5, p.getQuantidade_estoque());
			stm.setString(6, p.getDescricao());
			stm.setString(7, cod_barras);
			
			stm.executeUpdate();
			System.out.println("Produto alterado com sucesso");
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluirProduto(String cod_barras) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "DELETE FROM produto WHERE codigo_barras = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, cod_barras);
			stm.executeUpdate();
			System.out.println("Produto excluído com sucesso");
			conexao.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removerDoEstoque(String cod_barras, int qtde) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "update produto set qtde_estoque = qtde_estoque - ? where codigo_barras = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, qtde);
			stm.setString(2, cod_barras);
			stm.executeUpdate();
			conexao.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionarAoEstoque(String cod_barras, int qtde) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "update produto set qtde_estoque = qtde_estoque + ? where codigo_barras = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, qtde);
			stm.setString(2, cod_barras);
			stm.executeUpdate();
			conexao.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
