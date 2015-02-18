package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteRevisaoDaBase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://juridico.intranet.bb.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testERevisaoDaBase() throws Exception {
    driver.get(baseUrl + "/paj/revisaoBase");
    driver.findElement(By.id("Processos")).click();
    driver.findElement(By.id("Revisão da Base")).click();
    driver.findElement(By.linkText("Processo Indicado para Encerramento")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:dataClassificacaoRevisaoDecorate:dataClassificacaoRevisaoInputPopupButton")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:dataClassificacaoRevisaoDecorate:dataClassificacaoRevisaoInputDayCell9")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:btPesquisar")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:dataClassificacaoRevisaoDecorate:dataClassificacaoRevisaoInputPopupButton")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:dataClassificacaoRevisaoDecorate:dataClassificacaoRevisaoInputDayCell8")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:btPesquisar")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:dataTabletableProcessos:j_id471")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:dataTabletableProcessos:j_id471")).click();
    driver.findElement(By.id("pesquisarProcessoRevisaoBaseForm:dataTabletableProcessos:j_id481")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
