package za.ac.cput.Controller.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Service.impl.TestAppointmentService;

import java.util.List;

@RestController
@RequestMapping("/test-appointments")
@CrossOrigin(origins = "http://localhost:3000") //updated
public class TestAppointmentController {
    private TestAppointmentService testAppointmentService;

    @Autowired
    public TestAppointmentController(TestAppointmentService testAppointmentService) {
        this.testAppointmentService = testAppointmentService;
    }

    @PostMapping("/create")
    public TestAppointment create(@RequestBody TestAppointment testAppointment) {
        return testAppointmentService.create(testAppointment);
    }

    @GetMapping("/read/{id}")
    public TestAppointment read(@PathVariable Long id) {
        return testAppointmentService.read(id);
    }

    @PutMapping("/update")
    public TestAppointment update(@RequestBody TestAppointment testAppointment) {
        return testAppointmentService.update(testAppointment);
    }

//    @DeleteMapping("/delete/{id}")
//    public boolean delete(@PathVariable Long id) {
//        return testAppointmentService.delete(id);
//    }

    @GetMapping("/getAll")
    public List<TestAppointment> getAll() {
        return testAppointmentService.getAll();
    }
}