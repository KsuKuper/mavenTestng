package Steps;

import Pages.LoginPage;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage();

    public void login(String userName, String password) {
        loginPage.openLoginPage();
        loginPage.inputUserName(userName);
        loginPage.inputPassword(password);
        loginPage.clickLogin();
    }
}
