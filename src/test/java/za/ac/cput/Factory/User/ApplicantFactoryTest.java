package za.ac.cput.Factory.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.User.License;
import za.ac.cput.Domain.User.User;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Address;
import za.ac.cput.Domain.contact.Contact;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicantFactoryTest {

    private Contact contact;
    private Address address;
    private License license;
    private Bookings bookings;

    @BeforeEach
    public void setUp() {
        contact = new Contact.Builder()
                .setEmail("applicant@email.com")
                .setCellphone("0812345678")
                .build();

        address = new Address.Builder()
                .setStreet("123 Main Street")
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setCountry("South Africa")
                .build();

        license = new License.Builder()
                .setlicenseCode("Code 10")
                .setIssueDate((LocalDate.of(2015, 1, 10)))
                .setExpiryDate((LocalDate.of(2025, 1, 10)))
                .build();

        bookings = new Bookings.Builder()
                .setBookingDate(LocalDate.now())
                .build();
    }

    @Test
    public void testCreateValidApplicant() {
        Applicant applicant = ApplicantFactory.createApplicant(
                "Masibuve",
                "Sikhulume",
                "0001015009087",
                contact,
                address,
                license,
                bookings,
                User.Role.APPLICANT
        );

        System.out.println(applicant); // prints the object result
        assertNotNull(applicant);
    }

    @Test
    public void testCreateApplicantWithInvalidEmail() {
        Contact badContact = new Contact.Builder()
                .setEmail("invalid-email")
                .setCellphone("0812345678")
                .build();

        Applicant applicant = ApplicantFactory.createApplicant(
                "Test",
                "User",
                "0001015009087",
                badContact,
                address,
                license,
                bookings,
                User.Role.APPLICANT
        );

        System.out.println(applicant); // prints null
        assertNull(applicant);
    }

    @Test
    public void testCreateApplicantWithMissingName() {
        Applicant applicant = ApplicantFactory.createApplicant(
                "",  // missing name
                "Sikhulume",
                "0001015009087",
                contact,
                address,
                license,
                bookings,
                User.Role.APPLICANT
        );

        System.out.println(applicant); // prints null
        assertNull(applicant);
    }
}
