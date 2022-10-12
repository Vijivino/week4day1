package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//driver setup
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
		driver.manage().window().maximize();
//validate simple alert by text 
		driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']/following::span")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String text = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
        if(text.contains("successfully")) {
        	System.out.println("simple alert is handled");
        }
//check confirm alert by yes 
        driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following::span")).click();
	    Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
	    String text2 = driver.findElement(By.xpath("//span[@id='result']")).getText();
	    if(text2.equals("User Clicked : OK")) {
	    	System.out.println("confirm alert is handled by ok");
	    }
 //check confirm alert by cancel       
	   driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following::span")).click();
	   Thread.sleep(2000);
	   alert.dismiss();
	   String text3 = driver.findElement(By.xpath("//span[@id='result']")).getText();
	   System.out.println(text3);
//sweet alert by click inspect
	   driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following::span")).click();
	   driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
//sweet modal alert by click inspect
	   driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']/following::span")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']/following::span[@class='ui-icon ui-icon-closethick']")).click();
//prompt alert validate by giving inputs  
	   driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following::span")).click();
	   alert.sendKeys("Viji");
	   alert.accept();
	   String text4 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
	   if (text4.contains("Viji")){
		   System.out.println("the prompt alert is handled with name --- " + text4);
	   }
	  
//sweet alert confirmation
	   driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']/following::span")).click();
	   driver.findElement(By.xpath("//span[text()='Yes']")).click();
//minimize and maximize	
	   driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']/following::span")).click();
      //minimize check
	   WebElement element = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']"));
	   element.click();
 	   Thread.sleep(2000);
       WebElement element2 = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']"));
       element2.click();
       Thread.sleep(2000);
       //maximize check
       WebElement element3 = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']"));
       element3.click();
       Thread.sleep(2000);
       WebElement element4 = driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-newwin']"));
       element4.click();
       Thread.sleep(2000);
       //close the alert
       driver.findElement(By.xpath("//span[text()='Min and Max']/following::span[@class='ui-icon ui-icon-closethick']")).click();
	  
	   driver.close();
	}

}
