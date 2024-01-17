package appPages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testUtils.Utils;

public class InstallFireTvPage extends Basepage {
	
	public InstallFireTvPage(AndroidDriver<MobileElement> androidDriver) {
		super(androidDriver);
		
	}
	
	By fireTvAppicon=MobileBy.xpath("//android.widget.TextView[@text='Amazon Fire TV']");
	By installButtonWidget=MobileBy.id("cm.aptoide.pt:id/appview_install_button");
	By okInstallWidget=MobileBy.id("android:id/button1");
    By allowAccessWidget= MobileBy.id("com.android.permissioncontroller:id/permission_allow_button");
    By openWidget=MobileBy.xpath("//android.widget.Button[@text='OPEN']");
    
    
	public void scrollAppList(int times) {
		
		swipeDown(times);
		androidDriver2.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void clickFireTvApp() {
		
		clickMobileElement(fireTvAppicon);
		Utils.hardWait(2);
	}
	public void InstallFireTv() {
		
		clickMobileElement(installButtonWidget);
		clickMobileElement(okInstallWidget);
		clickMobileElement(allowAccessWidget);
		implicitWait(50);
		clickMobileElement(okInstallWidget);
		implicitWait(100);
	
	}
	
	public boolean verifyFireTvAppIsInstalled() {
		
		return isElementPresent(openWidget);
	}
	
	public void openFireTvApp() {
		
		clickMobileElement(openWidget);
	    implicitWait(10);
	}
}
