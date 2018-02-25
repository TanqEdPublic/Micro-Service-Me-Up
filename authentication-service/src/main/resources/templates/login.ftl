<html>
<head>
<link rel="stylesheet" href="css/wro.css"/>
</head>
<body>
	<div class="text-center">
		<p style="font-size: 150px; color: #428bca; font-weight: bold;
				  font-family: Impact; margin-top: 2%""> TanqEd</p>
	</div>
	<div class="container" style="margin-top: 5%" >
		<form role="form" action="login" method="post">
		  <div class="form-group">
		    <label for="username" style="font-weight: bold; font-size: 36px;">Email:</label>
		    <input type="text" class="form-control" id="username" name="username"
				   style="height: 5%; font-size: 36px;"/>
		  </div>
		  <div class="form-group">
		    <label for="password" style="font-weight: bold; font-size: 36px;">Password:</label>
		    <input type="password" class="form-control" id="password" name="password"
                   style="height: 5%; font-size: 36px;"/>
		  </div>
		  <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		  <button type="submit" class="btn btn-primary"
		  		  style="font-size: 36px; width: 200px; height: 80px;">Submit</button>
		</form>
	</div>
	<script src="js/wro.js" type="text/javascript"></script>
</body>
</html>