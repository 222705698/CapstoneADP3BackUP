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

    private int vehicleID;
    private String vehicleName;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleYear;
    private String vehicleColor;


@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "vehicle_disc_id")
    private VehicleDisc vehicleDisc;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Add cascade here too
    @JoinColumn(name = "vehicle_id")
    private List<Ticket> ticket;

//    @OneToMany(mappedBy = "vehicle", fetch = FetchType.EAGER)
//    private List<Ticket> ticket;
//
    public Vehicle() {
    }

    public Vehicle(Builder builder) {
        this.vehicleID = builder.vehicleID;
        this.vehicleName = builder.vehicleName;
        this.vehicleType = builder.vehicleType;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleYear = builder.vehicleYear;
        this.vehicleColor = builder.vehicleColor;
        this.vehicleDisc = builder.vehicleDisc;
        this.ticket = builder.ticket;

    }

    public int getVehicleID() {
        return vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }
    public String getVehicleYear() {
        return vehicleYear;
    }

    public VehicleDisc getVehicleDisc() {
        return vehicleDisc;
    }

    public List<Ticket> getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleYear='" + vehicleYear + '\'' +
                ", vehicleColor='" + vehicleColor + '\'' +
                ", vehicleDisc=" + vehicleDisc +
                ", ticket=" + ticket +
                '}';
    }


    public static class Builder{
        private int vehicleID;
        private String vehicleName;
        private String vehicleType;
        private String vehicleModel;
        private String vehicleYear;
        private String vehicleColor;
        private VehicleDisc vehicleDisc;
        private List<Ticket> ticket;

        public Builder setVehicleID(int vehicleID) {
            this.vehicleID = vehicleID;
            return this;
        }

        public Builder setVehicleName(String vehicleName) {
            this.vehicleName = vehicleName;
            return this;
        }

        public Builder setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Builder setVehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;
            return this;
        }

        public Builder setVehicleYear(String vehicleYear) {
            this.vehicleYear = vehicleYear;
            return this;
        }

        public Builder setVehicleColor(String vehicleColor) {
            this.vehicleColor = vehicleColor;
            return this;
        }

        public Builder setVehicleDisc(VehicleDisc vehicleDisc) {
            this.vehicleDisc = vehicleDisc;
            return this;
        }

        public Builder setTicket(List<Ticket> ticket) {
            this.ticket = ticket;
            return this;
        }

        public Builder copy(Vehicle vehicle) {
            this.vehicleID = vehicle.vehicleID;
            this.vehicleName = vehicle.vehicleName;
            this.vehicleType = vehicle.vehicleType;
            this.vehicleModel = vehicle.vehicleModel;
            this.vehicleYear = vehicle.vehicleYear;
            this.vehicleColor = vehicle.vehicleColor;
            this.vehicleDisc = vehicle.vehicleDisc;
            ticket = vehicle.ticket;
            return this;
        }
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
