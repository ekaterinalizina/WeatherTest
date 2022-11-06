import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.Set;

import static java.awt.SystemColor.text;
import static org.testng.Assert.assertTrue;

public class EkaterinaLizinaTest {

    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"


    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        //Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );

        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );

        searchButton.click();

        Thread.sleep(1000);

        WebElement parisFrhoiseInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class ='search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );

        parisFrhoiseInDropDownMenu.click();


        WebElement h2CityCountHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);

        String actualResult = h2CityCountHeader.getText();

        //Thread.sleep(5000);

        //Assert
        Assert.assertEquals(actualResult, expectedResult);
        // Thread.sleep(5000);

        driver.quit();

    }



    //    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой
// https://openweathermap.org/guide и что title этой страницы OpenWeatherMap
// API guide - OpenWeatherMap
    @Test

    public void testPage() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/guide";
        String expectedTitle = "OpenWeatherMap API guide - OpenWeatherMap";
        //Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement guideMenuButton = driver.findElement(
                By.xpath("//div[@id ='desktop-menu']//a[@href = '/guide']")
        );


        guideMenuButton.click();

        Thread.sleep(1000);

        String actualResult = driver.getCurrentUrl();
        String actualResultTitle = driver.getTitle();
        //Assert
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResultTitle, expectedTitle);

        driver.quit();
    }

    @Test

    public void testPageTitle() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        //Act
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement ButtonMenuGuide = driver.findElement(
                By.xpath("//div[@id ='desktop-menu']//a[@href = '/guide']")
        );

        ButtonMenuGuide.click();

        Thread.sleep(1000);

        String actualResult = driver.getTitle();
        //Assert
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test

    public void testMenuButtonGuide() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.manage().window().maximize();
        String expectedResult1 = "https://openweathermap.org/guide";
        String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        //Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement guideMenuButton = driver.findElement(
                By.xpath("//div[@id ='desktop-menu']//a[@href = '/guide']")
        );

        guideMenuButton.click();

        Thread.sleep(1000);

        String actualResult1 = driver.getCurrentUrl();
        String actualResult12 = driver.getTitle();
        //Assert
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult12, expectedResult2);
        driver.quit();
    }
    //    TC_11_02
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //
    //3.  Подтвердить, что температура для города показана в Фарингейтах

    @Test
    public void testTemperatureChangedInToF() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.manage().window().maximize();
        String expectedResult = "°F";
        String fTempSymbol = "°F";

        //Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement ButtonTemperatureFarenheit = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[text() = 'Imperial: °F, mph']"));
        ButtonTemperatureFarenheit.click();

        WebElement tempF = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//span[@class ='heading']"));

    //    String actualResult2= ButtonTemperatureFarenheit.getText().substring();

        Boolean isTemperatureInF = tempF.getText().contains("°F");
        Assert.assertTrue(tempF.getText().contains(fTempSymbol));
 //        boolean actualResult = temperatureMesurementIn.toString().contains("°F");
