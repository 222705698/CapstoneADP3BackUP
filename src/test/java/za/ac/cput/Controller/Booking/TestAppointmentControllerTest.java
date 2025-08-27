package za.ac.cput.Controller.Booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Domain.bookings.TestType;
import za.ac.cput.Factory.bookings.TestAppointmentFactory;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestAppointmentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/test-appointments";
    }

    @Test
    void testCreateTestAppointment() {
        TestAppointment appointment = TestAppointmentFactory.createTestAppointment(
                "10 Main Road",
                "Test Venue",
                LocalDate.now().plusDays(3),
                true,
                "B",
                TestType.DRIVERSLICENSETEST,
                LocalTime.of(9, 0),
                650.00   // ✅ added amount
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TestAppointment> request = new HttpEntity<>(appointment, headers);

        ResponseEntity<TestAppointment> response =
                restTemplate.postForEntity(getBaseUrl() + "/create", request, TestAppointment.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getTestAppointmentId());
        assertEquals("10 Main Road", response.getBody().getTestAddress());
        assertEquals(650.00, response.getBody().getTestAmount()); // ✅ check amount
    }

    @Test
    void testReadTestAppointment() {
        // Create
        TestAppointment appointment = TestAppointmentFactory.createTestAppointment(
                "123 Street",
                "Venue A",
                LocalDate.now().plusDays(5),
                true,
                "C1",
                TestType.LEARNERSLICENSETEST,
                LocalTime.of(9, 0),
                500.00   // ✅ added amount
        );

        TestAppointment created = restTemplate.postForEntity(
                getBaseUrl() + "/create",
                new HttpEntity<>(appointment, new HttpHeaders()),
                TestAppointment.class
        ).getBody();

        assertNotNull(created);
        assertNotNull(created.getTestAppointmentId());

        // Read
        ResponseEntity<TestAppointment> response =
                restTemplate.getForEntity(getBaseUrl() + "/read/" + created.getTestAppointmentId(), TestAppointment.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("123 Street", response.getBody().getTestAddress());
        assertEquals(500.00, response.getBody().getTestAmount()); // ✅ check amount
    }

    @Test
    void testUpdateTestAppointment() {
        // Create
        TestAppointment appointment = TestAppointmentFactory.createTestAppointment(
                "456 Street",
                "Venue B",
                LocalDate.now().plusDays(4),
                false,
                "EB",
                TestType.DRIVERSLICENSETEST,
                LocalTime.of(9, 0),
                700.00   // ✅ added amount
        );

        TestAppointment created = restTemplate.postForEntity(
                getBaseUrl() + "/create",
                new HttpEntity<>(appointment, new HttpHeaders()),
                TestAppointment.class
        ).getBody();

        assertNotNull(created);

        // Update (change venue & amount)
        TestAppointment updated = new TestAppointment.Builder()
                .copy(created)
                .setTestVenue("Updated Venue")
                .setTestAmount(800.00)  // ✅ updating amount
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestAppointment> request = new HttpEntity<>(updated, headers);

        ResponseEntity<TestAppointment> response = restTemplate.exchange(
                getBaseUrl() + "/update",
                HttpMethod.PUT,
                request,
                TestAppointment.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Venue", response.getBody().getTestVenue());
        assertEquals(800.00, response.getBody().getTestAmount()); // ✅ check updated amount
    }

    @Test
    void testGetAllTestAppointments() {
        ResponseEntity<TestAppointment[]> response =
                restTemplate.getForEntity(getBaseUrl() + "/getall", TestAppointment[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
