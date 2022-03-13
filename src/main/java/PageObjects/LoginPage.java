package PageObjects;

import Controls.Button;
import Controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final String pageRoot = ".login-block";
    private final String emailCss = "#user_session_email";
    private final String passwordCss = "#user_session_password";
    private final String loginBtnCss = "#sign-in";

    public TextBox emailTextBox;
    public TextBox passwordTextBox;
    public Button loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        emailTextBox = new TextBox(driver, By.cssSelector(emailCss));
        passwordTextBox = new TextBox(driver, By.cssSelector(passwordCss));
        loginButton = new Button(driver, By.cssSelector(loginBtnCss));
    }

    public LoginPage login(String userName, String password) {
        emailTextBox.setText(userName);
        passwordTextBox.setText(password);
        loginButton.click();
        return this;
    }

    public LoginPage login() {
        return login(properties.getProperty("email"), properties.getProperty("password"));
    }
}
