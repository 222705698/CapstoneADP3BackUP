package za.ac.cput.Factory.bookings;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Domain.bookings.TestType;
import za.ac.cput.Domain.payment.Payment;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TestAppointmentFactoryTest {

    @Test
    void testCreateTestAppointment_shouldNotBeNull() { // updated method name
        Payment payment = new Payment();
        Applicant applicant = null; // no applicant for this test

        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                "10 Main Road",
                "Test Venue",
                LocalDate.now().plusDays(3),
                true,
                "B",
                TestType.DRIVERSLICENSETEST,
                LocalTime.of(9, 0),
                500.0,
                payment,
                applicant // added to match factory
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
        LocalTime time = LocalTime.of(9, 0);
        double amount = 750.0;
        Payment payment = new Payment();
        Applicant applicant = null;

        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                address, venue, date, result, licenseCode, testType, time, amount, payment, applicant
        );

        assertNotNull(testAppointment);
        assertEquals(address, testAppointment.getTestAddress());
        assertEquals(venue, testAppointment.getTestVenue());
        assertEquals(date, testAppointment.getTestDate());
        assertEquals(result, testAppointment.getTestResult());
        assertEquals(licenseCode, testAppointment.getLicenseCode());
        assertEquals(testType, testAppointment.getTestype());
        assertEquals(time, testAppointment.getTestTime());
        assertEquals(amount, testAppointment.getTestAmount());
        assertEquals(payment, testAppointment.getPayment());
        assertEquals(applicant, testAppointment.getApplicant());
    }

    @Test
    void testCreateTestAppointment_invalidData_shouldReturnNull() {
        Payment payment = new Payment();
        Applicant applicant = null;

        // Null testType
        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                "123 Road", "Venue", LocalDate.now().plusDays(2), true, "B", null,
                LocalTime.of(9, 0), 400.0, payment, applicant
        );
        assertNull(testAppointment);

        // Past test date
        testAppointment = TestAppointmentFactory.createTestAppointment(
                "123 Road", "Venue", LocalDate.now().minusDays(2), true, "B",
                TestType.DRIVERSLICENSETEST, LocalTime.of(9, 0), 400.0, payment, applicant
        );
        assertNull(testAppointment);

        // Negative amount
        testAppointment = TestAppointmentFactory.createTestAppointment(
                "123 Road", "Venue", LocalDate.now().plusDays(2), true, "B",
                TestType.DRIVERSLICENSETEST, LocalTime.of(9, 0), -100.0, payment, applicant
        );
        assertNull(testAppointment);
    }

    @Test
    void testCreateTestAppointment_printOutput() {
        Payment payment = new Payment();
        Applicant applicant = null;

        TestAppointment testAppointment = TestAppointmentFactory.createTestAppointment(
                "123 Road", "Venue", LocalDate.now().plusDays(2),
                true, "B", TestType.DRIVERSLICENSETEST,
                LocalTime.of(9, 0), 650.0, payment, applicant
        );

        System.out.println(testAppointment);
        assertNotNull(testAppointment);
    }
}
