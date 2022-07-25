package page;

import control.Button;
import org.openqa.selenium.By;

public class MainPage {
    public Button loginButton = new Button(By.xpath("//img[@src='/Images/design/pagelogin.png']"));
    public Button signUpButton = new Button(By.xpath("//img[@src='/Images/design/pagesignup.png']"));
    public Button settingsButton = new Button(By.xpath("/html/body/form/div[3]/table/tbody/tr[1]/td/div[1]/div/div/div/a[1]"));
}
