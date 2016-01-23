<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Log in</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css"/>
</head>
<body>
<p>You can use: demo@localhost / demo</p>
<div class="login">
<h1>Log in</h1>
	<form role="form" action="/login" method="post">
        <input placeholder="E-mail" type="email" name="email" id="email" required autofocus/>
        <input type="password" name="password" placeholder="Password" id="password" required/>
    	<button class="btn btn-primary btn-block btn-large" type="submit">Sign in</button>
    	<span style="color:white; text-align:center">or</span>
    	<a class="alternativeLink" href="/register">Register</a>
    	
	</form>
</div>

<#if error.isPresent()>
<p>The email or password you have entered is invalid, try again.</p>
</#if>
</body>
</html>