package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {
	
	/**
	 * Metodo responsavel por instanciar o webDriver para o navegador escolhido
	 * @param browser
	 * @return webDriver
	 */
	public WebDriver getWebDriver(String browser) {
		switch (browser) {
		case "firefox":
			FirefoxDriver webDriver = new FirefoxDriver();		
			return webDriver;
		case "chrome":
			ChromeDriver chromeDriver = new ChromeDriver();		
			return chromeDriver;
		case "internetExplorer":
			FirefoxDriver ieDriver = new FirefoxDriver();		
			return ieDriver;
		default:
			break;
		}
		return null;	
	}
	
	
}
