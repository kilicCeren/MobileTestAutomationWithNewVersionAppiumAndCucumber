# 📱 MobileTestAutomationWithNewVersionAppiumAndCucumber

Bu depo, mobil otomasyon testlerini modern bir yaklaşımla ele alan, **Appium (v8.x), Cucumber ve Java** kullanılarak geliştirilmiş kapsamlı bir projedir. Proje, iki popüler Android e-ticaret uygulaması olan **PTT AVM** ve **Teknosa** üzerinde kullanıcı akışlarını, **BDD (Behavior-Driven Development)** metodolojisi ile otomatikleştirir. Özellikle **Selenium 4**'ün yeni etkileşim metotları ve Appium 8'in modern `UiAutomator2Options` kullanımı bu projenin temelini oluşturur.

---

## 🛠️ Teknolojiler ve Yapı

Bu otomasyon projesinde kullanılan ana teknoloji ve kütüphaneler:

* **Java (JDK 11+):** Temel programlama dili.
* **Maven:** Proje bağımlılık yönetimi.
* **Appium Java Client (v8.5.1):** Yeni Appium sunucusuyla iletişim kurmak için modern versiyon.
* **Selenium (v4.9.1):** Güncel mobil element etkileşimleri ve otomasyonu için.
* **Cucumber (v7.4.1):** BDD senaryolarını (`.feature` dosyaları) çalıştırmak için.
* **JUnit:** Test çalıştırma aracı.

### 📁 Proje Yapısı

Proje, standart bir Maven ve otomasyon iskeleti kullanılarak düzenlenmiştir:

```
MobileTestAutomationWithNewVersionAppiumAndCucumber/
 ├── .idea/ 
 ├── src/ 
 │ └── test/ 
 │ ├── java/ 
 │ │ ├── pages/ 
 │ │ │ ├── PttPage.java # PTT AVM Page Object Model (POM) 
 │ │ │ └── TeknosaPage.java # Teknosa Page Object Model (POM) 
 │ │ ├── runners/ 
 │ │ │ └── Runner.java # Cucumber Test Çalıştırıcı 
 │ │ └── stepDefinitions/ 
 │ │ ├── ApkStepDef.java # Uygulama Yükleme/Açma Adımları 
 │ │ ├── TeknosaStepDef.java # Teknosa senaryolarının implementasyonu 
 │ │ └── pttStepDef.java # PTT AVM senaryolarının implementasyonu 
 │ └── resources/ 
 │ └── Features/ 
 │ ├── ApkYukleme.feature # APK yükleme senaryoları 
 │ ├── Ptt.feature # PTT AVM test senaryoları 
 │ └── Teknosa.feature # Teknosa test senaryoları 
 ├── Apps/ 
 │ └── *.apk # Test edilen uygulamaların APK dosyaları 
 ├── configuration.properties # Temel platform konfigürasyonu 
 ├── pom.xml # Proje bağımlılıkları ve konfigürasyonu 
 └── .gitignore
```

---

## 🎯 Test Edilen Uygulamalar ve Senaryolar

Bu proje, iki farklı mobil uygulama üzerinde çeşitli kullanıcı akışlarını test eder:

### 1. 🛒 PTT AVM Testleri (`Ptt.feature`)

Bu senaryolar, PTT AVM uygulamasının temel işlevselliğini ve e-ticaret akışlarını kapsar:

* **Kullanıcı Giriş Kontrolü:** Hesabım bölümüne gidilerek "Giriş Yap" butonunun görünürlüğü doğrulanır.
* **Filtreleme ve Sıralama:** Belirli bir kategoriye (Örn: Beyaz Eşya > Kurutma Makineleri) gidilir ve ürünlerin **Azalan Fiyat**'a göre sıralandığı doğrulanır. (Fiyat karşılaştırması yapılarak azalan düzen test edilir.)

### 2. 💻 Teknosa Testleri (`Teknosa.feature`)

Bu senaryolar, Teknosa uygulamasının filtreleme, sıralama ve yardımcı metotlarını test eder:

* **Marka Filtreleme:** Kategori seçimi (Örn: Ev ve Yaşam > Aydınlatma) yapıldıktan sonra "Orbus" veya "Arzum" gibi belirli bir marka seçimi yapılarak sonuçların gösterilmesi.
* **Artan Fiyat Sıralaması:** Kategori ve filtreleme sonrası ürünlerin **Artan Fiyat**'a göre sıralandığı ve bunun doğru çalıştığı doğrulanır.
* **Ekran Görüntüsü Alma:** Belirli bir elementin (`"Kampanyalar"`) ekran görüntüsünün alınması işlevi test edilir.

---

