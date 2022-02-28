package com.test.orangehrm.tests;

import com.test.orangehrm.TestBase;
import com.test.orangehrm.pages.AdminPage;
import com.test.orangehrm.pages.LoginPage;
import com.test.orangehrm.pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AdminTest extends TestBase {
    @Test

    public void validateTheCreationOfTheEmployeeMessage(){
        LoginPage loginpage=new LoginPage(driver);
        loginpage.login("Admin","admin123");
        MainPage mainPage=new MainPage(driver);
        mainPage.clickAdminButton();

        AdminPage adminPage= new AdminPage(driver);
        adminPage.sendingAllinformationForEmployee();

    }

}
