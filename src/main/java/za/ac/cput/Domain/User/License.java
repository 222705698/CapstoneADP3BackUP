package za.ac.cput.Domain.User;

import jakarta.persistence.*;


/*Emihle Thole
  221755349
  18/05/18*/
@Entity
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int licenseId; // Changed to Long
    private String licenseCode;
    private String issueDate;
    private String expiryDate;



    public License() {
    }



    public License(Builder builder) {
        this.licenseId = builder.licenseId;
        this.licenseCode = builder.licenseCode;
        this.issueDate = builder.issueDate;
        this.expiryDate = builder.expiryDate;

    }

    public int getLicenseId() {
        return licenseId;
    }

    public String getlicenseCode() {
        return licenseCode;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }


    @Override
    public String toString() {
        return "License{" +
                "licenseId=" + licenseId +
                ", licenseCode='" + licenseCode + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }

    public static class Builder {

        private int licenseId; // Changed to Long
        private String licenseCode;
        private String issueDate;
        private String expiryDate;

                public Builder setLicenseId(int licenseId) {
            this.licenseId = licenseId;
            return this;
        }
        public Builder setlicenseCode(String licenseCode) {
            this.licenseCode = licenseCode;
            return this;
        }


        public Builder setIssueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }



        public Builder copy(License license) {
            this.licenseId = license.licenseId;
            this.licenseCode = license.licenseCode;
            this.issueDate = license.issueDate;
            this.expiryDate = license.expiryDate;

            return this;
        }

        public License build() {
            return new License(this);
        }
    }
}