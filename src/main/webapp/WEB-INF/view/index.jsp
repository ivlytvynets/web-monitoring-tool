<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Main page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>URL</th>
        <th>PING</th>
        <th>CODE RESPONSE</th>
        <th>CONTENT SIZE</th>
        <th>status</th>
    </tr>
    <c:forEach var="url" items="${urls}">
        <tr>
            <td>
                <c:out value="${url.id}"/>
            </td>
            <td>
                <c:out value="${url.urlName}"/>
            </td>
            <td>
                <c:out value="${url.ping}"/>
            </td>
            <td>
                <c:out value="${url.codeResponse}"/>
            </td>
            <td>
                <c:out value="${url.contentSize}"/>
            </td>
            <td>
                <c:out value="${url.status}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
