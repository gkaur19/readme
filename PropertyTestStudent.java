package plot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {

    private Property property1, property2, property3;

    @BeforeEach
    public void setUp() {
        property1 = new Property("Lakeview", "Rockville", 2500.0, "John Doe");
        property2 = new Property("Hilltop", "Baltimore", 3000.0, "Mary Ann", 2, 3, 4, 5);
        property3 = new Property(property2); // copy constructor
    }

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount());
        assertEquals("", p.getOwner());
        assertEquals("0,0,1,1", p.getPlot().toString());
    }

    @Test
    public void testParameterizedConstructor() {
        assertEquals("Hilltop", property2.getPropertyName());
        assertEquals("Baltimore", property2.getCity());
        assertEquals(3000.0, property2.getRentAmount());
        assertEquals("Mary Ann", property2.getOwner());
        assertEquals("2,3,4,5", property2.getPlot().toString());
    }

    @Test
    public void testCopyConstructor() {
        assertEquals(property2.getPropertyName(), property3.getPropertyName());
        assertEquals(property2.getPlot().toString(), property3.getPlot().toString());
    }

    @Test
    public void testToString() {
        String expected = "Hilltop,Baltimore,Mary Ann,3000.0";
        assertEquals(expected, property2.toString());
    }
}
