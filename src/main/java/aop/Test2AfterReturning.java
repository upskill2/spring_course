package aop;

import com.spring_intro.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2AfterReturning {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        University university = context.getBean("university", University.class);
        university.addStudent();


        try {
            List<Student> students = university.getStudents();
            System.out.println(students);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("exception " + e);;

        }


    }


}
