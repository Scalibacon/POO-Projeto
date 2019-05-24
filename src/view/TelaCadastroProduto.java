package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CadastroProdutoController;
import controller.EstoqueController;
import model.Categoria;
import model.Produto;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class TelaCadastroProduto extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome, txtPreco, txtQtd, txtCodBarras;
	private JComboBox<?> comboCategoria;
	private JTextArea txtDescricao;
	private JButton btnFinalizar;
	private CadastroProdutoController controller = new CadastroProdutoController();
	private EstoqueController ec;
	
	public TelaCadastroProduto(EstoqueController ec, Produto p) {
		this.ec = ec;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 795, 50);
		contentPane.add(panel);
		
		JLabel lblCadastroDeProduto = new JLabel("CADASTRO DE PRODUTO");
		lblCadastroDeProduto.setForeground(Color.WHITE);
		lblCadastroDeProduto.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblCadastroDeProduto);
		
		JLabel lblNewLabel = new JLabel("Categoria*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(70, 109, 98, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(70, 175, 98, 32);
		contentPane.add(lblNome);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o*");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPreo.setBounds(70, 238, 98, 32);
		contentPane.add(lblPreo);
		
		JLabel lblQuantidade = new JLabel("Quantidade*");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantidade.setBounds(70, 300, 124, 32);
		contentPane.add(lblQuantidade);
		
		comboCategoria = new JComboBox<Object>(Categoria.values());
		comboCategoria.setBounds(204, 116, 183, 26);
		contentPane.add(comboCategoria);
		
		txtNome = new JTextField();
		txtNome.setBounds(204, 182, 183, 26);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(204, 245, 183, 26);
		contentPane.add(txtPreco);
		
		txtQtd = new JTextField();
		txtQtd.setColumns(10);
		txtQtd.setBounds(204, 307, 183, 26);
		contentPane.add(txtQtd);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescricao.setBounds(433, 109, 98, 32);
		contentPane.add(lblDescricao);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFinalizar.setBounds(366, 430, 98, 32);
		btnFinalizar.addActionListener(this);
		contentPane.add(btnFinalizar);
		
		JLabel lblCodBarras = new JLabel("Cod. Barras*");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodBarras.setBounds(70, 362, 124, 32);
		contentPane.add(lblCodBarras);
		
		txtCodBarras = new JTextField();
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(204, 369, 183, 26);
		contentPane.add(txtCodBarras);
		
		txtDescricao = new JTextArea();
		txtDescricao.setBounds(433, 150, 291, 167);
		contentPane.add(txtDescricao);
		
		if(p != null) {
			produtoToTela(p);
			btnFinalizar.setText("Alterar");
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == btnFinalizar) {
			controller.adicionarNovoProduto(telaToProduto());
			ec.carregarTabela();
			this.dispose();
		}
	}
	
	public Produto telaToProduto() {
		Produto p = new Produto();
		p.setCategoria(((Categoria) comboCategoria.getSelectedItem()));
		p.setNome(txtNome.getText());
		p.setPreco(Double.parseDouble(txtPreco.getText()));
		p.setQuantidade_estoque(Integer.parseInt(txtQtd.getText()));
		p.setCod_barras(txtCodBarras.getText());
		
		return p;
	}
	
	public void produtoToTela(Produto p) {
		txtNome.setText(p.getNome());
		txtPreco.setText(String.valueOf(p.getPreco()));
		txtQtd.setText(String.valueOf(p.getQuantidade_estoque()));
		txtCodBarras.setText(p.getCod_barras());
		comboCategoria.setSelectedItem(p.getCategoria());
	}
}
