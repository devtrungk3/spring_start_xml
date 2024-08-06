<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit student</title>
</head>
<body>
	<h1>Edit student</h1>
	<form:form action="${pageContext.request.contextPath}/student/update" method="post" modelAttribute="student">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Classroom</td>
				<td>
					<form:select path="classRoom.id">
						<form:options items="${classRooms }" itemLabel="className" itemValue="id"/>
					</form:select>
				</td>
			</tr>
		</table>
		<button type="submit">Submit</button>
		<button type="reset">Reset</button>
	</form:form>
</body>
</html>