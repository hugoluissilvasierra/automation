package page;


import control.Button;
import control.Check;
import control.TextBox;
import org.openqa.selenium.By;

public class SettingsModal {

    public TextBox oldPasswordTxtBox = new TextBox(By.id("TextPwOld"));
    public TextBox newPasswordTxtBox = new TextBox(By.id("TextPwNew"));
    public Button okButton = new Button(By.xpath("/html/body/div[9]/div[2]/div/button[1]"));

}
