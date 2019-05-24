package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

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
	private JPanel contentPane;
	private JTextField txtCpf;
	private JPasswordField txtSenha;
	private JButton btnEntrar;
	LoginController controller = new LoginController();	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setResizable(false);
		setTitle("Login - Sistema de Mercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 190);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 250, 154));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCpf.setBounds(20, 54, 58, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSenha.setBounds(20, 92, 58, 14);
		contentPane.add(lblSenha);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(85, 50, 150, 26);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(85, 88, 150, 26);
		contentPane.add(txtSenha);
		
		ImageIcon imgLogo = new ImageIcon(new ImageIcon("img/logo.png").getImage().getScaledInstance(57, 57, Image.SCALE_DEFAULT));
		JLabel lblLogo = new JLabel(imgLogo);
		lblLogo.setBounds(266, 54, 57, 57);
		contentPane.add(lblLogo);		
		
		JLabel lblEntrarNoSistema = new JLabel("Entrar no Sistema");
		lblEntrarNoSistema.setForeground(new Color(0, 0, 128));
		lblEntrarNoSistema.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblEntrarNoSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrarNoSistema.setBounds(85, 11, 150, 14);
		contentPane.add(lblEntrarNoSistema);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEntrar.setBounds(111, 124, 90, 26);
		btnEntrar.addActionListener(this);
		contentPane.add(btnEntrar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEntrar) {
			String cpf = txtCpf.getText();
			String senha = String.valueOf(txtSenha.getPassword());
			controller.logar(cpf, senha);
		}
	}
}
