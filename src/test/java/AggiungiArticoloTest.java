// Generated by Selenium IDE
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
public class AggiungiArticoloTest {
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
  public void aggiungiArticoloContenutoMancante() {
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
    driver.findElement(By.cssSelector(".role-item:nth-child(3)")).click();
    driver.findElement(By.id("add-article-title")).sendKeys("Titolo");
    driver.findElement(By.id("add-article-shortTitle")).sendKeys("Sottotitolo");
    driver.findElement(By.id("add-article-button")).click();
    assertThat(driver.findElement(By.id("add-article-result")).getText(), is("Contenuto: campo obbligatorio"));
  }
  @Test
  public void aggiungiArticoloSottotitoloMancante() {
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
    driver.findElement(By.cssSelector(".role-item:nth-child(3)")).click();
    driver.findElement(By.id("add-article-title")).sendKeys("Titolo");
    driver.findElement(By.id("article-description")).sendKeys("Contenuto");
    driver.findElement(By.id("add-article-button")).click();
    assertThat(driver.findElement(By.id("add-article-result")).getText(), is("Sottotitolo: campo obbligatorio"));
  }
  @Test
  public void aggiungiArticoloTitoloMancante() {
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
    driver.findElement(By.cssSelector(".role-item:nth-child(3)")).click();
    driver.findElement(By.id("add-article-shortTitle")).click();
    driver.findElement(By.id("add-article-shortTitle")).sendKeys("Sottotitolo");
    driver.findElement(By.id("article-description")).sendKeys("Contenuto");
    driver.findElement(By.id("add-article-button")).click();
    assertThat(driver.findElement(By.id("add-article-result")).getText(), is("Titolo: campo obbligatorio"));
  }
  @Test
  public void aggiungiArticoloOK() {
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
    driver.findElement(By.cssSelector(".role-item:nth-child(3)")).click();
    driver.findElement(By.id("add-article-title")).click();
    driver.findElement(By.id("add-article-title")).sendKeys("Titolo");
    driver.findElement(By.id("add-article-shortTitle")).sendKeys("Sottotitolo");
    driver.findElement(By.id("article-description")).sendKeys("Contenuto");
    driver.findElement(By.id("add-article-button")).click();
    {
      WebElement element = driver.findElement(By.id("add-article-button"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    assertThat(driver.findElement(By.id("add-article-result")).getText(), is("Articolo aggiunto con successo!"));
  }
}
