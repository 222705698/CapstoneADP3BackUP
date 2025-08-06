package za.ac.cput.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User.Admin;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.payment.Payments;
import za.ac.cput.Domain.Registrations.Registration;
import za.ac.cput.Repository.*;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdminServiceTest {

    private AdminRepository adminRepository;
    private ApplicantRepository applicantRepository;
    private BookingsRepository bookingsRepository;
    private PaymentRepository paymentRepository;
    private RegistrationRepository registrationRepository;
    private AdminService adminService;

    private Admin testAdmin;

    @BeforeEach
    void setUp() {
        adminRepository = mock(AdminRepository.class);
        applicantRepository = mock(ApplicantRepository.class);
        bookingsRepository = mock(BookingsRepository.class);
        paymentRepository = mock(PaymentRepository.class);
        registrationRepository = mock(RegistrationRepository.class);

        adminService = new AdminService(adminRepository, applicantRepository, bookingsRepository, paymentRepository, registrationRepository);

        testAdmin = new Admin.Builder()
                .setUserId(1)
                .setUserName("Admin")
                .setUserSurname("Test")
                .build();
    }

    @Test
    void create() {
        when(adminRepository.save(testAdmin)).thenReturn(testAdmin);
        Admin created = adminService.create(testAdmin);
        assertNotNull(created);
        assertEquals(testAdmin.getUserId(), created.getUserId());
        verify(adminRepository).save(testAdmin);
    }

    @Test
    void read() {
        when(adminRepository.findById(1)).thenReturn(Optional.of(testAdmin));
        Admin found = adminService.read(1);
        assertNotNull(found);
        assertEquals(testAdmin.getUserId(), found.getUserId());
        verify(adminRepository).findById(1);
    }

    @Test
    void update() {
        when(adminRepository.existsById(testAdmin.getUserId())).thenReturn(true);
        when(adminRepository.save(testAdmin)).thenReturn(testAdmin);
        Admin updated = adminService.update(testAdmin);
        assertNotNull(updated);
        verify(adminRepository).existsById(testAdmin.getUserId());
        verify(adminRepository).save(testAdmin);
    }

    @Test
    void getAllAdmins() {
        when(adminRepository.findAll()).thenReturn(List.of(testAdmin));
        List<Admin> admins = adminService.getAllAdmins();
        assertFalse(admins.isEmpty());
        verify(adminRepository).findAll();
    }

    @Test
    void getAllApplicants() {
        Applicant applicant = mock(Applicant.class);
        when(applicantRepository.findAll()).thenReturn(List.of(applicant));
        adminService.getAllApplicants();
        verify(applicantRepository).findAll();
    }

    @Test
    void getBookings() {
        Bookings booking = mock(Bookings.class);
        when(bookingsRepository.findAll()).thenReturn(List.of(booking));
        adminService.getBookings();
        verify(bookingsRepository).findAll();
    }

    @Test
    void getPayments() {
        Payments payment = mock(Payments.class);
        when(paymentRepository.findAll()).thenReturn(List.of(payment));
        adminService.getPayments();
        verify(paymentRepository).findAll();
    }

    @Test
    void getRegistration() {
        Registration registration = mock(Registration.class);
        when(registrationRepository.findAll()).thenReturn(List.of(registration));
        adminService.getRegistration();
        verify(registrationRepository).findAll();
    }
}
