package StepDefinitions;

import Functions.SeleniumFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class MyStepdefsESPN {
    // create an instance structure
    SeleniumFunctions functions = new SeleniumFunctions();


    @Given("^I open up the page ESPN$")
    public void iOpenUpThePageESPN() throws IOException {

        functions.navigateTo("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
        functions.attachScreenShot();

    }

    @When("^I open the modal to login$")
    public void iOpenTheModalToLogin() throws Exception {

        functions.iLoadTheDOMInformation("ESPN.json");
        functions.iClicInElement("Icon User");
        functions.attachScreenShot();
        functions.iClicInElement("Login Icon");
        functions.attachScreenShot();
        functions.switchToFrame("Iframe");
    }

    @Then("^I see the web elements mentioned$")
    public void iSeeTheWebElementsMentioned() throws Exception {
        functions.checkIfElementIsPresent("Login Logo");
        functions.checkIfElementIsPresent("Login Buttom");
        functions.checkIfElementIsPresent("Sing up Buttom");


    }

    @Given("I am logged in")
    public void iAmLoggedIn() throws Exception {

        functions.iSetElementWithKeyValue("Username", "Email");
        functions.iSetElementWithKeyValue("Password", "Password");
        functions.iClicInElement("Login Buttom");
        functions.switchToParentFrame();

    }

    @When("I go to Watch")
    public void iGoToWatch() throws Exception {
        functions.iWaitTime(5);
        functions.iClicInElement("Watch");
    }

    @Then("I validate that at least one carousel is present")
    public void iValidateThatAtLeastOneCarouselIsPresent() throws Exception {
        functions.checkIfElementIsPresent("Carousel");
    }

    @And("Each target has a title and a small description about streaming source")
    public void eachTargetHasATitleAndASmallDescriptionAboutStreamingSource() throws Exception {
        functions.checkIfElementIsPresent("Carousel Tittle");
        functions.checkIfElementIsPresent("Carousel Description");

    }

    @Given("I am in the watch site")
    public void iAmInTheWatchSite() {

    }

    @When("I click on the second card in the first carousel")
    public void iClickOnTheSecondCardInTheFirstCarousel() throws Exception {
        functions.iClicInElement("Second Target");
    }

    @Then("I validate that \\(x) is present on the page, and closes the card")
    public void iValidateThatXIsPresentOnThePageAndClosesTheCard() throws Exception {
        functions.iWaitTime(5);
        functions.checkIfElementIsPresent("Close Button");
        functions.iClicInElement("Close Button");


    }

    @When("I hover the \\(User Icon) element located at the top right corner of the view")
    public void iHoverTheUserIconElementLocatedAtTheTopRightCornerOfTheView() throws Exception {
        functions.iClicInElement("Icon User");
    }

    @Then("I validate that in the sign up modal says Welcome {string}")
    public void iValidateThatInTheSignUpModalSays(String welcomeUser) throws Exception {
        functions.checkPartialTextElementPresent("Welcome User",welcomeUser);

    }

    @And("I log out from current session")
    public void iLogOutFromCurrentSession() throws Exception {
        functions.ClickJSElement("Logout session");
        functions.iWaitTime(5);
    }

    @Then("I validate that in the sign up modal says Welcome! without username")
    public void iValidateThatInTheSignUpModalSaysWelcomeWithoutUsername() throws Exception {
        functions.checkIfElementIsNotPresent("Welcome User");
    }

    @When("I click on the ESPN profile option")
    public void iClickOnTheESPNProfileOption() throws Exception {
        functions.iClicInElement("ESPN Profile");
    }

    @Then("I can deactivate the account")
    public void iCanDeactivateTheAccount() throws Exception {
        functions.switchToFrame("Iframe");
        functions.scrollToElement("Deactivate Account");
        functions.iClicInElement("Deactivate Account");
        functions.iWaitTime(5);
        functions.ClickJSElement("Delete Account Button");

    }

    @And("I validate the check green action when the account is deactivated")
    public void iValidateTheCheckGreenActionWhenTheAccountIsDeactivated() throws Exception {
        functions.iWaitTime(5);
        functions.checkPartialTextElementPresent("Modal Tittle", "Your account has been deleted");
        functions.iClicInElement("Ok Button");
        functions.switchToParentFrame();
        functions.iWaitTime(3);
        
    }

    @Then("I get message from page")
    public void iGetMessageFromPage() throws Exception {
        functions.switchToFrame("Iframe");
        functions.iWaitTime(4);
       functions.checkPartialTextElementPresent("Modal Tittle", "Account Deactivated");

    }
}