//        boolean expectedResult1 = expectedResult.equals(actualResult);
//        Assert.assertEquals(actualResult,expectedResult1);
        driver.quit();
    }
    @Ignore
    @Test
    public void testTemperatureIsInF() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.manage().window().maximize();
        String expectedResult = "°F";

        //Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement ButtonTemperatureFarenheit = driver.findElement(By.xpath("//div[@id = 'weather-widget']//div[text() = 'Imperial: °F, mph']"));
        ButtonTemperatureFarenheit.click();
        WebElement temperatureMesurementIn = driver.findElement(By.xpath("//div[@id = 'weather-widget']//span[@class ='heading']"));
        String actualResult = String.valueOf(temperatureMesurementIn.getText().contains("°F"));

        boolean expectedResult1 = expectedResult.equals("°F");
        Assert.assertEquals(actualResult, expectedResult1);

        driver.quit();
    }

    //TC_11_03
    //1.  Открыть базовую ссылку
    //2. Подтвердить, что внизу страницы есть панель с текстом
    // “We use cookies which are essential for the site to work.
    // We also use non-essential cookies to help us improve our services.
    // Any data collected is anonymised. You can allow all cookies or manage
    // them individually.”
    //3. Подтвердить, что на панели внизу страницы есть 2 кнопки
    // “Allow all” и “Manage cookies”
    //дополнение: именно нужно подтвердить, что есть 2 и именно кнопки
    @Test
    public void testTwoButtonsCookies() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        String expectedResult1 = "We use cookies which are essential for the site to work." +
                " We also use non-essential cookies to help us improve our services." +
                " Any data collected is anonymised. You can allow all cookies" +
                " or manage them individually.";
        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        //ACT
        WebElement cookiesText = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//p[contains(text (), 'We use cookies which')]"));
        String actualResult1 = cookiesText.getText();

        WebElement cookiesButton1 = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//button[text() = 'Allow all']"));
        WebElement cookiesButton2 = driver.findElement
                (By.xpath("//div[@id = 'stick-footer-panel']//a[text() = ' Manage cookies ']"));
        String actualResult2 = cookiesButton1.getText();
        String actualResult3 = cookiesButton2.getText();


        //Assert
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);


        driver.quit();
    }

    ////TC_11_04
    //Открыть базовую ссылку
    //2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”,
    // “How to start” и “Ask a question”

    @Test
    public void testSupportMenuHasThreeSubmenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);

        String expectedResult1 = "Support";
        String expectedResult2 = "FAQ";
        String expectedResult3 = "How to start";
        String expectedResult4 = "Ask a question";

        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']"));
        String actualResult1 = supportMenu.getText();

        supportMenu.click();

        Thread.sleep(2000);

        WebElement supportSubMenuFAQ = driver.findElement(
                By.xpath("//ul[@id=\"support-dropdown-menu\"]//a[text() = 'FAQ']"));
        String actualResult2 = supportSubMenuFAQ.getText();

        WebElement supportSubMenuHowToStart = driver.findElement(
                By.xpath("//ul[@id=\"support-dropdown-menu\"]//a[text() = 'How to start']"));
        String actualResult3 = supportSubMenuHowToStart.getText();

        WebElement supportSubMenuAskAQuestion = driver.findElement(By.xpath("//ul[@id=\"support-dropdown-menu\"]//a[text() = 'Ask a question']"));
        String actualResult4 = supportSubMenuAskAQuestion.getText();
        //Assert
        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);
        Assert.assertEquals(actualResult4, expectedResult4);

        driver.quit();
    }

    //TC_11_05
    //1. Открыть базовую ссылку
    //2. Нажать пункт меню Support → Ask a question
    //3. Заполнить поля Email, Subject, Message
    //4. Не подтвердив CAPTCHA, нажать кнопку Submit
    //5. Подтвердить, что пользователю будет показана ошибка
    // “reCAPTCHA verification failed, please try again.”

    @Test
    public void testSupportMenuSubMenuAskAQuestion() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String eMailaddress = "tester@test.com";
        String subjectText = "This is a text";
        String messageText = "This is my message";
        String expectedResult = "reCAPTCHA verification failed, please try again.";
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        //act
        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']"));
       // String actualResult1 = supportMenu.getText();

        supportMenu.click();

        Thread.sleep(2000);

        WebElement supportSubMenuAskAQuestion = driver.findElement(
                By.xpath("//ul[@id=\"support-dropdown-menu\"]//a[text() = 'Ask a question']"));
        supportSubMenuAskAQuestion.click();
        Thread.sleep(10000);

      //  driver.get("https://home.openweathermap.org/questions");

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        //3. Заполнить поля Email, Subject, Message
        WebElement eMail = driver.findElement(
                By.xpath("//form[@id= 'new_question_form']//input[@type = 'email']"));
        eMail.click();
        Thread.sleep(4000);
        eMail.sendKeys(eMailaddress);

        Thread.sleep(3000);


        WebElement subject = driver.findElement(By.xpath("//select[@id = 'question_form_subject']"));
        subject.click();
        Thread.sleep(3000);
        //выбрать из dropDown menu
        WebElement choiseFromDropDownMenu  = driver.findElement(By.xpath("//option[@value = 'Sales']"));
        Thread.sleep(3000);
        choiseFromDropDownMenu.click();
        //WebElement choiseFromDropDownMenu = driver.switchTo().activeElement().findElement(By.xpath("//option[@value = 'Sales']"));
