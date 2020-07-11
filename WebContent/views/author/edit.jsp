<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="me" uri="/WEB-INF/template"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<me:bg title="Edit Author">
		<jsp:attribute name="content">
<div class="page-header">
Edit author
</div>
<p>
				<a class="btn btn-info"
					href="${pageContext.request.contextPath}/author.html">Back</a>
			</p>
<form method="post" class="form">
<input type="hidden" value="${o.id}">
<div>
<label>Name</label>
<input type="text" name="name" value="${o.name}">
</div>
<div>
<button class="btn btn-primary">Save</button>
</div>
</form>
</jsp:attribute>
	</me:bg>
</body>
</html>