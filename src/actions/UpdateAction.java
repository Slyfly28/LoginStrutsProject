package actions;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;


public class UpdateAction extends ActionSupport
{
	private static final long serialVersionUID = -7505437345373234225L;
	
	private int accountId;
	private String username;
	private String password;
	private String name;
	private String address;
	private String pnumber;
	private String ssn;
	
	//validate each property, same validation seen in the RegisterAction.java
	public void validate()
	{
		if (name == null || name.trim().equals(""))
		{
			addFieldError("name", "Name field is required.");
		}
		
		if (username == null || username.trim().equals(""))
		{
			addFieldError("username", "Username is required.");
		}
		
		
		if (password == null || password.trim().equals(""))
		{
			addFieldError("password", "Password is required.");
		}
	}
	//same execute method. main difference is the query string
	public String execute() 
	{
		  String ret = "error";
	      Connection conn = null;
	      
	      try 
	      {
	         String URL = "jdbc:mysql://localhost:3306/strutdb";
	         String user = "root";
		     String pass = "root123";
		     
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, user, pass);
	         
	         String sql = "UPDATE accounts ";
	         		sql+= "SET username=?, password=?, name=?, address=?, pnumber=?, ssn=? "; // setting up the Update query
	         		sql+= "WHERE accountId=?";
	         
	         PreparedStatement ps = conn.prepareStatement(sql); //plugging in the sql query string to the prepared statement
	         //Setting up each value accordinglyu.
	         ps.setString(1, username);
	         ps.setString(2, password);
	         ps.setString(3, name);
	         ps.setString(4, address);
	         ps.setString(5, pnumber);
	         ps.setString(6, ssn);
	         ps.setInt(7, accountId);
	         
	         int rs = ps.executeUpdate();

	         if(rs > 0)
	         {
	        	System.out.println(rs);
	            ret = "success"; // if update success, return
	         }
	      } 
	      catch (Exception e) 
	      {
	    	ret = "error";
	      } 
	      finally 
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
	//getters and setters
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
