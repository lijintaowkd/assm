<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}
        <p>Following files are uploaded successfully.</p>
        <ol>
        <c:forEach items="${product.images}" var="image">
            <img width="100" src="/image/${image.originalFilename}"/>
            ${image.originalFilename}
             <a href="download?filename=${image.originalFilename}">下载</a>
           
        </c:forEach>
        </ol>
    </p>
</div>
</body>
</html>