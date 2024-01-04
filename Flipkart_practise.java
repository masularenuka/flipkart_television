package First_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_practise {

	public static void main(String[] args) {
												//  E:\\chrome driver123\\chrome-win64\\chromedriver.exe
		
		System.setProperty("webdriver.chrome.driver", "E:\\eclipse folder 2 jan 2023\\save your code here\\Sample\\chromedriver.exe");
		ChromeOptions co= new ChromeOptions();
		co.setBinary("E:\\chrome driver123\\chrome-win64\\chrome.exe");
//		WebDriverManager.chromedriver().setup();
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		d.get("https://www.flipkart.com/");
		
		try {
			int k=0;
			d.findElement(By.name("q")).sendKeys("television" , Keys.ENTER);
			Thread.sleep(2000);
			
			///size
			List<WebElement> sponsered =d.findElements(By.xpath("(//*[@class='_4rR01T'])"));
			System.out.println(sponsered.size());
			Thread.sleep(2000);
			
			// prod_details
			List<WebElement>  prod_details = d.findElements(By.xpath("(//*[@class='fMghEO'])"));
			System.out.println(prod_details.size());
			Thread.sleep(2000);
			
			
			// cost
			List<WebElement>  cost = d.findElements(By.xpath("(//*[@class='_30jeq3 _1_WHN1'])"));
			System.out.println(cost.size());
			Thread.sleep(2000);
			
			///////////pages load
			Thread.sleep(3000);

			String all_pages = d.findElement(By.xpath("(//*[@class='yFHi8N']/a)")).getText();

			System.out.println(all_pages);
			Thread.sleep(3000);

			String all_page_numbers = all_pages.substring(all_pages.length() - 1); // 2
			System.out.println(all_page_numbers.trim());
			Thread.sleep(3000);
			int num_of_pages = Integer.parseInt(all_page_numbers + 10);
			System.out.println(num_of_pages);
			for (int j = 1; j < num_of_pages; j++) {
				Thread.sleep(3000);
/////////////////////////////
				for(int i=1;i <=cost.size();i++) {
					k++;
					String sponsers = d.findElement(By.xpath("(//*[@class='_4rR01T'])["+ i + "]")).getText();
			//		System.out.println(sponsers);
					Thread.sleep(3000);
					
					String product = d.findElement(By.xpath("(//*[@class='fMghEO'])["+ i + "]")).getText();
			//		System.out.println(product);
					Thread.sleep(3000);
					
					String cost_price = d.findElement(By.xpath("(//*[@class='_30jeq3 _1_WHN1'])["+ i + "]")).getText();
			//		System.out.println(cost_price);
					Thread.sleep(3000);
					System.out.println(k+"\n"+" ::=  sponsered are :: "+sponsers+ "\n"+" product is :: "+product+ "\n"+" cost is :: "+ cost_price);
					System.out.println("****************************   "+j+"  **********************************************");
				}
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			System.out.println("ERROR MESSAGE IS "+e.getMessage());
		}

	}

}
