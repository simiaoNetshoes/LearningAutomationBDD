package br.com.yaman.testes;
 
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE 
		,format = { "html:target/cucumber-html-report"
		,"json:target/cucumber-json-" + "report.json" }
		,plugin = {"pretty", "html:target/cucumber"}
		,features = "features"
		,glue={"br.com.yaman.automacao.step"}
		,tags ={}
		)
public class RunTest {

}
