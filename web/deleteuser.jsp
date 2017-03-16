<%-- 
    Document   : deleteuser
    Created on : 16 ??? 2017, 8:06:53 ??
    Author     : konstantina
--%>

<%@page import="UserDao.UserDao" %>  <!--prosvasi sth vasi-->
<jsp:useBean id="u" class="bean.crud_users"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>    
    
<% 
int i=UserDao.delete(u);
response.sendRedirect("viewusers.jsp");

%>