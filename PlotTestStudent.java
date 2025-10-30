package plot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {

    private Plot mainPlot, subPlot, overlapPlot, outsidePlot;

    @BeforeEach
    public void setUp() {
        mainPlot = new Plot(0, 0, 10, 10);
        subPlot = new Plot(2, 2, 3, 3);
        overlapPlot = new Plot(5, 5, 6, 6);
        outsidePlot = new Plot(9, 9, 5, 5);
    }

    @Test
    public void testDefaultConstructor() {
        Plot p = new Plot();
        assertEquals("0,0,1,1", p.toString());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals(0, mainPlot.getX());
        assertEquals(10, mainPlot.getWidth());
    }

    @Test
    public void testCopyConstructor() {
        Plot copy = new Plot(mainPlot);
        assertEquals(mainPlot.toString(), copy.toString());
    }

    @Test
    public void testEncompasses() {
        assertTrue(mainPlot.encompasses(subPlot));
        assertFalse(subPlot.encompasses(mainPlot));
    }

    @Test
    public void testOverlaps() {
        assertTrue(mainPlot.overlaps(overlapPlot));
        assertTrue(mainPlot.overlaps(outsidePlot));
    }

    @Test
    public void testToString() {
        assertEquals("0,0,10,10", mainPlot.toString());
    }
}
