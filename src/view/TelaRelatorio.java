package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaRelatorio extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TelaRelatorio() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 130, 130));
		panel.setBounds(0, 0, 800, 50);
		contentPane.add(panel);
		
		JLabel lblRelatrios = new JLabel("RELAT\u00D3RIOS");
		lblRelatrios.setForeground(Color.WHITE);
		lblRelatrios.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblRelatrios);
		
		JButton btnNewButton = new JButton("Produtos mais vendidos");
		btnNewButton.setBounds(300, 125, 205, 25);
		contentPane.add(btnNewButton);
		
		JButton btnPorPerodo = new JButton("Por per\u00EDodo");
		btnPorPerodo.setBounds(300, 225, 200, 25);
		contentPane.add(btnPorPerodo);
	}
}
