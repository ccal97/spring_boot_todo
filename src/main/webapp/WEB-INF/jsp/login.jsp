<html>
	<head>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			jsp login content
			Hello ${name} !
			
			<form method="post">
				Name: <input type="text" name="name"/>
				Password: <input type="password" name="pwd" />
				<input type="submit" />
			</form>
		</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</body>
</html>