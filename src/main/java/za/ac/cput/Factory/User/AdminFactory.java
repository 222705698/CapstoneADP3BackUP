package za.ac.cput.Factory.User;

import za.ac.cput.Domain.User.Admin;
import za.ac.cput.Domain.User.User;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Contact;
import za.ac.cput.Domain.payment.Payments;
import za.ac.cput.Util.Helper;

import java.util.List;

public class AdminFactory {
    public static Admin createAdmin(String userName, String userSurname, Contact contact, Bookings userBooks, User.Role role,
                                    List<Payments> payments, Admin.Status status, String reason) {
        if (Helper.isNullOrEmpty(userName) || Helper.isNullOrEmpty(userSurname) ||
                contact == null || userBooks == null || role == null || payments == null || status == null) {
            return null;
        }

        // FIXED: Only return null if reason is empty OR contact number is invalid OR email is invalid
        if (Helper.isNullOrEmpty(reason) ||
                !Helper.isValidContactNumber(contact.getCellphone()) ||
                !Helper.isValidEmail(contact.getEmail())) {
            return null;
        }

        return new Admin.Builder()
                .setUserName(userName)
                .setUserSurname(userSurname)
                .setContact(contact)
                .setUserBooks(userBooks)
                .setRole(role)
                .setPayments(payments)
                .setStatus(status)
                .setReason(reason)
                .build();
    }
}
