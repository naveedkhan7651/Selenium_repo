package com.tricentis.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	public void MouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		;
	}

	public void rightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}

	public void scroll(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	public void selectDropdownByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void selectDropdownByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectDropdownByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBactToWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void screenShot(WebDriver driver) throws IOException {
		JavaUtility time = new JavaUtility();
		TakesScreenshot shot = (TakesScreenshot) driver;
		File temp = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/" + time + ".png");
		FileHandler.copy(temp, dest);
	}

	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void switchToAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToWindowUrl(WebDriver driver, String expUrl) {
		Set<String> Allids = driver.getWindowHandles();
		for (String id : Allids) {
			driver.switchTo().window(id);
			String u = driver.getCurrentUrl();
			if (u.contains(expUrl)) {
				break;
			}
		}

	}

	public void windowMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

}
