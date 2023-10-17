package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test3 {
    public static void main(String[] args) {
        System.out.println("Main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary library = context.getBean("libraryBean", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("Вернули книгу: " + bookName);
        context.close();
        System.out.println("Main ends");
    }
}
