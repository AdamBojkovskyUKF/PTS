package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class Main {
        public static void main(String[] args) {

                // Nacitanie gecko driveru
                System.setProperty("webdriver.gecko.driver",
                                "C:\\Users\\adams\\Documents\\Nitra\\PTS\\pts-2023-2024\\geckodriver-v0.33.0-win64\\geckodriver.exe");
                WebDriver driver = new FirefoxDriver();

                // Otvorenie AIS2
                driver.get("https://ais2.ukf.sk/ais/start.do");

                // Rozsirenie okna
                driver.manage().window().maximize();

                // Cakanie na to aby sa stranka nacitala
                try {
                        Thread.sleep(10000);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                // Odkliknutie Cookies
                WebElement cookies = driver.findElement(By.xpath("//*[@id=\"accept-cookies\"]"));
                cookies.click();

                // Zadanie prihlasovacieho mena
                WebElement meno = driver.findElement(By.xpath(
                                "/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/form/div/div/div/table/tbody/tr[1]/td[2]/input"));
                meno.sendKeys("meno");

                // Zadanie hesla
                WebElement heslo = driver.findElement(By.xpath(
                                "/html/body/div[4]/div/div/div/div/div/div[1]/div[1]/form/div/div/div/table/tbody/tr[2]/td[2]/input"));
                heslo.sendKeys("heslo");

                // Stlacenie tlacidla na prihlasenie
                WebElement prihlasit = driver.findElement(By.xpath("//*[@id=\"login-form-submit-btn\"]"));
                prihlasit.click();

                // Cakanie na to aby sa stranka nacitala
                try {
                        Thread.sleep(10000);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                // Otvorenie rozvrhu
                WebElement rozvrh = driver.findElement(By
                                .xpath("/html/body/app-root/div/div[1]/div[3]/app-body/div[1]/div/app-rozvrh/div/div/button/span[5]"));
                rozvrh.click();

                // Cakanie na to aby sa stranka nacitala
                try {
                        Thread.sleep(10000);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                // Urobenie screenshotu
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Ulozenie screenshotu
                try {
                        FileHandler.copy(screenshot,
                                        new File("C:\\Users\\adams\\Documents\\Nitra\\PTS\\pts-2023-2024\\screenshot.png"));
                } catch (Exception e) {
                        e.printStackTrace();
                }

                // Stlacenie na meno aby sa zobrazila moznost odhlasit
                WebElement mojeMeno = driver
                                .findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/a/span"));
                mojeMeno.click();

                // Stlacenie na potvrdenie odhlasenia
                WebElement odhlasenie = driver
                                .findElement(By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a"));
                odhlasenie.click();

                // Zatvorenie prehliadaca
                driver.quit();
        }
}