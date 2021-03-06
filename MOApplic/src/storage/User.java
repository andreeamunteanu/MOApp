package storage;

public class User {
	private static int idCounter=0;
	
	private int id; //unic id
	private String username;
	private String password;
	private String email;
	private String favouriteSite;
	
	public User(String username, String password, String email, String favouriteSite) {
		id=idCounter++;
		this.username = username;
		this.password = password;
		this.email=email;
		this.favouriteSite=favouriteSite ;
	}
	public User(String username, String password, String email) {
		id=idCounter++;
		this.username = username;
		this.password = password;
		this.email=email;
		this.favouriteSite="http://www.moa.fr";
	}
	
	public String getFavouriteSite() {
		return favouriteSite;
	}
	public void setFavouriteSite(String favouriteSite) {
		this.favouriteSite = favouriteSite;
	}
	public int getId()
	{
		return id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
