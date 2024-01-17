package appPages;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import com.github.javafaker.Faker;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Basepage {

	protected AndroidDriver<MobileElement> androidDriver2;
	protected  AndroidTouchAction touchAction;
	Faker fake= new Faker();

	public Basepage(AndroidDriver<MobileElement> androidDriver) {
		this.androidDriver2 = androidDriver;
		
		// initialize touch action
	touchAction = new AndroidTouchAction(androidDriver);
			
    }
	protected final void clickMobileElement(By locator) {
		
		androidDriver2.findElement(locator).click();
		
	}
	protected final void typeText(By locator, String textToType) {

		androidDriver2.findElement(locator).sendKeys(textToType);

	}
	
	protected final String getValueFromMobileElement(By locator) {

		return androidDriver2.findElement(locator).getText();

	}

	protected final boolean isElementPresent(By locator) {

		return androidDriver2.findElement(locator).isDisplayed();

	}
	
	protected final void swipeDown(int times) {

		for (int i = 0; i < times; i++) {
			int height = androidDriver2.manage().window().getSize().getHeight();
			int width = androidDriver2.manage().window().getSize().getWidth();

			int startx = (int) (width * .5);
			int endx = (int) (width * .5);
			int starty = (int) (height * .9);
			int endy = (int) (height * .4);
			touchAction.longPress(LongPressOptions.longPressOptions().withPosition(PointOption.point(startx, starty)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
		}
	}
	
    protected void pressEnterButton() {
		
		androidDriver2.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void implicitWait(int seconds) {
		
		androidDriver2.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
	}
	
	protected void switchContext() {
		
		Set<String> contextNames = androidDriver2.getContextHandles();
          for (String contextName : contextNames) {
			System.out.println("Hybridflow-Context name when opened mailinator app in chrome : "+contextName);
			if (contextName.toLowerCase().contains("web")) {
				androidDriver2.context(contextName);
				}
              }
	        }	
	
	
}
