package mobileTest.Mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PrivacyAndLegalScreen extends BaseScreen {

    @AndroidFindBy (id = "txt_element")
    private List<AndroidElement> privacyAndLegalOptions;

    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public boolean checkPrivacyAndLegalOptions() {
        List<String> expectedOptions = new ArrayList<>();
        List<Boolean> isCorrect = new ArrayList<>();
        Collections.addAll(expectedOptions,
                "Privacy Policy",
                "Terms of Use",
                "Supplemental Terms and Conditions",
                "Legal Notices",
                "Property Rules",
                "Electronic Communications Disclosure",
                "Your California Privacy Rights",
                "Do Not Sell My Personal Information",
                "In-App Maps Subject to Google Terms and Conditions",
                "In-App Maps Subject to Google Privacy Policy"
        );
        super.waitForVisibilityOfAll(this.privacyAndLegalOptions);
        for (int i = 0; i < this.privacyAndLegalOptions.size() ; i++) {
            isCorrect.add(this.privacyAndLegalOptions.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !isCorrect.contains(false);
    }
}
