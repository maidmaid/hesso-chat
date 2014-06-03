package client.network;

public abstract class ClientAbstract {

	private String firstName;
	private String lastName;
	private int id;
	private boolean registred;
	
	public ClientAbstract(){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
		this.setRegistred(registred);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isRegistred() {
		return registred;
	}

	public void setRegistred(boolean registred) {
		this.registred = registred;
	}
}
