package server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class user_sql {
	static Server dd=new Server();
	static boolean fx;
	public boolean getfx(){
		return fx;
	}
	public String select(String User_id) throws SQLException
	{
		ResultSet rs;
		String text=new String();
		String sql ="select * from user where userID='"+User_id+"';";
		rs=dd.operate(sql, 1);
		if(!rs.next()){
			text="该用户不存在，请确保输入正确！";
			fx=false;
		}else{
			text="user_id："+rs.getString("userID")+",user_name："+rs.getString("username")+",nick_name："+rs.getString("nickname")+",soloved："+rs.getInt("soloved")+",submitted："+rs.getInt("submitted");
			fx=true;
		}
		return text;
	}
	public String insert(String user_id,String user_name,String nick_name,String password) throws SQLException
	{
		user_sql uu=new user_sql();
		uu.select(user_id);
		boolean temp=uu.getfx();
		String re = null;
		if(temp){
			re="该用户已经存在，请重新输入！";
		}else{
			String sql = "insert into user(userid,username,nickname,soloved,submitted,password) "
				+ "VALUES('"+user_id+"','"+user_name+"','"+nick_name+"','"+0+"','"+0+"','"+password+"');";
			dd.operate(sql, 2);
			
		}
		return re;
	}
	public  void Updata(String user_id,String Result) throws SQLException
	{
			int x=0;
			if(Result.equals("Accepted"))
				x=1;
			String sql = "update user set soloved=soloved+'"+x+"',"+"submitted=submitted+'"+1+"' where userID='"+user_id+"';";
			dd.operate(sql, 2);	
	}
	public  String delete(String user_id) throws SQLException
	{
		
		user_sql uu=new user_sql();
		String re=null;
		uu.select(user_id);
		boolean text=uu.getfx();
		if(!text){
			re="该汽车编号不存在，请重新输入！";
		}else{
			String sql = "delete from user where userID='"+user_id+"';";
			dd.operate(sql,2);
		}
		return re;
	}
}
