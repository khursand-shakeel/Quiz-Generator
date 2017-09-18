import java.io.Serializable;


public class User implements Serializable{

	private String email;
	private String username;
	private String password;
	private String role;
	private int score;
	
	User(String email, String username, String password, String role){
		this.email = email;
		this.username = username;
		this.password = password;
		this.score = score;
		this.role = role;
	}
	
	/*User(String email, String username, String password){
		this.email = email;
		this.username = username;
		this.password = password;
		this.score = score;
		this.role = role;
	}*/
	
	public String getEmail(){
		return this.email;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getRole(){
		return this.role;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setRole(String role){
		this.role = role;
	}
}
