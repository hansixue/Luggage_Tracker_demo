package com.hansixue.tracker.luggage;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.util.Date;
public class luggageDbUtil {

	private DataSource dataSource;

	public luggageDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
    public List<Luggage> getluggages(String sql) throws Exception {

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
			    int tagNumber = myRs.getInt("tagNumber");
			    int amount = myRs.getInt("amount");
			    Date keptTime = myRs.getDate("keptTime");
			    int keptStuffId = myRs.getInt("keptStuffId");
				
			    // create new student object
			    Luggage tempLuggage = new Luggage(id, tagNumber, amount,keptTime,keptStuffId);
				
			    // add it to the list of students
			    luggages.add(tempLuggage);				
		    }
			
		    return luggages;		
	    }finally{
	    	
	    }

    }

}
