package controller;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Estoquista;
import view.TelaGerenciarUsuario2;

public class GerenciarUsuarioController extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tabela;
	private String[] colunas = {"Nome", "CPF", "Tipo", "Telefone"};
	private List<Estoquista> estoquista;
	private final int COLUNA_NOME = 0;
	private final int COLUNA_CPF = 1;
	private final int COLUNA_TIPO = 2;
	private final int COLUNA_TELEFONE = 3;
	
	
	public GerenciarUsuarioController(JTable tabela) {
		this.tabela = tabela;
	}

	public void limparTabela() {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);
	}
	
	public void adicionarOuAlterarUsuario(Estoquista e) {
		if (e != null) {
			JDialog tela_add_estoquista = new TelaGerenciarUsuario2();
			tela_add_estoquista.setModal(true);
			tela_add_estoquista.setVisible(true);
		} else {
			JDialog tela_add_estoquista = new TelaGerenciarUsuario2();
			tela_add_estoquista.setModal(true);
			tela_add_estoquista.setVisible(true);
		}
		fireTableDataChanged();
	}
	
	public void excluirUsuario(int row) {
		String cpf = (String) getValueAt(row, 2);
		//Help.logado.excluirUsuario(cpf);
		fireTableDataChanged();
	}
	
	public Estoquista buscarUsuario(String cpf) {
		for (Estoquista e : this.estoquista) {
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
		return estoquista.size();
	}
	
	public String getColumnName(int indice) {
		return colunas[indice];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Estoquista estoquista = this.estoquista.get(rowIndex);

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
