package example;

public class Person {
    private final String name;
    public final int age;
    public final int salary;

    public Person(String name, int age, int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getSalary(){
        return salary;
    }

}
