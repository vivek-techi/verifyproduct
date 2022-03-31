package TestCases;

import PageFactory.PageObjects;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC001_VerifySearchFunctionality {

    static BaseClass bs;

    @BeforeTest
    public static void openBrowser() throws IOException {
        bs = new BaseClass();
        bs.loadURL(bs.getPropValue("ApplicationURl"));
    }

    @Test
    public static void verifySearchProduct() {

        PageObjects.getProductPageObjects().enterProductInSearchBox(bs.getPropValue("SearchBoxInput"));
        PageObjects.getProductPageObjects().clickSearchIcons();
        Assert.assertTrue(PageObjects.getProductPageObjects().verifyContent(bs.getPropValue("VerifyText")));
        PageObjects.getProductPageObjects().LowPrice();
    }

    @AfterTest
    public static void tearDown() {
        bs.tearDown();
    }

}




