package org.openjfx;
/**
 * Class to represent if the individual has a criminal record.
 */
public class CriminalRecord {
    // has violations
    public Boolean hasRecord;
    // list of violations
    public String[] violations;

    /**
     * Default Constructor to represent an individual who does not have a criminal
     * record.
     */
    public CriminalRecord() {
        this.hasRecord = false;
        this.violations = null;
    }

    /**
     * 2 parameter public constructor to represent an individual who has a criminal
     * record.
     * 
     * @param hasRecord Boolean - Whether the individual has a record or not.
     * @param violations Violations - Array of violations.
     */
    public CriminalRecord(Boolean hasRecord, String[] violations) {
        this.hasRecord = hasRecord;
        this.violations = violations;
    }

    /**
     * Public toString() method depending on if the individual has a record or not.
     * 
     * @return String - Array.toString() or record or "No Criminal Record."
     */
    @Override
    public String toString() {
        if (hasRecord) {
            String spit = "Has " + violations.length + " violations:\nCommited the following: ";
            for (int i = 0; i < violations.length-1; i++) {
                spit += violations[i] + ", ";
                if (i == violations.length-2) {
                    spit += violations[i+1];
                }
            }
            return spit;
        }
        return "No Criminal Record.";
    }
}
