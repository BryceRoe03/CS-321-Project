public class PhoneNumber {
    public int internationalCode;
    public long number;

    public PhoneNumber(int internationalCode, long number) {
        this.internationalCode = internationalCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return "+" + this.internationalCode + " " + this.number;
    }
}