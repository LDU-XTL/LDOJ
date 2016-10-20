package server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class problem_sql {
	static Server dd=new Server();
	static boolean fx;
	public boolean getfx(){
		return fx;
	}
	public String select(int problem_id) throws SQLException
	{
		ResultSet rs;
		String text=new String();
		String sql ="select * from problem where problem_id='"+problem_id+"';";
		rs=dd.operate(sql, 1);
		if(!rs.next()){
			text="璇ラ鐩笉瀛樺湪锛岃纭繚杈撳叆姝ｇ‘锛�";
			fx=false;
		}else{
			text=rs.getInt("problem_id")+","+rs.getString("problem_title")+","+rs.getInt("accepted")+","+rs.getInt("submitted")+","+rs.getString("page");
			fx=true;
		}
		return text;
	}
	public String insert(int problem_id,String problem_title,int page,String problem_url) throws SQLException
	{
		problem_sql pp=new problem_sql();
		pp.select(problem_id);
		boolean temp=pp.getfx();
		String re = null;
		if(temp){
			re="璇ラ鐩凡缁忓瓨鍦紝璇烽噸鏂拌緭鍏ワ紒";
		}else{
			String sql = "insert into problem(problem_id,problem_title,accepted,submitted,page,problem_url) "
				+ "VALUES('"+problem_id+"','"+problem_title+"','"+0+"','"+0+"','"+page+"','"+problem_url+"');";
			System.out.println(sql);
			dd.operate(sql, 2);
			
		}
		return re;
	}
	public  void Updata(int problem_id,String Result) throws SQLException
	{
			int x=0;
			if(Result.equals("Accepted"))
				x=1;
			String sql = "update problem set accepted=accepted+'"+x+"',"+"submitted=submitted+'"+1+"' where problem_id='"+problem_id+"';";
			dd.operate(sql, 2);	
	}
	public  String delete(int problem_id) throws SQLException
	{
		
		problem_sql uu=new problem_sql();
		String re=null;
		uu.select(problem_id);
		boolean temp=uu.getfx();
		if(!temp){
			re="璇ラ鐩俊鎭笉瀛樺湪锛岃閲嶆柊杈撳叆锛�";
		}else{
			String sql = "delete from problem where problem_id='"+problem_id+"';";
			dd.operate(sql,2);
		}
		return re;
	}
}
