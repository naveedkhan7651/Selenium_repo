package com.tricentis.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(linkText = "Log out")
private WebElement logoutLink;

@FindBy(partialLinkText = "Books")
private WebElement booksLink;

@FindBy(partialLinkText = "Computers")
private WebElement computersLink;

public WebElement getComputersLink() {
	return computersLink;
}

public void setComputersLink(WebElement computersLink) {
	this.computersLink = computersLink;
}

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getBooksLink() {
	return booksLink;
}

public void setBooksLink(WebElement booksLink) {
	this.booksLink = booksLink;
}

public WebElement getLogoutLink() {
	return logoutLink;
}
}
