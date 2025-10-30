package plot;


public class ManagementCompany {
	// attributes
    private String name;
    private String taxID;
    private double mgmFeePer;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;
    
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
    // constructors 
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0.0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFeePer) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(0,0, MGMT_WIDTH,MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
         
    }



    public ManagementCompany(String name, String taxID, double mgmFeePer,
                             int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFeePer;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    // copy constructor 
    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer,
             otherCompany.plot.getX(), otherCompany.plot.getY(),
             otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
        this.numberOfProperties = otherCompany.numberOfProperties;
    }
    
    /**
     * Adds a property to the management company's property list.
     * Creates a new Property object using the given parameters.
     *
     * @param name the name of the property
     * @param city the city where the property is located
     * @param rent the rental amount for the property
     * @param owner the name of the property's owner
     * @return index of the property if successfully added;
     *         -1 if array is full;
     *         -2 if property is null;
     *         -3 if property plot is not within the management company's plot;
     *         -4 if property plot overlaps with another property.
     */
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    /**
     * Adds a property to the management company's property list.
     * Creates a new Property object using the given parameters including plot dimensions.
     *
     * @param name the name of the property
     * @param city the city where the property is located
     * @param rent the rental amount for the property
     * @param owner the name of the property's owner
     * @param x the x-coordinate of the property's plot
     * @param y the y-coordinate of the property's plot
     * @param width the width of the property's plot
     * @param depth the depth of the property's plot
     * @return index of the property if successfully added;
     *         -1 if array is full;
     *         -2 if property is null;
     *         -3 if property plot is not within the management company's plot;
     *         -4 if property plot overlaps with another property.
     */
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    /**
     * Adds a given Property object to the management company's property list.
     *
     * @param property the Property object to be added
     * @return index of the property if successfully added;
     *         -1 if array is full;
     *         -2 if property is null;
     *         -3 if property plot is not within the management company's plot;
     *         -4 if property plot overlaps with another property.
     */
    public int addProperty(Property property) {
        if (isPropertiesFull()) return -1;
        if (property == null) return -2;
        if (!plot.encompasses(property.getPlot())) return -3;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot()))
                return -4;
        }

        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    /**
     * Checks if the properties array is full.
     *
     * @return true if the array has reached the maximum capacity, false otherwise
     */
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    /**
     * Gets the number of properties currently managed.
     *
     * @return number of properties in the array
     */
    public int getPropertiesCount() {
        return numberOfProperties;
    }

    /**
     * Checks if the management fee percentage is valid.
     * The valid range is 0% to 100%.
     *
     * @return true if the fee is between 0 and 100, false otherwise
     */
    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    /**
     * Calculates the total rent of all properties managed by this company.
     *
     * @return the total rent amount
     */
    public double getTotalRent() {
        double total = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }

    /**
     * Finds and returns the property with the highest rent.
     *
     * @return the Property object with the highest rent;
     *         null if there are no properties
     */
    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) return null;
        Property highest = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highest.getRentAmount()) {
                highest = properties[i];
            }
        }
        return highest;
    }

    /**
     * Removes (nullifies) the last property in the properties array.
     */
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    /**
     * Returns a string representation of all properties managed by the company,
     * along with the total management fee.
     *
     * @return formatted string containing property list and total fee
     */
    
    @Override
    public String toString() {
        if (numberOfProperties == 0)
            return "No properties added yet.";

        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name)
          .append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                sb.append(properties[i].toString()).append("\n");
            }
        }

        sb.append("______________________________________________________\n");
        double totalManagementFee = getTotalRent() * mgmFeePer / 100.0;
        sb.append("Total management fee: ").append(totalManagementFee);

        return sb.toString();
    }
    public String toJUnitString() {
        return plot.toString(); 
    }

    public Plot getPlot() {
        return new Plot(plot);
    }


	public String getName() {
		
		return name;
	}
	

}
