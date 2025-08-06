package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Repository.IBookingsRepository;

import java.util.List;

@Service
public class BookingsService implements IBookingsService{
    @Autowired
    private IBookingsRepository repository;

    @Autowired
    public BookingsService(IBookingsRepository bookingsRepository) {
        this.repository = bookingsRepository;
    }



    @Override
    public Bookings create(Bookings bookings) {
        return this.repository.save(bookings);
    }

    @Override
    public Bookings read(Integer integer) {
        return this.repository.findById(integer)
                .orElse(null);
    }

    @Override
    public Bookings update(Bookings bookings) {
        return this.repository.save(bookings);
    }



    @Override
    public List<Bookings> getall() { return this.repository.findAll(); }



//    @Override
//    public void delete(Integer id) {
//
//    }

}
