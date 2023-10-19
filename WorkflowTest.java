import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
                cr, 0, 50, "JohnDoe", "Doe123", pn,
                "No Additional Information.");
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

        // fail("Not Yet Implemented!");
    }

    @Test
    public void testGetItem() {
        // Getters and setters I mean
        // fail("Not Yet Implemented!");
    }

}