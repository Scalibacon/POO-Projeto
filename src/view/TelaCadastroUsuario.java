package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import controller.CadastroUsuarioController;
import model.Estoquista;
import model.Privilegio;
import security.MD5;

import javax.swing.JButton;

public class TelaCadastroUsuario extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtNome, txtCpf, txtRua, txtNumero, txtCidade, txtEstado, txtTelefone, txtBairro;
	private JComboBox<?> comboPrivilegio;
	private JButton btnConfirmar, btnCancelar;
	private CadastroUsuarioController controller = new CadastroUsuarioController();
	private Estoquista est;

	public TelaCadastroUsuario(Estoquista est) {
		this.est = est;
		
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		painel = new JPanel();
		painel.setBackground(new Color(180, 180, 180));
		setContentPane(painel);
		painel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 800, 50);
		painel.add(panel);

		JLabel labelTitulo = new JLabel("GERENCIAR USU\u00C1RIOS");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(labelTitulo);

		JLabel lblPrivilgio = new JLabel("Privil\u00E9gio*");
		lblPrivilgio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrivilgio.setBounds(90, 105, 100, 25);
		painel.add(lblPrivilgio);

		comboPrivilegio = new JComboBox<Object>(Privilegio.values());
		comboPrivilegio.setBounds(215, 105, 110, 25);
		painel.add(comboPrivilegio);

		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(90, 152, 100, 25);
		painel.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(215, 152, 275, 25);
		painel.add(txtNome);

		JLabel lblCpf = new JLabel("CPF*");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(90, 194, 100, 25);
		painel.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(215, 194, 275, 25);
		painel.add(txtCpf);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRua.setBounds(90, 230, 125, 25);
		painel.add(lblRua);

		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(215, 230, 275, 25);
		painel.add(txtRua);

		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmero.setBounds(508, 230, 125, 25);
		painel.add(lblNmero);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(602, 230, 60, 25);
		painel.add(txtNumero);

		JLabel lblBairro = new JLabel("Cidade");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBairro.setBounds(90, 308, 124, 25);
		painel.add(lblBairro);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(215, 308, 275, 25);
		painel.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstado.setBounds(90, 344, 125, 25);
		painel.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(215, 344, 275, 25);
		painel.add(txtEstado);

		JLabel lblTelefone = new JLabel("Telefone*");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(90, 380, 125, 25);
		painel.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(215, 380, 275, 25);
		painel.add(txtTelefone);

		JLabel lblCidade = new JLabel("Bairro");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCidade.setBounds(90, 268, 125, 25);
		painel.add(lblCidade);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(215, 268, 275, 25);
		painel.add(txtBairro);

		btnConfirmar = new JButton();
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setBounds(268, 487, 100, 25);
		btnConfirmar.addActionListener(this);
		painel.add(btnConfirmar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(433, 487, 105, 25);
		btnCancelar.addActionListener(this);
		painel.add(btnCancelar);
		
		if (est != null) {
			usuarioToTela(est);
			btnConfirmar.setText("Alterar");
			labelTitulo.setText("ALTERAR USUÁRIO");
			txtCpf.setEditable(false);
		} else {
			btnConfirmar.setText("Cadastrar");
			labelTitulo.setText("CADASTRAR USUÁRIO");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Apertou TCU");
		if (e.getSource() == btnConfirmar) {
			if (est == null) {
				System.out.println("TCU aqui1");
				controller.adicionarNovoUsuario(telaToUsuario());
			}else {
				controller.alterarUsuario(est.getCpf());
			}
			this.dispose();
		}
	}
	
	public Estoquista telaToUsuario() {
		Estoquista e = new Estoquista();
		e.setPrivilegio(((Privilegio) comboPrivilegio.getSelectedItem()));
		e.setNome(txtNome.getText());
		e.setCpf(txtCpf.getText());
		e.setRua(txtRua.getText());
		e.setNumero(Integer.parseInt(txtNumero.getText()));
		e.setBairro(txtBairro.getText());
		e.setCidade(txtCidade.getText());
		e.setEstado(txtEstado.getText());
		e.setTelefone(txtTelefone.getText());
		e.setSenha(gerarSenha(e.getCpf()));

		return e;
	}
	
	public void usuarioToTela(Estoquista e) {
		comboPrivilegio.setSelectedItem(e.getPrivilegio());
		txtNome.setText(e.getNome());
		txtCpf.setText(e.getCpf());
		txtRua.setText(e.getRua());
		txtNumero.setText(String.valueOf(e.getNumero()));
		txtBairro.setText(e.getBairro());
		txtCidade.setText(e.getCidade());
		txtEstado.setText(e.getEstado());
		txtTelefone.setText(e.getTelefone());
		
	}
	
	public String gerarSenha(String cpf) {
		String senha = MD5.getMd5(cpf.substring(0,2) + cpf.substring(9,10));
		return senha;
	}
}