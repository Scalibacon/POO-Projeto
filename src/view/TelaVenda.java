package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
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
	private JTable tabela;
	private JButton btnFinalizar;
	private JTextField txtCodBarras;
	private VendaController controller = new VendaController();
	private JTextField txtQtd;

	public TelaVenda() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 130, 130));
		panel.setBounds(0, 0, 800, 50);
		contentPane.add(panel);

		JLabel lblVenda = new JLabel("VENDA");
		lblVenda.setForeground(Color.WHITE);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblVenda);

		JLabel labelAdd = new JLabel("+");
		labelAdd.setForeground(new Color(0, 180, 130));
		labelAdd.setFont(new Font("Tahoma", Font.PLAIN, 60));
		labelAdd.setBounds(525, 60, 50, 50);
		labelAdd.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.adicionarItemVenda(txtCodBarras.getText());
			}
		});
		contentPane.add(labelAdd);

		JLabel lblNovoItem = new JLabel("Adicionar");
		lblNovoItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNovoItem.setBounds(570, 65, 115, 45);
		lblNovoItem.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.adicionarItemVenda(txtCodBarras.getText());
			}
		});
		contentPane.add(lblNovoItem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 135, 800, 325);
		contentPane.add(scrollPane);

		tabela = new JTable();
		tabela.setBackground(Color.WHITE);
		tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				txtQtd.setEditable(true);
				atualizarCampos(tabela.getSelectedRow());
			}
		});
		scrollPane.setViewportView(tabela);
		atualizarTabela();

		JPanel panelDown = new JPanel();
		panelDown.setBackground(new Color(0, 130, 130));
		panelDown.setBounds(0, 510, 800, 50);
		contentPane.add(panelDown);
		panelDown.setLayout(null);

		JLabel lblTotalR = new JLabel("TOTAL R$: ");
		lblTotalR.setBounds(415, 0, 200, 50);
		panelDown.add(lblTotalR);
		lblTotalR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalR.setForeground(Color.WHITE);
		lblTotalR.setFont(new Font("Tahoma", Font.PLAIN, 38));

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFinalizar.setBounds(300, 10, 100, 30);
		btnFinalizar.addActionListener(this);
		panelDown.add(btnFinalizar);

		JLabel lblTotal = new JLabel("0,00");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblTotal.setBounds(600, 1, 200, 50);
		panelDown.add(lblTotal);

		JLabel lblCodBarras = new JLabel("C\u00F3d. Barras");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodBarras.setBounds(110, 80, 90, 20);
		contentPane.add(lblCodBarras);

		txtCodBarras = new JTextField();
		txtCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodBarras.setBounds(195, 80, 320, 30);
		contentPane.add(txtCodBarras);

		JLabel lblQtd = new JLabel("Quantidade: ");
		lblQtd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQtd.setBounds(290, 470, 115, 30);
		contentPane.add(lblQtd);

		txtQtd = new JTextField();
		txtQtd.setEditable(false);
		txtQtd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQtd.setHorizontalAlignment(SwingConstants.CENTER);
		txtQtd.setBounds(415, 470, 120, 30);
		txtQtd.addActionListener(this);
		contentPane.add(txtQtd);
		txtQtd.setColumns(10);

		JLabel lblRetirar = new JLabel("Retirar");
		lblRetirar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRetirar.setBounds(645, 470, 60, 30);
		contentPane.add(lblRetirar);

		ImageIcon imgRetirarIcon = new ImageIcon(
				new ImageIcon("img/x.png").getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		JLabel imgRetirar = new JLabel(imgRetirarIcon);
		imgRetirar.setBounds(700, 470, 35, 35);
		imgRetirar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (tabela.getSelectedRow() >= 0) {
					controller.removerItemVenda(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 1)));
				}
			}
		});
		contentPane.add(imgRetirar);

		lblNome = new JLabel("Nome...");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(20, 470, 115, 30);
		contentPane.add(lblNome);
	}

	private void atualizarTabela() {
		controller = new VendaController();
		tabela.setModel(controller);
	}

	public void atualizarCampos(int rowla) {
		if (tabela.getSelectedRow() >= 0) {
			lblNome.setText(tabela.getValueAt(rowla, 0).toString());
			txtQtd.setText(tabela.getValueAt(rowla, 3).toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtQtd) {
			System.out.println("Apertou enter no txtQtd");
			if (tabela.getSelectedRow() >= 0) {
				controller.alterarQuantidade(String.valueOf(tabela.getValueAt(tabela.getSelectedRow(), 1)),
						Integer.parseInt(txtQtd.getText()));
			}
		} else if (e.getSource() == btnFinalizar) {
			controller.finalizarVenda();
		}
	}
}
