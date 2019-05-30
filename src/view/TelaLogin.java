package view;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import controller.Help;
import controller.LoginController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TelaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTextField txtCpf;
	private JPasswordField txtSenha;
	private JButton btnEntrar;
	LoginController controller = new LoginController();

	public static void main(String[] args) {

		Help.preencheListas();
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		TelaLogin frame = new TelaLogin();
		frame.setVisible(true);

	}

	public TelaLogin() {
		setResizable(false);
		setTitle("Login - Sistema de Mercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 190);
		painel = new JPanel();
		painel.setBackground(new Color(0, 250, 155));
		setContentPane(painel);
		painel.setLayout(null);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCpf.setBounds(20, 55, 60, 15);
		painel.add(lblCpf);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSenha.setBounds(20, 90, 60, 15);
		painel.add(lblSenha);

		txtCpf = new JTextField();
		txtCpf.setBounds(85, 50, 150, 25);
		painel.add(txtCpf);
		txtCpf.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(85, 90, 150, 25);
		painel.add(txtSenha);

		ImageIcon imgLogo = new ImageIcon(
				new ImageIcon("img/logo.png").getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT));
		JLabel lblLogo = new JLabel(imgLogo);
		lblLogo.setBounds(265, 55, 55, 55);
		painel.add(lblLogo);

		JLabel lblEntrarNoSistema = new JLabel("Entrar no Sistema");
		lblEntrarNoSistema.setForeground(new Color(0, 0, 128));
		lblEntrarNoSistema.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblEntrarNoSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrarNoSistema.setBounds(85, 15, 150, 15);
		painel.add(lblEntrarNoSistema);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEntrar.setBounds(110, 125, 90, 25);
		btnEntrar.addActionListener(this);
		painel.add(btnEntrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEntrar) {
			String cpf = txtCpf.getText();
			String senha = String.valueOf(txtSenha.getPassword());
			if (controller.logar(cpf, senha)) {
				this.dispose();
			}
		}
	}
}
