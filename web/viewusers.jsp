<%-- 
    Document   : viewusers
    Created on : 13 Μαρ 2017, 7:54:08 μμ
    Author     : konstantina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>viewusers Page</title>
    </head>
    <body>
        <a href="index.jsp">Main page</a><br><br>
        <%@page import="UserDao.UserDao" %>
        <%@page import="bean.crud_users" %>
        <%@page import=" java.util.*" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


        <% List<crud_users> crud_users_list = UserDao.getAllRecords();
            request.setAttribute("crud_users_list", crud_users_list);

        %>

        <table>
            <tr>
                <th>Id</th>
                <th>UserName</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Edit</th>
                <th>Delete</th>
                
                    <c:forEach  items="${crud_users_list}" var="u" >
                <tr>
                    <td>${u.getCrud_users_id()}</td>
                    <td>${u.getCrud_users_username()}</td>
                    <td>${u.getCrud_users_firstname()}</td>
                    <td>${u.getCrud_users_lastname()}</td>
                    <td>${u.getCrud_users_email()}</td>
                    <td><a href="editform.jsp?crud_users_id=${u.getCrud_users_id()}">Edit</a></td>
                    <td><a href="deleteuser.jsp?crud_users_id=${u.getCrud_users_id()}">Delete</a></td>
                    
                </tr>
                    
                    </c:forEach>

            </tr>



        </table>
    </body>
</html>
