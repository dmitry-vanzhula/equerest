package com.equerest.tests.webdriver.adminpanel.projectpage.moderatesection;

import com.equerest.pages.adminpanel.projectpage.moderatesection.EditProjectPage;
import com.equerest.pages.helpers.adminpanel.EditProjectHelper;
import com.equerest.tests.webdriver.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by cherleo on 9/19/16.
 */
@RunWith(JUnitParamsRunner.class)
public class EditProjectDescriptionTest extends BaseTest {

    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void editProjectDescriptionPositive(String login, String password, String projectName) {
        EditProjectPage selectedProject = new EditProjectHelper(homePage).editProject(login, password, projectName);

        Date date = new java.util.Date();
        String currentDate = new Timestamp(date.getTime()).toString();

        selectedProject.editProjectDescription()
                .editText(currentDate)
                .applyChanges()
                .verifyEditWindowNotPresent()
                .verifyProjectSavedAlertDisplayed()
                .assertProjectDescriptionUpdate(currentDate);

    }

    @Test
    @FileParameters("src/test/resources/login_project_info.csv")
    public void editProjectDescriptionDeclineChanges(String login, String password, String projectName) {
        EditProjectPage selectedProject = new EditProjectHelper(homePage).editProject(login, password, projectName);

        selectedProject.editProjectDescription()
                .editText("Временное описание")
                .discardChanges();
    }
}
