package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class TelaGerenciarUsuario2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtBairro;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGerenciarUsuario2 frame = new TelaGerenciarUsuario2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaGerenciarUsuario2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 795, 50);
		contentPane.add(panel);
		
		JLabel label = new JLabel("GERENCIAR USU\u00C1RIOS");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(label);
		
		JLabel lblPrivilgio = new JLabel("Privil\u00E9gio*");
		lblPrivilgio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrivilgio.setBounds(82, 99, 98, 32);
		contentPane.add(lblPrivilgio);
		
		JComboBox<?> cbPrivilegio = new JComboBox<Object>();
		cbPrivilegio.setBounds(216, 109, 111, 20);
		contentPane.add(cbPrivilegio);
		
		JLabel label_2 = new JLabel("Nome*");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(82, 185, 98, 32);
		contentPane.add(label_2);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(216, 195, 273, 20);
		contentPane.add(txtNome);
		
		JLabel lblCpf = new JLabel("CPF*");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(82, 142, 98, 32);
		contentPane.add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		txtCPF.setBounds(216, 152, 111, 20);
		contentPane.add(txtCPF);
		
		JLabel lblRua = new JLabel("Rua*");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRua.setBounds(82, 304, 124, 32);
		contentPane.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(223, 314, 273, 20);
		contentPane.add(txtRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero*");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmero.setBounds(507, 304, 124, 32);
		contentPane.add(lblNmero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(605, 314, 61, 20);
		contentPane.add(txtNumero);
		
		JLabel lblBairro = new JLabel("Cidade*");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBairro.setBounds(82, 390, 124, 32);
		contentPane.add(lblBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(223, 400, 273, 20);
		contentPane.add(txtCidade);
		
		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstado.setBounds(82, 434, 124, 32);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(223, 444, 273, 20);
		contentPane.add(txtEstado);
		
		JLabel lblTelefone = new JLabel("Telefone*");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(82, 478, 124, 32);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(223, 488, 137, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCelular.setBounds(82, 518, 124, 32);
		contentPane.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(223, 528, 137, 20);
		contentPane.add(txtCelular);
		
		JLabel lblCidade = new JLabel("Bairro*");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCidade.setBounds(82, 347, 124, 32);
		contentPane.add(lblCidade);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(223, 357, 273, 20);
		contentPane.add(txtBairro);
		
		JLabel lblSenha = new JLabel("Senha*");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(82, 226, 98, 32);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(216, 236, 111, 20);
		contentPane.add(txtSenha);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(63, 80, 653, 198);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(63, 297, 653, 264);
		contentPane.add(tabbedPane_1);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(272, 604, 98, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(436, 604, 105, 23);
		contentPane.add(btnCancelar);
	}
}