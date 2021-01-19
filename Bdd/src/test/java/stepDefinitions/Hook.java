package stepDefinitions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


public class Hook {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class ToDo...");
    }

    @Before
    public void before() {
        System.out.println("Before test ToDO...");
    }

    @After
    public void after() {
        System.out.println("After tests ToDO...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class ToDo...");
    }
}
