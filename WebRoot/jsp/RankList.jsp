<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="server.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>RankList</title>
    	<link href="css/page_1.css" type="text/css" rel="stylesheet"/>
		<script type="text/javascript" src="js/page_1.js" ></script>
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
  <%
        int flag=1;
  		ResultSet rs=null;
  		String sql="select * from rank";
  		Server server=new Server();
  		rs=server.operate(sql,1);
   %>
		<div class="contain">
			<div class="top">
				<div class="top_1">
   			<img alt="lduacm" src="img/ldu_top_3.jpg"width="70%" height="100%">
   			<img alt="lduacm" src="img/ldu_top_2.jpg" width="20%" height="100%" id="img_top_1">
   			</div>
   			<ul class="u_top_1">
   				<li>Online Judge</li>
   				<li>Recent Contest</li>
   				<li>Contest Rank</li>
   				<li>Total rank</li>
   				<li>Blogs</li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="http://acm.hdu.edu.cn/" target="_blank">HDU OJ</a></li>
   				<li><a href="http://poj.org/" target="_blank">Peking OJ</a></li>
   				<li><a href="http://vjudge.net/" target="_blank">Virtual Judge</a></li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="http://codeforces.com/" target="_blank">CodeForce</a></li>
   				<li><a href="http://bestcoder.hdu.edu.cn/" target="_blank">BestCoder</a></li>
   				<li><a href="https://icpc.baylor.edu/" target="_blank">ACM ICPC</a></li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="">Freshman Contest</a></li>
   				<li><a href="">Region</a></li>
   				<li><a href="">Common Contest</a></li>
   			</ul>
   			<ul class="u_top_3">
   				<li><a href="">Freshman Contest</a></li>
   				<li><a href="">Region</a></li>
   				<li><a href="">Common Contest</a></li>
   			</ul>
   			<ul class="u_top_2">
   				<li><a href="http://blog.csdn.net/kavu1" target="_blank">Tommy</a></li>
   				<li><a href="http://blog.csdn.net/llwwlql" target="_blank">L-75</a></li>
   				<li><a href="http://blog.csdn.net/LDUTYK" target="_blank">ldutyk</a></li>
   			</ul>
			</div>
			<div class="body">
 				<span class="t1">RankList</span>
 				<table class="rank_table" height="600">
 					<tr class="rank_top1" style="width: 100%; height: 22;">
 						<td width="10%" height="15" >Rank</td>
 						<td width="30%" height="22">Username</td>
 						<td width="10%" height="22">Score</td>
 						<td width="15%" height="22">Solved</td>
 						<td width="35%" height="22">Blog</td>
 					</tr>
 					<%
 					  while(rs.next() && flag<=9){
 					  if(flag%2==1)
 					  {
 					 %>
 					<tr class="rank_top2" style="width: 100%; height: 22px;">
 						<td width="10%" ><%=flag %></td>
 						<td width="30%"><%=rs.getString("Username") %></td>
 						<td width="10%"><%=rs.getString("Score") %></td>
 						<td width="15%" ><%=rs.getString("Solved") %></td>
 						<td width="35%" ><%=rs.getString("Blog") %></td>
 					</tr>	
 					<%
 					 }
 					 else{
 					 %>
 					 <tr class="rank_top2" style="width: 100%; height: 22px;">
 						<td width="10%" bgcolor="aquamarine"><%=flag %></td>
 						<td width="30%" bgcolor="aquamarine"><%=rs.getString("Username") %></td>
 						<td width="10%" bgcolor="aquamarine"><%=rs.getString("Score") %></td>
 						<td width="15%" bgcolor="aquamarine"><%=rs.getString("Solved") %></td>
 						<td width="35%" bgcolor="aquamarine"><%=rs.getString("Blog") %></td>
 					</tr>	
 					 <%
 					 }
 					 flag++;
 					}
 					 %>
 				</table>
 				<br />
			</div>
			<div class="foot">
				<span class="f1">LuDong Unversity ACM</span>
<br />
   			<span class="f2">Copyright@2012-2016 LDU ACM Team. All Rights Reserved.</span>
			</div>
		</div>
	</body>
</html>
