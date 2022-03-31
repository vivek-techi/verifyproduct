package PageFactory;

import PageObjects.PageObject.ProductPageObjects;


public class PageObjects {
    public static ProductPageObjects productPageObjects;


    public static ProductPageObjects getProductPageObjects() {
        return (productPageObjects !=null) ? productPageObjects : new ProductPageObjects(BaseClass.driver);
    }



}