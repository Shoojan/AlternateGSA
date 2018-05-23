<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Saved</title>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<script>
        window.contextRoot = '${contextRoot}';
    </script>
</head>
<body>
    <h1>
    Data Saved.
   <form:form action="${contextRoot}/" method="get">
     <input type = "submit" name = "action1" value="Return"/>
   </form:form>
   </h1>
</body>
</html>  </div>