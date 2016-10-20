package problem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import server.problemStatus_sql;
/**
*提交处理
*对返回信息进行处理
*/

public class ProblemStatus {
	public String problemStatus(String Str,int Run_id) {
		Pattern p = Pattern.compile("<tr\\s*align(.*?)</tr>",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(Str);
		ArrayList<String> linklist = new ArrayList<String>();
		while (m.find()) {
			String link = m.group();
			linklist.add(link);
		}
		String status = new String();
		status = linklist.get(0);
		
		Pattern p1 = Pattern.compile("<td>(.*?)</td>",
				Pattern.CASE_INSENSITIVE);
		Matcher m1 = p1.matcher(status);
		ArrayList<String> link = new ArrayList<String>();
		while (m1.find()) {
			String l = m1.group();
			link.add(l);
		}
		String codeLength="";
		String result="";
		String memery="";
		String time="";
		codeLength=link.get(7).substring(4, link.get(7).length()-5);
		memery=link.get(4).substring(4, link.get(4).length()-5);
		time=link.get(5).substring(4, link.get(5).length()-5);
		String[] temp= link.get(3).split("<");
		temp=temp[2].split(">", 2);
		result=temp[1];
		problemStatus_sql pp =new problemStatus_sql();
		try {
			pp.Updata(Run_id, result, memery, time,codeLength);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return result;
	}
}
 