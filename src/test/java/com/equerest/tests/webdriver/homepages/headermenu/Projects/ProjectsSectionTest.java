package com.equerest.tests.webdriver.homepages.headermenu.Projects;

import com.equerest.pages.common.MainPage;
import com.equerest.pages.homepages.headermenu.Projects.ProjectsSection;
import com.equerest.pages.homepages.headermenu.TheElementsHeaderMenuAreCheckedClickability;
import com.equerest.tests.webdriver.BaseTest;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Created by Eduard Aliiev on 10/17/16;
 */
@Title("C126 Проверка контролов Хедер меню")
@Description("Проверка кликабельности кнопок 'Хедер' меню на главной странице сайта")
public class ProjectsSectionTest extends BaseTest{
    @Test
    @Title("Проверка кликабельности кнопки 'Проекты'")
    public void projectsSectionButton() {
        MainPage mainPage = new MainPage("https://dev.equerest.com/", driver);
        mainPage.open();

        TheElementsHeaderMenuAreCheckedClickability clickButton = new ProjectsSection(driver);
        clickButton
                .projectsSection()
                .projectsSectionButton();
    }

}
