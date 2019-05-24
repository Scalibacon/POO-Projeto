package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Estoquista;

public class GerenciarUsuarioController {
	private JTable tabela;

	public GerenciarUsuarioController(JTable tabela) {
		this.tabela = tabela;
	}

	public void iniciarTabela() {
		tabela.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Tipo", "Telefone" }));

		tabela.getColumnModel().getColumn(0).setPreferredWidth(180);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
	}

	public void carregarTabela() {
		limparTabela();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		for (Estoquista user : Help.lista_usuarios) {
			String privilegio = "";
			if (user.getPrivilegio() == 0)
				privilegio = "Estoquista";
			else if (user.getPrivilegio() == 1)
				privilegio = "Caixa";
			else if (user.getPrivilegio() == 2)
				privilegio = "Administrador";

				model.addRow(new Object[] { user.getNome(), user.getCpf(), privilegio, user.getTelefone()});
		}
	}

	public void limparTabela() {
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();
		model.setRowCount(0);
	}
}
