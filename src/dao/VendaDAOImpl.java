package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.SituacaoVenda;
import model.Venda;

public class VendaDAOImpl implements VendaDAO{

	@Override
	public List<Venda> buscarTodasVendas() throws DAOException {
		try {
			List<Venda> vendas = new ArrayList<Venda>();
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "SELECT v.id, v.dataCompra, v.situacao, v.total, f.nome " + 
					"FROM venda v " + 
					"INNER JOIN funcionario f " + 
					"ON v.funcionario_cpf = f.cpf";
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Venda venda = new Venda();
				venda.setId(rs.getInt("id"));
				venda.setData(rs.getDate("dataCompra"));
				venda.setTotal(rs.getDouble("total"));
				venda.setFuncionario(rs.getString("nome"));
				venda.setSituacao(SituacaoVenda.buscaSituacaoVenda(rs.getInt("situacao")));
				vendas.add(venda);
			}
			conexao.close();
			return vendas;
		} catch (SQLException e) {			
			e.printStackTrace();			
			return null;
		}
	}

	@Override
	public Venda buscarVenda(int id) throws DAOException {
		return null;
	}

	@Override
	public void inserirVenda(Venda v) throws DAOException {
		
	}

	@Override
	public void alterarVenda(int id) throws DAOException {
		
	}

	@Override
	public void excluirVenda(int id) throws DAOException {
		
	}

	@Override
	public List<Venda> buscarVendasPorPeriodo(Calendar inicio, Calendar fim) throws DAOException {
		return null;
	}

}
