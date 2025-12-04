package assignment6;

import java.util.Objects;

public class Dog implements Animal, Cloneable {
    // Instance variables
    private String name;
    private int age;
    protected String species;
    protected String color;

    // Constructor
    public Dog(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    @Override
	//move()
    public void move() {
        System.out.println(name + " runs around energetically!");
    }
    @Override
	//makeSound()
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }

    @Override
	//getName()
    public String getName() {
        return name;
    }
	
    @Override
	//getAge()
    public int getAge() {
        return age;
    }

    @Override
	//clone()
    public Dog clone() {
        try {
            return (Dog) super.clone();  // shallow copy is fine since fields are primitives/Strings
        } catch (CloneNotSupportedException e) {
            return null; // Should never happen since we implemented Cloneable
        }
    }

    @Override
	//equals()
		// Check for reference equality
		// Check for null or different class
		// Compare fields for logical equality
    public boolean equals(Object obj) {
        // Reference equality
        if (this == obj) return true;

        // Null or different class
        if (obj == null || getClass() != obj.getClass()) return false;

        // Field comparison
        Dog other = (Dog) obj;
        return age == other.age &&
               Objects.equals(name, other.name) &&
               Objects.equals(species, other.species) &&
               Objects.equals(color, other.color);
    }

    @Override
	//toString() 
    public String toString() {
        return String.format("Dog[name=%s, age=%d, species=%s, color=%s]", 
                              name, age, species, color);
    }
    
}    