//        WebElement choiseFromDropDownMenu = driver.findElement(By.xpath("//option[@value = 'Sales']"));
//        Select select = new Select(choiseFromDropDownMenu);
//        select.selectByValue("Data Issue");

        Thread.sleep(4000);
        WebElement message = driver.findElement(By.xpath("//textarea[@id = 'question_form_message']"));

        message.click();
        message.sendKeys(messageText);

        //scroll the page
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)", "");

        Thread.sleep(5000);

        //4. Не подтвердив CAPTCHA, нажать кнопку Submit
        WebElement submitButton = driver.findElement(
                By.xpath("//input [@value = 'Submit']"));

        submitButton.click();

        Thread.sleep(3000);

        //5. Подтвердить, что пользователю будет показана ошибка
        // “reCAPTCHA verification failed, please try again.”
        driver.navigate().forward();

        Thread.sleep(5000);

        WebElement reCaptchaTextFailedMessage = driver.findElement(
                By.xpath("//form[@id = 'new_question_form']//div[text() ='reCAPTCHA verification failed, please try again.']"));

        String actualResult = reCaptchaTextFailedMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Thread.sleep(3000);

        driver.quit();
    }


    @Test
    public void testWindowPopup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String eMailaddress = "tester@test.com";
        String subjectText = "This is a text";
        String messageText = "This is my message";
        String expectedResult = "reCAPTCHA verification failed, please try again.";
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        //act
        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']"));
        // String actualResult1 = supportMenu.getText();

        supportMenu.click();

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Chrome  расматривает окно как новую вкладку, те это как будтно
        // заново запущенный браузер

        WebElement supportSubMenuAskAQuestion = driver.findElement(
                By.xpath("//ul[@id=\"support-dropdown-menu\"]//a[text() = 'Ask a question']"));
        supportSubMenuAskAQuestion.click();
        Thread.sleep(10000);

        try{
            driver.get("https://home.openweathermap.org/questions");
            Thread.sleep(5000);

            //идентификаторо того окна, с которым мы сейчас работаем,
            // мы сохраняем в переменную
            //берем дискриптор текущего окна
            String window1 = driver.getWindowHandle();
            //таким образом мы открываем два окна
            js.executeScript("window.open()");

            //cохраняем набор неопорядоченных строк, в случайном порядке
            //где хранятся наши окна - список всех окон
            Set<String> currentWindows = driver.getWindowHandles();

            //cоздаем дискриптор для второго окна
            String window2 = null;

            //перебираем список из всех дискрипторов окон
            //cоздаем условие: мы проверяем все варианты и сравниваем с нашим 1м окном
            // если мы столкнемся с тем, который мы уже сохранили, то его пропустим
            //а если столкнемся с дискрпитором, которого у нас нет, то мы его сохраним
            //в переменную window2
            for (String window: currentWindows) {
                if(!window.equals(window1)){
                    window2 = window;
                    break;
                }
            }
            //это переключатель между окнами
            driver.switchTo().window(window2);
            driver.get("https://home.openweathermap.org/questions");
            //после окончания использования окна мы его можем закрыть, но это
            //не будет означать, что мы перешли на другую вкладку
            //нужно будет указать driver.get("url")
            //driver.switchTo().window(window1);

            //3. Заполнить поля Email, Subject, Message
            WebElement eMail = driver.findElement(
                    By.xpath("//form[@id= 'new_question_form']//input[@type = 'email']"));
            eMail.click();
            Thread.sleep(2000);
            eMail.sendKeys(eMailaddress);

            Thread.sleep(3000);

            WebElement subject = driver.findElement(By.xpath("//select[@id = 'question_form_subject']"));
            subject.click();
            Thread.sleep(3000);
            //выбрать из dropDown menu
            WebElement choiseFromDropDownMenu = driver.switchTo().activeElement().findElement(By.xpath("//option[@value = 'Sales']"));

            Thread.sleep(5000);
            WebElement message = driver.findElement(By.xpath("//textarea[@id = 'question_form_message']"));
            message.click();
            Thread.sleep(3000);
            message.sendKeys(messageText);

            //scroll the page
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,500)", "");

            Thread.sleep(3000);

            //4. Не подтвердив CAPTCHA, нажать кнопку Submit
            WebElement submitButton = driver.findElement(By.xpath("//input [@value = 'Submit']"));
            submitButton.click();

            Thread.sleep(4000);

            //5. Подтвердить, что пользователю будет показана ошибка
            // “reCAPTCHA verification failed, please try again.”
            driver.navigate().forward();

            Thread.sleep(5000);

            WebElement reCaptchaTextFailedMessage = driver.findElement(
                    By.xpath("//form[@id = 'new_question_form']//div[text() ='reCAPTCHA verification failed, please try again.']"));

            String actualResult = reCaptchaTextFailedMessage.getText();

            Assert.assertEquals(actualResult, expectedResult);
            Thread.sleep(3000);
            //           driver.close();
 //           driver.switchTo().window(window1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

    //TC_11_06
    //1.  Открыть базовую ссылку
    //2.  Нажать пункт меню Support → Ask a question
    //3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
    //4. Оставить пустым поле Email
    //5. Заполнить поля  Subject, Message
    //6. Подтвердить CAPTCHA
    //7. Нажать кнопку Submit
    //8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
    @Test
    public void testSupportAskQuestionEmailFieldCanNotBeBlank() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://openweathermap.org/";
        String subjectText = "This is a text";
        String messageText = "This is my message";
        String expectedResult = "can't be blank";
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(5000);
        //act
        WebElement supportMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']"));
        // String actualResult1 = supportMenu.getText();

        supportMenu.click();

        Thread.sleep(2000);

        WebElement supportSubMenuAskAQuestion = driver.findElement(
                By.xpath("//ul[@id=\"support-dropdown-menu\"]//a[text() = 'Ask a question']"));
        supportSubMenuAskAQuestion.click();
        Thread.sleep(10000);

        //  driver.get("https://home.openweathermap.org/questions");

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        //3. НЕ Заполнять поля Email, Subject, Message
        Thread.sleep(3000);


        WebElement subject = driver.findElement(By.xpath("//select[@id = 'question_form_subject']"));
        subject.click();
        Thread.sleep(3000);
        //выбрать из dropDown menu
        WebElement choiseFromDropDownMenu  = driver.findElement(By.xpath("//option[@value = 'Sales']"));
        Thread.sleep(3000);
        choiseFromDropDownMenu.click();
        //WebElement choiseFromDropDownMenu = driver.switchTo().activeElement().findElement(By.xpath("//option[@value = 'Sales']"));
