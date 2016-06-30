<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="../../img/favicon.ico">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Система контроля закупок - Редактирование товара</title>

  <!-- Bootstrap -->
  <link href="../../css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="../../css/dashboard.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body>
 <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="/">Система контроля закупок</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Настройки</a></li>
            <li><a href="#">Помощь</a></li>
            <li><a href="#">О проекте</a></li>
          </ul>
          <!--
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
          -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="/app/desktop">Рабочий стол</a></li>
            <li class="active"><a href="/app/goods">Товары</a></li>
            <li><a href="/app/users">Пользователи</a></li>
            <li><a href="/app/report">Отчёт</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Редактирование товара</h1>

            <form class="form-horizontal" action="/app/saveGoods" method="POST" role="form">
                <input type="hidden" id="id" name="id" value = "${id}">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Имя</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Имя" id="name" name="name" value = "${name}" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="depth" class="col-sm-2 control-label">Длина</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" placeholder="Длина" id="depth" name="depth" value = "${depth}" step="0.01">
                    </div>
                </div>
                <div class="form-group">
                    <label for="width" class="col-sm-2 control-label">Ширина</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" placeholder="Ширина" id="width" name="width" value = "${width}" step="0.01">
                    </div>
                </div>
                <div class="form-group">
                    <label for="height" class="col-sm-2 control-label">Высота</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" placeholder="Высота" id="height" name="height" value = "${height}" step="0.01">
                    </div>
                </div>
                <div class="form-group">
                    <label for="weight" class="col-sm-2 control-label">Вес</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" placeholder="Вес" id="weight" name="weight" value = "${weight}" step="0.01">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">
                            <span class="glyphicon glyphicon-floppy-save" style="font-size: 24px;"></span>
                            Сохранить
                        </button>
                        <button type="button" class="btn btn-default" onclick="location.href='/app/users'">
                            <span class="glyphicon glyphicon-remove" style="font-size: 24px;"></span>
                            Отмена
                        </button>
                    </div>
                </div>

            </form>
        </div>
      </div>
    </div>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../js/ie10-viewport-bug-workaround.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>