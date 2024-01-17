package appPages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testUtils.Utils;

public class MailinatorPage extends Basepage {

	public MailinatorPage(AndroidDriver<MobileElement> androidDriver) {
		super(androidDriver);
	}

	By chromesearchbar=MobileBy.id("com.android.chrome:id/url_bar");
	By emailsearch=By.xpath("//input[@id='search-mobile']");  
	By searchmailWidget=By.xpath("//button[@aria-label='Search for inbox']");
	By aptoideMailInInbox =By.xpath("//a[@class='text-decoration-none color-main ng-binding']");
	By pagetext=By.xpath("//div[@class='wrapper-title d-flex align-items-center']");
	
	public void openMailinatorWebsite(){
		
		clickMobileElement(chromesearchbar);
		typeText(chromesearchbar, "https://www.mailinator.com");
		pressEnterButton();
		Utils.hardWait(10);
		
	}
	public void openEmail(String mail) {
		
		switchContext();
		clickMobileElement(emailsearch);
		Utils.hardWait(2);
		typeText(emailsearch, mail);
		Utils.hardWait(2);
		clickMobileElement(searchmailWidget);
		Utils.hardWait(2);
	}
	public boolean verifyEmailIsReceived() {
		
		return isElementPresent(aptoideMailInInbox);
	}
	
	public String verifyMagicLinkIsPresentAndCorrect() {
		
		clickMobileElement(aptoideMailInInbox);
		Utils.hardWait(10);
		String text=getValueFromMobileElement(pagetext);
		System.out.println("Magic Link is verified");
		Utils.hardWait(2);
		return text;
	}
	
	
}
