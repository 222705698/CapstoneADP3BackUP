package za.ac.cput.Domain.bookings;

/*VehicleDisc POJO class
Author: Sibahle shange (222529571)*/

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class VehicleDisc {
    @Id
    private String discId;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public VehicleDisc() {
    }

    public VehicleDisc(Builder builder) {
        this.discId = builder.discId;
        this.issueDate = builder.issueDate;
        this.expiryDate = builder.expiryDate;

    }

    public String getDiscId() {
        return discId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "VehicleDisc{" +
                "discId='" + discId + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
    
    public static class Builder {
        private String discId;
        private LocalDate issueDate;
        private LocalDate expiryDate;

        public Builder setDiscId(String discId) {
            this.discId = discId;
            return this;
        }

        public Builder setIssueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setExpiryDate(LocalDate expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }
        public Builder copy(VehicleDisc vehicleDisc) {
            this.discId = vehicleDisc.getDiscId();
            this.issueDate = vehicleDisc.getIssueDate();
            this.expiryDate = vehicleDisc.getExpiryDate();
            return this;
        }

        public VehicleDisc build() {
            return new VehicleDisc(this);
        }
    }
}
