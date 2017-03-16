<%-- 
    Document   : editform
    Created on : 13 Μαρ 2017, 8:25:12 μμ
    Author     : konstantina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditFormJSP Page</title>
    </head>
    <body>
        <%@page import="UserDao.UserDao" %>
        <%@page import="bean.crud_users" %>
        <% String crud_users_id=request.getParameter("crud_users_id"); 
        int integ = Integer.parseInt(crud_users_id);
           crud_users q=UserDao.getUserById(integ);
        %>
        
        
        <a href="viewusers.jsp">View users</a>

<h1>Edit user</h1>
<form action="edituser.jsp" method="post">
    <input type="hidden" name="crud_users_id" value="<%=q.getCrud_users_id()%>">
    <input type="text" name="crud_users_username" value="<%=q.getCrud_users_username()%>" placeholder="User Name"><br>
    <input type="text" name="crud_users_firstname" value="<%=q.getCrud_users_firstname()%>" placeholder="First Name"><br>
    <input type="text" name="crud_users_lastname" value="<%=q.getCrud_users_lastname()%>" placeholder="Last Name"><br>
    <input type="text" name="crud_users_email"  value="<%=q.getCrud_users_email()%>"placeholder="E-mail"><br>
    <input type="submit" value="Save">
    
</form>
    </body>
</html>
