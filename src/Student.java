// Implementing the Comprable interface to be able to compare Student objects
public class Student implements Comparable<Student>{

    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        if (other == null)
            return -1;

        if (name.equals(other.name) && age == other.age)
            return 1;

        return -1;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                "\nAge: " + age;
    }

}
