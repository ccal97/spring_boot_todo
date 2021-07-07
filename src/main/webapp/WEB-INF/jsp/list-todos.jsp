<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>First Web App</title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<h1>Here is the list of todos:</h1>
			<br>
			<table class="table">
				<caption>Your todos are</caption>
				<thead>
					<th>Description</th>
					<th>Target Date</th>
					<th>IS IT DONE?</th>
					<th>Delete</th>
					<th>Update</th>
				</thead>
				<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td> <!-- campi della classe Todo -->
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a class="btn btn-success" type="button" href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a class="btn btn-warning" type="button" href="/delete-todo?id=${todo.id}">Delete</a></td> <!-- passo id come RequestParam dopo ? -->
					</tr>
				</c:forEach>
					
				</tbody>
			</table>
			<br>
			And you are logged as:  ${name}!
			<br>
			<div><a class="btn" href="/add-todo">Add a Todo</a></div>
		</div>
		
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>