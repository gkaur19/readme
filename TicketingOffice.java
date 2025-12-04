package assignment6;

public class TicketingOffice implements Building {
	//instance variables
    private String color;
    private double length;
    private double width;
    private String buildingType;

    //constructor
    public TicketingOffice(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.buildingType = "Ticketing Office";
    }

    @Override
	//setSize()
    public void setSize(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
	//getLength()
    public double getLength() {
        return length;
    }

    @Override
	//getWidth()
    public double getWidth() {
        return width;
    }
    
    @Override
	//setColor()
    public void setColor(String color) {
        this.color = color;
    }


    @Override
	//getColor()
    public String getColor() {
        return color;
    }

    @Override
	//setBuildingType()
    public void setBuildingType(String type) {
        this.buildingType = type;
    }


    @Override
	//getBuildingType()
    public String getBuildingType() {
        return buildingType;
    }
    
    @Override
	//toString()
    public String toString() {
        return String.format(
            "TicketingOffice[color=%s, length=%.2f, width=%.2f, type=%s]",
            color, length, width, buildingType
        );
    }

}
