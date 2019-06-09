package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Estoquista;
import model.Privilegio;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	@Override
	public List<Estoquista> buscarTodosFuncionarios() throws DAOException {
		try {
			List<Estoquista> funcionarios = new ArrayList<Estoquista>();
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "SELECT * FROM funcionario ORDER BY nome";
			PreparedStatement stm = conexao.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Estoquista est = new Estoquista();
				est.setCpf(rs.getString("cpf"));
				est.setNome(rs.getString("nome"));
				est.setSenha(rs.getString("senha"));
				est.setRua(rs.getString("rua"));
				est.setBairro(rs.getString("bairro"));
				est.setCidade(rs.getString("cidade"));
				est.setEstado(rs.getString("estado"));
				est.setTelefone(rs.getString("telefone"));
				est.setPrivilegio(Privilegio.buscaPrivilegio(rs.getInt("privilegio")));
				funcionarios.add(est);
			}
			conexao.close();
			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Estoquista buscarFuncionario(String cpf) throws DAOException {
		return null;
	}

	@Override
	public void inserirFuncionario(Estoquista est) throws DAOException {

	}

	@Override
	public void alterarFuncionario(String cpf) throws DAOException {

	}

	@Override
	public void excluirFuncionario(String cpf) throws DAOException {

	}

}
