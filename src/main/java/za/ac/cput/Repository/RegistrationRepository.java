package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Registrations.Registration;

public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
}
