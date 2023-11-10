package org.openjfx;
/**
 * Class to represent the individual's phone number.
 */
public class PhoneNumber {
    // international code
    public int internationalCode;
    // main part of the phone number
    public long number;

    /**
     * Two parameter constructor which takes in the international code and phone
     * number.
     * 
     * @param internationalCode Integer - International code extention.
     * @param number Long - Main portion of the phone number.
     */
    public PhoneNumber(int internationalCode, long number) {
        this.internationalCode = internationalCode;
        this.number = number;
    }

    /**
     * Public toString() method of the individual's phone number.
     */
    @Override
    public String toString() {
        return "+" + this.internationalCode + " " + this.number;
    }
}
