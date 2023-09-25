package introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    private Pet pet;
    private String surname;
    private int age;

    @Autowired
    public Person(Pet pet) {
        this.pet = pet;
    }
//    public Person() {
//        System.out.println("Person created");
//    }

    public void callPet() {
        System.out.println("Hello Pet ! ");
        pet.say();
    }


    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

}
