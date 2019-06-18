package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dao.DAOException;
import dao.VendaDAO;
import dao.VendaDAOImpl;
import model.ProdutoMaisVendido;

public class RelatorioController {
	public List<ProdutoMaisVendido> buscarProdutosMaisVendidos(Calendar inicio, Calendar fim){
		List<ProdutoMaisVendido> mais_vendidos = new ArrayList<ProdutoMaisVendido>();
		VendaDAO venDAO = new VendaDAOImpl();
		try {
			mais_vendidos = venDAO.buscarProdutosMaisVendidos(inicio, fim);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return mais_vendidos;
	}
}
