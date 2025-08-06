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
    public static Applicant createApplicant(String userName, String userSurname, String idNumber,
                                            Contact contact, Address address, License license,
                                            Bookings userBooks, User.Role role) {

        if (Helper.isNullOrEmpty(userName) || Helper.isNullOrEmpty(userSurname) ||
                contact == null || address == null || license == null || userBooks == null ||
                role == null) {
            return null;
        }

        LocalDate birthDate = Helper.getDateOfBirth(idNumber);

        if (!Helper.isValidEmail(contact.getEmail())) {
            return null;
        }

        return new Applicant.Builder()
                .setUserName(userName)
                .setUserSurname(userSurname)
                .setIdNumber(idNumber)
                .setBirthDate(birthDate)
                .setContact(contact)
                .setAddress(address)
                .setLicense(license)
                .setUserBooks(userBooks)
                .setRole(role)
                .build();
    }
}
