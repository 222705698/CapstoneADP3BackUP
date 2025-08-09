package za.ac.cput.Service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VehicleServiceTest {

    @Autowired
    private  VehicleDiscService vehicleDiscService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private VehicleService vehicleService;


    VehicleDisc disc;
    List<Ticket> ticketList =  new ArrayList<>();
    Vehicle vehicle;
    Payment payment;

    @BeforeEach
    void setup() {
        disc = VehicleDiscFactory.createVehicleDisc(LocalDate.of(2020, 8, 6), LocalDate.of(2024, 2, 6));

        payment = PaymentFactory.createPayment(2000, "PayPal", "Payment for Ticket");

        ticketList.add(TicketFactory.createTicket(3000, "Pending", payment));

        //ticketList.add(ticketList.get(0));


    }

    @Test
    void a_create() {
        Payment createPayment = paymentService.create(payment);
        assertNotNull(createPayment);
        System.out.println(createPayment.toString());

        Ticket createTicket = ticketService.create(ticketList.get(0));
        assertNotNull(createTicket);
        System.out.println(createTicket.toString());

        VehicleDisc createDisc = vehicleDiscService.create(disc);
        assertNotNull(createDisc);
        System.out.println(createDisc.toString());

        vehicle = VehicleFactory.createvehicle(
                "Toyota",
                "SUV",
                "Fortuner",
                "2023",
                "White",
                createDisc,
                ticketList
        );
        assertNotNull(vehicle);
        Vehicle createVehicle = vehicleService.create(vehicle);
        assertNotNull(createVehicle);
        System.out.println(createVehicle.toString());


    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}