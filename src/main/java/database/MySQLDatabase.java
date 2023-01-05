package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLDatabase {
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;	//..for displays result from database	(это результат выполнения запроса)
	private static final String SQL = "DELETE FROM users WHERE id = \"3\"";
		
	/* method executes connecting to data_base */
	public static void Conn() throws ClassNotFoundException, SQLException {
//		Class.forName("org.sqlite.JDBC");	//..drivers registration (?) ..уже лет 10 как не надо))
		Class.forName("com.mysql.jdbc.Driver");
//		conn = DriverManager.getConnection("jdbc:sqlite:rdr2_data_base.s3db", "root", "123"); //...
		conn = DriverManager.getConnection("");
		System.out.println("connect to rdr2_data_base ...complete");
	}
		
	public static void CreateDB() throws ClassNotFoundException, SQLException {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE users23 ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'time' text, 'Moscow Java' text, 'Moscow C++' text, 'Moscow C#' text, 'Moscow Swift' text,  'Moscow Python' text, 'Moscow PHP' text, 'Moscow J_junior' text," + 
		"'Petersburg Java' text, 'Petersburg C++' text, 'Petersburg C#' text, 'Petersburg Swift' text,  'Petersburg Python' text, 'Petersburg PHP' text, 'Petersburg J_junior' text," + 
		"'Minsk Java' text, 'Minsk C++' text, 'Minsk C#' text, 'Minsk Swift' text,  'Minsk Python' text, 'Minsk PHP' text, 'Minsk J_junior' text, 'Moscow r_Java' text, 'Moscow r_C++' text, 'Moscow r_C#' text, 'Moscow r_Swift' text,  'Moscow r_Python' text, 'Moscow r_PHP' text, 'Moscow r_J_junior' text," + 
		"'Petersburg r_Java' text, 'Petersburg r_C++' text, 'Petersburg r_C#' text, 'Petersburg r_Swift' text,  'Petersburg r_Python' text, 'Petersburg r_PHP' text, 'Petersburg r_J_junior' text," + 
		"'Minsk r_Java' text, 'Minsk r_C++' text, 'Minsk r_C#' text, 'Minsk r_Swift' text,  'Minsk r_Python' text, 'Minsk r_PHP' text, 'Minsk r_J_junior' text);");	
   }
		
	public static void WriteDB() throws SQLException {
		statmt = conn.createStatement();
			
			//String s = "insert copy(id,date,name,volume,money) values(5,16,'copy',1500,'sber')";
			String s = "insert itSector(id,date,vacMoscowJavaJun,vacancyMoscowJavaDev) values(5,20230115,10,20)";
			
			   statmt.execute(s);			  
			   System.out.println("writing to rdr2_data_base ...complete");
		}
		
			public static void CloseDB() throws ClassNotFoundException, SQLException
			   {
				conn.close();
				statmt.close();
				
				System.out.println("js2_data_base is closed");
			   }
}
