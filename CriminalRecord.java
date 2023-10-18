public class CriminalRecord {
    // has violations
    public Boolean hasRecord;
    // list of violations
    public String[] violations;

    public CriminalRecord() {
        this.hasRecord = false;
        this.violations = null;
    }

    public CriminalRecord(int amount, Boolean hasRecord, String[] violations) {
        this.hasRecord = hasRecord;
        this.violations = violations;
    }

    @Override
    public String toString() {
        if (hasRecord) {
            return "Has " + violations.length + " violations:\nCommited the following: " + violations.toString();
        }
        return "No Criminal Record.";
    }
}