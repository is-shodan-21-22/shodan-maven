// Generated by Selenium IDE
package seleniumtesting;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class AggiungiCartaTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "../commons/driver/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void aggiungiCartaCVVMancante() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-submit")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1111222233334444");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Slaver Test");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2024-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("CVV: campo obbligatorio"));
  }
  @Test
  public void aggiungiCartaCartaEsistente() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("MASTERCARD");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("8219671281263413");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Slave Tester");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("123");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2025-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Carta gia\\\' esistente"));
  }
  @Test
  public void aggiungiCartaCartaScaduta() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1111222233334444");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Slaver Test");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("123");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2020-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Carta scaduta"));
  }
  @Test
  public void aggiungiCartaFormatoCVVNonValido() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1111222233334444");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Slaver Test");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("abc");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2024-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Formato CVV non valido"));
  }
  @Test
  public void aggiungiCartaFormatoDataNonValido() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1111222233334444");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Slaver Test");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("123");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2024/01/01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Formato data non valido"));
  }
  @Test
  public void aggiungiCartaFormatoNumeroNonValido() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1234");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Slaver Test");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("123");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2024-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Formato numero carta non valido"));
  }
  @Test
  public void aggiungiCartaFormatoTitolareNonValido() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1111222233334444");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("test");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("123");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2024-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Formato titolare non valido"));
  }
  @Test
  public void aggiungiCartaNumeroMancante() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Slaver Test");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("123");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2024-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Numero carta: campo obbligatorio"));
  }
  @Test
  public void aggiungiCartaOK() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("admin");
    driver.findElement(By.id("login-password")).click();
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-submit")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("roles-link")));
    }
    driver.findElement(By.id("roles-link")).click();
    driver.findElement(By.cssSelector(".role-item:nth-child(2)")).click();
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("NUOVA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1111222233334444");
    driver.findElement(By.cssSelector(".card-owner")).sendKeys("Admin Test");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("111");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2022-05-05");
    driver.findElement(By.cssSelector("#new-card-form-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".credit-card-add"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void aggiungiCartaTitolareMancante() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1898, 1018));
    driver.findElement(By.id("login-username")).click();
    driver.findElement(By.id("login-username")).sendKeys("slave");
    driver.findElement(By.id("login-password")).sendKeys("123");
    driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("settings-link")));
    }
    driver.findElement(By.id("settings-link")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-card")));
    }
    driver.findElement(By.id("add-card")).click();
    driver.findElement(By.cssSelector(".credit-card-add")).click();
    driver.findElement(By.cssSelector(".card-type")).click();
    driver.findElement(By.cssSelector(".card-type")).sendKeys("VISA");
    driver.findElement(By.cssSelector(".card-number")).sendKeys("1111222233334567");
    driver.findElement(By.cssSelector(".card-cvv")).sendKeys("123");
    driver.findElement(By.cssSelector(".card-due")).sendKeys("2024-01-01");
    driver.findElement(By.id("new-card-form-submit")).click();
    assertThat(driver.findElement(By.cssSelector(".card-tip")).getText(), is("Titolare: campo obbligatorio"));
  }
}
