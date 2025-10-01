package patient;


		
		public class Procedure {
		    // Fields
		 private String procedureName;
		 private String procedureDate;
		 private String doctorName;
		 private double procedureCharges;

		    // No-arg constructor
		    public Procedure() {
		        procedureName = "";
		        procedureDate = "";
		        doctorName = "";
		        procedureCharges = 0.0;
		    }

		    // Constructor with procedure name and date
		    public Procedure(String name, String date) {
		        procedureName = name;
		        procedureDate = date;
		        doctorName = "";
		        procedureCharges = 0.0;
		    }

		    // Constructor with all attributes
		    public Procedure(String name, String date, String doctor, double charges) {
		        procedureName = name;
		        procedureDate = date;
		        doctorName = doctor;
		        procedureCharges = charges;
		    }

		 // Mutators (setters)
		    public void setProcName(String name) {
		        procedureName = name;
		    }

		    public void setProcDate(String date) {
		        procedureDate = date;
		    }

		    public void setDoctorName(String doctor) {
		        doctorName = doctor;
		    }

		    public void setProcCharges(double charges) {
		        procedureCharges = charges;
		    }
		    
		    // Accessors (getters)
		    public String getProcName() {
		        return procedureName;
		    }

		    public String getProcDate() {
		        return procedureDate;
		    }

		    public String getDoctorName() {
		        return doctorName;
		    }

		    public double getProcCharges() {
		        return procedureCharges;
		    }

		    

		    // Display method
		    @Override
		    public String toString() {
		        return "Procedure: " + getProcName() + "\n" +
		               "Procedure Date: " + getProcDate() + "\n" +
		               "Practitioner: " + getDoctorName() + "\n" +
		               "Charge: $" + getProcCharges() + "\n";
		    }



	}


