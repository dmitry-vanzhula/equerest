package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Mykhaylo Dmytrenko on 26.09.2016.
 */
public class InvestorRegisrationInvestmentsPage extends AbstractPage {
    private By checkbox_agree = By.xpath("//*[@type='checkbox']");
    private By finishReg = By.xpath("//*[text()='Завершить регистрацию']");
    private String radiobuttonPath = "//*[@class='input-radio-group']//*[@for='";
    private String radiobuttonPath2 = "']";

    public InvestorRegisrationInvestmentsPage(WebDriver driver){super(driver);}

    public InvestorRegisrationInvestmentsPage chooseInvestments(String investorRoleID, String investplanID, String dealquanttityID){
        driver.findElement(By.xpath(radiobuttonPath + investorRoleID + radiobuttonPath2)).click();
        driver.findElement(By.xpath(radiobuttonPath + investplanID + radiobuttonPath2)).click();
        driver.findElement(By.xpath(radiobuttonPath + dealquanttityID + radiobuttonPath2)).click();
        return this;
    }

    public InvestorRegisrationInvestmentsPage checkboxAgree(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(checkbox_agree));
        return this;
    }

    public FinishPage finishRegistration(){
        driver.findElement(finishReg).click();
        return new FinishPage(driver);
    }

}
