package plot;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {

    private ManagementCompany company;
    private Property prop1, prop2, prop3;

    @Before
    public void setUp() {
        company = new ManagementCompany("AlphaMgmt", "123456789", 5);

        // Properties with different positions, no overlaps
        prop1 = new Property("GreenVilla", "OakCity", 1500, "Alice", 0, 0, 3, 3);
        prop2 = new Property("BlueHouse", "OakCity", 2000, "Bob", 3, 0, 3, 3);
        prop3 = new Property("RedApartment", "OakCity", 1800, "Charlie", 6, 0, 3, 3);
    }

    @After
    public void tearDown() {
        company = null;
        prop1 = prop2 = prop3 = null;
    }

    @Test
    public void testAddMultipleProperties() {
        assertEquals(0, company.addProperty(prop1));
        assertEquals(1, company.addProperty(prop2));
        assertEquals(2, company.addProperty(prop3));
        assertEquals(3, company.getPropertiesCount());
    }

    @Test
    public void testAddPropertyOverlapFails() {
        company.addProperty(prop1);
        Property overlapping = new Property("OverlapHouse", "OakCity", 1700, "Dave", 2, 1, 3, 3);
        assertEquals(-4, company.addProperty(overlapping));
    }

    @Test
    public void testAddPropertyOutOfBoundsFails() {
        Property outside = new Property("OutOfBounds", "OakCity", 2100, "Eve", 9, 9, 3, 3);
        assertEquals(-3, company.addProperty(outside));
    }

    @Test
    public void testGetTotalRent() {
        company.addProperty(prop1);
        company.addProperty(prop2);
        company.addProperty(prop3);
        double expectedTotal = 1500 + 2000 + 1800;
        assertEquals(expectedTotal, company.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty() {
        company.addProperty(prop1);
        company.addProperty(prop2);
        company.addProperty(prop3);
        Property highest = company.getHighestRentProperty();
        assertEquals("BlueHouse", highest.getPropertyName());
    }

    @Test
    public void testPropertiesFull() {
        company.addProperty("P1", "CityX", 1000, "Owner1", 0, 0, 2, 2);
        company.addProperty("P2", "CityX", 1100, "Owner2", 2, 0, 2, 2);
        company.addProperty("P3", "CityX", 1200, "Owner3", 4, 0, 2, 2);
        company.addProperty("P4", "CityX", 1300, "Owner4", 6, 0, 2, 2);
        company.addProperty("P5", "CityX", 1400, "Owner5", 8, 0, 2, 2);
        assertTrue(company.isPropertiesFull());
    }
}
