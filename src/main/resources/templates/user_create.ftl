<#-- @ftlvariable name="form" type="ort.geekstagram_student.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new user</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css"/>
</head>
<body>
<div class="login">
	<h1>Register</h1>
	
	<form role="form" name="form" action="" method="post">
	        <input type="email" name="email" id="email" value="${form.email}" placeholder = "E-mail" required autofocus/>
	        <input name="pseudo" id="pseudo" value="${form.pseudo}" placeholder = "Pseudo" required/>
	        <input type="password" name="password" id="password" placeholder = "Password" required/>
	        <input type="password" name="passwordRepeated" id="passwordRepeated" placeholder = "Repeat Password" required/>
	    	<button class="btn btn-primary btn-block btn-large" type="submit">Register</button>
	        <span style="color:white; text-align:center">or</span>
    		<a class="alternativeLink" href="/login">Login</a>
	</form>
</div>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>