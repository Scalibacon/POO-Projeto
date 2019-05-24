package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.GerenciarUsuarioController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TelaGerenciarUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private GerenciarUsuarioController controller;

	public TelaGerenciarUsuario() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 795, 50);
		contentPane.add(panel);
		
		JLabel lblGerenciarUsuarios = new JLabel("GERENCIAR USU\u00C1RIOS");
		lblGerenciarUsuarios.setForeground(Color.WHITE);
		lblGerenciarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblGerenciarUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 157, 784, 404);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(360, 89, 89, 23);
		contentPane.add(btnCriar);	
		
		controller = new GerenciarUsuarioController(table);
		controller.iniciarTabela();
		controller.carregarTabela();		
	}
}