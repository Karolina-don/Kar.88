import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    @Test
    public void simpleAlert(){
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        getDriver().findElement(By.id("simple-alert")).click();

        getDriver().switchTo().alert().accept();

        Assert.assertEquals(getDriver().findElement(By.id("simple-alert-label")).getText(),"OK button pressed");
    }

    @Test
    public void promptalert(){
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");

        getDriver().findElement(By.id("prompt-alert")).click();
        String name= "Karolina Donarska";
        getDriver().switchTo().alert().sendKeys("Karolina Donarska");

        getDriver().switchTo().alert().accept();

        Assert.assertEquals(getDriver().findElement(By.id("prompt-label")).getText(),"Hello" + name + "! How are you today?");
    }
}

