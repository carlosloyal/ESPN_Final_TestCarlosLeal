package StepDefinitions;

import Functions.SeleniumFunctions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.java.es.Entonces;


public class PropertiesScenario {

    SeleniumFunctions functions = new SeleniumFunctions();


    @Given("The data of environment and users of the system")
    public void TheDataOfEnvironmentAndUsersOfTheSystem() throws Exception {
        functions.RetriveTestDatas();
    }


}
