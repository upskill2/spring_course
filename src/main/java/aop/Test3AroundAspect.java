package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3AroundAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        System.out.println("--------------Method starts------------");

        UniversityLibrary university = (UniversityLibrary) context.getBean("universityLibrary");

        String bookName =  university.returnBook();
        System.out.println(bookName);

        System.out.println("--------------Method completes------------");
    }
}
