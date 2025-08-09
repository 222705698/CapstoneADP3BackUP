package za.ac.cput.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Registrations.Registration;
import za.ac.cput.Domain.Registrations.Vehicle;
import za.ac.cput.Repository.RegistrationRepository;
import za.ac.cput.Service.impl.RegistrationService;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrationServiceTest {

    private RegistrationRepository registrationRepository;
    private RegistrationService registrationService;
    private Registration registration;

    @BeforeEach
    void setUp() {
        registrationRepository = mock(RegistrationRepository.class);
        registrationService = new RegistrationService(registrationRepository);

        registration = new Registration.Builder()
                .setRegistrationId(1)
                .setRegistrationNumber("REG-12345")
                .setRegistrationDate("2025-08-07")
                .setVehicle(new Vehicle())
                .build();
    }

    @Test
    void testCreate() {
        when(registrationRepository.save(registration)).thenReturn(registration);

        Registration created = registrationService.create(registration);
        assertNotNull(created);
        assertEquals("REG-12345", created.getRegistrationNumber());

        verify(registrationRepository, times(1)).save(registration);
    }

    @Test
    void testRead() {
        when(registrationRepository.findById(1)).thenReturn(Optional.of(registration));

        Registration found = registrationService.read(1);
        assertNotNull(found);
        assertEquals(1, found.getRegistrationId());

        verify(registrationRepository, times(1)).findById(1);
    }

    @Test
    void testUpdate() {
        Registration updatedRegistration = new Registration.Builder()
                .copy(registration)
                .setRegistrationNumber("REG-UPDATED")
                .build();

        when(registrationRepository.save(updatedRegistration)).thenReturn(updatedRegistration);

        System.out.println("Updated Registration: " + updatedRegistration);
        Registration updated = registrationService.update(updatedRegistration);
        assertNotNull(updated);
        assertEquals("REG-UPDATED", updated.getRegistrationNumber());

        verify(registrationRepository, times(1)).save(updatedRegistration);
    }

    @Test
    void testGetAll() {
        List<Registration> registrationList = new ArrayList<>();
        registrationList.add(registration);

        when(registrationRepository.findAll()).thenReturn(registrationList);

        List<Registration> allRegistrations = registrationService.getAll();
        assertEquals(1, allRegistrations.size());

        verify(registrationRepository, times(1)).findAll();
    }
}
