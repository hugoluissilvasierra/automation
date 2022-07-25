Feature: ChangePassword

  @Regression
  Scenario: Change password in the app
    Given la pagina principal "http://todo.ly/" este abierta
    When yo quiero realizar el login
      | email    | hugo.test10@hugo.com |
      | password | 789                 |
    Then yo deberia ingresar a la app web
    When yo quiero cambiar mi password
      | oldpassword    | 789 |
      | newpassword | 123 |
    Then deberia volver a la pantalla principal de la app web