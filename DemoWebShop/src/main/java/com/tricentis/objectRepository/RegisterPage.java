package com.tricentis.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {
@FindBy(id = "FirstName")
private WebElement firstnameTextField;

@FindBy(id = "LastName")
private WebElement lastNameTextField;

@FindBy(id = "Email")
private WebElement emailTextFeild;

@FindBy(id = "Password")
private WebElement passwordTextField;

@FindBy(id = "ConfirmPassword")
private WebElement confirmPasswordTextField;
}
