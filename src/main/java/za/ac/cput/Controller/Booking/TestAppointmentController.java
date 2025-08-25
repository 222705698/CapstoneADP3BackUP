package za.ac.cput.Controller.Booking;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Factory.bookings.TestAppointmentFactory;
import za.ac.cput.Service.impl.TestAppointmentService;

import java.util.List;

@RestController
@RequestMapping("/api/test-appointments")
public class TestAppointmentController {

    private final TestAppointmentService service;

    public TestAppointmentController(TestAppointmentService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<TestAppointment> create(@RequestBody TestAppointment appointment) {
        // Factory validation
        TestAppointment created = TestAppointmentFactory.createTestAppointment(
                appointment.getTestAddress(),
                appointment.getTestVenue(),
                appointment.getTestDate(),
                appointment.getTestResult(),
                appointment.getLicenseCode(),
                appointment.getTestype()
        );

        if (created == null) {
            return ResponseEntity.badRequest().build(); // Invalid input
        }

        TestAppointment saved = service.create(created);
        return ResponseEntity.ok(saved);
    }

    // READ by ID
    @GetMapping("/read/{id}")
    public ResponseEntity<TestAppointment> read(@PathVariable Long id) {
        TestAppointment appointment = service.read(id);
        return (appointment != null) ? ResponseEntity.ok(appointment) : ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<TestAppointment> update(@RequestBody TestAppointment appointment) {
        if (appointment.getTestAppointmentId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        TestAppointment updated = service.update(appointment);
        return ResponseEntity.ok(updated);
    }
//
//    // DELETE
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    // GET ALL
    @GetMapping("/getall")
    public ResponseEntity<List<TestAppointment>> getAll() {
        List<TestAppointment> list = service.getAll();
        return ResponseEntity.ok(list);
    }
}
