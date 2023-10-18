package starter.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    Base base;

    public Hooks(Base base){

        this.base = base;

    }
    @Before
    public void beforeScenario(Scenario scenario){
        scenario.log("Starting scenario: " + scenario.getName());
        base.createScenarioContext();
        base.setScenario(scenario);
    }

    @After
    public void afterScenario(Scenario scenario){
        scenario.log("Scenario status: " + scenario.getStatus());
    }
}
