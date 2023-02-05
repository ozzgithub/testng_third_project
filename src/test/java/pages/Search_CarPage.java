package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.Waiter;

import java.util.List;
import java.util.stream.IntStream;

public class Search_CarPage extends Carvana_BasePage{

    public Search_CarPage() {
        super();
    }

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchLink;
    @FindBy(id = "header-facets-wrapper")
    public List<WebElement> filterOptions;


    @FindBy(css = "input[data-test='SearchBarInput']")
    public WebElement searchBarToolBar;

    @FindBy(css = "button[class$='iPPBRN']")
    public WebElement goButton;

    @FindBy(css = "div[class='result-tile']")
    public List<WebElement> eachTile;


    @FindBy(css = "div[class='result-tile'] img")
    public List<WebElement> eachImage;

    @FindBy(css = "div[class='result-tile'] svg")
    public List<WebElement> eachFavButton;

    @FindBy(css = "div[class='tk-frame middle-frame']")
    public List<WebElement> tileBody;

    @FindBy(css = "div[data-test='InventoryTypeExperiment']")
    public List<WebElement> tileInventoryType;

    @FindBy(css = "div[class='year-make']")
    public List<WebElement> yearMakeModelInfoText;

    @FindBy(css = "div[class='trim-mileage']")
    public List<WebElement> trimMileageInfo;

    @FindBy(css = "div[data-qa='price']")
    public List<WebElement> priceInfo;

    @FindBy(css = "div[class='terms']")
    public List<WebElement> monthlyPaymentInfoDownPaymentInfo;

    @FindBy(css = "div[data-qa='shipping-cost']")
    public List<WebElement> freeShippingChip;






    public void searchLinkClick() {
        searchLink.click();
    }


    public void goMercedesPage() {
        searchLinkClick();
        searchBarToolBar.sendKeys("mercedes-benz");
        goButton.click();

    }


    public void ValidateEachSearchResultInfo() {

        Assert.assertTrue(Waiter.waitUntilUrlIs("mercedes-benz", 60));
        IntStream.range(0, eachTile.size()).forEach(i -> {
            Assert.assertTrue(eachTile.get(i).isDisplayed());
            Assert.assertTrue(eachImage.get(i).isDisplayed());
            Assert.assertTrue(eachFavButton.get(i).isDisplayed());
            Assert.assertTrue(tileBody.get(i).isDisplayed());

            Assert.assertTrue(tileInventoryType.get(i).isDisplayed());
            Assert.assertNotNull(tileInventoryType.get(i).getText());
            Assert.assertTrue(yearMakeModelInfoText.get(i).isDisplayed());
            Assert.assertNotNull(yearMakeModelInfoText.get(i).getText());
            Assert.assertTrue(trimMileageInfo.get(i).isDisplayed());
            Assert.assertNotNull(trimMileageInfo.get(i).getText());

            //   $22,300
            Assert.assertTrue(Integer.parseInt(priceInfo.get(i).getText().replaceAll("[^0-9]", "")) > 0);

            Assert.assertTrue(monthlyPaymentInfoDownPaymentInfo.get(i).isDisplayed());
            Assert.assertNotNull(monthlyPaymentInfoDownPaymentInfo.get(i).getText());

            Assert.assertTrue(freeShippingChip.get(i).isDisplayed());
            Assert.assertNotNull(freeShippingChip.get(i).getText());

        });
    }








}
