package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.User.Admin;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.payment.Payment;
import za.ac.cput.Domain.Registrations.Registration;
import za.ac.cput.Service.impl.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<Admin> create(@RequestBody Admin admin) {
        Admin created = adminService.create(admin);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Admin> read(@PathVariable Integer id) {
        Admin admin = adminService.read(id);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("/update")
    public ResponseEntity<Admin> update(@RequestBody Admin admin) {
        Admin updated = adminService.update(admin);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = adminService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @GetMapping("/applicants")
    public ResponseEntity<List<Applicant>> getAllApplicants() {
        return ResponseEntity.ok(adminService.getAllApplicants());
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<Bookings>> getBookings() {
        return ResponseEntity.ok(adminService.getBookings());
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getPayments() {
        return ResponseEntity.ok(adminService.getPayments());
    }

    @GetMapping("/registrations")
    public ResponseEntity<List<Registration>> getRegistrations() {
        return ResponseEntity.ok(adminService.getRegistration());
    }
}
