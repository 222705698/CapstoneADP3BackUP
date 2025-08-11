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
                TestType.DRIVERSLICENSETEST
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
                TestType.LEARNERSLICENSETEST
        );

        TestAppointment created = restTemplate.postForEntity(
                getBaseUrl() + "/create",
                appointment,
                TestAppointment.class
        ).getBody();

        assertNotNull(created);
        assertNotNull(created.getTestAppointmentId());

        // Read
        ResponseEntity<TestAppointment> response =
                restTemplate.getForEntity(getBaseUrl() + "/read/" + created.getTestAppointmentId(), TestAppointment.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("123 Street", response.getBody().getTestAddress());
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
                TestType.DRIVERSLICENSETEST
        );

        TestAppointment created = restTemplate.postForEntity(
                getBaseUrl() + "/create",
                appointment,
                TestAppointment.class
        ).getBody();

        assertNotNull(created);

        // Update
        created = new TestAppointment.Builder()
                .copy(created)
                .setTestVenue("Updated Venue")
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TestAppointment> request = new HttpEntity<>(created, headers);

        ResponseEntity<TestAppointment> response = restTemplate.exchange(
                getBaseUrl() + "/update",
                HttpMethod.PUT,
                request,
                TestAppointment.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated Venue", response.getBody().getTestVenue());
    }

    @Test
    void testDeleteTestAppointment() {
        // Create
        TestAppointment appointment = TestAppointmentFactory.createTestAppointment(
                "789 Street",
                "Venue C",
                LocalDate.now().plusDays(2),
                true,
                "A",
                TestType.DRIVERSLICENSETEST
        );

        TestAppointment created = restTemplate.postForEntity(
                getBaseUrl() + "/create",
                appointment,
                TestAppointment.class
        ).getBody();

        assertNotNull(created); //Created

        // Delete
        restTemplate.delete(getBaseUrl() + "/delete/" + created.getTestAppointmentId());

        // Try to read
        ResponseEntity<TestAppointment> response =
                restTemplate.getForEntity(getBaseUrl() + "/read/" + created.getTestAppointmentId(), TestAppointment.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
