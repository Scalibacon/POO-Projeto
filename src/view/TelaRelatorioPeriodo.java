package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;

public class TelaRelatorioPeriodo extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public TelaRelatorioPeriodo() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 50);
		panel.setBackground(new Color(0, 130, 130));
		contentPane.add(panel);
		
		JLabel label = new JLabel("RELAT\u00D3RIOS");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(label);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 60, 180, 150);
		contentPane.add(calendar);
		
		table = new JTable();
		table.setBounds(200, 60, 570, 475);
		contentPane.add(table);
	}
}
