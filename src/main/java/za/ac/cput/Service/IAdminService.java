package za.ac.cput.Service;

import za.ac.cput.Domain.User.Admin;

import java.util.List;

public interface IAdminService extends IService{
    void getAllApplicants();
    void getBookings();
    void getPayments();
    void getRegistration();
    List<Admin> getAllAdmins();
}
