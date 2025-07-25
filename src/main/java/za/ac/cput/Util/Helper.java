package za.ac.cput.Util;

import org.apache.commons.validator.routines.EmailValidator;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Helper {

    // Validate if a string is null or empty
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // Validate if an ID number is valid (example: must be 13 digits)
    public static boolean isValidIdNumber(Long idNumber) {
        return idNumber != null && String.valueOf(idNumber).length() == 13;
    }

    // Validate if a date is in the past
    public static boolean isDateInPast(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }
    // Validate if a date is in the future
    private static final AtomicInteger idCounter = new AtomicInteger(1000); // Start from 1000
    public static int generateUniqueId() {
        return idCounter.getAndIncrement();
    }
    // Validate email using Apache Commons Validator
    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    // Extract date of birth from South African ID number
    public static LocalDate getDateOfBirth(String identityNumber) {
        if (identityNumber == null || identityNumber.length() != 13) {
            throw new IllegalArgumentException("Invalid Identity Number");
        }

        int year = Integer.parseInt(identityNumber.substring(0, 2));
        int month = Integer.parseInt(identityNumber.substring(2, 4));
        int day = Integer.parseInt(identityNumber.substring(4, 6));

        // Determine century (assume IDs are for 1900s or 2000s)
        year += (year <= LocalDate.now().getYear() % 100) ? 2000 : 1900;

        return LocalDate.of(year, month, day);
    }

    // Validate contact number
    public static boolean isValidContactNumber(String contactNumber) {
        if (contactNumber == null || contactNumber.length() != 10) {
            return false;
        }
        // Check if it starts with '0' and contains only digits
        return contactNumber.startsWith("0") && contactNumber.matches("\\d+");
    }

    // Validate postal code
    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode == null || postalCode.length() != 4) {
            return false;
        }
        return postalCode.matches("\\d+");
    }
}