package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1Before {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

        Book book = (Book) context.getBean("book");
        UniversityLibrary universityLibrary = (UniversityLibrary) context.getBean("universityLibrary");

        System.out.println("----get-book------");
        universityLibrary.getBook();

        System.out.println("----add-book------");
        universityLibrary.addBook("Taras", book);

        System.out.println("----return-book------");
    //    universityLibrary.returnBook();

        System.out.println("----add-magazine-------");
        universityLibrary.addMagazine();
    //    universityLibrary.getMagazine();
    //    universityLibrary.returnMagazine();

        System.out.println("----school-Book------");

        SchoolLibrary schoolLibrary = (SchoolLibrary) context.getBean("schoolLibrary");
   //     schoolLibrary.getBook();



    }
}
