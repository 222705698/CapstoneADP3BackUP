package za.ac.cput.Domain.Registrations;
 /*Vehicle POJO class
     Author: Sibahle shange (222529571)*/

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.VehicleDisc;
@Entity
public class Vehicle {
    @Id
    private int VehicleID;
    private String VehicleName;
    private String VehicleType;
    private String VehicleModel;
    private String VehicleYear;
    private String VehicleColor;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "vehicle_disc_id")
    private VehicleDisc VehicleDisc;

    public Vehicle() {
    }

    public Vehicle(Builder builder) {
        this.VehicleID = builder.VehicleID;
        this.VehicleName = builder.VehicleName;
        this.VehicleType = builder.VehicleType;
        this.VehicleModel = builder.VehicleModel;
        this.VehicleYear = builder.VehicleYear;
        this.VehicleColor = builder.VehicleColor;
        this.VehicleDisc = builder.VehicleDisc;


    }

    public int getVehicleID() {
        return VehicleID;
    }

    public String getVehicleName() {
        return VehicleName;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public String getVehicleYear() {
        return VehicleYear;
    }

    public String getVehicleColor() {
        return VehicleColor;
    }

    public VehicleDisc getVehicleDisc() {
        return VehicleDisc;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "VehicleID=" + VehicleID +
                ", VehicleName='" + VehicleName + '\'' +
                ", VehicleType='" + VehicleType + '\'' +
                ", VehicleModel='" + VehicleModel + '\'' +
                ", VehicleYear='" + VehicleYear + '\'' +
                ", VehicleColor='" + VehicleColor + '\'' +
                ", VehicleDisc=" + VehicleDisc +
                '}';
    }

    public static class Builder{
        private int VehicleID;
        private String VehicleName;
        private String VehicleType;
        private String VehicleModel;
        private String VehicleYear;
        private String VehicleColor;
        private VehicleDisc VehicleDisc;

        public Builder setVehicleID(int vehicleID) {
            VehicleID = vehicleID;
            return this;
        }

        public Builder setVehicleName(String vehicleName) {
            VehicleName = vehicleName;
            return this;
        }

        public Builder setVehicleType(String vehicleType) {
            VehicleType = vehicleType;
            return this;
        }

        public Builder setVehicleModel(String vehicleModel) {
            VehicleModel = vehicleModel;
            return this;
        }

        public Builder setVehicleYear(String vehicleYear) {
            VehicleYear = vehicleYear;
            return this;
        }

        public Builder setVehicleColor(String vehicleColor) {
            VehicleColor = vehicleColor;
            return this;
        }

        public Builder setVehicleDisc(VehicleDisc vehicleDisc) {
            VehicleDisc = vehicleDisc;
            return this;
        }

        public Builder copy(Vehicle vehicle) {
            VehicleID = vehicle.VehicleID;
            VehicleName = vehicle.VehicleName;
            VehicleType = vehicle.VehicleType;
            VehicleModel = vehicle.VehicleModel;
            VehicleYear = vehicle.VehicleYear;
            VehicleColor = vehicle.VehicleColor;
            VehicleDisc = vehicle.VehicleDisc;
            return this;
        }
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
