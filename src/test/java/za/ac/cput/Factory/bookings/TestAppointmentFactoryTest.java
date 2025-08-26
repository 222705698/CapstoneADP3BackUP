package za.ac.cput.Factory.bookings;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Domain.bookings.TestType;
import za.ac.cput.Factory.bookings.TestAppointmentFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TestAppointmentFactoryTest {

    @Test
    void testCreateTestAppointment_shouldNotBeNull() {
        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                "10 Main Road",
                "Test Venue",
                LocalDate.now().plusDays(3),
                true,
                "B",
                TestType.DRIVERSLICENSETEST,
                LocalTime.of(9,0)  // Added default test time
        );
        System.out.println("Test Appointment: " + testAppointment);
        assertNotNull(testAppointment);
    }

    @Test
    void testCreateTestAppointment_valuesShouldMatch() {
        String address = "10 Main Road";
        String venue = "Test Venue";
        LocalDate date = LocalDate.now().plusDays(3);
        boolean result = true;
        String licenseCode = "10";
        TestType testType = TestType.DRIVERSLICENSETEST;
        LocalTime time = LocalTime.of(9,0);

        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                address, venue, date, result, licenseCode, testType, time
        );

        assertNotNull(testAppointment);
        assertEquals(address, testAppointment.getTestAddress());
        assertEquals(venue, testAppointment.getTestVenue());
        assertEquals(date, testAppointment.getTestDate());
        assertEquals(result, testAppointment.getTestResult());
        assertEquals(licenseCode, testAppointment.getLicenseCode());
        assertEquals(testType, testAppointment.getTestype());
        assertEquals(time, testAppointment.getTestTime());
    }

    @Test
    void testCreateTestAppointment_invalidData_shouldReturnNull() {
        // Null testType
        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                "123 Road", "Venue", LocalDate.now().plusDays(2), true, "B", null, LocalTime.of(9,0)
        );
        assertNull(testAppointment);

        // Past test date
        testAppointment = TestAppointmentFactory.createTestAppointment(
                "123 Road", "Venue", LocalDate.now().minusDays(2), true, "B", TestType.DRIVERSLICENSETEST, LocalTime.of(9,0)
        );
        assertNull(testAppointment);
    }

    @Test
    void testCreateTestAppointment_printOutput() {
        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                "123 Road", "Venue", LocalDate.now().plusDays(2), true, "B", TestType.DRIVERSLICENSETEST, LocalTime.of(9,0)
        );
        System.out.println(testAppointment);
        assertNotNull(testAppointment);
   }
}

