import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class WorkflowTest {
    Account ac = null;
    CriminalRecord cr = null;
    PhoneNumber pn = null;
    LocalDate date = null;
    Workflow w = null;

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

    @Test
    public void getWorkflow() {
        // Workflow should not be null
        assertNotNull("Workflow is null.", w);
    }

    @Test
    public void testUpdateWorkflowStatus() {
        // w.updateWorkflowStatus(Status.REVIEW, 0);
        assertFalse("updateWorkflowStatus() returned false", w.updateWorkflowStatus(Status.REVIEW, 0));
        // assertTrue("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() ==
        // Status.REVIEW);
        assertFalse("updateWorkflowStatus() worked.", ac.getAccount(0).getStatus() != Status.REVIEW);
    }

    @Test
    public void testAddItem() {
        // Item is already added
        assertFalse("addItem() returned true", w.addItem(-1));
        // New item is added
        assertTrue("addItem() returned false", w.addItem(0));
    }

    @Test
    public void testGetItem() {
        // Should find it
        assertEquals(-1, w.getItem(-1));
        // Should not find it
        assertEquals(0, w.getItem(200));
    }

}