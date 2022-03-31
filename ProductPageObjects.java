package PageObjects.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.HashMap;
import java.util.List;


public class ProductPageObjects {

    WebDriver driver;

    public ProductPageObjects(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "search_query_top")
    private static WebElement SearchBox;

    @FindBy(xpath =  "//button[@name='submit_search']")
    private static WebElement SearchBoxIcon;

    public static WebElement getSearchBox(){
        return SearchBox;
    }

    public static WebElement getSearchIcon(){
        return SearchBoxIcon;
    }

    public static void clickSearchIcons() {
        BaseClass.click(getSearchIcon());
    }

    public static void enterProductInSearchBox(String enterText) {
     BaseClass.enterText(getSearchBox(),enterText);
    }

    public static boolean verifyContent(String verifyText) {

        List<WebElement> Checkproduct = BaseClass.driver.findElements(By.className("product-container"));
        boolean flag = false;
        for(WebElement product: Checkproduct)
        {
                   if( product.getText().contains(verifyText)){
                       flag = true;
                   }else{
                       flag =false;
                   }
        }
        return flag;
    }


    public static HashMap<String,HashMap<String,String>> LowPrice()throws NumberFormatException {
       HashMap<String,HashMap<String,String>> rMap = new HashMap<>();
        HashMap<String,String> productDetails = new HashMap<>();
        List<WebElement> Productlowprice = BaseClass.driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[@class='right-block']/div[@itemprop='offers']/span[@itemprop='price']"));
        int iterCount = 0;
        int index = 0;
        double min = 0.0;
        for(WebElement price: Productlowprice)
        {
         String pr = price.getText().substring(1,price.getText().length());
        index++;
            double curr =Double.parseDouble(pr);
            if(iterCount==0){
                min = curr;
            iterCount=1;
            }
            if(curr<min){
               min = curr;
             String name =  BaseClass.driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+index+"]/div/div[2]/h5/a")).getText();
             String stock = BaseClass.driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+index+"]/div/div[2]/span/span")).getText();
                productDetails.put(name,stock);
        }
            }

         rMap.put(String.valueOf(min),productDetails);
         System.out.println(rMap);
        return rMap;
    }

}
