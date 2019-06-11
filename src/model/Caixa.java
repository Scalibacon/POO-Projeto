package model;

import dao.DAOException;
import dao.VendaDAO;
import dao.VendaDAOImpl;

public class Caixa extends Estoquista{
	
	public void realizarVenda(Venda v){
		VendaDAO venDAO = new VendaDAOImpl();
		try {
			venDAO.inserirVenda(v);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

}
