public enum Status {
    CREATED(1),
    REVIEW(2),
    APPROVAL(3),
    DONE(4),
    FAIL(5);

    private int status;

    private Status(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}