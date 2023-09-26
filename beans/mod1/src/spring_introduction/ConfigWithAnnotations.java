package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

        //Dog myDog = context.getBean("dogBean", Dog.class);
        //myDog.say();
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }
}
