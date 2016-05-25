package model;

import java.sql.ResultSet;  
import java.sql.SQLException;  
  
import com.guitar.utils.DBConn;  
import com.guitar.beans.UserBean;  
  

public class CheckUser {

	
    public boolean checkUsre(UserBean user){  
        if(user.username.equals("")||user.username!=null){  
            ResultSet rs=null;  
            DBConn db=new DBConn();  
            rs=db.doSelect("select * from db_user where userName='"+user.getUsername()+"'");  
            try {  
                if(rs.next()){  
                    if(user.password.equals("")||user.password!=null){  
                        rs=db.doSelect("select * from db_user where userPasswd="+user.password);  
                        return true;  
                    }  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
          
        return false;  
          
    }  

    
}
