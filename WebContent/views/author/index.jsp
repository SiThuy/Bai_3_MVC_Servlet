<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="me" uri="/WEB-INF/template"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<me:bg title="Manager Author">
		<jsp:attribute name="content">
<form class="form-search" method="get"
				action="${pageContext.request.contextPath}/author/search.html">
<input type="search" name="q" placeholder="Searching...">
<button class="btn btn-second">Search</button>
</form>
<div class="page-header">
Manage Author
</div>
<p>
<a class="btn btn-info"
					href="${pageContext.request.contextPath}/author/add.html">Add Author</a>
</p>
<table class="table table-bordered">
<tr>
<th>Id</th>
<th>Name</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach items="${list}" var="o">
<tr>
<td>${o.id}</td>
<td>${o.name}</td>
<td>
<a
							href="${pageContext.request.contextPath}/admin/author/edit.html?id=${o.id}">
<img src="${pageContext.request.contextPath}/images/edit.png" alt="Edit">
</a>
</td>
<td>
<a
							href="${pageContext.request.contextPath}/admin/author/del.html?id=${o.id}">
<img src="${pageContext.request.contextPath}/images/trash.png"
								alt="Delete">
</a>
</td>
</tr>
</c:forEach>
</table>
</jsp:attribute>
	</me:bg>

</body>
</html>