package za.ac.cput.Domain.payment;

//Thando Robert Tinto - 221482210

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private String paymentMethod;
    private double paymentAmount;
    private String paymentDetails;
    private LocalDate paymentDate;

    protected Payment(){}

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.paymentMethod = builder.paymentMethod;
        this.paymentAmount = builder.paymentAmount;
        this.paymentDetails = builder.paymentDetails;
        this.paymentDate = builder.paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public static class Builder {
        private int paymentId;
        private String paymentMethod;
        private double paymentAmount;
        private String paymentDetails;
        private LocalDate paymentDate;

        public Builder setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentDetails(String paymentDetails) {
            this.paymentDetails = paymentDetails;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder copy(Builder builder){
            this.paymentId = builder.paymentId;
            this.paymentMethod = builder.paymentMethod;
            this.paymentAmount = builder.paymentAmount;
            this.paymentDetails = builder.paymentDetails;
            this.paymentDate = builder.paymentDate;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
