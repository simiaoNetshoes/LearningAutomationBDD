package br.com.yaman.automacao.navegador.selenium.browser;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.yaman.automacao.navegador.utils.Navegador;

public class WebDriverFactory {

	final static long TIME_OUT = 30;

	private static WebDriverFactory instance = null;
	protected WebDriver webDriver;
	protected WebDriverWait webDriverWait;

	public WebDriverFactory() {
	}

	/**
	 * Metodo Construtor responsavel por instanciar o webDriver para o navegador
	 * escolhido
	 * 
	 * @param navegador
	 * @return webDriver
	 */
	@BeforeClass
	public void setWebDriver(Navegador navegador) {

		switch (navegador) {
		case FIREFOX:
			webDriver = getFirefoxDriver();
			break;
		case CHROME:
			webDriver = getChromeDriver();
			break;
		case IE:
			webDriver = new InternetExplorerDriver();
		default:
			break;
		}
	}

	/**
	 * Metodo responsavel por retornar o webDriver Construido
	 * 
	 * @return
	 */
	public WebDriver getWebDriver() {
		return this.webDriver;
	}

	public static WebDriverFactory getInstance() {
		if (instance == null) {
			instance = new WebDriverFactory();
		}
		return instance;
	}

	/**
	 * Obter driver do Firefox
	 * 
	 * @return
	 */
	private WebDriver getFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");
		WebDriver fireFoxWebDriver = new FirefoxDriver();
		fireFoxWebDriver.manage().window().maximize();
		return fireFoxWebDriver;
	}

	/**
	 * Obter driver do Chrome
	 * 
	 * @return
	 */
	private WebDriver getChromeDriver() {
		try {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
			WebDriver chromeWebDriver = new ChromeDriver();
			chromeWebDriver.manage().window().maximize();
			return chromeWebDriver;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

}
