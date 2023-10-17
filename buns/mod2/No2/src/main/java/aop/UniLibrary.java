package aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")

public class UniLibrary extends AbstractLibrary {
    public void getBook(Book book) {
        System.out.println("Мы берём книгу " + book.getName());
        System.out.println("-------------------------------------------------------");
    }
    public  void addBook(String person_name, Book book){
        System.out.println("Мы возвращаем книгу ");
        System.out.println("-------------------------------------------------------");
    }
    public String returnBook(){
        int a = 10/0;
        System.out.println("Мы возвращаем книгу ");
        return "Война и Мир";

    }

}
