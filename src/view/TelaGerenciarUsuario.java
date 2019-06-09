package view;

import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.GerenciarUsuarioController;
import model.Estoquista;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaGerenciarUsuario extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTable tabela;
	private GerenciarUsuarioController controller;
	private JButton btnCriar, btnExcluir, btnAlterar;
	private JTextField txtNome, txtCpf, txtEndereco, txtBairro, txtCidade, txtTelefone, txtPrivilegio;

	public TelaGerenciarUsuario() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 620);
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 130, 130));
		panel.setBounds(0, 0, 935, 50);
		painel.add(panel);

		JLabel lblGerenciarUsuarios = new JLabel("GERENCIAR USU\u00C1RIOS");
		lblGerenciarUsuarios.setForeground(Color.WHITE);
		lblGerenciarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblGerenciarUsuarios);

		btnCriar = new JButton("Criar");		
		btnCriar.setBounds(10, 85, 90, 25);
		btnCriar.addActionListener(this);
		painel.add(btnCriar);

		btnAlterar = new JButton("Alterar");		
		btnAlterar.setBounds(245, 85, 90, 25);
		btnAlterar.addActionListener(this);
		btnAlterar.setEnabled(false);
		painel.add(btnAlterar);

		btnExcluir = new JButton("Excluir");		
		btnExcluir.setBounds(470, 85, 90, 25);
		btnExcluir.addActionListener(this);
		btnExcluir.setEnabled(false);
		painel.add(btnExcluir);

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 135, 550, 435);
		painel.add(scroll);

		tabela = new JTable();
		tabela.setBackground(Color.WHITE);
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(tabela.getSelectedRow());
				if (tabela.getSelectedRow() >= 0) {
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					carregarDetail(tabela.getSelectedRow());
				} else {
					btnAlterar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		scroll.setViewportView(tabela);
		atualizarTabela();

		JPanel painelDetail = new JPanel();
		painelDetail.setBackground(Color.WHITE);
		painelDetail.setBounds(570, 135, 355, 435);
		painel.add(painelDetail);
		painelDetail.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(10, 10, 125, 15);
		painelDetail.add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setBounds(10, 35, 335, 25);
		painelDetail.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpf.setBounds(10, 71, 125, 15);
		painelDetail.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpf.setColumns(10);
		txtCpf.setBounds(10, 96, 335, 25);
		painelDetail.add(txtCpf);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 274, 335, 25);
		painelDetail.add(txtEndereco);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEndereco.setBounds(10, 249, 125, 15);
		painelDetail.add(lblEndereco);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBairro.setColumns(10);
		txtBairro.setBounds(10, 338, 335, 25);
		painelDetail.add(txtBairro);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBairro.setBounds(10, 313, 125, 15);
		painelDetail.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(10, 374, 125, 15);
		painelDetail.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		txtCidade.setBounds(10, 399, 335, 25);
		painelDetail.add(txtCidade);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefone.setBounds(10, 188, 125, 15);
		painelDetail.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(10, 213, 335, 25);
		painelDetail.add(txtTelefone);

		txtPrivilegio = new JTextField();
		txtPrivilegio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrivilegio.setColumns(10);
		txtPrivilegio.setBounds(10, 152, 335, 25);
		painelDetail.add(txtPrivilegio);

		JLabel lblPrivilegio = new JLabel("Privil\u00E9gio");
		lblPrivilegio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrivilegio.setBounds(10, 127, 125, 15);
		painelDetail.add(lblPrivilegio);

	}

	public void atualizarTabela() {
		controller = new GerenciarUsuarioController();
		tabela.setModel(controller);
	}

	public void carregarDetail(int rowla) {
		Estoquista est = controller.buscarUsuario(tabela.getValueAt(rowla, 1).toString());
		txtNome.setText(est.getNome());
		txtCpf.setText(est.getCpf());
		txtEndereco.setText(est.getRua() + " nº " + est.getNumero());
		txtBairro.setText(est.getBairro());
		txtCidade.setText(est.getCidade() + " - " + est.getEstado());
		txtTelefone.setText(est.getTelefone());
		txtPrivilegio.setText(est.getPrivilegio().name());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCriar) {
			controller.adicionarOuAlterarUsuario(null);
		} else if (e.getSource() == btnAlterar) {
			Estoquista est = controller.buscarUsuario((String) controller.getValueAt(tabela.getSelectedRow(), 1));
			controller.adicionarOuAlterarUsuario(est);
		} else if (e.getSource() == btnExcluir) {
			if (JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir esse funcionário?") == 0) {
				controller.excluirUsuario(tabela.getSelectedRow());
			}
		}
	}

}