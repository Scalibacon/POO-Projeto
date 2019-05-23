package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class GerenciarUsuario2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarUsuario2 frame = new GerenciarUsuario2();
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
	public GerenciarUsuario2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 795, 50);
		contentPane.add(panel);
		
		JLabel label = new JLabel("GERENCIAR USU\u00C1RIOS");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(label);
		
		JLabel lblPrivilgio = new JLabel("Privil\u00E9gio*");
		lblPrivilgio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrivilgio.setBounds(82, 99, 98, 32);
		contentPane.add(lblPrivilgio);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(216, 109, 111, 20);
		contentPane.add(comboBox);
		
		JLabel label_2 = new JLabel("Nome*");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(82, 185, 98, 32);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(216, 195, 273, 20);
		contentPane.add(textField);
		
		JLabel lblCpf = new JLabel("CPF*");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpf.setBounds(82, 142, 98, 32);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(216, 152, 111, 20);
		contentPane.add(textField_1);
		
		JLabel lblRua = new JLabel("Rua*");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRua.setBounds(82, 304, 124, 32);
		contentPane.add(lblRua);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(223, 314, 273, 20);
		contentPane.add(textField_2);
		
		JLabel lblNmero = new JLabel("N\u00FAmero*");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNmero.setBounds(507, 304, 124, 32);
		contentPane.add(lblNmero);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(605, 314, 61, 20);
		contentPane.add(textField_3);
		
		JLabel lblBairro = new JLabel("Cidade*");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBairro.setBounds(82, 390, 124, 32);
		contentPane.add(lblBairro);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(223, 400, 273, 20);
		contentPane.add(textField_4);
		
		JLabel lblEstado = new JLabel("Estado*");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstado.setBounds(82, 434, 124, 32);
		contentPane.add(lblEstado);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(223, 444, 273, 20);
		contentPane.add(textField_5);
		
		JLabel lblTelefone = new JLabel("Telefone*");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefone.setBounds(82, 478, 124, 32);
		contentPane.add(lblTelefone);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(223, 488, 137, 20);
		contentPane.add(textField_6);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCelular.setBounds(82, 518, 124, 32);
		contentPane.add(lblCelular);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(223, 528, 137, 20);
		contentPane.add(textField_7);
		
		JLabel lblCidade = new JLabel("Bairro*");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCidade.setBounds(82, 347, 124, 32);
		contentPane.add(lblCidade);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(223, 357, 273, 20);
		contentPane.add(textField_8);
		
		JLabel lblSenha = new JLabel("Senha*");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(82, 226, 98, 32);
		contentPane.add(lblSenha);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(216, 236, 111, 20);
		contentPane.add(textField_9);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(63, 80, 653, 198);
		contentPane.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(63, 297, 653, 264);
		contentPane.add(tabbedPane_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(272, 604, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(436, 604, 105, 23);
		contentPane.add(btnNewButton_1);
	}
}
