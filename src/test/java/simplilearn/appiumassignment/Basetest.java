package simplilearn.appiumassignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.github.javafaker.Faker;
import appPages.InstallFireTvPage;
import appPages.MailinatorPage;
import constants.Capabilities;
import appPages.FireTvAppPage;
import appPages.AptoideHomepage;
import appPages.AptoideLoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import testUtils.Utils;

public abstract class Basetest {

	protected AndroidDriver<MobileElement> androidDriver;
	protected AptoideHomepage aptoidehomepage;
	protected InstallFireTvPage installfiretvapppage;
	protected FireTvAppPage firetvpage;
	protected AptoideLoginPage aptoideloginpage;
	protected MailinatorPage mailinatorpage;
	protected Faker fakeData= new Faker();
	public double TimeAtTestStarted;
	
	@BeforeMethod
	public void setupAppiumDriver() {
		
		TimeAtTestStarted= System.currentTimeMillis();
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Capabilities.OS_NAME);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,Capabilities.OS_VERSION);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,Capabilities.DEVICE_NAME);
		cap.setCapability(MobileCapabilityType.APP,Capabilities.APP_PATH);
		
		try {
			androidDriver=new AndroidDriver<MobileElement>(new URL(Capabilities.APPIUM_SERVER_URL),cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		androidDriver.manage().timeouts().implicitlyWait(Capabilities.APPIUM_DRIVER_TIMEOUT,TimeUnit.SECONDS);
		
		//Initialization of page objects
		
		aptoidehomepage = new AptoideHomepage(androidDriver);
		installfiretvapppage = new InstallFireTvPage(androidDriver);
		firetvpage= new FireTvAppPage(androidDriver);
		aptoideloginpage=new AptoideLoginPage(androidDriver);
		mailinatorpage=new MailinatorPage(androidDriver);
	}
	
	public void closeAppiumDriver() {

		androidDriver.quit();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult itr,ITestContext cont) {
		closeApp();
		closeAppiumDriver();
	
		String testName=itr.getMethod().getMethodName();
    	int testStatus = itr.getStatus();
		String description=itr.getMethod().getDescription();
		double TimeAtTestEnded = System.currentTimeMillis();
		double TestExecutionTime = (TimeAtTestEnded - TimeAtTestStarted)*0.001; //resulting time in seconds
		String[] groups=cont.getAllTestMethods()[0].getGroups();
		String groupsname= groups.toString();
		String systemusername = System.getProperty("user.name");
		 
		try {
			Utils.insertDataInTestResultsDB(testName,testStatus,description,groupsname,systemusername,TestExecutionTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}
	
	protected void pressHomeButtonOnDevice() {
	    androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	protected void closeApp(){
		androidDriver.closeApp();
	}
	

	protected void openAppByPackageName(String packageName, String activityName) {
        Activity activity = new Activity(packageName, activityName);
		androidDriver.startActivity(activity);
    }
	
}
