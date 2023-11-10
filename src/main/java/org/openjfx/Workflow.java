package org.openjfx;
/**
 * Workflow class object.
 */
public class Workflow {
    // Private workflow object.
    private static Workflow w = new Workflow();

    /**
     * Default private constructor for the Workflow object.
     */
    private Workflow() {
    }

    /**
     * Geter method to return the Workflow object.
     * 
     * @return Workflow - Workflow object.
     */
    public static Workflow getWorkflow() {
        return w;
    }

    /**
     * Public method to update the Workflow status of an account.
     * 
     * @param updateStatus Status - Status to update the corresponding account to.
     * @param idInSystem   Long - Id of the corresponding account in the system.
     * @return Boolean - Whether the account was updated or not.
     */
    public static boolean updateWorkflowStatus(Status updateStatus, Long idInSystem) {
        return false;
    }

    /**
     * Public method to add a Workflow item.
     * 
     * @param idInSystem Long - Id of the corresponding in the system.
     * @return Boolean - Whether the account was added to the Workflow system.
     */
    public static boolean addItem(long idInSystem) {
        return false;
    }

    /**
     * Getter method to retrieve the next Workflow item with the corresponding
     * status.
     * 
     * @param workflowStatus Status - Status of the object to retrieve.
     * @return Integer - Id of the next account to pull with the corresponding
     *         Status/-1 if failed.
     */
    public static int getItem(Status workflowStatus) {
        // return idInSystem
        return -1;
    }
}
