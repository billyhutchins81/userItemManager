package testpack;

import java.sql.*;
import java.util.ArrayList;

public class DB_Access {
	private String url = "jdbc:mysql://localhost:3306/test";
	private String driver = "com.mysql.jdbc.Driver";
	private String uname = "root";
	private String upass = "billy81";
	private Connection con;
	private Statement st;
	private PreparedStatement pst;

	public DB_Access() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uname, upass);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User validateLogin(String uname, String upass) {
		User u = null;

		String sql = "select uid, Name from TUser01 " + "where LoginName = '" + uname + "' " + "and LoginPass = '"
				+ upass + "'";
		try {
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				u = new User(rs.getInt(1), uname, rs.getString(2), "");
			}
		} catch (Exception e) {
		}
		return u;
	}

	public boolean createAccount(String loginName, String fullName, String pass) {
		boolean success = true;
		String sql = "insert into TUser01 (LoginName, Name, LoginPass) values (?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, loginName);
			pst.setString(2, fullName);
			pst.setString(3, pass);
			pst.executeUpdate();
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	public ArrayList<Item> getUserItems(int userId) {
		ArrayList<Item> list = new ArrayList<Item>();
		String sql = "select iid, ItemName, Qty, uid " + "from TItems01 where uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Item i = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				list.add(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean addNewItem(String itemName, int itemQty, int userId) {
		boolean success = true;

		String sql = "insert into TItems01 (ItemName, Qty, uid) values (?, ?, ?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, itemName);
			pst.setInt(2, itemQty);
			pst.setInt(3, userId);
			pst.executeUpdate();
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	public Item getItemDetails(int itemId, int userId) {
		Item i = null;
		String sql = "select iid, ItemName, Qty, uid from TItems01 " + "where iid = ? and uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, itemId);
			pst.setInt(2, userId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				i = new Item(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public boolean deleteItem(int itemId, int userId) {
		boolean success = true;
		String sql = "delete FROM TItems01 " + "where iid = ? and uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, itemId);
			pst.setInt(2, userId);
			pst.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			success = false;
			e1.printStackTrace();
		}

		return success;
	}

	public boolean updateUserInfo(String loginName, String fullname, String loginPass, int userId) throws SQLException {
		boolean success = true;
		try {
			String sql = "update tuser01 set LoginName=?, Name=?, LoginPass=? " + "where uid = ?";
			System.out.println(sql);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, loginName);
			pst.setString(2, fullname);
			pst.setString(3, loginPass);
			pst.setInt(4, userId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			success = false;
			e.printStackTrace();
		}

		return success;
	}
	
	public boolean updateItemInfo(String itemName, int itemQuantity, int itemId, int userId) {
		boolean success = true;
		try {
			String sql = "update titems01 set ItemName=?, Qty=? " + "where iid = ? and uid = ?";
			System.out.println(sql);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, itemName);
			pst.setInt(2, itemQuantity);
			pst.setInt(3, itemId);
			pst.setInt(4, userId);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			success = false;
			e.printStackTrace();
		}

		return success;
		
	}

}
