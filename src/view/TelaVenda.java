package view;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.VendaController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TelaVenda extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtCodBarras;
	private VendaController controller;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda frame = new TelaVenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		contentPane.add(labelAdd);
		
		JLabel lblNovoItem = new JLabel("Adicionar");
		lblNovoItem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNovoItem.setBounds(572, 65, 114, 45);
		contentPane.add(lblNovoItem);
		
		table = new JTable();
		table.setBackground(new Color(152, 251, 152));
		table.setBounds(0, 133, 795, 378);
		contentPane.add(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(-11, 511, 795, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTotalR = new JLabel("TOTAL R$: ");
		lblTotalR.setBounds(412, 0, 195, 50);
		panel_1.add(lblTotalR);
		lblTotalR.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalR.setForeground(Color.WHITE);
		lblTotalR.setFont(new Font("Tahoma", Font.PLAIN, 38));
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(300, 11, 99, 28);
		panel_1.add(btnNewButton);
		
		JLabel lblTotal = new JLabel("0,00");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblTotal.setBounds(595, 1, 200, 50);
		panel_1.add(lblTotal);
		
		JLabel lblCodBarras = new JLabel("C\u00F3d. Barras");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodBarras.setBounds(112, 82, 90, 22);
		contentPane.add(lblCodBarras);
		
		txtCodBarras = new JTextField();
		txtCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodBarras.setBounds(194, 79, 319, 29);
		contentPane.add(txtCodBarras);
		txtCodBarras.setColumns(10);
	}
}
