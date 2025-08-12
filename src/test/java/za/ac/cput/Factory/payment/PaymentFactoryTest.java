package za.ac.cput.Factory.payment;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.payment.Payment;

import static org.junit.jupiter.api.Assertions.*;


class PaymentFactoryTest {

    Payment payment = PaymentFactory.createPayment(2000,"PayPal","Payment for Ticket");

    @Test
    public void paymentNotNull(){
        assertNotNull(payment);
        System.out.println(payment);
    }

}