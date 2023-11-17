package org.openjfx;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Workflow class object.
 */
public class Workflow {
    // Private workflow object.
    private static LinkedList<Long> q = new LinkedList<Long>();
    private static Workflow w = new Workflow();

    /**
     * Default private constructor for the Workflow object.
     */
    private Workflow() {
        /*
         * Hardcoding Account into account list which would be centralized if we were
         * doing a database
         */
        Account.testPopulateList();
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
    public static boolean updateWorkflowStatus(Status updateStatus, long idInSystem) {
        Iterator<Long> tmp = q.iterator();
        // Find node
        while (tmp.hasNext()) {
            Long id = tmp.next();
            if (id.equals(idInSystem)) {
                // Update status in AccountList
                for (Account a : Account.getAccountList()) {
                    if (a.getIdInSystem() == idInSystem) {
                        a.setStatus(updateStatus);
                    }
                }
                q.remove(id);
                q.add(id);

                /*
                 * Check work using
                 * Iterator<Long> it = q.iterator();
                 * System.out.println("\tList is: ");
                 * while (it.hasNext()) {
                 * System.out.print(it.next() + " -> ");
                 * }
                 */
                return true;
            }
        }
        /*
         * If node is not found or queue is null, return null. If node is found, update
         * node before, node after, status of current, and add to queue again.
         */
        return false;
    }

    /**
     * Public method to add a Workflow item.
     * 
     * @param idInSystem Long - Id of the corresponding in the system.
     * @return Boolean - True/False Whether the account was added to the Workflow
     *         system.
     */
    public static boolean addItem(Long idInSystem) {
        if (idInSystem >= 0 && !q.contains(idInSystem)) {
            return q.add(idInSystem);
        }
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
    public static long getItemWithStatus(Status workflowStatus) {
        Iterator<Long> it = q.iterator();

        String total = "";
        // Find node
        while (it.hasNext()) {
            Long tmp = it.next();
            if (Account.getAccount(tmp) != null) {
                // If the status is workflowStaus
                if (Account.getAccount(tmp).getStatus().equals(workflowStatus)) {
                    // q.remove(tmp);
                    // q.add(tmp);
                    return tmp;
                }
            }
        }
        System.out.println(total);
        /*
         * If node is not found or queue is null, return null. If node is found, update
         * node before, node after, status of current, and add to queue again.
         */
        return -1L;
    }
}
