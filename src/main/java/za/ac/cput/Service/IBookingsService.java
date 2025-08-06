package za.ac.cput.Service;

import za.ac.cput.Domain.bookings.Bookings;

import java.util.List;

public interface IBookingsService extends IService<Bookings, Integer> {

    List<Bookings> findAll();
    void delete(Integer id);
}
