package com.guitar.servlet;


import java.io.IOException;  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import model.CheckUser;  
import com.guitar.beans.UserBean;  
  

public class LoginServlet extends HttpServlet {  
	  
    /** 
     *  
     */  
    private static final long serialVersionUID = 7381169134016556647L;  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
            doPost(request,response);  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        //设置HTTP响应的文档类型,此处为Text/html,如果更改为application\msword则设置为word文档格式  
        response.setContentType("text/html");  
        //设置响应所采用的编码方式  
        response.setCharacterEncoding("GB18030");  
        //取得参数username的值  
        String uname=request.getParameter("username");  
        String passwd=request.getParameter("password");  
          
          
        UserBean user=new UserBean();  
        user.setUsername(uname);  
        user.setPassword(passwd);  
        CheckUser cku=new CheckUser();  
        boolean bool=cku.checkUsre(user);  
          
        String forward;  
        if(bool){  
            forward="success.jsp";  
              
        }else{  
            forward="error.jsp";  
        }  
        RequestDispatcher rd=request.getRequestDispatcher(forward);  
        rd.forward(request,response);  
    }  
  
  
}  