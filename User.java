package testpack;

public class User {
	private int uid;
	private String loginName;
	private String userName;
	private String userPass;
	public User(int uid, String loginName, String userName, String userPass) {
		super();
		this.uid = uid;
		this.loginName = loginName;
		this.userName = userName;
		this.userPass = userPass;
	}
	public User() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	
}
