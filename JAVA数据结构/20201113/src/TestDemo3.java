import java.util.Arrays;

class Person {
    public String name;
    public int age;
    public int score;

    public Person(String name, int age,int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

public class TestDemo3 {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("a",56,96);
        people[1] = new Person("d",45,89);
        people[2] = new Person("e",86,99);
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
        AgeComparator ageComparator = new AgeComparator();
        ScoreComparator scoreComparator = new ScoreComparator();
        Arrays.sort(people,scoreComparator);
        System.out.println("=========================");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }
}
