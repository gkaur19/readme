package TwoDimRaggedArrayUtility;

import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        List<double[]> rows = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] tokens = line.split("\\s+");
            double[] row = new double[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                try {
                    row[i] = Double.parseDouble(tokens[i]);
                } catch (NumberFormatException e) {
                    row[i] = 0.0;
                }
            }
            rows.add(row);
        }
        scanner.close();
        double[][] result = new double[rows.size()][];
        for (int i = 0; i < rows.size(); i++) result[i] = rows.get(i);
        return result;
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            for (double[] row : data) {
                if (row == null || row.length == 0) {
                    pw.println();
                    continue;
                }
                for (int j = 0; j < row.length; j++) {
                    pw.print(row[j]);
                    if (j < row.length - 1) pw.print(" ");
                }
                pw.println();
            }
        }
    }


    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (double[] row : data)
            for (double v : row) total += v;
        return total;
    }

    public static double getRowTotal(double[][] data, int row) {
        if (row < 0 || row >= data.length) return 0.0;
        double total = 0.0;
        for (double v : data[row]) total += v;
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        for (double[] row : data) {
            if (col < row.length) total += row[col];
        }
        return total;
    }

    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data)
            for (double v : row)
                if (v > max) max = v;
        return max == Double.NEGATIVE_INFINITY ? 0.0 : max;
    }

    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data)
            for (double v : row)
                if (v < min) min = v;
        return min == Double.POSITIVE_INFINITY ? 0.0 : min;
    }

    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) return 0.0;
        double max = data[row][0];
        for (double v : data[row]) if (v > max) max = v;
        return max;
    }

    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) return 0.0;
        double min = data[row][0];
        for (double v : data[row]) if (v < min) min = v;
        return min;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] > max) max = row[col];
        }
        return max == Double.NEGATIVE_INFINITY ? 0.0 : max;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] < min) min = row[col];
        }
        return min == Double.POSITIVE_INFINITY ? 0.0 : min;
    }

    public static int maxColumns(double[][] data) {
        int max = 0;
        for (double[] row : data)
            if (row.length > max) max = row.length;
        return max;
    }
}

