package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudent(){

        Student st1 = new Student("Taras", 4, 10.5);
        Student st2 = new Student("Student", 3, 12.8);
        Student st3 = new Student("Other Student", 1, 8.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);

    }

    public List<Student> getStudents(){

        System.out.println("start of students work");

        students.get(1);


        System.out.println("INFO about students: ");
        System.out.println(students);

        return students;
    }

}