## ⚙️ Appium Konfigürasyonu ve Yardımcı Sınıflar

Proje, Appium'un yeni özelliklerini kullanarak geliştirilmiştir:

### 📄 Page Object Model (POM)

* `pages/PttPage.java` ve `pages/TeknosaPage.java`: Her uygulamanın elementleri ayrı sayfa sınıflarında, `@FindBy` anotasyonu kullanılarak tanımlanmıştır.

### 🔗 Utilities (Yardımcı Sınıflar)

* `utilities/Driver.java`:
    * **Appium 8** uyumlu `UiAutomator2Options` kullanılarak mobil yetenekler (Capabilities) ayarlanmıştır.
    * Uygulamalar arasında geçiş yapmak için `setApp`, `setAppPackage` ve `setAppActivity` değerleri kolayca değiştirilebilir/yorum satırı yapılabilir durumdadır.
    * Sürücünün başlatılması (`getAndroidDriver()`) ve kapatılması (`quitAppiumDriver()`) sağlanır.
* `utilities/ReusableMethods.java`:
    * **Yeni Selenium 4 Etkileşimleri:** `dikeyKaydirma()` metodu, `PointerInput` ve `Sequence` sınıflarını kullanarak modern ve stabil kaydırma (scroll) işlemini gerçekleştirir. 
    * `scrollWithUiScrollableAndClick()`: Android'e özgü metotlarla ekranda görünmeyen elementlere kaydırarak ulaşım sağlar.
    * `screenShotElement()`: Belirli bir elementin kırpılmış ekran görüntüsünü alma yeteneği sunar.

---

## 🚀 Nasıl Çalıştırılır?

Bu projeyi yerel ortamınızda çalıştırmak için aşağıdaki adımları takip etmeniz gerekir:

### Ön Gereksinimler

* **Java Development Kit (JDK 11 veya üstü)**
* **Maven**
* **Android SDK ve bir Android Emülatörü** (Veya fiziksel cihaz)
* **Appium Server** (Lokalde çalışır durumda olmalıdır: `http://127.0.0.1:4723/`)

### Kurulum ve Çalıştırma

1.  **Depoyu Klonlayın:**
    ```bash
    git clone [https://github.com/KULLANICI_ADINIZ/MobileTestAutomationWithNewVersionAppiumAndCucumber.git](https://github.com/KULLANICI_ADINIZ/MobileTestAutomationWithNewVersionAppiumAndCucumber.git)
    ```
2.  **Konfigürasyonu Kontrol Edin:**
    * `src/test/java/utilities/Driver.java` içindeki emülatör adı (`Pixel 4`, `10.0`) ve test etmek istediğiniz uygulamaya ait `setAppPackage`/`setAppActivity` ayarlarını kontrol edin. (Projeye uygun APK dosyasının yolu da ayarlanmalıdır.)
3.  **Testleri Çalıştırın:**
    * **IntelliJ IDEA:** `src/test/java/runners/Runner.java` sınıfını sağ tıklayıp "Run 'Runner'" seçeneği ile çalıştırın.
    * **Maven Komutu:** Belirli bir tag'i çalıştırmak için:
        ```bash
        # Sadece Teknosa testlerini çalıştırır
        mvn test -Dcucumber.options="--tags @teknosa" 
        
        # Sadece PTT AVM testlerini çalıştırır
        mvn test -Dcucumber.options="--tags @ptt"
        ```
# 📱 MobileTestAutomationWithNewVersionAppiumAndCucumber

This repository is a comprehensive project developed using **Appium (v8.x), Cucumber, and Java**, adopting a modern approach to mobile automation testing. The project automates user flows on two popular Android e-commerce applications, **PTT AVM** and **Teknosa**, utilizing the **BDD (Behavior-Driven Development)** methodology. The foundation of this project relies heavily on the new interaction methods of **Selenium 4** and the modern `UiAutomator2Options` capabilities introduced in Appium 8.

---

## 🛠️ Technologies and Structure

The main technologies and libraries used in this automation project are:

* **Java (JDK 11+):** Primary programming language.
* **Maven:** Project dependency management.
* **Appium Java Client (v8.5.1):** The modern version for communicating with the latest Appium server.
* **Selenium (v4.9.1):** For up-to-date mobile element interactions and automation.
* **Cucumber (v7.4.1):** Used to run BDD scenarios (`.feature` files).
* **JUnit:** Test execution tool.

### 📁 Project Structure

The project is organized using a standard Maven and automation test framework:

