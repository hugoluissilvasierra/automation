package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import page.LoginModal;
import page.MainPage;
import page.MenuSection;
import page.SettingsModal;
import session.Session;

import java.util.Map;

public class MyStepLogin {

    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    MenuSection menuSection= new MenuSection();

    SettingsModal settingsModal = new SettingsModal();

    @Given("la pagina {string} este abierta")
    public void laPaginaEsteAbierta(String url) {
        Session.getInstance().getBrowser().get(url);
    }

    @When("yo quiero realizar el login")
    public void yoQuieroRealizarElLogin(Map<String,String> credential) {
        mainPage.loginButton.click();
        loginModal.emailTxtBox.writeText(credential.get("email"));
        loginModal.pwdTxtBox.writeText(credential.get("password"));
        loginModal.loginButton.click();
    }

    @Then("yo deberia ingresar a la app web")
    public void yoDeberiaIngresarALaAppWeb() {
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR el login fallo");
    }


    @When("yo quiero cambiar mi password")
    public void yoQuieroCambiarMiPassword(Map<String,String> credential) {
        mainPage.settingsButton.click();
        settingsModal.oldPasswordTxtBox.writeText(credential.get("oldpassword"));
        settingsModal.newPasswordTxtBox.writeText(credential.get("newpassword"));
        settingsModal.okButton.click();
    }

    @Then("deberia volver a la pantalla principal de la app web")
    public void deberiaVolverALaPantallaPrincipalDeLaAppWeb() {
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR el login fallo");
    }
}
