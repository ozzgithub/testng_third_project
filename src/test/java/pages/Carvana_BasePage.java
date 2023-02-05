package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Carvana_BasePage {

    public Carvana_BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "div[class*='14r2405']")
    public WebElement logo;

    @FindBy(css = "div[class$='ggtgcl']")
    public List<WebElement> navigationSections;

    @FindBy(css = "div[class^='SignInLink']>a")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(css = "button[type='submit']")
    public WebElement continueButton;

    @FindBy(id = "password")
    public WebElement passwordButton;

    @FindBy(css = "button[type='submit']")
    public WebElement submitButton;

    @FindBy(css = "div[class^='error-banner']>p")
    public WebElement errorMessage;













    public void login() {
        signInButton.click();
        emailInputBox.sendKeys("johndoe@gmail.com");
        continueButton.click();
        passwordButton.sendKeys("abcd1234");
        submitButton.click();
    }











}