```
MobileTestAutomationWithNewVersionAppiumAndCucumber/ 
├── .idea/ 
├── src/ 
│ └── test/ 
│ ├── java/ 
│ │ ├── pages/ 
│ │ │ ├── PttPage.java # PTT AVM Page Object Model (POM) 
│ │ │ └── TeknosaPage.java # Teknosa Page Object Model (POM) 
│ │ ├── runners/ 
│ │ │ └── Runner.java # Cucumber Test Runner 
│ │ └── stepDefinitions/ 
│ │ ├── ApkStepDef.java # Application Installation/Launch Steps 
│ │ ├── TeknosaStepDef.java # Implementation of Teknosa scenarios 
│ │ └── pttStepDef.java # Implementation of PTT AVM scenarios 
│ └── resources/ 
│ └── Features/ 
│ ├── ApkYukleme.feature # APK installation scenarios 
│ ├── Ptt.feature # PTT AVM test scenarios 
│ └── Teknosa.feature # Teknosa test scenarios 
├── Apps/ 
│ └── *.apk # APK files of the applications under test 
├── configuration.properties # Basic platform configuration 
├── pom.xml # Project dependencies and configuration 
└── .gitignore
```
---

## 🎯 Applications and Scenarios Under Test

This project tests various user flows across two different mobile applications:

### 1. 🛒 PTT AVM Tests (`Ptt.feature`)

These scenarios cover the core functionality and e-commerce flows of the PTT AVM application:

* **User Login Verification:** Verifies the visibility of the "Giriş Yap" (Log In) button by navigating to the "Hesabım" (My Account) section.
* **Filtering and Sorting:** Navigates to a specific category (e.g., White Goods > Tumble Dryers) and verifies that products are sorted by **Decreasing Price** ("Azalan Fiyat"). (The test compares prices to ensure the descending order is correct.)

### 2. 💻 Teknosa Tests (`Teknosa.feature`)

These scenarios test the filtering, sorting, and utility methods of the Teknosa application:

* **Brand Filtering:** Performs a category selection (e.g., Home and Living > Lighting) and verifies that search results are shown after selecting a specific brand like "Orbus" or "Arzum."
* **Ascending Price Sorting:** Verifies that products are sorted by **Ascending Price** ("Artan Fiyat") after category and filtering, confirming that the sorting works correctly.
* **Screenshot Capture:** Tests the functionality of capturing a screenshot of a specific element (e.g., the text **"Kampanyalar"** - Campaigns).

---

## ⚙️ Appium Configuration and Utility Classes

The project is developed utilizing new features from Appium:

### 📄 Page Object Model (POM)

* `pages/PttPage.java` and `pages/TeknosaPage.java`: Elements for each application are defined in separate page classes using the `@FindBy` annotation.

### 🔗 Utilities

* `utilities/Driver.java`:
    * Mobile capabilities are configured using the **Appium 8** compatible `UiAutomator2Options`.
    * The `setApp`, `setAppPackage`, and `setAppActivity` values are easily modifiable/commented out to switch between applications.
    * Manages the initialization (`getAndroidDriver()`) and termination (`quitAppiumDriver()`) of the driver.
* `utilities/ReusableMethods.java`:
    * **New Selenium 4 Interactions:** The `dikeyKaydirma()` (vertical scroll) method utilizes the `PointerInput` and `Sequence` classes for modern and stable scroll actions. 
    * `scrollWithUiScrollableAndClick()`: Uses Android-specific methods to scroll to and click elements that are not immediately visible on the screen.
    * `screenShotElement()`: Offers the ability to capture a cropped screenshot of a specific element.

---

## 🚀 How to Run?

To run this project in your local environment, you need to follow the steps below:

### Prerequisites

* **Java Development Kit (JDK 11 or higher)**
* **Maven**
* **Android SDK and an Android Emulator** (Or physical device)
* **Appium Server** (Must be running locally: `http://127.0.0.1:4723/`)

### Setup and Execution

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/MobileTestAutomationWithNewVersionAppiumAndCucumber.git](https://github.com/YOUR_USERNAME/MobileTestAutomationWithNewVersionAppiumAndCucumber.git)
    ```
2.  **Verify Configuration:**
    * Check the emulator name (`Pixel 4`, `10.0`) and the `setAppPackage`/`setAppActivity` settings for the application you want to test within `src/test/java/utilities/Driver.java`. (The correct path to the relevant APK file must also be set.)
3.  **Run Tests:**
    * **IntelliJ IDEA:** Right-click the `src/test/java/runners/Runner.java` class and select "Run 'Runner'".
    * **Maven Command:** To run tests with a specific tag:
        ```bash
        # Runs only Teknosa tests
        mvn test -Dcucumber.options="--tags @teknosa" 
        
        # Runs only PTT AVM tests
        mvn test -Dcucumber.options="--tags @ptt"
        ```
