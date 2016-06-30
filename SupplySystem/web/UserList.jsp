<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="../../img/favicon.ico">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <title>Система контроля закупок - Пользователи</title>

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
            <li><a href="/app/goods">Товары</a></li>
            <li class="active"><a href="/app/users">Пользователи</a></li>
            <li><a href="/app/report">Отчёт</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Пользователи</h1>

          <!--<h2 class="sub-header">Section title</h2>-->
            <div class="btn-group">
            <button type="button" class="btn btn-default" id="add">
                <span class="glyphicon glyphicon-plus" style="font-size: 24px;"></span>
                Добавить
            </button>
            <button type="button" class="btn btn-default" id="edit">
                <span class="glyphicon glyphicon-pencil" style="font-size: 24px;"></span>
                Редактировать
            </button>
            <button type="button" class="btn btn-default" id="delete">
                <span class="glyphicon glyphicon-trash" style="font-size: 24px;"></span>
                Удалить
            </button>
            </div>

          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Login</th>
                  <th>Имя</th>
                  <th>Фамилия</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach var="user" items="${userList}">
                  <tr style="cursor: pointer">
                      <td class="id">${user.ID}</td>
                      <td>${user.login}</td>
                      <td>${user.firstName}</td>
                      <td>${user.lastName}</td>
                  </tr>
              </c:forEach>

              </tbody>
            </table>
          </div>
          
        </div>
      </div>
    </div>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../js/ie10-viewport-bug-workaround.js"></script>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="../../js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../js/bootstrap.min.js"></script>

 <script type="text/javascript">

     $(document).ready(function(){

         $("tr").click(function(){
             $("tr").css("background-color","");
             $("tr").removeAttr("checked");
             $(this).attr("checked","");
             $("[checked]").css("background-color","#80DCFF");
         });

         $("#add").click(function(){
             location.href="/app/editUser";
         });

         $("#edit").click(function(){
             selectedID = +$("[checked] .id").text();
             if (selectedID != 0) {
                 location.href="/app/editUser?id="+selectedID;
             }
         });

         $("#delete").click(function(){
             selectedID = +$("[checked] .id").text();
             if (selectedID != 0) {
                 location.href="/app/deleteUser?id="+selectedID;
             }
         });

     });

 </script>

</body>
</html>