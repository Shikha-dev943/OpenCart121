

package testCases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindow {
     static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String parentWindow =driver.getWindowHandle();
		System.out.println("parent window " + parentWindow);
		
		WebElement link = driver.findElement(By.linkText("OrangeHRM, Inc"));
		link.click();
		
		Set<String> allwindowHandles = driver.getWindowHandles();
		
		for(String windowhandles : allwindowHandles) {
			if(!windowhandles.equals(parentWindow)) {
				driver.switchTo().window(windowhandles);
				System.out.println("swiched to child window " + windowhandles);
				break;
			}
			
		}
		System.out.println("Child window title " + driver.getTitle());
		driver.switchTo().window(parentWindow);
		System.out.println("switch back to parent window");

		 driver.quit();
		 
		 
		 
	}

}
