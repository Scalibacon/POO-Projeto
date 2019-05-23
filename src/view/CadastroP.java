package view;
import java.awt.BorderLayout;
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

public class CadastroP extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroP frame = new CadastroP();
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
	public CadastroP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		lblNewLabel.setBounds(104, 109, 98, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNome.setBounds(104, 175, 98, 32);
		contentPane.add(lblNome);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o*");
		lblPreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPreo.setBounds(104, 238, 98, 32);
		contentPane.add(lblPreo);
		
		JLabel lblQuantidade = new JLabel("Quantidade*");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuantidade.setBounds(104, 300, 124, 32);
		contentPane.add(lblQuantidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(238, 119, 111, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(238, 185, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 248, 111, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 310, 111, 20);
		contentPane.add(textField_2);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescrio.setBounds(431, 76, 98, 32);
		contentPane.add(lblDescrio);
		
		textField_3 = new JTextField();
		textField_3.setBounds(431, 119, 291, 147);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(358, 460, 89, 23);
		contentPane.add(btnFinalizar);
		
		JLabel lblCodBarras = new JLabel("Cod. Barras*");
		lblCodBarras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCodBarras.setBounds(104, 362, 124, 32);
		contentPane.add(lblCodBarras);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(238, 372, 111, 20);
		contentPane.add(textField_4);
	}
}
