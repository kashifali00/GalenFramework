package com.setup;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.reporters.XMLConstants;


import java.io.File;

public class BaseTest {

    private static WebDriver driver = null;
    private String specFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
            File.separator + "java" + File.separator + "specs";

    int browserSizeLen = 1366;
    int browserSizeWid = 784;

    String testURL = "http://testapp.galenframework.com/";

    public WebDriver getDriver(){

        return driver;
    }

    public String getSpecFilePath(){
        System.out.println( "getspecFile path : " + specFilePath);
        return specFilePath;
    }

    @BeforeTest
    public void setupDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "src"
                    + File.separator + "main" + File.separator + "resources" + File.separator + "Drivers" + File.separator +
                    "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().setSize(new Dimension(browserSizeLen, browserSizeWid));
            driver.get(testURL);
        }
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
