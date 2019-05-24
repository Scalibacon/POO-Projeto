package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.VendaController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class TelaVenda extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNome;
	private JTable table;
	private JTextField txtCodBarras;
	private VendaController controller;
	private JTextField txtQtd;

	public TelaVenda() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 795, 50);
		contentPane.add(panel);

		JLabel lblVenda = new JLabel("VENDA");
		lblVenda.setForeground(Color.WHITE);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblVenda);

		JLabel labelAdd = new JLabel("+");
		labelAdd.setForeground(new Color(0, 180, 128));
		labelAdd.setFont(new Font("Tahoma", Font.PLAIN, 60));
		labelAdd.setBounds(523, 61, 45, 45);
		labelAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.adicionarItemVenda(txtCodBarras.getText());
			}
		});
		contentPane.add(labelAdd);

		JLabel lblNovoItem = new JLabel("Adicionar");
		lblNovoItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNovoItem.setBounds(572, 65, 114, 45);
		lblNovoItem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.adicionarItemVenda(txtCodBarras.getText());
			}
		});
		contentPane.add(lblNovoItem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 133, 795, 325);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(152, 251, 152));
		table.setBounds(0, 133, 795, 378);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txtQtd.setEditable(true);
				atualizarCampos(table.getSelectedRow());
			}
		});
		scrollPane.setViewportView(table);

		JPanel panelDown = new JPanel();
		panelDown.setBackground(new Color(0, 128, 128));
		panelDown.setBounds(-11, 511, 795, 50);
		contentPane.add(panelDown);
		panelDown.setLayout(null);

		JLabel lblTotalR = new JLabel("TOTAL R$: ");
		lblTotalR.setBounds(412, 0, 195, 50);
		panelDown.add(lblTotalR);
		lblTotalR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalR.setForeground(Color.WHITE);
		lblTotalR.setFont(new Font("Tahoma", Font.PLAIN, 38));

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFinalizar.setBounds(300, 11, 99, 28);
		panelDown.add(btnFinalizar);

		JLabel lblTotal = new JLabel("0,00");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblTotal.setBounds(595, 1, 200, 50);
		panelDown.add(lblTotal);

		JLabel lblCodBarras = new JLabel("C\u00F3d. Barras");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodBarras.setBounds(112, 82, 90, 22);
		contentPane.add(lblCodBarras);

		txtCodBarras = new JTextField();
		txtCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodBarras.setBounds(194, 79, 319, 29);
		contentPane.add(txtCodBarras);
		txtCodBarras.setColumns(10);

		controller = new VendaController(table);

		JLabel lblQtd = new JLabel("Quantidade: ");
		lblQtd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQtd.setBounds(292, 469, 114, 31);
		contentPane.add(lblQtd);

		txtQtd = new JTextField();
		txtQtd.setEditable(false);
		txtQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQtd.setHorizontalAlignment(SwingConstants.CENTER);
		txtQtd.setBounds(416, 469, 119, 31);
		txtQtd.addActionListener(this);
		contentPane.add(txtQtd);
		txtQtd.setColumns(10);

		JLabel lblRetirar = new JLabel("Retirar");
		lblRetirar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRetirar.setBounds(645, 469, 62, 31);
		contentPane.add(lblRetirar);

		ImageIcon imgRetirarIcon = new ImageIcon(
				new ImageIcon("img/x.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		JLabel imgRetirar = new JLabel(imgRetirarIcon);
		imgRetirar.setBounds(707, 469, 35, 35);
		imgRetirar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.removerItemVenda();
			}
		});
		contentPane.add(imgRetirar);

		lblNome = new JLabel("Nome...");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(20, 469, 114, 31);
		contentPane.add(lblNome);

		controller.iniciarTabelaItens();
	}

	public void atualizarCampos(int rowla) {
		lblNome.setText(table.getValueAt(rowla, 0).toString());
		txtQtd.setText(table.getValueAt(rowla, 3).toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtQtd) {
			System.out.println("Apertou enter no txtQtd");
		}
	}
}
