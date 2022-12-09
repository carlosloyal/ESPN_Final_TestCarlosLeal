package mobileTest.Mobile.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;


public class AddPlansScreen extends BaseScreen {

    @AndroidFindBy(id = "actionSheetItemText")
    private List<AndroidElement> addPlansOptions;


    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public boolean checkDiningAvailabilityDisplayed() {
        List<Boolean> isCheckDiningAvailabilityOption = new ArrayList<>();
        super.waitForVisibilityOfAll(this.addPlansOptions);
        this.addPlansOptions.stream().forEach(element -> {
            isCheckDiningAvailabilityOption.add(element.getText().equals("Check Dining Availability"));
        });
        return isCheckDiningAvailabilityOption.contains(true);
    }
}
