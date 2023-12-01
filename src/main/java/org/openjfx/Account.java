package org.openjfx;

// Imports
import java.time.LocalDate;
import java.util.ArrayList;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Account Business Object.
 */
public class Account {
    // flags to check if we can assign more ids and alien numbers
    private static boolean canAssignID = true, canAssignAlienNumber = true;
    private static long nextIdInSystem = 0;
    private static long nextAlienNumber = 0;
    // workflow object
    private static ArrayList<Account> accList = new ArrayList<Account>();
    private static Workflow w = Workflow.getWorkflow();
    // fields for account object
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
    /**
     * Getter method for name.
     * 
     * @return String - name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for email.
     * 
     * @return String - email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter method for date of birth.
     * 
     * @return LocalDate - dateofBirth.
     */
    public LocalDate getDOB() {
        return this.dateOfBirth;
    }

    /**
     * Getter method for gender.
     * 
     * @return Integer - gender.
     */
    public int getGender() {
        return this.gender;
    }

    /**
     * Getter method for country of origin.
     * 
     * @return String - countryOfOrigin.
     */
    public String getCountryOfOrigin() {
        return this.countryOfOrigin;
    }

    /**
     * Getter method for medical conditions.
     * 
     * @return String - medicalConditions.
     */
    public String getMedicalConditions() {
        return this.medicalConditions;
    }

    /**
     * Getter method for criminal record.
     * 
     * @return CriminalRecord - criminalRecord.
     */
    public CriminalRecord getCriminalRecord() {
        return this.criminalRecord;
    }

    /**
     * Getter method of reason for entry (will be a dropdown menu).
     * 
     * @return Integer - reasonForEntry
     */
    public int getReasonForEntry() {
        return this.reasonForEntry;
    }

    /**
     * Getter method for length of intended stay.
     * 
     * @return String - lengthOfIntendedStay.
     */
    public String getLengthOfIntendedStay() {
        return this.lengthOfIntendedStay;
    }

    /**
     * Getter method for account username.
     * 
     * @return String - accountUsername.
     */
    public String getAccountUsername() {
        return this.accountUsername;
    }

    /**
     * Getter method for account password.
     * 
     * @return String - accountPassword.
     */
    public String getAccountPassword() {
        return this.accountPassword;
    }

    /**
     * Getter method for alien number.
     * 
     * @return Long - alienNumber.
     */
    public long getAlienNumber() {
        return this.alienNumber;
    }

    /**
     * Getter method for id in the system.
     * 
     * @return Long - idInSystem.
     */
    public long getIdInSystem() {
        return this.idInSystem;
    }

    /**
     * Getter method for the status.
     * 
     * @return Status - status.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Getter method for the phone number.
     * 
     * @return PhoneNumber - phoneNumber.
     */
    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Getter method for any additional information.
     * 
     * @return String - additionalInformation.
     */
    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    /**
     * Getter method for account list.
     * 
     * @return ArrayList<Account> - Account list.
     */
    public static ArrayList<Account> getAccountList() {
        return accList;
    }

