import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomacaoGoogle {
    public static void main(String[] args) {
        // @comment@ Configuração do caminho do chromedriver
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe"); // Atualize o caminho.

        // @comment@ Inicializa o WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // @comment@ Acessa o Cloud Leaf
            driver.get("https://cloud-leaf.senior.com.br");

            // @comment@ Inicializa o WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // @comment@ Localiza o campo username e digita o e-mail
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username-input-field")));
            username.sendKeys("admin@luiz-tiesen.com.br");

            // @comment@ Clica no botão 'Próximo'
            WebElement botaoProximo = driver.findElement(By.id("nextBtn")); // Atualize para o ID correto.
            botaoProximo.click();

            // @comment@ Localiza o campo password e digita a senha
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-input-field")));
            password.sendKeys("Senha1!");

            // @comment@ Clica no botão 'Autenticar'
            WebElement botaoAutenticar = driver.findElement(By.id("loginbtn")); // Atualize para o ID correto.
            botaoAutenticar.click();

            // @comment@ Verifica se a autenticação foi bem-sucedida
            boolean autenticacaoBemSucedida = wait.until(ExpectedConditions.urlContains("logo-preview-desktop")); // Atualize com parte da URL pós-login.

            if (autenticacaoBemSucedida) {
                System.out.println("Sucesso: Autenticação realizada com sucesso!");
            } else {
                System.out.println("Erro: Autenticação falhou.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // @comment@ Fecha o navegador
            driver.quit();
        }
    }
}
