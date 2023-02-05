package scripts;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Carvana_BasePage;
import pages.Search_CarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Carvana_Base {



    WebDriver driver;
    Carvana_BasePage carvana_basePage;
    Search_CarPage search_carPage;


    @BeforeMethod
    public void setup() {

        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        carvana_basePage = new Carvana_BasePage();
        search_carPage = new Search_CarPage();


    }


    @AfterMethod
    public void tearDown() {

        Driver.quitDriver();

    }
}