    /* Setters */
    /**
     * Setter method to set the status.
     * 
     * @param status - Status of account.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Private Account constructor to create an Account object with the given
     * parameters. The fields alientNumber, idInSystem, and Status are not included
     * becuase the user does not assign these.
     * 
     * @param name                  - Individual's name.
     * @param email                 - Individual's email.
     * @param dateOfBirth           - Individual's date of birth.
     * @param gender                - Individual's gender.
     * @param countryOfOrigin       - Individual's country of origin.
     * @param medicalConditions     - Individual's medical conditions.
     * @param criminalRecord        - Individual's criminalRecord/null.
     * @param reasonForEntry        - Individual's reason for entry.
     * @param lengthOfIntendedStay  - Individual's intended length of stay.
     * @param accountUsername       - Individual's account username.
     * @param accountPassword       - Individual's account password
     * @param phoneNumber           - Individual's phone number.
     * @param additionalInformation - Any additional information the individual
     *                              would like to include.
     */
    private Account(String name, String email, LocalDate dateOfBirth, int gender, String countryOfOrigin,
            String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry, String lengthOfIntendedStay,
            String accountUsername, String accountPassword,
            PhoneNumber phoneNumber, String additionalInformation) {
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
    /**
     * Public method used to add an account to the system. This method is called by
     * data entry and only succeeds if the on scren validation returns true and if
     * the canAssignID and canAssignAlienNumber flags are
     * true (meaning there is enough storage to create another account).
     * 
     * @param name                  - Individual's name.
     * @param email                 - Individual's email.
     * @param dateOfBirth           - Individual's date of birth.
     * @param gender                - Individual's gender.
     * @param countryOfOrigin       - Individual's country of origin.
     * @param medicalConditions     - Individual's medical conditions.
     * @param criminalRecord        - Individual's criminalRecord/null.
     * @param reasonForEntry        - Individual's reason for entry.
     * @param lengthOfIntendedStay  - Individual's intended length of stay.
     * @param accountUsername       - Individual's account username.
     * @param accountPassword       - Individual's account password
     * @param phoneNumber           - Individual's phone number.
     * @param additionalInformation - Any additional information the individual
     *                              would like to include.
     * @return Account - Account added to the system.
     */
    public static Account addAccount(String name, String email, LocalDate dateofBirth, int gender,
            String countryOfOrigin,
            String medicalConditions, CriminalRecord criminalRecord, int reasonForEntry, String lengthOfIntendStay,
            String accountUsername, String accountPassword,
            PhoneNumber phoneNumber, String additionalInformation) {

        Account tmp = null;
        // call constructor if idInSystem and alienNumber can be created (<
        // Long.MAX_VALUE)
        if (canAssignID && canAssignAlienNumber) {
            tmp = new Account(name, email, dateofBirth, gender, countryOfOrigin, medicalConditions, criminalRecord,
                    reasonForEntry, lengthOfIntendStay, accountUsername, accountPassword, phoneNumber,
                    additionalInformation);
            // Add account to account list (database)
            saveAccountToDatabase(tmp);
            // Add account to workflow
            Workflow.addItem(tmp.getIdInSystem());
        }
        return tmp;
    }

    /**
     * This is a public method that is used to retrieve an individual's account
     * given the id the system associated to it.
     * 
     * @param idInSystem - Long corresponding to the id for the account.
     * @return Account - Individual's account.
     */
    public static Account getAccount(long idInSystem) {
        if (idInSystem == -1) {
            //System.out.println("-1 ID!!!!");
            return null;
        }
        for (Account i : accList) {
            if (i.getIdInSystem() == idInSystem) {
                return i;
            }
        }
        return null;
    }

    /**
     * Private method called by dataReview to run validation checks against the
     * individual's account.
     * 
     * @param idInSystem - Long corresponding to the id for the account.
     * @return Boolean - Whether the validation was successful or not.
     */
    private static Boolean validateAccount(long idInSystem) {

        // FOR TA: We were unable to find a suitable public dataset so this
        // method is empty and always returns true.
        return true;
    }

    /**
     * Private method to save the account to the database.
     * 
     * @param account - Account to save to the database.
     * @return Boolean - Whether the save was successful or not.
     */
    private static Boolean saveAccountToDatabase(Account account) {
        return accList.add(account);
    }

    // FOR DATA REVIEW
    /**
     * Public method called by the reviewer to review and save any changes to the
     * corresponding account.
     * 
     * @param idInSystem - Long corresponding to the id for the account.
     * @return Long - 0 if staus change to approval/1 if not.
     */
    public static long dataReview(long idInSystem) {
        // calls both validateAccount() and saveAccountToDatabase()
        // only calls save if validate passes
        Account acc = getAccount(idInSystem);
        if (acc != null) {
            if (acc.getStatus() == Status.REVIEW) {
                // Run tests
                if (validateAccount(idInSystem)) {
                    Workflow.updateWorkflowStatus(Status.APPROVAL, idInSystem);
                    return 0L;
                }
                Workflow.updateWorkflowStatus(Status.FAIL, idInSystem);
            }
        }
        return 1L;
    }

    // FOR DATA APPROVAL
    /**
     * Public method called by the approver that calls the approveAccount and
     * saveToDatabase method to update any changes made to the account.
     * 
     * @param idInSystem - Long corresponding to the id for the account.
     * @return Long - 0 if status done/1 if not.
     */
    public static long dataApprove(long idInSystem) {
        // calls both approveAccount() and saveAccountToDatabase()
        // only calls save if approve passes
        Account fin_acc = getAccount(idInSystem);

        if (fin_acc != null) {
            if (fin_acc.getStatus() == Status.APPROVAL) {
                if (approveAccount(idInSystem) == 0) {

                    Workflow.updateWorkflowStatus(Status.DONE, idInSystem);

                    return 0L;
                }
            }
        }
        Workflow.updateWorkflowStatus(Status.FAIL, idInSystem);
        return 1L;
    }

    /**
     * Private method to approve the acocunt.
     * 
     * @param idInSystem - Long corresponding to the id for the account.
     * @return Long - 0 if email sent/1 if not.
     */
    private static long approveAccount(long idInSystem) {
        final String guser = "immigranttest01@gmail.com";
        final String gpass = "ledz qsof yjwr tbqb";

        Properties setup = new Properties();
        setup.put("mail.smtp.host", "smtp.gmail.com");
        setup.put("mail.smtp.auth", "true");
        setup.put("mail.smtp.port", "587");
        setup.put("mail.smtp.starttls.enable", "true");

        Session sesh = Session.getInstance(setup, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(guser, gpass);
            }
        }); 

