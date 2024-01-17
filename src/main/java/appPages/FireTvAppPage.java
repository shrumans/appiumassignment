package appPages;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FireTvAppPage extends Basepage {

	public FireTvAppPage(AndroidDriver<MobileElement> androidDriver) {
		super(androidDriver);
	}

	By moreOptionsWidget= MobileBy.xpath("//android.widget.TextView[@text='More']");
	By appVersionWidget=MobileBy.id("android:id/summary");
	
	public void clickMoreOptions() {
		
		clickMobileElement(moreOptionsWidget);
	}
	
	public boolean verifyAppVersionIsCorrect(String expected) {
		
		return getValueFromMobileElement(appVersionWidget).equals(expected);
	}
	
}
