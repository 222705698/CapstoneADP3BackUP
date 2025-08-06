package za.ac.cput.Service;

import za.ac.cput.Domain.bookings.TestAppointment;

import java.util.List;

public interface ITestAppointmentService extends IService<TestAppointment, Long> {
    List<TestAppointment> findByTestId(Long testAppointmentId);
    //TestAppointment create(TestAppointment testAppointment);
    //TestAppointment read(Integer id);
    //TestAppointment update(TestAppointment testAppointment);
//    void delete(Integer id);



}
