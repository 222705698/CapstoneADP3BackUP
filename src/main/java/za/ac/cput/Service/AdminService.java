package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.User.Admin;
import za.ac.cput.Domain.Registrations.Registration;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.payment.Payments;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;
    private final ApplicantRepository applicantRepository;
    private final BookingsRepository bookingsRepository;
    private final PaymentRepository paymentRepository;
    private final RegistrationRepository registrationRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository,
                        ApplicantRepository applicantRepository,
                        BookingsRepository bookingsRepository,
                        PaymentRepository paymentRepository,
                        RegistrationRepository registrationRepository) {
        this.adminRepository = adminRepository;
        this.applicantRepository = applicantRepository;
        this.bookingsRepository = bookingsRepository;
        this.paymentRepository = paymentRepository;
        this.registrationRepository = registrationRepository;
    }

    // === CRUD Methods ===

    @Override
    public Admin create(Object o) {
        if (o instanceof Admin admin) {
            return adminRepository.save(admin);
        }
        return null;
    }

    @Override
    public Admin read(Object id) {
        if (id instanceof Integer adminId) {
            Optional<Admin> admin = adminRepository.findById(adminId);
            return admin.orElse(null);
        }
        return null;
    }

    @Override
    public Admin update(Object o) {
        if (o instanceof Admin admin && adminRepository.existsById(admin.getUserId())) {
            return adminRepository.save(admin);
        }
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // === Custom Admin Functions ===

    @Override
    public void getAllApplicants() {
        List<Applicant> applicants = applicantRepository.findAll();
        applicants.forEach(System.out::println);
    }

    @Override
    public void getBookings() {
        List<Bookings> bookings = bookingsRepository.findAll();
        bookings.forEach(System.out::println);
    }

    @Override
    public void getPayments() {
        List<Payments> payments = paymentRepository.findAll();
        payments.forEach(System.out::println);
    }

    @Override
    public void getRegistration() {
        List<Registration> registrations = registrationRepository.findAll();
        registrations.forEach(System.out::println);
    }
}
