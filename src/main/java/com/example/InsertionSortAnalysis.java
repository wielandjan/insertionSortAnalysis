package com.example;

public class InsertionSortAnalysis {

    /**
     * Standard Insertion Sort Algorithm.
     * It builds the sorted array one element at a time by shifting larger elements
     * to the right.
     *
     * Time Complexity:
     * - Best Case: Ω(n) - already sorted
     * - Average Case: Θ(n²) - random elements
     * - Worst Case: O(n²) - reversed order
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Current element to insert
            int j = i - 1;

            // Shift larger elements to the right
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key at the correct position
            arr[j + 1] = key;
        }
    }

    /**
     * Generates a sorted array (best case for Insertion Sort)
     * "generateBestCase(10) --> [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]"
     */
    public static int[] generateBestCase(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    /**
     * Generates a reverse-sorted array (worst case for Insertion Sort)
     * "generateWorstCase(10) --> [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
     * "
     */
    public static int[] generateWorstCase(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    /**
     * Generates an array with random elements (average case)
     * generateAverageCase(10) --> [3, 7, 2, 8, 1, 4, 9, 0, 5, 6]
     */
    public static int[] generateAverageCase(int n) {
        int[] arr = new int[n];
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(n);
        }
        return arr;
    }
}
