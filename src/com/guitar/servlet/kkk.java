package com.guitar.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar.beans.Guitar;

/**
 * Servlet implementation class kkk
 */
@WebServlet("/kkk")
public class kkk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public kkk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置输入到Servlet的字符编码格式为utf-8, 这只能post方法有效
        req.setCharacterEncoding("utf-8");
        //设置输出的字符编码格式为utf-8
        resp.setContentType("text/html;charset=utf-8");
        /*
         * 得到前一网页提交的表单数据
         */
        String sqlType = (String)req.getParameter("type");
        String sqlKeyword = (String)req.getParameter("keyword");
        
        
        /*
         * database为数据库链接的字符串,做为数据库链接的一个参数
         */
        String database ="jdbc:odbc:/Users/user/Documents/workspace/guitars/WebContent/database/GuitarData.db";
        /*
         * 定义一个字符串变量,用来存储数据库查询的命令语句
         */
        String sqlCmd ="select * from Guitar where "+ sqlType +"="+"\""+ sqlKeyword +"\"";
        Connection conn =null;
        Statement stmt =null;
        ResultSet rs =null;
        ArrayList list =new ArrayList();        
        
        try
        {
            /*
             * 导入mysql的jdbc驱动
             * 但是首先要确认此WEB项目已经导放此jar包
             */
            Class.forName("org.sqlite.JDBC").newInstance();
            /*
             * 进行数据库的链接
             */
            conn = DriverManager.getConnection(database);
            /*
             * 创建一个Statement对象,用来执行数据库查询的语句
             */
            stmt = conn.createStatement();
            /*
             * 执行一条查询语句, 并将结果返回给ResultSet
             */
            rs = stmt.executeQuery(sqlCmd);
            
            /*
             * 判断到没有执行查询
             */
            if(stmt.execute(sqlCmd))
            {
                /*
                 * 如果执行了查询, 将结果返回给rs
                 */
                rs = stmt.getResultSet();
                /*
                 * while循环用来判断rs中是否还有数据
                 */
                while(rs.next())
                {
                    /*
                     * 用一个javabean来接收并存储结果
                     */
                    Guitar vo =new Guitar();
                    /*
                     * 将rs中的数据以相应的格式提取出来
                     * 并将其结果存储在 javabean的新对象中
                     */
                    vo.setSerialNumber(rs.getString("serialNumber"));
                    vo.setPrice(rs.getString("price"));
                    vo.setModel(rs.getString("model"));
                    vo.setType(rs.getString("type"));
                    vo.setBackWood(rs.getString("backWood"));
                    vo.setTopWood(rs.getString("topWood"));
                    vo.setBuilder(rs.getString("builder"));
                    /*
                     * 将存储有结果的javabean放到list中
                     */
                    list.add(vo);                    
                }            
            }            
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(rs !=null)
            {
                try
                {
                    rs.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(stmt !=null)
            {
                try
                {
                    stmt.close();
                }
                catch(SQLException e)                
                {
                    e.printStackTrace();
                }
            }
        }        
        
        /*
         * 将list设置后准备传递给下一页面
         */
        req.setAttribute("info",list);
        /*
         * 定义一个页面转向的对象
         */
        RequestDispatcher rd=null;
        /*
         * 判断list是否为空
         */
        if(list.isEmpty())
        {
            /*
             * 如果list为空, 就转向错误页面
             */
             rd = req.getRequestDispatcher("error.jsp");
        }
        else
        {
            /*
             * 如果list不为空, 就转向显示结果的页面
             */
             rd = req.getRequestDispatcher("result.jsp");
        }
        /*
         * 实现转向
         */
        rd.forward(req,resp);
                
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
