package assignment6;

import java.util.Objects;

public class Lion implements Animal {
	//instance variables
    private String name;
    private int age;
    private String species;
    private String color;

    //constructor
    public Lion(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
	//move()
    public void move() {
        System.out.println("The lion prowls gracefully.");
    }
    @Override
	//makeSound()
    public void makeSound() {
        System.out.println("Roar!");
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

  
    @Override
	//equals()
		// Check for reference equality
		// Check for null or different class
		// Compare fields for logical equality
    public boolean equals(Object obj) {
        
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Lion other = (Lion) obj;
        return age == other.age &&
                Objects.equals(name, other.name) &&
                Objects.equals(species, other.species) &&
                Objects.equals(color, other.color);
    }
    
    @Override
	//toString()
    public String toString() {
        return String.format(
            "Lion [Name: %s, Age: %d, Species: %s, Color: %s]",
            name, age, species, color);
    }

}
