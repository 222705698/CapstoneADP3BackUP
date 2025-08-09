package za.ac.cput.Factory;


import org.junit.jupiter.api.*;
import za.ac.cput.Domain.payment.Payment;
import za.ac.cput.Domain.payment.Ticket;
import za.ac.cput.Factory.payment.PaymentFactory;
import za.ac.cput.Factory.payment.TicketFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class TicketFactoryTest {

    Ticket ticketWithoutPayment = TicketFactory.createTicket(3000,"Pending");

    //Ticket with Payment

    Payment payment = PaymentFactory.createPayment(2000,"PayPal","Payment for Ticket");

    Ticket ticketWithPayment = TicketFactory.createTicket(3000,"Pending",payment);

    @Test
    public void isTicketWithoutPaymentNull(){
        assertNotNull(ticketWithoutPayment);
        System.out.println(ticketWithPayment.toString());
    }

    @Test
    public void isTicketWithPaymentNull(){
        assertNotNull(ticketWithPayment);
        System.out.println(ticketWithPayment.toString());
    }

}