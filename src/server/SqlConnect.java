package server;
import java.sql.*;
public class SqlConnect {
        private static  Connection conn = null;
		private static String URL="jdbc:mysql://localhost/ldoj_test01?useUnicode=true&characterEncoding=utf-8";
		static {
			load();
		}
        public static void load()
        {//加载驱动器
        	try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        public static Connection getConnection()throws SQLException
        {
        	//连接数据库
             if(conn==null)
				 conn=DriverManager.getConnection(URL,"root",null);
			
        	return conn;
        }
        public static ResultSet find(String str)throws SQLException
        {
        	//执行有结果集返回SQL语句，如查询
        	SqlConnect.load();
			Connection conn=SqlConnect.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(str);
			return rs;
        }
        public static void add(String sql) throws SQLException
        {   //执行没有结果集返回的SQL语句，如添加，修改和删除
        	SqlConnect.load();
        	Connection conn=SqlConnect.getConnection();
        	PreparedStatement ps=conn.prepareStatement(sql);
        	ps.executeUpdate();
        }
}
