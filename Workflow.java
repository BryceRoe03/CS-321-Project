public class Workflow {
    private Workflow w = null;

    private Workflow() {
        // connect to Workflow DB
        w = null;
    }

    public boolean updateWorkflowStatus(Status updateStatus, int idInSystem) {
        return false;
    }

    public boolean addItem(int idInSystem) {
        return false;
    }

    public int getItem(Status workflowStatus) {
        // idInSystem
        return 0;
    }
}
