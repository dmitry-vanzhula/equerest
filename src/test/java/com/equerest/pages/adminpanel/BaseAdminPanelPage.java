package com.equerest.pages.adminpanel;

import com.equerest.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by cherleo on 9/19/16.
 */
public class BaseAdminPanelPage extends AbstractPage {

    private By projectsMenuItem = By.xpath("//*[@id='js-navbar-collapse']//*[text()='Проекты']");

    public BaseAdminPanelPage(WebDriver driver){
        super(driver);
    }

    @Step("Go to Projects menu")
    public ProjectsPage navigateToProjectPageViaMenuItem(){
        driver.findElement(projectsMenuItem).click();
        return new ProjectsPage(driver);
    }
}
