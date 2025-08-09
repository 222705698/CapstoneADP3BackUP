package za.ac.cput.Domain.payment;

//Thando Robert Tinto - 221482210

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;
    private double ticketAmount;
    private LocalDate issueDate;
    private String status;

    @ManyToOne
    @Column(name = "payment_id")
    private Payment ticketPayment;

    protected Ticket(){}

    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.ticketAmount = builder.ticketAmount;
        this.issueDate = builder.issueDate;
        this.status = builder.status;
        this.ticketPayment = builder.ticketPayment;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getStatus() {
        return status;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Payment getTicketPayment() {
        return ticketPayment;
    }

    public static class Builder {
        private int ticketId;
        private double ticketAmount;
        private LocalDate issueDate;
        private String status;
        private Payment ticketPayment;

        public Builder setIssueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setTicketAmount(double ticketAmount) {
            this.ticketAmount = ticketAmount;
            return this;
        }

        public Builder setTicketId(int ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder setTicketPayment(Payment ticketPayment) {
            this.ticketPayment = ticketPayment;
            return this;
        }

        public Builder copy(Builder builder) {
            this.ticketId = builder.ticketId;
            this.ticketAmount = builder.ticketAmount;
            this.issueDate = builder.issueDate;
            this.status = builder.status;
            this.ticketPayment = builder.ticketPayment;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }
}
