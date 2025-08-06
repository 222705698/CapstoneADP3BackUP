package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.bookings.TestAppointment;

@Repository
public interface TestAppointmentRepository extends JpaRepository<TestAppointment, Long> {
    TestAppointment findByTestId(Long testAppointmentId);




}
