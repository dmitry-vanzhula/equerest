package com.equerest.pages.adminpanel.projectpage;

import com.equerest.pages.adminpanel.ProjectsPage;
import com.equerest.pages.adminpanel.projectpage.projectsections.DescriptionSection;
import com.equerest.pages.adminpanel.projectpage.projectsections.FinanceModelSection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by aBulgakoff on 9/20/16.
 */
public class EditProjectPage extends ProjectsPage {
    protected Actions actions;

    private final String commonSmallEditButton = "//button[@class='edit-btn']";

    /*project's editing finalization buttons*/
    protected final By saveProjectButton = By.cssSelector(".btn.btn-success");
    protected final By cancelProjectEditButton = By.cssSelector(".btn.btn-primary");
    protected final By moveProjectToArchive = By.cssSelector(".btn.btn-warning");

    /*project sections (access level needed for page scroll)*/
    protected final By addNumbersLink = By.xpath("html/body/div[1]/main/div/div/div/section[2]/div[2]/div[2]/div/div[1]/h3/span/a");
    protected final By descriptionEditButton = By.xpath("//*[@id='anchor-full_description']" + commonSmallEditButton);
    protected final By achievementsEditButton = By.xpath("//*[@id='anchor-achievements']" + commonSmallEditButton);
    protected final By financeModelEditButton = By.xpath("//*[@id='anchor-fmodel']" + commonSmallEditButton);
    protected final By editorInputAreaWindows = By.cssSelector(".quick-editor.input-textarea-group");
    protected final By projectSavedAlert = By.xpath("//*[@id='toast-container']//*[text()[contains(.,'Проект сохранен')]]");
    protected final By projectDescriptionTextArea = By.id("anchor-full_description");

    /*left bar's buttons*/
    private final By financeModelEditThruLeftBar = By.xpath("//ul[contains(concat(' ', @class, ' '), ' left-nav ')]//a[normalize-space(.)='Финансовая модель']");

    public EditProjectPage(WebDriver driver) {
        super(driver);
        if (actions == null) {
            actions = new Actions(driver);
        }
    }

    private void scrollToElement(By element) {
        actions.moveToElement(driver.findElement(element)).perform();
    }

    public DescriptionSection editProjectDescription() {
        /*move to the element in the end of page, move to the higher element for correct displaying of needed one*/
        scrollToElement(saveProjectButton);
        scrollToElement(addNumbersLink);
        driver.findElement(descriptionEditButton).click();
        return new DescriptionSection(driver, this);
    }

    public FinanceModelSection editFinanceModel() {
        /*move to the higher element for correct displaying of needed one*/
        scrollToElement(achievementsEditButton);
        driver.findElement(financeModelEditButton).click();
        return new FinanceModelSection(driver, this);
    }

    public EditProjectPage verifyEditWindowNotPresent(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(editorInputAreaWindows)));
        return this;
    }

    public EditProjectPage verifyProjectSavedAlertDisplayed(){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(projectSavedAlert)));
        return this;
    }


    public EditProjectPage assertProjectDescriptionUpdate(String s) {
        Assert.assertTrue(driver.findElement(projectDescriptionTextArea).getText().contains(s));
        return this;
    }
}