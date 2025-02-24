package books;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tricentis.genericutility.BaseClass;
import com.tricentis.genericutility.ListenerUtility;
import com.tricentis.objectRepository.HomePage;

@Listeners(ListenerUtility.class)
public class TC_001_Test extends BaseClass {
	@Test
	public void clickOnBooks() {
		hp = new HomePage(driver);

		hp.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Book", "Home page is not displayed");
		test.log(Status.PASS, "Books page is displayed");

	}
}
