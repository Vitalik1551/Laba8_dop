package example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"Cat", "Dog", "Frog", "Cow", "Fish", "Cat", "Cat", "Fish", "Pig", "Frog", "Frog", "Cat", "Dog", "Fish", "Frog",
                "Fish"};
        System.out.print("Самые частые слова: ");
        Stream.of(words).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey()).get().getValue()
                .stream().map(w -> w.getKey().toString()).forEach(s -> System.out.print(s + " "));
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Solah", 25, 34000));
        persons.add(new Person("Derry", 30, 72000));
        persons.add(new Person("Raava", 21, 40000));
        persons.add(new Person("Colly", 41, 51000));
        persons.add(new Person("Sam", 35, 69000));
        persons.add(new Person("Rikky", 23, 39000));
        persons.add(new Person("Mariya", 40, 56000));
        persons.add(new Person("Eveline", 31, 44000));
        persons.add(new Person("Mark", 27, 61000));
        persons.add(new Person("John", 38, 57000));
        persons.add(new Person("Benny", 37, 41000));
        persons.add(new Person("Sarah", 34, 36000));
        persons.add(new Person("Ann", 36, 36000));
        Double a = persons.stream().collect(Collectors.averagingInt(Person::getSalary));
        System.out.printf("\nСредняя зарплата среди указанных людей: %.2f\n", a);
        EldestPersons(persons, 7);

    }
    public static void EldestPersons(ArrayList<Person> persons, int n)
    {
        String str = persons.stream()
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .limit(n)
                .sorted((a, b) -> b.getName().toUpperCase().compareTo(a.getName().toUpperCase()))
                .filter(x->x.getSalary() >50000)
                .map(p -> p.getName())
                .sorted(Comparator.comparing(e->e.length()))
                .collect(Collectors.joining(", ",n + " самых старших сотрудников зовут: ",""));

        System.out.println(str);
    }

}