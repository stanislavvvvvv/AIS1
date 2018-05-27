package es.codeurjc.ais.tictactoe;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import es.codeurjc.ais.tictactoe.WebApp;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SistemasTest {

	WebDriver d1;
	WebDriver d2;
	
	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
		WebApp.start();
	}
	
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}
	
	@Before
	public void setup() {
		d1 = new ChromeDriver();
		d2 = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		if(d1 != null) {
			d1.quit();
		}
		if(d2 != null) {
			d2.quit();
		}
	}
	
	@Test
	public void p1ganaTest() throws InterruptedException {
		d1.get("http://localhost:8080");
		d2.get("http://localhost:8080");
		
		d1.findElement(By.id("nickname")).sendKeys("Jugador 1");
		d1.findElement(By.id("startBtn")).click();
		
		d2.findElement(By.id("nickname")).sendKeys("Jugador 2");
		d2.findElement(By.id("startBtn")).click();
		
		
		d1.findElement(By.id("cell-0")).click();
		d2.findElement(By.id("cell-2")).click();
		d1.findElement(By.id("cell-4")).click();
		d2.findElement(By.id("cell-5")).click();
		d1.findElement(By.id("cell-8")).click();
		
		String s = d1.switchTo().alert().getText();
		String s1 ="Jugador 1 wins! Jugador 2 looses.";
		assertTrue(s.equals(s1));
		
	}
	@Test
	public void p2ganaTest() throws InterruptedException {

		d1.get("http://localhost:8080");
		d2.get("http://localhost:8080");
		
		d1.findElement(By.id("nickname")).sendKeys("Jugador 1");
		d1.findElement(By.id("startBtn")).click();
		
		d2.findElement(By.id("nickname")).sendKeys("Jugador 2");
		d2.findElement(By.id("startBtn")).click();
		
		
		d1.findElement(By.id("cell-0")).click();
		d2.findElement(By.id("cell-2")).click();
		d1.findElement(By.id("cell-4")).click();
		d2.findElement(By.id("cell-5")).click();
		d1.findElement(By.id("cell-7")).click();
		d2.findElement(By.id("cell-8")).click();
		
		String s = d2.switchTo().alert().getText();
		String s1 ="Jugador 2 wins! Jugador 1 looses.";
		assertTrue(s.equals(s1));
	}

	@Test
	public void empateTest() throws InterruptedException {
		d1.get("http://localhost:8080");
		d2.get("http://localhost:8080");
		
		d1.findElement(By.id("nickname")).sendKeys("Jugador 1");
		d1.findElement(By.id("startBtn")).click();
		
		d2.findElement(By.id("nickname")).sendKeys("Jugador 2");
		d2.findElement(By.id("startBtn")).click();
		
		
		d1.findElement(By.id("cell-4")).click();
		d2.findElement(By.id("cell-0")).click();
		d1.findElement(By.id("cell-7")).click();
		d2.findElement(By.id("cell-1")).click();
		d1.findElement(By.id("cell-2")).click();
		d2.findElement(By.id("cell-6")).click();
		d1.findElement(By.id("cell-3")).click();
		d2.findElement(By.id("cell-5")).click();
		d1.findElement(By.id("cell-8")).click();
		
		String s = d1.switchTo().alert().getText();
		String s1 ="Draw!";
		assertTrue(s.equals(s1));
	}

}

