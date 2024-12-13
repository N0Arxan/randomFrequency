import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Integer> freq = new HashMap<>();


        for (int i = 0; i < 1000000; i++) {
            int num = new Random().nextInt(10);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }


        Map<Integer, Integer> freqSorted = new TreeMap<>(freq);

        // Create a dataset for the chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Add data to the dataset (X-axis is numbers and Y-axis is the frequency)
        for (Map.Entry<Integer, Integer> entry : freqSorted.entrySet()) {
            dataset.addValue(entry.getValue(), "Frequency", entry.getKey().toString());
        }


        JFreeChart chart = ChartFactory.createBarChart(
                "Number Frequency", // Chart Title
                "Number",           // X-Axis Label
                "Frequency",        // Y-Axis Label
                dataset             // Dataset
        );


        JFrame frame = new JFrame("Frequency Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}