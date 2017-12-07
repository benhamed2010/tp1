package ConnectionJavaMysql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import com.mysql.jdbc.Statement; 
import java.sql.Statement;

public class Tconnect {


	public static void main(String[] args) throws FileNotFoundException  {
		//CSV
		String fileName ="audience.csv";
		File file = new File(fileName);
		
			Scanner in = new Scanner (file);
			while (in.hasNextLine()){
				String line = in.nextLine(); 
				System.out.println(line+"+++++");
			}
			in.close();
			

		// TODO Auto-generated method stub
// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
// System.out.println("Drivers reussi");
// Connection Cn = (Connection) DriverManager.getConnection("jdbc:odbc:MysqlDb","","");
// System.out.println("Connection reussi");
		 String username = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost/db_audience";

	        try {

	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Drivers reussi");
	        Connection con=DriverManager.getConnection(url, username, password);
	        Statement getData=con.createStatement();
	        System.out.println("Connection reussi");
	        ResultSet rs = getData.executeQuery("select * from t_audience");
	        while(rs.next()){
	        	System.out.println(rs.getString(1));
	        	System.out.println(rs.getString(2));
	        	System.out.println(rs.getString(3));
	        	System.out.println(rs.getString(4));
	        }
	        System.out.println("Merci de votre attention....");
	        
	        con.close();

	    }catch(Exception e) {System.out.println(e);}
	        


	    }


	}
//		try{
//1. Get a connection to database
//Tconnect myConn= DriverManager.getConnection("jdbc:Mysql://localhost:3306/audience1","","");

//2. Create a statement
//	Statement myStmt= myConn.createStatement();	
//3.Execute Query
	//ResultSet myRs= myStmt.executeQuery("select * from audiencee");
	
//4. Process the result
//	while (myRs.next()){
	//	System.out.println(myRs.getString("tranche"));
		
	//}
	//	}
		//catch (Exception exc)
	//	{exc.printStackTrace();
	//}
//	}

//}

