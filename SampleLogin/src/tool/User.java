package tool;

public class User {
	private String id;
	private String pass;

	public User(String id, String pass) {
		this.setId(id);
		this.setPass(pass);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
}
