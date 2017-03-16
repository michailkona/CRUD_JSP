<%-- 
    Document   : adduser
    Created on : 13 ??? 2017, 6:18:39 ??
    Author     : konstantina
--%>
<%@page import="UserDao.UserDao" %>  <!--prosvasi sth vasi-->
<jsp:useBean id="u" class="bean.crud_users"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>    
    
<% 
int i=UserDao.save(u);
if(i>0){
response.sendRedirect("add_user_success.jsp");
}
else{
response.sendRedirect("add_user_error.jsp");
}

%>
