package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class PaymentFactory {
    public static Payment createPayment(double amount, String paymentMethod,String paymentDetails){

        if(Helper.isNullOrEmpty(paymentDetails) || Helper.isNullOrEmpty(paymentMethod) || Helper.isAmountValid(amount)){
            return null;
        }

        LocalDate paymentDate = LocalDate.now();

        return new Payment.Builder()
                .setPaymentAmount(amount)
                .setPaymentDate(paymentDate)
                .setPaymentMethod(paymentMethod)
                .setPaymentDetails(paymentDetails)
                .build();
    }
}
