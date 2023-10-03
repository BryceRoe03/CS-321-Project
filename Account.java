public class Account {
    private String name;
    private String email;
    private String gender;
    private String alien_number, id_in_system, status;
    
    public void CreateNewAc(String[] information) {
	    this.bro.name = information[0];
	    this.bro.email = information[1];
	    this.bro.gender = information[2];
    	this.bro.alien_number = information[3];
	    this.bro.id_in_system = information[4];
	    this.bro.status = information[5];
    }

    public Account GetAcc() {
        return this;
    }

    public String ValidateAc(Account account) {
        return this.alien_number;
    }
    
    public void setName(String newName) {
	    this.name = newName;
    }

    public int getGender() {
	    return String.paraseInteger(this.gender);
    }
}
