<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="img/favicon.ico">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Система контроля закупок</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="css/jumbotron.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">Система контроля закупок</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <form class="navbar-form navbar-right" action="${pageContext.servletContext.contextPath}/login" method="POST">
        <div class="form-group">
          <input type="text" placeholder="Login" class="form-control" name="login">
        </div>
        <div class="form-group">
          <input type="password" placeholder="Password" class="form-control" name="password">
        </div>
        <button type="submit" class="btn btn-success">Войти</button>
      </form>
    </div><!--/.navbar-collapse -->
  </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
  <div class="container">
    <h1>Добро пожаловать!</h1>
    <p>Это демонстрационное приложение по организации закупки товаров.
      </p>
    <p><a class="btn btn-primary btn-lg" href="#" role="button">Подробнее &raquo;</a></p>
  </div>
</div>

<div class="container">
  <!-- Example row of columns -->
  <div class="row">
    <div class="col-md-4">
      <h2>Пользователи</h2>
      <p>Возможность настройки доступа пользователей с разными ролями</p>
      <p><a class="btn btn-default" href="#" role="button">Подробней &raquo;</a></p>
    </div>
    <div class="col-md-4">
      <h2>Товары</h2>
      <p>Управление каталогом товаров с возможностью детального настройки опций</p>
      <p><a class="btn btn-default" href="#" role="button">Подробней &raquo;</a></p>
    </div>
    <div class="col-md-4">
      <h2>Отчётность</h2>
      <p>Предоставление отчётности по списку заказанных товаров различными менеджерами</p>
      <p><a class="btn btn-default" href="#" role="button">Подробней &raquo;</a></p>
    </div>
  </div>

  <hr>

  <footer>
    <p>&copy; 2016 Company, Inc.</p>
  </footer>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="js/ie10-viewport-bug-workaround.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>