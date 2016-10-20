<%@page import="code.fileout"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="server.Server"%>
<%@page import="constant.Constant"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
    	/*
    		p_id未获取
    	*/
    	Constant.p_id="1002";
     %>
   		<title>Problem 
   			<%=Constant.p_id %>
   		</title>
		<link href="css/page_1.css" type="text/css" rel="stylesheet"/>
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
				////p_h未修改
				String p_h="Biorhythms";
			 %>
			<h1 class="p_h"><%=p_h %></h1>
			<%
					String pid=request.getParameter("pid");///获取跳转页面的pid
					out.print(pid+"<br>");
					Server server=new Server();
					String sql="select p_url from problem where p_id='"+pid+"'";
					ResultSet rs=null;
					String purl="";
					rs=server.operate(sql,1);
					if(rs.next())
					{
					 	 purl=rs.getString("p_url");
					}
					
					fileout filein=new fileout();
					filein.readTxtFile(purl);
			 %>
			<span class="p_tm">
				Time Limit: <%
					
				 %>
			</span>
			<p class="pst">Problem Description</p>
			</p><div class="ptx" lang="en-US">The most important part of a GSM network is so called Base Transceiver Station (BTS). These transceivers form the areas called cells (this term gave the name to the cellular phone) and every phone connects to the BTS with the strongest signal (in a little simplified view). Of course, BTSes need some attention and technicians need to check their function periodically. 
<br>
<br>ACM technicians faced a very interesting problem recently. Given a set of BTSes to visit, they needed to find the shortest path to visit all of the given points and return back to the central company building. Programmers have spent several months studying this problem but with no results. They were unable to find the solution fast enough. After a long time, one of the programmers found this problem in a conference article. Unfortunately, he found that the problem is so called "Travelling Salesman Problem" and it is very hard to solve. If we have N BTSes to be visited, we can visit them in any order, giving us N! possibilities to examine. The function expressing that number is called factorial and can be computed as a product 1.2.3.4....N. The number is very high even for a relatively small N. 
<br>
<br>The programmers understood they had no chance to solve the problem. But because they have already received the research grant from the government, they needed to continue with their studies and produce at least some results. So they started to study behaviour of the factorial function. 
<br>
<br>For example, they defined the function Z. For any positive integer N, Z(N) is the number of zeros at the end of the decimal form of number N!. They noticed that this function never decreases. If we have two numbers N1 < N2, then Z(N1) <= Z(N2). It is because we can never "lose" any trailing zero by multiplying by any positive number. We can only get new and new zeros. The function Z is very interesting, so we need a computer program that can determine its value efficiently. 
<br>
<br></div>
	<p class="pst">Input</p>
	<div class="ptx" lang="en-US">
		There is a single positive integer T on the first line of input. It stands for the number of numbers to follow. Then there is T lines, each containing exactly one positive integer number N, 1 <= N <= 1000000000. 
	</div>
	<p class="pst">Output</p>
	
	<div class="ptx" lang="en-US">
		For every number N, output a single line containing the single non-negative integer Z(N). 
	</div>
	
	<p class="pst">Sample Input</p>
	
<pre class="sio">6
3
60
100
1024
23456
8735373</pre>
	<p class="pst">Sample Output</p>
	
<pre class="sio">0
14
24
253
5861
2183837
</pre>
<p class="pst">
		<div class="p_body_foot">
							<a href="jsp/submit.jsp" class="p_sub">Submit</a>
							<a href="" class="p_sub">Statistic</a>
							<a href="" class="p_sub">Discuss</a>
							</div>

		</div>
		<div class="foot">
			
		</div>
  </body>
</html>
