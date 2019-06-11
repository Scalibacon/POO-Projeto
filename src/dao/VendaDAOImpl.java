package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Estoquista;
import model.SituacaoVenda;
import model.Venda;

public class VendaDAOImpl implements VendaDAO{

	@Override
	public List<Venda> buscarTodasVendas() throws DAOException {
		try {
			List<Venda> vendas = new ArrayList<Venda>();
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "SELECT v.id, v.dataCompra, v.situacao, v.total, f.nome, f.cpf " + 
					"FROM venda v " + 
					"INNER JOIN funcionario f " + 
					"ON v.funcionario_cpf = f.cpf";
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Venda venda = new Venda();
				venda.setId(rs.getInt("id"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getTimestamp("dataCompra"));
				venda.setData(cal);
				venda.setTotal(rs.getDouble("total"));
				Estoquista f = new Estoquista();
				f.setNome(rs.getString("nome"));
				f.setCpf(rs.getString("cpf"));
				venda.setFuncionario(f);
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
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "insert into venda(dataCompra, situacao, total, funcionario_cpf) " + 
					"values(?, ?, ?, ?)";
			PreparedStatement stm = conexao.prepareStatement(sql);
			
			stm.setDate(1, new java.sql.Date(v.getData().getTimeInMillis()));
			stm.setInt(2, v.getSituacao().getValor());
			stm.setDouble(3, v.getTotal());
			stm.setString(4, v.getFuncionario().getCpf());			

			stm.executeUpdate();
			System.out.println("Venda inserida com sucesso");
			
			sql = "SELECT MAX(id) as id FROM venda";
			stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if(rs.next())
				v.setId(rs.getInt("id"));
			
			conexao.close();
			ItemVendaDAO ivDAO = new ItemVendaDAOImpl();
			ivDAO.incluirItemVenda(v.getListaItens(), v.getId());
		} catch (SQLException e) {
			DAOException.mensagemConflitoPrimaryKey("ID da venda");
			e.printStackTrace();
		}
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
