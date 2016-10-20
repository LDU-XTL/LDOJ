<%@page import="constant.Constant"%>
<%@page import="servlet.SubHandle"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
       <link href="css/page_1.css" type="text/css" rel="stylesheet"/>
		 <link rel="shortcut icon" href="img/ldu_top_1.ico"/>
		<title>Submit</title>
    
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
				<div class="s_body">
					<form action="servlet/SubHandle" method="get">
						<h1 class="s_h1">Submit your Code</h1>
						<br /><br />
						<div class="s_body_1">
							<font class="s_span_f" >ProblemID:</font>
							<input type="text" name="Problem_id"  width="100px" size="7" value=<%=Constant.p_id %> />
							<font class="s_span_f">language:</font>
							<select name="s_select" id="s1">
								<option value="1">G++</option>
								<option value="2" selected="">GCC</option>
								<option value="3">Java</option>
								<option value="4">Pascal</option>
								<option value="5">C++</option>
								<option value="6">C</option>
								<option value="7">Fortran</option>
							</select>
							</div>
							<div class="s_body_2">
								<textarea name="s_txt" class="s_t" id="s" style="width: 660px; height: 370px;" ></textarea>
							</div>
							<div class="s_body_3">
							<input type="submit" value="Submit" class="p_sub"/>
							<input type="reset" value="Reset" class="p_sub"/>
							</div>
					</form>
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
