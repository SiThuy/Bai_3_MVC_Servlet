<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib prefix="me" uri="/WEB-INF/template" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<me:bg title="Search">
<jsp:attribute name="content">
   <form class="form-search" method="get" action="${pageContext.request.contextPath}/author/search.html">

          <input type="text" placeholder="Search..." name="q" >
    <button class="btn btn-primary">Search</button>
   </form>
   <div class="page-header">
        Search Result
   </div>
   <div class="products">
          <c:forEach var="o" items="${list}">
    <div class="col-3">
    <div class="item">
         <img alt="${o.title}" src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
     <div class="info">
   <a href="${pageContext.request.contextPath}/author/detail.html?id=${o.id}">${o.title}</a>
    </div>
    </div>
    </div>
          </c:forEach>
    <div class="clear"></div>
    </div>
    </jsp:attribute>
</me:bg>

</body>
</html>