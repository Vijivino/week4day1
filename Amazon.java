package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		/*1.Load the URL https://www.amazon.in/
			2.search as oneplus 9 pro 
			3.Get the price of the first product
			4. Print the number of customer ratings for the first displayed product
			5. Click the first text link of the first image
			6. Take a screen shot of the product displayed
			7. Click 'Add to Cart' button
			8. Get the cart subtotal and verify if it is correct.
			9.close the browser
			*/
//browser setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
//search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
//Get the price of the first product
		String price = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println("first product price is "+price);
		Thread.sleep(5000);
// Print the number of customer ratings for the first displayed product
		driver.findElement(By.xpath("//a[@class='a-popover-trigger a-declarative']")).click();
		Thread.sleep(5000);
		String rating = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-beside-button a-text-bold']")).getText();
		System.out.println("Rating " +rating);
		Thread.sleep(2000);
//Click the first text link of the first image		
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
//move focus to the new window
		Set<String> handles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(handles);
		driver.switchTo().window(list.get(1));
//Take a screen shot of the product displayed
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snaps/snap1.png");
		FileUtils.copyFile(source, destination);
		Thread.sleep(2000);
//Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(8000);
//		Set<String> handles2 = driver.getWindowHandles();
//		List<String> list2=new ArrayList<String>(handles2);
//		System.out.println(handles2.size());
//Get the cart subtotal and verify if it is correct		
		String total = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("Cart subtotal is "+total);
	    if(total.contains(price)) {
	    	System.out.println("Cart subtotal is verified");
	    }else {
	    	System.out.println("not verified");
	    }
		
	}

}
