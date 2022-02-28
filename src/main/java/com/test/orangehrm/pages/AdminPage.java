package com.test.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class AdminPage {
    public AdminPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "btnAdd")
    WebElement AddButton;

    @FindBy(id = "systemUser_userType")
    WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(xpath = "//input[@id='systemUser_userName")
    WebElement userName;

    @FindBy(name = "systemUser[status]")
    WebElement status;

    @FindBy(name = "systemUser[password]")
    WebElement password;

    @FindBy(name = "systemUser[confirmPassword]")
    WebElement confirmPassword;

    @FindBy(className = "addbutton")
    WebElement saveButton;

    public void sendingAllinformationForEmployee(){
        AddButton.click();
        Select selectAdd=new Select(userRole);
        selectAdd.selectByVisibleText("Admin");
        employeeName.sendKeys("Alice Duval");
        userName.sendKeys("ahmetBaldir");
        Select selectUser=new Select(status);
        selectUser.selectByVisibleText("ahmetBaldir");
        password.sendKeys("ahmet12345");
        confirmPassword.sendKeys("ahmet12345");


    }

}
