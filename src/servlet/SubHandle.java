package servlet;


import java.io.IOException;
import java.sql.ResultSet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;

import problem.ProblemStatus;
import server.Server;
import server.problemStatus_sql;
import code.fileout;

import com.llwwlql.CodeSubmit;
import com.llwwlql.Login;

import constant.Constant;

public class SubHandle extends HttpServlet {
	private final String[] User_id = { "Fox233", "Fox234", "Fox235" };
	private static int i=0;
	private String user_name="user2";
	private String user_id="2014220";
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			//获取代码
			String str = req.getParameter("s_txt");
			String problem_id=String.valueOf(req.getParameter("Problem_id"));
			System.out.println(problem_id);
			ResultSet rs=null;
			int count=0;
			//SqlConnect.load();
				//SqlConnect.getConnection();
			
			//user_name未改
			String sql="SELECT COUNT(problem_id) as problem_count FROM problemstatus WHERE problem_id="+problem_id+" and username='"+user_name+"';";
			//System.out.println(sql);
			Server server=new Server();
			rs=server.operate(sql,1);
			if(rs.next())
			{
				//结果
				count=rs.getInt("problem_count");
			}
			//user_id未改
			//输出代码到文件，路径需修改
			//String fileName="E:/tomcat/apache-tomcat-7.0.69/"+user_name+"/"+problem_id;
			String fileName = "D:/Test";
			new fileout(str,fileName,count);
			
			i = (i+1)%3;
			Login login = new Login(User_id[i], "lduacm", problem_id);
			String location = login.PostLogin();
			String language=req.getParameter("s_select");
			String file_name=fileName+"/"+String.valueOf(count+1)+".txt";
			CodeSubmit codeSubmit = new CodeSubmit(problem_id,"1");
			codeSubmit.setSource(file_name);
			codeSubmit.Submit(location);
			problemStatus_sql psSql = new problemStatus_sql();
			//用户名user未改
			psSql.insert(user_name,User_id[i], Integer.parseInt(problem_id), "Wating","","",language,"", "2016-10-11 08:19:52",file_name);
			String Url = codeSubmit.getSTATUSUTL() + User_id[i];
			int runid=psSql.selectrun_id(file_name);
			ProblemStatus ps = new ProblemStatus();
			String result = "Waiting";
			while(result.equals("Waiting") || result.equals("Compiling") || result.equals("Running & Judging")){
				Thread.sleep(100);
				result = ps.problemStatus(codeSubmit.GetResult(Url),runid);
			}
			resp.sendRedirect("../jsp/first_page.jsp");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
