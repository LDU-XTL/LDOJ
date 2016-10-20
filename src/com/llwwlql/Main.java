package com.llwwlql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;

import org.apache.http.client.ClientProtocolException;

import code.fileout;
import server.problemStatus_sql;

public class Main {

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClientProtocolException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws ClientProtocolException,
			IOException, InterruptedException {
//		// TODO Auto-generated method stub
//		String[] User_id={"Fox233","Fox234","Fox235"};
//		CodeSubmit cs = new CodeSubmit("1166","1");
//		for(int i=0;i<1;i++)
//		{
//			Login login= new Login(User_id[(i++)%3],"lduacm","1166");
//			String location = login.PostLogin();
//			String fileName = "C:\\Appliciation\\D_Work\\Code\\Jave\\HDUoj\\1.txt";
//			//cs.setSource(fileName);
//			//cs.Submit(location);
//			problemStatus_sql ps=new problemStatus_sql();
//			//Date d=new Date();
//			//DateFormat df=new DateFormat(d);
//			try {
//				ps.insert("user1",login.getUser_id1(), 1166, "Wating", "", "", "C", "","2016-10-11 08:19:52",fileName);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		new fileout("asdfasdfasdf", "C:\\ldu\\xy", 1);
		
	}
}
