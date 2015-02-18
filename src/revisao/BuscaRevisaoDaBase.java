/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisao;

import java.text.ParseException;
import com.thoughtworks.selenium.Selenium;
import java.io.File;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.sql.SQLException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author f7057419
 */

public class BuscaRevisaoDaBase {
    /**
     * @param args the command line arguments
     */
    private final String usuario;
    private final String senha;

    public BuscaRevisaoDaBase(String usuario, String senha) {
        this.usuario = usuario.toUpperCase();
        this.senha = senha;
    }
    @SuppressWarnings({"null", "empty-statement"})
    public void capturaInfos() throws IOException, InterruptedException, ParseException, SQLException {

        //CONFIGURAR PROXY
        Proxy proxy = new Proxy();

        proxy.setProxyAutoconfigUrl("http://intranet.bb.com.br/firefox_proxy.pac");
   //     proxy.setProxyAutoconfigUrl ("https://intranet.bb.com.br/csr/APPS/index");
        
        
        proxy.setSocksUsername(usuario);
        proxy.setSocksPassword(senha);

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(CapabilityType.PROXY, proxy);

        //Abre o firefox
        WebDriver driver = new FirefoxDriver(capabilities);
        //String url = "https://cenopservicossp.intranet.bb.com.br";
        //String url = "https://login.intranet.bb.com.br/distAuth/UI/Login";
       // String url = "https://intranet.bb.com.br/chq/APPS/CHQInicio.do";

        
        String url = "https://intranet.bb.com.br/chq/APPS/img.listarCheques.do?comando=enviarInicio&tipoBusca=BB";
        
        
        
        driver.get(url);
        Selenium selenium = new WebDriverBackedSelenium(driver, url);
    //    selenium.open(url);

        //PROCURAR OS ELEMENTOS PARA ENTRAR NO PORTAL
        // WebElement userName = driver.findElement(By.name("username"));
        // WebElement passWord = driver.findElement(By.name("senha"));
        // WebElement codigo = driver.findElement(By.id("captcha"));
        //PROCURAR OS ELEMENTOS PARA ENTRAR NA INTRANET
        
  //      driver.get(baseUrl + "/distAuth/UI/Login");
//    driver.findElement(By.id("IDToken1")).clear();
//    driver.findElement(By.id("IDToken1")).sendKeys("f4114509");
//    driver.findElement(By.id("IDToken2")).clear();
//    driver.findElement(By.id("IDToken2")).sendKeys("45124513");
//    driver.findElement(By.id("entrar")).click();
        
        WebElement userName = driver.findElement(By.id("chave"));
        WebElement passWord = driver.findElement(By.id("senha"));
        WebElement entrar = driver.findElement(By.id("entrar"));
        
        
//    driver.findElement(By.xpath("(//a[contains(text(),'Aplicativos')])[2]")).click();
 //   driver.findElement(By.linkText("CSR - Controle Sua Remessa")).click();
//    driver.findElement(By.id("chave")).clear();
//    driver.findElement(By.id("chave")).sendKeys("f4114509");
//    driver.findElement(By.id("senha")).clear();
//    driver.findElement(By.id("senha")).sendKeys("45124513");
//    driver.findElement(By.id("entrar")).click();
//    driver.findElement(By.id("entrar")).click();
//    driver.findElement(By.id("mainPage:closeAvisoConferencia")).click();
//    driver.findElement(By.id("j_id15:j_id47:anchor")).click();
//        
        
        
        
        
        
        
       

        userName.sendKeys(usuario);
        passWord.sendKeys(senha);
        
        //intranet apoio, aplicativos, csr - consulta sua remessa, consultas, cheques compensados
        entrar.click();
   //     Thread.sleep(60000);
//        
//        // colocar exceção mensagem 
//        if (agora.after(vencimento)) {
//         System.out.println("Calculando multa...");
//         } else {
//         System.out.println("Sem multa");
//         }
//        //
//        
        
  //https://intranet.bb.com.br/chq/APPS/CHQInicio.do      
  //https://intranet.bb.com.br/chq/APPS/servlet/br.com.bb.customizacao.servlets.paginas.ServletPaginaInicialIntranet?ctx=https://intranet.bb.com.br/chq/APPS      
        
 //   driver.findElement(By.xpath("(//a[contains(text(),'Aplicativos')])[2]")).click();
//    driver.findElement(By.linkText("Consulta de Cheques")).click();
//    
//    
//    selenium.selectPopUp("");
    
    
    
  //  selenium.selectWindow("");
    
    
    


    

    
    
    
    driver.findElement(By.name("agencia")).click();
    driver.findElement(By.name("agencia")).clear();
    driver.findElement(By.name("agencia")).sendKeys("0768");
    driver.findElement(By.name("conta")).clear();
    driver.findElement(By.name("conta")).sendKeys("9215");
    driver.findElement(By.name("numeroCheque")).clear();
    driver.findElement(By.name("numeroCheque")).sendKeys("854327");
    driver.findElement(By.name("dataInicio")).click();
    driver.findElement(By.name("dataInicio")).clear();
    driver.findElement(By.name("dataInicio")).sendKeys("09/10/2012");
    driver.findElement(By.name("dataFim")).clear();
    driver.findElement(By.name("dataFim")).sendKeys("09/10/2012");
    driver.findElement(By.name("enviar")).click();
    driver.findElement(By.name("tarifa")).click();
    driver.findElement(By.name("visualizar")).click();
   driver.findElement(By.id("cartao"));
   
   File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   FileUtils.copyFile(scrFile,new File("C:\temp\teste.png"));
   
   
   // driver.findElement(By.linkText("Verso")).click();
   // driver.findElement(By.id("cartao")).click();
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        driver.close();
        
        
    }
}
