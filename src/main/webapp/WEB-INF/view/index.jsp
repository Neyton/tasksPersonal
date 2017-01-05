<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>Test Project</title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <link href="<c:url value="/resource/css/style.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resource/js/calculate-date.js"/>"></script>
</head>
<body>
<div class="main">
<form action="index">

    <div>Start Date:
    <input type="text" pattern="[A-Za-z]{3} [0-9]{1,2},[0-9]{4}" placeholder="Apr 8,1995" id="inputStart" name="startDate" ></div><br>
    <div>End Date:
    <input type="text" pattern="[A-Za-z]{3} [0-9]{1,2},[0-9]{4}"  placeholder="Apr 8,1995" id="inputEnd" name="endDate"></div><br>

    <div>Performer:
        <select name="perf">
            <option value="All Performers">All Performers</option>
            <c:forEach var="next" items="${performers}">
                <option value="${next}">${next}</option>
            </c:forEach>
        </select></div><br/>

        <div>Time Period:
        <select	 id="selecter">
            <option value=""></option>
            <option value="1">Last Qtr</option>
            <option value="2">Last Mounth</option>
            <option value="3">Last Calendar Year</option>
            <option value="4">Current Year to Date</option>
            <option value="5">Current Qtr to Date</option>
            <option value="6">Current Mounth to Date</option>
        </select></div><br/>
        <input type="submit" name="push" value="Submit">

</form></div><br/>


<c:choose>
    <c:when test="${entityList.size() == 0}" >
        <script type="text/javascript">
            alert("Error: Reports not found");
        </script>
    </c:when>
    <c:when test="${entityList.size() != 0}">
        <table class="table-hover" border="1" >
            <tr>
                <th>Id</th>
                <th>StartDate</th>
                <th>EndDate</th>
                <th>Performer</th>
                <th>Activity</th>
            </tr>
    <c:forEach var="next" items="${entityList}">
        <tr>
            <td >${next.getId()}</td>
            <td >${next.getStart()}</td>
            <td>${next.getEnd()}</td>
            <td >${next.getPerformer()}</td>
            <td >${next.getActivity()}</td>
        </tr>
    </c:forEach>
        </table>
    </c:when>
    </c:choose>
</body>
</html>
