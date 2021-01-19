package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class LoginSteps {

    @Given("^User is on landing page$")
    public void user_is_on_landing_page() {
        System.out.println("User is on landing page");
    }

    @When("^User login into application with correct login and correct password$")
    public void user_login_into_application_with_correct_login_and_correct_password() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User login into apllication with correct login and correct password");
    }

    @Then("^Home page is visible$")
    public void home_page_is_visible() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Home page is visible");
    }

    @Then("^Card are displayed$")
    public void card_are_displayed() {
        System.out.println("Card are displayed");
    }

    @When("^User login into application with (.+) login and password (.+)$")
    public void user_login_into_application_with_login_and_password(String username, String password) {
        System.out.println("username = " + password + "password = " + password);
    }

    // te fragmenty kodu można wygenerowac w TidyGherkin po podaniu fragmentu z feature:

    @When("^User sign up into application with the following details$")
    public void user_sign_up_into_application_with_the_following_details(DataTable data) {
        List<List<String>> user = data.raw();
        System.out.println(user.get(0).get(0));
        System.out.println(user.get(0).get(1));
    }

    @When("^User login into application with \"([^\"]*)\" login and \"([^\"]*)\" password$")
    public void userLoginIntoApplicationWithLoginAndPassword(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("username = " + password + "password = " + password);
    }
}
