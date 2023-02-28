package steps;

import cucumber.api.java.After;
import utilities.Driver;

public class Hook {
    @After
    public void teardown(){
        Driver.quitDriver();
    }
}

