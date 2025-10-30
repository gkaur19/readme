package plot;

public class Property {
	//attributes
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;
    
    // constructors 
    public Property() {
        this.propertyName = "";
        this.city = "";
        this.owner = "";
        this.rentAmount = 0.0;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner,
                    int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // copy constructor
    public Property(Property otherProperty) {
        this(otherProperty.propertyName, otherProperty.city, otherProperty.rentAmount,
             otherProperty.owner, otherProperty.plot.getX(), otherProperty.plot.getY(),
             otherProperty.plot.getWidth(), otherProperty.plot.getDepth());
    }
    
    // getter and setter method
    public String getPropertyName() { return propertyName; }
    public String getCity() { return city; }
    public double getRentAmount() { return rentAmount; }
    public String getOwner() { return owner; }
    public Plot getPlot() { return new Plot(plot); }

    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
    public void setCity(String city) { this.city = city; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }
    public void setOwner(String owner) { this.owner = owner; }
    
    // toString method to represent a Property instance
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}