//        WebElement choiseFromDropDownMenu = driver.findElement(By.xpath("//option[@value = 'Sales']"));
//        Select select = new Select(choiseFromDropDownMenu);
//        select.selectByValue("Data Issue");

        Thread.sleep(4000);
        WebElement message = driver.findElement(By.xpath("//textarea[@id = 'question_form_message']"));

        message.click();
        message.sendKeys(messageText);

        //scroll the page
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)", "");

        Thread.sleep(5000);

        //4. Подтвердить CAPTCHA,

//        driver.switchTo().frame("a-9wt0e8vkopnm");
//        driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();


        WebElement captchaCheckBox = driver.findElement(
                By.xpath("//div[@class = 'recaptcha-checkbox-border']"));
        captchaCheckBox.click();

        // нажать кнопку Submit
        WebElement submitButton = driver.findElement(
                By.xpath("//input [@value = 'Submit']"));

        submitButton.click();

        Thread.sleep(3000);

        //5. Подтвердить, что в поле Email пользователю
        // будет показана ошибка “can't be blank”
        driver.navigate().forward();

        Thread.sleep(5000);

        WebElement eMailFailedMessage = driver.findElement(
                By.xpath("//div[@class = 'form-group email required question_form_email has-error']//span[@class = 'help-block']"));
        String actualResult =eMailFailedMessage.getText();

        Assert.assertEquals(actualResult, expectedResult);
        Thread.sleep(3000);

        driver.quit();
    }
    //TC_11_07
    //1.  Открыть базовую ссылку
    //2.  Нажать на единицы измерения Imperial: °F, mph
    //
    //3.  Нажать на единицы измерения Metric: °C, m/s
    //4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

    @Test
    public void testTemperatureChangedFromFtoC() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.manage().window().maximize();
        String expectedResult = "°C";


        //Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement buttonTemperatureFarenheit = driver.findElement(By.xpath("//div[@id = 'weather-widget']//div[text() = 'Imperial: °F, mph']"));
        buttonTemperatureFarenheit.click();

        Thread.sleep(3000);

        WebElement temperatureMesurementIn = driver.findElement(By.xpath("//div[@id = 'weather-widget']//span[@class ='heading']"));
        WebElement buttonTemperatureCelcium = driver.findElement(By.xpath("//div[@class = 'switch-container']//div[text() = 'Metric: °C, m/s']"));
        buttonTemperatureCelcium.click();
        boolean actualResult = temperatureMesurementIn.toString().contains("°C");
        boolean expectedResult1 = expectedResult.equals(actualResult);
        Assert.assertEquals(actualResult,expectedResult1);
        driver.quit();
    }
    //TC_11_08
    //1.  Открыть базовую ссылку
    //2.  Нажать на лого компании
    //
    //3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить,
    // что текущая ссылка не изменилась

    @Test
    public void testUrlHasNotChangedAfterClickingOnLogo() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();
        String expectedResult = "https://openweathermap.org/";

        //act
        Thread.sleep(5000);
        WebElement logoClick = driver.findElement(By.xpath("//img[@src = '/themes/openweathermap/assets/img/logo_white_cropped.png']"));
        logoClick.click();
        String actualResult = driver.getCurrentUrl();

        //Assert
        Thread.sleep(2000);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    //1.  Открыть базовую ссылку
    //2.  В строке поиска в навигационной панели набрать “Rome”
    //
    //3.  Нажать клавишу Enter
    //4.  Подтвердить, что вы перешли на страницу
    // в ссылке которой содержатся слова “find” и “Rome”
    //5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”
    @Test
    public void testSearchRome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();
        String word1 = "Rome";
        String word2 = "find";
        String expectedResult2 = "Rome";
        boolean expectedResult = word1.toString().equals("Rome") && word2.toString().equals("find");

        WebElement searchWeatherInYourCity = driver.findElement(By.xpath("//div[@id = 'desktop-menu']//input[@placeholder = 'Weather in your city']"));
        searchWeatherInYourCity.sendKeys(word1 + "\n");

