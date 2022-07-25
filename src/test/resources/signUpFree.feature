Feature: SignUpFree

  @Regression
  Scenario: Sign up in the app

    Given la pagina principal "http://todo.ly/" este abierta
    When yo hago el registro de mi usuario
      | fullname  | email     | password | timezone        |
      | Hugo_User_ | _user_hugo@domain.com | pass_hugo_  | tz_hugo_ |
    Then el contenido de Work deberia ser mostrado