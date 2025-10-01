
package patient;

public class Patient {
	    // Fields
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    private String emergencyPhone;
	    private String emergencyContactName;
	    private String streetAddress;
	    private String city;
	    private String state;
	    private String zipCode;

	    // No-argument constructor
	    public Patient() {
	        firstName = "";
	        middleName= "";
	        lastName = "";
	        emergencyPhone = "";
	        emergencyContactName = "";
	        streetAddress= "";
	        city= "";
	        state="";
	        zipCode="";
	           
	    }
	    
	    public Patient(String fName, String mName, String lName) {
	        firstName = fName;
	        middleName = mName;
	        lastName = lName;
	        // Other fields initialized empty
	        emergencyPhone = "";
	        emergencyContactName = "";
	        streetAddress = "";
	        city = "";
	        state = "";
	        zipCode = "";
	       
	    }

	    
	    public Patient(String fName, String mName, String lName,
                String phone, String emergencyName, 
                String street, String cityName, String st, String zip) {
     firstName = fName;
     middleName = mName;
     lastName = lName;
     emergencyPhone = phone;
     emergencyContactName = emergencyName;
     streetAddress = street;
     city = cityName;
     state = st;
     zipCode = zip;
    
 }

	    // Setter methods (no 'this', different parameter names)
	    public void setFirstName(String fName) {
	        firstName = fName;
	    }
	    public void setMiddleName(String mName) {
	        middleName = mName;
	    }
 
	    public void setLastName(String lName) {
	        lastName = lName;
	    }

	    public void setPhoneNumber(String phone) {
	        emergencyPhone = phone;
	    }

	    public void setEmergencyContactName(String contactName) {
	        emergencyContactName = contactName;
	    }

	    public void setStreetAddress(String street) {
	        streetAddress = street;
	    }
	    public void setCity(String cityName) {
	        city = cityName;
	    }
	    public void setState(String st) {
	        state = st;
	    }
	    public void setZipCode(String zip) {
	        zipCode = zip;
	    }
	    // Methods to build full name and emergency contact
	    public String buildFullName() {
	        return firstName + " " + middleName + " " + lastName;
	    }

	    public String buildEmergencyContact() {
	        return emergencyContactName + " " + emergencyPhone;
	    }
	    
	    public String buildAddress() {
	        return streetAddress + ", " + city + ", " + state + " " + zipCode;
	    }

	 // Display method
	    @Override
	    public String toString() {
	        return "Patient info:\n" +
	               "Name: " + buildFullName() + "\n" +
	               "Address: " + buildAddress() + "\n" +
	               "Emergency Contact: " + buildEmergencyContact() + "\n";
	    }

}

