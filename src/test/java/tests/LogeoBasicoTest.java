package tests;

import java.net.URL;
import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import flujos.LoginStep;
import funciones.Funciones;
import io.appium.java_client.AppiumDriver;

public class LogeoBasicoTest {

	
	AppiumDriver<WebElement> driver;
	LoginStep login;
	Funciones funciones;
	ResourceBundle rb = ResourceBundle.getBundle("funciones/configuracion");
	
	@Before
	public  void SetUp() throws Exception {

		String kobitonServerUrl = "https://datshv0:17b22b61-d470-4a51-83c2-a836a710de5b@api.kobiton.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities(); 
	
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", ""); 
		capabilities.setCapability("deviceOrientation", "portrait");  
		capabilities.setCapability("captureScreenshots", true); 
		capabilities.setCapability("browserName", "chrome"); 
		capabilities.setCapability("deviceGroup", "KOBITON"); 
		capabilities.setCapability("deviceName", "*");
		capabilities.setCapability("platformVersion", "*");
		capabilities.setCapability("platformName", "Android");  
		capabilities.setCapability("app", "kobiton-store:24065");
		capabilities.setCapability("appPackage", "com.nequi.MobileApp");
		capabilities.setCapability("appActivity", "MobileApp");		
		driver = new AppiumDriver<WebElement>(new URL(kobitonServerUrl), capabilities);	
		  login = new LoginStep(driver);
				funciones= new Funciones(driver);
		

	}

	
	@Test
	public void ingresarMalClave1vezTest() throws Exception{
		login.correrLogin();
	}
	
	

	
	@After
	public  void cleanUp() {
		driver.quit();
	}
	
}
