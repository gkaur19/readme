package TwoDimRaggedArrayUtility;

public class HolidayBonus {

    // Default bonus values
    private static final double HIGH_BONUS = 5000;
    private static final double LOW_BONUS = 1000;
    private static final double OTHER_BONUS = 2000;

    public static double[] calculateHolidayBonus(double[][] data,
                                                 double highBonus,
                                                 double lowBonus,
                                                 double otherBonus) {
        int stores = data.length;
        double[] bonuses = new double[stores];

        if (stores == 0) return bonuses;

        int maxCols = 0;
        for (double[] row : data)
            if (row.length > maxCols) maxCols = row.length;

        for (int col = 0; col < maxCols; col++) {
            double maxVal = Double.NEGATIVE_INFINITY;
            double minVal = Double.POSITIVE_INFINITY;
            boolean anyPositive = false;

            for (int r = 0; r < stores; r++) {
                if (col < data[r].length) {
                    double val = data[r][col];
                    if (val > 0) {
                        anyPositive = true;
                        if (val > maxVal) maxVal = val;
                        if (val < minVal) minVal = val;
                    }
                }
            }

            if (!anyPositive) continue;

            for (int r = 0; r < stores; r++) {
                if (col < data[r].length) {
                    double val = data[r][col];
                    if (val <= 0) continue;
                    if (val == maxVal) bonuses[r] += highBonus;
                    else if (val == minVal) bonuses[r] += lowBonus;
                    else bonuses[r] += otherBonus;
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data,
                                                    double highBonus,
                                                    double lowBonus,
                                                    double otherBonus) {
        double[] arr = calculateHolidayBonus(data, highBonus, lowBonus, otherBonus);
        double sum = 0.0;
        for (double v : arr) sum += v;
        return sum;
    }

    // Overloaded methods with default bonus values
    public static double[] calculateHolidayBonus(double[][] data) {
        return calculateHolidayBonus(data, HIGH_BONUS, LOW_BONUS, OTHER_BONUS);
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        return calculateTotalHolidayBonus(data, HIGH_BONUS, LOW_BONUS, OTHER_BONUS);
    }
    
  

}
