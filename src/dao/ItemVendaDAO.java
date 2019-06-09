package dao;

import java.util.List;

import model.ItemVenda;

public interface ItemVendaDAO {
	List<ItemVenda> buscarItemVenda(int id_venda) throws DAOException;
	
	void incluirItemVenda(ItemVenda iv) throws DAOException;
	
	void excluirItemVenda(int id_venda, ItemVenda iv) throws DAOException;
}
