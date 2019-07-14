<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add product</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div align="center">
		<h2>Add new product</h2>
		<s:form action="addAction" class="formTable">
			<s:textfield name="productId" label="Product ID" class="formTextField" />
			<s:textfield name="productName" label="Product Name" class="formTextField" />
			<s:textfield name="productCategory" label="Product Category" class="formTextField" />
			<s:textfield name="productPrice" label="Product Price" class="formTextField" />
			<s:submit value="Add product" class="actionBtn" />
		</s:form>
	</div>
</body>
</html>