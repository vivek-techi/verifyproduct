package BaseLibrary;

import CommonConstant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;


public class BaseClass {
    public static WebDriver driver;
    public static  WebDriverWait wait;
    public static ProReader prop;


    public BaseClass() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        prop = ProReader.getInstance();
    }


    /****
     * ActionReUsables
     * @param key
     * @return
     */

    public static String getPropValue(String key){
        return  prop.getPropertyValue(key);
    }

    public static void isElementPresent(WebElement element){
        wait = new WebDriverWait(driver, Constant.timeWait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void enterText(WebElement element, String textToEnter){
        isElementPresent(element);
        element.click();
        element.sendKeys(textToEnter);
    }

    public static  void click(WebElement element){
        isElementPresent(element);
        element.click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }



    /***
     * Verifications or Assertions ReUsable
     */

    public boolean verifyText(String expected,String actual){

        boolean flag = false;

        if(expected.contentEquals(actual)){
            flag = true;
        }
        return  flag;
    }

    public static void loadURL(String URL){
        driver.get(URL);
    }

    public static void tearDown() {
        driver.quit();
    }

}
