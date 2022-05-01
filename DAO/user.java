package DAO;

public class user {
	private String users;
	private String password;
	private String status;
	public user(String users, String password, String status) {
		super();
		this.users = users;
		this.password = password;
		this.status = status;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
