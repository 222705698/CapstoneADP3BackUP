package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.bookings.TestAppointment;

public interface TestAppointmentRepository extends JpaRepository<TestAppointment, Long> {
    TestAppointment findByTestAppointmentId(Long testAppointmentId);
}

