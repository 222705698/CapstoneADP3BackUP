package za.ac.cput.Domain.bookings;
//Emihle Thole
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Bookings {
    @Id
    private int bookingId;
    protected Booktype booktype;
    @Enumerated(EnumType.STRING)
    private LocalDate bookingDate;


    @OneToOne
    @JoinColumn(name = "vehicle_disc_id")
    private VehicleDisc vehicleDisc;
@OneToOne
@JoinColumn(name = "test_test_id")
private  Test test;



    // Enum for user roles
    public enum Booktype {
        VEHICLE_DISC ,
        TEST
    }
    public Bookings() {
    }

}