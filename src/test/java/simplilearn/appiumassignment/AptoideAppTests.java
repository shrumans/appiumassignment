package simplilearn.appiumassignment;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import testUtils.Utils;

public class AptoideAppTests extends Basetest {
	
	//before running script--->make sure firetv app is not installed and aptoide account is logged out
    //chrome driver(version 74.0.3729)path should be given in appium server settings 
	
	    @Test(priority=1, description="verify install firetv app",groups={"smoke","regression"},testName="AmazonFireTvAppInstallTest")
	    public void installAmazonFireTvAppTest() {
		
	    System.out.println("Test1=InstallAmazonFireTvAppTest");
	    
		aptoidehomepage.clickSearchIcon();
		aptoidehomepage.searchAmazon();
		installfiretvapppage.scrollAppList(4);
		installfiretvapppage.clickFireTvApp();
		installfiretvapppage.InstallFireTv();
		Utils.hardWait(2);
		assertEquals((installfiretvapppage.verifyFireTvAppIsInstalled()),true);
		System.out.println("FireTvApp is successfully installed");
		installfiretvapppage.openFireTvApp();
        
		firetvpage.clickMoreOptions();
		assertEquals(firetvpage.verifyAppVersionIsCorrect("2.6.33.0-aosp"),true);
		Utils.hardWait(1);
		System.out.println("FireTvApp version is verified and correct: 2.6.33.0-aosp");
		
		
	}
	    
	    
	    @Test(priority=2,description="verify Login in Aptoide app",groups= {"regression","sanity"},testName="AptoideAppLoginTest")
		public void aptoideLoginWithEmail() {
	    
	    System.out.println("Test2=AptoideLoginWithEmail");
	    	
		aptoidehomepage.clickOnStores();
		aptoideloginpage.loginWithEmail();
		assertEquals(aptoideloginpage.verifyCheckMailContent("We've sent a magic link"),true);
		System.out.println("Check mail page content(we've sent a magic link) is verified and correct");
		Utils.hardWait(2);
		
    }
	    
	    
		@Test(priority=3,description="verify email received in mailinator",groups={"appiumapk","sanity","smoke"},testName="CheckEmailInMAilinatorTest")
		public void checkEmailInMailinator() {
			
		System.out.println("Test3=CheckEmailInMailinator");	
		System.out.println("mail id to login: "+aptoideloginpage.email);
		openAppByPackageName("com.android.chrome","com.google.android.apps.chrome.Main");
		mailinatorpage.openMailinatorWebsite();
		mailinatorpage.openEmail(aptoideloginpage.email);
		assertEquals((mailinatorpage.verifyEmailIsReceived()),true);
		System.out.println("Aptoide mail is received in inbox");
		assertEquals(mailinatorpage.verifyMagicLinkIsPresentAndCorrect(),"Aptoide login");
		
	}
	
}

