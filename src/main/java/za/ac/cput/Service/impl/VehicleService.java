package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Registrations.Vehicle;
import za.ac.cput.Repository.VehicleRepository;
import za.ac.cput.Service.IVehicleService;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {

    private VehicleRepository vehicleRepository;
@Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle read(Integer integer) {
        return this.vehicleRepository.findById(integer).orElse(null);


    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return this.vehicleRepository.save(vehicle);

    }

    public List<Vehicle> getVehiclesByUser(int userId) {
        return vehicleRepository.findByApplicantUserId(userId);
    }

    //    @Deprecated
//    @Override
//    public void delete(Integer integer) {
//    this.vehicleRepository.deleteById(integer);
//
//    }

    public List<Vehicle> getExpiredDiscsByUser(int userId) {
        return vehicleRepository.findExpiredDiscsByUser(userId);
    }

    @Override
    public List<Vehicle> getAll() {
        return this.vehicleRepository.findAll();
    }

}
