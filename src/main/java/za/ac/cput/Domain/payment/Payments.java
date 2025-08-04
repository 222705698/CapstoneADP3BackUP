package za.ac.cput.Domain.payment;

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.Bookings;

import java.time.LocalDate;

/*
Thando Tinto
221482210
*/

@Entity
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private String paymentMethod, paymentDetails;
    private double paymentAmount;
    private LocalDate paymentDate;

    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    public Payments() {
    }

}
