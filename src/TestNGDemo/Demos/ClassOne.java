package TestNGDemo.Demos;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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


    @Parameters({"myOs","myUrl","browser"})
    @Test
    public void classOneTest3(String os,String myUrl,String br)
    {
        System.out.println("url="+myUrl);
        System.out.println("os="+os);
        System.out.println("browser="+br);

        System.out.println("classOneTest3");
    }



}
