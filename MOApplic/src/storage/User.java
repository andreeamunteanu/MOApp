package storage;

public class User {
	private static int idCounter=0;
	
	private int id; //unic id
	private String Username;
	private String password;
	private String email;
	
	public User(String username, String password, String email) {
		id=idCounter++;
		Username = username;
		this.password = password;
		this.email=email;
	}
	public int getId()
	{
		return id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}