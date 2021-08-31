<%-- 
    Document   : Add
    Created on : Jul 5, 2021, 5:28:27 PM
    Author     : hoandk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/add.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adding</title>
    </head>
    <body>
        <div class="container">
            <h3>Add Timetable</h3>
            <a style="color: red; padding-left: 100px;font-family: sans-serif;"> ${mess} </a>
            <form action="Add" method="post">
                <div class="input-even"><a class="text-input">Date</a><input id="day" type="date"  name="date"></div>
                <div class="input-odd"><a class="text-input">Slot</a>
                    <select name="slot">
                        <c:forEach items="${requestScope.listS}" var="s">
                            <option value="${s.slot}">${s.slot}</option>
                        </c:forEach>
                    </select></div>
                <div class="input-even"><a class="text-input">Room</a>
                    <select name="room">
                        <c:forEach items="${requestScope.listR}" var="r">
                            <option value="${r.id}">${r.name}</option>
                        </c:forEach>
                    </select></div>
                <div class="input-odd"><a class="text-input">Teacher</a><input name="teacher" type="text"></div>
                <div class="input-even"><a class="text-input">Class</a>
                    <select name="class">
                        <c:forEach items="${requestScope.listC}" var="c">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select></div>
                <div class="btn-save"><input class="" type="submit" value="save"></div>
            </form>
    </body>
    <script>
        document.getElementById('day').valueAsDate = new Date();
    </script>
</div>
</html>
