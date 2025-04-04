package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many input sizes to test
        System.out.print("How many input sizes should be tested? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        // Generate size array: 10, 20, 30, ..., count*10
        int[] sizes = new int[count];
        for (int i = 0; i < count; i++) {
            sizes[i] = (i + 1) * 10;
        }

        // Arrays to store execution times for each case
        long[] bestTimes = new long[count];
        long[] avgTimes = new long[count];
        long[] worstTimes = new long[count];

        // Print table header
        System.out.println();
        System.out.printf("+--------+------------+---------------+--------------+%n");
        System.out.printf("| Inputs | Best (ns)  | Average (ns)  | Worst (ns)   |%n");
        System.out.printf("+--------+------------+---------------+--------------+%n");

        // Loop over each input size and measure sort time
        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];

            // Measure best case

            // Generate the "best case" input array of size
            // This array is already sorted in ascending order: [0, 1, 2, ...]
            int[] best = InsertionSortAnalysis.generateBestCase(size);

            // Record the current time in nanoseconds before sorting begins
            long startBest = System.nanoTime();

            // Perform insertion sort on the best case array
            InsertionSortAnalysis.insertionSort(best);

            // Calculate the elapsed time in nanoseconds by subtracting the start time from
            // the current time
            // This represents how long it took to sort the already sorted array
            bestTimes[i] = System.nanoTime() - startBest;

            // Measure average case
            int[] avg = InsertionSortAnalysis.generateAverageCase(size);
            long startAvg = System.nanoTime();
            InsertionSortAnalysis.insertionSort(avg);
            avgTimes[i] = System.nanoTime() - startAvg;

            // Measure worst case
            int[] worst = InsertionSortAnalysis.generateWorstCase(size);
            long startWorst = System.nanoTime();
            InsertionSortAnalysis.insertionSort(worst);
            worstTimes[i] = System.nanoTime() - startWorst;

            // Print row of results
            System.out.printf("| %-6d | %-10d | %-13d | %-12d |%n",
                    size, bestTimes[i], avgTimes[i], worstTimes[i]);
        }

        System.out.printf("+--------+------------+---------------+--------------+%n");

        // Wait for user input before showing chart
        System.out.println("\nPress ENTER to display the chart...");
        scanner.nextLine();

        // Call chart display
        SortChart.showChart(sizes, bestTimes, avgTimes, worstTimes);
    }
}
