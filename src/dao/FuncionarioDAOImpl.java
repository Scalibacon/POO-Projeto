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
				est.setNumero(rs.getInt("numero"));
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
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "insert into funcionario(cpf, nome, senha, rua, numero, bairro, cidade, estado, telefone, "
					+ "privilegio) VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, est.getCpf());
			stm.setString(2, est.getNome());
			stm.setString(3, est.getSenha());
			stm.setString(4, est.getRua());
			stm.setInt(5, est.getNumero());
			stm.setString(6, est.getBairro());
			stm.setString(7, est.getCidade());
			stm.setString(8, est.getEstado());
			stm.setString(9, est.getTelefone());
			stm.setInt(10, est.getPrivilegio().getValor());

			stm.executeUpdate();
			System.out.println("Usuário inserido com sucesso");
			conexao.close();
		} catch (SQLException e) {
			DAOException.mensagemConflitoPrimaryKey("CPF");
			e.printStackTrace();
		}

	}

	@Override
	public void alterarFuncionario(Estoquista est, String cpf) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "UPDATE funcionario SET cpf = ?, nome = ?, senha = ?, rua = ?, numero = ?, bairro = ?, "
					+ "cidade = ?, estado = ?, telefone = ?, privilegio = ? "
					+ "WHERE cpf = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, est.getCpf());
			stm.setString(2, est.getNome());
			stm.setString(3, est.getSenha());
			stm.setString(4, est.getRua());
			stm.setInt(5, est.getNumero());
			stm.setString(6, est.getBairro());
			stm.setString(7, est.getCidade());
			stm.setString(8, est.getEstado());
			stm.setString(9, est.getTelefone());
			stm.setInt(10, est.getPrivilegio().getValor());
			stm.setString(11, cpf);
			
			stm.executeUpdate();
			System.out.println("Usuário alterado com sucesso");
			conexao.close();
		} catch (SQLException e) {

		}

	}

	@Override
	public void excluirFuncionario(String cpf) throws DAOException {
		try {
			Connection conexao = ConnectionDB.getInstancia().conectar();
			String sql = "DELETE FROM funcionario WHERE cpf = ?";
			PreparedStatement stm = conexao.prepareStatement(sql);
			stm.setString(1, cpf);
			stm.executeUpdate();
			System.out.println("Funcionário excluído com sucesso");
			conexao.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
