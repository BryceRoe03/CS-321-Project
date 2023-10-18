import java.util.Date;

public class Account {

    public static Account addAccount(String name, String email, Date dateofBirth, int gender, String countryOfOrigin,
            String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry, int lengthOfIntendeStay,
            String accountUsername, String accountPassword, int alienNumber, int idInSystem, Status status,
            PhoneNumber phoneNumber, String additionalInformation) {
        return null;
    }

    public Account getAccount(int idInSystem) {
        return null;
    }

    public Boolean validateAccount(int idInSystem) {
        // temporary
        return false;
    }

    public static Boolean saveAccountToDatabase(Account account) {
        return false;
    }

    public int recordAccount(int idInSystem) {
        return 0;
    }

    public int approveAccount(int idInSystem) {
        return 0;
    }

    public static Account searchAccount(int alienNumber) {
        return null;
    }
}