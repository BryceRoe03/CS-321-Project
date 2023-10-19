import java.time.LocalDate;

public class Account {
    private static boolean canAssignID = true, canAssignAlienNumber = true;
    private static long nextIdInSystem = 0;
    private static long nextAlienNumber = 0;
    private static Workflow w;
    // private Account acc = null;

    private String name = "";
    private String email = "";
    private LocalDate dateOfBirth = null;
    private int gender = -1;
    private String countryOfOrigin = "";
    private String medicalConditions = "";
    private CriminalRecord criminalRecord = null;
    private int reasonForEntry = -1;
    private String lengthOfIntendedStay = "";
    private String accountUsername = "";
    private String accountPassword = "";
    private long alienNumber = -1;
    private long idInSystem = -1;
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

    public String getLengthOfIntendedStay() {
        return this.lengthOfIntendedStay;
    }

    public String getAccountUsername() {
        return this.accountUsername;
    }

    public String getAccountPassword() {
        return this.accountPassword;
    }

    public long getAlienNumber() {
        return this.alienNumber;
    }

    public long getIdInSystem() {
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

    private Account(String name, String email, LocalDate dateOfBirth, int gender, String countryOfOrigin,
            String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry, String lengthOfIntendedStay,
            String accountUsername, String accountPassword,
            PhoneNumber phoneNumber, String additionalInformation) { // don't include alienNumber, idInSystem, and status becuase
                                                                     // that is assigned by the sytem?
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.countryOfOrigin = countryOfOrigin;
        this.medicalConditions = medicalConditions;
        this.criminalRecord = criminalRecord;
        this.reasonForEntry = reasonForEntry;
        this.lengthOfIntendedStay = lengthOfIntendedStay;
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        // status is already set to Status.CREATED
        // assign idInSystem to this value and increment to next available value
        this.idInSystem = nextIdInSystem++;
        if (idInSystem == Long.MAX_VALUE) {
            canAssignID = false;
        }
        // assign alienNumber to this value and increment to next available value
        this.alienNumber = nextAlienNumber++;
        if (nextAlienNumber == Long.MAX_VALUE) {
            canAssignAlienNumber = false;
        }
        this.phoneNumber = phoneNumber;
        this.additionalInformation = additionalInformation;


    }

    // THIS IS RUN FROM DATA ENTRY CALLED AFTER ONSCREENVALIDATION RETURNS TRUE
    public static Account addAccount(String name, String email, LocalDate dateofBirth, int gender, String countryOfOrigin,
            String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry, String lengthOfIntendStay,
            String accountUsername, String accountPassword,
            PhoneNumber phoneNumber, String additionalInformation) {
        
        Account tmp = null;
        // call constructor if idInSystem and alienNumber can be created (less than Long.MAX_VALUE)
        if (canAssignID && canAssignAlienNumber) {
            tmp = new Account(name, email, dateofBirth, gender, countryOfOrigin, medicalConditions, criminalRecord,
                    reasonForEntry, lengthOfIntendStay, accountUsername, accountPassword, phoneNumber,
                additionalInformation);
            saveAccountToDatabase(tmp);

            Workflow w = Workflow.getWorkflow();
            w.addItem(tmp.getIdInSystem());
        }

        return tmp;
    }

    public Account getAccount(long idInSystem) {
        return null;
    }

    private Boolean validateAccount(long idInSystem) {
        return false;
    }

    private static Boolean saveAccountToDatabase(Account account) {
        return false;
    }

    // FOR DATA REVIEW
    public static int dataReview(long idInSystem) {
        // calls both validateAccount() and saveAccountToDatabase()
        // only calls save if validate passes
        return 0;
    }

    // FOR DATA APPROVAL
    public static int dataApprove(long idInSystem) {
        // calls both approvaAccount() and saveAccountToDatabase()
        // only calls save if approve passes
        return 0;
    }

    private static int approveAccount(long idInSystem) {
        return 0;
    }

    public static Account searchAccount(long alienNumber) {
        return null;
    }
}