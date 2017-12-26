package ConnectionJavaMysql;





import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.mysql.jdbc.Statement; 
import java.sql.Statement;



public class Tconnect {


	public static void main(String[] args) throws FileNotFoundException  {
		//CSV
		String fileName ="monfichier.csv";
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
	        
	        try {
	            
	            String delimiter = ";";
	            String line = null;
	            StringTokenizer strToken = null;
	            BufferedReader bufferReader;
	            int lineID = 0;
	            int fieldID = 0;
	           
	         //   ArrayList<Cannaux> canals = new ArrayList<Cannaux>();
	        
	            
	            
	//Ouvrir le fichier CSV 
	            bufferReader = new BufferedReader(new FileReader(fileName));
	            List<Cannaux> Cans = new ArrayList<Cannaux>();
	//parcourir les lignes du fichier CSV
	            while ((line = bufferReader.readLine()) != null) {
	                lineID++;
	              	//get next token and store it in the array
                	

            		// read line by line
            		String[] record = null;

	//Parcourir les champs séparés par delimiter
	                strToken = new StringTokenizer(line, delimiter);
	                while (strToken.hasMoreTokens()) {
	              
	            		
	                	Cannaux can = new Cannaux();
	            			can.setTranche(record[0]);
	            			can.setQuart(record[1]);
	            			can.setChainetv(record[2]);
	            			can.setNbre(record[3]);
	            			try {
	            			    int nbree = Integer.parseInt(can.setNbre);
	            			System.out.println("Actual String:"+record[3]);
	            			    System.out.println("Converted to Int:" + nbree);
	            		} catch (NumberFormatException e) {
	            			      //Will Throw exception!
	            			      //do something! anything to handle the exception.
	            			Cans.add(can);
	            		}

	            		System.out.println(Cans);
	            		System.out.println("bye bye ");
	            		
	            		
	            	}	                	
	                    fieldID++;
	                    System.out.println("Ligne " + lineID
	                            + " / champs " + fieldID
	                            + " : " + strToken.nextToken());
	                   
	                
	                fieldID = 0;
	            
	        } catch (IOException ex) {
	         Logger.getLogger(Tconnect.class.getName()).log(Level.SEVERE, null, ex);
	        	//ex.printStackTrace();

	    
	}
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
	//	
	//}{exc.printStackTrace();
//	}

//}

