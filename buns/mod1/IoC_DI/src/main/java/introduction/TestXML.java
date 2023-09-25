package introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXML {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = context.getBean("myPerson", Person.class);
        person.callPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());

        context.close();
    }
}
