package br.com.yaman.automacao.navegador.selenium.searchElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchElement{
	protected WebDriver webDriver;
	
	public SearchElement(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebElement getWebElement(String xpath) {
		return webDriver.findElement(By.xpath(xpath));
	}
	
	public List<WebElement> getListWebElements(String xpath) {
		return webDriver.findElements(By.xpath(xpath));
	}
	
	public void rollToElement(WebElement element) {
		((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
