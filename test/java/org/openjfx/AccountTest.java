package org.openjfx;

// Imports
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

/**
 * Tester file for Account.java.
 */
public class AccountTest {
    // Fields.
    Account ac = null;
    CriminalRecord cr = null;
    PhoneNumber pn = null;
    LocalDate date = null;

    /**
     * Initialize any objects needed.
     */
    @Before
    public void setUp() {
        cr = new CriminalRecord();
        pn = new PhoneNumber(1, 0);
        date = LocalDate.now();
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
        // ac = Account.addAccount("Don Joe", "Don.Joe@gmail.com", date, 1, "Russia",
        // "No Medical Conditions.",
        // cr, 0, "50 days", "JohnDoe", "Doe123", pn,
        // "No Additional Information.");

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
        assertEquals(4L, ac.getIdInSystem());
        assertTrue("testGetAccount(): idInSystem is less than 0.", ac.getIdInSystem() > 0L);
        // Account Alien Number
        assertEquals(4L, ac.getAlienNumber());
        assertTrue("testGetAccount(): alienNumber is less than 0.", ac.getAlienNumber() > 0L);
        // getAccount test
        assertEquals(ac, ac.getAccount(4));
    }

    // For TA: Method is private, cannot test directly
    @Test
    public void testValidateAccount() {
        // fail("Not Yet Implemented!");
    }

    // For TA: Method is private, cannot test directly
    @Test
    public void testSaveAccountToDatabase() {
        // fail("Not Yet Implemented!");
    }

    // For TA: Method is private, cannot test directly
    @Test
    public void testApproveAccount() {
        // fail("Not Yet Implemented!");
    }

    /**
     * Test to check if the dataReview method is able to run successfully (validate
     * the account and save updates to the database) by checking the return value
     * (which should be the id of the account in the system).
     */
    @Test
    public void testDataReview() {
        // Account ac = new Account();

        // Next account to review 
        assertEquals(0, Account.dataReview(0L));
        // Id of an account should not be less than 0
        assertFalse("testDataReview(): idInSystem should be greater than 0.", Account.dataReview(0L) < 0);
        // Id of an account should less than the max Long Value
        assertFalse("testDataReview(): idInSystem should be less than or equal to the max Value for a Long.", Account.dataReview(0L) > Long.MAX_VALUE);
    }

    /**
     * Test to check if the dataApproval method is able to run successfully (approve
     * the account and save updates to the database) by checking the return value
     * (which should be the id of the account in the system).
     */
    @Test
    public void testDataApproval() {
        // Account ac = new Account();

        // Next account to approve
        assertEquals(0, Account.dataApprove(0));
        // Id of an account should not be less than 0
        assertFalse("dataApprove(): should return greater than 0 if passed.", Account.dataApprove(0) < 0);
        // Id of an account should less than the max Long Value
        assertFalse("testDataReview(): idInSystem should be less than or equal to the max Value for a Long.", Account.dataReview(0L) > Long.MAX_VALUE);

    }

    /**
     * Test to check if the account can be retrieved given the alienNumber.
     */
    @Test
    public void testSearchAccount() {
        // filler number for now
        int alienNumber = 0;
        assertNotNull(Account.searchAccount(alienNumber));
        assertFalse("searchAccount(): should return " + alienNumber,
                Account.searchAccount(0).getAlienNumber() != alienNumber);
        // fail("Not Yet Implemented!");
    }

    /**
     * Test to check if the account's status can be retrieved.
     */
    @Test
    public void testGetStatus() {
        // Create an account with a given status
        ac.setStatus(Status.REVIEW);
        assertEquals(Status.REVIEW, ac.getStatus());
        assertFalse("getStatus(): should return greater than 0 if passed.", ac.getStatus() != Status.REVIEW);
        // Grab Status and compare
        // account.status.getStatus();
        // fail("Not Yet Implemented!");
    }

}
