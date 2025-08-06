package za.ac.cput.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.User.License;
import za.ac.cput.Domain.User.User;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Address;
import za.ac.cput.Domain.contact.Contact;
import za.ac.cput.Factory.User.ApplicantFactory;
import za.ac.cput.Repository.ApplicantRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApplicantServiceTest {

    private ApplicantService service;
    private ApplicantRepository repository;
    private Applicant testApplicant;

    @BeforeEach
    void setUp() {
        repository = mock(ApplicantRepository.class);
        service = new ApplicantService(repository);

        Contact contact = new Contact.Builder()
                .setEmail("applicant@email.com")
                .setCellphone("0812345678")
                .build();

        Address address = new Address.Builder()
                .setStreet("123 Main Street")
                .setCity("Cape Town")
                .setProvince("Western Cape")
                .setCountry("South Africa")
                .build();

        License license = new License.Builder()
                .setlicenseCode("Code 10")
                .setIssueDate((LocalDate.of(2015, 1, 10)))
                .setExpiryDate((LocalDate.of(2025, 1, 10)))
                .build();

        Bookings bookings = new Bookings.Builder()
                .setBookingDate(LocalDate.now())
                .build();

        testApplicant = ApplicantFactory.createApplicant(
                "Masibuve",
                "Sikhulume",
                "0001015009087",
                contact,
                address,
                license,
                bookings,
                User.Role.APPLICANT
        );
    }

    @Test
    void create() {
        when(repository.save(testApplicant)).thenReturn(testApplicant);

        Applicant created = (Applicant) service.create(testApplicant);

        System.out.println("Created: " + created);
        assertNotNull(created);
        verify(repository).save(testApplicant);
    }

    @Test
    void read() {
        when(repository.findById(testApplicant.getUserId())).thenReturn(java.util.Optional.of(testApplicant));

        Applicant found = (Applicant) service.read(testApplicant.getUserId());

        System.out.println("Found: " + found);
        assertNotNull(found);
        verify(repository).findById(testApplicant.getUserId());
    }

    @Test
    void update() {
        when(repository.save(testApplicant)).thenReturn(testApplicant);

        Applicant updated = (Applicant) service.update(testApplicant);

        System.out.println("Updated: " + updated);
        assertNotNull(updated);
        verify(repository).save(testApplicant);
    }

    @Test
    void getAll() {
        when(repository.findAll()).thenReturn(List.of(testApplicant));

        List<Applicant> list = service.getAll();

        System.out.println("All Applicants: " + list);
        assertFalse(list.isEmpty());
        verify(repository).findAll();
    }
}
