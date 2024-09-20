package pages;

import org.apache.commons.compress.archivers.sevenz.CLI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class MenuPage extends BasePage{
    private final By menuButtonLocator=By.xpath("//i[@class=\"nav-icon fas fa-bars\"]");
    private final By addNewMenuButtonLocator=By.xpath("//a[@href=\"index.php?page=module/menu/add_menu\"]");
    private final By menuTitleLabelLocator=By.xpath("//input[@name=\"menu_item_title\"]");
    private final By menuCheckboxLocator=By.id("myCheckbox");

    private final By selectContentLocator=By.id("DDL");
    private final By selectMainMenuLocator=By.id("menu_item_parent_id");
    private final By submitButtonLocator=By.xpath("//input[@name=\"submit\"]");
    private final By isMenuListLocator=By.xpath("//h1[text()=\"MENÜ LİSTESİ\"]");





    public MenuPage(WebDriver driver){
        super(driver);
    }

    public void clickMenuButton(){
        WebElement menuButton = wait.until(ExpectedConditions.visibilityOfElementLocated(menuButtonLocator));
        menuButton.click();
    }

    public void addNewMenuButton(){
        WebElement addNewMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(addNewMenuButtonLocator));
        addNewMenu.click();
    }

    public void setMenuTitle(String title){
        WebElement addNewMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(menuTitleLabelLocator));
        addNewMenu.click();
        addNewMenu.sendKeys(title);
    }

    public void clickCheckbox(){
        WebElement clickCheckboxButton = wait.until(ExpectedConditions.visibilityOfElementLocated(menuCheckboxLocator));
        clickCheckboxButton.click();

    }

    public void selectContent(){
        WebElement selectContent = wait.until(ExpectedConditions.visibilityOfElementLocated(selectContentLocator));
        selectContent.click();
        Select dropdown = new Select(selectContent);

        // Tüm seçenekleri al
        List<WebElement> options = dropdown.getOptions();

        // Son seçeneği seç
        dropdown.selectByIndex(options.size() - 1);
    }
    public void selectMainMenu(){
        WebElement selectMainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(selectMainMenuLocator));
        selectMainMenu.click();
        Select dropdown = new Select(selectMainMenu);

        // Tüm seçenekleri al
        List<WebElement> options = dropdown.getOptions();

        // Son seçeneği seç
        dropdown.selectByIndex(options.size() - 1);
    }
    public void saveSubmit(){
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButtonLocator));
        submitButton.click();
    }

    public void isMenuList(){
       wait.until(ExpectedConditions.visibilityOfElementLocated(isMenuListLocator));
    }

}
