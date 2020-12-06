import java.util.Comparator;
import java.util.PriorityQueue;

class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class AgeComp implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.age-o2.age;
    }
}
public class TestDemo4 {
    public static void main(String[] args) {
        AgeComp ageComp = new AgeComp();
        PriorityQueue<Animal> priorityQueue = new PriorityQueue<>(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o2.age - o1.age;
            }
        });
        priorityQueue.offer(new Animal("ss",45));
        priorityQueue.offer(new Animal("ll",25));
        System.out.println(priorityQueue);
    }
}
