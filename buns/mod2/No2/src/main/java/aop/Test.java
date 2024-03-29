package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("libraryBean", UniLibrary.class);
        Book book = context.getBean("book", Book.class);
//        uniLibrary.getBook(book);
        uniLibrary.addBook("Pavel",book);


        context.close();
    }
}
