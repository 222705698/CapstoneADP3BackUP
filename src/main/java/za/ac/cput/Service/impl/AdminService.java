package za.ac.cput.Service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.User.Admin;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Domain.bookings.VehicleDisc;
import za.ac.cput.Domain.payment.Payment;
import za.ac.cput.Domain.payment.Ticket;
import za.ac.cput.Domain.Registrations.Registration;
import za.ac.cput.Repository.*;
import za.ac.cput.Service.IAdminService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {

    private final AdminRepository adminRepository;
    private final ApplicantRepository applicantRepository;
    private final BookingsRepository bookingsRepository;
    private final PaymentRepository paymentRepository;
    private final RegistrationRepository registrationRepository;
    private final TestAppointmentRepository testAppointmentRepository;
    private final VehicleDiscRepository vehicleDiscRepository;
    private final TicketRepository ticketRepository;

    public AdminService(AdminRepository adminRepository,
                        ApplicantRepository applicantRepository,
                        BookingsRepository bookingsRepository,
                        PaymentRepository paymentRepository,
                        RegistrationRepository registrationRepository,
                        TestAppointmentRepository testAppointmentRepository,
                        VehicleDiscRepository vehicleDiscRepository,
                        TicketRepository ticketRepository) {
        this.adminRepository = adminRepository;
        this.applicantRepository = applicantRepository;
        this.bookingsRepository = bookingsRepository;
        this.paymentRepository = paymentRepository;
        this.registrationRepository = registrationRepository;
        this.testAppointmentRepository = testAppointmentRepository;
        this.vehicleDiscRepository = vehicleDiscRepository;
        this.ticketRepository = ticketRepository;
    }

    // Create
    @Override
    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    // Read
    @Override
    public Admin read(Integer id) {
        Optional<Admin> opt = adminRepository.findById(id);
        return opt.orElse(null);
    }

    // Update
    @Override
    public Admin update(Admin admin) {
        if (adminRepository.existsById(admin.getUserId())) {
            return adminRepository.save(admin);
        }
        return null;
    }

    // Delete
    @Override
    public boolean delete(Integer id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }


    // Other methods
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @Override
    public List<Bookings> getBookings() {
        return bookingsRepository.findAll();
    }

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Registration> getRegistration() {
        return registrationRepository.findAll();
    }

    @Override
    public List<TestAppointment> getTestAppointments() {
        return testAppointmentRepository.findAll();
    }

    @Override
    public List<VehicleDisc> getVehicleDiscs() {
        return vehicleDiscRepository.findAll();
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }
}
