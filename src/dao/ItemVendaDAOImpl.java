package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class ItemVendaDAOImpl implements ItemVendaDAO{

	@Override
	public List<ItemVenda> buscarItemVenda(int id_venda) throws DAOException {
		List<ItemVenda> itens_venda = new ArrayList<ItemVenda>();
		try {
			ItemVenda iv = new ItemVenda();
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "SELECT iv.produto_codigo_barras, iv.qtde_produto, iv.subtotal, p.nome "
					+ "FROM itemvenda iv INNER JOIN produto p "
					+ "ON iv.produto_codigo_barras = p.codigo_barras "
					+ "WHERE iv.venda_id = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setInt(1, id_venda);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				iv.setSubtotal(rs.getDouble("subtotal"));
				iv.setQuantidade_produto(rs.getInt("qtde_produto"));
				Produto p = new Produto();
				p.setCod_barras(rs.getString("produto_codigo_barras"));
				p.setNome(rs.getString("nome"));
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
	public void incluirItemVenda(ItemVenda iv, Venda v) throws DAOException {
		
	}

	@Override
	public void excluirItemVenda(int id_venda, ItemVenda iv) throws DAOException {
		
	}

}
