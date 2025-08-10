package za.ac.cput.Controller.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Registrations.Vehicle;
import za.ac.cput.Service.impl.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @PostMapping("/create")
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleService.create(vehicle);
    }

    @GetMapping("/read/{VehicleID}")
    public Vehicle read(@PathVariable int VehicleID) {
        return vehicleService.read(VehicleID);
    }

    @PutMapping("/update")
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return vehicleService.update(vehicle);
    }

    @DeleteMapping("/delete/{VehicleID}")
    public void delete(@PathVariable int VehicleID) {
        vehicleService.delete(VehicleID);
    }
    @GetMapping("/getAll")
    public List<Vehicle> getAll() {
        return vehicleService.getAll();
    }
}
