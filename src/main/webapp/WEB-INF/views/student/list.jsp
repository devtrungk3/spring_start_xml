<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student list</title>
</head>
<body>
	<h1>List student</h1>
	<c:if test="${message != null }"><h2>${message }</h2></c:if>
	<form action="${pageContext.request.contextPath}/student/search" method="get">
		<span>Name</span>
		<input type="text" name="studentName"/>
		<input type="submit" value="Search">
	</form>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Class Room</th>
			<th>Function</th>
		</tr>
		<c:forEach items="${students.getContent() }" var="s">
			<tr>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.age }</td>
				<td>${s.classRoom.className }</td>
				<td style="display: flex">
					<button><a href="${pageContext.request.contextPath}/student/update/${s.id }">Update</a></button>
					<form action="${pageContext.request.contextPath}/student/delete" method="post">
						<input type="hidden" name="id" value="${s.id }"/>
						<button type="submit">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${students.hasPrevious() }">
		<c:if test="${studentName != null }">
			<a href="${pageContext.request.contextPath}/student/search?studentName=${studentName}&page=${currentPage-1}&size=${currentSize}">Previous</a>
		</c:if>
		<c:if test="${studentName == null }">
			<a href="${pageContext.request.contextPath}/student/list?page=${currentPage-1}&size=${currentSize}">Previous</a>
		</c:if>
	</c:if>
	<c:if test="${students.hasNext() }">
		<c:if test="${studentName != null }">
			<a href="${pageContext.request.contextPath}/student/search?studentName=${studentName}&page=${currentPage+1}&size=${currentSize}">Next</a>
		</c:if>
		<c:if test="${studentName == null }">
			<a href="${pageContext.request.contextPath}/student/list?page=${currentPage+1}&size=${currentSize}">Next</a>
		</c:if>
	</c:if>
</body>
</html>