package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TESTNGAssertion {

    @Test
    public int getSum(int num, int num2){
        int sum=num*num2;
        return sum;
    }
    @Test
    public void validationSum(){
        double actualResult=getSum(5,6);
        double expectedResult=30;
        Assert.assertEquals(actualResult,expectedResult,"My numbers are 5 and 6");
    }

    public double getDivision(double num1, double num2){
        if (num1 >= num2) {
            return  num1/num2;
        }
        return num2/num1;

    }
  public int substraction(int num1, int num2){
      if (num1 >=num2) {
          return  num1-num2;
      }
      return num2-num1;
  }
  @Test
    public void validateDiv(){
        double actualResult=getDivision(8,2);
        double expectedResult=4;
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    public void validateSub() {
        int actualResult = substraction(8, 2);
        int expectedResult = 6;
        Assert.assertEquals(actualResult, expectedResult);

        double actualResultofDiv=getDivision(8,2);
        double expectedResultofDiv=4;
        Assert.assertEquals(actualResultofDiv,expectedResultofDiv);

    }
}
