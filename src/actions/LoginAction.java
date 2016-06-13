package actions;

import java.sql.*;

public class LoginAction {
	private int accountId;
	private String username;
	private String password;
	private String name;
	private String address;
	private String pnumber;
	private String ssn;


	public String execute() 
	{  
		  String ret = "error"; // set return value for execute method
	      Connection conn = null;
	     
	      try 
	      {
	         String URL = "jdbc:mysql://localhost:3306/strutdb"; // Connection string for MySQL where localhost:3306 is the port number and strutdb is the name of database.
	         String user = "root"; // set user for MySQL
		     String pass = "root123"; // set password for MySQL
	         
		     Class.forName("com.mysql.jdbc.Driver"); // set call name
	         conn = DriverManager.getConnection(URL, user, pass); // setup connection string
	         
	         String sql = "SELECT * FROM accounts WHERE"; // prepare the query; selecting all the columns of the matched username and password.
	         sql+=" username = ? AND password = ?";
	         
	         PreparedStatement ps = conn.prepareStatement(sql); // invoke query into the statement
	         ps.setString(1, username); // set the first parameter as the username passed from the form index.jsp.
	         ps.setString(2, password); // set the second paramet as the password passed also from the form in index.jsp
	         
	         ResultSet rs = ps.executeQuery(); // instantiate the resultset

	         while (rs.next()) // iterate through the result set
	         {
	        	 //set each values to respective columns.
	        	setAccountId(rs.getInt(1)); 
	            username = rs.getString(2);
	            password = rs.getString(3);
	            name = rs.getString(4);
	            address = rs.getString(5);
	            pnumber = rs.getString(6);
	            ssn = rs.getString(7);
	            
	            ret = "success";
	         }
	      } 
	      catch (Exception e) 
	      {
	    	ret = "error"; // error appears, set return to "error"
	      } 
	      finally // closing the connection.
	      {
	         if (conn != null) 
	         {
	            try 
	            {
	               conn.close();
	            } 
	            catch (Exception e) 
	            {
	            }
	         }
	      }
	      
	      return ret;
	   }
	//getter and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	

}
