package za.ac.cput.Factory.Registration;

import za.ac.cput.Domain.Registrations.Vehicle;
import za.ac.cput.Domain.bookings.VehicleDisc;
import za.ac.cput.Util.Helper;

import java.util.List;

public class VehicleFactory {
 public static Vehicle createvehicle (
     String vehicleName,
     String vehicleType,
     String vehicleModel,
     String vehicleYear,
     String vehicleColor,
     VehicleDisc vehicleDisc,
     List<Ticket> ticket
 ) {
    if(Helper.isNullOrEmpty(vehicleName) || Helper.isNullOrEmpty(vehicleType) || Helper.isNullOrEmpty(vehicleModel)||
    Helper.isNullOrEmpty(vehicleYear) || Helper.isNullOrEmpty(vehicleColor) || vehicleDisc == null || ticket == null
    )
        return null;
    return new Vehicle.Builder()
            .setVehicleName(vehicleName)
            .setVehicleType(vehicleType)
            .setVehicleModel(vehicleModel)
            .setVehicleYear(vehicleYear)
            .setVehicleColor(vehicleColor)
            .setVehicleDisc(vehicleDisc)
            .setTicket(ticket)
            .build();
 }
}
