package com.pluralsight.bdd.loyalty_cards;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features/loyalty_cards",glue = "com.pluralsight.bdd")

public class SuperSmoothieProgramTestSuite {

}
