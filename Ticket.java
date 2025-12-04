package assignment6;

public class Ticket {
    private double basePrice;
    private String dayOfWeek;
    private int age;

    public Ticket(String dayOfWeek, double basePrice, int age) {
        this.basePrice = basePrice;
        this.age = age;
        this.dayOfWeek = dayOfWeek.toLowerCase();
    }

    // Calculate ticket price based on day of week and age
    public double calculatePrice() {
        double price = basePrice;
        // Apply discounts for weekdays
        if (dayOfWeek.equals("MONDAY") ||
                dayOfWeek.equals("TUESDAY") ||
                dayOfWeek.equals("WEDNESDAY") ||
                dayOfWeek.equals("THURSDAY") ||
                dayOfWeek.equals("FRIDAY")) {

                price *= 0.90;
            }
        // Apply age-based discounts
        if (age <= 12) {
            // Child (10% off)
            price *= 0.90;
        } else if (age <= 25) {
            // Student (10% off)
            price *= 0.90;
        } else if (age >= 65) {
            // Senior (5% off)
            price *= 0.95;
        }

        return price;
    }

    // Display the ticket details
    public void displayTicketDetails() {
        System.out.printf("Ticket Details: [Age: %d, Day: %s, Price: $%.2f]%n",
                          age, dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), calculatePrice());
    }

    @Override
    public String toString() {
        return String.format("Ticket [Day: %s, Age: %d, Price: $%.2f]",
                             dayOfWeek.substring(0, 1).toUpperCase() + dayOfWeek.substring(1), 
                             age, calculatePrice());
    }
}