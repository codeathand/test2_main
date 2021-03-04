package com.qa.test2;

import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selectors {
	
	/** Timeout for waiting element **/
	int timeoutInSeconds = 5;
	
	protected static WebDriver driver;
	
	List<String> watchlistItems = new ArrayList<String>();
	
	/** Locators **/
	private By filtersButton = By.className("table-control-filter");
	private By allCryptocurrencies = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[1]/div/span/div/button");
	private By showRows = By.className("table-control-page-sizer");
	private By table = By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr[not(contains(@class, 'fENxkl'))]");
	
//	private By logIn = By.xpath("//button[contains(text(), 'Log In')]");
	private By logIn = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[1]/div[2]/a[2]/button");
	private By email = By.xpath("//*[@id=\"__next\"]/main/form/div[2]/input");
	private By password = By.xpath("//*[@id=\"__next\"]/main/form/div[5]/input");
	private By submitCredentials = By.xpath("//*[@id=\"__next\"]/main/form/button");
	private By price = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[3]/span/div/button");
	private By priceFrom = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div/div/div/div[1]/input[1]");
	private By priceTo = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div/div/div/div[1]/input[2]");
	private By applyPrice = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/div/div/div/div[3]/div/button[2]");
	private By volume = By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div/div[2]/div/div[5]/span/div/button");
	private By volumeFrom = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[5]/div/div/div[1]/div/div/div/div[1]/input[1]");
	private By volumeTo = By.xpath("/html/body/div/div/div[2]/div/div/div[2]/div/div[5]/div/div/div[1]/div/div/div/div[1]/input[2]");
	private By applyVolume = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[5]/div/div/div[1]/div/div/div/div[3]/div/button[2]");
	private By checkItOut = By.xpath("/html/body/div[3]/div/div[2]/button");
	private By addToWatchList = By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr[1]/td/span/span");
	private By watchlistLink = By.xpath("/html/body/div[1]/div/div[2]/div/div/div[1]/div[2]/a[1]/button/span[2]");
	private By watchlistLabel = By.xpath("//div[contains(text(), 'My First Watchlist')]");
	private By watchlistTable = By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr");

	private By bannerBottomClose = By.className("cmc-cookie-policy-banner__close");
	
	public Selectors(WebDriver driver) {
		this.driver = driver;
	}
	
	/** load Chrome web driver **/
	public WebDriver loadDriver() {
//		System.out.println("Working Directory is " + System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver_win32_88.0.4324.96\\chromedriver.exe");
		System.out.println("Web driver is loaded");
		return driver = new ChromeDriver();
	}
	
	/** open page and maximize it **/
	public void openPage() throws InterruptedException {
		driver.get("https://coinmarketcap.com/");
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		driver.manage().window().maximize();
		System.out.println("Page is opened and maximized");
//		driver.navigate().refresh();
		driver.navigate().to("https://accounts.coinmarketcap.com/login");

//		WebDriverWait waitLogin = new WebDriverWait(driver, timeoutInSeconds);
//		waitLogin.until(ExpectedConditions.elementToBeClickable(logIn));
//
//		driver.findElement(logIn).click();
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		
		driver.findElement(email).sendKeys("kekac34316@geeky83.com");
		driver.findElement(password).sendKeys("Bc231");
		driver.findElement(submitCredentials).click();
	}
	
	/** click on the Filters button **/
	public void clickOnFilters() {
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(filtersButton));
		
		// validate that Filters button is displayed
		Assert.assertTrue(driver.findElement(filtersButton).isDisplayed());
		
		// click on the Filters button
		if (driver.findElement(filtersButton).isDisplayed()) {
			System.out.println("Filters button is displayed");
			driver.findElement(filtersButton).click();
		}
	}
	
	/** validate that filter is set to Cryptocurrencies **/
	public void validateFilterText() {
		
		// validate that All Cryptocurrencies is selected
		Assert.assertEquals(driver.findElement(allCryptocurrencies).getText(), "All Cryptocurrencies");

	}
	
	/** click on the Filters button **/
	public void validateShowRows() {
		
		// validate that Show rows is select to 100
		Assert.assertTrue(driver.findElement(showRows).getText().contains("100"));
		
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows: " + rowCount.size());
		Assert.assertEquals(rowCount.size(), 100);
	}
	
	/** click on the Price **/
	public void selectPrice() {
		
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(price));
		
		// validate that price tab is displayed
		Assert.assertTrue(driver.findElement(price).isDisplayed());
		
		// click on the Price filter
		if (driver.findElement(price).isDisplayed()) {
			System.out.println("Price filter is displayed");
			driver.findElement(price).click();
		}
	}
	
	/** select price range **/
	public void selectPriceRange() throws InterruptedException {
		
		// wait for the price window to be displayed
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(priceFrom));
		
		// validate that inputs and button are displayed
		Assert.assertTrue(driver.findElement(priceFrom).isDisplayed());
		Assert.assertTrue(driver.findElement(priceTo).isDisplayed());
		Assert.assertTrue(driver.findElement(applyPrice).isDisplayed());
		
		// enter price ranges and submit
		driver.findElement(priceFrom).sendKeys("10000");
		driver.findElement(priceTo).sendKeys("40000");

		WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
		wait1.until(ExpectedConditions.elementToBeClickable(applyPrice));
		Thread.sleep(2000);
		driver.findElement(applyPrice).click();
		Thread.sleep(2000);
		// validate that filtered table has less than 10 rows
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows: " + rowCount.size());
		Assert.assertTrue(rowCount.size() < 10);
	}
	
	/** click on the Volume **/
	public void selectVolume() {
		
		// validate that volume tab is displayed
		Assert.assertTrue(driver.findElement(volume).isDisplayed());
		
		// click on the Volume filter
		if (driver.findElement(volume).isDisplayed()) {
			System.out.println("Volume filter is displayed");
			driver.findElement(volume).click();
		}
	}
	
	/** select volume range **/
	public void selectVolumeRange() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(volumeFrom));
		
		// validate that inputs and submit button are displayed
		Assert.assertTrue(driver.findElement(volumeFrom).isDisplayed());
		Assert.assertTrue(driver.findElement(volumeTo).isDisplayed());
		Assert.assertTrue(driver.findElement(applyVolume).isDisplayed());
		
		// enter volume range and submit
		driver.findElement(volumeFrom).sendKeys("1");
		driver.findElement(volumeTo).sendKeys("45000");

		WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
		wait1.until(ExpectedConditions.elementToBeClickable(applyVolume));
		Thread.sleep(2000);
		driver.findElement(applyVolume).click();
		Thread.sleep(2000);
		// validate that filtered table has less than 5 rows
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows: " + rowCount.size());
		Assert.assertTrue(rowCount.size() < 5);
	}
	
	/** Add filtered data to Watchlist 
	 * @throws InterruptedException **/
	public void addToWatchlist() throws InterruptedException {
		
		// get count of filtered rows
		List<WebElement> rowCount = driver.findElements(table);
		System.out.println("Num rows filtered: " + rowCount.size());
		
		// add id of items to the list
		for (int i=1; i<=rowCount.size(); i++) {
			System.out.println(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[3]/table/tbody/tr["+i+"]/td[2]/p")).getText());
//			Thread.sleep(500);
			watchlistItems.add(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[3]/table/tbody/tr["+i+"]/td[2]/p")).getText());
		}
		
		System.out.println(watchlistItems);

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(addToWatchList));
		// when click on the star to add to watch list, check whether is modal window is displayed
		Thread.sleep(2000);
		driver.findElement(addToWatchList).click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(checkItOut));
		
		// if modal window is displayed, click on the button in the window
		if (driver.findElement(checkItOut).isDisplayed()) {
			driver.findElement(checkItOut).click();
			driver.findElement(addToWatchList).click();
		}

		WebDriverWait wait2 = new WebDriverWait(driver, timeoutInSeconds);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(bannerBottomClose));

		if (driver.findElement(bannerBottomClose).isDisplayed()) {
			driver.findElement(bannerBottomClose).click();

			// check all filtered items for adding to the watchlist by clicking the star
			for (int i=1; i<=rowCount.size(); i++) {
				driver.findElement(By.xpath("//table[contains(@class, 'cmc-table')]/tbody/tr["+i+"]/td/span/span")).click();
				Thread.sleep(2000);
			}
		}
	}
	
	/** open watchlist 
	 * @throws InterruptedException **/
	public void openWatchlist() throws InterruptedException {
		float volume = 0;

		// wait until Watchlist tab is displayed, and click on it
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(watchlistLink));
		driver.findElement(watchlistLink).click();
		
		// wait for the Wathlist page to be displayed
		WebDriverWait wait1 = new WebDriverWait(driver, timeoutInSeconds);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(watchlistLabel));
		
		// get numbers of rows in the table
		List<WebElement> rowCount = driver.findElements(watchlistTable);
		
		for (int i=1; i<=rowCount.size(); i++) {
			WebDriverWait wait2 = new WebDriverWait(driver, timeoutInSeconds);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[2]/p")));

			// get values of id, price and volume
			String id = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[2]/p")).getText();
			float price = Float.parseFloat(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[4]/div/a")).getText().replaceAll("[$,]", ""));
			try {
				volume = Float.parseFloat(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[8]/div/a/p")).getText().replaceAll("[$,]", ""));
			} catch (Exception exp) {
				System.out.println(exp.getMessage());
			}
			Thread.sleep(2000);
			
			// validate that items in the watchlist table are previously added
			Assert.assertEquals(id, watchlistItems.get(i-1));
			
			// validate that prices in the watchlist table meet the criteria
			Assert.assertTrue(price >= 10000 && price <= 40000);
			
			// validate that volumes in the watchlist table meet the criteria
			Assert.assertTrue(volume >= 1 && volume <= 1700000);
		}
		
	}

	public void deselectWatchList() throws InterruptedException {
		// get count of filtered rows
		List<WebElement> rowCount = driver.findElements(watchlistTable);
		System.out.println("Num rows watchlist table filtered: " + rowCount.size());

		// check all filtered items for adding to the watchlist by clicking the star
		for (int i=1; i<=rowCount.size(); i++) {
			if (i < rowCount.size()) {
				WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[1]/span/span")));
				driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div[2]/table/tbody/tr["+i+"]/td[1]/span/span")).click();
				Thread.sleep(2000);
			} else {
//				WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]/span/span")));
				driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]/span/span")).click();
				Thread.sleep(2000);
			}
		}
	}
}