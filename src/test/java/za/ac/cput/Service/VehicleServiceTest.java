package za.ac.cput.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Registrations.Vehicle;
import za.ac.cput.Domain.bookings.VehicleDisc;
import za.ac.cput.Domain.payment.Payment;
import za.ac.cput.Domain.payment.Ticket;
import za.ac.cput.Factory.Registration.VehicleFactory;
import za.ac.cput.Factory.bookings.VehicleDiscFactory;
import za.ac.cput.Factory.payment.PaymentFactory;
import za.ac.cput.Factory.payment.TicketFactory;
import za.ac.cput.Service.impl.PaymentService;
import za.ac.cput.Service.impl.TicketService;
import za.ac.cput.Service.impl.VehicleDiscService;
import za.ac.cput.Service.impl.VehicleService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class VehicleServiceTest {

    @Autowired
    private VehicleDiscService vehicleDiscService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private VehicleService vehicleService;


    private static VehicleDisc disc;

    private static List<Ticket> ticketList ;

    private static Vehicle vehicle;
    private static Vehicle createdVehicle;

    private static Payment payment1,payment2;


    @BeforeEach
    void setup() {

            // Create Payment objects (just plain Java objects)
            Payment payment1 = PaymentFactory.createPayment(
                    2000,
                    "PayPal",
                    "Payment for Speeding Ticket"
            );

            Payment payment2 = PaymentFactory.createPayment(
                    1500,
                    "Credit Card",
                    "Payment for Parking Ticket"
            );

            // Persist Payments and replace references with saved instances (with IDs)
            Payment savedPayment1 = paymentService.create(payment1);
            Payment savedPayment2 = paymentService.create(payment2);

            // Create Tickets with persisted Payments
            Ticket ticket1 = TicketFactory.createTicket(
                    3000,
                    "Pending",
                    savedPayment1
            );

            Ticket ticket2 = TicketFactory.createTicket(
                    2500,
                    "Paid",
                    savedPayment2
            );

            // Persist Tickets and collect saved ones in list
            Ticket savedTicket1 = ticketService.create(ticket1);
            Ticket savedTicket2 = ticketService.create(ticket2);

            List<Ticket> savedTickets = new ArrayList<>();
            savedTickets.add(savedTicket1);
            savedTickets.add(savedTicket2);

            // Create and persist VehicleDisc
            disc = VehicleDiscFactory.createVehicleDisc(
                    LocalDate.of(2020, 8, 6),
                    LocalDate.of(2024, 2, 6)
            );
            VehicleDisc savedDisc = vehicleDiscService.create(disc);

            // Create Vehicle with persisted disc and tickets
            vehicle = VehicleFactory.createvehicle(
                    "Toyota",
                    "SUV",
                    "Fortuner",
                    "2023",
                    "White",
                    savedDisc,
                    savedTickets
            );

            // Persist vehicle and keep reference to persisted entity
            vehicle = vehicleService.create(vehicle);
        }



    @Test
    void a_create() {
        assertNotNull(vehicle);
        Vehicle createdVehicle = vehicleService.create(vehicle);
        assertNotNull(createdVehicle.getVehicleID());
        System.out.println("Created Vehicle: " + createdVehicle);
    }

    @Test
    void b_read() {
        Vehicle read =  vehicleService.read(vehicle.getVehicleID());
        assertNotNull(read);
        System.out.println( "Read Vehicle: "+ read);

    }

    @Test
    void c_update() {
        Vehicle NewVehicle  = new Vehicle.Builder().copy(vehicle).setVehicleColor("RED").build();
        Vehicle UpdatedVehicle = vehicleService.update(NewVehicle);
        assertNotNull(UpdatedVehicle);
        System.out.println( "Updated Vehicle: "+ UpdatedVehicle.toString());

    }

    @Test
    void d_delete() {
        vehicleService.delete(vehicle.getVehicleID());
        assertNull(vehicleService.read(vehicle.getVehicleID()));
        System.out.println("Deleted Vehicle: " + vehicle.getVehicleID());

    }

    @Test
    void e_getAll() {
        vehicleService.getAll();
        for(Vehicle vehicle : vehicleService.getAll()) {
            System.out.println(vehicle.toString());
        }
    }
}