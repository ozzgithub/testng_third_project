package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Search_CarPage;
import utilities.Waiter;

import java.util.stream.IntStream;

public class Carvana_Test extends Carvana_Base{


    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndUrl() {

        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }


    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validateCarvanaLogo() {
        Assert.assertTrue(carvana_basePage.logo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateNavigationItems() {
        IntStream.range(0,carvana_basePage.navigationSections.size()).forEach(i -> {
            Assert.assertTrue(carvana_basePage.navigationSections.get(i).isDisplayed()); });
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void validateErrorMessage() {
        carvana_basePage.login();
        Assert.assertEquals(carvana_basePage.errorMessage.getText(),
                "Email address and/or password combination is incorrect.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void validateSearchFilterAndSearchButton() {
        search_carPage.searchLinkClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        IntStream.range(0, search_carPage.filterOptions.size()).forEach(i -> {
            Assert.assertTrue(search_carPage.filterOptions.get(i).isDisplayed());
        });
    }

    @Test(priority = 6, description = "Validate the search result titles")
    public void validateSearchResultTitles() {
        search_carPage.searchLinkClick();
        search_carPage.searchBarToolBar.sendKeys("mercedes-benz");
        search_carPage.goButton.click();
        Assert.assertTrue(Waiter.waitUntilUrlIs("mercedes-benz", 60));


        IntStream.range(0, search_carPage.eachTile.size()).forEach(i -> {
            Assert.assertTrue(search_carPage.eachTile.get(i).isDisplayed());
            Assert.assertTrue(search_carPage.eachImage.get(i).isDisplayed());
            Assert.assertTrue(search_carPage.eachFavButton.get(i).isDisplayed());
            Assert.assertTrue(search_carPage.tileBody.get(i).isDisplayed());

            Assert.assertTrue(search_carPage.tileInventoryType.get(i).isDisplayed());
            Assert.assertNotNull(search_carPage.tileInventoryType.get(i).getText());
            Assert.assertTrue(search_carPage.yearMakeModelInfoText.get(i).isDisplayed());
            Assert.assertNotNull(search_carPage.yearMakeModelInfoText.get(i).getText());
            Assert.assertTrue(search_carPage.trimMileageInfo.get(i).isDisplayed());
            Assert.assertNotNull(search_carPage.trimMileageInfo.get(i).getText());

            //   $22,300
            Assert.assertTrue(Integer.parseInt(search_carPage.priceInfo.get(i).getText().replaceAll("[^0-9]", "")) > 0);

            Assert.assertTrue(search_carPage.monthlyPaymentInfoDownPaymentInfo.get(i).isDisplayed());
            Assert.assertNotNull(search_carPage.monthlyPaymentInfoDownPaymentInfo.get(i).getText());

            Assert.assertTrue(search_carPage.freeShippingChip.get(i).isDisplayed());
            Assert.assertNotNull(search_carPage.freeShippingChip.get(i).getText());

        });





    }








}
