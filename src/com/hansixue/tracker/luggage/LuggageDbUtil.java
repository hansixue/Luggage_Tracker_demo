package com.hansixue.tracker.luggage;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.util.Date;
public class LuggageDbUtil {

	private DataSource dataSource;

	public LuggageDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public Luggage getLuggageByid(int theId) throws Exception {
		  //#1 init conn stmt rs
		System.out.println("On Going get by id");
	    Connection myConn = null;
	    Statement myStmt = null;
	    ResultSet myRs = null;
	    try {
		    // get a connection
		    myConn = dataSource.getConnection();
		    myStmt = myConn.createStatement();
		    // execute query
		    myRs = myStmt.executeQuery("select * from guest_luggage where id = "+ theId +";");

		    // process result set
		    while (myRs.next()) {
				
			    // retrieve data from result set row
			    int id = myRs.getInt("id");
			    int tagNumber = myRs.getInt("tag_number");
			    int amount = myRs.getInt("amount");
			    Date keptTime = myRs.getDate("kept_time");
			    int keptStuffId = myRs.getInt("kept_stuff_id");
				
			    // create new student object
			    Luggage luggage = new Luggage(id, tagNumber, amount,keptTime,keptStuffId); 
			    System.out.println("On Going get by id return");
	            return luggage; // Return the luggage object for the first matching row
		    }
		    return null;		
	    }finally{
	    	close(myConn,myStmt,myRs);
	    }
	}
	
    public List<Luggage> getLuggages(String sql) throws Exception {

        List<Luggage> luggages = new ArrayList<>();
        //#1 init conn stmt rs
	    Connection myConn = null;
	    Statement myStmt = null;
	    ResultSet myRs = null;
        //#2 try
        //#3 finally
	    try {
		    // get a connection
		    myConn = dataSource.getConnection();
		    myStmt = myConn.createStatement();
		    // execute query
		    myRs = myStmt.executeQuery(sql);
			
		    // process result set
		    while (myRs.next()) {
				
			    // retrieve data from result set row
			    int id = myRs.getInt("id");
			    int tagNumber = myRs.getInt("tag_number");
			    int amount = myRs.getInt("amount");
			    Date keptTime = myRs.getDate("kept_time");
			    int keptStuffId = myRs.getInt("kept_stuff_id");
				
			    // create new student object
			    Luggage tempLuggage = new Luggage(id, tagNumber, amount,keptTime,keptStuffId);
			    tempLuggage.setPickedUpTime(myRs.getDate("picked_up_time"));
			    tempLuggage.setPassedByStuffId(myRs.getInt("passed_by_stuff_id"));
			    // add it to the list of students
			    luggages.add(tempLuggage);				
		    }
			
		    return luggages;		
	    }finally{
	    	close(myConn,myStmt,myRs);
	    }

    }
    
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addLuggage(Luggage theLuggage) {
		//init myconn and mystmt
		Connection myconn = null;
		PreparedStatement mystmt = null;
		
		try{
			/*
			 *  1. get a connection
	      		2. create sql statement
	      		3. execute query
	      		4. process result set*/	
			myconn = dataSource.getConnection();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql = "insert into guest_luggage"	
					+ "(id,tag_number,amount,kept_time,kept_stuff_id) "
					+ "values(null,?,?,?,?)";
			
			
			mystmt = myconn.prepareStatement(sql);
			mystmt.setInt(1, theLuggage.getTagNumber());
			mystmt.setInt(2, theLuggage.getAmount());
			System.out.println(theLuggage.getKeptTime().toString());
			mystmt.setString(3, dateFormat.format(theLuggage.getKeptTime()));
			mystmt.setInt(4, theLuggage.getKeptStuffId());
			
			mystmt.execute();
		}catch (Exception exc) {
			exc.printStackTrace();
		}finally{
			//finally close
			close(myconn,mystmt,null);
		}
		
	}

	public void setLuggagePickedupTime(int theId,Date now){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Get a database connection
            connection = dataSource.getConnection();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // Define the SQL query for updating the row
            String sql = "UPDATE guest_luggage SET picked_up_time=? WHERE id=?";
            System.out.println("set kepttime"+sql+"+"+theId+"+"+dateFormat.format(now));
            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dateFormat.format(now));
            preparedStatement.setInt(2,theId);
            
            // Execute the update
            preparedStatement.executeUpdate();
        } catch (Exception exc) {
			exc.printStackTrace();}
        finally {
            // Close the PreparedStatement and connection
            close(connection, preparedStatement, null);
        }
	}

	public void setLuggagePickedupStuff(int theId,int theStuff) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Get a database connection
            connection = dataSource.getConnection();

            // Define the SQL query for updating the row
            String sql = "UPDATE guest_luggage SET passed_by_stuff_id=? WHERE id=?";
            System.out.println("set pickedupstuff"+sql+"+"+theId+"+"+theStuff);
            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, theStuff);
            preparedStatement.setInt(2, theId);
            
            // Execute the update
            preparedStatement.executeUpdate();
        } catch (Exception exc) {
			exc.printStackTrace();}
        finally {
            // Close the PreparedStatement and connection
            close(connection, preparedStatement, null);
        }
	}
	

}
