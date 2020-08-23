<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<body>

<h2>Nozol APIs Backend</h2>

<hr>
<div style="margin: 25px" class="bar">
    <h3>Welcome Nozol APIs</h3>
</div>

<h3>Browsing App</h3>
<hr>
<a href="${pageContext.request.contextPath}/auth/usersTypes">Get Users Types</a><br>
<a href="${pageContext.request.contextPath}/auth/users">Get Users</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryType">Get Category Types</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryType/1">Get Categories By Category Types</a><br>
<a href="${pageContext.request.contextPath}/auth/category">Get Categories</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryService">Get Category Services</a><br>
<a href="${pageContext.request.contextPath}/auth/service">Get Services</a><br>
<hr>

</body>
</html>