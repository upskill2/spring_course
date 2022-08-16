package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary {

/*    public void getBook(Book book){
        System.out.println("The book from University Library " + book.getName());
    }*/

    // @Override
    public void getBook(){
        System.out.println("The book from University Library" );
    }

    public String returnBook(){

        int error = 10/0;
        System.out.println("text from return method");

      return "BOOK NAME IS ...";
    }

    public void getMagazine(){

        System.out.println("The magazine from University Library");
    }

    public void returnMagazine(){
        System.out.println("Returning magazine from University");
    }

    public void addBook(String person, Book book){
        System.out.println("Adding book from University");

    }

    public void addMagazine(){
        System.out.println("Adding magazine from University");
    }
}
