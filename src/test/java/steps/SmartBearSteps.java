package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import steps.pages.LogInPage;
import steps.pages.WebOrdersPage;
import utilities.Driver;
import utilities.TableHandler;

import java.util.List;

public class SmartBearSteps {
    WebDriver driver;
    Actions actions;
    LogInPage logInPage;
    WebOrdersPage webOrdersPage;
    List<WebElement> tableRow;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        actions = new Actions(driver);
        logInPage = new LogInPage();
        webOrdersPage = new WebOrdersPage();
    }

    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);
    }

    @When("user enters username as {string}")
    public void user_enters_username_as(String username) {
        logInPage.usernameInput.sendKeys(username);
    }

    @When("user enters password as {string}")
    public void user_enters_password_as(String password) {
        logInPage.passwordInput.sendKeys(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_Login_button() {
        logInPage.loginButton.click();
    }

    @Then("user should see {string} message")
    public void user_should_see_message(String message) {
        Assert.assertEquals(message, logInPage.errorMessage.getText());
    }

    @Then("user should be routed to {string}")
    public void user_should_be_routed_to(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @Then("validate below menu items are displayed")
    public void validate_below_menu_items_are_displayed(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            Assert.assertEquals(webOrdersPage.webOrdersMenu.get(i).getText(), dataTable.asList().get(i));
        }
    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        switch(button){
            case "Check All":
                webOrdersPage.selectAllButton.click();
                break;
            case "Uncheck All":
                webOrdersPage.uncheckAllButton.click();
                break;
            case "Process":
                webOrdersPage.processBtn.click();
                break;
            case "Delete Selected":
                webOrdersPage.deleteSelected.click();
                break;
            default:
                throw new NotFoundException("This button doesn't exist!");
        }
    }

    @Then("all rows should be checked")
    public void all_rows_should_be_checked() {
        for (int i = 0; i < webOrdersPage.checkboxes.size(); i++) {
            Assert.assertTrue(webOrdersPage.checkboxes.get(i).isSelected());
        }
    }



    @Then("all rows should be unchecked")
    public void all_rows_should_be_unchecked() {
        for (int i = 0; i < webOrdersPage.checkboxes.size(); i++) {
            Assert.assertFalse(webOrdersPage.checkboxes.get(i).isSelected());
        }
    }

    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String option) {
        switch(option){
            case "Order":
                webOrdersPage.webOrdersMenu.get(2).click();
                break;
            case "View all orders":
                webOrdersPage.webOrdersMenu.get(0).click();
                break;
            default:
                throw new NotFoundException("This menu option doesn't exist!");
    }
}
    @When("user selects FamilyAlbum as product")
    public void user_selects_as_product() {
        webOrdersPage.productDropDown.click();
        webOrdersPage.productDropDownOptions.get(1).click();
    }

    @When("user enters 2 as quantity")
    public void user_enters_as_quantity() {
        webOrdersPage.quantityInput.sendKeys("2");
    }

    @When("user enters all address information")
    public void user_enters_all_address_information(DataTable dataTable) {
        for (int i = 0; i < dataTable.asList().size(); i++) {
            webOrdersPage.addressInformation.get(i).sendKeys(dataTable.asList().get(i));
        }
    }

    @When("user enters all payment information")
    public void user_enters_all_payment_information() {
        webOrdersPage.typeOfCardRadioButton.get(0).click();
        webOrdersPage.cardNumberInput.sendKeys("5467895437896456");
        webOrdersPage.expirationDateInput.sendKeys("12/25");
    }


    @Then("user should see their order displayed in the table")
    public void user_should_see_their_order_displayed_in_the_table() {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertTrue(tableRow.get(i).isDisplayed());
        }
    }

    @Then("validate all information entered displayed correct with the order")
    public void validate_all_information_entered_displayed_correct_with_the_order(DataTable orderInfo) {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size()-1; i++) {
            Assert.assertEquals(orderInfo.asList().get(i), tableRow.get(i).getText());
        }
    }

    @Then("validate all orders are deleted from the {string}")
    public void validate_all_orders_are_deleted_from_the(String string) {
        tableRow = TableHandler.getTableRow(driver, 2);
        for (int i = 0; i < tableRow.size() - 1; i++) {
            Assert.assertFalse(tableRow.get(i).isDisplayed());
        }
    }
    @Then("validate user sees {string} message")
    public void validate_user_sees_message(String message) {
        Assert.assertEquals(message, webOrdersPage.errorMessage.getText());
    }
}
