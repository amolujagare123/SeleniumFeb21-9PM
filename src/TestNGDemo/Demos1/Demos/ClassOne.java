package TestNGDemo.Demos1.Demos;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassOne {




    @Test
    public void classOneTest1()
    {
        System.out.println("classOneTest1");
    }

    @Test (groups = "email")
    public void classOneTest2()
    {
        System.out.println("classOneTest2");
    }



    @Test
    public void classOneTest3()
    {


        System.out.println("classOneTest3");
    }



}
