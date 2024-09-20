package test;

import org.testng.annotations.Test;
import pages.*;

public class KarincaTest extends BaseTest{

    LoginPage loginPage;
    HomePage homePage;
    EditorPage editorPage;
    MenuPage menuPage;
    BlogPage blogPage;
    @Test(priority = 1)
    public void login(){
        loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.setEmail("beyzkay2a@gmail.com");
        loginPage.setPassword("123");
        loginPage.clickSubmitButton();
    }

    @Test(priority = 2)
    public void navigateAdmin(){
       homePage = new HomePage(driver);
       homePage.userDropdown();
       homePage.navigateToAdminPanel();
    }

    @Test(priority = 3)
    public void addEditor(){
        editorPage = new EditorPage(driver);
        editorPage.clickEditorButton();
        editorPage.clickAddNewEditorContent();
        editorPage.setEditorTitle("Karınca Sitesi Test Otomasyonu");
        editorPage.setEditorContent("Karınca Sitesi İçerik Denemesi İçin Yazıyorum Deneme . Deneme \n Deneme");
        editorPage.clickAddEditor();
        editorPage.verificationContentList();
    }
    @Test(priority = 4)
    public void addEditorwithImage(){
        editorPage = new EditorPage(driver);
        editorPage.clickEditorButton();
        editorPage.clickAddNewEditorContent();
        editorPage.setEditorTitle("Karınca Sitesi Test Otomasyonu Denemesi Fotoğraf ile");
        editorPage.setEditorContent("Karınca Sitesi İçerik Denemesi İçin Yazıyorum Deneme . Deneme \n Deneme");
        editorPage.clickAddImageButton();
        editorPage.clickBroadcastingCheckbox();
        editorPage.clickAddEditor();
        editorPage.verificationContentList();
    }
    @Test(priority = 5)
    public void addEditorwithFile(){
        editorPage = new EditorPage(driver);
        editorPage.clickEditorButton();
        editorPage.clickAddNewEditorContent();
        editorPage.setEditorTitle("Karınca Sitesi Test Otomasyonu Denemesi Dosya ile");
        editorPage.setEditorContent("Karınca Sitesi İçerik Denemesi İçin Yazıyorum Deneme . Deneme \n Deneme");
        editorPage.clickMoreButton();
        editorPage.addFile();
        editorPage.clickBroadcastingCheckbox();
        editorPage.clickAddEditor();
        editorPage.verificationContentList();
    }
    @Test(priority = 6)
    public void addEditorwithVideo() throws InterruptedException {
        editorPage = new EditorPage(driver);
        editorPage.clickEditorButton();
        editorPage.clickAddNewEditorContent();
        editorPage.setEditorTitle("Karınca Sitesi Test Otomasyonu Denemesi Video ile");
        editorPage.setEditorContent("Karınca Sitesi İçerik Denemesi İçin Yazıyorum Deneme . Deneme \n Deneme");
        editorPage.clickMoreButton();
        editorPage.addVideo();
        editorPage.clickBroadcastingCheckbox();
        editorPage.clickAddEditor();
        editorPage.verificationContentList();
    }
    @Test(priority = 7)
    public void navigateToContentListAndDeleteContent() {
        editorPage = new EditorPage(driver);
        editorPage.navigateToPageTwo();
        editorPage.clickDeleteButton();
        editorPage.verificationContentList();
    }
    @Test(priority = 8)
    public void addNewMenuItem() {
        menuPage=new MenuPage(driver);
        menuPage.clickMenuButton();
        menuPage.addNewMenuButton();
        menuPage.setMenuTitle("Otomasyon");
        menuPage.clickCheckbox();
        menuPage.selectContent();
        menuPage.selectMainMenu();
        menuPage.saveSubmit();
        menuPage.isMenuList();
    }

        @Test(priority = 9)
        public void addNewPlatform() {
            blogPage=new BlogPage(driver);
            editorPage = new EditorPage(driver);
            blogPage.clickHomeLayout();
            blogPage.clickAddNewPlatform();
            blogPage.selectPlatform();
            blogPage.selectActivity();
            blogPage.setActivityTitle("Karınca Otomasyon Etkinliği");
            blogPage.setStartDate("22.08.2024");
            blogPage.setEndDate("24.08.2024");
            blogPage.setTime("12.30");
            editorPage.clickBroadcastingCheckbox();
            blogPage.setActivityImage();
            editorPage.setEditorContent("Karınca Etkinlik Deneme");
            blogPage.addActivity();
        }

        @Test(priority = 10)
        public void deletePlatform() {
            blogPage=new BlogPage(driver);
            blogPage.selectList();
            blogPage.selectPlatform();
            blogPage.selectActivity();
            blogPage.listPlatform();
        }



}
