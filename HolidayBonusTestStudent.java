package TwoDimRaggedArrayUtility;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class HolidayBonusTestStudent {

    private double[][] sales;

    @Before
    public void setUp() throws Exception {
        sales = new double[][] {
            {1000, 2000, 3000},
            {1500, 2500, 3500},
            {1200, 2200, 3200}
        };
    }

    @After
    public void tearDown() throws Exception {
        sales = null;
    }

    @Test
    public void testCalculateHolidayBonus() {
        double[] expected = HolidayBonus.calculateHolidayBonus(sales, 5000, 1000, 2000);
        double[] actual = HolidayBonus.calculateHolidayBonus(sales);
        assertArrayEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double expected = HolidayBonus.calculateTotalHolidayBonus(sales, 5000, 1000, 2000);
        double actual = HolidayBonus.calculateTotalHolidayBonus(sales);
        assertEquals(expected, actual, 0.001);
    }
}
