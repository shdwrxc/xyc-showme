<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <style type="text/css">
        div{text-align: center}
    </style>
</head>
<body>
<div>
<h1>Welcome to the here! ${abc}</h1>
</div>
<form id="someForm">
    <div id="clickhere">
        <a href="/first/one">click one!</a>
    </div>
</form>
<script>
    $(document).ready(function () {
        $("a").click(function (event) {
            var origHref = $(this).attr('href');
            event.preventDefault();
            $.post("/first/two", function (data) {
                window.location = origHref + "?msg=" + data;
            });
        });
    });
</script>
</body>
</html>
