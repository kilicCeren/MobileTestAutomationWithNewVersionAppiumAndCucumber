package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.Driver;

public class ApkStepDef {

    @Given("Kullanici uygulamayi yukler")
    public void kullanici_uygulamayi_yukler() {
        Driver.getAndroidDriver();

    }

}