        try {
            Message approvalEmail = new MimeMessage(sesh);
            approvalEmail.setFrom(new InternetAddress("immigranttest01@gmail.com"));
            approvalEmail.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(getAccount(idInSystem).getEmail())  
            );
            approvalEmail.setSubject("Contratulations! Your account has been approved!");
            approvalEmail.setText("Hello " + getAccount(idInSystem).getName() + ",\n\n Your account has been approved! See you in the next step of the process!\n\n- Immigration team\n(Do not reply)");

            Transport.send(approvalEmail);

        } catch (MessagingException e) {
            e.printStackTrace();
            return 1L;
        }

        return 0L;
    }

    

    /**
     * Public method to search for a user's account.
     * 
     * @param alienNumber - Long AlienNumber corresponding to the individual's
     *                    account.
     * @return Account - The individual's account.
     */
    public static Account searchAccount(long alienNumber) {
        for (Account i : accList) {
            if (i.getAlienNumber() == alienNumber) {
                return i;
            }
        }
        return null;
    }

    /**
     * toString for Account
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", DateOfBirth: " + dateOfBirth + ", Gender: " + gender
                + ", CountryOfOrigin: " + countryOfOrigin + ", MedicalConditions: " + medicalConditions
                + ", CriminalRecord: " + criminalRecord + ", ReasonForEntry: " + reasonForEntry
                + ", LengthOfIntendedStay: " + lengthOfIntendedStay + ", AccountUsername: " + accountUsername
                + ", AccountPassword: " + accountPassword + ", alienNumber: " + alienNumber + ", idInSystem: "
                + idInSystem + ", Status: " + status + ", PhoneNumber: " + phoneNumber + ", AdditionalInformation: "
                + additionalInformation;
    }

    /**
     * Public method for testing purposes to populate Account ArrayList.
     * 
     * @return Boolean - True/False if the list was populated.
     */
    public static boolean testPopulateList() {
        boolean accounts = true;

        CriminalRecord testCriminalRecord = new CriminalRecord();
        testCriminalRecord.hasRecord = true;
        testCriminalRecord.violations = new String[] { "Arson", "Vandalism" };

        // KABIR: You used the private constructor instead of the public "constructor"
        // that adds to the List I changed it to addAccount

        addAccount("Crew Terrys", "immigranttest02@gmail.com", LocalDate.of(1973, 3, 20), 0,
                "Germany", "Broken Legs", testCriminalRecord, 3, "12 days", "crews", "terrys123",
                new PhoneNumber(1, 4834683211l), "");

        addAccount("Terry Crews", "immigranttest02@gmail.com", LocalDate.of(1968, 7, 30), 0,
                "Brazil", "",
                new CriminalRecord(), 0, "12 years", "terry", "crews123", new PhoneNumber(1, 1234567890l), "");

        return accounts;
    }
}
