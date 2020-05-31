package co.grandcircus.Capstone6.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    private String name;
	private String email;
	private String password;
	private String theme;
	//private String name;
	
	public User() {
		
	}

	public User(String name, String email, String password, String theme) {
		super();
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.theme = theme;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
}