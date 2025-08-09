package za.ac.cput.Factory.payment;

import za.ac.cput.Domain.payment.Payment;
import za.ac.cput.Domain.payment.Ticket;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class TicketFactory {

    public static Ticket createTicket(double ticketAmount, String status) {
        if(Helper.isAmountValid(ticketAmount) || Helper.isNullOrEmpty(status)) {
            return null;
        }

        LocalDate issueDate = LocalDate.now();

        return new Ticket.Builder()
                .setTicketAmount(ticketAmount)
                .setIssueDate(issueDate)
                .setStatus(status)
                .build();
    }
}
