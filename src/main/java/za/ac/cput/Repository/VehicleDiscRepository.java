package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.bookings.VehicleDisc;
@Repository
public interface VehicleDiscRepository extends JpaRepository<VehicleDisc, Long> {
}
