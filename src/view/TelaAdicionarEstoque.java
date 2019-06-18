package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.AlteracaoEstoque;
import model.Produto;
import model.TipoAlteracao;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import controller.AdicionarEstoqueController;
import controller.Help;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;


public class TelaAdicionarEstoque extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private Produto p;
	private JTextField txtProduto, txtCodBarras, txtEstoqueAtual, txtQtdeAlteracao;
	private JRadioButton rdbtnAdd, rdbtnRemover;
	private JButton btnFinalizar;
	private JTextArea txtDescricao;
	private JDateChooser dateChooser;
	private AdicionarEstoqueController controller = new AdicionarEstoqueController();

	public TelaAdicionarEstoque(Produto p) {
		this.p = p;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 415);
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 644, 50);
		painel.add(panel);

		JLabel lblAlterarEstoque = new JLabel("ALTERAR ESTOQUE");
		lblAlterarEstoque.setForeground(Color.WHITE);
		lblAlterarEstoque.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblAlterarEstoque);
		
		JLabel lblNome = new JLabel("Produto");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 60, 200, 20);
		painel.add(lblNome);
		
		txtProduto = new JTextField();
		txtProduto.setEditable(false);
		txtProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtProduto.setBounds(10, 85, 300, 27);
		painel.add(txtProduto);
		txtProduto.setColumns(10);
		
		JLabel lblCodBarras = new JLabel("C\u00F3d. Barras");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodBarras.setBounds(10, 121, 200, 20);
		painel.add(lblCodBarras);
		
		txtCodBarras = new JTextField();
		txtCodBarras.setEditable(false);
		txtCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCodBarras.setColumns(10);
		txtCodBarras.setBounds(10, 146, 300, 27);
		painel.add(txtCodBarras);
		
		txtEstoqueAtual = new JTextField();
		txtEstoqueAtual.setEditable(false);
		txtEstoqueAtual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEstoqueAtual.setColumns(10);
		txtEstoqueAtual.setBounds(10, 207, 300, 27);
		painel.add(txtEstoqueAtual);
		
		JLabel lblQtdeEstoqueAtual = new JLabel("Qtde Estoque Atual");
		lblQtdeEstoqueAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQtdeEstoqueAtual.setBounds(10, 182, 200, 20);
		painel.add(lblQtdeEstoqueAtual);
		
		JLabel lblTipoAlterao = new JLabel("Tipo Altera\u00E7\u00E3o");
		lblTipoAlterao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoAlterao.setBounds(339, 61, 200, 20);
		painel.add(lblTipoAlterao);
		
		rdbtnAdd = new JRadioButton("Adicionar");
		rdbtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnAdd.setBounds(339, 86, 109, 23);
		rdbtnAdd.setSelected(true);
		painel.add(rdbtnAdd);
		
		rdbtnRemover = new JRadioButton("Remover");
		rdbtnRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnRemover.setBounds(456, 86, 109, 23);
		painel.add(rdbtnRemover);
		
		ButtonGroup rdbtnGroup = new ButtonGroup();
		rdbtnGroup.add(rdbtnAdd);
		rdbtnGroup.add(rdbtnRemover);
		
		JLabel lblQtdeAlteracao = new JLabel("Qtde Altera\u00E7\u00E3o");
		lblQtdeAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQtdeAlteracao.setBounds(339, 121, 200, 20);
		painel.add(lblQtdeAlteracao);
		
		txtQtdeAlteracao = new JTextField();
		txtQtdeAlteracao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtQtdeAlteracao.setBounds(339, 146, 300, 27);
		painel.add(txtQtdeAlteracao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescricao.setBounds(339, 182, 200, 20);
		painel.add(lblDescricao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 207, 300, 95);
		painel.add(scrollPane);
		
		txtDescricao = new JTextArea();
		scrollPane.setViewportView(txtDescricao);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(280, 325, 90, 30);
		btnFinalizar.addActionListener(this);
		painel.add(btnFinalizar);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 275, 160, 27);
		painel.add(dateChooser);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 245, 200, 20);
		painel.add(lblData);
		carregarTela();		

	}
	
	public void carregarTela() {
		txtProduto.setText(p.getNome());
		txtCodBarras.setText(p.getCod_barras());
		txtEstoqueAtual.setText(String.valueOf(p.getQuantidade_estoque()));		
	}
	
	public AlteracaoEstoque telaToAlter() {
		AlteracaoEstoque ae = new AlteracaoEstoque();
		
		ae.setData(dateChooser.getCalendar());
		ae.setAutor(Help.logado);
		ae.setQuantidade(Integer.parseInt(txtQtdeAlteracao.getText()));
		ae.setProduto(p);
		if(rdbtnAdd.isSelected())
			ae.setTipoAlt(TipoAlteracao.ADICIONAR);
		else
			ae.setTipoAlt(TipoAlteracao.SUBTRAIR);
		ae.setDescricao(txtDescricao.getText());
		
		return ae;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnFinalizar) {
			AlteracaoEstoque ae = telaToAlter();
			controller.adicionarAlteracao(ae);
			this.dispose();
		}
	}
}
