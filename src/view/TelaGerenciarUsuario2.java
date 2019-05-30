package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class TelaGerenciarUsuario2 extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome, txtCpf, txtRua, txtNumero, txtCidade, txtEstado, txtTelefone, txtCelular, txtBairro,
			txtSenha;

	public TelaGerenciarUsuario2() {
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(180, 180, 180));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 800, 50);
		contentPane.add(panel);

		JLabel labelTitulo = new JLabel("GERENCIAR USU\u00C1RIOS");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(labelTitulo);

		JLabel lblPrivilgio = new JLabel("Privil\u00E9gio*");
		lblPrivilgio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrivilgio.setBounds(80, 100, 100, 30);
		contentPane.add(lblPrivilgio);

		JComboBox<?> cbPrivilegio = new JComboBox<Object>();
		cbPrivilegio.setBounds(215, 110, 110, 20);
		contentPane.add(cbPrivilegio);

		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(85, 185, 100, 35);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(215, 195, 275, 20);
		contentPane.add(txtNome);

		JLabel lblCpf = new JLabel("CPF*");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(80, 140, 100, 30);
		contentPane.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(215, 150, 110, 20);
		contentPane.add(txtCpf);

		JLabel lblRua = new JLabel("Rua*");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRua.setBounds(80, 300, 125, 30);
		contentPane.add(lblRua);

		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(225, 315, 275, 20);
		contentPane.add(txtRua);

		JLabel lblNmero = new JLabel("N\u00FAmero*");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmero.setBounds(510, 305, 125, 30);
		contentPane.add(lblNmero);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(605, 315, 60, 20);
		contentPane.add(txtNumero);

		JLabel lblBairro = new JLabel("Cidade*");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBairro.setBounds(82, 390, 124, 32);
		contentPane.add(lblBairro);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(225, 400, 275, 20);
		contentPane.add(txtCidade);

		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstado.setBounds(80, 435, 125, 30);
		contentPane.add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setBounds(225, 445, 275, 20);
		contentPane.add(txtEstado);

		JLabel lblTelefone = new JLabel("Telefone*");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(80, 480, 125, 30);
		contentPane.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(225, 490, 140, 20);
		contentPane.add(txtTelefone);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCelular.setBounds(80, 520, 125, 30);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(225, 530, 135, 20);
		contentPane.add(txtCelular);

		JLabel lblCidade = new JLabel("Bairro*");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCidade.setBounds(80, 350, 125, 30);
		contentPane.add(lblCidade);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(225, 360, 275, 20);
		contentPane.add(txtBairro);

		JLabel lblSenha = new JLabel("Senha*");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(80, 225, 100, 30);
		contentPane.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(215, 236, 110, 20);
		contentPane.add(txtSenha);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(65, 80, 655, 200);
		contentPane.add(tabbedPane);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(65, 300, 655, 265);
		contentPane.add(tabbedPane_1);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(270, 600, 100, 25);
		contentPane.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(435, 600, 105, 25);
		contentPane.add(btnCancelar);
	}
}