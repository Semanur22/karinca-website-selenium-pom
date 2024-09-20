package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.BaseTest;

import javax.swing.*;

public class HomePage extends BasePage {
    private final By userDropdownLocator=By.cssSelector(".donate-btn-header .dropdown");
    private final By adminPanelButtonLocator=By.xpath("//a[@href=\"admin\"]");
    public HomePage(WebDriver driver){
        super(driver);
    }


    public void userDropdown(){
        WebElement userDropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(userDropdownLocator));
        actions.moveToElement(userDropdown).perform();

    }
    public void navigateToAdminPanel(){
        WebElement adminPanelButton=wait.until(ExpectedConditions.visibilityOfElementLocated(adminPanelButtonLocator));
        adminPanelButton.click();

    }
}
