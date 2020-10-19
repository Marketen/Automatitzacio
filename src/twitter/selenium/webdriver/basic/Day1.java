package twitter.selenium.webdriver.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Day1 {
    JavascriptExecutor js;
    WebDriver driver;

    @Test(priority = 1)
    public void invokeBrowser(){
        try {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marc\\Documents\\SeleniumShit\\chromedriver.exe");
            driver = new ChromeDriver();
            //driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            js = (JavascriptExecutor) driver;
            driver.get("https://www.amazon.es/ref=nav_logo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void Buscar1917(){

        driver.findElement(By.cssSelector("#twotabsearchtextbox")).click();
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("1917");
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/span[3]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]")).click();
        js.executeScript("window.scrollBy(0,250)", "");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getTitle());
        String expectedTitle = "Prime Video: 1917";
        String title = driver.getTitle();
        Assert.assertEquals(title,expectedTitle);
        driver.close();
    }

    @Test(priority = 0)
    public static void main(String[] args){
        Day1 day1 = new Day1();
        day1.invokeBrowser();
        day1.Buscar1917();

    }

}
