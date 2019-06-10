package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controller.ListarVendasController;
import model.ItemVenda;
import model.Venda;

import javax.swing.JTextField;
import javax.swing.JTextArea;

public class TelaListarVendas extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JButton btnAlterar, btnExcluir;
	private JTable tabela;
	private ListarVendasController controller;
	private JTextField txtID, txtFuncionario, txtData, txtTotal, txtSituacao;
	private JTextArea txtProdutos;

	public TelaListarVendas() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 620);
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(0, 130, 130));
		panelTitulo.setBounds(0, 0, 950, 50);
		painel.add(panelTitulo);

		JLabel lblGerenciarVendas = new JLabel("GERENCIAR VENDAS");
		lblGerenciarVendas.setForeground(Color.WHITE);
		lblGerenciarVendas.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panelTitulo.add(lblGerenciarVendas);
		
		btnAlterar = new JButton("Alterar");		
		btnAlterar.setBounds(41, 95, 90, 25);
		btnAlterar.addActionListener(this);
		btnAlterar.setEnabled(false);
		painel.add(btnAlterar);

		btnExcluir = new JButton("Excluir");		
		btnExcluir.setBounds(399, 95, 90, 25);
		btnExcluir.addActionListener(this);
		btnExcluir.setEnabled(false);
		painel.add(btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 525, 400);
		painel.add(scrollPane);
		
		tabela = new JTable();
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(tabela.getSelectedRow());
				if (tabela.getSelectedRow() >= 0) {
					btnAlterar.setEnabled(true);
					btnExcluir.setEnabled(true);
					carregarDetail(tabela.getSelectedRow());
				} else {
					btnAlterar.setEnabled(false);
					btnExcluir.setEnabled(false);
				}
			}
		});
		scrollPane.setViewportView(tabela);
		atualizarTabela();
		
		JPanel painelDetail = new JPanel();
		painelDetail.setBackground(Color.WHITE);
		painelDetail.setBounds(545, 61, 379, 499);
		painel.add(painelDetail);
		painelDetail.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 175, 20);
		painelDetail.add(lblId);
		
		txtID = new JTextField();
		txtID.setBounds(10, 35, 359, 25);
		painelDetail.add(txtID);
		txtID.setColumns(10);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setColumns(10);
		txtFuncionario.setBounds(10, 95, 359, 25);
		painelDetail.add(txtFuncionario);
		
		JLabel lblFuncionario = new JLabel("Funcion\u00E1rio");
		lblFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFuncionario.setBounds(10, 71, 175, 20);
		painelDetail.add(lblFuncionario);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 129, 175, 20);
		painelDetail.add(lblData);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(10, 153, 359, 25);
		painelDetail.add(txtData);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(10, 213, 359, 25);
		painelDetail.add(txtTotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(10, 189, 175, 20);
		painelDetail.add(lblTotal);
		
		JLabel lblSituacao = new JLabel("Situa\u00E7\u00E3o");
		lblSituacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSituacao.setBounds(10, 248, 175, 20);
		painelDetail.add(lblSituacao);
		
		txtSituacao = new JTextField();
		txtSituacao.setColumns(10);
		txtSituacao.setBounds(10, 272, 359, 25);
		painelDetail.add(txtSituacao);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProdutos.setBounds(10, 308, 175, 20);
		painelDetail.add(lblProdutos);
		
		JScrollPane scrollProdutos = new JScrollPane();
		scrollProdutos.setBounds(10, 339, 359, 149);
		painelDetail.add(scrollProdutos);
		
		txtProdutos = new JTextArea();
		scrollProdutos.setViewportView(txtProdutos);		
	}
	
	public void atualizarTabela() {
		controller = new ListarVendasController();
		tabela.setModel(controller);
	}
	
	public void carregarDetail(int rowla) {
		Venda v = controller.buscarVenda(Integer.parseInt(tabela.getValueAt(rowla, 0).toString()));
		txtID.setText(String.valueOf(v.getId()));
		txtData.setText(v.getData().toString());
		txtFuncionario.setText(v.getFuncionario());
		txtTotal.setText(String.valueOf(v.getTotal()));;
		txtSituacao.setText(v.getSituacao().name());
		
		List<ItemVenda> itens_venda = controller.buscarItemVenda(v.getId());
		txtProdutos.setText("");
		for(ItemVenda iv : itens_venda) {
			txtProdutos.append(iv.getQuantidade_produto() + "x " + iv.getProduto().getNome() + " = " + iv.getSubtotal() + "\n");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
