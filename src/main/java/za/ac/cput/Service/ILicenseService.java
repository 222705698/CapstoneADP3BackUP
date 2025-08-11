package za.ac.cput.Service;


import za.ac.cput.Domain.User.License;
import za.ac.cput.Domain.bookings.Bookings;

import java.util.List;

public interface ILicenseService extends IService <License, Long> {

    List<License> getall();
//    License findById(Long id);


}
