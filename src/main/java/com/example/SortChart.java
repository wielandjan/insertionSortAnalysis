package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

/**
 * Utility class to generate and display a runtime chart using JFreeChart.
 */
public class SortChart {

    /**
     * Displays an XY-line chart comparing Insertion Sort runtimes.
     *
     * @param sizes the input sizes
     * @param best  best-case runtimes
     * @param avg   average-case runtimes
     * @param worst worst-case runtimes
     */
    public static void showChart(int[] sizes, long[] best, long[] avg, long[] worst) {
        // Create data series for each case
        XYSeries seriesBest = new XYSeries("Best Case");
        XYSeries seriesAverage = new XYSeries("Average Case");
        XYSeries seriesWorst = new XYSeries("Worst Case");

        // Fill each series with corresponding measured data
        for (int i = 0; i < sizes.length; i++) {
            seriesBest.add(sizes[i], best[i]);
            seriesAverage.add(sizes[i], avg[i]);
            seriesWorst.add(sizes[i], worst[i]);
        }

        // Combine all series into one dataset
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesBest);
        dataset.addSeries(seriesAverage);
        dataset.addSeries(seriesWorst);

        // Create the chart with axis labels and title
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Insertion Sort Runtime Analysis",
                "Array Size",
                "Time (ns)",
                dataset);

        // Access the plot to customize appearance
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        // Assign colors: green (best), blue (average), red (worst)
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.RED);

        // Optional: draw lines only (no shapes/points)
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        renderer.setSeriesShapesVisible(2, false);

        plot.setRenderer(renderer);

        // Display chart in a JFrame
        JFrame frame = new JFrame("Runtime Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
