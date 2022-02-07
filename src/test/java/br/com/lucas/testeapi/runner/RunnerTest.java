package br.com.lucas.testeapi.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
				glue = {"br.com.lucas.testeapi.steps"}, //
				tags = "@login and @TA_0001" // 
				)
public class RunnerTest {

}
