package steps.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebOrdersPage extends LogInPage {
    public WebOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "#ctl00_menu li")
    public List<WebElement> webOrdersMenu;
    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    public WebElement selectAllButton;
    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkboxes;
    @FindBy(id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckAllButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropDown;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct option")
    public List<WebElement> productDropDownOptions;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInput;
    @FindBy(xpath = "//ol[2]//input")
    public List <WebElement> addressInformation;
    @FindBy(xpath = "(//tbody/tr)[3]/td")
    public List<WebElement> typeOfCardRadioButton;
    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expirationDateInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBtn;
    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelected;
    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement errorMessage;

}
