package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BlogPage extends BasePage{
    private final By homeLayoutButtonLocator = By.className("fa-home");
    private final By addNewPlatformButtonLocator = By.xpath("//a[@href=\"index.php?page=module/platform/add_platform\"]");
    private final By selectPlatformButtonLocator = By.id("editor_category_id");
    private final By selectActivityLocator = By.xpath("//option[text()=\"Etkinlik\"]");
    private final By titleLocator = By.xpath("//input[@name=\"editor_title\"]");
    private final By startDateLocator = By.xpath("//input[@name=\"editor_start_date\"]");
    private final By endDateLocator = By.xpath("//input[@name=\"editor_end_date\"]");
    private final By timeLocator = By.xpath("//input[@name=\"editor_time\"]");
    private final By activityImageLocator = By.id("editor_image");
    private final By addActivityButtonLocator = By.className("mr-2");
    private final By deleteActivityButtonLocator = By.className("delete_platform");
    private final By isListPageLocator = By.xpath("//option[text()=\"Neyi listelemek istiyorsunuz?\"]");
    private final By confirmDeleteButtonLocator = By.id("confirm");
    private final By alertSuccessDeleteLocator = By.id("sidebar-mini");
    public BlogPage(WebDriver driver){
        super(driver);
    }

    public void clickHomeLayout(){
        WebElement homeLayoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(homeLayoutButtonLocator));
        homeLayoutButton.click();
    }

    public void clickAddNewPlatform(){
        WebElement addNewPlatformButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addNewPlatformButtonLocator));
        addNewPlatformButton.click();
    }
    public void listPlatform(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectPlatformButtonLocator));
    }
    public void selectPlatform(){
        WebElement selectPlatformButton = wait.until(ExpectedConditions.visibilityOfElementLocated(selectPlatformButtonLocator));
        selectPlatformButton.click();
    }
    public void selectActivity(){
        WebElement selectActivity = wait.until(ExpectedConditions.visibilityOfElementLocated(selectActivityLocator));
        selectActivity.click();
    }
    public void setActivityTitle(String title){
        WebElement activityTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        activityTitle.click();
        activityTitle.sendKeys(title);
    }

    public void setStartDate(String date){
        WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(startDateLocator));
        startDate.click();
        startDate.sendKeys(date);
    }

    public void setEndDate(String date){
        WebElement endDate = wait.until(ExpectedConditions.visibilityOfElementLocated(endDateLocator));
        endDate.click();
        endDate.sendKeys(date);
    }
    public void setTime(String time){
        WebElement timeActivity = wait.until(ExpectedConditions.visibilityOfElementLocated(timeLocator));
        timeActivity.click();
        timeActivity.sendKeys(time);
    }

    public void setActivityImage(){
        WebElement activityImage = driver.findElement(activityImageLocator);
        activityImage.sendKeys("C:\\Users\\Semanur\\Pictures\\linkedin 1.jpg");

    }

    public void addActivity(){
        WebElement addActivity = wait.until(ExpectedConditions.visibilityOfElementLocated(addActivityButtonLocator));
        js.executeScript("arguments[0].scrollIntoView(true);", addActivity);
        addActivity.click();
    }

    public void deleteActivity(){
        WebElement deleteActivity = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteActivityButtonLocator));
        deleteActivity.click();
        WebElement confirmDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButtonLocator));
        confirmDelete.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertSuccessDeleteLocator));
    }

    public void selectList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(isListPageLocator));
    }


}
