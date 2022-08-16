package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {


    @AfterThrowing(pointcut = "execution (* getStudents(..))", throwing = "exception")
    public void afterThrowing(Throwable exception){
        System.out.println("afterThrowing: EXCEPTION !" + exception);
    }

    @Before("execution (* getStudents(..))")
    public void beforeGetStudentsLoggingAdvice() {
        System.out.println("beforeGetStudentsLoggingAdvice: Log @Before getStudents");
    }

    @AfterReturning(pointcut = "execution (* getStudents(..))", returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {

        Student firstSt = students.get(0);
        String nameSurname = "Mr. " + firstSt.getSurname();
        firstSt.setSurname(nameSurname);

        double avGrade = firstSt.getAverageGrade() + 99.0;
        firstSt.setAverageGrade(avGrade);


        System.out.println("afterReturningGetStudentsLoggingAdvice: Log @AfterReturning getStudents");
    }

    @After("execution (* get*(..))")
    public void afterGetStudentAdvice(){
        System.out.println("afterGetStudentAdvice: after Advice");
    }

}
