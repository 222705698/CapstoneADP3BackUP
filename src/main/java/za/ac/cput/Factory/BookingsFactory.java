package za.ac.cput.Factory;

import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class BookingsFactory {

public static Bookings createBookings(  LocalDate bookingDate, String bookingType, Double bookingAmount){


    int bookingId = Helper.generateUniqueId();
    if (bookingAmount == null || bookingAmount <= 0)
        return null;
    if(Helper.isNullOrEmpty(bookingType))
        return null;

    if (Helper.isDateInPast(bookingDate))
        return null;

    return new Bookings.Builder()
            .setBookingId(bookingId)
            .setBookingDate(bookingDate)
            .setBookingType(bookingType)
            .setBookingAmount(bookingAmount)
            .build();
}
}
