<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Login Page</title>
</head>
<body>

<%--<h1> How are you, ${param.name} </h1>--%>
<div class="container">
    <h1> Welcome to the Login Page!</h1>

    <pre>${errorMessage}</pre>
    <form method="post">
        Name : <input type="text" name="name">
        Password : <input type="password" name="password">
        <input type="submit" class="btn btn-success">
    </form>
</div>
</body>
</html>