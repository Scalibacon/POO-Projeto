package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.AlteracaoEstoque;
import model.Estoquista;

public class AlteracaoEstoqueDAOImpl implements AlteracaoEstoqueDAO {

	@Override
	public List<AlteracaoEstoque> buscarTodasAlteracoes() throws DAOException {
		try {
			List<AlteracaoEstoque> alts = new ArrayList<AlteracaoEstoque>();
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "select ae.data_alter, ae.tipo, ae.quantidade, f.nome, p.nome "
					+ "from alteracaoestoque ae inner join funcionario f "
					+ "on ae.funcionario_cpf = f.cpf inner join produto p"
					+ "on ae.produto_codigo_barras = p.codigo_barras";
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				
			}
			conexao.close();
			return alts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Estoquista buscarAlteracaoPorPeriodo(Calendar inicio, Calendar fim) throws DAOException {
		return null;
	}

	@Override
	public void inserirAlteracao(AlteracaoEstoque ae) throws DAOException {

	}

	@Override
	public void alterarAlteracao(int id) throws DAOException {

	}

	@Override
	public void excluirAlteracao(int id) throws DAOException {

	}

}
