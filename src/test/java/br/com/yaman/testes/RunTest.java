package br.com.yaman.testes;
 
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
 
/**
* 
* Propósito da classe: Realizar execução dos testes via JUnit
*
* @since 3 de jul de 2017 08:19:27
* @authorDaniel Simião<BR>
*         DesafioYaman<BR>
* 
*/
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
