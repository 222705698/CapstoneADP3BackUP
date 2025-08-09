package za.ac.cput.Service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Repository.TestAppointmentRepository;
import za.ac.cput.Service.ITestAppointmentService;

import java.util.Collections;
import java.util.List;

@Service
public class TestAppointmentService implements ITestAppointmentService {

    private final TestAppointmentRepository testAppointmentRepository;

    public TestAppointmentService(TestAppointmentRepository testAppointmentRepository) {
        this.testAppointmentRepository = testAppointmentRepository;
    }

    @Override
    public TestAppointment create(TestAppointment testAppointment) {
        return testAppointmentRepository.save(testAppointment);
    }

    @Override
    public TestAppointment read(Long id) {
        return testAppointmentRepository.findById(id).orElse(null);
    }

    @Override
    public TestAppointment update(TestAppointment testAppointment) { // updates
        return testAppointmentRepository.save(testAppointment);
    }
    @Override
    public void delete(Long id) {
        testAppointmentRepository.deleteById(id);

    }
    @Override
    public List<TestAppointment> findByTestId(Long testAppointmentId) {
        return Collections.singletonList(testAppointmentRepository.findByTestId(testAppointmentId));
    }
}
