<%--
  Created by IntelliJ IDEA.
  User: Light
  Date: 07.01.2018
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowBooks</title>
</head>
<body>
    <jsp:useBean id="listResults" class="java.util.ArrayList" scope="request"/>
    <table>
        <tbody>
    <c:forEach items="${books}" var="book">
        <td align="left">${book.name}</td>
        <td align="left">${book.price}</td>
    </c:forEach>
        </tbody>
    </table>
<div>
    <h1>Books</h1>
</div>
</body>
</html>
