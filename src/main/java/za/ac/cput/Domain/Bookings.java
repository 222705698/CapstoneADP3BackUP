package za.ac.cput.Domain;

import java.time.LocalDate;

public class Bookings {

    private int bookingId;
    private LocalDate bookingDate;
    private String bookingType;
    private Double bookingAmount;

    public Bookings() {
    }
    public Bookings (Builder builder){
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.bookingType = builder.bookingType;
        this.bookingAmount = builder.bookingAmount;

    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public Double getBookingAmount() {
        return bookingAmount;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", bookingType='" + bookingType + '\'' +
                ", bookingAmount=" + bookingAmount +
                '}';
    }

    public static class Builder{
        private int bookingId;
        private LocalDate bookingDate;
        private String bookingType;
private Double bookingAmount;

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
return this;        }

        public Builder setBookingDate(LocalDate bookingDate) {
            this.bookingDate = bookingDate;
return this;        }

        public Builder setBookingType(String bookingType) {
            this.bookingType = bookingType;
return this;        }

        public Builder setBookingAmount(Double bookingAmount) {
            this.bookingAmount = bookingAmount;
return this;        }
        public Builder copy(Bookings bookings) {
            this.bookingId = bookings.bookingId;
            this.bookingDate = bookings.bookingDate;
            this.bookingType = bookings.bookingType;
            this.bookingAmount = bookings.bookingAmount;
return this;
    
}
        public Bookings build(){
            return new Bookings(this);
        }
}}