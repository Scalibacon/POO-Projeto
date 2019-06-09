package controller;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;

import dao.DAOException;
import dao.FuncionarioDAO;
import dao.FuncionarioDAOImpl;
import model.Administrador;
import model.Estoquista;
import view.TelaCadastroUsuario;

public class GerenciarUsuarioController extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String[] colunas = { "Nome", "CPF", "Tipo", "Telefone"};
	private List<Estoquista> usuarios;
	private final int COLUNA_NOME = 0;
	private final int COLUNA_CPF = 1;
	private final int COLUNA_TIPO = 2;
	private final int COLUNA_TELEFONE = 3;
	private FuncionarioDAO funcDAO;

	public GerenciarUsuarioController() {
		atualizarListausuarios();
	}

	public void atualizarListausuarios() {
		funcDAO = new FuncionarioDAOImpl();
		try {
			this.usuarios = funcDAO.buscarTodosFuncionarios();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public void excluirUsuario(int row) {
		String cpf = (String) getValueAt(row, 1);
		if(Help.logado instanceof Administrador) {
			((Administrador) Help.logado).excluirUsuário(cpf);
		}
		fireTableDataChanged();
	}
	
	public void adicionarOuAlterarUsuario(Estoquista est) {
		if (est != null) {
			JDialog tela_add_estoquista = new TelaCadastroUsuario(est);
			tela_add_estoquista.setModal(true);
			tela_add_estoquista.setVisible(true);
		} else {
			System.out.println("Cadastrar");
			JDialog tela_add_estoquista = new TelaCadastroUsuario(null);
			tela_add_estoquista.setModal(true);
			tela_add_estoquista.setVisible(true);
		}
		fireTableDataChanged();
	}	

	public Estoquista buscarUsuario(String cpf) {
		for (Estoquista e : this.usuarios) {
			if (e.getCpf().equals(cpf)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return usuarios.size();
	}

	public String getColumnName(int indice) {
		return colunas[indice];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Estoquista estoquista = this.usuarios.get(rowIndex);

		switch (columnIndex) {
		case COLUNA_NOME:
			return estoquista.getNome();
		case COLUNA_CPF:
			return estoquista.getCpf();
		case COLUNA_TIPO:
			return estoquista.getPrivilegio();
		case COLUNA_TELEFONE:
			return estoquista.getTelefone();

		}
		return null;
	}
}
