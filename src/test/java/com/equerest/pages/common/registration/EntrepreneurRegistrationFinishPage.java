package com.equerest.pages.common.registration;

import com.equerest.pages.AbstractPage;
import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Oleg Nesterov on 04.10.2016;
 */
public class EntrepreneurRegistrationFinishPage extends AbstractPage {

    public EntrepreneurRegistrationFinishPage(WebDriver driver) {
        super(driver);
    }

    private final By buttonMyProjectThankYou = By.cssSelector("#thankYouMessage .button.button-white");

    public EditProjectPage navigateToProject(){
        click(buttonMyProjectThankYou);
        return new EditProjectPage(driver);
    }

}
