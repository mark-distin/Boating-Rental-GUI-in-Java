
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




public class Enquiry {
	
	public static final String URL = "jdbc:mysql://rerun.it.uts.edu.au/sd01";
	public static final String USER = "sd01";
	public static final String PASSWORD = "dwy2mDmW";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	
	public static void main(String[] args) {
		
	//	searchBoat();
	//	createBoat();
	//	updateBoat();
	//  deleteBoat();
		
	}	
	
	public static void searchBoat(String text) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try
		{			
			
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(text);
			
			String boatID;
			String boatType;
			String price;
			String rentalPrice;
			String status;
			String rentalPeriod;
			String date;
			
			DefaultTableModel model = new DefaultTableModel(new String[]{"Boat ID", "Boat Type", "Price", "Rental Price", "Status", "Rental Period", "Date"}, 0);
						
			if(rs.next()) {
					do {
						
						boatID = rs.getString("boatID");
						boatType = rs.getString("boatType");
						price = rs.getString("price");
						rentalPrice = rs.getString("rentalPrice");
						status = rs.getString("status");
						rentalPeriod = rs.getString("rentalPeriod");
						date = rs.getString("date");
						
						model.addRow(new Object[] {boatID, boatType, price, rentalPrice, status, rentalPeriod, date});			
						
			//			System.out.println(boatID+"|"+boatType+"|"+price+"|"+rentalPrice+"|"+status+"|"+rentalPeriod+"|"+date);
						}while(rs.next());
			}

			SecSearch.table.setModel(model);

			rs.close();
			statement.close();
			connection.close();
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			e.printStackTrace();
		}
		
	}
	
	public static void createBoat(int id, String t, int p, int rp, String s, String period, String d) {  
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {	

	    	
	    	String createNewBoat = "insert into boat values(?,?,?,?,?,?,?);";
	    	
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	//    	Statement statement = connection.createStatement();
	    	PreparedStatement state = connection.prepareStatement(createNewBoat);
	    	state.setInt(1,id);
	    	state.setString(2,t);
	    	state.setInt(3,p);
	    	state.setInt(4,rp);
	    	state.setString(5,s);
	    	state.setString(6,period);
	    	state.setString(7,d);

	    	JOptionPane.showMessageDialog(null, "Boat created");
	    	state.executeUpdate();
	//   	int rowsUpdated = state.executeUpdate(createNewBoat);  

	    	state.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
		
		
	}
	
	public static void updateBoat(String update) { 
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {
	    		    	
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	Statement statement = connection.createStatement();     

	    	statement.executeUpdate(update);
	    	JOptionPane.showMessageDialog(null, "Boat updated!");
	   // 	System.out.println("Number of rows update - " + rowsUpdated);
	    	
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	
	}
	
	public static void deleteBoat(String delete) { 
		
		try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.exit(1);
	    }
	    try
	    {
	    		    	
	    	Connection connection = DriverManager.getConnection(URL,USER,PASSWORD );
	    	Statement statement = connection.createStatement();     

	    	statement.executeUpdate(delete);
	    	JOptionPane.showMessageDialog(null, "Boat deleted!");
	   // 	System.out.println("Number of rows update - " + rowsUpdated);
	    	
	    	statement.close();
	    	connection.close();
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	
	}

	
	
	
	
}
