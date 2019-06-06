package dao;

import java.sql.SQLException;
import java.util.List;

import model.ItemVenda;

public interface ItemVendaDAO {
	List<ItemVenda> buscarItemVenda(int id_venda) throws SQLException;
	
	void incluirItemVenda(ItemVenda iv) throws SQLException;
	
	void excluirItemVenda(int id_venda, ItemVenda iv) throws SQLException;
}
