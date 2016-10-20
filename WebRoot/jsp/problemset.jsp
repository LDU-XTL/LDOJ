<%@page import="constant.Constant"%>
<%@page import="server.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.text.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  	<link rel="stylesheet" href="css/page_1.css"  type="text/css" rel="stylesheet"/>
		<title>Problem set</title>
     <link rel="shortcut icon" href="img/ldu_top_1.ico"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="contain">
			<div class="top">
   			<div class="top_1">
   			<img alt="lduacm" src="img/ldu_top_3.jpg"width="70%" height="100%">
   			<img alt="lduacm" src="img/ldu_top_2.jpg" width="20%" height="100%" id="img_top_1">
   			</div>
   			<ul class="u_top_1">
   				<li>Recent Contest</li>
   				<li>ProblemSet</li>
   				<li>Problems</li>
   				<li>Rank</li>
   				<li>Blogs</li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="http://codeforces.com/" target="_blank">CodeForce</a></li>
   				<li><a href="http://bestcoder.hdu.edu.cn/" target="_blank">BestCoder</a></li>
   				<li><a href="https://icpc.baylor.edu/" target="_blank">ACM ICPC</a></li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="jsp/problemset.jsp">Problems</a></li>
   				<li><a href="jsp/first_page.jsp">Online Status</a></li>
   				<li><a href="jsp/submit.jsp">Submit Problem</a></li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="">Freshman Contest</a></li>
   				<li><a href="">Region</a></li>
   				<li><a href="">Common Contest</a></li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="">Common Contest</a></li>
   				<li><a href="">Region</a></li>
   				<li><a href="">Total Rank</a></li>
   			</ul>
   			<ul class="u_top_2">
   				<li><a href="http://blog.csdn.net/kavu1" target="_blank">Tommy</a></li>
   				<li><a href="http://blog.csdn.net/llwwlql" target="_blank">L-75</a></li>
   				<li><a href="http://blog.csdn.net/LDUTYK" target="_blank">ldutyk</a></li>
   			</ul>
   		</div> 
			<div class="body">
			<%
				ResultSet rs=null,rs1=null;
				String max_page="31";///题目最大页面数
				String p=request.getParameter("page");
				int p_g;
				if(p==null)
				Constant.page=1;
				else
				{
					p_g=Integer.parseInt(p);
					Constant.page=p_g;	
				}	
				//out.print(String.valueOf(Constant.page)+" "+String.valueOf(p_g));
			 %>
			 <p class="ps_page">
			 	<font size="3">
			 		<%
			 			int i=0;
			 			for(i=1;i<=Integer.parseInt(max_page);i++)
			 			{
			 		 %>
			 		 	<a href="jsp/problemset.jsp?page=<%=i %>" name="ps_pg"><%=i %></a>
			 		 <%
			 		 	}
			 		 %>
			 	</font>
			 </p>
			 <%
			 ///查找当前页面的题目总数（100条）
			 	String sql1="select * from problem where p_page='"+Constant.page+"'";
			 	rs=SqlConnect.find(sql1);
			 	String sql2="select p_ac,p_sub from problem where p_page='"+Constant.page+"'";
			 	ResultSet rs2=null;
			 	rs2=SqlConnect.find(sql2);
			 	int index=(Constant.page-1)*100+1000;
			 	while(rs2.next())
			 	{
			 		ResultSet rs_sub=null;
			 		int sub=0;
			 		double radio=0;
			 		String s1="select p_sub from problem where p_id='"+index+"'";
			 		rs_sub=SqlConnect.find(s1);  ///查找当前的题目id的提交数
			 		if(rs_sub.next())
			 			sub=rs_sub.getInt("p_sub");
			 			if(sub!=0)
			 			{   ///计算提交率
				 			radio=rs2.getInt("p_ac")*100.0/rs2.getInt("p_sub");
				 		}
				 		else 
				 		{  ///如果提交数为0，radio设为0
				 			radio=0.0;
				 		}
			 		//
			 		DecimalFormat df = new DecimalFormat("0.00"); 
			 		String upsql="update problem set p_rd='"+df.format(radio)+"' where p_id='"+index+"'";
			 		SqlConnect.add(upsql);
			 		index++;
			 	}
			 	
			  %>
			 <table class="rank_table" style="width:100%;">
 					<tr class="ps_top1" style="width: 100%;">
 						<td width="10%" height="15">Pid</td>
 						<td width="50%" height="22">Title</td>
 						<td width="10%" height="22">Tags</td>
 						<td width="15%" height="22">Radio</td>
 						<td width="15%" height="22">Accepted/Submit</td>
 					</tr>
			 <%
			 int flag=1;
 					  while(rs.next() && flag<=100){
 					  if(flag%2==1)
 					  {
 					 %>
 					<tr class="ps_top2" style="width: 100%; height: 22px;">
 						<td width="10%"><%=rs.getInt("p_id") %></td>
 						<td width="50%"><a href="jsp/problem.jsp?pid=<%=index+flag %>" name="pname"><%=rs.getString("p_name") %></a></td>
 						<td width="10%" ></td>
 						<td width="15%" ><%=rs.getDouble("p_rd") %>%</td>
 						<td width="15%" ><%=rs.getInt("p_ac")%>/<%=rs.getInt("p_sub")%></td>
 					</tr>	
 					<%
 					 }
 					 else{
 					 %>
 					 <tr class="ps_top2" style="width: 100%; height: 22px;">
 						<td width="10%" bgcolor="#9db4dd"><%=rs.getInt("p_id") %></td>
 						<td width="50%" bgcolor="#9db4dd"><a href="jsp/problem.jsp?pid=<%=index+flag %>" name="pname"><%=rs.getString("p_name") %></a></td>
 						<td width="10%" bgcolor="#9db4dd"></td>
 						<td width="15%" bgcolor="#9db4dd"><%=rs.getDouble("p_rd")%>%</td>
 						<td width="15%" bgcolor="#9db4dd"><%=rs.getInt("p_ac")%>/<%=rs.getInt("p_sub")%></td>
 					</tr>	
 					 <%
 					 }
 					 flag++;
 					}
 					 %>
 					 </table>
				<div class="ps_t">
				</div>
			</div>
			<div class="foot">
					<span class="f1">LuDong Unversity ACM</span>
<br />
   			<span class="f2">Copyright@2012-2016 LDU ACM Team. All Rights Reserved.</span>
			</div>
		</div>
  </body>
</html>
