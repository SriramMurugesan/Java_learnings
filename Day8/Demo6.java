import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedHashSet;








class Demo {
    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Ravi");
        students.add("Anu");
        students.add("Ravi"); // duplicate allowed

        System.out.println(students);
        System.out.println(students.get(1)); // access by index
    }
}


class Demo1 {
    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Chennai");
        cities.add("Bangalore");
        cities.add("Mumbai");

        cities.addFirst("Delhi");
        cities.addLast("Goa");

        System.out.println(cities);
    }
}


class Demo2 {
    public static void main(String[] args) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(5);

        System.out.println(dq);

        dq.removeLast();

        System.out.println(dq);
    }
}


class Demo3 {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println(pq.poll()); // highest priority (smallest)
        System.out.println(pq.poll());
    }
}


class Demo4 {
    public static void main(String[] args) {

        TreeSet<Integer> marks = new TreeSet<>();

        marks.add(80);
        marks.add(60);
        marks.add(90);
        marks.add(80); // duplicate removed

        System.out.println(marks);
    }
}


class Demo5 {
    public static void main(String[] args) {

        HashSet<String> skills = new HashSet<>();

        skills.add("Java");
        skills.add("Python");
        skills.add("Java"); // duplicate ignored

        System.out.println(skills);
    }
}


class Demo6 {
    public static void main(String[] args) {

        LinkedHashSet<String> names = new LinkedHashSet<>();

        names.add("Ravi");
        names.add("Anu");
        names.add("Kumar");

        System.out.println(names);
    }
}
