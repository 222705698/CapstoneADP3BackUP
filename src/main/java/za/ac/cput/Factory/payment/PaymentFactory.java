package za.ac.cput.Factory.payment;

import za.ac.cput.Domain.payment.Payment;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class PaymentFactory {

    // Payment with Card.
    public static Payment createPayment(double amount, String paymentMethod, String cardName, Long cardNumber, LocalDate expirationDate, String paymentType, Short cvs){

        if(Helper.isNullOrEmpty(paymentMethod) || Helper.isAmountValid(amount) || Helper.isNullOrEmpty(cardName) || Helper.isNullOrEmpty(String.valueOf(cvs))){
            return null;
        }

        LocalDate paymentDate = LocalDate.now();

        return new Payment.Builder()
                .setPaymentAmount(amount)
                .setPaymentDate(paymentDate)
                .setPaymentMethod(Helper.getPaymentMethod(paymentMethod))
                .setPaymentType(Helper.getPaymentType(paymentType))
                .setCardName(cardName)
                .setCardNumber(cardNumber)
                .setCardDate(expirationDate)
                .setCvs(cvs)
                .build();
    }

    // Payment with Cash.
    public static Payment createPayment(double amount, String paymentMethod, String paymentType){

        if(Helper.isNullOrEmpty(paymentMethod) || Helper.isAmountValid(amount)){
            return null;
        }

        LocalDate paymentDate = LocalDate.now();

        return new Payment.Builder()
                .setPaymentAmount(amount)
                .setPaymentDate(paymentDate)
                .setPaymentMethod(Helper.getPaymentMethod(paymentMethod))
                .setPaymentType(Helper.getPaymentType(paymentType))
                .build();
    }
}
