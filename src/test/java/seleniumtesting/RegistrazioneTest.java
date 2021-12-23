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
public class RegistrazioneTest {
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
  public void registrazioneOK() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1822, 1054));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("Francesco");
    driver.findElement(By.id("signin-password")).sendKeys("a1234");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1234");
    driver.findElement(By.id("signin-email")).sendKeys("Francesco@Shodan.it");
    driver.findElement(By.id("signin-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("signin-message"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneEmailNonValida() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1822, 1040));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("test");
    driver.findElement(By.id("signin-password")).click();
    driver.findElement(By.id("signin-password")).sendKeys("a1234");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1234");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("test@@a.it");
    driver.findElement(By.id("signin-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@signin-message,\'\')]"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneEmailInUso() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1822, 1040));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("test");
    driver.findElement(By.id("signin-password")).click();
    driver.findElement(By.id("signin-password")).sendKeys("a1234");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1234");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("antonio@shodan.it");
    driver.findElement(By.id("signin-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("signin-message"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneEmailMancante() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("test");
    driver.findElement(By.id("signin-username")).sendKeys("test5");
    driver.findElement(By.id("signin-password")).click();
    driver.findElement(By.id("signin-password")).sendKeys("a1234");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1234");
    driver.findElement(By.id("signin-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@signin-message,\'\')]"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazionePasswordDiverse() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("test_nuovo");
    driver.findElement(By.id("signin-password")).sendKeys("a1234");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1235");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("tes3t@test.it");
    driver.findElement(By.id("signin-submit")).click();
    assertThat(driver.findElement(By.id("signin-message")).getText(), is("Le password non coincidono"));
  }
  @Test
  public void registrazionePasswordMancante() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("test3");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1234");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("test2@test.it");
    driver.findElement(By.id("signin-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@signin-message,\'\')]"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazionePasswordNonValida() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("test");
    driver.findElement(By.id("signin-username")).sendKeys("test5");
    driver.findElement(By.id("signin-password")).click();
    driver.findElement(By.id("signin-password")).sendKeys("a123");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a123");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("test2@test.it");
    driver.findElement(By.id("signin-submit")).click();
    {
      WebElement element = driver.findElement(By.id("signin-submit"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    assertThat(driver.findElement(By.id("signin-message")).getText(), is("La password non rispetta i criteri.\\\\nSono necessari almeno cinque caratteri,\\\\ndi cui per lo meno un numero e una lettera."));
  }
  @Test
  public void registrazioneRipetiPasswordMancante() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("test5");
    driver.findElement(By.id("signin-password")).click();
    driver.findElement(By.id("signin-password")).sendKeys("test1");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("test2@test.it");
    driver.findElement(By.id("signin-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@signin-message,\'\')]"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneUsernameInUso() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("admin");
    driver.findElement(By.id("signin-password")).sendKeys("a1234");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1234");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("antonio@shodan.it");
    driver.findElement(By.id("signin-submit")).click();
    assertThat(driver.findElement(By.id("signin-message")).getText(), is("Username esistente"));
  }
  @Test
  public void registrazioneUsernameMancante() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-password")).click();
    driver.findElement(By.id("signin-password")).sendKeys("a1234");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("a1234");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("test@test.it");
    driver.findElement(By.id("signin-submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@signin-message,\'\')]"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneUsernameNonValido() {
    driver.get("http://localhost:8080/shodan_maven/");
    driver.manage().window().setSize(new Dimension(1900, 1020));
    driver.findElement(By.id("flip-login-card")).click();
    driver.findElement(By.id("signin-username")).click();
    driver.findElement(By.id("signin-username")).sendKeys("a");
    driver.findElement(By.id("signin-password")).click();
    driver.findElement(By.id("signin-password")).sendKeys("1234a");
    driver.findElement(By.id("signin-password-again")).click();
    driver.findElement(By.id("signin-password-again")).sendKeys("1234a");
    driver.findElement(By.id("signin-email")).click();
    driver.findElement(By.id("signin-email")).sendKeys("antonio@shodan.it");
    driver.findElement(By.id("signin-submit")).click();
    assertThat(driver.findElement(By.id("signin-message")).getText(), is("Formato username non valido"));
  }
}