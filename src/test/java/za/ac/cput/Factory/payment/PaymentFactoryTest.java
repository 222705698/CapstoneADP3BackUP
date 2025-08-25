package za.ac.cput.Factory.payment;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.payment.Payment;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class PaymentFactoryTest {

    LocalDate date =  LocalDate.now();

    Payment payment = PaymentFactory.createPayment(2000.0,"Card","Thando", 4538483625767l ,date,"Ticket", (short) 464);

    @Test
    public void paymentNotNull(){
        assertNotNull(payment);
        System.out.println(payment);
    }

}