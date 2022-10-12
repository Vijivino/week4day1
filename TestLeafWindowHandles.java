package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLeafWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//driver setup		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//click and confirm new window appears
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> list=new ArrayList<String>(handles);
//compare the size of windows list and confirm for new window
		int size = list.size();
		System.out.println(size);
		System.out.println("Parent window -- "+driver.getTitle());
		if(size>1) {
			System.out.println("new window is opened" );
			
		}
		else {
			System.out.println("no new window");
		}
//get the title and confirm the new window
		driver.switchTo().window(list.get(1));
		System.out.println("Child window -- "+driver.getTitle());
		//String windowHandle = driver.getWindowHandle();
//close the current tab in which the control is		
		driver.close();
		Thread.sleep(2000);
//focus back to parent window
		driver.switchTo().window(list.get(0));
//find no.of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();	
		Set<String> handles2 = driver.getWindowHandles();
		List<String> list2=new ArrayList<String>(handles2);
		System.out.println("No of opened tabs "+list2.size());
//close multiple child windows 
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();	
		Set<String> handles3= driver.getWindowHandles();
		List<String> list3=new ArrayList<String>(handles3);

		for (int i = 1; i < list3.size(); i++) {
	  //move focus to child window 1 by 1 and close
	  driver.switchTo().window(list3.get(i));
	  driver.close();
	  //driver.switchTo().window(list3.get(2));
	  //driver.close();
	  //driver.switchTo().window(list3.get(3));
	  //driver.close();
}
		//move focus back to parent window		
		driver.switchTo().window(list3.get(0));
//open with delay		
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();	


	
	}

}
