package mySeleniumPackage;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class test {
	 public static  WebDriver driver;
	 

	public static void main(String[] args) {
	

       System.setProperty("webdriver.chrome.driver","C:\\Users\\Eda\\Downloads\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get("https://www.gittigidiyor.com");
    	String title1 = driver.getTitle();
		String title_gg = "GittiGidiyor - Türkiye'nin Öncü Alýþveriþ Sitesi";
		
		if(title1.equalsIgnoreCase(title_gg)) {
			System.out.println("Homepage is working");
		}else {
			System.out.println("Homepage is not found");
		}
		
		 driver.quit();
		
		login();
		deleteBasket();
	}
		
	
	public static void login() {
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.gittigidiyor.com/uye-girisi");
			driver.findElement(By.id("L-UserNameField")).sendKeys("ee459559@gmail.com");
			driver.findElement(By.id("L-PasswordField")).sendKeys("ee459559");
			driver.findElement(By.id("gg-login-enter")).click();
			
			String expectedUrl="https://www.gittigidiyor.com/"; 
			if(driver.getCurrentUrl() == expectedUrl) {
				System.out.println("succesful login");
			}else {
				System.out.println("unsuccesful login");
			}
			
			
			 driver.get("https://www.gittigidiyor.com/arama");
		  
		       driver.findElement(By.id("search-keyword")).sendKeys("Bilgisayar",Keys.ENTER);
		       
		   
		       driver.get("https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
		        String title1 = driver.getTitle();
				String title_gg = "Bilgisayar - GittiGidiyor - 2/100";
				
				if(title1.equalsIgnoreCase(title_gg)) {
					System.out.println("second page of 'bilgisayar' query is working"); 
				}else {
					System.out.println("second page of 'bilgisayar' query is not found");
				}
		        
		                   
				driver.findElement(By.className("product-title")).click();                            //urun sayfasi acilir
		        WebElement price = driver.findElement(By.id("sp-price-lowPrice"));
		        String priceOnProductPage= price.getText();                                          //urun sayfasindaki fiyat
		        
		       
		        driver.get("https://www.gittigidiyor.com/sepetim"); //sepet sayfasi acilir
		        WebElement priceBasket = driver.findElement(By.className("total-price")); 
		        String priceOnBasket= priceBasket.getText();                                        //sepet sayfasindaki fiyat
		        
		      
		        if( priceOnProductPage.equalsIgnoreCase(priceOnBasket)) {
					System.out.println("Ürün sayfasýndaki fiyat ile sepette yer alan ürün fiyatý ayni");
				}else {
					System.out.println("Ürün sayfasýndaki fiyat ile sepette yer alan ürün fiyatý farkli");
				}
		        
		        
		       Select amount = new Select(driver.findElement(By.className("amount")));
		        amount.selectByIndex(2);

}
	public static void deleteBasket(){
		
     WebDriver driver = new ChromeDriver();
    	
    	driver.get("https://www.gittigidiyor.com/sepetim");
		
			 
			 driver.findElement(By.className("gg-icon gg-icon-bin-medium")).click();                 //urun sepetten silinir
			 
			 driver.findElement(By.className("gg-w-22 gg-d-22 gg-t-21 gg-m-18"));
			 String text = driver.getTitle();
			 String text2= "Sepetinizde ürün bulunmamaktadýr."; 
		        
		      
		        if( text.equalsIgnoreCase(text2)) {
					System.out.println("sepetin boþ");
				}else {
					System.out.println("sepette urun mevcut");
				}
		        
		        driver.quit();
			 
		 }
}
	