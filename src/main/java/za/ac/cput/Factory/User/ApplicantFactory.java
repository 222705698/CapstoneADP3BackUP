package za.ac.cput.Factory.User;

import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.User.License;
import za.ac.cput.Domain.User.User;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Address;
import za.ac.cput.Domain.contact.Contact;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;
public class ApplicantFactory {
    public static Applicant createApplicant(String firstName, String lastName, String idNumber,
                                            Contact contact, Address address, License license,
                                            Bookings bookings, User.Role role) {

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                contact == null || address == null || license == null || bookings == null ||
                role == null) {
            return null;
        }

        LocalDate birthDate = Helper.getDateOfBirth(idNumber);

        if (!Helper.isValidEmail(contact.getEmail())) {
            return null;
        }

        return new Applicant.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setIdNumber(idNumber)
                .setBirthDate(birthDate)
                .setContact(contact)
                .setAddress(address)
                .setLicense(license)
                .setUserBooks(bookings)
                .setRole(role)
                .build();
    }
}
