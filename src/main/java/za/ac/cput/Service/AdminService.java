package za.ac.cput.Service;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.User.Admin;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.payment.Payments;
import za.ac.cput.Domain.Registrations.Registration;
import za.ac.cput.Repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final ApplicantRepository applicantRepository;
    private final BookingsRepository bookingsRepository;
    private final PaymentRepository paymentRepository;
    private final RegistrationRepository registrationRepository;

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

    // Create
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    // Read by id
    public Admin read(int id) {
        Optional<Admin> opt = adminRepository.findById(id);
        return opt.orElse(null);
    }

    // Update
    public Admin update(Admin admin) {
        if(adminRepository.existsById(admin.getUserId())) {
            return adminRepository.save(admin);
        }
        return null;
    }

    // Delete
    public boolean delete(int id) {
        if(adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Other methods
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public List<Bookings> getBookings() {
        return bookingsRepository.findAll();
    }

    public List<Payments> getPayments() {
        return paymentRepository.findAll();
    }

    public List<Registration> getRegistration() {
        return registrationRepository.findAll();
    }
}
