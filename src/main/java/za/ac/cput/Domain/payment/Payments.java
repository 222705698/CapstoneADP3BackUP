package za.ac.cput.Domain.payment;

import jakarta.persistence.*;

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
    private Payments(Builder builder) {
        this.paymentId = builder.paymentId;
        this.paymentType = builder.paymentType;
        this.paymentMethod = builder.paymentMethod;
        this.paymentDetails = builder.paymentDetails;
        this.paymentAmount = builder.paymentAmount;
        this.paymentDate = builder.paymentDate;
        this.ticket = builder.ticket;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentId=" + paymentId +
                ", paymentType=" + paymentType +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate=" + paymentDate +
                ", ticket=" + ticket +
                '}';
    }
    public static class Builder {
        private int paymentId;
        private PaymentType paymentType;
        private String paymentMethod;
        private String paymentDetails;
        private double paymentAmount;
        private LocalDate paymentDate;
        private Ticket ticket;

        public Builder setPaymentId(int paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPaymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentDetails(String paymentDetails) {
            this.paymentDetails = paymentDetails;
            return this;
        }

        public Builder setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setTicket() {
            this.ticket = ticket;
            return this;
        }
        public Builder copy(Payments payments) {
            this.paymentId = payments.paymentId;
            this.paymentType = payments.paymentType;
            this.paymentMethod = payments.paymentMethod;
            this.paymentDetails = payments.paymentDetails;
            this.paymentAmount = payments.paymentAmount;
            this.paymentDate = payments.paymentDate;
            this.ticket = payments.ticket;
            return this;
        }
       public Payments build() {
            return new Payments(this);
        }


    }

}
