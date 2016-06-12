package actions;

import java.sql.*;

public class LoginAction {
	private String username;
	private String password;
	private String name;
	private String address;
	private String pnumber;
	private String ssn;
	
	public String execute() {
	      String ret = "error";
	      Connection conn = null;

	      try {
	         String URL = "jdbc:mysql://localhost:3306/strutdb";
	         Class.forName("com.mysql.jdbc.Driver");
	         conn = DriverManager.getConnection(URL, "root", "root123");
	         String sql = "SELECT name FROM accounts WHERE";
	         sql+=" username = ? AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, username);
	         ps.setString(2, password);
	         ResultSet rs = ps.executeQuery();

	         while (rs.next()) {
	            name = rs.getString(1);
	            ret = "success";
	         }
	      } catch (Exception e) {
	         ret = "error";
	      } finally {
	         if (conn != null) {
	            try {
	               conn.close();
	            } catch (Exception e) {
	            }
	         }
	      }
	      return ret;
	   }

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
