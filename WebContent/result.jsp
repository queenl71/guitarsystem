<%@ page language="java" import="java.util.*,com.guitar.servlet.check,com.guitar.beans.Guitar" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="<%=basePath%>">    
    <title>Result</title>
  </head>
  
  <body>
   <h1>查询结果如下:</h1>
    <%
        ArrayList list = (ArrayList)request.getAttribute("info");
        Iterator it = list.iterator();
        
        out.println("<table border=1>");
        out.println("<tr>");
        out.println("<th>编号</th>");
        out.println("<th>价格</th>");
        out.println("<th>型号</th>");
        out.println("<th>种类</th>");
        out.println("<th>背面</th>");
        out.println("<th>前面</th>");
        out.println("<th>制造商</th>");


        out.println("</tr>");
        while(it.hasNext())
        {
            Guitar vo =new Guitar();
            out.println("<tr>");
            out.println("<td>"+ vo.getSerialNumber() +"</td>");
            out.println("<td>"+ vo.getPrice() +"</td>");
            out.println("<td>"+ vo.getModel() +"</td>");
            out.println("<td>"+ vo.getType() +"</td>");    
            out.println("<td>"+ vo.getBackWood() +"</td>");  
            out.println("<td>"+ vo.getTopWood() +"</td>");  
            out.println("<td>"+ vo.getBuilder() +"</td>");    


            out.println("</tr>");
        }
        out.println("</talbe>");
    %>
    <br />
   
    <a href="index.jsp">返回继续查询</a>
  </body>
</html>