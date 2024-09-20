package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class EditorPage extends BasePage{
    private final By editorButtonLocator=By.className("nav-editor");
    private final By addNewEditorContentLocator=By.xpath("//a[@href=\"index.php?page=module/editor/add_editor\"]");
    private final By editorContentTitleLabelLocator=By.id("editor_title");
    private final By editorContentLabelLocator=By.className("fr-view");
    private final By addEditorButtonLocator=By.className("btn-block");
    private final By contentListTextLocator=By.xpath("//h1[text()=\"İÇERİK LİSTESİ\"]");
    private final By addImageButtonLocator=By.id("insertImage-1");
    private final By dropImageButtonLocator=By.xpath("//input[@aria-labelledby=\"fr-image-upload-layer-1\"]");
    private final By broadcastingCheckboxLocator=By.id("editor_broadcasting");
    private final By addFileButtonLocator=By.id("insertFiles-1");
    private final By clickEnableButtonLocator=By.xpath("//button[text()=\"Enable\"]");
    private final By dropFileButtonLocator=By.xpath("//input[@aria-labelledby=\"fr-file-upload-layer-1\"]");
    private final By uploadFileButtonLocator=By.id("insertFile-1");
    private final By moreButtonLocator=By.id("moreRich-1");
    private final By insertVideoButtonLocator=By.id("insertVideo-1");
    private final By uploadVideoButtonLocator=By.id("videoUpload-1");
    private final By dropVideoButtonLocator=By.xpath("//input[@aria-labelledby=\"fr-video-upload-layer-1\"]");
    private final By listContentButtonLocator=By.xpath("(//p[text()=\"Listele\"])[1]");
    private final By uploadedVideoLocator = By.className("fr-dvb");
    private final By navigateToPageTwo = By.xpath("//*[@id=\"list_paginate\"]/ul/li[3]/a");
    private final By deleteButtonLocator = By.className("fa-trash");
    private final By okDeleteButtonLocator = By.className("btn-danger");
    public EditorPage(WebDriver driver){
        super(driver);
    }

    public void clickEditorButton(){
        WebElement editorButton=wait.until(ExpectedConditions.visibilityOfElementLocated(editorButtonLocator));
        editorButton.click();
    }

    public void clickAddNewEditorContent(){
        WebElement addNewEditorContentButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addNewEditorContentLocator));
        addNewEditorContentButton.click();
    }
    public void setEditorTitle(String title){
        WebElement editorContentTitleLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(editorContentTitleLabelLocator));
        editorContentTitleLabel.click();
        editorContentTitleLabel.sendKeys(title);
    }

    //sadece text ekleme
    public void setEditorContent(String content){
        WebElement editorContentLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(editorContentLabelLocator));
        editorContentLabel.click();
        editorContentLabel.sendKeys(content);
    }

    public void clickAddEditor(){
        WebElement addEditorButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addEditorButtonLocator));
        addEditorButton.click();
    }

    public void clickAddImageButton(){
        WebElement addImageButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addImageButtonLocator));
        addImageButton.click();
        WebElement dropImageButton = driver.findElement(dropImageButtonLocator);
        dropImageButton.sendKeys("C:\\Users\\Semanur\\Pictures\\homess.png");
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(dropImageButtonLocator)));
    }

    public void clickMoreButton(){
        WebElement moreButton = wait.until(ExpectedConditions.visibilityOfElementLocated(moreButtonLocator));
        moreButton.click();
    }
    public void addFile(){

        WebElement uploadFileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadFileButtonLocator));
        uploadFileButton.click();
        WebElement dropFileButton = driver.findElement(dropFileButtonLocator);
        dropFileButton.sendKeys("C:\\Users\\Semanur\\Desktop\\PHP_8_ile_Web_Uygulama_Geliştirme_Sertifika.pdf");
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(dropFileButtonLocator)));

    }

    public  void addVideo() throws InterruptedException {
        WebElement insertVideoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(insertVideoButtonLocator));
        insertVideoButton.click();

        WebElement uploadVideoButton = wait.until(ExpectedConditions.visibilityOfElementLocated(uploadVideoButtonLocator));
        uploadVideoButton.click();

        WebElement dropVideoButton = driver.findElement(dropVideoButtonLocator);
        dropVideoButton.sendKeys("C:\\Users\\Semanur\\Pictures\\Medeniyet Teknopark finansal teknoloji merkezi oluyor (1).mp4");

        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadedVideoLocator));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(dropVideoButtonLocator)));

    }
    public void verificationContentList(){
        WebElement contentListText = wait.until(ExpectedConditions.visibilityOfElementLocated(contentListTextLocator));
        Assert.assertTrue(contentListText.isDisplayed());
    }

    public void clickBroadcastingCheckbox(){
        WebElement broadcastingCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(broadcastingCheckboxLocator));
        broadcastingCheckbox.click();
    }


    public void clickListContent(){
        WebElement clickListContentButton = wait.until(ExpectedConditions.elementToBeClickable(listContentButtonLocator));
        clickListContentButton.click();
    }

    public void navigateToPageTwo(){

        actions.sendKeys(Keys.END).perform();
        WebElement clickPageTwoButton = wait.until(ExpectedConditions.elementToBeClickable(navigateToPageTwo));

        clickPageTwoButton.click();
    }

    public void clickDeleteButton(){
        List<WebElement> trashIcons = driver.findElements(deleteButtonLocator);

        // Son çöp kutusu simgesini bulalım ve tıklayalım
        if (!trashIcons.isEmpty()) {
            WebElement lastTrashIcon = trashIcons.get(trashIcons.size() - 1);
            lastTrashIcon.click();
            WebElement okDeleteButton=wait.until(ExpectedConditions.visibilityOfElementLocated(okDeleteButtonLocator));
            okDeleteButton.click();
        } else {
            System.out.println("Çöp kutusu simgesi bulunamadı.");
        }
    }



}
