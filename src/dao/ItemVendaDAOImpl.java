package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ItemVenda;
import model.Produto;

public class ItemVendaDAOImpl implements ItemVendaDAO {

	@Override
	public List<ItemVenda> buscarItemVenda(int id_venda) throws DAOException {
		List<ItemVenda> itens_venda = new ArrayList<ItemVenda>();
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "SELECT iv.produto_codigo_barras, iv.qtde_produto, iv.subtotal, p.nome, p.preco "
					+ "FROM itemvenda iv INNER JOIN produto p " + "ON iv.produto_codigo_barras = p.codigo_barras "
					+ "WHERE iv.venda_id = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, id_venda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ItemVenda iv = new ItemVenda();
				iv.setSubtotal(rs.getDouble("subtotal"));
				iv.setQuantidade_produto(rs.getInt("qtde_produto"));
				Produto p = new Produto();
				p.setCod_barras(rs.getString("produto_codigo_barras"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				iv.setProduto(p);
				itens_venda.add(iv);
			}
			conexao.close();
			return itens_venda;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void incluirItemVenda(List<ItemVenda> ivs, int id_venda) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			for (ItemVenda iv : ivs) {
				String sql = "insert into itemvenda(venda_id, produto_codigo_barras, qtde_produto, subtotal) "
						+ "	values (?, ?, ?, ?)";
				PreparedStatement stm = conexao.prepareStatement(sql);
				stm.setInt(1, id_venda);
				stm.setString(2, iv.getProduto().getCod_barras());
				stm.setInt(3, iv.getQuantidade_produto());
				stm.setDouble(4, iv.getSubtotal());

				stm.executeUpdate();
				System.out.println("ItemVenda inserido com sucesso");
			}
			conexao.close();
		} catch (SQLException e) {
			DAOException.mensagemConflitoPrimaryKey("ItemVenda");
			e.printStackTrace();
		}

	}

	@Override
	public void excluirItemVenda(int id_venda, ItemVenda iv) throws DAOException {

	}

}
