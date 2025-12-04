package assignment6;

public abstract class Person {
    private String name;
    private int age;
    private int yearsWorked;

    public Person(String name, int age, int yearsWorked) {
        this.name = name;
        this.age = age;
        this.yearsWorked = yearsWorked;
     }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYearsWorked() {
        return yearsWorked;
    }
    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Years Worked: %d",
                name, age, yearsWorked);
    }


}