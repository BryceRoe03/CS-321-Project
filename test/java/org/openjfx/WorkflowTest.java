package org.openjfx;

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
    }

    /**
     * Test to check if the Workflow object is null.
     */
    @Test
    public void getWorkflow() {
        // Grab multiple workflows of different accounts
        assertNotNull("Workflow is null.", w);
    }

    /**
     * Test to check if we are able to add Account id's to the Workflow system.
     */
    @Test
    public void testAddItem() {
        // Item cannot be added (negative id)
        assertFalse("addItem() returned true", Workflow.addItem(-1L));
        // Item is already added
        assertFalse("addItem() returned True", Workflow.addItem(0L));
        // New item is added
        assertTrue("addItem() returned false", Workflow.addItem(5248L));
    }

    /**
     * Test to check if we are able to retrieve the workflow status of an Account.
     */
    @Test
    public void testUpdateWorkflowStatus() {
        // w.updateWorkflowStatus(Status.REVIEW, 0);
        assertTrue("updateWorkflowStatus() returned false", Workflow.updateWorkflowStatus(Status.REVIEW, 0L));
        // assertTrue("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() ==
        // Status.REVIEW);
        assertFalse("updateWorkflowStatus() worked.", ac.getAccount(0L).getStatus() != Status.REVIEW);

        assertTrue("updateWorkflowStatus() returned false", Workflow.updateWorkflowStatus(Status.APPROVAL, 0L));
        // assertTrue("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() ==
        // Status.REVIEW);
        assertFalse("updateWorkflowStatus() worked.", ac.getAccount(0L).getStatus() != Status.APPROVAL);

        assertTrue("updateWorkflowStatus() returned false", Workflow.updateWorkflowStatus(Status.DONE, 0L));
        // assertTrue("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() ==
        // Status.REVIEW);
        assertFalse("updateWorkflowStatus() worked.", ac.getAccount(0L).getStatus() != Status.DONE);
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
        w.updateWorkflowStatus(Status.DONE, 0L);
        // assertEquals("give", Account.searchAccount(0L).toString());
        assertEquals(0, w.getItemWithStatus(Status.DONE));
        // Should not find it
        assertEquals(-1, w.getItemWithStatus(Status.APPROVAL));
        // Should not find it
        assertEquals(-1, w.getItemWithStatus(Status.REVIEW));
    }
}
