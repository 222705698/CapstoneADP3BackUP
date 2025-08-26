package za.ac.cput.Domain.payment;

import jakarta.persistence.*;

import java.time.LocalDate;

/*
Thando Tinto
221482210
*/

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    private String paymentMethod, paymentDetails;
    private double paymentAmount;
    private LocalDate paymentDate;

    public Payment() {
    }
    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.paymentType = builder.paymentType;
        this.paymentMethod = builder.paymentMethod;
        this.paymentDetails = builder.paymentDetails;
        this.paymentAmount = builder.paymentAmount;
        this.paymentDate = builder.paymentDate;
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

    @Override
    public String toString() {
        return "Payments{" +
                "paymentId=" + paymentId +
                ", paymentType=" + paymentType +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentDate=" + paymentDate +
                '}';
    }
    public static class Builder {
        private int paymentId;
        private PaymentType paymentType;
        private String paymentMethod;
        private String paymentDetails;
        private double paymentAmount;
        private LocalDate paymentDate;

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

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.paymentType = payment.paymentType;
            this.paymentMethod = payment.paymentMethod;
            this.paymentDetails = payment.paymentDetails;
            this.paymentAmount = payment.paymentAmount;
            this.paymentDate = payment.paymentDate;
            return this;
        }
       public Payment build() {
            return new Payment(this);
        }


    }

}
