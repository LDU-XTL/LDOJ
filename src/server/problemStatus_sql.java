package server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class problemStatus_sql {
	static Server dd=new Server();
	static boolean fx;
	public boolean getfx(){
		return fx;
	}
	public String selectall(String sel,String uesr_oj,String user_host) throws SQLException
	{
		
		ResultSet rs;
		String text=new String();
		String sql ="select * from problem_status where uesr_oj='"+uesr_oj+"'and user_host='"+user_host+"';";
		rs=dd.operate(sql, 1);
		text=rs.getInt("Run_Id")+","+rs.getString("user_host")+","+rs.getInt("Problem_id")+","+rs.getString("result")+","+rs.getString("memory")+","+rs.getString("time")+","+rs.getString("language")+","+rs.getString("submit_time")+","+rs.getString("code_url");
		fx=true;
		return text;
	}
	public int selectrun_id(String code_url) throws SQLException
	{	
		ResultSet rs;
		int runid=0;
		String sql="select runid from problemstatus where codeurl='"+code_url+"';";
		rs=dd.operate(sql, 1);
		if(rs.next())
			runid=rs.getInt("runid");
		return runid;
	}
	public void insert(String user_host,String user_oj,int Problem_id,String result,String memory,String time,String language,String codelength,String submit_time,String code_url) throws SQLException
	{
		String sql = "insert into problemstatus(Username,Submitid,Problem_id,Result,memory,time,language,codelength,submittime,codeurl) "
				+ "VALUES('"+user_host+"','"+user_oj+"','"+Problem_id+"','"+result+"','"+memory+"','"+time+"','"+language+"','"+codelength+"','"+submit_time+"','"+code_url+"');";
		dd.operate(sql, 2);
	}
	public  void Updata(int run_id,String result,String memory,String time,String codeLength) throws SQLException
	{
			String sql = "update problemstatus set result='"+result+"',"+"memory='"+memory+"',"+"CodeLength='"+codeLength+"',"+"time='"+time+"' where runid='"+run_id+"';";
			dd.operate(sql, 2);	
	}
}
