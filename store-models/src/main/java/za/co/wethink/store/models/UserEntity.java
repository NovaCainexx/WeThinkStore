package za.co.wethink.store.models;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ebe
 *
 */
public class UserEntity {

	private String userName;
	private String password;
	private List<Role> roles;

	public UserEntity() {
		super();
		roles = new ArrayList<>();
	}

	public UserEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = new ArrayList<>();
	}
	
	public UserEntity(String userName, String password, List<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> list) {
		roles = list;
	}

}
