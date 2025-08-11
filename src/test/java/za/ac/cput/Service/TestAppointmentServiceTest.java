package za.ac.cput.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Service.impl.TestAppointmentService;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Domain.bookings.TestType;
import za.ac.cput.Factory.bookings.TestAppointmentFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestAppointmentServiceTest {

    @Autowired
    private TestAppointmentService service;

    @Test
    void createAndReadTestAppointment() {
        // Create a TestAppointment object using the factory
        TestAppointment appointment = TestAppointmentFactory.createTestAppointment(
                "10 Main Road",
                "Test Venue",
                LocalDate.now().plusDays(5),
                true,
                "B",
                TestType.DRIVERSLICENSETEST
        );

        assertNotNull(appointment, "Factory returned null");

        // Save to DB
        TestAppointment saved = service.create(appointment);
        assertNotNull(saved.getTestAppointmentId(), "ID should be generated after save");

        // Read from DB
        TestAppointment found = service.read(saved.getTestAppointmentId());
        assertNotNull(found, "Saved appointment should be found in DB");
        assertEquals("10 Main Road", found.getTestAddress());
    }

    @Test
    void updateTestAppointment() {
        TestAppointment appointment = TestAppointmentFactory.createTestAppointment(
                "123 Road",
                "Venue A",
                LocalDate.now().plusDays(3),
                false,
                "10",
                TestType.LEARNERSLICENSETEST
        );

        TestAppointment saved = service.create(appointment);

        // Update venue
        TestAppointment updated = new TestAppointment.Builder()
                .copy(saved)
                .setTestVenue("Updated Venue")
                .build();

        TestAppointment result = service.update(updated);
        assertEquals("Updated Venue", result.getTestVenue());
    }

    @Test
    void deleteTestAppointment() {
        TestAppointment appointment = TestAppointmentFactory.createTestAppointment(
                "456 Street",
                "Venue B",
                LocalDate.now().plusDays(4),
                true,
                "14",
                TestType.DRIVERSLICENSETEST
        );

        TestAppointment saved = service.create(appointment);
        Long id = saved.getTestAppointmentId();

        service.delete(id);
        assertNull(service.read(id), "Deleted appointment should not be found");
    }
}
