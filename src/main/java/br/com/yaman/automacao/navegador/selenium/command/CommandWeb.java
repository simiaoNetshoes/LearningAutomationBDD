package br.com.yaman.automacao.navegador.selenium.command;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.utils.Sites;

public class CommandWeb {
	
	protected WebDriver webDriver;

	public CommandWeb(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void goToSite(Sites site) {
		webDriver.get(site.getDescricao());
	}

	public void screenShot() {
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File("resources\\evidencias\\screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void screenShot(WebElement element) {
	    ((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", element);
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File("resources\\evidencias\\print.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void click(WebElement element) {
		element.click();
	}

	public void inputValue(WebElement element, String value) {
		element.sendKeys(value);
	}

}
