package yurchello.guava.examples.core;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CoreTest {

    @Test
    public void testCore() throws Exception {
        Person person1 = new Person();
        person1.setFirstName("name1");
        person1.setLastName("last1");
        person1.setMiddleName("mid1");
        person1.setZipCode(1);

        Person person2 = new Person();
        person2.setFirstName("name2");
        person2.setLastName("last2");
        person2.setMiddleName("mid2");
        person2.setZipCode(2);

        int result = person1.compareTo(person2);
        System.out.println(result);
        System.out.println(person1);
        System.out.println(person1.toString());
    }
}