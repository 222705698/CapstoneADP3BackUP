package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.bookings.Bookings;

import java.time.LocalDate;
import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {
    List<Bookings> findByBooktype(Bookings.Booktype type);
    //

    List<Bookings> findByBookingDate(LocalDate date);
}
