package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student student1 = new Student("Pavel Ahaimov", 3, 90.36);
        Student student2 = new Student("Mihail Ivanov", 2, 83.45);
        Student student3 = new Student("Elena Sidorova", 1, 91.81);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public List<Student> getStudents() {
        System.out.println("Начало работы Метода getStudents");
//        System.out.println(students.get(3));
        System.out.println("Inf from method getStudents:");
        System.out.println(students);
        return students;
    }
}
