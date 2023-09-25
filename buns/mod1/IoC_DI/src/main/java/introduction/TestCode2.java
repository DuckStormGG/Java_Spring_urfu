package introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCode2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CodeConfig2.class);

        Person person = context.getBean("personBean", Person.class);
        person.callPet();
    }
}
