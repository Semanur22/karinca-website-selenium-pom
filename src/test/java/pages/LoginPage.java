package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    private final By loginButtonLocator=By.xpath("//a[text()='GİRİŞ YAP']");
    private final By emailLabelLocator=By.id("user_email_1");
    private final By passwordLabelLocator=By.id("user_password_1");
    private final By submitButtonLocator=By.xpath("//button[text()=\"Giriş\"]");
    public  LoginPage(WebDriver driver){
        super(driver);
    }

    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    public void setEmail(String email){
        WebElement emailLabel = driver.findElement(emailLabelLocator);
        wait.until(ExpectedConditions.elementToBeClickable(emailLabel));
        emailLabel.sendKeys(email);
    }
    public void setPassword(String password){
        WebElement passwordLabel = driver.findElement(passwordLabelLocator);
        wait.until(ExpectedConditions.elementToBeClickable(passwordLabel));
        passwordLabel.sendKeys(password);
    }

    public void clickSubmitButton(){
        WebElement submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();
    }

}
