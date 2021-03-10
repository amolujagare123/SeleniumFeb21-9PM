package TestNGDemo.Demos;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassThree {

    @Test
    public void classThreeTest1()
    {
        System.out.println("classThreeTest1");
    }

    @Test (groups = "email")/* (enabled = false)*/
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }

    @Test
    public void classThreeTest3()
    {
        System.out.println("classThreeTest3");
    }








    @BeforeTest
    public void methodBeforeTest()
    {
        System.out.println("methodBeforeTest()");
    }

    @AfterTest
    public void methodAfterTest()
    {
        System.out.println("methodAfterTest()");
    }

}
