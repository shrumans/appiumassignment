package appPages;

import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import testUtils.Utils;

public class AptoideHomepage extends Basepage {
	public AptoideHomepage(AndroidDriver<MobileElement> androidDriver) {
		super(androidDriver);
	}

	By cancelWidget= MobileBy.xpath("//android.widget.Button[@text='CANCEL']");
    By searchIconwidget=MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.ImageView");
    By searchBarToType=MobileBy.id("cm.aptoide.pt:id/search_src_text");
    By storesWidget=MobileBy.xpath("//android.widget.TextView[@text='Stores']");
    
    
 
	public void clickCancel() {
		
    	clickMobileElement(cancelWidget);
    }
    public void clickSearchIcon() {
    	
    	clickCancel();
    	clickMobileElement(searchIconwidget);
    }
    public void searchAmazon() {
    	
    	typeText(searchBarToType, "amazon");
    	pressEnterButton();
		Utils.hardWait(5);
    }
    
    public void clickOnStores() {
    	
    	clickMobileElement(storesWidget);
    	Utils.hardWait(2);
    }
}
