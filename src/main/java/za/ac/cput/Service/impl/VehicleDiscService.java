package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.bookings.VehicleDisc;
import za.ac.cput.Repository.VehicleDiscRepository;
import za.ac.cput.Service.IVehicleDiscService;

import java.util.List;
@Service
public class VehicleDiscService implements IVehicleDiscService {
   private VehicleDiscRepository repository;
@Autowired
    public VehicleDiscService(VehicleDiscRepository repository) {
        this.repository = repository;
    }

    @Override
    public VehicleDisc create(VehicleDisc vehicleDisc) {
        return this.repository.save(vehicleDisc);
    }

    @Override
    public VehicleDisc read(Integer integer) {
        return this.repository.findById(integer).orElse(null);
    }

    @Override
    public VehicleDisc update(VehicleDisc vehicleDisc) {
        return this.repository.save(vehicleDisc);
    }

    @Override
    public void delete(Integer integer) {
    this.repository.deleteById(integer);

    }

    @Override
    public List<VehicleDisc> getAll() {
        return this.repository.findAll();
    }
}
