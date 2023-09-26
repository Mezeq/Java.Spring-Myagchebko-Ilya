package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//Java-Code(2)
public class Test5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig1.class);

        //Pet dog = context.getBean("dogBean", Pet.class);
        //dog.say();

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        context.close();
    }
}
