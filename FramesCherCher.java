package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesCherCher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
//switch to frame by index and enter text		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("TestLeaf");
//switch to inner frame by webelement and click checkbox
		WebElement element = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//input[@id='a']")).click();
//to switch back to default main window
		driver.switchTo().defaultContent();
//switch to other frame by id or name and click dropdown by select constructor
		driver.switchTo().frame("frame2");
		WebElement element2 = driver.findElement(By.xpath("//select[@id='animals']"));
		Select sel=new Select(element2);
//choosing option by select by value
		sel.selectByValue("babycat");
		
		driver.close();
		
	}

}
