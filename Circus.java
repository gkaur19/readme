package assignment6;

import java.util.ArrayList;
import java.util.List;

public class Circus {
    private List<Animal> animals;
    private List<Person> persons;
    private List<Building> buildings;
    private List<Ticket> tickets;

    public Circus() {
        animals = new ArrayList<>();
        persons = new ArrayList<>();
        buildings = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    // Add building
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    // Display building
    public void displayAllBuildings() {
        for (Building b : buildings) {
            System.out.println(b.toString());
        }
    }

    // Add person
    public void addPerson(Person person) {
        persons.add(person);
    }

    // Display person
    public void displayAllPersons() {
        for (Person p : persons) {
            System.out.println(p.toString());
        }
    }


    // Add animal
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Display animal using toString() method
    public void displayAllAnimals() {
        for (Animal a : animals) {
            System.out.println(a.toString());
        }
    }

    // Selection sort to sort animals by age
    public void sortAnimalsByAge() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getAge() < animals.get(minIndex).getAge()) {
                    minIndex = j;
                }
            }
            Animal temp = animals.get(i);
            animals.set(i, animals.get(minIndex));
            animals.set(minIndex, temp);
        }
    }
    
    // Selection sort to sort animals by name
    public void sortAnimalsByName() {
        for (int i = 0; i < animals.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < animals.size(); j++) {
                if (animals.get(j).getName().compareTo(animals.get(minIndex).getName()) < 0) {
                    minIndex = j;
                }
            }
            // Swap
            Animal temp = animals.get(i);
            animals.set(i, animals.get(minIndex));
            animals.set(minIndex, temp);
        }
    }
    // Search for an animal by name
    public Animal searchAnimalByName(String name) {
        for (Animal a : animals) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null; // not found
    }

    // Add ticket
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    // Generate ticket
    public Ticket generateTicket(String dayOfWeek, double basePrice, int age) {
        Ticket ticket = new Ticket(dayOfWeek, basePrice, age);  // Pass dayOfWeek, basePrice, age to Ticket constructor
        addTicket(ticket);
        return ticket;
    }
    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
