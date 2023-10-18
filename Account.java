import java.time.LocalDate;

public class Account {
    private static int nextIdInSystem = 0;
    private static int nextAlienNumber = 0;
    // private Account acc = null;

    private String name = "";
    private String email = "";
    private LocalDate dateOfBirth = null;
    private int gender = -1;
    private String countryOfOrigin = "";
    private String medicalConditions = "";
    private CriminalRecord criminalRecord = null;
    private int reasonForEntry = -1;
    private int lengthOfIntendedeStay = -1;
    private String accountUsername = "";
    private String accountPassword = "";
    private int alienNumber = -1;
    private int idInSystem = -1;
    private Status status = Status.CREATED;
    private PhoneNumber phoneNumber = null;
    private String additionalInformation = "";

    /* Getters */
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getDOB() {
        return this.dateOfBirth;
    }

    public int getGender() {
        return this.gender;
    }

    public String getCountryOfOrigin() {
        return this.countryOfOrigin;
    }

    public String getMedicalConditions() {
        return this.medicalConditions;
    }

    public CriminalRecord getCriminalRecord() {
        return this.criminalRecord;
    }

    public int getReasonForEntry() {
        return this.reasonForEntry;
    }

    public int getLengthOfIntendedStay() {
        return this.lengthOfIntendedeStay;
    }

    public String getAccountUsername() {
        return this.accountUsername;
    }

    public String getAccountPassword() {
        return this.accountPassword;
    }

    public int getAlienNumber() {
        return this.alienNumber;
    }

    public int getIdInSystem() {
        return this.idInSystem;
    }

    public Status getStatus() {
        return this.status;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    /* Setters */
    public void setStatus(Status status) {
        this.status = status;
    }

    private Account(String name, String email, LocalDate dateofBirth, int gender, String countryOfOrigin,
            String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry, int lengthOfIntendedeStay,
            String accountUsername, String accountPassword, Status status,
            PhoneNumber phoneNumber, String additionalInformation) { // don't include alienNumber and idInSystem becuase
                                                                     // that is assigned by the sytem?
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateofBirth;
        this.gender = gender;
        this.countryOfOrigin = countryOfOrigin;
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        // assign idInSystem to this value and increment to next available value
        this.idInSystem = nextIdInSystem++;
        // assign alienNumber to this value and increment to next available value
        this.alienNumber = nextAlienNumber++;
        // status is already set to Status.CREATED
        this.phoneNumber = phoneNumber;
        this.additionalInformation = additionalInformation;

    }

    public static Account addAccount(String name, String email, LocalDate dateofBirth, int gender, String countryOfOrigin,
            String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry, int lengthOfIntendeStay,
            String accountUsername, String accountPassword, Status status,
            PhoneNumber phoneNumber, String additionalInformation) {
        // call constructor
        return new Account(name, email, dateofBirth, gender, countryOfOrigin, medicalConditions, criminalRecord,
                reasonForEntry, lengthOfIntendeStay, accountUsername, accountPassword, status, phoneNumber,
                additionalInformation);
    }

    public Account getAccount(int idInSystem) {
        return null;
    }

    private Boolean validateAccount(int idInSystem) {
        return false;
    }

    public static Boolean saveAccountToDatabase(Account account) {
        return false;
    }

    public static int recordAccount(int idInSystem) {
        // calls both validateAccount() and saveAccountToDatabase()
        // only calls save if validate passes

        // FOR DATA REVIEW

        return 0;
    }

    private static int approveAccount(int idInSystem) {
        return 0;
    }

    public static Account searchAccount(int alienNumber) {
        return null;
    }

}