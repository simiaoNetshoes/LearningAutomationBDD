package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Navegador;

public class ConfigWebDriver {
	
	private WebDriver webDriver;
	
	/**
	 * Metodo Construtor responsavel por instanciar o webDriver para o navegador escolhido
	 * @param navegador
	 * @return webDriver
	 */
	public ConfigWebDriver(Navegador navegador) {
		
		switch (navegador) {
		case FIREFOX:
			 webDriver = new FirefoxDriver();		
		case CHROME:
			 webDriver = new ChromeDriver();		
		case IE:
			 webDriver = new FirefoxDriver();		
		default:
			break;
		}
	}
	
	/**
	 * Metodo responsavel por retornar o webDriver Construido
	 * @return
	 */
	public WebDriver getWebDrive() {
		return webDriver;
	}
	
}
