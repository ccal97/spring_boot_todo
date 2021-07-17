<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Add Todo</title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<form:form method="post" modelAttribute="todo"> <!-- binding per Command Bean. dobbiamo aggiungere "todo" nel model -->
				<form:hidden path="id"/>
				<fieldset class="form-group">
					<form:label path="desc">Description:</form:label>
					<form:input path="desc" class="form-control" type="text" required="required"/> <!--validazione client-side con attr. required, ma meglio serverside -->
				</fieldset>
				<button class="btn btn-success" type="submit">Submit</button>
			</form:form>
		</div>
	
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>