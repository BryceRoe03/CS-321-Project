package org.openjfx;
/**
 * Enum class representing Status' as an integer.
 */
public enum Status {
    // Status enums.
    CREATED(1),
    REVIEW(2),
    APPROVAL(3),
    DONE(4),
    FAIL(5);

    // Integer stored in the enum.
    private int status;

    /**
     * Status constrcutor with the corresponding integer representation of which
     * stage the account is at.
     * 
     * @param status Integer - Status of account.
     */
    private Status(int status) {
        this.status = status;
    }

    /**
     * Getter method to extract the status.
     * 
     * @return Integer - Status.
     */
    public int getStatus() {
        return status;
    }
}
