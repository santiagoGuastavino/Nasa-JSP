<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>
		<c:out value="${title}" />
	</title>
	<!-- style sheet -->
	<style>
		<%@ include file="/public/css/styles.css" %>
	</style>
	<!-- font awesome CDN -->
	<script src="https://kit.fontawesome.com/47a442944c.js"></script>
	<!-- font family -->
	<link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
	<!-- icon -->
	<link rel="icon" href="https://i.imgur.com/vf5S864.png" />
</head>
