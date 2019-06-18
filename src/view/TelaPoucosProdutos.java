package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import dao.DAOException;
import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import model.Produto;

public class TelaPoucosProdutos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txtProdutos;

	public TelaPoucosProdutos() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 130, 130));
		panel.setBounds(0, 0, 450, 50);
		contentPane.add(panel);

		JLabel lblTitulo = new JLabel("PRODUTOS ACABANDO");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblTitulo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 415, 390);
		contentPane.add(scrollPane);

		txtProdutos = new JTextArea();
		txtProdutos.setEditable(false);
		scrollPane.setViewportView(txtProdutos);

		carregaProdutosFaltando();
	}

	public void carregaProdutosFaltando() {
		ProdutoDAO proDAO = new ProdutoDAOImpl();
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			produtos = proDAO.buscarFaltando();
			System.out.println(produtos.size());
			if (produtos.size() > 0) {
				for (Produto p : produtos) {
					txtProdutos.append(p.getNome() + " (" + p.getCod_barras() + ") - Apenas "
							+ p.getQuantidade_estoque() + " em estoque\n\n");
				}
			} else {
				this.setVisible(false);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
