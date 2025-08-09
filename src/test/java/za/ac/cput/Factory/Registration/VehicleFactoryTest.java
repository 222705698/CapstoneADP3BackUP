package za.ac.cput.Factory.Registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Registrations.Vehicle;
import za.ac.cput.Domain.bookings.VehicleDisc;
import za.ac.cput.Domain.payment.Payment;
import za.ac.cput.Domain.payment.Ticket;
import za.ac.cput.Factory.bookings.VehicleDiscFactory;
import za.ac.cput.Factory.payment.PaymentFactory;
import za.ac.cput.Factory.payment.TicketFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

        VehicleDisc disc;
        List<Ticket> tickets;
        Vehicle vehicle;

        @BeforeEach
        void setup() {
            disc = VehicleDiscFactory.createVehicleDisc(LocalDate.of(2020, 8, 6), LocalDate.of(2024, 2, 6));

            Payment payment = PaymentFactory.createPayment(2000, "PayPal", "Payment for Ticket");
            Ticket ticketWithPayment = TicketFactory.createTicket(3000, "Pending", payment);

            tickets = new ArrayList<>();
            tickets.add(ticketWithPayment);

            vehicle = VehicleFactory.createvehicle(
                    "Toyota",
                    "SUV",
                    "Fortuner",
                    "2023",
                    "White",
                    disc,
                    tickets
            );
        }

        @Test
        void createVehicleTest() {
            assertNotNull(vehicle);
            System.out.println(vehicle.toString());
        }
}