public class Account {
    private Account bro;
    private String name;
    private String email;
    private int gender;
    private int alien_number, id_in_system, status;
    
    public void CreateNewAc(String[] information){
	this.bro = new Account();
	this.bro.name = information[0];
	this.bro.email = information[1];
	this.bro.gender = information[2];
	this.bro.alien_number = information[3];
	this.bro.id_in_system = information[4];
	this.bro.status = information[5];
    }

    public Account GetAc() {
        return this.bro;
    }

    public String ValidateAc(Account account) {
        return null;
    }
    
    public void setName(String newName) {
	this.name = newName;
    }
    public int getGender() {
	    return this.gender;
    }
}
