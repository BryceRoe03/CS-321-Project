public class CriminalRecord {
    // number of violations
    public int amount;
    public Boolean hasRecord;
    // list of violations
    public String[] violations;

    public CriminalRecord(int amount, Boolean hasRecord, String[] violations) {
        this.amount = amount;
        this.hasRecord = hasRecord;
        this.violations = violations;
    }

    @Override
    public String toString() {
        if (hasRecord) {
            return "Has " + amount + " violations:\nCommited the following: " + violations.toString();
        }
        return "No Criminal Record.";
    }
}