package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.bookings.Bookings;

public interface IBookingsRepository extends JpaRepository<Bookings, Integer> {

}
