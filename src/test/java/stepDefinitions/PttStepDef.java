package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PttPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class PttStepDef {

   PttPage page=new PttPage();

    @Given("Kullanici uygulamayi acar")
    public void kullanici_uygulamayi_acar() {
        Driver.getAndroidDriver();

    }
    @When("hesabim bolumune gider")
    public void hesabim_bolumune_gider() {
        ReusableMethods.bekle(3);
       page.accountButton.click();

    }
    @Then("Kullanıcı {string} butonunun göründüğünü doğrular")
    public void kullanıcı_butonunun_göründüğünü_doğrular(String string) {
        Assert.assertTrue(page.girisYapButton.isDisplayed());
        ReusableMethods.bekle(3);

    }
    @When("Kullanıcı ana sayfaya geri doner")
    public void kullanıcı_ana_sayfaya_geri_doner() {
        page.geriOkButton.click();
        ReusableMethods.bekle(3);

    }
    @When("{string} bolumune tiklar")
    public void bolumune_tiklar(String kategoriler) {
        page.kategorilerButton.click();
       // ReusableMethods.scrollWithUiScrollableAndClick(kategoriler);
        ReusableMethods.bekle(3);
    }
    @When("{string} bolumunu secer")
    public void bolumunu_secer(String kategoriBolum) {
        ReusableMethods.scrollWithUiScrollableAndClick(kategoriBolum);
        ReusableMethods.bekle(3);
    }
    @When("{string} secenegine gider")
    public void secenegine_gider(String urun) {
        ReusableMethods.dikeyKaydirma(Driver.getAndroidDriver(),0.70,0.30,0.50,100);
        ReusableMethods.bekle(3);
        ReusableMethods.scrollWithUiScrollableAndClick(urun);
        ReusableMethods.bekle(3);

    }
    @When("Urunleri {string} a gore siralar")
    public void urunleri_a_gore_siralar(String string) {
        page.siralaButton.click();
        ReusableMethods.bekle(3);
        page.AzalanFiyatText.click();
        ReusableMethods.bekle(3);

    }
    @Then("fiyatlarin azalan duzende oldugunu dogrular")
    public void fiyatlarin_azalan_duzende_oldugunu_dogrular() {
        String yuksekFiyat =page.ilkFiyat.getText();
        yuksekFiyat=yuksekFiyat.replaceAll("\\D","");
        ReusableMethods.bekle(3);

        String dusukFiyat =page.ikinciFiyat.getText();
        dusukFiyat=dusukFiyat.replaceAll("\\D","");
        ReusableMethods.bekle(3);

        Assert.assertTrue(Integer.parseInt(dusukFiyat)<Integer.parseInt(yuksekFiyat));


    }

}
