package com.hansixue.tracker.luggage;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.util.Date;
public class LuggageDbUtil {

	private DataSource dataSource;

	public LuggageDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
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

}
