package view;

import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.GerenciarUsuarioController;
import model.Estoquista;
import model.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class TelaGerenciarUsuario extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JTable tabela;
	private GerenciarUsuarioController controller = new GerenciarUsuarioController(tabela);
	private JButton btnCriar, btnExcluir1, btnAlterar1;

	
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
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnCriar) {
					controller.adicionarOuAlterarUsuario(null);
				} else if (e.getSource() == btnAlterar1) {
					Estoquista estoquista = controller.buscarUsuario((String) controller.getValueAt(tabela.getSelectedRow(), 4));
					controller.adicionarOuAlterarUsuario(estoquista);
				} else if (e.getSource() == btnExcluir1) {
					if (JOptionPane.showConfirmDialog(btnExcluir1, this, "Deseja mesmo excluir esse usuario?", getDefaultCloseOperation()) == 0) {
						controller.excluirUsuario(tabela.getSelectedRow());
					}
				}
			}
		});
		btnCriar.setBounds(72, 88, 90, 25);
		painel.add(btnCriar);	
		
		controller = new GerenciarUsuarioController(tabela);
		
		JButton btnAlterar1 = new JButton("Alterar");
		btnAlterar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == btnCriar) {
					controller.adicionarOuAlterarUsuario(null);
				} else if (e.getSource() == btnAlterar1) {
					Estoquista estoquista = controller.buscarUsuario((String) controller.getValueAt(tabela.getSelectedRow(), 4));
					controller.adicionarOuAlterarUsuario(estoquista);
				} else if (e.getSource() == btnExcluir1) {
					if (JOptionPane.showConfirmDialog(btnExcluir1, this, "Deseja mesmo excluir esse usuario?", getDefaultCloseOperation()) == 0) {
						controller.excluirUsuario(tabela.getSelectedRow());
					}
				}
			}
		});
		btnAlterar1.setBounds(358, 89, 89, 23);
		painel.add(btnAlterar1);
		
		JButton btnExcluir1 = new JButton("Excluir");
		btnExcluir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCriar) {
					controller.adicionarOuAlterarUsuario(null);
				} else if (e.getSource() == btnAlterar1) {
					Estoquista estoquista = controller.buscarUsuario((String) controller.getValueAt(tabela.getSelectedRow(), 4));
					controller.adicionarOuAlterarUsuario(estoquista);
				} else if (e.getSource() == btnExcluir1) {
					if (JOptionPane.showConfirmDialog(btnExcluir1, this, "Deseja mesmo excluir esse usuario?", getDefaultCloseOperation()) == 0) {
						controller.excluirUsuario(tabela.getSelectedRow());
					}
				}
				
			}
		});
		btnExcluir1.setBounds(612, 89, 89, 23);
		painel.add(btnExcluir1);	
		
	}
	
	public void abrirTelaCadastro(boolean isAlterar) {
		if (isAlterar) {
			Estoquista estoquista = controller.buscarUsuario((String) controller.getValueAt(tabela.getSelectedRow(), 4));
			JDialog tela_add_estoquista = new TelaGerenciarUsuario2();
			tela_add_estoquista.setModal(true);
			tela_add_estoquista.setVisible(true);
		} else {
			JDialog tela_add_produto = new TelaGerenciarUsuario2();
			tela_add_produto.setModal(true);
			tela_add_produto.setVisible(true);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
		
	
}