package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import utils.Navegador;

public class ConfigWebDriver {

	private WebDriver webDriver;

	/**
	 * Metodo Construtor responsavel por instanciar o webDriver para o navegador
	 * escolhido
	 * 
	 * @param navegador
	 * @return webDriver
	 */
	public ConfigWebDriver(Navegador navegador) {

		switch (navegador) {
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "resouces\\drivers\\geckodriver.exe");
			
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setCapability("marionette", true);
			cap.setBrowserName("firefox");
			webDriver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty("webdriver.chrome.driver", "resouces\\drivers\\chromedriver.exe");
			ChromeOptions optionsChrome = new ChromeOptions();

			optionsChrome.addArguments("test-type");
			optionsChrome.addArguments("start-maximized");
			optionsChrome.addArguments("--js-flags=--expose-gc");
			optionsChrome.addArguments("--enable-precise-memory-info");
			optionsChrome.addArguments("--disable-popup-blocking");
			optionsChrome.addArguments("--disable-default-apps");
			optionsChrome.addArguments("test-type=browser");    
			optionsChrome.addArguments("disable-infobars");
			
			webDriver = new ChromeDriver(optionsChrome);
			break;
		case IE:
			webDriver = new InternetExplorerDriver();
		default:
			break;
		}
	}

	public ConfigWebDriver() {
		
	}

	/**
	 * Metodo responsavel por retornar o webDriver Construido
	 * 
	 * @return
	 */
	public WebDriver getWebDrive() {
		return webDriver;
	}

}
