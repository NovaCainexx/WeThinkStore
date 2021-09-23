package za.co.wethink.store.models;

/**
 * 
 * @author ebe
 *
 */
public class Role {

	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}

	public Role() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
