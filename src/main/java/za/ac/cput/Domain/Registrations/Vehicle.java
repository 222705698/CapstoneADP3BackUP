package za.ac.cput.Domain.Registrations;
 /*Vehicle POJO class
     Author: Sibahle shange (222529571)*/

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.VehicleDisc;
import za.ac.cput.Domain.payment.Ticket;

import java.util.List;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int VehicleID;
    private String VehicleName;
    private String VehicleType;
    private String VehicleModel;
    private String VehicleYear;
    private String VehicleColor;

@OneToOne //(cascade = CascadeType.ALL)
@JoinColumn(name = "vehicle_disc_id")
    private VehicleDisc VehicleDisc;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private List<Ticket> ticket;

//    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
//    private List<Ticket> ticket;
//
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
        this.ticket = builder.ticket;


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

    public List<Ticket> getTicket() {
        return ticket;
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
                ", ticket=" + ticket +
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
        private List<Ticket> ticket;

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
        public Builder setTicket(List<Ticket> ticket) {
            this.ticket = ticket;
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
            ticket = vehicle.ticket;
            return this;
        }
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
