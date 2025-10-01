package patient;



import java.util.Scanner;

public class PatientDriverApp {

    // Display patient info using method from Patient class
    public static void displayPatient(Patient p) {
    	 System.out.println(p); // Calls toString() automatically
    }

    // Display procedure info
    public static void displayProcedure(Procedure proc) {
    	System.out.println(proc); // Calls toString() automatically
    }

    // Calculate total charges
    public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
        return p1.getProcCharges() + p2.getProcCharges() + p3.getProcCharges();
    }

    public static double getValidCharge(Scanner input) {
        double charge = -1;
    while (true) {
        System.out.print("Enter procedure charge (>=0): ");
        if (input.hasNextDouble()) {
            charge = input.nextDouble();
            if (charge >= 0) {
                input.nextLine(); // clear leftover newline
                return charge;    // return valid charge
            } else {
                System.out.println("Charge cannot be negative. Please try again.");
            }
        } else {
            System.out.println("Invalid input. Please enter a numeric value.");
            input.next(); // discard the invalid token
        }
    }
}
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ==== Patient Info Input ====
        Patient patient = new Patient();

        System.out.print("Enter first name: ");
        patient.setFirstName(input.nextLine());

        System.out.print("Enter middle name: ");
        patient.setMiddleName(input.nextLine());

        System.out.print("Enter last name: ");
        patient.setLastName(input.nextLine());

        System.out.print("Enter phone number: ");
        patient.setPhoneNumber(input.nextLine());

        System.out.print("Enter emergency contact name: ");
        patient.setEmergencyContactName(input.nextLine());

        System.out.print("Enter street address: ");
        patient.setStreetAddress(input.nextLine());

        System.out.print("Enter city: ");
        patient.setCity(input.nextLine());

        System.out.print("Enter state: ");
        patient.setState(input.nextLine());

        System.out.print("Enter ZIP code: ");
        patient.setZipCode(input.nextLine());
        
        
        //  Procedure 1 - using no-arg constructor 
        System.out.println("\nEnter details for Procedure 1:");
        Procedure proc1 = new Procedure();
        System.out.print("Procedure name: ");
        proc1.setProcName(input.nextLine());
        System.out.print("Procedure date (MM/DD/YYYY): ");
        proc1.setProcDate(input.nextLine());
        System.out.print("Practitioner name: ");
        proc1.setDoctorName(input.nextLine());
        proc1.setProcCharges(getValidCharge(input));

        //  Procedure 2 - using name and date constructor 
        System.out.println("\nEnter details for Procedure 2:");
        System.out.print("Procedure name: ");
        String name2 = input.nextLine();
        System.out.print("Procedure date (MM/DD/YYYY): ");
        String date2 = input.nextLine();
        Procedure proc2 = new Procedure(name2, date2);
        System.out.print("Practitioner name: ");
        proc2.setDoctorName(input.nextLine());
        
        proc2.setProcCharges(getValidCharge(input));

        //  Procedure 3 - using full constructor 
        System.out.println("\nEnter details for Procedure 3:");
        System.out.print("Procedure name: ");
        String name3 = input.nextLine();
        System.out.print("Procedure date (MM/DD/YYYY): ");
        String date3 = input.nextLine();
        System.out.print("Practitioner name: ");
        String doc3 = input.nextLine();
       
        double charge3=getValidCharge(input);
        
        
		Procedure proc3 = new Procedure(name3, date3, doc3, charge3);

        //  Output 
        System.out.println("\n=======================================");
        displayPatient(patient);

        System.out.println("\nProcedure Name    \tDate      \tPractitioner         \tCharges");
        System.out.println("---------------------------------------------------------------");
      
        displayProcedure(proc1);
        displayProcedure(proc2);
        displayProcedure(proc3);

        double total = calculateTotalCharges(proc1, proc2, proc3);
        System.out.printf("\nTotal Charges: $%,.2f\n", total);

        // Extra footer for assignment
        System.out.println("\nStudent Name: Gurleen Kaur");
        System.out.println("MC#: M24038390");
        System.out.println("Due Date: 10/01/2025");

        input.close();
    }
}
