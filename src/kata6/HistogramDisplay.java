package kata6;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay<T> extends ApplicationFrame {
    
    private final Histogram<T> histogram;
    private final String xAxisName;
    
    public HistogramDisplay(Histogram<T> histogram, String horizontalAxisName) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.xAxisName = horizontalAxisName;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(600, 400));
        return chartPanel;
        
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart(null, xAxisName, "Número", dataSet, PlotOrientation.VERTICAL, false, false, false);
        return chart;
        
        
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", (Comparable) key);
        }
        return dataset;
    }
    
    public void execute() {
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
