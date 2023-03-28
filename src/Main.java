import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList<Student> list= new LinkedList<>();
        list.addFirst(new Student("David", 30));
        list.addFirst(new Student("Harry", 30));
        list.addMiddle(new Student("A", 30), 1);
        list.addLast(new Student("B", 30));
        list.reverse();
        Student[] students = list.convertToArray();
        System.out.println(Arrays.toString(students));
        System.out.println(list.kthNodeFromTheEnd(2));
    }




}