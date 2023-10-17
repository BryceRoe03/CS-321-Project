public class PhoneNumber {
    public int internationalCode;
    public int number;

    public PhoneNumber(int internationalCode, int number) {
        this.internationalCode = internationalCode;
        this.number = number;
    }

    @Override
    public String toString() {
        return "+" + this.internationalCode + " " + this.number;
    }
}