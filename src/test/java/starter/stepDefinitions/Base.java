package starter.stepDefinitions;

import io.cucumber.java.Scenario;

import java.util.HashMap;

public class Base {

     HashMap<String, Object> scenarioContext = new HashMap<>();
     Scenario scenario;


    public void createScenarioContext() {
        scenarioContext = new HashMap<>();
    }

    public HashMap<String, Object> getScenarioContext() {
        return scenarioContext;
    }

    public void put(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public <T> T get(String key) {
        return (T) scenarioContext.get(key);
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Scenario getScenario() {
        return scenario;
    }

}
