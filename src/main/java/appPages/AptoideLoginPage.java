package appPages;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testUtils.Utils;

public class AptoideLoginPage extends Basepage {

	
	public static String email;
	
	public AptoideLoginPage(AndroidDriver<MobileElement> androidDriver) {
		super(androidDriver);
	}

	By loginButtonWidget=MobileBy.xpath("//android.widget.Button[@text='LOG IN']");
	By CheckBoxWidget=MobileBy.id("cm.aptoide.pt:id/tc_checkbox");
	By connectWithEmailWidget=MobileBy.xpath("//android.widget.Button[@text='CONNECT WITH EMAIL']");
	By enterEmail=MobileBy.xpath("//android.widget.EditText[@text='Your email here']");
	By sendMagicLinkWidget=MobileBy.xpath("//android.widget.Button[@text='SEND MAGIC LINK']");
	By checkMailContent=MobileBy.id("cm.aptoide.pt:id/check_your_email_body_text");
	
	public void loginWithEmail() {
		
		clickMobileElement(loginButtonWidget);
		Utils.hardWait(2);
		clickMobileElement(CheckBoxWidget);
		Utils.hardWait(2);
		clickMobileElement(connectWithEmailWidget);
		Utils.hardWait(2);
		String name=fake.name().firstName().toLowerCase();
		email=name+"@mailinator.com";
		typeText(enterEmail, email);
		Utils.hardWait(2);
		clickMobileElement(sendMagicLinkWidget);
		Utils.hardWait(5);
	}
	
    public boolean verifyCheckMailContent(String expected) {
    	
	return getValueFromMobileElement(checkMailContent).contains(expected);
     }
	
}
