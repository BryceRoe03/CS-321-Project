
// Imports
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.beans.Transient;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

/**
 * Tester file for Workflow.java.
 */
public class WorkflowTest {
    // Fields.
    Account ac = null;
    CriminalRecord cr = null;
    PhoneNumber pn = null;
    LocalDate date = null;
    Workflow w = null;

    /**
     * Initialize any objects needed.
     */
    @Before
    public void setUp() {
        cr = new CriminalRecord();
        pn = new PhoneNumber(1, 0);
        date = LocalDate.now();
        w = Workflow.getWorkflow();
        ac = Account.addAccount("Don Joe", "Don.Joe@gmail.com", date, 1, "Russia", "No Medical Conditions.",
                cr, 0, "50 days", "JohnDoe", "Doe123", pn,
                "No Additional Information.");
    }

    /**
     * Test to check if the Workflow object is null.
     */
    @Test
    public void testGetWorkflow() {
        // Grab multiple workflows of different accounts
        Workflow work = Workflow.getWorkflow();
        assertNotNull("Workflow is null.", work);
    }

    /**
     * Test to check if we are able to add Account id's to the Workflow system.
     */
    @Test
    public void testAddItem() {
        // Item is already added
        assertFalse("addItem() returned true", Workflow.addItem(-1));
        // New item is added
        assertTrue("addItem() returned false", Workflow.addItem(0));

        assertTrue("addItem() returned false", Workflow.addItem(5248));
    }

    /**
     * Test to check if we are able to retrieve the workflow status of an Account.
     */
    @Test
    public void testUpdateWorkflowStatus() {
        // w.updateWorkflowStatus(Status.REVIEW, 0);
        assertFalse("updateWorkflowStatus() returned false", Workflow.updateWorkflowStatus(Status.REVIEW, 0L));
        // assertTrue("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() ==
        // Status.REVIEW);
        assertFalse("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() != Status.REVIEW);

        assertFalse("updateWorkflowStatus() returned false", Workflow.updateWorkflowStatus(Status.APPROVAL, 0L));
        // assertTrue("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() ==
        // Status.REVIEW);
        assertFalse("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() != Status.APPROVAL);

        assertFalse("updateWorkflowStatus() returned false", Workflow.updateWorkflowStatus(Status.DONE, 0L));
        // assertTrue("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() ==
        // Status.REVIEW);
        assertFalse("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() != Status.DONE);
    }

    /**
     * Test to retrieve id of the account using a status.
     */
    @Test
    public void testGetItem() {
        // Cannot test with other integers becuase because Status is a private enum with
        // set input integers, this if we try to pull accounts with the workflow Status
        // of 20, we will get a compilation error.
        // Should find it
        assertEquals(0, Workflow.getItem(Status.REVIEW));
        // Should not find it
        assertEquals(-1, Workflow.getItem(Status.APPROVAL));
        // Should not find it
        assertEquals(-1, Workflow.getItem(Status.DONE));
    }
}
