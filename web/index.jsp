<%--
  Created by IntelliJ IDEA.
  User: bogda
  Date: 10-09-2019
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Przelicznik metryczny</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        body {
            margin-left: 200px;
            margin-right: 200px;
        }
    </style>
</head>
<body>
<div>
    <h1>Przelicznik metryczny</h1>
    <div class="form-row">
        <form method="post" action="/distance">
            <div class="form-group">
                <input type="text" class="form-control" name="metre" placeholder="metry">
                <input type="text" class="form-control" name="centimetre" placeholder="centymetry">
                <input type="text" class="form-control" name="millimetre" placeholder="milimetry">
                <input type="submit" value="Przelicz">
            </div>
        </form>
    </div>

    <h1>Przelicznik wag</h1>
    <div class="form-row">
        <form method="post" action="/weight">
            <div class="form-group">
                <input type="text" class="form-control" name="kilogram" placeholder="kilogramy">
                <input type="text" class="form-control" name="gram" placeholder="gramy">
                <input type="text" class="form-control" name="milligram" placeholder="miligramy">
                <input type="submit" formmethod="post" value="Przelicz">
            </div>
        </form>
    </div>

</div>
</body>
</html>
