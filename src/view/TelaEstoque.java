package view;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaEstoque extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque frame = new TelaEstoque();
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
	public TelaEstoque() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(-11, 0, 795, 50);
		contentPane.add(panel);
		
		JLabel lblGerenciamentoDeEstoque = new JLabel("GERENCIAMENTO DE ESTOQUE");
		lblGerenciamentoDeEstoque.setForeground(new Color(255, 255, 255));
		lblGerenciamentoDeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblGerenciamentoDeEstoque);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 134, 784, 427);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome do produto", "Categoria", "Pre\u00E7o R$", "Qtd Estoque"
			}
		));
		
		JButton btnEstocar = new JButton("New button");
		btnEstocar.setBounds(122, 79, 89, 23);
		contentPane.add(btnEstocar);
		
		JButton btnAlterar = new JButton("New button");
		btnAlterar.setBounds(349, 79, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("New button");
		btnExcluir.setBounds(578, 79, 89, 23);
		contentPane.add(btnExcluir);
		table.getColumnModel().getColumn(0).setPreferredWidth(239);
		table.getColumnModel().getColumn(1).setPreferredWidth(185);
		table.getColumnModel().getColumn(2).setPreferredWidth(101);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
	}
}