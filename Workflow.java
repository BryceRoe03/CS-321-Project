public class Workflow {
    private static Workflow w = new Workflow();

    private Workflow() {
    }

    public static Workflow getWorkflow() {
        return w;
    }

    public static boolean updateWorkflowStatus(Status updateStatus, int idInSystem) {
        return false;
    }

    public static boolean addItem(long idInSystem) {
        return false;
    }

    public static int getItem(Status workflowStatus) {
        // return idInSystem
        return 0;
    }
}
