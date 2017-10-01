package sortingAnalysis;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends JFrame{

	private static final long serialVersionUID = 1L;
	public static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	
	public LineChart(String title) {
		super(title);

		JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}
	
	private JPanel createChartPanel() {
	    String chartTitle = "Running times of sorting algorithms";
	    String categoryAxisLabel = "Input Array Size(n)";
	    String valueAxisLabel = "Time in milliseconds";
	 
	    JFreeChart chart = ChartFactory.createLineChart(chartTitle,
	            categoryAxisLabel, valueAxisLabel, this.dataset);
	    
	    CategoryPlot plot = chart.getCategoryPlot();
	    LineAndShapeRenderer renderer = new LineAndShapeRenderer();
	    plot.setRenderer(renderer);
	 
	    return new ChartPanel(chart);
	}
	
}