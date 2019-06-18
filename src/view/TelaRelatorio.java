package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.toedter.calendar.JDateChooser;

import controller.RelatorioController;
import model.ProdutoMaisVendido;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TelaRelatorio extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTotalPeriodo;
	private JPanel contentPane;
	private JButton btnBuscarEstoque, btnBuscarVendas;
	private JDateChooser dataInicialEstoque, dataFimEstoque, dataInicialVenda, dataFimVenda;
	private JFreeChart grafico;
	private ChartPanel panelGraficoVendas, panelGraficoEstoque;
	private RelatorioController controller = new RelatorioController();

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

		btnBuscarVendas = new JButton("Buscar");
		btnBuscarVendas.setBounds(45, 175, 90, 25);
		btnBuscarVendas.addActionListener(this);
		panelVendas.add(btnBuscarVendas);

		panelGraficoVendas = new ChartPanel(grafico);
		panelGraficoVendas.setBounds(188, 10, 500, 300);
		panelVendas.add(panelGraficoVendas);

		lblTotalPeriodo = new JLabel("Faturamento Total do Período");
		lblTotalPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalPeriodo.setBounds(188, 325, 500, 25);
		panelVendas.add(lblTotalPeriodo);

		// ******************** ESTOQUE ************************************

		JPanel panelEstoque = new JPanel();
		panelEstoque.setBackground(Color.WHITE);
		tabbedPane.addTab("Funcionários", null, panelEstoque, null);
		panelEstoque.setLayout(null);

		JLabel lblEstoqueDataInicio = new JLabel("Data Início");
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

		btnBuscarEstoque = new JButton("Buscar");
		btnBuscarEstoque.setBounds(45, 175, 90, 25);
		btnBuscarEstoque.addActionListener(this);
		panelEstoque.add(btnBuscarEstoque);

		panelGraficoEstoque = new ChartPanel(grafico);
		panelGraficoEstoque.setBounds(188, 10, 500, 300);
		panelEstoque.add(panelGraficoEstoque);

	}

	public void geraGraficoVendas(List<ProdutoMaisVendido> mais_vendidos) {
		DefaultPieDataset dataset = new DefaultPieDataset();

		for (ProdutoMaisVendido pmv : mais_vendidos) {
			dataset.setValue(pmv.getProduto().getNome(), pmv.getQtde_comprada());
		}

		grafico = ChartFactory.createPieChart("Top 5 Produtos Mais Vendidos", dataset, true, true, false);

		PiePlot plot = (PiePlot) grafico.getPlot();
		plot.setSimpleLabels(true);

		PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
				/* com porcentagem"{0}: {1} ({2})" */"{0}: {1}", new DecimalFormat("0"), new DecimalFormat("0%"));
		plot.setLabelGenerator(gen);

		panelGraficoVendas.setChart(grafico);
		lblTotalPeriodo.setText("Faturamento Total do Período = R$"
				+ controller.buscaTotalPeriodo(dataInicialVenda.getCalendar(), dataFimVenda.getCalendar()));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarVendas) {
			System.out.println(dataInicialVenda.getCalendar().getTime());
			List<ProdutoMaisVendido> mais_vendidos = new ArrayList<ProdutoMaisVendido>();
			mais_vendidos = controller.buscarProdutosMaisVendidos(dataInicialVenda.getCalendar(),
					dataFimVenda.getCalendar());
			geraGraficoVendas(mais_vendidos);
		}
	}
}
