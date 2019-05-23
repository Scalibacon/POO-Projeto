package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class TelaCadastroProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome, txtPreco, txtQtd, txtCodBarras;
	JTextArea txtDescricao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaCadastroProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JComboBox comboCategoria = new JComboBox();
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
		lblDescricao.setBounds(436, 82, 98, 32);
		contentPane.add(lblDescricao);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFinalizar.setBounds(366, 430, 98, 32);
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
		txtDescricao.setBounds(436, 123, 291, 167);
		contentPane.add(txtDescricao);
	}
}
