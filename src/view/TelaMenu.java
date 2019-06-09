package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Help;
import controller.MenuController;
import model.Privilegio;

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
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 240, 240));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Bem-Vindo, " + Help.logado.getNome());
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(240, 10, 185, 15);
		contentPane.add(lblNome);
		ImageIcon imgEstoque = new ImageIcon(
				new ImageIcon("img/estoque.png").getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
		JLabel imgGerEstoque = new JLabel(imgEstoque);
		imgGerEstoque.setBounds(55, 30, 125, 125);
		imgGerEstoque.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirEstoque();
			}
		});
		contentPane.add(imgGerEstoque);
		JLabel lblGerenciarEstoque = new JLabel("Gerenciar Estoque");
		lblGerenciarEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGerenciarEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarEstoque.setBounds(60, 155, 125, 20);
		lblGerenciarEstoque.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirEstoque();
			}
		});
		contentPane.add(lblGerenciarEstoque);

		ImageIcon imgVenda = new ImageIcon(
				new ImageIcon("img/venda.png").getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
		JLabel imgRealVenda = new JLabel(imgVenda);
		imgRealVenda.setBounds(240, 30, 125, 125);
		imgRealVenda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirVenda();
			}
		});
		contentPane.add(imgRealVenda);
		JLabel lblVenda = new JLabel("Realizar Venda");
		lblVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVenda.setBounds(240, 155, 125, 20);
		if (!controller.verificaPrivilegio(Privilegio.CAIXA)) {
			lblVenda.setForeground(new Color(135, 135, 135));
		}
		lblVenda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirVenda();
			}
		});
		contentPane.add(lblVenda);

		ImageIcon imgUsuarios = new ImageIcon(
				new ImageIcon("img/usuarios.png").getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
		JLabel imgGerUsers = new JLabel(imgUsuarios);
		imgGerUsers.setBounds(55, 225, 125, 125);
		imgGerUsers.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirUsuarios();
			}
		});
		contentPane.add(imgGerUsers);
		JLabel lblGerenciarUsuarios = new JLabel("Gerenciar Usu\u00E1rios");
		lblGerenciarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciarUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGerenciarUsuarios.setBounds(55, 350, 125, 20);
		if (!controller.verificaPrivilegio(Privilegio.ADMINISTRADOR)) {
			lblGerenciarUsuarios.setForeground(new Color(133, 133, 133));
		}
		lblGerenciarUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirUsuarios();
			}
		});
		contentPane.add(lblGerenciarUsuarios);

		ImageIcon imgRelatorios = new ImageIcon(
				new ImageIcon("img/relatorio.png").getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT));
		JLabel imgVerRel = new JLabel(imgRelatorios);
		imgVerRel.setBounds(240, 225, 125, 125);
		imgVerRel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirRelatorios();
			}
		});
		contentPane.add(imgVerRel);
		JLabel lblVisualizarRelatrios = new JLabel("Visualizar Relat\u00F3rios");
		lblVisualizarRelatrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisualizarRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVisualizarRelatrios.setBounds(240, 350, 125, 20);
		if (!controller.verificaPrivilegio(Privilegio.ADMINISTRADOR)) {
			lblVisualizarRelatrios.setForeground(new Color(133, 133, 133));
		}
		lblVisualizarRelatrios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				controller.abrirRelatorios();
			}
		});
		contentPane.add(lblVisualizarRelatrios);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
