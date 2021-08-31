<%-- 
    Document   : Home
    Created on : Jul 5, 2021, 5:28:11 PM
    Author     : hoandk
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Time table</title>
    </head>
    <body>
        <h3 style="color: #34b1eb;font-family: sans-serif;">Time Table</h3>
        <div class="nameTextBox"><a>From Date</a><a style="padding-left: 200px;">To Date</a></div>
        <form action="Home" method="post">
            <a class="inputDate"> <input type="date" value="${from}" name="from"> 
                <input style="margin-left: 30px;" type="date" value="${to}" name="to"></a>
            <a class="btn-search"> <input type="submit" value="Search"></a>  <a class="link" href="Add">Add timetable</a> 
        </form>
            <a style="font-family: sans-serif;color:red;">${mess}</a>

        <table class="table" >
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Slot</th>
                    <th>Time</th>
                    <th>Class</th>
                    <th>Teacher</th>
                    <th>Room</th>
                </tr>
            </thead>
            <c:forEach items="${list}" var="c">
            <tbody>
                <tr>
                    <td class="date">${c.date}</td>
                    <td class="slot">${c.slot}</td>
                    <td class="time">${c.time}</td>
                    <td class="class"> <a>${c.className}</a></td>
                    <td class="teacher">${c.name}</td>
                    <td class="room">${c.room}</td>
                </tr>
            </tbody>
            </c:forEach>
        </table>

    </body>
</html>
