package br.com.yaman.automacao.navegador.selenium.command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.yaman.automacao.navegador.utils.Sites;
import cucumber.api.junit.Cucumber;

public class CommandWeb {
	
	protected WebDriver webDriver;
	private String path = Paths.get("").toAbsolutePath().toString() + "//Evidences//";
	
	public CommandWeb(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void goToSite(Sites site) {
		webDriver.get(site.getDescricao());
	}

	public void screenShot() {
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File(path+getFileName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void hightLight(WebElement element) {
		 ((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public void screenShot(WebElement element) {
	    ((JavascriptExecutor)webDriver).executeScript("arguments[0].style.border='3px solid red'", element);
		File scrFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(path+getFileName(element.getTagName())+".png"));
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

	
	private String getFileName(String nameTest) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		return dateFormat.format(date) + "_" + nameTest + ".png";
		}
	
	private String getFileName() throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		return dateFormat.format(date) +".png";
		}

}
