package TwoDimRaggedArrayUtility;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] dataSet1;

    @Before
    public void setUp() throws Exception {
        dataSet1 = new double[][] {
            {1, 2, 3},
            {4, 5},
            {6, 7, 8, 9}
        };
    }

    @After
    public void tearDown() throws Exception {
        dataSet1 = null;
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), 0.001);
    }

    @Test
    public void testGetTotal() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), 0.001);
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0), 0.001);
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0), 0.001);
    }

    @Test
    public void testMaxColumns() {
        assertEquals(4, TwoDimRaggedArrayUtility.maxColumns(dataSet1));
    }
}
