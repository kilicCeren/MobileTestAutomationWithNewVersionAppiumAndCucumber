package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TeknosaPage {
    public TeknosaPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver()),this);
    }

    @FindBy(xpath = "//*[@text='Atla']")
    public WebElement atlaButonu;

    @FindBy(xpath = "//*[@text='Kategoriler']")
    public WebElement kategorilerButonu;

    @FindBy(xpath = "//*[@text='Filtrele']")
    public WebElement filtreleButonu;

    @FindBy(xpath = "//*[@text='Marka']")
    public WebElement markaButonu;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement markaMetinYazmaKutusu;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[24]")
    public WebElement filtrelenmisMarkaKutusu;

    @FindBy(xpath = "//*[@text='Sonuçları Göster']")
    public WebElement sonuclariGosterButonu;

    @FindBy(xpath = "//*[@text='Sırala']")
    public WebElement siralaButonu;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[8]")
    public WebElement artanDusukFiyat;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[10]")
    public WebElement artanYuksekFiyat;








}