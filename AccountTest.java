import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;
import org.junit.Test;
import java.time.LocalDate;

public class AccountTest {
    Account ac = null;

    @Test
    public void testGetAccount() {
        CriminalRecord cr = new CriminalRecord();
        PhoneNumber pn = new PhoneNumber(1, 0);
        LocalDate date = LocalDate.now();
        ac = Account.addAccount("Don Joe", "Don.Joe@gmail.com", date, 1, "Russia", "No Medical Conditions.",
                cr, 0, 50, "JohnDoe", "Doe123", Status.CREATED, pn,
                "No Additional Information.");// <------- Can I call these tests from another method that already
                                              // instantiates this?

        // Account not null test
        assertNotNull(ac);
        // Account is an account
        assertTrue("Account is an account instance.", ac instanceof Account);
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
        assertEquals("No Medical Conditions", ac.getMedicalConditions());
        // Criminal Record
        assertEquals(cr, ac.getCriminalRecord());
        // Reason for entry
        assertEquals(0, ac.getReasonForEntry());
        // Length of stay
        assertEquals(50, ac.getLengthOfIntendedStay());
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
        assertEquals(ac, ac.getAccount(0));
        // Account Alien Number
        assertEquals(0, ac.getAlienNumber());
    }

    // ASK About testing private method
    @Test
    public void testValidateAccount() {
        // fill in constructor with valid data later once we implement the some
        // functionality
        // assertTrue(ac.validateAccount(0));
        // fail("Not Yet Implemented!");
    }

    // ASK ABOUT VISIBILITY OF SAVEACCOUNTTODATABASE
    @Test
    public void testSaveAccountToDatabase() {
        // Account ac = new Account();
        // assertTrue(Account.saveAccountToDatabase(ac));
        fail("Not Yet Implemented!");
    }

    @Test
    public void testRecordAccount() {
        // Account ac = new Account();
        assertEquals(0, Account.recordAccount(0));
        // fail("Not Yet Implemented!");
    }

    // ASK ABOUT VISIBILITY OF APPROVEACCOUNT
    @Test
    public void testApproveAccount() {
        // assertEquals(0, Account.approveAccount(0));
        fail("Not Yet Implemented!");
    }

    @Test
    public void testSearchAccount() {
        // filler number for now
        int alienNumber = 176;
        assertNotNull(Account.searchAccount(alienNumber));
        // fail("Not Yet Implemented!");
    }

    @Test
    public void testGetStatus() {
        // Create an account with a given status
        ac.setStatus(Status.REVIEW);
        assertEquals(Status.REVIEW, ac.getStatus());
        // Grab Status and compare
        // account.status.getStatus();
        // fail("Not Yet Implemented!");
    }

}
