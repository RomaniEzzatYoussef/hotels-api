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
<a href="${pageContext.request.contextPath}/auth/user/current">Get Current User</a><br>
<a href="${pageContext.request.contextPath}/auth/user/1">Get User By ID</a><br>
<a href="${pageContext.request.contextPath}/auth/usersTypes">Get All Users Types</a><br>
<a href="${pageContext.request.contextPath}/auth/users">Get All Users</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryTypes">Get All Category Types</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryType/1/categories">Get Categories By Category Type</a><br>
<a href="${pageContext.request.contextPath}/auth/category/1">Get Category By ID</a><br>
<a href="${pageContext.request.contextPath}/auth/category/1/categoryServices">Get Category Services By Category ID</a><br>
<a href="${pageContext.request.contextPath}/auth/categories">Get All Categories</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryService/1">Get Category Service By ID</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryServices">Get All Category Services</a><br>
<a href="${pageContext.request.contextPath}/auth/services">Get All Services</a><br>
<a href="${pageContext.request.contextPath}/auth/categoryService/1/services">Get Services By Category Service ID</a><br>
<hr>

</body>
</html>