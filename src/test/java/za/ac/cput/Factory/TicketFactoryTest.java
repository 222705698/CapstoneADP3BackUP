package za.ac.cput.Factory;


import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Ticket;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class TicketFactoryTest {


    Ticket tickets = TicketFactory.createTicket(3000,"Pending", null);


    @Test
    public void isTicketNull(){
        assertNotNull(tickets);
        System.out.println(tickets.toString());
    }

}