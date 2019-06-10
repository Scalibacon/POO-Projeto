package controller;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import dao.DAOException;
import dao.ItemVendaDAO;
import dao.ItemVendaDAOImpl;
import dao.VendaDAO;
import dao.VendaDAOImpl;
import model.Administrador;
import model.ItemVenda;
import model.Venda;

public class ListarVendasController extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private String[] colunas = { "ID", "Data", "Funcionário", "Status", "Total"};
	private List<Venda> vendas;
	private final int COLUNA_ID = 0;
	private final int COLUNA_DATA = 1;
	private final int COLUNA_FUNCIONARIO = 2;
	private final int COLUNA_STATUS = 3;
	private final int COLUNA_TOTAL = 4;
	private VendaDAO venDAO;
	private ItemVendaDAO ivDAO;

	public ListarVendasController() {
		atualizarListaVendas();
	}

	public void atualizarListaVendas() {
		venDAO = new VendaDAOImpl();
		try {
			this.vendas = venDAO.buscarTodasVendas();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirVenda(int row) {
		int id_venda = (int) getValueAt(row, 1);
		if(Help.logado instanceof Administrador) {
			((Administrador) Help.logado).excluirVenda(id_venda);
		}
		atualizarListaVendas();
		fireTableDataChanged();
	}
	
	public Venda buscarVenda(int id) {
		for (Venda v : this.vendas) {
			if (v.getId() == id){
				return v;
			}
		}
		return null;
	}
	
	public List<ItemVenda> buscarItemVenda(int id_venda){
		ivDAO = new ItemVendaDAOImpl();
		try {
			return ivDAO.buscarItemVenda(id_venda);
		} catch (DAOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return vendas.size();
	}

	public String getColumnName(int indice) {
		return colunas[indice];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Venda ven = this.vendas.get(rowIndex);

		switch (columnIndex) {
		case COLUNA_ID:
			return ven.getId();
		case COLUNA_DATA:
			return ven.getData();
		case COLUNA_FUNCIONARIO:
			return ven.getFuncionario();
		case COLUNA_STATUS:
			return ven.getSituacao();
		case COLUNA_TOTAL:
			return ven.getTotal();

		}
		return null;
	}

	
}
