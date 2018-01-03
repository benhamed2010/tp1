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
import java.sql.PreparedStatement;

import com.mysql.jdbc.Statement; 
//import java.sql.Statement;

//import com.mysql.jdbc.Statement;



public class Tconnect {


	public static void main(String[] args) throws FileNotFoundException  {
		//CSV
		String fileName ="monfichier.csv";
		File file = new File(fileName);
		
		
			Scanner in = new Scanner (file);
			in.next();// ignore la premiere ligne
			

			while (in.hasNextLine()){
				String line = in.nextLine(); 
				
				
				System.out.println(line+"+++++");
			}
			in.close();
			

		 String username = "root";
	        String password = "";
	        String url = "jdbc:mysql://localhost/db_audience";

	       try {

	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.println("Drivers reussi");
	        Connection con=DriverManager.getConnection(url, username, password);
	        Statement getData=(Statement) con.createStatement();
	        System.out.println("Connection reussi");
	        ResultSet rs = getData.executeQuery("select * from t_audience");
	        while(rs.next()){
	        	System.out.println("bonjourrrrrr");
	        	System.out.println(rs.getString(1));
	        	System.out.println(rs.getString(2));
	        	System.out.println(rs.getString(3));
	        	System.out.println(rs.getString(4));
	        }
	        
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
              
                        			 // the mysql insert statement
      	               String query = " insert into t_audience (tranche, quart, chaine, individus)"
      	                  + " values (?, ?, ?, ?)";
      	                // create the mysql insert preparedstatement
      	                PreparedStatement preparedStmt = con.prepareStatement(query);
      	                preparedStmt.setString (1, record[0]);
      	                preparedStmt.setString (2, record[1]);
      	                preparedStmt.setString   (3, record[2]);
      	                
      	                preparedStmt.setString    (4, record[3]);
      	            
      	                // execute the preparedstatement
      	                preparedStmt.execute();
      	            
      	                con.close();
      	            
            		}
            }
	       }
	
                catch (Exception e)
	              
	              {
	                System.err.println("Got an exception!");
	                System.err.println(e.getMessage());
	              }

            }
            }

            
/*
            		System.out.println(Cans);
            		System.out.println("bye bye ");
            		
            		
            	}	                	
                    fieldID++;
                    System.out.println("Ligne " + lineID
                            + " / champs " + fieldID
                            + " : " + strToken.nextToken());
                   
                
                fieldID = 0;
	        }*/
                
         




	        
	        
	        
	   
	            
	           