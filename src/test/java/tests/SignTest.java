package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignTest {
    @Test
    public void testFazerLoginNoTaskit() {
        //Passar o caminho onde seu chromedriver.exe instalado
        System.setProperty("webdriver.chrome.driver", "D:\\Area de Trabalho\\Nova pasta\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        //Delimita um tempo especifico para dar tempo para navegador carregar todos os elementos
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //.Get pega o caminho do site
        navegador.get("https://www.mercadolivre.com.br/");
        // Maximiza o tamanho da janela no navegador
        navegador.manage().window().maximize();
        //
        WebElement caixadebusca = navegador.findElement(By.className("nav-search-input"));
        caixadebusca.sendKeys("alicate de pressão");

        WebElement busca = navegador.findElement(By.className("nav-search-btn"));
        busca.click();

        WebElement resultpesquisa = navegador.findElement(By.className("ui-search-item__title"));
        String resut = resultpesquisa.getText().toLowerCase();

        if ( resut.contains("alicate") || resut.contains("pressão") )
        {

            System.out.println("O teste obteve sucesso : " + resut
                    + navegador.getTitle() );

        }
        else
        {
            System.out.println("Erro na pesquisa"
                    + navegador.getTitle());
        }


       // navegador.close();


    }
}