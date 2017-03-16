<%-- 
    Document   : edituser
    Created on : 16 ??? 2017, 7:57:41 ??
    Author     : konstantina
--%>

<%@page import="UserDao.UserDao" %>  <!--prosvasi sth vasi-->
<jsp:useBean id="u" class="bean.crud_users"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>    
    
<% 
int i=UserDao.update(u);
response.sendRedirect("viewusers.jsp");

%>
