package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import controller.GerenciarUsuarioController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TelaGerenciarUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTable tabela;
	private GerenciarUsuarioController controller;
	
	public static void main(String args[]) {
		TelaGerenciarUsuario2 tela = new TelaGerenciarUsuario2();
		tela.setVisible(true);
	}

	public TelaGerenciarUsuario() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 130, 130));
		panel.setBounds(0, 0, 800, 50);
		painel.add(panel);
		
		JLabel lblGerenciarUsuarios = new JLabel("GERENCIAR USU\u00C1RIOS");
		lblGerenciarUsuarios.setForeground(Color.WHITE);
		lblGerenciarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblGerenciarUsuarios);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 160, 785, 400);
		painel.add(scroll);
		
		tabela = new JTable();
		scroll.setViewportView(tabela);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(360, 90, 90, 25);
		painel.add(btnCriar);	
		
		controller = new GerenciarUsuarioController(tabela);
		controller.iniciarTabela();
		controller.carregarTabela();		
	}
}