package runner;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import page.LoginModal;
import page.MainPage;
import page.MenuSection;
import page.SignUpModal;
import session.Session;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.Map;


public class SignUpFree {

    MainPage mainPage = new MainPage();
    SignUpModal signUpModal = new SignUpModal();
    MenuSection menuSection= new MenuSection();

    @Given("la pagina principal {string} este abierta")
    public void laPaginaPrincipalEsteAbierta(String url) {
        Session.getInstance().getBrowser().get(url);
    }

    @When("yo hago el registro de mi usuario")
    public void yoHagoElRegistroDeMiUsuario(SignUpFreeDto signUpFreeDto) {

        /*
        System.out.println("FullName: " + signUpFreeDto.getFullName());
        System.out.println("Email: " + signUpFreeDto.getEmail());
        System.out.println("Password: " + signUpFreeDto.getPassword());
        System.out.println("TimeZone: " + signUpFreeDto.getTimeZone());
        */

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        String datoVariante = dtf.format(now);

        this.mainPage.signUpButton.click();
        this.signUpModal.fullNameTxtBox.writeText(signUpFreeDto.getFullName() + datoVariante);
        this.signUpModal.emailTxtBox.writeText(datoVariante + signUpFreeDto.getEmail());
        this.signUpModal.pwdTxtBox.writeText(signUpFreeDto.getPassword() + datoVariante);
        this.signUpModal.checkZoneCheck.click();
        this.signUpModal.signUpButton.click();

    }

    @Then("el contenido de Work deberia ser mostrado")
    public void elContenidoDeWorkDeberiaSerMostrado() {
        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR el SignUp fallo");
    }

    @DataTableType
    public SignUpFreeDto convert(Map<String,String> entity){
        SignUpFreeDto signUpFreeDto= new SignUpFreeDto();
        signUpFreeDto.setFullName(entity.get("fullname"))
                .setEmail(entity.get("email"))
                .setPassword(entity.get("password"))
                .setTimeZone(entity.get("timezone"));
        return signUpFreeDto;
    }
}
