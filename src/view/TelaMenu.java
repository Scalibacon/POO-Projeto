package view;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TelaMenu extends JFrame implements ActionListener {	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuController controller = new MenuController();

	public TelaMenu() {
		setTitle("Sistema de Gerenciamento de Mercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon imgEstoque = new ImageIcon(
				new ImageIcon("img/estoque.png").getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
		JLabel imgGerEstoque = new JLabel(imgEstoque);
		imgGerEstoque.setBounds(57, 28, 125, 125);
		imgGerEstoque.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abrirEstoque();
			}
		});
		contentPane.add(imgGerEstoque);

		JLabel lblGerenciarEstoque = new JLabel("Gerenciar Estoque");
		lblGerenciarEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGerenciarEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarEstoque.setBounds(57, 156, 125, 18);
		lblGerenciarEstoque.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abrirEstoque();
			}
		});
		contentPane.add(lblGerenciarEstoque);

		ImageIcon imgVenda = new ImageIcon(
				new ImageIcon("img/venda.png").getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
		JLabel imgRealVenda = new JLabel(imgVenda);
		imgRealVenda.setBounds(240, 28, 125, 125);
		imgRealVenda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abrirVenda();
			}
		});
		contentPane.add(imgRealVenda);

		JLabel lblVenda = new JLabel("Realizar Venda");
		lblVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVenda.setBounds(240, 156, 125, 18);
		lblVenda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				abrirVenda();
			}
		});
		contentPane.add(lblVenda);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void abrirEstoque() {
		JDialog tela = new TelaEstoque();
		controller.abrirModal(tela);
	}

	public void abrirVenda() {
		JDialog tela = new TelaVenda();
		controller.abrirModal(tela);
	}

}
