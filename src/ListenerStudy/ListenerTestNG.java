package ListenerStudy;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenerStudy.Listener.class)
public class ListenerTestNG {
  @Test
  public void method1() 
  {
	  Reporter.log("method1-> Tacse case passed", true);
  }
  @Test
  public void method2() 
  {
	  Reporter.log("method2-> Tacse case passed", true);
  }
  @Test
  public void method3() 
  {
	  Assert.fail();
	  Reporter.log("method3-> Tacse case passed", true);
  }
  @Test(dependsOnMethods = {"method3"})
  public void method4() 
  {
	  Reporter.log("method4-> Tacse case passed", true);
  }
}
