import static org.junit.Assert.assertEquals;

import java.beans.Transient;

import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {
   @BeforeClass
    public void testClassName() {
        // idk what test ur writing here @kabir
    }

    @Test
    public void testGetAccount() {
        Account ac = new Account();// <------- Can I call these tests from another method that already instantiates this?
        assertNotNull(ac.getAccount(0));
        // fail("Not Yet Implemented!");
    }
    @Test
    public void testValidateAccount() {
        // fill in constructor with valid data later once we implement the some functionality
        Account ac = new Account();
        assertTrue(ac.validateAccount(0));

        // fail("Not Yet Implemented!");
    }
    @Test
    public void testSaveAccountToDatabase() {
       Account ac = new Account();
       assertTrue(Account.saveAccountToDatabase(ac));
        // fail("Not Yet Implemented!");
    }
    @Test
    public void testRecordAccount() {
        // Account ac = new Account();
        fail("Not Yet Implemented!");
    }
    @Test
    public void testApproveAccount() {
        fail("Not Yet Implemented!");
    }
    @Test
    public void testSearchAccount() {
        //filler number for now
        int alienNumber = 176;
        assertNotNull(Account.searchAccount(alienNumber));
        // fail("Not Yet Implemented!");
    }
}
