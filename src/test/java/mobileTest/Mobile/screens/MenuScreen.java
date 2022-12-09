package mobileTest.Mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MenuScreen extends BaseScreen {

    @AndroidFindBy (id = "avatarImage")
    private AndroidElement menuBanner;

    @AndroidFindBy (id = "content")
    private List<AndroidElement> menuOptions;

    @AndroidFindBy (uiAutomator = "new UiSelector().resourceIdMatches(\".*content\").text(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalOption;


    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public boolean bannerIsDisplayed() {
        return super.isElementAvailable(this.menuBanner);
    }


    public void scrollToTheScreenEnd() {
        int swipes = 0;
        int maxSwipesAmount = 5;
        while (!this.isPrivacyAndLegalOptionDisplayed() && swipes < maxSwipesAmount) {
            swipeVertical();
            swipes++;
        }
    }


    public boolean isPrivacyAndLegalOptionDisplayed() {
        return super.isElementAvailable(this.privacyAndLegalOption, 5);
    }


    public boolean checkMenuOptions() {
        List<String> expectedOptions = new ArrayList<>();
        List<Boolean> isCorrect = new ArrayList<>();
        Collections.addAll(expectedOptions,
                "My Profile",
                "Property Rules",
                "Cast Compliment",
                "Link to Account",
                "Car Locator",
                "Help",
                "Privacy & Legal"
        );
        super.waitForVisibilityOfAll(this.menuOptions);
        for (int i = 0; i < this.menuOptions.size() ; i++) {
            isCorrect.add(this.menuOptions.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !isCorrect.contains(false);
    }


    public PrivacyAndLegalScreen clickOnPrivacyAndLegalOption() {
        super.click(this.privacyAndLegalOption);
        return new PrivacyAndLegalScreen(getDriver());
    }
}
