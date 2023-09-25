package introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_annotation.xml");

        Person person = context.getBean("personBean", Person.class);
        person.callPet();
        context.close();
    }
}
