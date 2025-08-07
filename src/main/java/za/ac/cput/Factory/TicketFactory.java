package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment;
import za.ac.cput.Domain.Ticket;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class TicketFactory {

    public static Ticket createTicket(double ticketAmount, String status, Payment ticketPayment) {
        if(Helper.isAmountValid(ticketAmount) || Helper.isNullOrEmpty(status)) {
            return null;
        }

        LocalDate issueDate = LocalDate.now();

        return new Ticket.Builder()
                .setTicketAmount(ticketAmount)
                .setIssueDate(issueDate)
                .setStatus(status)
                .setTicketPayment(ticketPayment)
                .build();
    }
}
