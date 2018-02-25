<html>
<head>
<link rel="stylesheet" href="../css/wro.css"/>
</head>
<body>
	<div class="container">
		<h1 style="font-size: 50px; color: #2a6496;">Please Confirm</h1>

		<p style="font-weight: bold; font-size: 36px;">
			Do you authorize "${authorizationRequest.clientId}" at "${authorizationRequest.redirectUri}" to access your protected resources
			with scope ${authorizationRequest.scope?join(", ")}.
		</p>
		<form id="confirmationForm" name="confirmationForm"
			action="../oauth/authorize" method="post">
			<input name="user_oauth_approval" value="true" type="hidden" />
			<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button class="btn btn-primary" type="submit"
                    style="font-size: 36px; width: 200px; height: 80px;">Approve</button>
		</form>
		<form id="denyForm" name="confirmationForm"
			action="../oauth/authorize" method="post">
			<input name="user_oauth_approval" value="false" type="hidden" />
			<input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button class="btn btn-primary" type="submit"
                    style="font-size: 36px; width: 200px; height: 80px;">Deny</button>
		</form>
	</div>
	<script src="../js/wro.js"	type="text/javascript"></script>
</body>
</html>