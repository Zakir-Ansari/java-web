package jsp;

import java.sql.*;
import java.text.SimpleDateFormat;

public class MySQL {
	public static Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			return DriverManager.getConnection("jdbc:mysql://localhost/FeeManagementSystem", "root", "Zakir@12345");
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean close(Connection c) {
		try {
			c.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static long insertUser(Connection c, String email, String password, String birthday) {
		// id = -1 means, we can never have a -ve no. in case of auto increment
		// if id return as -1 (-ve) means this function failed to insert a user
		long id = -1;
		try {
			PreparedStatement ps = c.prepareStatement(
					"INSERT INTO user (user_email, user_password, user_birthday) VALUE (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, email);
			ps.setString(2, password);
			java.sql.Date d = new java.sql.Date(new SimpleDateFormat("MM/dd/yyyy").parse(birthday).getTime());
			ps.setDate(3, d);

			//
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getLong(1);
			}
			rs.close();
			ps.close();

		} catch (Exception e) {
			throw new Error(e);
		}
		return id;
	}
	public static long selectUser(Connection c, String email, String password) {
		long id = -1;
		try {
			PreparedStatement ps = c.prepareStatement("SELECT user_id FROM user WHERE user_email=? AND user_password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getLong("user_id");
			}
			rs.close();
			ps.close();
		} catch(Exception e) {
			
		}
		return id;
	}
}
