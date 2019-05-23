package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;

public class TelaRelatorioPeriodo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioPeriodo frame = new TelaRelatorioPeriodo();
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
	public TelaRelatorioPeriodo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 795, 50);
		panel.setBackground(new Color(0, 128, 128));
		contentPane.add(panel);
		
		JLabel label = new JLabel("RELAT\u00D3RIOS");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(label);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 61, 182, 146);
		contentPane.add(calendar);
		
		table = new JTable();
		table.setBounds(202, 61, 572, 474);
		contentPane.add(table);
	}
}
