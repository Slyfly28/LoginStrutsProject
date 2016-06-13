package actions;

import java.sql.*;

import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport
{
	private static final long serialVersionUID = -7505437345373234225L;
	
	private String username;
	private String password;
	private String name;
	private String address;
	private String pnumber;
	private String ssn;
	
	// validating each property
	public void validate()
	{
		if (name == null || name.trim().equals("")) // check to see if the name is null
		{
			addFieldError("name", "Name field is required.");
		}
		
		if (username == null || username.trim().equals("")) // check to see if the username if null
		{
			addFieldError("username", "Username is required.");
		}
		
		
		if (password == null || password.trim().equals("")) // check to see if the password is null
		{
			addFieldError("password", "Password is required.");
		}
	}
	
	public String execute() 
	{
	      
		  String ret = "error";
	      Connection conn = null;
	      //Same procedure as in the LoginAction.java
	      try 
	      {
	         String URL = "jdbc:mysql://localhost:3306/strutdb";
	         String user = "root";
		     String pass = "root123";
		     
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, user, pass);
	         
	         String sql = "INSERT INTO accounts (username, password, name, address, pnumber, ssn) "; // query to insert to the table values.
	         		sql+=  "VALUES (?,?,?,?,?,?)";
	         
	         PreparedStatement ps = conn.prepareStatement(sql); // prepare the statement, setting each values accordingly.
	         ps.setString(1, username);
	         ps.setString(2, password);
	         ps.setString(3, name);
	         ps.setString(4, address);
	         ps.setString(5, pnumber);
	         ps.setString(6, ssn);
	         
	         int rs = ps.executeUpdate(); // result set returns a number > 0 if insert is success

	         if(rs > 0) // if no error, return "success"
	         {
	            ret = "success";
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
	
	
	
}
