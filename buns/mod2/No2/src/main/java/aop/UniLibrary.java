package aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")

public class UniLibrary extends AbstractLibrary {
    public void getBook(Book book) {
        System.out.println("Мы берём книгу " + book.getName());
    }
}
