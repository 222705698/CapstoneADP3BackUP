package za.ac.cput.Factory;


import org.junit.jupiter.api.*;
import za.ac.cput.Domain.payment.Ticket;
import za.ac.cput.Factory.payment.TicketFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class TicketFactoryTest {

    Ticket tickets = TicketFactory.createTicket(3000,"Pending");

    @Test
    public void isTicketNull(){
        assertNotNull(tickets);
        System.out.println(tickets.toString());
    }

}