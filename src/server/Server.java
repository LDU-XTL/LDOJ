package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Server {
		private static final String DRIVERNAME="com.mysql.jdbc.Driver";
		private static final String URL="jdbc:mysql://localhost:3306/ldoj_test01?useUnicode=true&characterEncoding=utf-8";
		private static final String USER="root",PASSWD="";
		private static Connection conn=null;
		
		static{
			loadDriver();
		}
		private static void loadDriver(){
			try {
				Class.forName(DRIVERNAME);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() throws SQLException{
			if(conn==null){
				conn=DriverManager.getConnection(URL,USER,PASSWD);
			}
			return conn;
		}
		public static void close(){
			try {
				if(conn!=null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public ResultSet operate(String order,int type) throws SQLException {
			//1表示查询，2表示增删改操作
			Connection conn=Server.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=null;
			if(type==1)
			{
				rs=stmt.executeQuery(order);
				return rs;
			}
			else if(type==2){
				if(stmt.executeUpdate(order)!=0)
				{
					return rs;
				}
				return rs;
			}
			return rs;
	}
}