package za.ac.cput.Service;

import za.ac.cput.Domain.Registrations.Vehicle;

import java.util.List;

public interface IVehicleService extends IService <Vehicle, Integer> {
    List<Vehicle> getAll();
}
