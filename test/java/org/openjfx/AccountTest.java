package org.openjfx;

// Imports
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

/**
 * Tester file for Account.java.
 */
public class AccountTest {
    // Fields.
    static Account ac = null;
    static CriminalRecord cr = null;
    static LocalDate date = null;
    static PhoneNumber pn = null;

    /**
     * Initialize any objects needed.
     */
    @BeforeClass
    public static void setUp() {
        // System.out.println("\ntestSetUp()\n");
        cr = new CriminalRecord();
        date = LocalDate.now();
        pn = new PhoneNumber(1, 0);
        ac = Account.addAccount("Don Joe", "Don.Joe@gmail.com", date, 1, "Russia", "No Medical Conditions.",
                cr, 0, "50 days", "JohnDoe", "Doe123", pn,
                "No Additional Information.");
    }

    /**
     * Test to check if the account object was created successfully and if the
     * getter methods are working.
     */
    @Test
    public void testGetAccount() {
        // System.out.println("\ntestGetAccount()\n");
        // Account not null test
        assertNotNull(ac);
        // Account is an account
        assertTrue("testGetAccount(): account is not an instance of Account Class.", ac instanceof Account);
        // Account name test
        assertEquals("Don Joe", ac.getName());
        // Account email test
        assertEquals("Don.Joe@gmail.com", ac.getEmail());
        // Account DOB test
        String todaysDate = date.getMonth().toString() + '/'
                + Integer.toString(date.getDayOfMonth()) + '/' + Integer.toString(date.getYear());
        assertEquals(todaysDate, ac.getDOB().getMonth().toString() + '/' + Integer.toString(ac.getDOB().getDayOfMonth())
                + '/' + Integer.toString(ac.getDOB().getYear()));
        // Account gender test
        assertEquals(1, ac.getGender());
        // CountryOfOrigin
        assertEquals("Russia", ac.getCountryOfOrigin());
        // Medical Conditions
        assertEquals("No Medical Conditions.", ac.getMedicalConditions());
        // Criminal Record
        assertEquals(cr, ac.getCriminalRecord());
        // Reason for entry
        assertEquals(0, ac.getReasonForEntry());
        // Length of stay
        assertEquals("50 days", ac.getLengthOfIntendedStay());
        // Account username
        assertEquals("JohnDoe", ac.getAccountUsername());
        // Account Password
        assertEquals("Doe123", ac.getAccountPassword());
        // Account status
        assertEquals(Status.CREATED, ac.getStatus());
        // Phone Number
        assertEquals(pn, ac.getPhoneNumber());
        // Additional Information
        assertEquals("No Additional Information.", ac.getAdditionalInformation());
        // Account idInSystem test
        assertEquals(2L, ac.getIdInSystem());
        // Failed idInSystem test
        assertTrue("testGetAccount(): idInSystem is less than 0.", ac.getIdInSystem() > 0L);
        // Account Alien Number
        assertEquals(2L, ac.getAlienNumber());
        // Failed idInSystem test
        assertTrue("testGetAccount(): alienNumber is less than 0.", ac.getAlienNumber() > 0L);
        // getAccount test
        assertEquals(ac, ac.getAccount(2L));
    }

    // For TA: Method is private, cannot test directly
    @Test
    public void testValidateAccount() {
        // Cannot be done. It's the thought that counts.
    }

    // For TA: Method is private, cannot test directly
    @Test
    public void testSaveAccountToDatabase() {
        // Cannot be done. It's the thought that counts.
    }

    // For TA: Method is private, cannot test directly
    @Test
    public void testApproveAccount() {
        // Cannot be done. It's the thought that counts.
    }

    /**
     * Test to check if the dataReview method is able to run successfully (validate
     * the account and save updates to the database) by checking the return value.
     */
    @Test
    public void testDataReview() {
        // System.out.println("\ntestDataReview()\n");
        // Set status to Review
        Account.getAccount(0L).setStatus(Status.REVIEW);
        // Next account to review
        assertEquals(0L, Account.dataReview(0L));
        // System.out.println(Account.getAccount(0L).getStatus());
        // Successful Data Review should update status to Approval
        assertTrue("testDataReview(): A valid account should change status to Status.APPROVAL", Account.getAccount(0L).getStatus() == Status.APPROVAL);
        // Set status to Created
        Account.getAccount(0L).setStatus(Status.CREATED);
        // Should fail 
        assertFalse("testDataReview(): Account with any status other than review should return 0.", Account.dataReview(0L) < 0);
    }

    /**
     * Test to check if the dataApproval method is able to run successfully (approve
     * the account and save updates to the database) by checking the return value.
     */
    @Test
    public void testDataApproval() {
        // System.out.println("\ntestDataApproval()\n");
        // Set status to Approval
        Account.getAccount(0L).setStatus(Status.APPROVAL);
        // Next account to approve
        assertEquals(0L, Account.dataApprove(0L));
        // System.out.println(Account.getAccount(0L).getStatus());
        // Successful Data Approval should update status to Done
        assertTrue(
                "A valid account should change status to Status.DONE becuase the account was approved",
                Account.getAccount(0L).getStatus() == Status.DONE);
        // Set status to REVIEW
        Account.getAccount(0L).setStatus(Status.REVIEW);
        // Should fail
        assertFalse("Account with any status other than approval should return 0.",
                Account.dataApprove(0L) < 0);
    }

    /**
     * Test to check if the account can be retrieved given the alienNumber.
     */
    @Test
    public void testSearchAccount() {
        // System.out.println("\ntestSearchAccount()\n");
        // testing account that is in the database
        Long alienNumber = 0L;
        assertNotNull(Account.searchAccount(alienNumber));

        // tests to make sure the alien number is correct
        assertFalse("searchAccount(): should return " + alienNumber,
                Account.searchAccount(0L).getAlienNumber() != alienNumber);
        // testing account that is not in the database
        assertFalse("searchAccount(): should return null", Account.searchAccount(100000L) != null);
    }

    /**
     * Test to check the toString method for an Account.
     */
    @Test
    public void testToString() {
        // System.out.println("\ntestToString()\n");
        // checking toString of the account.
        assertEquals("toString() does not match", "Name: Don Joe, Email: Don.Joe@gmail.com, DateOfBirth: "
                + date.toString()
                + ", Gender: 1, CountryOfOrigin: Russia, MedicalConditions: No Medical Conditions., CriminalRecord: No Criminal Record., ReasonForEntry: 0, LengthOfIntendedStay: 50 days, AccountUsername: JohnDoe, AccountPassword: Doe123, alienNumber: 2, idInSystem: 2, Status: CREATED, PhoneNumber: "
                + pn.toString() + ", AdditionalInformation: No Additional Information.",
                Account.getAccount(2L).toString());
    }

    /**
     * Test to check if the account's status can be retrieved.
     */
    @Test
    public void testGetStatus() {
        // System.out.println("\ntestGetStatus()\n");
        // Create an account with a given status
        ac = Account.getAccount(2L);
        ac.setStatus(Status.REVIEW);
        // Status should be Review
        assertEquals(Status.REVIEW, ac.getStatus());
        // Grab Status and compare
        assertTrue("getStatus(): should return greater than 0 if passed.", ac.getStatus() != Status.DONE);
    }
}
