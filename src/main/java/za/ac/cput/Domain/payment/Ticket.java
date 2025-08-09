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

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    protected Ticket(){}

    private Ticket(Builder builder) {
        this.ticketId = builder.ticketId;
        this.ticketAmount = builder.ticketAmount;
        this.issueDate = builder.issueDate;
        this.status = builder.status;
        this.payment = builder.payment;
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

    public Payment getPayment() {
        return payment;
    }

    public static class Builder {
        private int ticketId;
        private double ticketAmount;
        private LocalDate issueDate;
        private String status;
        private Payment payment;

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

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder copy(Builder builder) {
            this.ticketId = builder.ticketId;
            this.ticketAmount = builder.ticketAmount;
            this.issueDate = builder.issueDate;
            this.status = builder.status;
            this.payment = builder.payment;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "issueDate=" + issueDate +
                ", ticketId=" + ticketId +
                ", ticketAmount=" + ticketAmount +
                ", status='" + status + '\'' +
                ", payment=" + payment +
                '}';
    }
}
