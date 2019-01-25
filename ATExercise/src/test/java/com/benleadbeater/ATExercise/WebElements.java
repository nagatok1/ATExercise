package com.benleadbeater.ATExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebElements {

	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement FormButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement CountryDropDown;

	@FindBy(xpath = "//*[@id=\"nameInput\"]")
	private WebElement EmailInput;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement SelectUK;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement SelectFrance;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement SelectGermany;

	@FindBy(id = "passInput")
	private WebElement InputPass1;

	@FindBy(id = "passInput2")
	private WebElement InputPass2;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement SubmitButton;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement Success;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/p[10]")
	private WebElement PasswordNoMatch;

	public void ClickFormButton() {
		FormButton.click();
	}

	public void SelectCountry(String arg1) {
		CountryDropDown.click();
		if (arg1.equals("United Kingdom")) {
			SelectUK.click();
		} else if (arg1.equals("France")) {
			SelectFrance.click();
		} else if (arg1.equals("Germany")) {
			SelectGermany.click();
		}

	}

	public void EnterEmail(String arg1) {
		EmailInput.sendKeys(arg1);
	}

	public void EnterPass1(String arg1) {
		InputPass1.sendKeys(arg1);
	}

	public void EnterPass2(String arg1) {
		InputPass2.sendKeys(arg1);
		SubmitButton.click();
	}

	public String SuccessCheck() {
		return Success.getText();
	}

	public String PasswordMisMatch() {
		return PasswordNoMatch.getText();
	}

}
