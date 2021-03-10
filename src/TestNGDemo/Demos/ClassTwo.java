package TestNGDemo.Demos;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassTwo {

    @Test
    public void classTwoTest1()
    {
        System.out.println("classTwoTest1");
    }

    @Test (groups = "email")
    public void classTwoTest2()
    {
        System.out.println("classTwoTest2");
    }

    @Parameters({"myOs","myUrl","browser"})
    @Test
    public void classTwoTest3(String os,String myUrl,String br)
    {

        System.out.println("url="+myUrl);
        System.out.println("os="+os);
        System.out.println("browser="+br);

        System.out.println("classTwoTest3");
    }


    @BeforeSuite
    public void beforeMySuite()
    {
        System.out.println("beforeMySuite");
    }

    @AfterSuite
    public void afterMySuite()
    {
        System.out.println("afterMySuite");
    }
}
