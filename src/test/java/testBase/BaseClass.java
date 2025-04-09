package testBase;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups= {"Sanity" , "Regression" ,"Master" , "DataDriven"})
    @Parameters({"os", "browser"})
    public void setUp(@Optional("windows") String os, @Optional("chrome") String br) throws IOException {

        // Load config.properties
    	FileReader file = new FileReader("C:\\Users\\admin\\Desktop\\GitDemoProjectV1\\OpenCart121\\src\\test\\resource\\config.properties");

        p = new Properties();
        p.load(file);

        // Logger configuration
        System.setProperty("log4j.configurationFile", "src/test/resources/log4j2.xml");
        logger = LogManager.getLogger(this.getClass());

        logger.info("OS: " + os + ", Browser: " + br);

        // Launch browser
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                logger.error("Invalid browser name: " + br);
                throw new IllegalArgumentException("Invalid browser name: " + br);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }
        @AfterClass(groups= {"Sanity" ,"Regression" ,"Master"})
        public void teardown() {
        	driver.quit();
        }

       
    
    public String randomeString() {
        return RandomStringUtils.randomAlphabetic(5);
    }


}