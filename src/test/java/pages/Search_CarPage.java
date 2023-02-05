package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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










}