//        WebElement searchValue  = driver.findElement(By.xpath("//input[@class = 'form-control border-color col-sm-12']"));
//        String actualResult2 = searchValue.getText();

//        Assert.assertEquals(actualResult2, expectedResult2 );
        boolean actualResult = driver.getCurrentUrl().toString().contains("Rome")
                && driver.getCurrentUrl().toString().contains("find");
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
//TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок

@Test
    public void testDeskTopMenuClickAPIFind30Buttons() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
    WebDriver driver = new ChromeDriver();

    //Arrange
    String url = "https://openweathermap.org/";
    driver.get(url);
    driver.manage().window().maximize();
    int expectedResult = 30;
    Thread.sleep(5000);
 //   WebElement api = driver.findElement(By.xpath("//div[@id = 'desktop-menu']//a[text()= 'API']"));
 //   api.click();
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'desktop-menu']//a[text()= 'API']"))).click();

    //.implies that the click on the desired element was intercepted by some other element.

    WebElement element = driver.findElement(
            By.xpath("//div[@id = 'desktop-menu']//a[text()= 'API']"));
    element.click();
//    Actions actions = new Actions(driver);
//    actions.moveToElement(element).click().build().perform();

//    for (String winHandle : driver.getWindowHandles()) {
//        driver.switchTo().window(winHandle);
//    }


    int countButton = driver.findElements(
            By.xpath("//a[contains(@class, 'btn_block orange round') " +
                    "or contains(@class, 'ow-btn round btn-orange') ]")).size();

   int actualResult = countButton;

    Assert.assertEquals(actualResult, expectedResult);
    driver.quit();

}

    @Test
    public void testDeskTopMenuClickAPIFind30ButtonsChecked() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
        driver.manage().window().maximize();
        int expectedResult = 30;
        Thread.sleep(5000);

        WebElement element = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//a[text()= 'API']"));
        element.click();

        int countButton = driver.findElements(
                By.xpath("//a[contains(@class, 'btn_block orange round') " +
                        "or contains(@class, 'ow-btn round btn-orange') ]")).size();

        int actualResult = countButton;

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

    @Test
    public void testDeskTopMenuClickAPIFind30ButtonsChecked1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers_for_Selenium/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Arrange
        String url = "https://openweathermap.org/";
        driver.get(url);
    }

}

