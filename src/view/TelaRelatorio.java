package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.toedter.calendar.JDateChooser;

public class TelaRelatorio extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser dataInicialEstoque, dataFimEstoque, dataInicialVenda, dataFimVenda;
	private JFreeChart grafico;

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

		JLabel lblRelatorios = new JLabel("RELAT\u00D3RIOS");
		lblRelatorios.setForeground(Color.WHITE);
		lblRelatorios.setFont(new Font("Tahoma", Font.PLAIN, 38));
		panel.add(lblRelatorios);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 50, 784, 500);
		contentPane.add(tabbedPane);

		JPanel panelVendas = new JPanel();
		panelVendas.setBackground(Color.WHITE);
		tabbedPane.addTab("Vendas", null, panelVendas, null);
		panelVendas.setLayout(null);

		JLabel lblVendaDataInicio = new JLabel("Data In\u00EDcio");
		lblVendaDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVendaDataInicio.setBounds(10, 10, 100, 25);

		JLabel lblVendaDataFim = new JLabel("Data Fim");
		lblVendaDataFim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVendaDataFim.setBounds(10, 85, 100, 25);

		panelVendas.add(lblVendaDataInicio);
		panelVendas.add(lblVendaDataFim);

		dataInicialVenda = new JDateChooser();
		dataInicialVenda.setBounds(10, 45, 160, 27);
		panelVendas.add(dataInicialVenda);

		dataFimVenda = new JDateChooser();
		dataFimVenda.setBounds(10, 118, 160, 27);
		panelVendas.add(dataFimVenda);

		// ****************************************************************

		JPanel panelEstoque = new JPanel();
		panelEstoque.setBackground(Color.WHITE);
		tabbedPane.addTab("Estoque", null, panelEstoque, null);
		panelEstoque.setLayout(null);

		JLabel lblEstoqueDataInicio = new JLabel("Data In\u00EDcio");
		lblEstoqueDataInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstoqueDataInicio.setBounds(10, 10, 100, 25);

		JLabel lblEstoqueDataFim = new JLabel("Data Fim");
		lblEstoqueDataFim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstoqueDataFim.setBounds(10, 85, 100, 25);

		panelEstoque.add(lblEstoqueDataFim);
		panelEstoque.add(lblEstoqueDataInicio);

		dataInicialEstoque = new JDateChooser();
		dataInicialEstoque.setBounds(10, 45, 160, 27);
		panelEstoque.add(dataInicialEstoque);

		dataFimEstoque = new JDateChooser();
		dataFimEstoque.setBounds(10, 118, 160, 27);
		panelEstoque.add(dataFimEstoque);

		geraGrafico();
		add(getGrafico());
		
		ChartPanel chPanel = new ChartPanel(grafico);
		chPanel.setBounds(100, 80, 500, 3000);
		panelEstoque.add(chPanel);
;	}

	public void geraGrafico() {
		XYSeries produtos = new XYSeries("Produto");
		produtos.add(1995, 0.5);
		produtos.add(2000, 3.0);
		produtos.add(2010, 20.0);
		produtos.add(2020, 50.0);
		XYDataset produtosEmLinhas = new XYSeriesCollection(produtos);

		grafico = ChartFactory.createXYAreaChart("Produtos Mais Vendidos", "Nome", "Quantidade", produtosEmLinhas,
				org.jfree.chart.plot.PlotOrientation.VERTICAL, true, false, false);

		try {
			ChartUtilities.saveChartAsJPEG(new java.io.File("GráficoProdutosMaisVendidos.jpg"), grafico, 500, 300);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public JPanel getGrafico() {
		return new ChartPanel(grafico);
	}
}
