package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo1 {

    @Test
    public void testcasePass() {
        Assert.assertEquals(sum(4,5),9);
    }

    @Test
    public void testcaseFail() {
        Assert.assertEquals(sum(3,4),8);
    }


    public int sum(int a, int b) {
        return a+b;
    }


}
