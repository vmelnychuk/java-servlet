<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="icon" type="image/png" href="assets/img/favicon.png" />
</head>
<body>
    <h1>Main page</h1>
    <ul class="menu">
    <%
        Cookie[] cookies = request.getCookies();
        boolean foundCookie = false;
        for(int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("userId-id")) {
                foundCookie = true;
            }
        }
        if (foundCookie) {
    %>
            <li>
                <a href="logout">Log Out</a>
            </li>
    <% } else { %>
        <li>
            <a href="signup.html">Sign Up</a>
        </li>
        <li>
            <a href="signin.html">Sign In</a>
        </li>
    <% } %>
    </ul>
    <h2><a href="hello.html">Hello</a></h2>
    <h2><a href="bye.html">Bye</a></h2>
</body>
</html>