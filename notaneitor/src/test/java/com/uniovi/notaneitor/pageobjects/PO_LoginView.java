package com.uniovi.notaneitor.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView {

	static public void fillLoginForm(WebDriver driver, String dnip, String passwordp) {
		WebElement dni = driver.findElement(By.name("username"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnip);
		WebElement password = driver.findElement(By.name("password"));
		password.click();
		password.clear();
		password.sendKeys(passwordp);
		//Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();	
	}

	static public void login(WebDriver driver, String dni, String pass, String text) {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillLoginForm(driver, dni, pass);
		// Comprobamos que entramos en la pagina privada del Profesor
		PO_View.checkElementBy(driver, "text", text);
	}

	static public void logout(WebDriver driver) {
		String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
		PO_PrivateView.clickOption(driver, "logout", "text", loginText);
	}


}
